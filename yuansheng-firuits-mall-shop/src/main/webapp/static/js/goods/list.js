pageNum = 1;
price_sort = 0;// 1升序,-1降序
sale_sort = 0;// 1升序,-1降序
brand_id = 0;
var goods_list_ops = {
		init:function(){
			this.initGoods();
			this.initBrand();
			this.eventLoadMoreBind();
			this.initCartGoodsCount();
			this.eventBind();
		},
		initGoods:function(){
			this.getGoods();			
		},
		eventBind:function(){
			//价格排序
			var that = this;
			$("#a_productPrice").click(function(){
			  sale_sort = 0;
			  brand_id = 0;
			  var sale_sort_class = ($(this).attr("class")=="des_icon"?"asc_icon":"des_icon");
			  price_sort = ($(this).attr("class")=="des_icon"?1:-1);
			  pageNum = 1;
			  that.getGoods();
			  $(this).attr("class",sale_sort_class);
			});
			//销量排序
		    $("#a_productSales").click(function(){
		    	 price_sort = 0;
		    	 brand_id = 0;
				 var sale_sort_class = ($(this).attr("class")=="des_icon"?"asc_icon":"des_icon");
		    	 sale_sort = ($(this).attr("class")=="des_icon"?1:-1);
				 pageNum = 1;
				 that.getGoods();
				 $(this).attr("class",sale_sort_class);
		    });
		    //利用事件委托对动态加载商品做加入购物车事件的操作
		    $("#ul_productList").on("click",".addToCart",function(e){
		    	$that = $(e.target);
		    	var goodsId = $that.attr("productId");
		    	//console.log($(e.target).attr("productId"));
		    	$.ajax({
               	 url:basePath+"cartItem/",
               	 method:'POST',
               	 type:'text/json',
               	 data:{goodsId:goodsId},
               	 success:function(res){
               		 console.log(res.code);
               		 if(res.code == 0){
               			 that.cartFlyAnimation($that);
               		 }else if(res.code == 500008){
               			 common_ops.msg(res.msg, function(){
               				 window.location.href = basePath+"member/login?rurl="+window.location.href;
               			 });
               		 }else{
               		 common_ops.msg(res.msg);
               		 }
               	 },
               	 error:function(){
               		 
               	 }
                });
		    	
		    });
		    $(".drop_list").on("click","a",function(e){
		    	$that = $(e.target);
		    	price_sort = 0;// 1升序,-1降序
		    	sale_sort = 0;// 1升序,-1降序
		    	brand_id = $that.parent().val();
		    	pageNum=1;
		    	that.getGoods();
		    	$(".drop_list").toggle();
		    });
		},
		initBrand:function(){
			var categoryId = common_ops.g_getQueryString("categoryId");
			var categorySupId = common_ops.g_getQueryString("categorySupId");
			var query = common_ops.g_getQueryString("query");
			if(query == undefined){
				query = "";
			}
			var url = basePath+"brand/query?categoryId="+categoryId+"&categorySupId="+categorySupId+"&query="+query+"&pageNum="+pageNum;
			$.ajax({
				url:url,
				type:"text/json",
				method:"GET",
				success:function(res){
				   if(res.code == 0){
					   var data = $.parseJSON(res.data);
					   $(".drop_list").empty();
					   $.each(data,function(i,v){
						   $(".drop_list").append("<li value='"+v.id+"' ><a>"+v.name+"</a></li>");
					   });   
				   }	
				}
			});
			$(".drop_icon").click(function() {
				$(".drop_list").toggle();
			});
		},
		initCartGoodsCount:function(){
			$.ajax({
				url:basePath+"cart/countGoods",
				type:"text/json",
				method:"GET",
				success:function(res){
					console.log(res);
					if(res.code == 0){
						$(".hoverCart a").html(res.data);
					}
					else{
						$(".hoverCart a").html(0);
					}
				}
			});
		},
		cartFlyAnimation:function(cart){
			$(".hoverCart a").html(
					parseInt($(
							".hoverCart a")
							.html()) + 1);/* 测试+1 */
			var shopOffset = $(".hoverCart")
					.offset();
			var cloneDiv =cart.parent()
					.siblings(".goodsPic")
					.clone();
			var proOffset = cart
					.parent().siblings(
							".goodsPic")
					.offset();
			cloneDiv.css({
				"position" : "absolute",
				"top" : proOffset.top,
				"left" : proOffset.left
			});
			cart.parent().siblings(
					".goodsPic").parent()
					.append(cloneDiv);
			cloneDiv.animate({
				width : 0,
				height : 0,
				left : shopOffset.left,
				top : shopOffset.top,
				opacity : 1
			}, "slow");
		},
		getGoods:function(){
			var categoryId = common_ops.g_getQueryString("categoryId");
			var categorySupId = common_ops.g_getQueryString("categorySupId");
			var query = common_ops.g_getQueryString("query");
			if(query == undefined){
				query = "";
			}
			var url = basePath+"goods/query?categoryId="+categoryId+"&categorySupId="+categorySupId+"&query="+query+"&brandId="+brand_id+"&pageNum="+pageNum;
			if(price_sort!=0){
				url = url+"&priceSort="+price_sort;
			}
			if(sale_sort!=0){
				url = url+"&saleSort="+sale_sort;
			}
			$.ajax({
				url:url,
				method:"GET",
				type:"text/json",
				success:function(res){
					if(res.code == 0){
						var data = $.parseJSON(res.data);
						if(data.items.length > 0){
							$(".goods-empty").hide();
							if(pageNum == 1){
							$("#ul_productList").empty();
							}
							$.each(data.items,function(i,v){
								$("#ul_productList").append("<li><a href='"+basePath+"goods/"+v.id+"'"+
									" class='goodsPic'> <img src='"+basePath+v.imagePath+"' />"+
									"</a>"+
										"<div class='goodsInfor'>"+
											"<h2>"+
										    "<a href='"+basePath+"goods/"+v.id+"'>"+v.name+"</a>"+
											"</h2>"+
											"<p>"+
											"<del>"+v.price+"</del>"+
											"</p>"+
											"<p>"+
											"<strong class='price'>"+v.discoutPrice+"</strong>"+
											"</p>"+
											"<a class='addToCart' productId='"+v.id+"' >&#126;</a>"+
										"</div>"+
								    "</li>");
							});	
							if(data.lastPage){
								$("#a_more_btn").hide();
							}else{
								$("#a_more_btn").show();
								pageNum++;						
							}					
						}else{
							$(".goods").hide();
							$(".goods-empty").show();
						}
					}else{
						$(".goods").hide();
						$(".goods-empty").show();
					}
				}
			})
		},
		eventLoadMoreBind:function(){
			var that = this;
			$("#a_more_btn").click(function(){
				console.log("加载更多");
				that.getGoods();
			});
		
		}
}
$(function(){
	goods_list_ops.init();
});