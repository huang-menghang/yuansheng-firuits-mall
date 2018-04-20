package com.ysdevelop.shop.service;

import java.util.List;
import java.util.Map;

import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.shop.entity.Goods;

public interface GoodsService {

	List<Goods> listByQuery(Integer query);

	Goods getById(Long id);

	Pagination<Goods> pagination(Map<String, Object> queryMap, Pagination<Goods> pagination);
}