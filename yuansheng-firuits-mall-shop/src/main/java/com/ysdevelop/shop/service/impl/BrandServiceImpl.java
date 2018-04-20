package com.ysdevelop.shop.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.shop.entity.Brand;
import com.ysdevelop.shop.mapper.BrandDao;
import com.ysdevelop.shop.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandDao brandDao;

	@Override
	public List<Brand> listByQueryMap(Map<String, Object> queryMap) {
		if (queryMap == null || queryMap.size() == 0) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		return brandDao.listByQueryMap(queryMap);
	}

}
