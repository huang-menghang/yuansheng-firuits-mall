var goods_info_ops = {
	inint:function(){
		this.inintGoods(this.getGoodsId());
		this.eventBind();
		
	},
	inintGoods:function(goodsId){
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
		
	}
	
		
};
$(function(){
	goods_info_ops.inint();
})