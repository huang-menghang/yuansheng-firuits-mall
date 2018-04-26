<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/context/begin-tags.jsp"%>  
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp"/>
<title>修改密码</title>
</head>
<body>
	<!--header-->
	<header>
		<a onclick="backAndRefresh()" class="iconfont backIcon">&#60;</a>
		<h1>修改密码</h1>
	</header>
	<div style="height: 1rem;"></div>
	<form class="userForm">
	<ul >
		<li><label class="formName">旧密码：</label> <input type="password"
			id="input_old_password" required="true" minlength="6" maxlength="12" placeholder="旧密码..." /></li>
		<li><label class="formName">新密码：</label> <input type="password"
			id="input_new_password" required="true" minlength="6" maxlength="12" placeholder="新密码..." /></li>
		<li><label class="formName">确认新密码：</label> <input type="password"
			id="input_confirm_password" required="true" minlength="6" maxlength="12" placeholder="确认新密码..." /></li>
		<li><input type="button" value="确认修改密码" id="input_change_password"
			class="formLastBtn" /></li>
	</ul>
	</form>
	<div style="height: 1.2rem;"></div>
	<script>
		document.oncontextmenu=new Function("event.returnValue=false;");
		document.onselectstart=new Function("event.returnValue=false;"); 
	</script>
    <jsp:include page="/context/js-tags.jsp"/>
   <script type="text/javascript"
		src="<%=basePath%>static/js/plugin/jquery-validation/jquery.validate.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>static/js/plugin/jquery-validation/localization/messages_zh.min.js"></script>
    <script type="text/javascript" 
       src="<%=basePath%>static/js/plugin/jquery-validation/additional-methods.min.js"></script>
    <script type="text/javascript" 
       src="<%=basePath%>static/js/plugin/md5/md5.min.js"></script>	   
    <script type="text/javascript" src="<%=basePath%>static/js/member/change-pwd.js"></script>
</body>
</html>
