package com.ysdevelop.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.admin.entity.LogsMember;
import com.ysdevelop.common.page.Pagination;


public interface LogsDao {
	List<LogsMember> paginationByQueryMap(@Param(value="pagination")Pagination<LogsMember> pagination,@Param (value="queryMap")Map<String,String> queryMap);
    
	Integer countByQueryMap(@Param(value="queryMap")Map<String, String> queryMap);
	
	void deleteBatchByIds(List<Long> ids);
	
	LogsMember getInfoById(Long id);
}
