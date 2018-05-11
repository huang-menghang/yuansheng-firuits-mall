<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>常购清单</title>
<jsp:include page="/context/css-tags.jsp"/>
</head>
<body style="background:white;">
<!--header-->
<header>
 <a href="<%=basePath %>member/center" class="iconfont backIcon">&#60;</a>
 <h1>常购清单</h1>
</header>
<div style="height:1rem;"></div>
<section class="productList">
  <ul id="ul_favoriteList">

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
		<a class="more_btn" style="display:none" id="a_more_btn">加载更多</a>
</section>
<!--floatCart-->
<div class="hoverCart">
 <a href="<%=basePath%>cart">
  </a>
</div>
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript" src="<%=basePath%>static/js/member/favor.js"></script>
</body>
</html>
