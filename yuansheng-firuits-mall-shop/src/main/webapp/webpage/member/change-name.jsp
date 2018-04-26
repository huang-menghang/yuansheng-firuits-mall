<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>        
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp"/>
<title>修改</title>
</head>
<body>
<!--header-->
<header>
 <a onclick="backAndRefresh()" class="iconfont backIcon">&#60;</a>
 <h1>用户昵称</h1>
</header>
<div style="height:1rem;"></div>
<ul class="userForm">
 <li><input type="text" id="input_petname" value="" placeholder="设置用户名"/></li>
 <li><input type="button" id="btn-save" value="更新保存" class="formLastBtn" /></li>
</ul>
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript" src="<%=basePath%>static/js/member/change-name.js"></script>
</body>
</html>
