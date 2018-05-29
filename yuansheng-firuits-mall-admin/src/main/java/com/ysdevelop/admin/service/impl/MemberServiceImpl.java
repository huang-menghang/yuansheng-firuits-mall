package com.ysdevelop.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.admin.entity.Member;
import com.ysdevelop.admin.mapper.MemberDao;
import com.ysdevelop.admin.service.MemberService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public void paginationByQueryMap(Pagination<Member> pagination, Map<String, String> queryMap) {
		if (pagination == null || queryMap == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		
		Integer page = null;
		Integer limit = null;
		System.out.println(Integer.valueOf((String) queryMap.get("page")));
		if (queryMap == null || (page = Integer.valueOf(queryMap.get("page"))) == null || (limit = Integer.valueOf(queryMap.get("limit"))) == null) {

			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		pagination.setPageNum(page);
		pagination.setPageSize(limit);
		
		System.out.println("是否为空1"+queryMap);
		Integer count = memberDao.countByQueryMap(queryMap);
		pagination.setTotalItemsCount(count);
		System.out.println("是否为空"+queryMap);
		List<Member> memberItems = memberDao.paginationByQueryMap(pagination, queryMap);
		pagination.setItems(memberItems);

	}

	@Override
	public void deleteById(Long id) {
		if(id == null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		
		
		
		memberDao.updateStatusById(id);
		
		
		
	}

	@Override
	public void deleteBatchByIds(List<Long> ids) {
		
		if(ids == null || ids.size() == Constant.DEFALUT_INTEGER_ZERO){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		
		memberDao.deleteBatchByIds(ids);
		
		
	}

	@Override
	public Member getInfoById(Long id) {
		if(id == null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Member memberInfo = memberDao.getInfoById(id);
		return memberInfo;
	}

}
