package com.ysdevelop.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.admin.entity.ActionLog;
import com.ysdevelop.admin.mapper.ActionLogDao;
import com.ysdevelop.admin.service.ActionLogService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;

@Service
public class ActionLogServiceImpl implements ActionLogService {
	@Autowired
	private ActionLogDao actionLogDao;

	@Override
	public void save(ActionLog log) {
		actionLogDao.save(log);
	}

	@Override
	public void listLogs(Pagination<ActionLog> pagination, Map<String, String> queryMap) {
		if (pagination == null || queryMap == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		
		Integer page = null;
		Integer limit = null;
		
		if (queryMap == null || (page = Integer.valueOf(queryMap.get("page"))) == null || (limit = Integer.valueOf(queryMap.get("limit"))) == null) {

			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		
		pagination.setPageNum(page);
		pagination.setPageSize(limit);
		
		Integer count = actionLogDao.countActionLog();
		pagination.setTotalItemsCount(count);
		
		List<ActionLog> actionLogs = actionLogDao.paginationLogs(pagination,queryMap);
		pagination.setItems(actionLogs);
	}

	@Override
	public ActionLog getLog(Long id) {
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		return actionLogDao.getLogById(id);
	}

}