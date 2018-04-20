package com.ysdevelop.shop.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.JSONHelper;
import com.ysdevelop.shop.annotation.IgnoreAuth;
import com.ysdevelop.shop.entity.Brand;
import com.ysdevelop.shop.service.BrandService;

@Controller
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@IgnoreAuth
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public Result<String> listByQuery(@RequestParam Map<String, Object> queryMap) {
		List<Brand> brands = brandService.listByQueryMap(queryMap);
		return Result.successData(JSONHelper.array2json(brands));
	}

}
