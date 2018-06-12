package com.ysdevelop.admin.service;

import java.util.Map;

import com.ysdevelop.admin.entity.ActionLog;
import com.ysdevelop.common.page.Pagination;

public interface ActionLogService {

	void save(ActionLog log);

	void listLogs(Pagination<ActionLog> pagination, Map<String, String> queryMap);

	ActionLog getLog(Long id);

}
