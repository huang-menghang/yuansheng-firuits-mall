package com.ysdevelop.shop.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;
import com.ysdevelop.shop.annotation.IgnoreAuth;
import com.ysdevelop.shop.entity.Goods;
import com.ysdevelop.shop.service.GoodsService;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	@IgnoreAuth
	@RequestMapping(value = "/query/{queryId}", method = RequestMethod.GET)
	@ResponseBody
	public Result<String> query(@PathVariable(value = "queryId") Integer queryId) {
		return Result.successData(JSONHelper.array2json(goodsService.listByQuery(queryId)));
	}

	@IgnoreAuth
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public String info() {
		return "goods/info";
	}

	@IgnoreAuth
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Result<String> getGoods(@PathVariable(value = "id") Long id) {
		return Result.successData(JSONHelper.bean2json(goodsService.getById(id)));
	}

	@IgnoreAuth
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(String query) {
		System.out.println(query);
		return "goods/list";
	}

	@IgnoreAuth
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public Result<String> doList(@RequestParam Map<String, Object> queryMap, Pagination<Goods> pagination) {
		if (queryMap.containsKey("query")) {
			String queryValue = HttpUtils.getRequestParamterUtf8((String) queryMap.get("query"));
			queryMap.put("query",  HttpUtils.getRequestParamterUtf8(queryValue));
		}
		System.out.println(pagination.getPageNum());
		pagination.setPageSize(3);
		goodsService.pagination(queryMap, pagination);
		return Result.successData(JSONHelper.bean2json(pagination));
	}

}