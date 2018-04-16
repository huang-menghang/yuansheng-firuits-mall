package com.ysdevelop.api.shop.service;

import java.util.List;

import com.ysdevelop.api.entity.CartItem;

public interface CartItemService {
	void save(Long cartId, Long goodsId);

	List<CartItem> listByCartId(Long cartId);
}
