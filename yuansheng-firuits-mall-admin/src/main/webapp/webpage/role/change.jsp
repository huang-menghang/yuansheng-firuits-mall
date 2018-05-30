<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
</head>
<body class="body">
<div >
    <label>已有权限勾选删除，未有权限勾选添加</label>
</div>
<form class="layui-form layui-form-pane" >
    <div class="layui-form-item">
        <label class="layui-form-label">已有权限</label>
        <div class="layui-input-block" id="have">
            
        </div>
    </div>
     <div class="layui-form-item">
        <label class="layui-form-label">未有权限</label>
        <div class="layui-input-block" id="notHave">
            
        </div>
    </div>
    <div class="layui-form-item">
        <button class="layui-btn" lay-submit="" lay-filter="sub" id="btn-submit">提交</button>
    </div>
</form>
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript" src="<%=basePath %>static/js/role/change.js"></script>
</body>
</html>