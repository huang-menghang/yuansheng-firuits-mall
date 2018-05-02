<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>设置</title>
<jsp:include page="/context/css-tags.jsp" />
</head>
<body>
<!--header-->
<header>
 <a href = "<%=basePath %>member/center" class="iconfont backIcon">&#60;</a>
 <h1>设置</h1>
</header>
<div style="height:1rem;"></div>
<ul class="inforList">
 <li><a href="<%=basePath %>member/set/changePassword" class="isNext">修改密码</a></li>
 <li><a href="<%=basePath %>member/set/address" class="isNext">我的地址</a></li>
 <li><a href="<%=basePath %>member/set/aboutus" class="isNext">关于我们</a></li>
 <li><a href="<%=basePath %>member/logout" class="lastBtn">安全退出</a></li>
</ul>
</body>
</html>
