package com.ysdevelop.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.admin.entity.Category;
import com.ysdevelop.admin.mapper.CategoryDao;
import com.ysdevelop.admin.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;


	@Override
	public List<Category> getCategories() {
		return categoryDao.getCategories();
	}


	@Override
	public List<Category> getCategoriesByParentId(Long id) {
		return categoryDao.getCategoriesByParentId(id);
	}
	
}
