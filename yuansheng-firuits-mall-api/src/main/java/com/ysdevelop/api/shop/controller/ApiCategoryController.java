package com.ysdevelop.api.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.api.annotation.IgnoreAuth;
import com.ysdevelop.api.entity.Category;
import com.ysdevelop.api.shop.service.CategoryService;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.JSONHelper;

@Controller
@RequestMapping(value = "/category")
public class ApiCategoryController {
	@Autowired
	private CategoryService categoryService;

	@IgnoreAuth
	@RequestMapping(method = RequestMethod.GET, value = "")
	@ResponseBody
	public Result<String> index() {
		List<Category> categories = categoryService.list();
		return Result.successData(JSONHelper.array2json(categories));
	}

	@IgnoreAuth
	@RequestMapping(method = RequestMethod.GET, value = "/info/{parentId}")
	public String info(@PathVariable(value = "parentId") Integer parentId) {
		return "category/index";
	}

	@IgnoreAuth
	@RequestMapping(method = RequestMethod.GET, value = "/{parentId}")
	@ResponseBody
	public Result<String> listClassification(@PathVariable(value = "parentId") Long parentId) {

		return Result.successData(JSONHelper.array2json(categoryService.listById(parentId)));
	}
}
