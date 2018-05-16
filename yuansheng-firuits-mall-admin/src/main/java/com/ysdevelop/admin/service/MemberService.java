package com.ysdevelop.admin.service;

import java.util.List;
import java.util.Map;

import com.ysdevelop.admin.entity.Member;
import com.ysdevelop.common.page.Pagination;

public interface MemberService {

	void paginationByQueryMap(Pagination<Member> pagination, Map<String, String> queryMap);

	void deleteById(Long id);

	void deleteBatchByIds(List<Long> ids);

	Member getInfoById(Long id);

}
