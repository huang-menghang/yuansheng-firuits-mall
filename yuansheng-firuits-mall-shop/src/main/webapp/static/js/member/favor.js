pageNum = 1;
var member_favor_ops = {
		init:function(){
			this.initFavor();
			this.initCartGoodsCount();
			this.eventBind();
		},
		initFavor:function(){
			this.getGoodsFav();
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
		eventBind:function(){
			  var that = this;
			   $("#ul_favoriteList").on("click",".addToCart",function(e){
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
		getGoodsFav:function(){
			$.ajax({
				url:basePath+"member/favor?pageNum="+pageNum,
				method:"GET",
				type:"text/json",
				success:function(res){
					if(res.code == 0){
						var data = $.parseJSON(res.data);
						
						if(data.pageNum == 1){
							$("#ul_favoriteList").empty();
						}
						
						$.each(data.items,function(i,v){
							$("#ul_favoriteList").append("<li><a href='"+basePath+"goods/info/"+v.id+"'"+
					          "class='goodsPic'> <img src='"+basePath+v.imagePath+"' />"+
				              "</a>"+
					          "<div class='goodsInfor' >"+
						      "<h2>"+
							"<a href='"+basePath+"goods/info/"+v.id+"'>"+v.name+"</a>"+
						     "</h2>"+
						    "<p>"+
							"<del>"+v.price+"</del>"+
						    "</p>"+
						   "<p>"+
							"<strong class='price'>"+v.discoutPrice+"</strong>"+
						    "</p>"+
						    "<a class='addToCart'  productId='"+v.id+"' >&#126;</a>"+
					        "</div>"+
			                 "</li>");
						});
						if(!data.lastPage){
							pageNum++;
							$(".more_btn").show();
						}else{
							$(".more_btn").hide();
						}
									
					}
				}
			})
		}
		
}
$(function(){
	member_favor_ops.init();
})
