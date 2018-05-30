<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>编辑详情</title>
</head>
<body class="body">
<form class="layui-form layui-form-pane" >
    <div class="layui-form-item">
        <label class="layui-form-label">权限名称</label>
        <div class="layui-input-inline">
            <input type="text" name="permissionName"  
                   autocomplete="off" placeholder="请输入权限名称"   class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <label class="layui-form-label">权限Url</label>
        <div class="layui-input-inline">
            <input type="text" name="permissionUrl" 
                   autocomplete="off" placeholder="请输入权限Url" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">上级权限编码</label>
        <div class="layui-input-inline">
            <input type="text" name="userParentId"  
                   autocomplete="off" placeholder="请输入上级权限编码(数字形式)" class="layui-input">
        </div>
    </div>
    
     <div class="layui-form-item">
        <label class="layui-form-label">权限连接</label>
        <div class="layui-input-inline">
            <input type="text" name="permissionHref" 
                   autocomplete="off" placeholder="请输入权限连接" class="layui-input">
        </div>
     </div>

      <div class="layui-form-item">
        <label class="layui-form-label">权限等级</label>
        <div class="layui-input-inline">
            <input type="text" name="permissionLevel"  
                   autocomplete="off" placeholder="请输入权限等级(数字形式)" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">权限规则描述</label>
        <div class="layui-input-inline">
            <input type="text" name="permissionDescription" 
                   autocomplete="off" placeholder="请输入权限规则描述" class="layui-input">
        </div>
     </div>
     <br>

    <div align="center"><button class="layui-btn mgl-20" id="btn-save">保存</button></div>
</form>
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript" src="<%=basePath %>static/js/permission/edit.js"></script>
</body>
</html>