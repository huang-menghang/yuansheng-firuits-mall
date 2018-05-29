package com.ysdevelop.admin.entity;

import com.ysdevelop.common.entity.BaseEntity;

public class Brand extends BaseEntity {
	
	private String name;

	private String description;
	
	private Integer status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
