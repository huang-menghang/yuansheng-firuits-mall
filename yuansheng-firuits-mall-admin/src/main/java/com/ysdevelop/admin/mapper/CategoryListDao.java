package com.ysdevelop.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.admin.entity.CategoryListImage;
import com.ysdevelop.common.page.Pagination;

public interface CategoryListDao {
          
	public List<CategoryListImage> list(@Param(value="pagination")Pagination<CategoryListImage> pagination, @Param(value="queryMap")Map<String, String> queryMap);

	public Integer queryCount(@Param(value="queryMap")Map<String, String> queryMap);

	public void editStatusById(Long id);

	public void deleteBatchByids(List<Long> ids);

	public CategoryListImage getCategoryById(Long id);

	public void editCategoryByMap(@Param(value="editMap")Map<String, String> editMap);

	public void save(CategoryListImage image);
	
}
