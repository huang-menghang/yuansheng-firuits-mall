<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>新鲜蔬菜</title>
</head>
<body>
	<!--header-->
	<header>
		<a href="<%=basePath%>home/homeLocation.jspa" class="location">西安市</a>
		<h1 class="logoIcon" style="font-size: .85rem;">&#35;</h1>
		<a href="<%=basePath%>search/index" class="rt_searchIcon">&#37;</a>
	</header>
	<div style="height: 1rem;"></div>
	<!--slide-->
	<div id="slide">
		<div class="swiper-wrapper">
		</div>
		<div class="pagination"></div>
	</div>
	<!--categoryList-->
	<ul class="categoryLiIcon">
	</ul>
	<!--Tab:productList-->
	<dl class="tab_proList">
		<dt>
			<a queryId="0">热销</a> <a queryId="1">新品</a> <a queryId="2">打折</a>
		</dt>
		<dd>
			<ul class="goods-list">
				
			</ul>
		</dd>
	</dl>
	<div class="hoverCart">
		<a href="<%=basePath%>cart"> 
		</a>
	</div>
	<div style="height: 1.2rem;"></div>
	<%@include file="/webpage/common/footer.jsp"%>
	<jsp:include page="/context/js-tags.jsp"/>
	<script src="<%=basePath%>static/js/plugin/swiper/swiper.min.js"></script>
	<script src="<%=basePath%>static/js/index/index.js" type="text/javascript"></script>
</body>
</html>
