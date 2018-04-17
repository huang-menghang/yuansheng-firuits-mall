package com.ysdevelop.shop.service;

import javax.servlet.http.HttpSession;

import com.ysdevelop.shop.entity.Cart;
import com.ysdevelop.shop.entity.Member;



public interface CartService {

	void save(Member member,HttpSession httpSession);
	
	Cart getById(Long id);
	
}