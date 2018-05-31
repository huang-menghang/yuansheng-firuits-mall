<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp"/>
<title>分类列表</title>
</head>
<body>
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
	    
	        <label style="width:150px;">图片分类id：</label>
	        <div class="layui-input-inline">
	            <input type="text" autocomplete="off" name="id" placeholder="请输入搜索id" class="layui-input" style="width:240px;margin-left:34px;margin-bottom:5px;">
	        </div>
	        
	        <label style="width:150px;margin-left:100px;">图片分类名称：</label>
	        <div class="layui-input-inline">
	            <input type="text" autocomplete="off" name="name" placeholder="请输入搜索名称" class="layui-input" style="width:240px;margin-left:24px;margin-bottom:5px;">
	        </div><br/>
	        
	        <label style="width:150px;">图片分类等级：</label>
	        <div class="layui-input-inline">
	            <input type="text" autocomplete="off" name="level" placeholder="请输入搜索等级" class="layui-input" style="width:240px;margin-left:18px;margin-bottom:5px;">
	        </div>
	       
	        <label style="width:150px;margin-left:100px;">图片分类详情：</label>
	        <div class="layui-input-inline">
	            <input type="text" autocomplete="off" name="description" placeholder="请输入搜索详情关键字" class="layui-input" style="width:240px;margin-left:24px;margin-bottom:5px;">
	        </div><br/>
	        
	        <label style="width:150px;">上传时间范围：</label>
	        <div class="layui-input-inline">
	            <input type="text" autocomplete="off" name="startTime" placeholder="请输入起始时间" class="layui-input" style="width:240px;margin-left:18px;margin-bottom:5px;">
	        </div>
	        
	        <label  style="width:150px;margin-left:100px;">请输入截止时间:</label>
	        <div class="layui-input-inline">
	            <input type="text" autocomplete="off" name="endTime" placeholder="请输入截止时间" class="layui-input" style="width:240px;margin-left:20px;margin-bottom:5px;">
	        </div><br/>
	        
	        <button class="layui-btn mgl-20" id="btn_query">查询</button>
	    </div>
	  </div>
   </div>
   
   <div id="dateTable" lay-filter="table-data"></div>
   
 <jsp:include page="/context/js-tags.jsp"/>
 <script type="text/javascript" src="<%=basePath%>static/js/category-list/index.js"></script>
 <script>
//注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
});
</script>
 <script type="text/html" id="dateTime">
     {{#  
    console.log("验证日期对不对 ： "+d.createTime);
    return new Date(d.createTime.time).format("yyyy-MM-dd hh:mm:ss"); 
    }}

</script>
   <script type="text/html" id="status">
    {{#  
    console.log("d.status 的值为 = "+d.status);
    return (d.status == 0 ? "正常":"下架"); 
    }}
</script>
<script type="text/html" id="barOption">
   {{#
    var status = d.status;  
     console.log("barOption 中status = "+d.status);
    var barOption = "<a class='layui-btn layui-btn-mini layui-btn-normal' lay-event='edit'>编辑</a>";
    status == 0 ? barOption+="<a class='layui-btn layui-btn-mini layui-btn-danger' lay-event='del'>下架</a>":barOption+="<a class='layui-btn layui-btn-mini layui-btn-normal' lay-event='rec'>激活</a>";
    return  barOption;    
   }} 
</script>

</body>
</html>
