package com.ysdevelop.shop.service;

import java.util.List;

import com.ysdevelop.shop.entity.OrderItem;

public interface OrderItemService {
	void addBatchOrderItem(List<OrderItem> orderItems);

	List<OrderItem> listByOrderId(String id);
}
