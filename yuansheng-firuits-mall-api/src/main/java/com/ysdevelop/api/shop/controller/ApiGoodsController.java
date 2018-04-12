package com.ysdevelop.api.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.api.annotation.IgnoreAuth;
import com.ysdevelop.api.shop.service.GoodsService;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.JSONHelper;

@Controller
@RequestMapping(value = "/goods")
public class ApiGoodsController {

	@Autowired
	private GoodsService goodsService;
	
    @IgnoreAuth
	@RequestMapping(value = "/query/{queryId}", method = RequestMethod.GET)
	@ResponseBody
	public Result<String> query(@PathVariable(value = "queryId") Integer queryId) {
		return Result.successData(JSONHelper.array2json(goodsService.listByQuery(queryId)));
	}
    
    
    @IgnoreAuth
    @RequestMapping(value="/info/{id}",method = RequestMethod.GET)
    public String info(){
    	return "goods/info";
    }
    
    @IgnoreAuth
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result<String> getGoods(@PathVariable(value="id")Long id){
    	return Result.successData(JSONHelper.bean2json(goodsService.getById(id)));
    }

}
