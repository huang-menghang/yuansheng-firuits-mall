<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>业务日志详情</title>
</head>
<body class="body">
<form class="layui-form layui-form-pane" >
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="user"  
                   class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <label class="layui-form-label">请求地址</label>
        <div class="layui-input-block">
            <input type="text" name="requstUrl" 
                   class="layui-input">
        </div>
    </div>
    
     <div class="layui-form-item">
        <label class="layui-form-label">请求IP</label>
        <div class="layui-input-block">
            <input type="text" name="ip" 
                   class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <label class="layui-form-label">请求时间</label>
        <div class="layui-input-block">
            <input type="text" name="createTime" 
                   class="layui-input">
        </div>
    </div>
    
     <div class="layui-form-item">
        <label class="layui-form-label">请求方式</label>
        <div class="layui-input-block">
            <input type="text" name="requestMethod" 
                   class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <label class="layui-form-label">请求参数</label>
        <div class="layui-input-block">
            <input type="text" name="requestParams" 
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">执行类名、执行方法名</label>
        <div class="layui-input-block">
            <input type="text" name="requestControllerMethod"  
                   class="layui-input">
        </div>
    </div>
    
     <div class="layui-form-item">
        <label class="layui-form-label">返回结果</label>
        <div class="layui-input-block">
            <input type="text" name="result" 
                   class="layui-input">
        </div>
     </div>
     
    <div class="layui-form-item">
        <label class="layui-form-label">异常信息</label>
        <div class="layui-input-block">
            <input name="exception"  
                   class="layui-input"></input>
        </div>
    </div>
    
    <div class="layui-form-item">
        <label class="layui-form-label">系统、浏览器</label>
        <div class="layui-input-block">
            <input type="text" name="osAndBrowser"  
                   class="layui-input">
        </div>
    </div>
    
</form>
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript" src="<%=basePath %>static/js/actionlog/log.js"></script>
</body>
</html>