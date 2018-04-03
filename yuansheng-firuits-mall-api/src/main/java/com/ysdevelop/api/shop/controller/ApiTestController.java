package com.ysdevelop.api.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.result.Result;

@Controller
@RequestMapping("/apiTest")
public class ApiTestController {

	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	@ResponseBody
	public Result<String> helloWrold() {
		return Result.error(CodeMsg.SUCCESS);
	}

}
