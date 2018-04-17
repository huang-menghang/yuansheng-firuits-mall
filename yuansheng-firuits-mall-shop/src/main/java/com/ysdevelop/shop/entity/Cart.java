package com.ysdevelop.shop.entity;

import java.math.BigDecimal;
import java.util.List;

import com.ysdevelop.common.entity.BaseEntity;
import com.ysdevelop.common.utils.NumberArithmeticUtils;

public class Cart extends BaseEntity {

	private Long memberId;
	private List<CartItem> cartItems;
	private Double totalPrice = 0.0;
	private Integer totalItemCount;
	// 购物车中的总的商品数
	private Integer totalItemNo = 0;
	// 是否为空
	@SuppressWarnings("unused")
	private Boolean isEmpty;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Double getTotalPrice() {
		BigDecimal totalPrice = new BigDecimal(this.totalPrice);
		for (CartItem cartItem : cartItems) {
			totalPrice = NumberArithmeticUtils.safeAdd(totalPrice, new BigDecimal(cartItem.getGoodsTotalPrice()));
		}
		return totalPrice.doubleValue();
	}

	public Integer getTotalItemCount() {
		return totalItemCount;
	}

	public void setTotalItemCount(Integer totalItemCount) {
		this.totalItemCount = totalItemCount;
	}

	public Integer getTotalItemNo() {
		for (CartItem cartItem : cartItems) {
			totalItemNo = cartItem.getGoodsCount() + totalItemNo;
		}
		return totalItemNo;
	}

	public Boolean getIsEmpty() {
		return this.isEmpty = getTotalItemNo() == 0 ? true : false;
	}

}
