package com.ysdevelop.api.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ysdevelop.api.annotation.IgnoreAuth;

@Controller
@RequestMapping("/index")
public class ApiIndexController {

	@IgnoreAuth
	@RequestMapping(value="",method=RequestMethod.GET)
	public String index(){
		
		
		return "index/index";
	}

}
