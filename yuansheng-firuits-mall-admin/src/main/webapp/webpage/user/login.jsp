<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登录</title>
    <link rel="stylesheet" href="<%=basePath %>static/plugin/layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath %>static/css/style.css">
    <link rel="icon" href="<%=basePath %>static/images/code.png">
</head>
<body>

<div class="login-main">
    <header class="layui-elip">源盛农业合作社管理系统</header>
    <form class="layui-form">
        <div class="layui-input-inline">
            <input type="text" name="account" placeholder="用户名" required="true" minlength="2"
			maxlength="5" id="input-account" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="password" name="password" placeholder="密码" autocomplete="off" id="input-password"
			required="true" minlength="6" maxlength="12" class="layui-input">
        </div>
        <div class="layui-input-inline login-btn">
            <button type="submit" class="layui-btn">登录</button>
        </div>
        <hr/>
        <!--<div class="layui-input-inline">
            <button type="button" class="layui-btn layui-btn-primary">QQ登录</button>
        </div>
        <div class="layui-input-inline">
            <button type="button" class="layui-btn layui-btn-normal">微信登录</button>
        </div>-->
        <p><a href="javascript:;" class="fl">立即注册</a><a href="javascript:;" class="fr">忘记密码？</a></p>
    </form>
</div>
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript"
		src="<%=basePath%>static/js/plugin/jquery-validation/jquery.validate.min.js"></script>
<script type="text/javascript"
		src="<%=basePath%>static/js/plugin/jquery-validation/localization/messages_zh.min.js"></script>
<script type="text/javascript" 
       src="<%=basePath%>static/js/plugin/jquery-validation/additional-methods.min.js"></script>
<script type="text/javascript" 
       src="<%=basePath%>static/js/plugin/md5/md5.min.js"></script>	
<script type="text/javascript" src="<%=basePath%>static/js/user/login.js"></script>       
</body>
</html>