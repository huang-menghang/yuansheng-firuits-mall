package com.ysdevelop.admin.service;

import java.util.List;
import java.util.Map;

import com.ysdevelop.admin.entity.ErrorLogsMember;
import com.ysdevelop.common.page.Pagination;

public interface ErrorLogsService {
	void paginationByQueryMap(Pagination<ErrorLogsMember> pagination,Map<String, String> queryMap);
    
	void deleteBatchByIds(List<Long> ids);
	
	ErrorLogsMember getInfoById(Long id);
	

}
