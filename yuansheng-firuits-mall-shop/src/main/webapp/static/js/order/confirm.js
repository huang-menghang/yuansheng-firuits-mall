var order_confirm_ops ={
	init:function(){
		this.initOrder();
		this.eventBind();
	},
	initOrder:function(){
		var orderNo = common_ops.g_getQueryString("orderId");
		$.ajax({
			url:basePath+"order/"+orderNo,
			method:"GET",
			type:"text/json",
			success:function(res){
				console.log(res);
				if(res.code == 0){
				  var order = res.data;		 
					$(".order-member-name").html("收货人:"+order.memberName);
					$(".order-member-telephone").html(order.memberMobile);
					var orderAddress;
					if(order.memberDist != null){
						orderAddress = order.memberProvince+""+order.memberCity+""+order.memberDist+""+order.orderDetailAddress;
					}else{
						orderAddress = order.memberProvince+""+order.memberCity+""+order.orderDetailAddress;
					}
					$(".confirmAddr address").html(orderAddress);
					$(".order-total-price").html("合计：￥"+order.orderTotalPrice);	
				}
			}
		});
		
		
		
	},
	eventBind:function(){
		$(".payment dd label input[type='radio']").click(function(){
			$(this).parent().addClass("isTrue");
			$(this).parent().siblings().removeClass("isTrue");
		});
		
		$(".confirmAddr a").click(function(){
			window.location.href = basePath+"order/newAddress?orderId="+common_ops.g_getQueryString("orderId");
		})
	}
}
$(function(){
	order_confirm_ops.init();
})