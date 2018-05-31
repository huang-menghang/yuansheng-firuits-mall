<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>      
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/context/css-tags.jsp"/>
    <title>轮播图表格</title>
    
</head>
<body class="body">

	<!-- 工具集 -->
	<div class="my-btn-box">
	    <span class="fl">
	        <a class="layui-btn layui-btn-danger radius btn-delect" id="btn-delete-all">批量删除</a>
	        <a class="layui-btn btn-add btn-default" id="btn-add" >添加</a>
	        <a class="layui-btn btn-add btn-default" id="btn-refresh"><i class="layui-icon">&#x1002;</i></a>
	    </span> 
	</div> 

	<div class="layui-collapse layui-form">
	  <div class="layui-colla-item">
	    <h2 class="layui-colla-title">搜索</h2>
	    <div class="layui-colla-content layui-show">
	    
	        <span>轮播图id：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
	        <div class="layui-input-inline">
	            <input type="text" autocomplete="off" name="id" placeholder="请输入搜索id" class="layui-input" >
	        </div>
	        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	        
	        <span>轮播图名称：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
	        <div class="layui-input-inline">
	            <input type="text" autocomplete="off" name="name" placeholder="请输入搜索名称" class="layui-input" >
	        </div><br/>
	        
	        <span>上传时间范围：</span>
	        <div class="layui-input-inline">
	            <input type="text" autocomplete="off" name="startTime" placeholder="请输入起始时间" class="layui-input">
	        </div>
	        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	        
	        <span>请输入截止时间:</span>&nbsp&nbsp
	        <div class="layui-input-inline">
	            <input type="text" autocomplete="off" name="endTime" placeholder="请输入截止时间" class="layui-input">
	        </div><br/>
	        
	        <button class="layui-btn mgl-20" id="btn_query">查询</button>
	    </div>
	  </div>
	</div>
<!-- 表格 -->
<div id="dateTable" lay-filter="table-data"></div>

<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript" src="<%=basePath %>static/js/scroll/index.js"></script>
<script>
//注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
});
</script>

<!-- 表格操作按钮集 -->
<script type="text/html" id="createTime">
     {{#  
     console.log("d指什么 ： "+d);
     console.log(d.createTime);
    return new Date(d.createTime.time).format("yyyy-MM-dd hh:mm:ss"); 
    }}

</script>
<script type="text/html" id="status">
    {{#  
    console.log(d.status);
    return (d.status == 0 ? "正常":"下架"); 
    }}
</script>
<script type="text/html" id="barOption">
   {{#
    var status = d.status;   
    var barOption = "<a class='layui-btn layui-btn-mini' lay-event='detail'>查看</a> <a class='layui-btn layui-btn-mini layui-btn-normal' lay-event='edit'>编辑</a>";
    status == 0 ? barOption+="<a class='layui-btn layui-btn-mini layui-btn-danger' lay-event='del'>下架</a>":barOption+="<a class='layui-btn layui-btn-mini layui-btn-normal' lay-event='rec'>激活</a>";
    return  barOption;    
   }} 
</script>
</body>
</html>