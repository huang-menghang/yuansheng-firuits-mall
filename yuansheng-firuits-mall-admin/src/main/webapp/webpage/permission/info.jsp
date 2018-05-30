<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>权限详情</title>
</head>
<body class="body">
<form class="layui-form layui-form-pane" >
    <div class="layui-form-item">
        <label class="layui-form-label">权限名称</label>
        <div class="layui-input-inline">
            <input type="text" name="permissionName"  
                   class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <label class="layui-form-label">权限Url</label>
        <div class="layui-input-inline">
            <input type="text" name="permissionUrl" 
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">上级权限编码</label>
        <div class="layui-input-inline">
            <input type="text" name="userParentId"  
                   class="layui-input">
        </div>
    </div>
    
     <div class="layui-form-item">
        <label class="layui-form-label">权限连接</label>
        <div class="layui-input-inline">
            <input type="text" name="permissionHref" 
                   class="layui-input">
        </div>
     </div>

      <div class="layui-form-item">
        <label class="layui-form-label">权限等级</label>
        <div class="layui-input-inline">
            <input type="text" name="permissionLevel"  
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">权限规则描述</label>
        <div class="layui-input-inline">
            <input type="text" name="permissionDescription" 
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
<script type="text/javascript" src="<%=basePath %>static/js/permission/info.js"></script>
</body>
</html>