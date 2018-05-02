package com.ysdevelop.shop.service;

import java.util.List;

import com.ysdevelop.shop.entity.CartItem;

public interface CartItemService {
	void save(Long cartId, Long goodsId);

	List<CartItem> listByCartId(Long cartId);
	
	void updateStatusById(Long id);

	void updateItemBatch(List<CartItem> items);

	List<CartItem> clearCartItem(List<Long> ids);
	
	
}