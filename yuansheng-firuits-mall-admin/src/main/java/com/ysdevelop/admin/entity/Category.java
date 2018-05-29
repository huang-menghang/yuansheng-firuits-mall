package com.ysdevelop.admin.entity;

import com.ysdevelop.common.entity.BaseEntity;

public class Category extends BaseEntity{

	private String imagePath;
	
	private String name;

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
