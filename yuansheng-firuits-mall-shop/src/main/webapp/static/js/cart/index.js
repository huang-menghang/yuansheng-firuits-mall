var cart_index_ops = {
		init:function(){
			this.initCart();
		},
		eventBind:function(){
			isEdit = true;
			var dd_doms = $(".cart dd");
			var that = this;
			$(".edit").click(function(){
				if(isEdit){
					$(this).parent().siblings("dd").find(".delBtn").fadeIn();
					  dd_doms.each(
						function(){
							$(this).find(".number").val($(this).find(".itemProduct").html()); 
						}	  
					  );
					  $(this).html("完成");
					  $(".numberWidget").show();
					  $(".priceArea").hide();
					  $(".check_item").hide();
					  isEdit = false;
				}else{
					  $(this).parent().siblings("dd").find(".delBtn").fadeOut();
					  $(this).html("编辑");
					  $(".numberWidget").hide();
					  $(".priceArea").show();
					  $(".check_item").show();
					  isEdit = true;
				}
			});
			//加操作
			$(".minus").click(function(){
			  var goodsCountInput = $(this).siblings(".number");
				if(goodsCountInput.val() <= 1){
					return ;
				}
				else{
					goodsCountInput.val(goodsCountInput.val()-1);
				}
			});
			//减操作
			$(".plus").click(function(){
		    var goodsCountInput = $(this).siblings(".number");	
			goodsCountInput.val(parseInt(goodsCountInput.val())+1);
			});
			//删除操作
			$(".delBtn").click(function(){
				//发送请求到接口,服务器修改数据
			   $(this).parent().remove();
			   that.calculatePrice();
			   that.nullTips();
			});
			
			
		},
		calculatePrice:function(){
			var dom_dd = $(".cart-show").find("dd");
			var total_price = 0.0;
			dom_dd.each(function(i,v){
			 	if($(v).find("input[type='checkbox']").prop('checked')){
			 		var goods_price = $(v).find('.number').val();
			 		var goods_count = $(v).find('.productPrice').html();
			 	    total_price	= goods_price*goods_count+total_price;	
			 	};
			});
		$(".a_total_price").html("合计：￥ "+total_price);
		},
		nullTips:function(){
			if($(".cart").find("dd").size() == 0){
				common_ops.msg("购物车被清空",function(){
					$(".cart-show").hide();
					$(".cart-empty").show();
				});
			}
		},
		initCart:function(){
			var cartId ;
		    var that = this;
			$.ajax({
				url:basePath+"cart/info",
				method:"GET",
				type:"text/json",
				success:function(res){
					if(res.code == 0){
						var result = $.parseJSON(res.data);
						console.log(result.isEmpty);
						if(result.isEmpty){
							$(".cart-show").hide();
						}else{					
        					$(".cart-empty").hide();
        					$(".cart dd").empty();
        					$.each(result.cartItems,function(i,v){
        						$(".cart").append("<dd> <input type='checkbox' class='check_item'/>"+
             "<a href='"+basePath+"goods/"+v.goodsId+"' class='goodsPic'> <img src='"+basePath+v.goodsImagePath+"'/></a>"+  
             "<div class='goodsInfor'>"+
             "<h2>"+
             "<a href='"+basePath+"goods/"+v.goodsId+"' >"+v.goodsName+"</a>"+
             "<span class='itemProduct'>"+v.goodsCount+"</span>"+
             "</h2>"+
             "<div class='priceArea' >"+
             "<strong class='productPrice'>"+v.goodsDiscoutPrice+"</strong>"+
             "<del>"+v.goodsPrice+"</del>"+
             "</div>"+
             "<div class='numberWidget'>"+
             "<input type='button' value='-' class='minus'/>"+
             "<input type='text' value='"+v.goodsCount+"' disabled  class='number'/>"+
             "<input type='button' value='+'  class='plus'/>"+
             "</div>"+
             "</div>"+
             "<a class='delBtn' productId='"+v.goodsId+"' itemId='' itemPrice='"+v.goodsTotalPrice+"'>删除</a>"+
             "</dd>");
        					});
        					$("dd input[type='checkbox']").prop("checked",true); 
        					that.calculatePrice();
        					//$(".a_total_price").html("合计：￥ "+result.totalPrice);
        					
        				    //些点击事件..	
        					that.eventBind();
        					
						}
					}
				}
			})
		}
		
}

$(function(){
	cart_index_ops.init();
	
})