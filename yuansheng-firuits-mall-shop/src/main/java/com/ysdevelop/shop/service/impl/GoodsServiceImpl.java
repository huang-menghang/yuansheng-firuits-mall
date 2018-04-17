package com.ysdevelop.shop.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;
import com.ysdevelop.shop.entity.Goods;
import com.ysdevelop.shop.mapper.GoodsDao;
import com.ysdevelop.shop.service.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public List<Goods> listByQuery(Integer query) {
		if(query !=Constant.QueryType.SALES.getValue() && query != Constant.QueryType.NEW.getValue() && query != Constant.QueryType.DISCOUT.getValue()){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		
		return goodsDao.listByQuery(query);
	}

	@Override
	public Goods getById(Long id) {
		if(id==null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		return goodsDao.getById(id);
	}

}