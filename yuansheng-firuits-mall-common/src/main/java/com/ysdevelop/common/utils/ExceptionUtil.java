package com.ysdevelop.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 
 * @author Admin
 * 
 * @Package com.ysdevelop.cms.util
 * 
 * @Description: 错误信息统一处理类
 * 
 * @date 2017年10月26日
 * 
 * @version
 * 
 */

public class ExceptionUtil {
	/**
	 * 返回错误信息字符串
	 * 
	 * @param ex
	 *            Exception
	 * @return 错误信息字符串
	 */
	public static String getExceptionMessage(Exception ex) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		return sw.toString();
	}
}
