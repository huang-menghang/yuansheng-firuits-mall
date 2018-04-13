package com.ysdevelop.api.entity;

import java.util.List;

import com.ysdevelop.common.entity.BaseEntity;

public class Cart extends BaseEntity {

	private Long userId;
	private List<CartItem> cartItems;
	private Double totalPrice;
	private Integer totalItemCount;
	// 购物车中的总的商品数
	private Integer totalItemNo = 0;
	// 是否为空
	private Boolean isEmpty;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getTotalItemCount() {
		return totalItemCount;
	}
	public void setTotalItemCount(Integer totalItemCount) {
		this.totalItemCount = totalItemCount;
	}
	public Integer getTotalItemNo() {
		return totalItemNo;
	}
	public void setTotalItemNo(Integer totalItemNo) {
		this.totalItemNo = totalItemNo;
	}
	public Boolean getIsEmpty() {
		return isEmpty;
	}
	public void setIsEmpty(Boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	
	
	
	

}
