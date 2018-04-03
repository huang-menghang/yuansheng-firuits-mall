package com.ysdevelop.common.result;

public class CodeMsg {
	private int code;
	private String msg;

	private CodeMsg() {

	}

	// 通用的错误码
	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	// 用户
	public static CodeMsg MOBILE_EMPTY = new CodeMsg(500001,"手机号码为空");
	public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500002,"密码为空");
	public static CodeMsg PASSWORD_WRONG =  new CodeMsg(500003,"密码错误");
	private CodeMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public CodeMsg fillArgs(Object... args) {
		Integer code = this.code;
		String message = String.format(this.msg, args);
		return new CodeMsg(code, message);
	}

}
