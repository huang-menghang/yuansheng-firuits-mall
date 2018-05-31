package com.ysdevelop.admin.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.admin.entity.ScrollImage;
import com.ysdevelop.admin.mapper.ScrollDao;
import com.ysdevelop.admin.service.ScrollService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;

@Service
public class ScrollServiceImpl implements ScrollService{
       
	@Autowired
	private ScrollDao scrollDao;

	public void queryByMapQuery(Pagination<ScrollImage> pagination, Map<String, String> queryMap) {
		
		if (pagination == null || queryMap == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}		
		Integer page = null;
		Integer limit = null;		
		if (queryMap == null || (page = Integer.valueOf(queryMap.get("page"))) == null || (limit = Integer.valueOf(queryMap.get("limit"))) == null) {

			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		pagination.setPageNum(page);
		pagination.setPageSize(limit);		
		
		Integer count = scrollDao.countByQueryMap(queryMap);		
		pagination.setTotalItemsCount(count);
		
		List<ScrollImage> lists = scrollDao.queryByMapQuery(pagination, queryMap);		
		pagination.setItems(lists);
	
	}

	@Override
	public void deleteById(Long id) {
		if(id==null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		
		scrollDao.deleteById(id);
	}

	@Override
	public void deleteBatchByIds(List<Long> ids) {
		if(ids==null || ids.size()==0){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		
		scrollDao.deleteBatchByIds(ids);
	}

	@Override
	public ScrollImage getScrollById(Long id) {
		
		if(id==null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		
		ScrollImage scrollImage = scrollDao.getScrollById(id);		
		return scrollImage;
	}

	@Override
	public void editScrollByMap(Map<String,String> editMap) {
		
		if(editMap==null || editMap.size()==0){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}		
		scrollDao.editScrollByMap(editMap);		
	}

	@Override
	public void save(ScrollImage image) {
		
		if(image==null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		scrollDao.save(image);		
	}

	@Override
	public boolean deleteImage(String filePath) {
		
		if(filePath==null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		String fileName =filePath.substring(filePath.lastIndexOf("\\"));
		
		File file = new File(Constant.IMAGE_PATH,fileName);
		if(file.exists()){
			return file.delete();
		}
		return true;		
	}
}
















/*@Override
public JSONObject queryByMapQuery(Map<String, String> queryMap) {
	
	List<ScrollImage> list = scrollDao.queryByMapQuery(queryMap);
	JSONObject object = new JSONObject();
	object.put("code", 0);
	object.put("data", list);
	object.put("count", list.size());
	object.put("msg","");
	
	return object;
}
*/












