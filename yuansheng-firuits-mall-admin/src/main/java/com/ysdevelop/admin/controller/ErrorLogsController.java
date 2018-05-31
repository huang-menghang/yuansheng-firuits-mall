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

import com.ysdevelop.admin.entity.ErrorLogsMember;
import com.ysdevelop.admin.service.ErrorLogsService;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;


@Controller
@RequestMapping(value="errorlogs")
public class ErrorLogsController {
	@Autowired
	private ErrorLogsService errorlogsService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
    public String LogsList() {
		return "errorlogs/errorlogs-list";
	}
	
	@RequestMapping(value="/pagination",method = RequestMethod.GET)
	@ResponseBody
	public String pagination(HttpServletRequest request) {
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		System.out.println("进入异常日志控制器");
		Pagination<ErrorLogsMember> pagination = new Pagination<>();
	    errorlogsService.paginationByQueryMap(pagination,queryMap);
	    return JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}
	
	@RequestMapping(value = "/delete/batch",method = RequestMethod.DELETE)
	@ResponseBody
	public Result<String> deleteBatch(@RequestParam(value = "ids[]",required = false) List<Long> ids){

		errorlogsService.deleteBatchByIds(ids);

		return Result.success("操作成功");
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info() {
		return "errorlogs/info";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Result<ErrorLogsMember> info(@PathVariable(value = "id") Long id) {

		ErrorLogsMember memberInfo = errorlogsService.getInfoById(id);

		return Result.successData(memberInfo);
	} 
}
