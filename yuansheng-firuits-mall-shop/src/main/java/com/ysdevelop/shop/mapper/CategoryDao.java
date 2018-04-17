package com.ysdevelop.shop.mapper;

import java.util.List;

import com.ysdevelop.shop.entity.Category;

public interface CategoryDao {
	List<Category> list();
	List<Category> listById(Long parentId);
}