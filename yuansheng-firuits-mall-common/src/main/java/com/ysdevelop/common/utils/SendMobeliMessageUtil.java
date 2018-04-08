package com.ysdevelop.common.utils;

import com.alibaba.fastjson.JSONObject;

public class SendMobeliMessageUtil {

	
	@SuppressWarnings("static-access")
	public static String sendSms(String sid, String token, String appid, String templateid, String param, String mobile, 
			String uid) {
		
		String result = "";
		
		try {
			String url = String.format(ResourceUtil.getInstance().getConfigByName("sms.request.url"),"sendsms");
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", sid);
			jsonObject.put("token", token);
			jsonObject.put("appid", appid);
			jsonObject.put("templateid", templateid);
			jsonObject.put("param", param);
			jsonObject.put("mobile", mobile);
			jsonObject.put("uid", uid);
			
			String body = jsonObject.toJSONString();
			
			System.out.println("body = " + body);
			
			result = HttpUtils.postJson(url, body, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
