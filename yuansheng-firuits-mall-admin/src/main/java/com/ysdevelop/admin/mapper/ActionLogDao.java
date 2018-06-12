package com.ysdevelop.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.admin.entity.ActionLog;
import com.ysdevelop.common.page.Pagination;

public interface ActionLogDao {

	void save(@Param(value="log")ActionLog log);

	Integer countActionLog();

	List<ActionLog> paginationLogs(@Param(value="pagination")Pagination<ActionLog> pagination,@Param(value="queryMap") Map<String, String> queryMap);

	ActionLog getLogById(@Param(value="id")Long id);

}
