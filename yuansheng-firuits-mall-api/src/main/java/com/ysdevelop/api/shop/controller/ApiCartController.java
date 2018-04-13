package com.ysdevelop.api.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ysdevelop.api.annotation.LoginUser;
import com.ysdevelop.api.entity.Member;

@Controller
@RequestMapping(value="/cart")
public class ApiCartController {

	@RequestMapping(value="",method=RequestMethod.GET)
	public String index(@LoginUser Member member){
		System.out.println("用户id: "+member.getId());
		return "cart/index";
	}
}
