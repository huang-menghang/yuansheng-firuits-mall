package com.ysdevelop.shop.service;

import java.util.List;

import com.ysdevelop.shop.entity.Category;


public interface CategoryService {
	List<Category> list();
	
	List<Category> listById(Long parentId);
}
