package com.ysdevelop.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.admin.entity.Brand;
import com.ysdevelop.common.page.Pagination;

public interface BrandDao {

	List<Brand> getBrands();

	Integer countByQueryMap(@Param(value = "queryMap") Map<String, String> queryMap);

	List<Brand> paginationByQueryMap(@Param(value = "queryMap") Map<String, String> queryMap,@Param(value = "pagination") Pagination<Brand> pagination);

	void updateStatusById(Long id);

	void deleteBatchByIds(List<Long> ids);

	Brand getBrandById(Long id);

	void updateByQueryMap(@Param(value = "queryMap") Map<String, String> queryMap);

	void saveByQueryMap(@Param(value = "queryMap") Map<String, String> queryMap);
}
