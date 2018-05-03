package com.ysdevelop.shop.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.NumberArithmeticUtils;
import com.ysdevelop.common.utils.OrderNumberGeneratorUtil;
import com.ysdevelop.common.utils.Constant.OrderType;
import com.ysdevelop.shop.entity.CartItem;
import com.ysdevelop.shop.entity.Member;
import com.ysdevelop.shop.entity.Order;
import com.ysdevelop.shop.entity.OrderItem;
import com.ysdevelop.shop.mapper.OrderDao;
import com.ysdevelop.shop.service.CartItemService;
import com.ysdevelop.shop.service.MemberService;
import com.ysdevelop.shop.service.OrderItemService;
import com.ysdevelop.shop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private OrderItemService orderItemService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private OrderDao orderDao;

	@Transactional
	@Override
	public String add(Member loginMember, List<Long> ids) {
		// 第一步把CartItem 选中找出来,把这个状态改成已经清空
		if (ids == null || ids.size() == 0) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}

		List<CartItem> cartItems = cartItemService.clearCartItem(ids);

		// 根据这些CartItem 生成OrderItem
		if (cartItems == null || cartItems.size() == 0) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		List<OrderItem> orderItems = new ArrayList<>();
		CartItem cartItem = null;
		String orderId = ""+OrderNumberGeneratorUtil.get();
		for (int i = 0; i < cartItems.size(); i++) {
			cartItem = cartItems.get(i);
			if (cartItem != null) {
				OrderItem item = new OrderItem();
				item.setGoodsName(cartItem.getGoodsName());
				System.out.println("goodsName " + cartItem.getGoodsName());
				item.setGoodsId(cartItem.getGoodsId());
				item.setGoodsCount(cartItem.getGoodsCount());
				item.setGoodsPrice(cartItem.getGoodsPrice());
				item.setGoodsTotalPrice(cartItem.getGoodsTotalPrice());
				item.setOrderId(orderId);
				orderItems.add(item);
			}
		}
		// 将订单条目添加到订单条目表中
		Order order = new Order();
		order.setMemberId(loginMember.getId());
		order.setId(orderId);
		order.setMemberProvince(loginMember.getProvince());
		order.setMemberCity(loginMember.getCity());
		order.setMemberDist(loginMember.getTown());
		order.setOrderDetailAddress(loginMember.getDetailAddress());
		order.setMemberMobile(loginMember.getMobile());
		order.setMemberPhone(loginMember.getTelephone());
		order.setOrderStatus(OrderType.UNPAY.getValue());
		generateOrder(order, orderItems);
		orderDao.add(order);
		orderItemService.addBatchOrderItem(orderItems);
		System.out.println("订单"+orderId);
		System.out.println("订单:"+order.getId());
		return order.getId();
	}

	private void generateOrder(Order order, List<OrderItem> orderItems) {
		// 总的价格
		BigDecimal totalPrice = new BigDecimal(0);
		BigDecimal itemPrice = null;
		// 总的商品数
		Integer totalItemNo = 0;
		// 总的订单条目数
		Integer totalItemCount = 0;
		for (OrderItem item : orderItems) {
			totalItemCount++;
			totalItemNo = totalItemNo + item.getGoodsCount();
			itemPrice = new BigDecimal(item.getGoodsTotalPrice());
			totalPrice = NumberArithmeticUtils.safeAdd(totalPrice, itemPrice);
		}
		order.setTotalItemCount(totalItemCount);
		order.setTotalItemNo(totalItemNo);
		order.setOrderTotalPrice(totalPrice.doubleValue());
		logger.info("order detail " + order.getOrderTotalPrice());

	}

	@Override
	public Order getOrderById(Long orderId) {
		if (orderId == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Order order = orderDao.getOrderById(orderId);
		return order;
	}

	@Transactional
	@Override
	public void changeAddress(Order order, Boolean defaultAddress, Member loginMember) {
		if (order == null || loginMember == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		orderDao.updateAddress(order);
		if (defaultAddress) {
			Member member = new Member();
			member.setProvince(order.getMemberProvince());
			member.setCity(order.getMemberCity());
			member.setTown(order.getMemberDist());
			member.setDetailAddress(order.getOrderDetailAddress());
			member.setMobile(order.getMemberMobile());
			member.setTelephone(order.getMemberPhone());
			member.setId(loginMember.getId());
			memberService.updateAddressById(member, loginMember);
			loginMember.setProvince(member.getProvince());
			loginMember.setCity(member.getCity());
			loginMember.setTown(member.getTown());
			loginMember.setDetailAddress(member.getDetailAddress());
		}

	}

	// 根据我们的订单状态进行查询
	@Override
	public void pagination(Integer orderStatus, Long memberId, Pagination<Order> pagination) {
		// 先查出所有的订单,再根据订单的id去找查找它的订单条目
		if (orderStatus == null || memberId == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}

		Integer orderCount = orderDao.countByMemberIdAndStatus(memberId, orderStatus);
		pagination.setTotalItemsCount(orderCount);
		List<Order> orders = orderDao.listByStatusAndMemberId(memberId, orderStatus, pagination);
		for (Order order : orders) {
			List<OrderItem> orderItems = orderItemService.listByOrderId(order.getId());
			order.setOrderItems(orderItems);
		}
		pagination.setItems(orders);

	}

}
