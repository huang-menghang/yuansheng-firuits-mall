package com.ysdevelop.admin.service;

import java.util.List;
import java.util.Map;

import com.ysdevelop.admin.entity.ScrollImage;
import com.ysdevelop.common.page.Pagination;

public interface ScrollService {
	
	
	public void queryByMapQuery(Pagination<ScrollImage> pagination, Map<String, String> queryMap);

	public void deleteById(Long id);

	public void deleteBatchByIds(List<Long> ids);

	public ScrollImage getScrollById(Long id);

	public void editScrollByMap(Map<String,String> editMap);

	public void save(ScrollImage image);

	public boolean deleteImage(String filePath);
	     
}
