package com.ysdevelop.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainController {
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET, produces = "text/html;charset=utf-8")
	public String index() {
		return "index/index";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET, produces = "text/html;charset=utf-8")
	public String welcome() {
		return "index/welcome";
	}

}
