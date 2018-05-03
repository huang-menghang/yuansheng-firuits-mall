<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>常购清单</title>
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name='apple-touch-fullscreen' content='yes'>
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta name="format-detection" content="address=no">
<link rel="icon" href="<%=path%>/images/firuitShop/icon/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon-precomposed" sizes="57x57" href="<%=path%>/images/firuitShop/icon/apple-touch-icon-57x57-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="120x120" href="<%=path%>/images/firuitShop/icon/apple-touch-icon-120x120-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="196x196" href="<%=path%>/images/firuitShop/icon/apple-touch-icon-196x196-precomposed.png">
<meta name="viewport" content="initial-scale=1, width=device-width, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/common/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/firuitShop/style.css" />
<script src="<%=path%>/js/common/jquery-2.1.4.min.js"></script>
<script src="<%=path%>/js/common/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=path%>/js/common.js?v=1"></script>
</head>
<body style="background:white;">
<!--header-->
<header>
 <a onclick="backAndRefresh()" class="iconfont backIcon">&#60;</a>
 <h1>常购清单</h1>
</header>
<div style="height:1rem;"></div>
<section class="productList">
  <ul id="ul_favoriteList">
  <c:forEach items="${pagination.items}" var="item">
				<li><a href="<%=basePath%>product/${item.id}/showProduct.jspa"
					class="goodsPic"> <img src="<%=path%>${item.productImgPath}" />
				</a>
					<div class="goodsInfor" >
						<h2>
							<a href="<%=basePath%>product/${item.id}/showProduct.jspa">${item.productName}</a>
						</h2>
						<p>
							<del>${item.productCastPrice}</del>
						</p>
						<p>
							<strong class="price">${item.productPrice}</strong>
						</p>
						<a class="addToCart" cartId="${sessionScope.cart.id}" productId="${item.id}" customerId="${sessionScope.customer.id}">&#126;</a>
					</div>
			    </li>
</c:forEach>
   <!--  
   <li>
    <a href="product.html" class="goodsPic">
     <img src="<%=path%>/images/goods/goods002.jpg"/>
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="product.html">红萝卜3斤装</a>
     </h2>
     <p>
      <del>12.90</del>
     </p>
     <p>
      <strong class="price">8.90</strong>
     </p>
     <a class="addToCart">&#126;</a>
    </div>
   </li>
   <li>
    <a href="product.html" class="goodsPic">
     <img src="<%=path%>/images/goods/goods003.jpg"/>
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="product.html">西红柿5斤装</a>
     </h2>
     <p>
      <del>9.90</del>
     </p>
     <p>
      <strong class="price">6.90</strong>
     </p>
     <a class="addToCart">&#126;</a>
    </div>
   </li>
   <li>
    <a href="product.html" class="goodsPic">
     <img src="<%=path%>/images/goods/goods009.jpg"/>
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="product.html">西红柿5斤装</a>
     </h2>
     <p>
      <del>9.90</del>
     </p>
     <p>
      <strong class="price">6.90</strong>
     </p>
     <a class="addToCart">&#126;</a>
    </div>
   </li>
   <li>
    <a href="product.html" class="goodsPic">
     <img src="<%=path%>/images/goods/goods008.jpg"/>
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="product.html">西红柿5斤装</a>
     </h2>
     <p>
      <del>9.90</del>
     </p>
     <p>
      <strong class="price">6.90</strong>
     </p>
     <a class="addToCart">&#126;</a>
    </div>
   </li>
   -->
  </ul>
  <c:if test="${pagination.lastPage == false}">
		<a class="more_btn" id="a_more_btn">加载更多</a>
 </c:if>
</section>
<div hidden="true" id="favorite_list_pageNo">${pagination.pageNum}</div>
<div hidden="true" id="favorite_cart_id" value="${sessionScope.cart.id}"></div>
<div hidden="true" id="favorite_customer_id" value="${sessionScope.customer.id}"></div> 
<!--floatCart-->
<div class="hoverCart">
 <a href="<%=basePath%>cart/showCart.jspa">
	    	<c:choose>
				<c:when test="${sessionScope.cart!=null}">
				  ${sessionScope.cart.totalItemNo }
			    </c:when>
				<c:otherwise>
				   0
				</c:otherwise>
		    </c:choose>
  </a>
</div>
<script>
$(document).ready(function(){
     //飞入动画，具体根据实际情况调整
     //事件委托机制....
     $("#ul_favoriteList").delegate('.addToCart','click',function(){
    	 var cartId = $(this).attr("cartId");
  	    var productId = $(this).attr("productId");
  		var customerId = $(this).attr("customerId");
  		if(customerId == null || customerId =="" || cartId  == null || cartId =="" ){
  			openAlertModal("请先登录",function(){
  				window.location.href = getRootPath()+"/userSet/login.jspa";
  			});
  			return;
  		}
  		  $.post(getRootPath()+"/doCart/addCartItem.do",{productId:productId,cartId:cartId,customerId:customerId},function(result){
  	        if(result.code != 0){
  	           // 如果返回码不为0,则跳出整个xunhuan
  	        	return ;
  	        }
  			  
  		  });
  	       
  	        //飞入动画
  	        $(".hoverCart a").html(parseInt($(".hoverCart a").html())+1);/*测试+1*/
              var shopOffset = $(".hoverCart").offset();
              var cloneDiv = $(this).parent().siblings(".goodsPic").clone();
              var proOffset = $(this).parent().siblings(".goodsPic").offset();
              cloneDiv.css({ "position": "absolute", "top": proOffset.top, "left": proOffset.left });
              $(this).parent().siblings(".goodsPic").parent().append(cloneDiv);
              cloneDiv.animate({
  				width:0,
  				height:0,
                  left: shopOffset.left,
                  top: shopOffset.top,
  				opacity:1
              },"slow");  
     });
          
  $(".more_btn").click(function(){
	  alert("1");
	  var nextPage = Number($('#favorite_list_pageNo').html())+1;
	  var customerId = $("#favorite_customer_id").attr("value");
	  var cartId  = $("#favorite_cart_id").attr("value");
	  var path = getRootPath();
	  $.getJSON(path+"/doProduct/getProductPaginationEntityFavorite.do",{pageNum:nextPage,customerId:customerId},function(data){
		  alert("2");
		  alert(data);
		  if(data.lastPage == true){
	        	$("#a_more_btn").hide();	
	        }else{
	        	$("#a_more_btn").show();
	        }
		   for(var i=0; i<data.items.length; i++){
	        	$("#ul_favoriteList").append(
	        		  "<li>"+
	      			  "<a href='"+path+"/product/"+data.items[i].id+"/showProduct.jspa' class ='goodsPic'>"+
	                    "<img src='"+path+""+data.items[i].productImgPath+"'/>"+
	                    "</a>"+
	                    "<div class='goodsInfor'>"+
	      	  		  "<h2>"+
	      	  		  "<a href='"+path+"/product/"+data.items[i].id+"/showProduct.jspa'>"+data.items[i].productName+
	      	  		  "</a>"+
	      	  		  "</h2>"+
	      	  		  "<p>"+
	      	  		  "<del>"+
	      	  		   data.items[i].productCastPrice+
	      	  		  "</del>"+
	      	  		  "</p>"+
	      	  		  "<p>"+
	      	  		  "<strong class='price'>"+
	      	  		   data.items[i].productPrice+
	      	  		  "</strong>"+
	      	  		  "</p>"+
	      	  		  "<a class='addToCart'  cartId='"+cartId+"' productId='"+data.items[i].id+"' customerId='"+customerId+"'>"+
	      	  		  "&#126;"+
	      	  		  "</a>"+
	                   "</div>"+
	      	  		 "</li>"
          );
	        }      
		  
		  
	  });                          
      $('#product_list_pageNo').html(nextPage);
  });  
      
});
</script>
</body>
</html>
