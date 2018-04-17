package com.ysdevelop.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.shop.entity.Goods;

public interface GoodsDao {
	List<Goods> listByQuery(@Param(value = "queryId") Integer queryId);

	Goods getById(Long id);
}
