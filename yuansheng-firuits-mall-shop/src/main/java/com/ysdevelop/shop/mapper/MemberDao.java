package com.ysdevelop.shop.mapper;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.shop.entity.Member;


public interface MemberDao {
	void save(Member member);

	int countByMobile(String mobile);

	Member getByMobile(String mobile);

	Integer updateNameAndMobileById(@Param(value="name")String name, @Param(value="mobile")String mobile, @Param(value="id")Long id);

	void updatePasswordById(@Param(value="password")String password, @Param(value="id")Long id);

	void updateAddressById(Member member);
}
