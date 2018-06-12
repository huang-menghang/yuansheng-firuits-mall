package com.ysdevelop.admin.entity;

import com.ysdevelop.common.entity.BaseEntity;

public class ActionLog extends BaseEntity{
	private String requstUrl;
	
	private String user;
	
	private String result;
	
	private String requestParams;
	
	private String exception;
	
	private String ip;
	
	private String osAndBrowser;
	
	private String requestMethod;
	
	private String requestControllerMethod;

	
	
	public String getIp() {
		return ip;
	}



	public void setIp(String ip) {
		this.ip = ip;
	}



	public String getOsAndBrowser() {
		return osAndBrowser;
	}



	public void setOsAndBrowser(String osAndBrowser) {
		this.osAndBrowser = osAndBrowser;
	}



	public String getRequestMethod() {
		return requestMethod;
	}


	
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}



	public String getRequestControllerMethod() {
		return requestControllerMethod;
	}




	public void setRequestControllerMethod(String requestControllerMethod) {
		this.requestControllerMethod = requestControllerMethod;
	}



	public String getRequstUrl() {
		return requstUrl;
	}

	
	
	public String getUser() {
		return user;
	}


	
	public void setUser(String user) {
		this.user = user;
	}


	
	public String getResult() {
		return result;
	}


	
	public void setResult(String result) {
		this.result = result;
	}


	public void setRequstUrl(String requstUrl) {
		this.requstUrl = requstUrl;
	}



	public String getException() {
		return exception;
	}



	public void setException(String exception) {
		this.exception = exception;
	}



	public String getRequestParams() {
		return requestParams;
	}


	public void setRequestParams(String requestParams) {
		this.requestParams = requestParams;
	}

}
