package com.ysdevelop.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.admin.entity.LogsMember;
import com.ysdevelop.admin.mapper.LogsDao;
import com.ysdevelop.admin.service.LogsService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;

@Service
public class LogsServiceImpl implements LogsService{
	@Autowired 
	private LogsDao logsDao;
    
	@Override
	public void paginationByQueryMap(Pagination<LogsMember> pagination,Map<String, String> queryMap) {
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
		Integer count = logsDao.countByQueryMap(queryMap);
		pagination.setTotalItemsCount(count);
		List<LogsMember> memberItems = logsDao.paginationByQueryMap(pagination,queryMap);
		pagination.setItems(memberItems);
	}
	
	@Override
	public void deleteBatchByIds(List<Long> ids) {
		if (ids == null || ids.size() == Constant.DEFALUT_INTEGER_ZERO) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		logsDao.deleteBatchByIds(ids);
	}
	
	@Override
	public LogsMember getInfoById(Long id){
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		LogsMember memberInfo = logsDao.getInfoById(id);
		return memberInfo;
	}
}
