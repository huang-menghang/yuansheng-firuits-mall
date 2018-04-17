package com.ysdevelop.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.shop.annotation.LoginUser;
import com.ysdevelop.shop.entity.Member;
import com.ysdevelop.shop.service.CartItemService;

@Controller
@RequestMapping(value = "/cartItem")
public class CartItemController {
	@Autowired
	private CartItemService itemService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> add(Long goodsId, @LoginUser Member member) {
		if (member == null || goodsId == null) {
			return Result.error(CodeMsg.SERVER_ERROR);
		}
		System.out.println("用户的cartId"+member.getCartId());
		itemService.save(member.getCartId(), goodsId);
		return Result.success("添加成功");
	}
}
