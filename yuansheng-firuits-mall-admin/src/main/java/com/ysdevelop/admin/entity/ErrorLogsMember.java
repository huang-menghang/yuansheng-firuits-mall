package com.ysdevelop.admin.entity;

import com.ysdevelop.common.entity.BaseEntity;

public class ErrorLogsMember extends BaseEntity{
	
	
	private String ip;
	
	private String osAndbroswer;
	
	private String requestUrl;
	
	private String requestMethod;
	
	private String requestParmater;
	
	private String exceptionMessage;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOsAndbroswer() {
		return osAndbroswer;
	}

	public void setOsAndbroswer(String osAndbroswer) {
		this.osAndbroswer = osAndbroswer;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getRequestParmater() {
		return requestParmater;
	}

	public void setRequestParmater(String requestParmater) {
		this.requestParmater = requestParmater;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}
