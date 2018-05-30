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

import com.ysdevelop.admin.entity.LogsMember;
import com.ysdevelop.admin.service.LogsService;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;

@Controller
@RequestMapping(value="logs")
public class LogsController {
	
	@Autowired
	private LogsService logsService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
    public String LogsList() {
		return "logs/logs-list";
	}
	
	@RequestMapping(value="/pagination",method = RequestMethod.GET)
	@ResponseBody
	public String pagination(HttpServletRequest request) {
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		System.out.println("进入日志控制器");
		Pagination<LogsMember> pagination = new Pagination<>();
	    logsService.paginationByQueryMap(pagination,queryMap);
	    return JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}
	
	@RequestMapping(value = "/delete/batch",method = RequestMethod.DELETE)
	@ResponseBody
	public Result<String> deleteBatch(@RequestParam(value = "ids[]",required = false) List<Long> ids){
		System.out.println("AAA");
		logsService.deleteBatchByIds(ids);
		System.out.println("BBBB");
		return Result.success("操作成功");
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info() {
		return "logs/info";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Result<LogsMember> info(@PathVariable(value = "id") Long id) {

		LogsMember memberInfo = logsService.getInfoById(id);

		return Result.successData(memberInfo);
		
	} 
}
