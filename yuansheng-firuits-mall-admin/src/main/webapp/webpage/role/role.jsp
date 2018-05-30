<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
 <jsp:include page="/context/css-tags.jsp"/>
 <title>角色列表</title>
</head>
<body>
<!-- 工具集 -->
<div class="my-btn-box">
    <span class="fl">
        <a class="layui-btn btn-add btn-default" id="btn-add" >添加</a>
        
        <a class="layui-btn btn-add btn-default" id="btn-refresh"><i class="layui-icon">&#x1002;</i></a>
    </span>
</div>
<!-- 表格 -->
<div id="dateTable" lay-filter="table-data">


</div>
<jsp:include page="/context/js-tags.jsp"/>
<script id=permission type="text/html">
    {{#  
   var pers = d.permissions;
   if(pers == null || pers.length == 0){
      return "";
   }
   var per = pers[0].permissionName;
   for(var i=1;i<pers.length;i++){
      per += "、" + pers[i].permissionName;
   }
   return per;
    }} 
 </script>
 <script id="barOption" type="text/html">  
    <a class='layui-btn layui-btn-mini' lay-event='edit'>修改信息</a>
    <a class='layui-btn layui-btn-mini' lay-event='change'>修改权限</a>
    <a class='layui-btn layui-btn-mini layui-btn-danger' lay-event='del'>删除</a>
</script>
<script type="text/javascript" src="<%=basePath %>static/js/role/role.js"></script>
</body>
</html>    