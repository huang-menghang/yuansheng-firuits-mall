package com.ysdevelop.common.exception;

import com.ysdevelop.common.result.CodeMsg;

public class WebServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7147069598126673797L;

	private CodeMsg codeMsg;

	public WebServiceException(CodeMsg codeMsg) {
		super(codeMsg.getMsg());
		this.codeMsg = codeMsg;
	}

	public CodeMsg getCm() {
		return codeMsg;
	}

}
