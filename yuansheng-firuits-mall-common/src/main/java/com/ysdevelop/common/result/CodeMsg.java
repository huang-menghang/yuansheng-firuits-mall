package com.ysdevelop.common.result;

public class CodeMsg {
	private int code;
	private String msg;

	private CodeMsg() {

	}

	// 通用的错误码
	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");

	// 用户
	public static CodeMsg MOBILE_EMPTY = new CodeMsg(500001,"手机号码为空");
	public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500002,"密码为空");
	public static CodeMsg PASSWORD_WRONG =  new CodeMsg(500003,"密码错误");
	public static CodeMsg MOBILE_EXIST =  new CodeMsg(500004,"手机号码已经注册");
	public static CodeMsg PASSWORD_CONFIRM =  new CodeMsg(500005,"两次密码输入不一致");
	public static CodeMsg MESSAGE_CODE_WRONG =  new CodeMsg(500006,"手机验证码错误");
	public static CodeMsg MEMBER_WRONG =  new CodeMsg(500007,"手机号码不存在");
	public static CodeMsg MEMBER_UNLOGIN = new CodeMsg(500008, "用户未登录");
	public static CodeMsg OLDPASSWORD_WRONG =  new CodeMsg(500009,"旧密码输入错误");
	public static CodeMsg NEWOLDPASSWOR_SAME =  new CodeMsg(500010,"新旧密码一致");
	
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
