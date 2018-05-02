var cart_index_ops = {
		init:function(){
			this.initCart();
		},
		eventBind:function(){
			isEdit = true;
			var dd_doms = $(".cart dd");
			var that = this;
			$("#check_all").prop("checked",true);
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
					  var dom_dd = $(".cart-show").find("dd");
					  //找出需要去数据更新数量的条目
					  var items = [];
					  dom_dd.each(function(i,v){
						  var num_dom = $(v).find(".number");
						  var item_count = num_dom.val();
						  if(num_dom.attr("goodsCount")!=item_count){
							  var item_id = num_dom.attr("itemId");
							  var item = new Object();
							  item.id= item_id;
							  item.goodsCount= item_count;
							  items.push(item);
						  };
					  });
					  if(items.length > 0){
					  $.ajax({
						  url:basePath+"cartItem/batch",
						  method:"PUT",
						  type:"text/json",
						  contentType:"application/json",
						  dataType:'json',
						  data:JSON.stringify(items),
						  success:function(res){
							  console.log(res.msg);
						  }
						  
					  });
					  }
					  //处理价格问题,修改界面以及数据库		  
					  isEdit = true;
				}
			});
			//减操作
			$(".minus").click(function(){
			  var goodsCountInput = $(this).siblings(".number");
				if(goodsCountInput.val() <= 1){
					return ;
				}
				else{
					goodsCountInput.val(goodsCountInput.val()-1);
					$(this).parent().siblings("h2").find(".itemProduct").html(goodsCountInput.val());
				}
				that.calculatePrice();
			});
			//加操作
			$(".plus").click(function(){
		    var goodsCountInput = $(this).siblings(".number");	
			goodsCountInput.val(parseInt(goodsCountInput.val())+1);
			$(this).parent().siblings("h2").find(".itemProduct").html(goodsCountInput.val());
			that.calculatePrice();
			});
			//删除操作
			$(".delBtn").click(function(){
				//发送请求到接口,服务器修改数据
			   $(this).parent().remove();
			   $that = $(this);
			   $.ajax({
				   url:basePath+"cartItem/"+$that.attr("itemId"),
				   method:'post',
				   data:{_method:'delete'},
				   type:"text/json",
				   success:function(res){
					   if(res.code == 0){
						   that.calculatePrice();
						   that.nullTips();
					   }
				   }
			   })
			 
			}); 
			$(".check_item").change(function(){
				that.calculatePrice();
			});
		    
			 $("#check_all").click(
				function(){
				var is_check=$(this).prop("checked"); 
				if(is_check == false){
					$(".check_item").prop("checked",false); 
				}else{
					$(".check_item").prop("checked",true); 
					
				}
				that.calculatePrice();
				}	  
			  );
			 //添加订单
			 $(".a_confirm_order").click(function(){
				 var ids = [];
				 var dd_doms = $(".check_item:checked");
				 $.each(dd_doms,function(i,v){
					 ids.push($(v).attr("itemId"));
				 });

				 $.ajax({
					 url:basePath+"order/add",
					 data:{ids:ids},
					 method:"POST",
					 type:"text/json",
					 success:function(res){
						var callback = null;
						var msg = null
					    if(res.code == 0){
					    	callback = function(){
					    		window.location.href = basePath+"order/confirm?orderId="+res.data;
					    	};
					    	msg = "订单生成成功";
					    }else{
					    	msg = res.msg;
					    }
					    common_ops.msg(msg,callback);
					    
					 }
				 })
//				 
//				 window.location.href = basePath+"order/confirm";
			 });
		},
		calculatePrice:function(){
			var dom_dd = $(".cart-show").find("dd");
			var total_price =Number(0);
			var checkItemCount = 0;
			var itemCount = 0;
			dom_dd.each(function(i,v){
				itemCount++;
			 	if($(v).find("input[type='checkbox']").prop('checked')){
			 		checkItemCount++;
			 		var goods_price =Number($(v).find('.number').val());
			 		var goods_count = Number($(v).find('.productPrice').html());
			 	    total_price = goods_price.mul(goods_count).add(total_price);
			 	};
			});
			if(checkItemCount == itemCount){
				$("#check_all").prop("checked",true);
			}else{
				$("#check_all").prop("checked",false);
			}
		    $(".a_total_price").html("合计：￥ "+total_price.toFixed(2));
		    if(checkItemCount == 0){
			   $(".a_confirm_order").css("background","grey");
		    }else{
			   $(".a_confirm_order").css("background","#64ab5b");
		    }
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
        						$(".cart").append("<dd> <input type='checkbox' itemId='"+v.id+"' class='check_item'/>"+
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
             "<input type='text' itemId='"+v.id+"' goodsCount='"+v.goodsCount+"' value='"+v.goodsCount+"' disabled  class='number'/>"+
             "<input type='button' value='+'  class='plus'/>"+
             "</div>"+
             "</div>"+
             "<a class='delBtn' productId='"+v.goodsId+"' itemId='"+v.id+"' itemPrice='"+v.goodsTotalPrice+"'>删除</a>"+
             "</dd>");
        					});
        					$("dd input[type='checkbox']").prop("checked",true); 
        					that.calculatePrice();			
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