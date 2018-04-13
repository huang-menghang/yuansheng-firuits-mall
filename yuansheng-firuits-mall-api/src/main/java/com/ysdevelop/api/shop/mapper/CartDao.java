package com.ysdevelop.api.shop.mapper;

import com.ysdevelop.api.entity.Cart;

public interface CartDao {
	void save(Long memberId);

	Cart getByMemberId(Long memberId);
}
