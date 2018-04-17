package com.ysdevelop.shop.service;

import java.util.List;

import com.ysdevelop.shop.entity.Goods;


public interface GoodsService {

	List<Goods> listByQuery(Integer query);

	Goods getById(Long id);
}