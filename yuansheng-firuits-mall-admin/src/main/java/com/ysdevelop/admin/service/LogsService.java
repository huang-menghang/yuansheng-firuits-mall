package com.ysdevelop.admin.service;

import java.util.List;
import java.util.Map;

import com.ysdevelop.admin.entity.LogsMember;
import com.ysdevelop.common.page.Pagination;

public interface LogsService {
	void paginationByQueryMap(Pagination<LogsMember> pagination,Map<String, String> queryMap);
    
	void deleteBatchByIds(List<Long> ids);
	
	LogsMember getInfoById(Long id);
}
