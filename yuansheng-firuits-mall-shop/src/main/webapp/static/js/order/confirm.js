var order_confirm_ops = {
	init : function() {
		this.initOrder();
		this.eventBind();
	},
	initOrder : function() {
		var orderNo = common_ops.g_getQueryString("orderId");
		$.ajax({
			url : basePath + "order/" + orderNo,
			method : "GET",
			type : "text/json",
			success : function(res) {
				console.log(res);
				if (res.code == 0) {
					var order = res.data;
					$(".order-member-name").html("收货人:" + order.memberName);
					$(".order-member-telephone").html(order.memberMobile);
					var orderAddress;
					if (order.memberDist != null) {
						orderAddress = order.memberProvince + ""
								+ order.memberCity + "" + order.memberDist + ""
								+ order.orderDetailAddress;
					} else {
						orderAddress = order.memberProvince + ""
								+ order.memberCity + ""
								+ order.orderDetailAddress;
					}
					$(".confirmAddr address").html(orderAddress);
					$(".btmNav .pay").attr("orderId", orderNo);
					$(".order-total-price")
							.html("合计：￥" + order.orderTotalPrice).attr(
									"total-price", order.orderTotalPrice);
				}
			}
		});

	},
	eventBind : function() {
		$(".payment dd label input[type='radio']").click(function() {
			$(this).parent().addClass("isTrue");
			$(this).parent().siblings().removeClass("isTrue");
		});

		$(".confirmAddr a").click(
				function() {
					window.location.href = basePath
							+ "order/newAddress?orderId="
							+ common_ops.g_getQueryString("orderId");
				});

		$(".backIcon").click(function() {
			window.location.href = basePath + "order/list";
		});

		$(".btmNav .pay").click(
				function() {
					$that = $(this);
					var pay_method = $("input[name='pay']:checked").val();
					if (pay_method == null) {
						common_ops.msg("请选择支付方式", null);
						return;
					}
					if (pay_method == "ali-pay") {
						$.ajax({
							url : basePath + "alipay/pay",
							method : "POST",
							type : "text/json",
							data : {
								orderId : $that.attr("orderId"),
								totalPrice :0.01
							},
							success : function(res) {
								if(res.code == 0){
								 document.write(res.data);
								}
							}

						})
					} else {
						common_ops.msg("暂不支持微信支付,请选择支付宝", null);
					}

				});
	}
}
$(function() {
	order_confirm_ops.init();
})