var goods_info_ops = {
	init:function(){
		this.initGoods(this.getGoodsId());
		this.initCartGoodCount();	
		this.eventBind();
		
	},
	initCartGoodCount:function(){
		$.ajax({
			url:basePath+"cart/countGoods",
			method:"GET",
			type:"text/json",
			success:function(res){
				if(res.code == 0){
					$(".topCart em").html(res.data);
				}
				else{
					$(".topCart em").html(0);
				}
			}
		});
	},
	initGoods:function(goodsId){
		$.ajax({
			url:basePath+"/goods/"+goodsId,
			method:"GET",
			type:"text/json",
			success:function(res){
				if(res.code == 0){
					var goods = $.parseJSON(res.data);
					if(goods!=null){
					  $(".pro_bigImg img").attr("src",basePath+goods.imagePath);
					  $(".pro_baseInfor h2").html(goods.name);
					  $(".pro_baseInfor strong").html(goods.discoutPrice);
					  $(".pro_baseInfor del").html(goods.price);
					  $(".launcTime em").html((new Date(goods.launcTime.time)).format("yyyy-MM-dd"));
					  $(".standrds em").html(goods.standrds);
					  $(".weight em").html(goods.weight+"kg");
					  var packet =(goods.packet == 0?"散装":"斤装");
					  $(".packet em").html(packet);
					  $(".storage em").html(goods.storage+"个月");
					  $(".brandName em").html(goods.brandName);
					  $(".addToCart").attr("goodsId",goods.id);
					  $(".addToFavor").attr("goodsId",goods.id);
					}				
				}
			}
		})
	},
	getGoodsId:function(){
	   var splitArray=	(window.location.href).split("/");
	   if(splitArray!=null){
				return splitArray[splitArray.length-1];
		}
	},
	eventBind:function(){
		var that = this;
		$(".addToCart").click(function(){
			var goodsId = $(this).attr("goodsId");
			$.ajax({
				url:basePath+"cartItem",
				method:"POST",
				data:{goodsId:goodsId},
				type:"text/json",
				success:function(res){
					var callback = null;
					if(res.code == 0){
						callback = function(){
							that.initCartGoodCount();
						};
						common_ops.msg("添加购物车成功",callback);
					}else if(res.code == 500008){
						callback = function(){
							window.location.href = basePath+"member/login?rurl="+window.location.href;
						};
						common_ops.msg("请先登录",callback);
					}else{
						common_ops.msg(res.msg,callback);
					}
				}
				
			});
		});
	    $(".addToFavor").click(function(){
	    	var goodsId = $(this).attr("goodsId");
			$.ajax({
				url:basePath+"goodsFav",
				method:"POST",
				data:{goodsId:goodsId},
				type:"text/json",
				success:function(res){
					var callback = null;
					if(res.code == 0){
						common_ops.msg(res.msg,callback);
					}else if(res.code == 500008){
						callback = function(){
							window.location.href = basePath+"member/login?rurl="+window.location.href;
						};
						common_ops.msg("请先登录",callback);
					}else{
						common_ops.msg(res.msg,callback);
					}
				}
				
			});
		});
	}
	
		
};
$(function(){
	goods_info_ops.init();
})