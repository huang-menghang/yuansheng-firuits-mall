package com.ysdevelop.shop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.shop.entity.Goods;

public interface GoodsDao {
	List<Goods> listByQuery(@Param(value = "queryId") Integer queryId);

	Goods getById(Long id);

	Integer countByQueryMap(@Param(value="queryMap")Map<String, Object> queryMap);

	List<Goods> listByQueryMap(@Param(value="queryMap")Map<String, Object> queryMap,@Param(value="pagination") Pagination<Goods> pagination);
}
