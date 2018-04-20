<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>分类</title>
</head>
<body style="background: white;">
	<!--header-->
	<header>
		<a onclick="backHome()" class="iconfont backIcon">&#60;</a>
		<h1>动态分类名称</h1>
		<a href="<%=basePath%>search/index" class="rt_searchIcon">&#37;</a>
	</header>
	<div style="height: 1rem;"></div>
	<!--category list-->
	<!--模板不变，异步处理，链接传参数，静态写过于累赘-->
	<aside class="class_tree">
		<ul>
		</ul>
	</aside>
	<!--category content-->
	<ul class="category_cont">	
	</ul>
	<div style="height: 1.2rem;"></div>
	<%@include file="/webpage/common/footer.jsp"%>
	<script>
		document.oncontextmenu = new Function("event.returnValue=false;");
		document.onselectstart = new Function("event.returnValue=false;");
	</script>
    <jsp:include page="/context/js-tags.jsp"/>
    <script src="<%=basePath%>static/js/category/index.js" type="text/javascript"></script>
</body>
</html>
