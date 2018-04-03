<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav>
	<a href="<%=request.getContextPath()%>/home/toHome.jspa" class="homeIcon">首页</a> 
	<a href="<%=request.getContextPath()%>/category/1/showCategory.jspa" class="categoryIcon">分类</a>
	<a href="<%=request.getContextPath()%>/cart/showCart.jspa" class="cartIcon">购物车</a> 
	<a href="<%=request.getContextPath()%>/userCenter/myCenter.jspa" class="userIcon">我的</a>
</nav>
