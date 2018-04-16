package com.ysdevelop.api.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.api.entity.CartItem;

public interface CartItemDao {

	void save(CartItem cartItem);

	CartItem getByCartId(@Param(value = "cartId") Long cartId, @Param(value = "goodsId") Long goodsId);

	void updateCartItemGoodsCount(CartItem cartItem);

	List<CartItem> listByCartId(Long cartId);
	
}
