package com.ysdevelop.api.shop.mapper;

import java.util.List;

import com.ysdevelop.api.entity.Category;

public interface CategoryDao {
	List<Category> list();
	List<Category> listById(Long parentId);
}
