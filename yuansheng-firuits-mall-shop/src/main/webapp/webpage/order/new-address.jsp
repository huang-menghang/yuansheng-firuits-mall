<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%> 	
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>使用新的收货地址</title>
</head>
<body>
	<!--header-->
	<header>
		<a onclick="bcakToOrder(${firuitOrder.id})" class="iconfont backIcon">&#60;</a>
		<h1>收货人信息</h1>
	</header>
	<div style="height: 1rem;"></div>
	<form class="userForm">
	<ul  id="ul_adress">
		<li><label class="radio istrue"><input type="radio"
				checked />使用新地址</label></li>
		<li>
  <span>收货地址：</span>
   <select class="prov" style="width:auto;display:inline-block; vertical-align:middle;" id="select_prov" required="true">
   </select>
   <select class="city" style="width:auto;display:inline-block; vertical-align:middle;" disabled="false" id="select_city" required="true">
  </select>
   <select class="dist" style="width:auto;display:inline-block; vertical-align:middle;" disabled="false" id="select_dist" required="true">
  </select>
  </li>
		<li><input type="text" id="input_detail_address"  placeholder="详细地址" required="true" minlength="5" maxlength="32" /></li>
		<li><input type="text" id="input_mobile"  placeholder="手机号码"  required="true" diyCheck="手机号码格式不正确"
			diyRule="^((1[3|4|5|7|8][0-9]{1})\d{8})$" /></li>
		<li><input type="text" id="input_phone"  placeholder="固定电话" required="true"
		    diyCheck="请输入正确电话" diyRule="(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)" /></li>
		<li><label class="checkbox"><input type="checkbox" id="input_default" />设为默认地址</label>
		</li>
		<li><input type="button" value="保存地址" class="formLastBtn" /></li>
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
  <script src="<%=basePath%>static/js/order/new-address.js" type="text/javascript"></script>
</body>
</html>
