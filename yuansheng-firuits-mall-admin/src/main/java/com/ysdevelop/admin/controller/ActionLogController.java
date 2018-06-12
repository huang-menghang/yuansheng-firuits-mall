package com.ysdevelop.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.admin.entity.ActionLog;
import com.ysdevelop.admin.service.ActionLogService;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;

@Controller
@RequestMapping("/actionlog")
public class ActionLogController {
	@Autowired
	private ActionLogService actionLogService;
	
	@RequestMapping("/actionlog")
	public String goToActionlog() {
		return "actionlog/actionlog";
	}
	
	@RequestMapping(value="/pagination",method = RequestMethod.GET)
	@ResponseBody
	public String listLogs(HttpServletRequest request) {
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		Pagination<ActionLog> pagination = new Pagination<>();
		actionLogService.listLogs(pagination,queryMap);
		return JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));
	}
	
	@RequestMapping(value="/showlog")
	public String showLog() {
		return "actionlog/log";
	}
	
	@RequestMapping(value="/log/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Result<ActionLog> singleLog(@PathVariable String id) {
        ActionLog actionLog = actionLogService.getLog(Long.valueOf(id));
		return Result.successData(actionLog);
	}

}
