<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>   
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp"/>
<title>我的地址</title>
</head>
<body>
<!--header-->
<header>
 <a onclick="backAndRefresh()" class="iconfont backIcon">&#60;</a>
 <h1>我的地址</h1>
</header>
<div style="height:1rem;"></div>
<form  class="userForm">
<ul id="ul_adress">
 <li>
  <input type="text" id="input-name" readonly="true" />
 </li>
 <li>
  <select class="prov" id="select_prov" required="true" >
  </select>
 </li>
 <li>
  <select class="city" disabled="false" id="select_city" required="true" >
  </select>
 </li>
 <li>
  <select class="dist" disabled="false" id="select_dist" required="true" >
  </select>
 </li>
 <li>
  <textarea id="textarea_detail" placeholder="请填写详细地址,不少于5个字" required="true" minlength="5" maxlength="32"></textarea>
 </li>
 <li>
  <input type="button" value="修改地址"  id="input_change_address" class="formLastBtn"/>
 </li>
</ul>
</form>
<jsp:include page="/context/js-tags.jsp"/>
<script src="<%=basePath%>static/js/city/cityselect.js"></script>
<script type="text/javascript"
		src="<%=basePath%>static/js/plugin/jquery-validation/jquery.validate.min.js"></script>
<script type="text/javascript"
		src="<%=basePath%>static/js/plugin/jquery-validation/localization/messages_zh.min.js"></script>
<script type="text/javascript" 
       src="<%=basePath%>static/js/plugin/jquery-validation/additional-methods.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/member/address.js"></script>
</body>
</html>
