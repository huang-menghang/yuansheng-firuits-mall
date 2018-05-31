package com.ysdevelop.admin.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.admin.entity.CategoryListImage;
import com.ysdevelop.admin.mapper.CategoryListDao;
import com.ysdevelop.admin.service.CategoryListService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;
@Service
public class CategoryListServiceImpl implements CategoryListService {
    
	@Autowired
	private CategoryListDao categoryListDao;

	@Override
	public void queryByMapQuery(Pagination<CategoryListImage> pagination, Map<String, String> queryMap){
		
		Integer page = Integer.valueOf(queryMap.get("page"));
		Integer limit = Integer.valueOf(queryMap.get("limit"));
		if(pagination == null || queryMap == null || page==null || limit==null){
			
			throw new WebServiceException(CodeMsg.SERVER_ERROR);			
		}
						
		Integer count = categoryListDao.queryCount(queryMap);
		System.out.println("count = "+count);
		pagination.setTotalItemsCount(count);
		pagination.setPageSize(limit);
		pagination.setPageNum(page);;
	
		List<CategoryListImage> list = categoryListDao.list(pagination,queryMap); 
		pagination.setItems(list);
	}
	
	@Override
	public void editStatusById(Long id) {
		if(id==null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		categoryListDao.editStatusById(id);
	}
	
	@Override
	public void deleteBatchByids(List<Long> ids) {
		if(ids==null || ids.size()==0){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		categoryListDao.deleteBatchByids(ids);
	}
	
	@Override
	public CategoryListImage getCategoryById(Long id) {
		if(id==null){

			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		CategoryListImage image = categoryListDao.getCategoryById(id);
		return image;
	}
	
	@Override
	public void editCategoryByMap(Map<String, String> editMap) {
		if(editMap==null || editMap.size()==0){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		for(String s : editMap.keySet()){
			System.out.println(s+" = "+editMap.get(s));
		}
		System.out.println(editMap.get("id")+" ... "+editMap.get("createTime"));
		System.out.println(editMap.get("name")+". 00 . 21212 ."+editMap.get("imageUrl"));
		categoryListDao.editCategoryByMap(editMap);
		System.out.println("实现类中   我也走完了 ！ ");
		
	}
	
	@Override
	public void save(CategoryListImage image) {
		
		if(image==null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}		
		System.out.println("CategoryListImag ="+image.toString());
		categoryListDao.save(image);
		
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
