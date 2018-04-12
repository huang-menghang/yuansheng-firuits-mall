package com.ysdevelop.api.shop.service;

import java.util.List;

import com.ysdevelop.api.entity.Category;

public interface CategoryService {
	List<Category> list();
	
	List<Category> listById(Long parentId);
}
