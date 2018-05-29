package com.ysdevelop.admin.mapper;

import java.util.List;

import com.ysdevelop.admin.entity.Category;

public interface CategoryDao {

	List<Category> getCategories();

	List<Category> getCategoriesByParentId(Long id);

}
