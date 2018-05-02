package com.ysdevelop.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.shop.entity.OrderItem;
import com.ysdevelop.shop.mapper.OrderItemDao;
import com.ysdevelop.shop.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Autowired
	private OrderItemDao itemDao;

	@Override
	public void addBatchOrderItem(List<OrderItem> orderItems) {
		if (orderItems == null || orderItems.size() == 0) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		itemDao.batchAddOrderItem(orderItems);

	}

}
