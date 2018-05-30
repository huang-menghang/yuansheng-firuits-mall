package com.ysdevelop.admin.controller;

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

import com.ysdevelop.admin.entity.Brand;
import com.ysdevelop.admin.service.BrandService;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;

@Controller
@RequestMapping(value = "/brand")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	//品牌页面跳转
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String index(){
		return "brand/index";
	}
	
	//初始化品牌列表并分页
	@RequestMapping(value = "/pagination",method = RequestMethod.GET)
	@ResponseBody
	public String pagination(HttpServletRequest request){
		Map<String,String> queryMap = HttpUtils.getParameterMap(request);
		Pagination<Brand> pagination = new Pagination<>();
		brandService.paginationByQueryMap(queryMap,pagination);
		return JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}
	
	//更改status状态码用于上架和下架
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	@ResponseBody
	public Result<String> updateStatus(@PathVariable(value = "id") Long id){
		brandService.updateStatusById(id);
		System.out.println(id);
		return Result.success("操作成功");
	}
	
	//用于批量删除品牌
	@RequestMapping(value = "/deleteBatch",method = RequestMethod.DELETE)
	@ResponseBody
	public Result<String> deleteBatch(@RequestParam(value = "ids[]", required = false) List<Long> ids){
		brandService.deleteBatchByIds(ids);
		System.out.println(ids);
		return Result.success("操作成功");
	}
	
	//跳转品牌页面
	@RequestMapping(value = "/edit",method = RequestMethod.GET)
	public String edit(){
		return "brand/edit";
	}
	
	//跳转添加页面
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String add(){
		return "brand/add";
	}
	
	//初始化修改页面表单
	@RequestMapping(value = "/edit/getBrand/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Result<String> getBrand(@PathVariable(value = "id") Long id){
		return Result.successData(JSONHelper.bean2json(brandService.getBrandById(id)));
	}
	
	//进行品牌的修改操作
	@RequestMapping(value = "edit/update",method = RequestMethod.PUT)
	@ResponseBody
	public Result<String> update(@RequestParam Map<String,String> queryMap){
		System.out.println(queryMap);
		brandService.updateByQueryMap(queryMap);
		return Result.success("操作成功");
	}

	//进行品牌的添加操作
	@RequestMapping(value = "/add/save",method = RequestMethod.POST)
	@ResponseBody
	public Result<String> save(@RequestParam Map<String,String> queryMap){
		System.out.println(queryMap);
		brandService.saveByQueryMap(queryMap);
		return Result.success("操作成功");
	}
	

}
