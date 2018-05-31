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

import com.ysdevelop.admin.entity.ScrollImage;
import com.ysdevelop.admin.service.FileUpload;
import com.ysdevelop.admin.service.ScrollService;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;


@Controller
@RequestMapping("/scroll")
public class ScrollController {
      
	@Autowired
	private ScrollService scrollService;
	@Autowired
	private FileUpload fileUpload;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String goIndex(){
		
		return "scroll/index";
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public String pagination(HttpServletRequest request) {
		
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);		
		Pagination<ScrollImage> pagination = new Pagination<>();
		scrollService.queryByMapQuery(pagination, queryMap);						
		return JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result<String> deleteById(@PathVariable(value = "id") Long id){
				
		scrollService.deleteById(id);
		return Result.success("操作成功");
	}
	
	@RequestMapping(value = "/delete/batch", method = RequestMethod.DELETE)
	@ResponseBody
	public Result<String> deleteBatchByIds(@RequestParam(value = "ids[]",required = false)List<Long> ids){
				
		scrollService.deleteBatchByIds(ids);
		return Result.success("删除成功");
	}
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String info(){
		
		return "scroll/info";
	}
	
	@RequestMapping(value = "/list/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> getScrollById(@PathVariable(value = "id") Long id){
		
		ScrollImage scrollImage = scrollService.getScrollById(id);
		return Result.successData(JSONHelper.bean2json(scrollImage));
	}
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(){
		System.out.println("Controller edit  进来了");
		return "scroll/edit";
	}
	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	@ResponseBody
	public Result<String> editScrollByMap(@RequestParam Map<String,String> editMap){
				
		scrollService.editScrollByMap(editMap);		
		return Result.success("编辑成功");
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(){
		System.out.println("Controller add  进来了");
		return "scroll/add";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	public Result<String> upload(@RequestParam(value="file")MultipartFile file) throws IOException{
				
		ScrollImage scrollImage = fileUpload.upload(file);
		System.out.println(scrollImage.getImageUrl());		
		return Result.success(scrollImage.getImageUrl());
	}
	@RequestMapping(value="/save",method=RequestMethod.GET) 
	@ResponseBody
	public Result<String> save(ScrollImage image){
		
		scrollService.save(image);
		return Result.success("数据上传成功 ！ ");
	}
	
	@RequestMapping(value="/deleteImage",method=RequestMethod.DELETE)
	@ResponseBody
	public Result<String> deleteImage(String filePath){
		
		scrollService.deleteImage(filePath);
		return Result.success("图片取消  ！ ");
	}
}













/*@RequestMapping(value="/list",method=RequestMethod.GET)
@ResponseBody
public String list(@RequestParam Map<String,String> mapQuery){
	System.out.println(mapQuery.get("page"));
	System.out.println("list 进来了 ");
	JSONObject object = scrollService.list();
	return object.toString();
}
*/

/*@RequestMapping(value="/query",method=RequestMethod.GET)
@ResponseBody
public String queryByMapQuery(@RequestParam Map<String,String> queryMap){
	System.out.println("951000000  ..");
	JSONObject object =scrollService.queryByMapQuery(queryMap);
	return object.toString();
}*/



