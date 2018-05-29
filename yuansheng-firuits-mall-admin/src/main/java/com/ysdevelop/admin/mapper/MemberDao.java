package com.ysdevelop.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.admin.entity.Member;
import com.ysdevelop.common.page.Pagination;

public interface MemberDao {
	Integer countByQueryMap(@Param(value="queryMap")Map<String, String> queryMap);
	
	List<Member> paginationByQueryMap(@Param(value="pagination")Pagination<Member> pagination,@Param(value="queryMap")Map<String, String> queryMap);

	void updateStatusById(Long id);

	void deleteBatchByIds(List<Long> ids);

	Member getInfoById(Long id);

}
