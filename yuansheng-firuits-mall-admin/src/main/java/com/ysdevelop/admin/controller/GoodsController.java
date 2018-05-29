package com.ysdevelop.admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ysdevelop.admin.entity.Goods;
import com.ysdevelop.admin.service.GoodsService;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	//商品跳转页面
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
		return "goods/index";
	}

	//初始化商品表格
	@RequestMapping(value = "/pagination", method = RequestMethod.GET)
	@ResponseBody
	public String pagination(HttpServletRequest request) {
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		Pagination<Goods> pagination = new Pagination<>();
		goodsService.paginationByQueryMap(pagination, queryMap);
		return JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}
	
	//商品上架与下架
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Result<String> update(@PathVariable(value = "id") Long id){
		System.out.println(id);
		goodsService.updateStatusById(id);
		return Result.success("操作成功");
	}
	
	//商品详情
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Result<String> info(@PathVariable(value = "id") Long id){
		System.out.println(id);
		goodsService.getInfoById(id);
		return Result.successData(JSONHelper.bean2json(goodsService.getInfoById(id)));
	}
	
	//商品详情页跳转
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info(){
		return "goods/info";
	}
	
	//批量删除操作
	@RequestMapping(value = "/deleteBatch",method = RequestMethod.DELETE)
	@ResponseBody
	public Result<String> deleteBatch(@RequestParam(value = "ids[]", required = false) List<Long> ids){
		System.out.println(ids.toString());
		goodsService.deleteBatchByIds(ids);
		return Result.success("批处理成功");
	}
	
	//商品添加页面跳转
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String add(){
		return "goods/add";
	}
	
	//商品修改页面跳转
	@RequestMapping(value = "/edit",method = RequestMethod.GET)
	public String edit(){
		return "goods/edit";
	}

	//商品文件上传
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	@ResponseBody
	public Result<String> uploadFile(@RequestParam(value = "file")MultipartFile file) throws IOException{
		return Result.successData(JSONHelper.bean2json(goodsService.uploadFile(file)));
	}
	
	//商品添加
	@RequestMapping(value = "/add/save",method = RequestMethod.POST)
	@ResponseBody
	public Result<String> save(@RequestParam Map<String, String> queryMap){
		goodsService.saveByQueryMap(queryMap);
		return Result.success("操作成功");
	}
	
	//修改商品信息操作
	@RequestMapping(value = "/edit/update",method = RequestMethod.PUT)
	@ResponseBody
	public Result<String> edit(@RequestParam Map<String, String> queryMap){
		//Map<String,String> queryMap = HttpUtils.getParameterMap(request);
		System.out.println(queryMap);
		goodsService.editGoodsByQueryMap(queryMap);
		return Result.success("操作成功");
	}

	//添加商品时 品牌 与 分类 下拉列表初始化
	@RequestMapping(value = "/add/getBrandsAndCategories",method = RequestMethod.GET)
	@ResponseBody
	public Result<String> getBrandsAndCategories(){
		return Result.successData(JSONHelper.bean2json(goodsService.getBrandsAndCategories()));
	}
	
	//通过商品主分类 获取其子分类
	@RequestMapping(value = "/getCategories/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Result<String> getCategories(@PathVariable(value = "id") Long id){
		return Result.successData(JSONHelper.bean2json(goodsService.getCategoriesByParentId(id)));
	}
	
	//初始化修改页面
	@RequestMapping(value = "/edit/getGoods/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Result<String> getGoods(@PathVariable(value = "id") Long id){
		return Result.successData(JSONHelper.bean2json(goodsService.getGoodsById(id)));
	}
}
