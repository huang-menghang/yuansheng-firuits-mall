package com.ysdevelop.pay.alipay.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.pay.alipay.config.AlipayConfig;

@Controller
@RequestMapping("/alipay")
public class AlipayController {

	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> pay(ModelMap map, HttpServletRequest request) {
		System.out.println("开始支付");
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, "json", AlipayConfig.CHARSET,
				AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);
		// 设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);

		// 商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = request.getParameter("orderId");
		// 订单名称，必填
		String subject = "消费金额" + request.getParameter("totalPrice");
		// 付款金额，必填
		String total_amount = request.getParameter("totalPrice");

		// 封装请求支付信息
		AlipayTradePagePayModel model = new AlipayTradePagePayModel();
		model.setOutTradeNo(out_trade_no);
		model.setSubject(subject);
		model.setTotalAmount(total_amount);
		model.setTimeoutExpress("");
		// 销售产品码 必填
		model.setProductCode("FAST_INSTANT_TRADE_PAY");
		alipayRequest.setBizModel(model);
		// 调用SDK生成表单
		String form = null;
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			throw new WebServiceException(CodeMsg.PAY_ERROR);
		}
		System.out.println(form);
		return Result.successData(form);
	}
}
