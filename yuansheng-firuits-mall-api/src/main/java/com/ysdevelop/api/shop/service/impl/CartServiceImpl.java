package com.ysdevelop.api.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.api.shop.mapper.CartDao;
import com.ysdevelop.api.shop.service.CartService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;

	@Override
	public void save(Long memberId) {
		if (memberId == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		if (cartDao.getByMemberId(memberId) == null) {
			cartDao.save(memberId);
		}
	}

}
