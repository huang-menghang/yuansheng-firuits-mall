package com.ysdevelop.api.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ysdevelop.api.annotation.LoginUser;
import com.ysdevelop.api.entity.Cart;
import com.ysdevelop.api.entity.Member;
import com.ysdevelop.api.shop.service.CartService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.JSONHelper;

@Controller
@RequestMapping(value = "/cart")
public class ApiCartController {
	@Autowired
	private CartService cartService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(@LoginUser Member member) {
		System.out.println("用户id: " + member.getId());
		return "cart/index";
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@ResponseBody
	public Result<String> info(@LoginUser Member member) {
		Cart cart = cartService.getById(member.getCartId());
		if (cart == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		System.out.println(cart);
		return Result.successData(JSONHelper.bean2json(cart));
	}
}
