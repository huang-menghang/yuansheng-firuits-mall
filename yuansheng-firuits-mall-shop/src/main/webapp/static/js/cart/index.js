var cart_index_ops = {
		init:function(){
			this.initCart();
		},
		eventBind:function(){
		},
		initCart:function(){
			var cartId = 
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
             "<strong class='productPrice'>"+v.goodsPrice+"</strong>"+
             "<del>原价</del>"+
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
        					
        					$(".a_total_price").html("合计：￥ "+result.totalPrice);
        					
						}
					}
				}
			})
		}
		
}

$(function(){
	cart_index_ops.init();
	
})