<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>注册</title>
<jsp:include page="/context/css-tags.jsp" />
</head>
<body>
	<!--header-->
	<header>
		<a onclick="backAndRefresh()" class="iconfont backIcon">&#60;</a>
		<h1>注册</h1>
	</header>
	<div style="height: 1rem;"></div>
	<mark class="formMark">这里放电话做什么，请联系400-8000-6379</mark>
	<form>
	<ul class="formarea">
		<li><label class="lit">账号：</label> <input type="tel"
			id="input-telephonephoneNo" placeholder="手机号码" class="textbox" /></li>
		<li><label class="lit">密码：</label> <input type="password"
			id="input-password" placeholder="设置密码" class="textbox" /></li>
		<li><label class="lit">确认密码：</label> <input type="password"
			id="input-confirm-password" placeholder="确认密码" class="textbox" /></li>
		<li><label class="lit">所在城市：</label> <select id="select-address">
		</select></li>
		<li><label class="lit">餐馆名称：</label> <input type="text"
			id="input-restaurant" placeholder="餐馆名称" class="textbox" /></li>
		<li><label class="lit">收货人：</label> <input type="text"
			id="input-customer-name" placeholder="收件人真实姓名" class="textbox" /></li>
		<li><label class="lit">联系电话：</label> <input type="tel"
			id="input-phoneNo" placeholder="联系电话" class="textbox" /></li>
		<li><label class="lit">收货地址：</label> <input type="text"
			id="input_detailAdd" placeholder="区-街道-小区-门牌号" class="textbox" /></li>
		<li class="liLink"><a
			href="<%=basePath%>userSet/userAgreement.jspa" class="fl">《用户协议》</a>
			<a href="<%=basePath%>userSet/login.jspa" class="fr">已有账号，登陆</a></li>
		<li><input type="button" id="input_regesiter" value="立即注册" /></li>
	</ul>
	</form>
	<div style="height: 1.2rem;"></div>
	<%@include file="/webpage/common/footer.jsp"%>
	<script>
		document.oncontextmenu = new Function("event.returnValue=false;");
		document.onselectstart = new Function("event.returnValue=false;");
	</script>
	<jsp:include page="/context/js-tags.jsp" />
	<script type="text/javascript"
		src="<%=basePath%>static/js/plugin/jquery-validation/jquery.validate.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>static/js/plugin/jquery-validation/localization/messages_zh.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/user/register.js"></script>
</body>
</html>
