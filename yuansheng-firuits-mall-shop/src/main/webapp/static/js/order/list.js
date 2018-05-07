//订单页号
pageNum = 1;
//订单状态
orderStatus = 0;
//正在加载
isLoadMore = false;
var order_list_ops = {
	init:function(){
		this.getOrder();
		this.eventBind();
	},
	eventBind:function(){
		var that = this;
		$(".orderSift a").click(function(){
			$(this).addClass("currStyle").siblings("a").removeClass("currStyle");
		    pageNum = 1;
		    orderStatus=$(this).attr("status");
			that.getOrder();
		});
		$(".productList").click(function(){
			if(isLoadMore){
				common_ops.msg("正在加载");
				return ;
			}
			console.log(isLoadMore);
			isLoadMore = true;
			console.log(isLoadMore);
			that.getOrder();
		});
		$(".orderList").on("click",".order_payBtn",function(e){
			$that = $(e.target);
	    	var orderId = $that.attr("orderId");
			window.location.href = basePath+"order/confirm?orderId="+orderId;
		});
        $(".backIcon").click(function(){
        	window.location.href = basePath+"member/center";
        });
		
	},
	// 初始化定单
	getOrder:function(){
		$.ajax({
			url:basePath+"order/list/query",
			method:"GET",
			type:"text/json",
			data:{
				pageNum:pageNum,
				orderStatus:orderStatus
			},
			success:function(res){
				if(res.code == 0){
					var data = $.parseJSON(res.data);
					var orders = data.items;
					if(pageNum == 1){
					$(".orderList").empty();
					}
					$.each(orders,function(i,v){
						//找出它的条目
						var orderItems ="" ;
						var orderOps = "";
						if(orderStatus == 0){
							orderOps+= ("<dd>"+
							    "<a class='order_delBtn' orderId='"+v.id+"'>删除订单</a>"+
							    "<a class='order_payBtn' orderId='"+v.id+"'>付款</a>"+
							   "</dd>");
						}else{
						  orderOps+= ("<dd>"+
								    "<a class='order_delBtn' orderId='"+v.id+"'>删除订单</a>"+
								   "</dd>");
						}		
						$.each(v.orderItems,function(vi,vv){
							orderItems += ("<dd>"+
						    "<h2>"+vv.goodsName+"</h2>"+
						    "<strong>"+
						     "<em>"+vv.goodsTotalPrice+"</em>"+
						     "<span>"+vv.goodsCount+"</span>"+
						    "</strong>"+
						   "</dd>");

						});
						$(".orderList").append("<li>"+
						"<dl>"+
						   "<dt>"+
						    "<span>订单："+v.id+"</span>"+
						    "<span>代付款："+v.orderTotalPrice+"</span>"+
						   "</dt>"+ 
						    orderItems+
						    "<dd>"+
						    "<span>商品数量：<b>"+v.totalItemNo+"</b></span>"+
						    "<span>订单金额：<b>"+v.orderTotalPrice+"</b></span>"+ 
						    "<span>实付：<b>"+v.orderTotalPrice+"</b></span>"+
						   "</dd>"+ 
						   orderOps+
						  "</dl>"+
						"</li>");});
				       if(data.lastPage){
				    	   $(".productList").hide();
				       }else{
				    	   $(".productList").show();
				    	   pageNum++;
				       }
				       isLoadMore = false; 
					
				}	
				else{
					 isLoadMore = false; 
				}
			}
			
		});
		
	}
	
};
$(function(){
	order_list_ops.init();
});