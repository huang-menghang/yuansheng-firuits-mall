package com.ysdevelop.shop.entity;

import java.util.Date;

import com.ysdevelop.common.entity.BaseEntity;

public class Goods extends BaseEntity {

	private String name;

	private Double price;
	// 折扣价格
	private Double discoutPrice;

	private String standrds;
	
	private Double weight;
	
	private Integer packet;
	//保质期
	private Double storage;

	private Integer sort;
	// 销量
	private Long sales;

	private String description;

	private Long brandId;
	// 上市时间
	private Date launcTime;

	private String imagePath;
	
	private String brandName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscoutPrice() {
		return discoutPrice;
	}

	public void setDiscoutPrice(Double discoutPrice) {
		this.discoutPrice = discoutPrice;
	}
	

	public String getStandrds() {
		return standrds;
	}

	public void setStandrds(String standrds) {
		this.standrds = standrds;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getPacket() {
		return packet;
	}

	public void setPacket(Integer packet) {
		this.packet = packet;
	}

	public Double getStorage() {
		return storage;
	}

	public void setStorage(Double storage) {
		this.storage = storage;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Long getSales() {
		return sales;
	}

	public void setSales(Long sales) {
		this.sales = sales;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Date getLauncTime() {
		return launcTime;
	}

	public void setLauncTime(Date launcTime) {
		this.launcTime = launcTime;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	
}
