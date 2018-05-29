package com.ysdevelop.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.admin.entity.Goods;
import com.ysdevelop.common.page.Pagination;

public interface GoodsDao {

	Integer countByQueryMap(@Param(value = "queryMap")Map<String, String> queryMap);

	List<Goods> paginationByQueryMap(@Param(value = "pagination")Pagination<Goods> pagination, @Param(value = "queryMap")Map<String, String> queryMap);

	void updateStatusById(Long id);

	void deleteBatchByIds(List<Long> ids);

	Goods getInfoById(Long id);

	void saveByQueryMap(@Param(value = "queryMap")Map<String, String> queryMap);

	List<Goods> ImagePathByids(List<Long> ids);

	Goods getGoodsById(Long id);

	Goods getImagePathById(Long id);

	void editGoodsByQueryMap(@Param(value = "queryMap")Map<String, String> queryMap);

}
