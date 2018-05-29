package com.ysdevelop.admin.service;

import java.util.List;

import com.ysdevelop.admin.entity.Category;

public interface CategoryService {

	List<Category> getCategories();

	List<Category> getCategoriesByParentId(Long id);

}
