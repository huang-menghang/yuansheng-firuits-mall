package com.ysdevelop.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.Constant;
import com.ysdevelop.shop.annotation.LoginUser;
import com.ysdevelop.shop.entity.Member;
import com.ysdevelop.shop.service.GoodsFavService;

@Controller
@RequestMapping(value = "/goodsFav")
public class GoodsFavController {

	@Autowired
	private GoodsFavService goodsFavService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> add(Long goodsId, @LoginUser Member member) {
		if (member == null || goodsId == null) {
			return Result.error(CodeMsg.SERVER_ERROR);
		}
		Integer itemChangeCount = goodsFavService.save(member.getId(), goodsId);
		String msg = null;
		if (itemChangeCount == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		} else {
			msg = itemChangeCount == Constant.DEFALUT_INTEGER_ONE ? "收藏成功" : "你已经收藏";
		}
		return Result.success(msg);

	}
}
