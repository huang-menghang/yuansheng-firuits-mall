package com.ysdevelop.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.shop.entity.Order;

public interface OrderDao {
	void add(Order order);

	Order getOrderById(Long orderId);

	void updateAddress(Order order);

	Integer countByMemberIdAndStatus(@Param(value="memberId")Long memberId, @Param(value="orderStatus")Integer orderStatus);

	List<Order> listByStatusAndMemberId(@Param(value="memberId")Long memberId, @Param(value="orderStatus")Integer orderStatus, @Param(value="pagination")Pagination<Order> pagination);

	void updateStatusByOrderId(@Param(value="orderId")String orderId, @Param(value="status")Integer status);
}
