package com.ysdevelop.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.admin.entity.ErrorLogsMember;
import com.ysdevelop.admin.mapper.ErrorLogsDao;
import com.ysdevelop.admin.service.ErrorLogsService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;

@Service
public class ErrorLogsServiceImpl implements ErrorLogsService{
	@Autowired 
	private ErrorLogsDao errorlogsDao;
    
	@Override
	public void paginationByQueryMap(Pagination<ErrorLogsMember> pagination,Map<String, String> queryMap) {
		if (pagination == null || queryMap == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		
		Integer page = null;
		Integer limit = null;
		if ((page = Integer.valueOf(queryMap.get("page"))) == null || (limit = Integer.valueOf(queryMap.get("limit"))) == null) {

			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		pagination.setPageNum(page);
		pagination.setPageSize(limit);
		System.out.println("是不是空"+queryMap);
		Integer count = errorlogsDao.countByQueryMap(queryMap);
		System.out.println(count);
		pagination.setTotalItemsCount(count);
		List<ErrorLogsMember> memberItems = errorlogsDao.paginationByQueryMap(pagination,queryMap);
		System.out.println(memberItems);
		pagination.setItems(memberItems);
	}
	@Override
	public void deleteBatchByIds(List<Long> ids) {
		if (ids == null || ids.size() == Constant.DEFAULT_INTEGER_ZERO) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		errorlogsDao.deleteBatchByIds(ids);
	}
	
	@Override
	public ErrorLogsMember getInfoById(Long id){
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		ErrorLogsMember memberInfo = errorlogsDao.getInfoById(id);
		return memberInfo;
	}
}
