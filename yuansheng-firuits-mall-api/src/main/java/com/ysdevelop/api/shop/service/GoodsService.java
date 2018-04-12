package com.ysdevelop.api.shop.service;

import java.util.List;

import com.ysdevelop.api.entity.Goods;

public interface GoodsService {

	List<Goods> listByQuery(Integer query);

	Goods getById(Long id);
}