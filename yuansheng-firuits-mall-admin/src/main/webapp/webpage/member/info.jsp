<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>用户详情</title>
</head>
<body class="body">
<form class="layui-form layui-form-pane" >
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input type="text" name="memberName"  
                   class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <label class="layui-form-label">手机号码</label>
        <div class="layui-input-inline">
            <input type="text" name="mobile" 
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">电话号码</label>
        <div class="layui-input-inline">
            <input type="text" name="telephone"  
                   class="layui-input">
        </div>
    </div>
    
     <div class="layui-form-item">
        <label class="layui-form-label">详细地址</label>
        <div class="layui-input-inline">
            <input type="text" name="address" 
                   class="layui-input">
        </div>
     </div>

      <div class="layui-form-item">
        <label class="layui-form-label">饭店</label>
        <div class="layui-input-inline">
            <input type="text" name="restaurant"  
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
<script type="text/javascript" src="<%=basePath %>static/js/member/info.js"></script>
</body>
</html>