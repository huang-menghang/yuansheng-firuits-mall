package com.ysdevelop.api.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.common.result.Result;

@Controller
@RequestMapping(value = "/cartItem")
public class ApiCartItemController {

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> add(Long goodsId) {
		return Result.success("添加成功");
	}

}
