package com.ysdevelop.api.entity;

import com.ysdevelop.common.entity.BaseEntity;
/**
 * 
 * @author OldHuang
 *
 * @Package com.ysdevelop.api.entity
 *
 * @Description: 会员信息实体
 *
 * @date 2018年4月3日
 * 
 * @version 
 *
 */
public class Member extends BaseEntity{

	private String mobile;
	
	private String password;
	
    private String restaurant;
    
    private String name;
    
    private String telephone;
    
    private String detailAddress;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
    
    
	
	
	
	
}
