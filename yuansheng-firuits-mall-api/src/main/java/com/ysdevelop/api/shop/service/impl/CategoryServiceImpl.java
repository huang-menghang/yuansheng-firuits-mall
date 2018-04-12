package com.ysdevelop.api.shop.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.api.entity.Category;
import com.ysdevelop.api.shop.mapper.CategoryDao;
import com.ysdevelop.api.shop.service.CategoryService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Category> list() {

		return categoryDao.list();
	}

	@Override
	public List<Category> listById(Long parentId) {
		if(parentId==null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		return categoryDao.listById(parentId);
	}

}
