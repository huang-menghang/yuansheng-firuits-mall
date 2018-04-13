<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>购物车</title>
</head>
<body>
<!--header-->
<header>
 <a onclick="backAndRefresh()" class="iconfont backIcon">&#60;</a>
 <h1>购物车</h1>
</header>
<div style="height:1rem;"></div>
<c:choose>
<c:when test="${sessionScope.cart.isEmpty == false}">
<dl class="cart" customerId="${sessionScope.customer.id }">
 <dt>
  <label><input type="checkbox" id="check_all"/>全选</label>
  <a class="edit">编辑</a>
 </dt>
 <c:forEach items="${sessionScope.cart.cartItems}" var="item">
<dd >
  <input type="checkbox" class="check_item"/>
  <a href="<%=basePath%>product/${item.productId}/showProduct.jspa"class="goodsPic"> <img src="<%=path%>${item.productImgPath}" /></a>  
  <div class="goodsInfor">
   <h2>
   <a href="<%=basePath%>product/${item.productId}/showProduct.jspa">${item.productName}</a>
    <span class="itemProduct">${item.productQuantity}</span>
   </h2>
   <div class="priceArea" >
    <strong class="productPrice">${item.productPrice}</strong>
    <del>${item.productCastPrice}</del>
   </div>
   <div class="numberWidget">
    <input type="button" value="-" class="minus"/>
    <input type="text" value="${item.productQuantity}" disabled  class="number"/>
    <input type="button" value="+"  class="plus"/>
   </div>
  </div>
  <a class="delBtn" productId="${item.productId}" itemId="${item.id}" itemPrice="${item.itemTotalPrice}">删除</a>
 </dd>
 </c:forEach>
</dl>
<!--bottom nav-->
<div style="height:1rem;"></div>
<aside class="btmNav">
 <a class="a_total_price" totalPrice="${sessionScope.cart.cartTotalPrice}">合计：￥${sessionScope.cart.cartTotalPrice}</a>
 <a class="a_confirm_order"    style="background:#64ab5b;color:white;text-shadow:none;">立即下单</a>
</aside>
 </c:when>
 	<c:otherwise>
 	<div class="cart-empty" >
 	    <div style="height:1rem;"></div>
        <aside class="btmNav">
        <a class="a_total_price" totalPrice="${sessionScope.cart.cartTotalPrice}" >合计：￥${sessionScope.cart.cartTotalPrice}</a>
        <a class="a_confirm_order"  style="background:grey;color:white;text-shadow:none;" >立即下单</a>
        </aside>
		<mark style='display:block;background:none;text-align:center;color:grey;'>购物车为空！</mark>
	</div>
	</c:otherwise>
 </c:choose>
<jsp:include page="/context/js-tags.jsp"/>
</body>
</html>
