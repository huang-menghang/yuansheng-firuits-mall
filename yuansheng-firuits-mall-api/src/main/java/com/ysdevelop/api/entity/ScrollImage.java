package com.ysdevelop.api.entity;

import com.ysdevelop.common.entity.BaseEntity;

public class ScrollImage extends BaseEntity {

	private String name;
	// 图片地址
	private String imageHref;
	// 跳转地址
	private String imageUrl;

	private Integer sort;

	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageHref() {
		return imageHref;
	}

	public void setImageHref(String imageHref) {
		this.imageHref = imageHref;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
