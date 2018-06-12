<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>      
<!DOCTYPE html>
<html>
<head>
 <jsp:include page="/context/css-tags.jsp"/>
 <title>系统日志列表</title>
</head>
<body>
<!-- 工具集 -->
<div class="my-btn-box">
    <span class="fl">
        <a class="layui-btn layui-btn-normal " id="btn-reset">重置</a>
        
        <a class="layui-btn btn-add btn-default" id="btn-refresh"><i class="layui-icon">&#x1002;</i></a>
    </span>
</div>
<div class="layui-form">
 <span class="fl">
        <div class="layui-input-inline ">
            <input type="text" name="user" autocomplete="off" placeholder="用户名" class="layui-input">
        </div>
        
        <div class="layui-input-inline">
            <input type="text" name="ip" autocomplete="off" placeholder="ip地址" class="layui-input">
        </div>
  
        <div class="layui-input-inline">
            <input type="text"  name="requestUrl" autocomplete="off" placeholder="请求地址" class="layui-input">
        </div>
        
        <div class="layui-input-inline">
        <label class="layui-input-inline">时间范围</label>
        <div class="layui-input-inline">
            <input type="text" name="startTime" autocomplete="off" placeholder="开始时间" class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="text" name="endTime" autocomplete="off" placeholder="结束时间" class="layui-input">
        </div>
        </div>

        <button class="layui-btn mgl-20" id="btn-search">查询</button>
        
    </span>
</div>
<br><br><br>
<!-- 表格 -->
<div id="dateTable" lay-filter="table-data">


</div>
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/html" id="params">
{{#
var params = d.requestParams;
console.log(params);
if(params.length > 0){
    return params;
}else{
   return "无";
}
}}
</script>
 <script id="barOption" type="text/html">
     <a class='layui-btn layui-btn-mini' lay-event='detail'>查看</a>
</script>
<script type="text/javascript" src="<%=basePath %>static/js/actionlog/actionlog.js"></script>
</body>
</html>