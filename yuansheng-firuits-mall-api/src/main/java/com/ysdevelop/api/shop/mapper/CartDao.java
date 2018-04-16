package com.ysdevelop.api.shop.mapper;

import com.ysdevelop.api.entity.Cart;

public interface CartDao {
	void save(Cart cart);

	Cart getByMemberId(Long memberId);
}
