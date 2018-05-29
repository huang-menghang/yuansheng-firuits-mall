package com.ysdevelop.admin.entity;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.ysdevelop.common.entity.BaseEntity;
import com.ysdevelop.common.validate.IsMobile;
import com.ysdevelop.common.validate.IsTelephone;

public class Member extends BaseEntity{
	@NotEmpty(message = "手机号码不能为空")
	@IsMobile
	private String mobile;
	@NotEmpty(message = "密码不能为空")
	@Size(max = 12, min = 6)
	private String password;

	private String restaurant;
	@NotEmpty(message = "姓名不能为空")
	@Size(min = 2)
	private String name;
	@NotEmpty(message = "电话号码不能为空")
	@IsTelephone
	private String telephone;
	@NotEmpty(message = "请选择省市")
	private String province;
	@NotEmpty(message = "请选择省市")
	private String city;
	private String town;
	@NotEmpty(message = "详细地址不能为空")
	private String detailAddress;
	
	private Integer status;

	
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	


		
	
	
}
