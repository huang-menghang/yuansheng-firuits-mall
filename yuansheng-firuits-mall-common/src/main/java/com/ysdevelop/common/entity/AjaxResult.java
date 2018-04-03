package com.ysdevelop.common.entity;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class AjaxResult {
	private boolean success = true;
	private String msg = "操作成功";
	private Object obj = null;
	//错误码(0,表示成功,其它状态说明有异常)
	private Integer code;
	private Map<String, Object> attributes;

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getJsonStr() {
		JSONObject obj = new JSONObject();
		obj.put("success", this.success);
		obj.put("msg", this.getMsg());
		obj.put("obj", this.obj);
		obj.put("attributes", this.attributes);
		return obj.toString();
	}

}
