package com.ysdevelop.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.shop.entity.CartItem;
import com.ysdevelop.shop.mapper.CartItemDao;
import com.ysdevelop.shop.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemDao cartItemDao;

	@Override
	public void save(Long cartId, Long goodsId) {
		if (cartId == null || goodsId == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}

		CartItem cartItem = cartItemDao.getByCartId(cartId, goodsId);
		if (cartItem != null) {
			cartItem.setGoodsCount(cartItem.getGoodsCount() + 1);
			cartItemDao.updateCartItemGoodsCount(cartItem);
		} else {
			cartItem = new CartItem();
			cartItem.setCartId(cartId);
			cartItem.setGoodsId(goodsId);
			cartItemDao.save(cartItem);
		}

	}

	@Override
	public List<CartItem> listByCartId(Long cartId) {
		if (cartId == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		List<CartItem> cartItems = cartItemDao.listByCartId(cartId);

		return cartItems;
	}

	@Override
	public void updateStatusById(Long id) {
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		cartItemDao.updateStatusById(id);
	}

	@Override
	public void updateItemBatch(List<CartItem> items) {
		if (items == null || items.size() == 0) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}

		cartItemDao.updateBatchByList(items);

	}

}
