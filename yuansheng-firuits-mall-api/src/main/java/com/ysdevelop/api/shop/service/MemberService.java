package com.ysdevelop.api.shop.service;

import javax.servlet.http.HttpSession;

import com.ysdevelop.api.entity.Member;

public interface MemberService {
	void save(Member member,String confirmPassword);

	void sendMessage(HttpSession session);
	
}
