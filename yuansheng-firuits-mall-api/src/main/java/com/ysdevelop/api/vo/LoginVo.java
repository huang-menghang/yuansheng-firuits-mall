package com.ysdevelop.api.vo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.ysdevelop.common.validate.IsMobile;

public class LoginVo {
	private Long id;
	@NotEmpty(message = "手机号码不能为空")
	@IsMobile
	private String mobile;
	@NotEmpty(message = "密码不能为空")
	@Size(min = 6, max = 64, message = "密码长度必须在6到64之间")
	private String password;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

}
