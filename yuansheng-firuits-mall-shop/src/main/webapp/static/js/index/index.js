;
isAddCartItem = false;
var index_ops = {

	init : function() {
		this.initScrollImage();
		this.initCategory();
		this.initGoods();
		this.initCartGoodsCount();
		this.eventBind();
	},
	initScrollImage : function() {
		$.ajax({
			url : basePath + "scrollImage",
			method : 'GET',
			type : 'text/json',
			success : function(res) {
				if (res.code == 0) {
					$(".swiper-wrapper").empty();
					console.log(res.data);
					$.each($.parseJSON(res.data), function(i, val) {
						$(".swiper-wrapper").append(
								"<div class='swiper-slide'>"
										+ "<a href='#'><img src='" + basePath
										+ val.imageHref + "'/></a></div>");
						// console.log(basePath+val.imageHref);
					});
				}
			}
		});
		var scrollSwiper = new Swiper('#slide', {
			autoplay : 5000,
			visibilityFullFit : true,
			autoplayDisableOnInteraction : false,
			// loop : true,
			observer : true,
			observeParents : true,
			pagination : '.pagination',
		});
	},
	initCategory : function() {
		$.ajax({
			url : basePath + "category",
			method : "GET",
			type : "text/json",
			success : function(res) {
				if (res.code == 0) {
					$(".categoryLiIcon").empty();
					$.each($.parseJSON(res.data), function(i, v) {
						$(".categoryLiIcon").append(
								"<li><a href='" + basePath + "category/info/" + v.id
										+ "'>" + "<img src='" + basePath
										+ v.imagePath + "'/><em>" + v.name
										+ "</em>" + "</a></li>");
					});
				}
			}
		})
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
	changeGoods : function(queryId) {
		var that = this;
		$.ajax({
					url : basePath + "goods/query/" + queryId,
					method : "GET",
					type : "text/json",
					success : function(res) {
						if (res.code == 0) {
							$(".goods-list").empty();
							$.each($.parseJSON(res.data), function(i, v) {
								var goodHtml = $("<li><a href='" + basePath
										+ "goods/info/" + v.id
										+ "' class='goodsPic'><img src='"
										+ basePath + v.imagePath + "'/>"
										+ "</a>" + "<div class='goodsInfor'>"
										+ "<h2>" + "<a href='" + basePath
										+ "goods/info/" + v.id + "'>" + v.name
										+ "</a>" + "</h2>" + "<p>" + "<del>"
										+ v.price + "</del>" + "</p>" + "<p>"
										+ "<strong class='price'>"
										+ v.discoutPrice + "</strong>" + "</p>"
										+ "<a class='addToCart' "
										+ "goodsId='"+v.id+"' >"
										+ "&#126;</a>" + "</div>" + "</li>");
								$(".goods-list").append(goodHtml);
								goodHtml.fadeIn(2000);
							});
							$(".addToCart").click(function(){ 					         
								               //购物车添加商品条目
								              if(isAddCartItem){
								            	  return;
								              }
								               isAddCartItem = true;
								                var $that = $(this);
								                 $.ajax({
								                	 url:basePath+"cartItem/",
								                	 method:'POST',
								                	 type:'text/json',
								                	 data:{goodsId:$(this).attr("goodsId")},
								                	 success:function(res){
								                		 console.log(res.code);
								                		 if(res.code == 0){
								                			 that.cartFlyAnimation($that);
								                		 }else if(res.code == 500008){
								                			 common_ops.msg(res.msg, function(){
								                				 window.location.href = basePath+"member/login?rurl="+basePath+"index";
								                			 });
								                		 }else{
								                		 common_ops.msg(res.msg);
								                		 }
								                		 isAddCartItem = false;
								                	 },
								                	 error:function(){
								                		 isAddCartItem = false;
								                	 }
								                 });
												// var goodsId = $(this).attr();
											});

						}
					}
				});
	},
	initGoods : function() {
		$(".tab_proList dt a").eq(0).addClass("currStyle");
		this.changeGoods(0);
	},
	eventBind : function() {
		var that = this;
		$(".tab_proList dt a").click(function() {
			// 获取到点击的内容
			$(this).addClass("currStyle").siblings().removeClass("currStyle");
			console.log($(this).attr("queryId"));
			that.changeGoods($(this).attr("queryId"));
		});
		// 点击加入购物车
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
	}
};
$(function() {
	index_ops.init();
});