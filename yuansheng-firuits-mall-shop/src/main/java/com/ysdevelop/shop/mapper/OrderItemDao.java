package com.ysdevelop.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.shop.entity.OrderItem;

public interface OrderItemDao {
	void batchAddOrderItem(@Param(value = "orderItems") List<OrderItem> orderItems);
}
