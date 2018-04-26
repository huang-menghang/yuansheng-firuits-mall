<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>	
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>产品列表</title>
</head>
<body style="background: white;">
	<!--header-->
	<header>
		<a onclick ="backAndRefresh()" class="iconfont backIcon" >&#60;</a>
		<h1>产品列表</h1>
		<a href="<%=basePath%>search/index" class="rt_searchIcon">&#63;</a>
	</header>
	<div style="height: 1rem;"></div>
	<div class="goods">
	<!--asc->1[升序asc_icon];des->0[降序des_icon]-->
	<ul class="sift_nav">
		<li><a class="des_icon" id="a_productPrice">价格</a></li>
		<li><a class="des_icon" id="a_productSales">销量优先</a></li>
		<li><a class="nav_li drop_icon">品牌筛选</a>
			<ul class="drop_list">
			</ul>
	    </li>
	</ul>
	<!--productList-->
	<section class="productList">
		<ul id="ul_productList">
		</ul>
		<a class="more_btn" id="a_more_btn">加载更多</a>
	</section>
	<!--floatCart-->
	<div class="hoverCart">
		<a href="<%=basePath%>cart">
		</a>
	</div>
    </div>
    <div class="goods-empty">
 	<div style="height:1rem;"></div>
    <mark style='display:block;background:none;text-align:center;color:grey;'>列表为空！</mark>
	</div>
 
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript" src="<%=basePath%>static/js/goods/list.js"></script>
</body>
</html>
