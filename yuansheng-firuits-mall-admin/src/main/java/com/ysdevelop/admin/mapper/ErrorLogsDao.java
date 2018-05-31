package com.ysdevelop.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.admin.entity.ErrorLogsMember;
import com.ysdevelop.common.page.Pagination;

public interface ErrorLogsDao {
	List<ErrorLogsMember> paginationByQueryMap(@Param(value="pagination")Pagination<ErrorLogsMember> pagination,@Param (value="queryMap")Map<String,String> queryMap);
    
	Integer countByQueryMap(@Param(value="queryMap")Map<String, String> queryMap);
	
	void deleteBatchByIds(List<Long> ids);
	
	ErrorLogsMember getInfoById(Long id);
}
