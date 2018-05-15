package com.ysdevelop.common.utils;

public class Constant {
	public static String MOBILE_MSG = "randomNumber";
	public static String TOKEN_NAME = "token";

	public static Integer DEFALUT_INTEGER_ZERO = 0;

	public static Integer DEFALUT_INTEGER_ONE = 1;

	/**
	 * 菜单类型
	 * 
	 * @author oldHuang
	 * @email
	 * @date
	 */
	public enum QueryType {
		/**
		 * 目录
		 */
		SALES(0),
		/**
		 * 菜单
		 */
		NEW(1),
		/**
		 * 按钮
		 */
		DISCOUT(2);

		private int value;

		private QueryType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	/**
	 * 订单状态
	 * 
	 * @author oldHuang
	 * @email
	 * @date
	 */
	public enum OrderType {
		/**
		 * 未支付
		 */
		UNPAY(0),
		/**
		 * 已支付
		 */
		PAY(1),
		/**
		 * 待收货
		 */
		UNRECEIVED(2),
		/**
		 * 完成
		 */
		FINISHED(3),
		/**
		 * 删除
		 */
		DESTORY(4);
		private int value;

		private OrderType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	/**
	 * 订单状态
	 * 
	 * @author oldHuang
	 * @email
	 * @date
	 */
	public enum RequestMethodType {
		/**
		 * get
		 */
		GET("GET"),
		/**
		 * post
		 */
		POST("POST"),
		/**
		 * put
		 */
		PUT("PUT"),
		/**
		 * delete
		 */
		DELETE("DELETE");
		
		private String value;

		private RequestMethodType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}
	/**
	 * 订单状态
	 * 
	 * @author oldHuang
	 * @email
	 * @date
	 */
	public enum PayType {
		/**
		 * 未支付
		 */
		ALIPAY(0),
		/**
		 * 已支付
		 */
		WECHAT(1);
		
	
		private int value;

		private PayType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}
}
