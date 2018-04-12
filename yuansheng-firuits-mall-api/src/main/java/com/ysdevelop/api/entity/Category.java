package com.ysdevelop.api.entity;

import com.ysdevelop.common.entity.BaseEntity;

/**
 * 
 * @author OldHuang
 * 
 * @Package com.ysdevelop.api.entity
 * 
 * @Description: 首页分类
 * 
 * @date 2018年4月11日
 * 
 * @version
 * 
 */
public class Category extends BaseEntity {

	private String name;

	private String imagePath;

	private String remark;

	private Integer sort;

    private String description;
    
    private Long parentId;
    
    private Integer level;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
    
	
    


}
