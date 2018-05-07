package com.ysdevelop.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.Constant;
import com.ysdevelop.common.utils.JSONHelper;
import com.ysdevelop.shop.annotation.IgnoreAuth;
import com.ysdevelop.shop.annotation.LoginUser;
import com.ysdevelop.shop.entity.Member;
import com.ysdevelop.shop.entity.Order;
import com.ysdevelop.shop.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/newAddress", method = RequestMethod.GET)
	public String newAddress(@LoginUser Member loginMember) {
		return "order/new-address";
	}

	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public String confirm(@LoginUser Member loginMember) {
		return "order/confirm";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> add(@RequestParam(value = "ids[]") List<Long> ids, @LoginUser Member loginMember) {
		String orderId = orderService.add(loginMember, ids);
		System.out.println("返回orderId" + orderId);
		return Result.successData(orderId);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Result<Order> info(@PathVariable(value = "id") Long orderId, @LoginUser Member loginMember) {
		Order order = orderService.getOrderById(orderId);
		System.out.println(loginMember);
		System.out.println(loginMember.getName());
		System.out.println(order);
		order.setMemberName(loginMember.getName());
		return Result.successData(order);
	}

	@RequestMapping(value = "/changeAddress", method = RequestMethod.PUT)
	@ResponseBody
	public Result<String> changeAddress(@Validated Order order, Boolean defaultAddress, @LoginUser Member loginMember, HttpSession session,
			@CookieValue(value = "token") String token) {
		orderService.changeAddress(order, defaultAddress, loginMember);
		if (defaultAddress) {
			session.setAttribute(token, loginMember);
		}
		return Result.success("修改成功");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@LoginUser Member loginMember) {
		return "order/order-list";
	}

	@RequestMapping(value = "/list/query", method = RequestMethod.GET)
	@ResponseBody
	public Result<String> doList(Integer orderStatus, Pagination<Order> pagination, @LoginUser Member loginMember) {
		pagination.setPageSize(3);
		orderService.pagination(orderStatus, loginMember.getId(), pagination);
		for (Order order : pagination.getItems()) {
			System.out.println(order.getId());
		}

		return Result.successData(JSONHelper.bean2json(pagination));
	}
	
    @IgnoreAuth
	@RequestMapping(value = "/returnState", method = RequestMethod.GET)
	public String returnState(HttpServletRequest request,ModelMap map) {
    	String orderId = request.getParameter("out_trade_no");
    	String orderTotalPrice = request.getParameter("total_amount");
    	String timestamp = request.getParameter("timestamp");
    	map.addAttribute("orderId", orderId);
    	map.addAttribute("orderTotalPrice", orderTotalPrice);
    	map.addAttribute("orderDate", timestamp);
    	
    	orderService.updateStatusById(orderId,Constant.OrderType.PAY.getValue() );
    	System.out.println(orderId+" "+orderTotalPrice+" "+timestamp);
		return "order/return-state";
	}

}
