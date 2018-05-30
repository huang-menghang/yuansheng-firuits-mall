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
        <label class="layui-form-label">事件发生位置</label>
        <div class="layui-input-inline">
            <input type="text" name="location"  
                   class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <label class="layui-form-label">日志时间点</label>
        <div class="layui-input-inline">
            <input type="text" name="date" 
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">所属类名</label>
        <div class="layui-input-inline">
            <input type="text" name="logger"  
                   class="layui-input">
        </div>
    </div>
    
     <div class="layui-form-item">
        <label class="layui-form-label">优先级</label>
        <div class="layui-input-inline">
            <input type="text" name="level" 
                   class="layui-input">
        </div>
     </div>
     
    <div class="layui-form-item">
        <label class="layui-form-label">过程信息</label>
        <div class="layui-input-block">
            <textarea name="message"  
                   class="layui-textarea"></textarea>
        </div>
    </div>
    
</form>
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript" src="<%=basePath %>static/js/logs/info.js"></script>
</body>
</html>