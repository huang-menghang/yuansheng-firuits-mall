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

import com.ysdevelop.admin.entity.CategoryListImage;
import com.ysdevelop.admin.entity.ScrollImage;
import com.ysdevelop.admin.service.CategoryListService;
import com.ysdevelop.admin.service.FileUpload;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;

@Controller
@RequestMapping("/categoryList")
public class CategoryListController {
    
	@Autowired
	private CategoryListService category;
	
	@Autowired
	private FileUpload fileUpload;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		return "categoryList/index";
	}
	
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public String pagination(HttpServletRequest request) {
	    
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);	
		Pagination<CategoryListImage> pagination = new Pagination<>();
		category.queryByMapQuery(pagination, queryMap);		
		return JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Result<String> editStatusById(@PathVariable(value="id")Long id){

		 category.editStatusById(id);
		return Result.success("操作成功 ！");
				
	}
	
	@RequestMapping(value = "/delete/batch", method = RequestMethod.DELETE)
	@ResponseBody
	public Result<String> deleteBatchByids(@RequestParam(value = "ids[]",required = false)List<Long> ids){
			
		 category.deleteBatchByids(ids);
		return Result.success(" 批量删除成功 ！");
				
	}
	
	@RequestMapping(value ="/edit",method=RequestMethod.GET)
	public String edit(){
		return "categoryList/edit";
	}
	
	@RequestMapping(value = "/list/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> getCategoryById(@PathVariable(value="id")Long id){
			
		 CategoryListImage categoryList = category.getCategoryById(id);
		return Result.successData(JSONHelper.bean2json(categoryList));
				
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	@ResponseBody
	public Result<String> editCategoryByMap(@RequestParam Map<String,String> editMap){

		category.editCategoryByMap(editMap);		
		return Result.success("编辑成功");
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(){
		System.out.println("Controller add  进来了");
		return "categoryList/add";
	}

	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	public Result<String> upload(@RequestParam(value="file")MultipartFile file) throws IOException{
		System.out.println("Controller upload  进来了");
		
		ScrollImage scrollImage = fileUpload.upload(file);
		System.out.println(scrollImage.getImageUrl());	
		return Result.success(scrollImage.getImageUrl());
	}
		
	@RequestMapping(value="/save",method=RequestMethod.GET) 
	@ResponseBody
	public Result<String> save(CategoryListImage image){
		
		category.save(image);		
		return Result.success("数据上传成功 ！ ");
	}
	
	@RequestMapping(value="/deleteImage",method=RequestMethod.DELETE)
	@ResponseBody
	public Result<String> deleteImage(String filePath){
		
		category.deleteImage(filePath);
		return Result.success("图片取消  ！ ");
	}
}


