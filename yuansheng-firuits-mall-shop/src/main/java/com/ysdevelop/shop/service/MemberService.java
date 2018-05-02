package com.ysdevelop.shop.service;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ysdevelop.shop.entity.Member;
import com.ysdevelop.shop.vo.LoginVo;



public interface MemberService {
	void save(Member member,String confirmPassword, String messageCode, HttpSession session);

	void sendMessage(HttpSession session, String mobile);
	
	Member login(LoginVo loginVo,HttpSession session,HttpServletResponse response);

	Integer updateNameAndMobileById(String name, String tel, Long id);
	
	void refreshSessionMember(HttpSession session,String token,Member member);

	String  updatePasswordById(String newPassword, String newConfirmPassword, String oldPassword, Member loginMember);

	void updateAddressById(Member member, Member loginMember);
}