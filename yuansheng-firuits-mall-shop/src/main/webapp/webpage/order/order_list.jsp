<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>订单列表</title>
</head>
<body>
<!--header-->
<header>
 <a  class="iconfont backIcon">&#60;</a>
 <h1>订单列表</h1>
</header>
<div style="height:1rem;"></div>
<!--异步处理，此处不做TAB形式,注意当前状态样式currStyle-->
<aside class="orderSift">
 <a class="currStyle" status="0">待付款</a>
 <a status="1">待发货</a>
 <a status="2">已发货</a>
 <a status="3">已完成</a>
</aside>
<!--订单列表-->
<ul class="orderList" >
<!-- 订单列表 -->
</ul>
<section class="productList" >
		<ul id="ul_productList">
		</ul>
		<a class="more_btn" id="a_more_btn">加载更多</a>
</section>
<div style="height:1.2rem;"></div>
<script>
  document.oncontextmenu=new Function("event.returnValue=false;");
  document.onselectstart=new Function("event.returnValue=false;"); 
</script>
<jsp:include page="/context/js-tags.jsp"/>
<script src="<%=basePath%>static/js/order/list.js" type="text/javascript"></script>
</body>
</html>
