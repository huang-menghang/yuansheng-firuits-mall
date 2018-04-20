package com.ysdevelop.shop.mapper;

import com.ysdevelop.shop.entity.Cart;

public interface CartDao {
	void save(Cart cart);

	Cart getByMemberId(Long memberId);

	Integer countGoodsById(Long id);
}