package com.ysdevelop.shop.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.shop.entity.Category;
import com.ysdevelop.shop.mapper.CategoryDao;
import com.ysdevelop.shop.service.CategoryService;

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