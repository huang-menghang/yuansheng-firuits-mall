package com.ysdevelop.shop.service;

import java.util.List;

import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.shop.entity.Member;
import com.ysdevelop.shop.entity.Order;

public interface OrderService {
	String add(Member loginMember, List<Long> ids);

	Order getOrderById(Long orderId);

	void changeAddress(Order order, Boolean defaultAddress, Member loginMember);

	void pagination(Integer orderStatus, Long memberId, Pagination<Order> pagination);

	void updateStatusById(String orderId, Integer status);
}
