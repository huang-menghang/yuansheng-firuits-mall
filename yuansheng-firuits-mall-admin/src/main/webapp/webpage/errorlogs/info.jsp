<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>异常日志详情</title>
</head>
<body class="body">
<form class="layui-form layui-form-pane" >
    <div class="layui-form-item">
        <label class="layui-form-label">ip</label>
        <div class="layui-input-inline">
            <input type="text" name="ip"  
                   class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <label class="layui-form-label">请求Url</label>
        <div class="layui-input-inline">
            <input type="text" name="requestUrl" 
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">请求方式</label>
        <div class="layui-input-inline">
            <input type="text" name="requestMethod"  
                   class="layui-input">
        </div>
    </div>
    
     <div class="layui-form-item">
        <label class="layui-form-label">请求参数</label>
        <div class="layui-input-inline">
            <input type="text" name="requestParmater" 
                   class="layui-input">
        </div>
     </div>
     
    <div class="layui-form-item">
        <label class="layui-form-label">创建时间</label>
        <div class="layui-input-inline">
            <input type="text" name="createTime"  
                   class="layui-input">
        </div>
    </div>
</form>
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript" src="<%=basePath %>static/js/errorlogs/info.js"></script>
</body>
</html>