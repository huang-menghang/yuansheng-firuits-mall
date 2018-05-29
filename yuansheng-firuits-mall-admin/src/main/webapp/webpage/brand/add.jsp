<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>添加品牌</title>
</head>
<body class="body">
<form class="layui-form layui-form-pane" >

<div class="layui-form-item">
	<label class="layui-form-label">品牌名</label>
        <div class="layui-input-inline">
            <input type="text" lay-verify="required|name" placeholder="请输入商品名称" name="name"  
                   class="layui-input">
        </div>
</div>
<div class="layui-form-item">
        <label class="layui-form-label" >商品描述</label>
        <div class="layui-input-block">
        	<textarea lay-verify="required|description" name="description"  placeholder="请输入内容5-120字" class="layui-textarea"></textarea>
        </div>
</div>
     <div class="layui-input-inline">
        <button type="button" class="layui-btn" lay-submit lay-filter="sub">提交</button>
        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
</form>
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript" src="<%=basePath %>static/js/brand/add.js"></script>
</body>
</html>