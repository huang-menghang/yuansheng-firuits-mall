package com.ysdevelop.shop.entity;

import com.ysdevelop.common.entity.BaseEntity;

public class CartItem extends BaseEntity {

	private Long goodsId;
	
	private String goodsName;

	private Integer goodsCount;

	private Double goodsTotalPrice;

	private Double goodsPrice;
	// 折扣价格
	private Double goodsDiscoutPrice;
	
	private String goodsImagePath;

	private Long cartId;
	// 表示是否被删除或则是已经被清空(不买了或则买完了)
	private Integer status;

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

    
	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Double getGoodsDiscoutPrice() {
		return goodsDiscoutPrice;
	}

	public void setGoodsDiscoutPrice(Double goodsDiscoutPrice) {
		this.goodsDiscoutPrice = goodsDiscoutPrice;
	}

	public Double getGoodsTotalPrice() {
		return goodsTotalPrice;
	}

	public void setGoodsTotalPrice(Double goodsTotalPrice) {
		this.goodsTotalPrice = goodsTotalPrice;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getGoodsImagePath() {
		return goodsImagePath;
	}

	public void setGoodsImagePath(String goodsImagePath) {
		this.goodsImagePath = goodsImagePath;
	}

}
