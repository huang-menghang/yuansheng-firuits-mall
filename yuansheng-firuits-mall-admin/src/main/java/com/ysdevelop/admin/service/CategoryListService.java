package com.ysdevelop.admin.service;

import java.util.List;
import java.util.Map;

import com.ysdevelop.admin.entity.CategoryListImage;
import com.ysdevelop.common.page.Pagination;

public interface CategoryListService {
      	
	public void queryByMapQuery(Pagination<CategoryListImage> pagination, Map<String, String> queryMap);

	public void editStatusById(Long id);

	public void deleteBatchByids(List<Long> ids);

	public CategoryListImage getCategoryById(Long id);

	public void editCategoryByMap(Map<String, String> editMap);

	public void save(CategoryListImage image);

	public boolean deleteImage(String filePath);
}
