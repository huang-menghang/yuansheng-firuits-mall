package com.ysdevelop.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.shop.annotation.LoginUser;
import com.ysdevelop.shop.entity.CartItem;
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
		System.out.println("用户的cartId" + member.getCartId());
		itemService.save(member.getCartId(), goodsId);
		return Result.success("添加成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result<String> delete(@PathVariable(value = "id") Long id) {
		itemService.updateStatusById(id);
		return Result.success("删除成功");
	}

	// 数据库批处理,以及map传值
	@RequestMapping(value = "/batch", method = RequestMethod.PUT)
	@ResponseBody  
	public Result<String> bathch(@RequestBody  List<CartItem> items) {
		itemService.updateItemBatch(items);
		return Result.success("修改成功");
	}
}
