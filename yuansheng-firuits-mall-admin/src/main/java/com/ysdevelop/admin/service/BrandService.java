package com.ysdevelop.admin.service;

import java.util.List;
import java.util.Map;

import com.ysdevelop.admin.entity.Brand;
import com.ysdevelop.common.page.Pagination;

public interface BrandService {

	List<Brand> getBrands();

	void paginationByQueryMap(Map<String, String> queryMap, Pagination<Brand> pagination);

	void updateStatusById(Long id);

	void deleteBatchByIds(List<Long> ids);

	Brand getBrandById(Long id);

	void updateByQueryMap(Map<String, String> queryMap);

	void saveByQueryMap(Map<String, String> queryMap);

}
