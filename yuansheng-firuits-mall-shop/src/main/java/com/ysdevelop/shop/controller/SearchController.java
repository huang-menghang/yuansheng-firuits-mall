package com.ysdevelop.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ysdevelop.shop.annotation.IgnoreAuth;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@IgnoreAuth
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "search/index";
	}

}
