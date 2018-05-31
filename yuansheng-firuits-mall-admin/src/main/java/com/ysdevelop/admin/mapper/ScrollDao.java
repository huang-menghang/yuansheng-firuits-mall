package com.ysdevelop.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.admin.entity.ScrollImage;
import com.ysdevelop.common.page.Pagination;

public interface ScrollDao {
     
	public Integer countByQueryMap(@Param(value="queryMap")Map<String, String> queryMap);

	public List<ScrollImage> queryByMapQuery(@Param(value="pagination")Pagination<ScrollImage> pagination,@Param(value="queryMap") Map<String, String> queryMap);

	public void deleteById(Long id);

	public void deleteBatchByIds(List<Long> ids);

	public ScrollImage getScrollById(Long id);

	public void editScrollByMap(@Param(value="editMap")Map<String,String> editMap);

	public void save(ScrollImage image);
}
