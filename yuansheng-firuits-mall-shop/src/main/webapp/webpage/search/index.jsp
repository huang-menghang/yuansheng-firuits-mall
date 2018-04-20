<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>搜索</title>
</head>
<body>
<!--header-->
<header>
 <a onclick="backAndRefresh()" class="iconfont backIcon">&#60;</a>
 <h1>搜索</h1>
</header>
<div style="height:1rem;"></div>
<aside class="searchArea">
 <input type="text"   class="searchCondition" placeholder="寻找调料、食材..."/>
 <input type="button" value="&#63;" class="searchBtn"/>
</aside>
<dl class="searchHistory">
 <dt>历史搜索</dt>
 <dd>
  <ul id="ul_search">
  </ul>
 </dd>
 <dd>
  <a id="a_empty_history">清空历史记录</a>
 </dd>
</dl>
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript" src="<%=basePath%>static/js/cookie/jquery.cookie.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/search/index.js"></script>
</body>
</html>