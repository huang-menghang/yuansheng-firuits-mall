package com.ysdevelop.admin.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ysdevelop.admin.entity.Goods;
import com.ysdevelop.admin.mapper.GoodsDao;
import com.ysdevelop.admin.service.BrandService;
import com.ysdevelop.admin.service.CategoryService;
import com.ysdevelop.admin.service.GoodsService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;

@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsDao goodsDao;
	
	@Autowired
	private BrandService brandService;
	
	@Autowired 
	private CategoryService categoryService;
	
	private String uploadPath = "D:\\upload\\static\\images\\goods\\";

	@Override
	public void paginationByQueryMap(Pagination<Goods> pagination, Map<String, String> queryMap) {
		if (pagination == null || queryMap == null || queryMap.size() == 0) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Integer page = null;
		Integer limit = null;
		if ((page = Integer.valueOf(queryMap.get("page"))) == null || (limit = Integer.valueOf(queryMap.get("limit"))) == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		System.out.println(page + "     "+limit);
		pagination.setPageNum(page);
		pagination.setPageSize(limit);
		Integer count = goodsDao.countByQueryMap(queryMap);
		System.out.println(count);
		pagination.setTotalItemsCount(count);
		List<Goods> goods = goodsDao.paginationByQueryMap(pagination,queryMap);
		System.out.println(goods);
		pagination.setItems(goods);
	}

	@Override
	@Transactional
	public void updateStatusById(Long id) {
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		goodsDao.updateStatusById(id);
	}

	@Override
	@Transactional
	public void deleteBatchByIds(List<Long> ids) {
		if (ids == null || ids.size() == 0) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		goodsDao.deleteBatchByIds(ids);
	}

	@Override
	public Goods getInfoById(Long id) {
		if(id == null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		return goodsDao.getInfoById(id);
	}

	@Override
	public Goods getBrandsAndCategories() {
		Goods goods = new Goods();
		goods.setCategories(categoryService.getCategories());
		goods.setBrandsNames(brandService.getBrands());
		return goods;
	}

	@Override
	public Goods getCategoriesByParentId(Long id) {
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Goods goods = new Goods();
		goods.setCategories(categoryService.getCategoriesByParentId(id));
		return goods;
	}

	@Override
	@Transactional
	public void saveByQueryMap(Map<String, String> queryMap) {
		if (queryMap == null || queryMap.size() == 0) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		goodsDao.saveByQueryMap(queryMap);
	}

	@Override
	public Goods uploadFile(MultipartFile file) throws IOException {
		if (file == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
		String fileNameToDate = dateFormat.format(new Date());
		String oldFileName = file.getOriginalFilename();
		String newFileName = fileNameToDate + oldFileName.substring(oldFileName.lastIndexOf("."));
		System.out.println(newFileName);
		if (!file.isEmpty()) {
			FileUtils.copyInputStreamToFile(file.getInputStream(),new File(uploadPath,newFileName));
		}
		String filePath = "static/images/goods/"+newFileName;
		Goods goods = new Goods();
		goods.setImagePath(filePath);
		return goods;
	}

	@Override
	public Goods getGoodsById(Long id) {
		Goods goods = goodsDao.getGoodsById(id);
		goods.setBrandsNames(brandService.getBrands());
		goods.setCategories(categoryService.getCategories());
		goods.setSecondCategories(categoryService.getCategoriesByParentId(goods.getCategoryParentId()));
		return goods;
	}

	@Override
	@Transactional
	public void editGoodsByQueryMap(Map<String, String> queryMap) {
		if (queryMap == null || queryMap.size() ==0) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		goodsDao.editGoodsByQueryMap(queryMap);
	}

}
