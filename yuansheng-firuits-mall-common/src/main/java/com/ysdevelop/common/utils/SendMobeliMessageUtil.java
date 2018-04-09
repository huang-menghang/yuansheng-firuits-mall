package com.ysdevelop.common.utils;

import com.alibaba.fastjson.JSONObject;

public class SendMobeliMessageUtil {

	private static String URL = String.format(ResourceUtil.getInstance().getConfigByName("sms.request.url"), "sendsms");

	private static String SID = ResourceUtil.getInstance().getConfigByName("sms.sid");

	private static String TOKEN = ResourceUtil.getInstance().getConfigByName("sms.token");

	private static String APPID = ResourceUtil.getInstance().getConfigByName("sms.appid");

	private static String TEMPLATE_ID = ResourceUtil.getInstance().getConfigByName("sms.template.id");

	public static String sendSms(String param, String mobile, String uid) {

		String result = "";
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", SID);
			jsonObject.put("token", TOKEN);
			jsonObject.put("appid", APPID);
			jsonObject.put("templateid", TEMPLATE_ID);
			jsonObject.put("param", param);
			jsonObject.put("mobile", mobile);
			jsonObject.put("uid", uid);

			String body = jsonObject.toJSONString();

			System.out.println("body = " + body);

			result = HttpUtils.postJson(URL, body, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
