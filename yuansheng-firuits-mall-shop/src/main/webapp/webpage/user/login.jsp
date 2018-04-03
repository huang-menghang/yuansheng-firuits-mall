<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp"/>
<title>源盛生鲜通-登录</title>
</head>
<body>
	<section class="formLogo">
		<h2>&#35;</h2>
	</section>
	<form class="formarea">
	<ul >
		<li><label class="lit">账号：</label> <input type="text"
			placeholder="手机号码" class="textbox" required="true" minlength="11"
			maxlength="11" id="input-mobile" value="" /></li>
		<li><label class="lit">密码：</label> <input type="password"
			placeholder="登陆密码" class="textbox" id="input-password"
			required="true" minlength="6" maxlength="12" value="" /></li>
		<li class="liLink lg_liLink"><span><label><input
					type="checkbox" />记住密码</label></span> <span><a
				href="<%= basePath %>user/register">新用户注册</a></span> <span><a
				href="/userSet/findPwd.jspa">忘记密码?</a></span></li>
		<li><input type="button" class="btn-login" value="立即登陆" /></li>
	</ul>
	</form>
	<div style="height: 1.2rem;"></div>
	<%@include file="/webpage/common/footer.jsp"%>
	<script>
		document.oncontextmenu = new Function("event.returnValue=false;");
		document.onselectstart = new Function("event.returnValue=false;");
	</script>
	<jsp:include page="/context/js-tags.jsp"/>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/plugin/jquery-validation/jquery.validate.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/plugin/jquery-validation/localization/messages_zh.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/user/login.js"></script>
</body>
</html>