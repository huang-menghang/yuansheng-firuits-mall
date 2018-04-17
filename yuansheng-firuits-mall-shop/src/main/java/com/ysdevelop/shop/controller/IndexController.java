package com.ysdevelop.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ysdevelop.shop.annotation.IgnoreAuth;

@Controller
@RequestMapping("/index")
public class IndexController {

	@IgnoreAuth
	@RequestMapping(value="",method=RequestMethod.GET)
	public String index(){
		
		
		return "index/index";
	}

}
