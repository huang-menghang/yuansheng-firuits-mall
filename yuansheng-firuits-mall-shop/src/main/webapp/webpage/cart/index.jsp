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
<div class="cart-show" >
<dl class="cart" customerId="${sessionScope.customer.id }">
 <dt>
  <label><input type="checkbox" id="check_all"/>全选</label>
  <a class="edit">编辑</a>
 </dt>
</dl>
<!--bottom nav-->
<div style="height:1rem;"></div>
<aside class="btmNav">
 <a class="a_total_price" totalPrice="${sessionScope.cart.cartTotalPrice}"></a>
 <a class="a_confirm_order"    style="background:#64ab5b;color:white;text-shadow:none;">立即下单</a>
</aside>
</div>
<div class="cart-empty" >
 	    <div style="height:1rem;"></div>
        <aside class="btmNav">
        <a class="a_total_price" totalPrice="${sessionScope.cart.cartTotalPrice}" >合计：￥${sessionScope.cart.cartTotalPrice}</a>
        <a class="a_confirm_order"  style="background:grey;color:white;text-shadow:none;" >立即下单</a>
        </aside>
		<mark style='display:block;background:none;text-align:center;color:grey;'>购物车为空！</mark>
</div>

<jsp:include page="/context/js-tags.jsp"/>
<script src="<%=basePath%>static/js/cart/index.js" type="text/javascript"></script>
</body>
</html>
