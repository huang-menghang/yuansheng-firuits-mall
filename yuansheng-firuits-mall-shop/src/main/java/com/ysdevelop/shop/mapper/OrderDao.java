package com.ysdevelop.shop.mapper;

import com.ysdevelop.shop.entity.Order;

public interface OrderDao {
	void add(Order order);

	Order getOrderById(Long orderId);

	void updateAddress(Order order);
}
