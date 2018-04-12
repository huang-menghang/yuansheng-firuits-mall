<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>产品详情</title>
</head>
<body>
<!--header-->
<header>
 <a onclick="backAndRefresh()" class="iconfont backIcon">&#60;</a>
 <h1>产品详情</h1>
 <a href="<%=basePath%>cart/showCart.jspa" class="topCart"><em>
 <c:choose>
 <c:when test="${sessionScope.cart!=null}">
 ${sessionScope.cart.totalItemNo }
  </c:when>
 <c:otherwise>
	0
</c:otherwise>
 </c:choose></em>
 </a>
</header>
<div style="height:1rem;"></div>
<div class="pro_bigImg">
 <img src=""/>
</div>
<!--base information-->
<section class="pro_baseInfor">
 <h2></h2>
 <p>
  <strong>${firuitsProduct.productPrice}</strong>
  <del>${firuitsProduct.productCastPrice}</del>
 </p>
</section>
<!--product attr-->
<dl class="pro_attr">
 <dt>产品属性信息</dt>
 <dd>
  <ul>
   <li class="launcTime">
    <span>上市时间</span>
    <em></em>
   </li>
   <li class="standrds">
    <span>产品规格</span>
    <em></em>
   </li>
   <li class="weight">
    <span>产品重量</span>
    <em></em>
   </li>
   <li class="packet">
    <span>包装方式</span>
    <em>散装</em>
   </li>
   <li class="storage">
    <span>保质期</span>
    <em></em>
   </li>
   <li class="brandName"> 
    <span>所属品牌</span>
    <em></em>
   </li>
  </ul>
 </dd>
</dl>
 
 
 <!--  
 <h1>产品详情</h1>
 <a href="<%=basePath%>cart/showCart.jspa" class="topCart"><em>0</em></a>
</header>
<div style="height:1rem;"></div>
<div class="pro_bigImg">
 <img src="<%=path%>/images/firuitShop/upload/goods001.jpg"/>
</div>
<!--base information-->
<!--  
<section class="pro_baseInfor">
 <h2>新鲜生菜两斤装特惠</h2>
 <p>
  <strong>39.80</strong>
  <del>49.80</del>
 </p>
</section>
-->
<!--product attr-->
<!-- 
<dl class="pro_attr">
 <dt>产品属性信息</dt>
 <dd>
  <ul>
   <li>
    <span>上市时间</span>
    <em>2015年09月</em>
   </li>
   <li>
    <span>产品规格</span>
    <em>2斤装</em>
   </li>
   <li>
    <span>产品重量</span>
    <em>1kg</em>
   </li>
   <li>
    <span>包装方式</span>
    <em>散装</em>
   </li>
   <li>
    <span>保质期</span>
    <em>6个月</em>
   </li>
   <li>
    <span>所属品牌</span>
    <em>三星</em>
   </li>
  </ul>
 </dd>
</dl>
-->
<!--bottom nav-->
<div style="height:1rem;"></div>
<aside class="btmNav">
 <a style="background:#64ab5b;color:white;text-shadow:none;" class="addToCart" cartId="${sessionScope.cart.id}" productId="${firuitsProduct.id}" customerId="${sessionScope.customer.id}">加入购物车</a>
 <a style="background:#87a983;color:white;text-shadow:none;" class="addToFavor" productId="${firuitsProduct.id}" customerId="${sessionScope.customer.id}">加入常购单</a>
</aside>
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript" src="<%=basePath%>static/js/goods/info.js"></script>
</body>
</html>
