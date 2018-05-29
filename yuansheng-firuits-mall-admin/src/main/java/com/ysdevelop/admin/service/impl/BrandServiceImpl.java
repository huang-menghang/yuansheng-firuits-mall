package com.ysdevelop.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ysdevelop.admin.entity.Brand;
import com.ysdevelop.admin.mapper.BrandDao;
import com.ysdevelop.admin.service.BrandService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandDao brandDao;

	@Override
	public List<Brand> getBrands() {
		return brandDao.getBrands();
	}

	@Override
	public void paginationByQueryMap(Map<String, String> queryMap, Pagination<Brand> pagination) {
		if (queryMap == null || queryMap.size() == 0) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Integer page = null;
		Integer limit = null;
		if ((page = Integer.valueOf(queryMap.get("page"))) == null || (limit = Integer.valueOf(queryMap.get("limit"))) == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		System.out.println(page + "     "+limit);
		System.out.println();
		pagination.setPageNum(page);
		pagination.setPageSize(limit);
		Integer count = brandDao.countByQueryMap(queryMap);
		pagination.setTotalItemsCount(count);
		System.out.println(queryMap);
		List<Brand> brands = brandDao.paginationByQueryMap(queryMap,pagination);
		System.out.println(brands);
		pagination.setItems(brands);
	}

	@Override
	public void updateStatusById(Long id) {
		if (id == null) {
			throw  new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		brandDao.updateStatusById(id);
	}

	@Override
	public void deleteBatchByIds(List<Long> ids) {
		if (ids == null || ids.size() == 0) {
			throw  new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		brandDao.deleteBatchByIds(ids);
	}

	@Override
	public Brand getBrandById(Long id) {
		return brandDao.getBrandById(id);
	}

	@Override
	@Transactional
	public void updateByQueryMap(Map<String, String> queryMap) {
		if (queryMap == null || queryMap.size() == 0) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		brandDao.updateByQueryMap(queryMap);
	}

	@Override
	public void saveByQueryMap(Map<String, String> queryMap) {
		if (queryMap == null || queryMap.size() == 0) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		brandDao.saveByQueryMap(queryMap);
	}


}
