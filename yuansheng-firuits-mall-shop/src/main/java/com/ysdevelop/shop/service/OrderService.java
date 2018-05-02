package com.ysdevelop.shop.service;

import java.util.List;

import com.ysdevelop.shop.entity.Member;
import com.ysdevelop.shop.entity.Order;

public interface OrderService {
	Long add(Member loginMember, List<Long> ids);

	Order getOrderById(Long orderId);

	void changeAddress(Order order, Boolean defaultAddress, Member loginMember);
}
