package com.ysdevelop.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.JSONHelper;
import com.ysdevelop.shop.annotation.IgnoreAuth;
import com.ysdevelop.shop.annotation.LoginUser;
import com.ysdevelop.shop.entity.Cart;
import com.ysdevelop.shop.entity.Member;
import com.ysdevelop.shop.service.CartService;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
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
	@IgnoreAuth
	@RequestMapping(value="countGoods",method = RequestMethod.GET)
	@ResponseBody
	public Result<Integer> countGoods(@LoginUser Member member){
		Integer goodsCount = cartService.countGoodsById(member.getCartId());
		return Result.successData(goodsCount);
	}
	
}