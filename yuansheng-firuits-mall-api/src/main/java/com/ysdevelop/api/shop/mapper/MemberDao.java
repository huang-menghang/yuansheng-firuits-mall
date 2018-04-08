package com.ysdevelop.api.shop.mapper;



import com.ysdevelop.api.entity.Member;

public interface MemberDao {
	void save(Member member);
	
	int countByMobile(String mobile);
}
