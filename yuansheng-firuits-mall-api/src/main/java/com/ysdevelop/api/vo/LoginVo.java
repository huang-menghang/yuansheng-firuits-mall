package com.ysdevelop.api.vo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.ysdevelop.common.validate.IsMobile;

public class LoginVo {
	@NotEmpty(message = "手机号码不能为空")
	@IsMobile
	private String mobile;
	@NotEmpty(message = "密码不能为空")
	@Size(min = 6, max = 12, message = "密码长度必须在6到12之间")
	private String password;

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
