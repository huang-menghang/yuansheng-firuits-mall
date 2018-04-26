package com.ysdevelop.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.shop.mapper.GoodsFavDao;
import com.ysdevelop.shop.service.GoodsFavService;
@Service
public class GoodsFavServiceImpl implements GoodsFavService {

	@Autowired
	private GoodsFavDao goodsFavDao;
	
	
	@Override
	public Integer save(Long memberId, Long goodsId) {
         if(memberId == null || goodsId == null){
        	 throw new WebServiceException(CodeMsg.SERVER_ERROR);
         }
		return goodsFavDao.save(memberId, goodsId);
	}
	

}
