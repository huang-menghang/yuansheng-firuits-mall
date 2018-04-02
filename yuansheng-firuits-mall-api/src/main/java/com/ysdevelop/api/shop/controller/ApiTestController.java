package com.ysdevelop.api.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/apiTest")
public class ApiTestController {

	@RequestMapping(value = "/sayHello", method = RequestMethod.GET, produces = "text/json;charset=utf-8")
	@ResponseBody
	public String helloWrold() {
		return "hello";
	}

}
