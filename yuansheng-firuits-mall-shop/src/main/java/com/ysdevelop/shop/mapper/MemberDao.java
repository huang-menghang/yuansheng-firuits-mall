package com.ysdevelop.shop.mapper;

import com.ysdevelop.shop.entity.Member;


public interface MemberDao {
	void save(Member member);

	int countByMobile(String mobile);

	Member getByMobile(String mobile);
}
