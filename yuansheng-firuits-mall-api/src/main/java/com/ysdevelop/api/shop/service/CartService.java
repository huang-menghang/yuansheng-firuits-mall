package com.ysdevelop.api.shop.service;

import javax.servlet.http.HttpSession;

import com.ysdevelop.api.entity.Cart;
import com.ysdevelop.api.entity.Member;

public interface CartService {

	void save(Member member,HttpSession httpSession);
	
	Cart getById(Long id);
	
}
