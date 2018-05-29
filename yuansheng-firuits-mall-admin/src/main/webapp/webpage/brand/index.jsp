<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>      
<!DOCTYPE html>
<html>
<head>
 <jsp:include page="/context/css-tags.jsp"/>
 <title>品牌列表</title>
</head>
<body>
<!-- 工具集 -->
<div class="my-btn-box">
    <span class="fl">
        <a class="layui-btn layui-btn-danger radius btn-delect" id="btn-delete-batch">批量删除</a>
         
        <a class="layui-btn" id="btn-add">添加</a>
        
        <a class="layui-btn btn-add btn-default" id="btn-refresh"><i class="layui-icon">&#x1002;</i></a>
    </span>
</div>
<div class="layui-form layui-form-pane">
		<span class="fl">
			<div class="layui-collapse">
				<div class="layui-colla-item">
					<h2 class="layui-colla-title">搜索</h2>
					<div class="layui-colla-content layui-show">
					
			<div class="layui-input-inline ">
				<div class="layui-input-inline ">
				<label class="layui-form-label">品牌名称</label>
				</div>
				<div class="layui-input-inline ">
	            <input type="text" name="name" autocomplete="off" placeholder="请输入品牌名称" class="layui-input">
	       		</div>
	       	</div>
	        
	        <div class="layui-input-inline">
	        <div class="layui-input-inline ">
	        <label class="layui-form-label">创建时间</label>
	        </div>
	        <div class="layui-input-inline">
	            <input type="text" name="createTimeStart" autocomplete="off" placeholder="开始时间" class="layui-input">
	        </div>
	         <div class="layui-input-inline">
	            <input type="text" name="createTimeEnd" autocomplete="off" placeholder="结束时间" class="layui-input">
	        </div>
	         </div>
	         
	        <div class="layui-input-inline">
	        <div class="layui-input-inline ">
	        <label class="layui-form-label">修改时间</label>
	        </div>
	        <div class="layui-input-inline">
	            <input type="text" name="updateTimeStart" autocomplete="off" placeholder="开始时间" class="layui-input">
	        </div>
	         <div class="layui-input-inline">
	            <input type="text" name="updateTimeEnd" autocomplete="off" placeholder="结束时间" class="layui-input">
	        </div>
	         </div>
	        
	        <div class="layui-input-inline">
	        	<div class="layui-input-inline ">
	        	 <label class="layui-form-label">品牌状态</label>
	        	 </div>
	        	 <div class="layui-input-inline ">
	             <select name="status" lay-filter="status" >
				 <option text="未选择" value="">请选择状态</option>				
				 <option value="0" >已上架</option>
			     <option value="1" >已下架</option>
		        </select>
		        </div>
	        </div>
	        
	        <div class="layui-input-inline">
	        <button class="layui-btn mgl-20" id="btn-search">查询</button>
	        <a class="layui-btn layui-btn-normal " id="btn-reset">重置</a>
				</div>
				</div>
				</div>
		</span>
	</div>
<!-- 表格 -->
<div id="dateTable" lay-filter="table-data">

</div>
<jsp:include page="/context/js-tags.jsp"/>
<script id="createTime" type="text/html">
    {{#  
    return new Date(d.createTime.time).format("yyyy-MM-dd hh:mm:ss"); 
    }} 
 </script>
<script id="updateTime" type="text/html">
    {{#  
    return d.updateTime == null ? "还未进行修改" : new Date(d.updateTime.time).format("yyyy-MM-dd hh:mm:ss"); 
    }} 
 </script>
 <script id="status" type="text/html">
    {{#  
    return (d.status == 0 ? "已上架":"已下架"); 
    }} 
 </script>
 <script id="barOption" type="text/html">
    <a class="layui-btn layui-btn-mini layui-btn-normal" lay-event="edit">编辑</a>
	{{# if(d.status == 0){ }} 
		<a class='layui-btn layui-btn-mini layui-btn-danger' lay-event='pull'>下架</a>
	{{# }else if(d.status == 1){ }}
	<a class='layui-btn layui-btn-mini' lay-event='put'>上架</a>
	{{# } }}
</script>
<script type="text/javascript" src="<%=basePath %>static/js/brand/index.js"></script>
</body>
</html>