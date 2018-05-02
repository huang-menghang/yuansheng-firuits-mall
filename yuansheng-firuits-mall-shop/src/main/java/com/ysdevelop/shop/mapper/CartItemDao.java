package com.ysdevelop.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.shop.entity.CartItem;



public interface CartItemDao {

	void save(CartItem cartItem);

	CartItem getByCartId(@Param(value = "cartId") Long cartId, @Param(value = "goodsId") Long goodsId);

	void updateCartItemGoodsCount(CartItem cartItem);

	List<CartItem> listByCartId(Long cartId);
	
	void updateStatusById(Long id);

	void updateBatchByList(@Param(value="items")List<CartItem> items);

	List<CartItem> listByIds(@Param(value="ids")List<Long> ids);
	
	void updateStatusBatchByIds(@Param(value="ids")List<Long> ids);
}