package com.ysdevelop.admin.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ysdevelop.admin.entity.Goods;
import com.ysdevelop.common.page.Pagination;

public interface GoodsService {

	void paginationByQueryMap(Pagination<Goods> pagination, Map<String, String> queryMap);

	void updateStatusById(Long id);

	void deleteBatchByIds(List<Long> ids);

	Goods getInfoById(Long id);

	Goods getBrandsAndCategories();

	Goods getCategoriesByParentId(Long id);

	void saveByQueryMap(Map<String, String> queryMap);

	Goods uploadFile(MultipartFile file) throws IOException;

	Goods getGoodsById(Long id);

	void editGoodsByQueryMap(Map<String, String> queryMap);

}
