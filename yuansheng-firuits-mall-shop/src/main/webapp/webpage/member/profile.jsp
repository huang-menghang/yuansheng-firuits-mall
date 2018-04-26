<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp"/>
<title>个人资料</title>
</head>
<body>
<!--header-->
<header>
 <a class="iconfont backIcon">&#60;</a>
 <h1>个人资料</h1>
</header>
<div style="height:1rem;"></div>
<ul class="inforList">
 <li>
  <a href="<%=basePath%>member/info/changeName" id="member-name" class="isNext">
  <span>用户昵称</span>
  <span></span>
  </a>
 </li>
 <li>
  <a href="<%=basePath%>member/info/changeMobile" id="member-mobile" class="isNext">
   <span>手机号码</span>
   <span></span>
  </a>
 </li>
</ul>
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript" src="<%=basePath%>static/js/member/profile.js"></script>
</html>