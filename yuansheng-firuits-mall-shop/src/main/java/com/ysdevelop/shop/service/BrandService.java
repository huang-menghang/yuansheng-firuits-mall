package com.ysdevelop.shop.service;

import java.util.List;
import java.util.Map;

import com.ysdevelop.shop.entity.Brand;

public interface BrandService {
	List<Brand> listByQueryMap(Map<String, Object> queryMap);
}
