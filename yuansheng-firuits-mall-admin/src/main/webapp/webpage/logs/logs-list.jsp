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
        <a class="layui-btn layui-btn-danger radius btn-delect" id="btn-delete-batch">批量删除</a>
         
        <a class="layui-btn layui-btn-normal " id="btn-reset">重置</a>
        
        <a class="layui-btn btn-add btn-default" id="btn-refresh"><i class="layui-icon">&#x1002;</i></a>
    </span>
</div>
<div class="layui-form">
 <span class="fl">
        <div class="layui-input-inline ">
            <input type="text" name="logger" autocomplete="off" placeholder="请输入所属的类名" class="layui-input">
        </div>
        
        <div class="layui-input-inline">
            <input type="text" name="level" autocomplete="off" placeholder="请输入优先级" class="layui-input">
        </div>
  
        <div class="layui-input-inline">
            <input type="text"  name="message" autocomplete="off" placeholder="请输入过程信息" class="layui-input">
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

 <script id="barOption" type="text/html">
   {{#
    var status = d.status;   
    var barOption = "<a class='layui-btn layui-btn-mini' lay-event='detail'>查看</a>";
    return  barOption;
    
   }} 
</script>
<script type="text/javascript" src="<%=basePath %>static/js/logs/index.js"></script>
</body>
</html>