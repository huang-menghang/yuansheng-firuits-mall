<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/context/css-tags.jsp"/>
    <title>添加-修改</title>
    <jsp:include page="/context/js-tags.jsp"/>
</head>
<body class="body">
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">角色名：</label>

        <div class="layui-input-inline">
            <input type="text" name="roleName" lay-verify="required" placeholder="请输入角色名" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
   <div class="layui-form-item" pane="">
     <label class="layui-form-label">设置权限</label>
       <div class="layui-input-block" id="checkbox">
            
    </div>
   </div>
    <div class="layui-form-item layui-form-text">
         <label class="layui-form-label">角色描述</label>
        <div class="layui-input-block">
            <textarea name="description" placeholder="请输入角色的描述信息" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <button class="layui-btn" lay-submit="" lay-filter="sub" id="btn-submit">提交</button>
    </div>
</form>
<script type="text/javascript" src="<%=basePath %>static/js/role/add.js"></script>
</body>
</html>