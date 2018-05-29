<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>      
<!DOCTYPE html>
<html>
<head>
 <jsp:include page="/context/css-tags.jsp"/>
 <title>商品列表</title>
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
				<label class="layui-form-label">商品名称</label>
				</div>
				<div class="layui-input-inline ">
	            <input type="text" name="name" autocomplete="off" placeholder="请输入商品名称" class="layui-input">
	       		</div>
	       	</div>
	       	
	       	<div class="layui-input-inline">
	       	<div class="layui-input-inline ">
				<label class="layui-form-label">分类名称</label>
				</div>
				<div class="layui-input-inline ">
	            <input type="text" name="categoryName" autocomplete="off" placeholder="请输入分类名称" class="layui-input">
	        	</div>
	        </div>
	        
	         <div class="layui-input-inline">
	         <div class="layui-input-inline ">
				<label class="layui-form-label">商品品牌</label>
				</div>
				<div class="layui-input-inline ">
	            <input type="text" name="brandName" autocomplete="off" placeholder="请输入商品品牌" class="layui-input">
	        	</div>
	        </div>
	       
	       <div class="layui-input-inline">
	         <div class="layui-input-inline ">
				<label class="layui-form-label">商品销量</label>
				</div>
	        <div class="layui-input-inline" style="width:80px;">
	            <input type="text" name="startSales" autocomplete="off" placeholder="最低销量" class="layui-input">
	        </div>
	        <div class="layui-input-inline" style="width:10px;">-</div>
	         <div class="layui-input-inline" style="width:80px;">
	            <input type="text" name="endSales" autocomplete="off" placeholder="最高销量" class="layui-input">
	        </div>
	        </div>
	        
	        <div class="layui-input-inline">
	        <div class="layui-input-inline ">
				<label class="layui-form-label">商品售价</label>
				</div>
	        <div class="layui-input-inline" style="width:80px;">
	            <input type="text" name="startPrice" autocomplete="off" placeholder="最低价" class="layui-input">
	        </div>
	        <div class="layui-input-inline" style="width:10px;">-</div>
	         <div class="layui-input-inline" style="width:80px;">
	            <input type="text" name="endPrice" autocomplete="off" placeholder="最高价" class="layui-input">
	        </div>
	        </div>
	        
	        <div class="layui-input-inline">
	        <div class="layui-input-inline ">
				<label class="layui-form-label">上市时间</label>
				</div>
	        <div class="layui-input-inline">
	            <input type="text" name="startTime" autocomplete="off" placeholder="开始时间" class="layui-input">
	        </div>
	         <div class="layui-input-inline">
	            <input type="text" name="endTime" autocomplete="off" placeholder="结束时间" class="layui-input">
	        </div>
	         </div>
	        
	        <div class="layui-input-inline">
	        <div class="layui-input-inline ">
				<label class="layui-form-label">商品状态</label>
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
<script id="launcTime" type="text/html">
    {{#  
    return new Date(d.launcTime.time).format("yyyy-MM-dd hh:mm:ss"); 
    }} 
 </script>
 <script id="status" type="text/html">
    {{#  
    return (d.status == 0 ? "已上架":"已下架"); 
    }} 
 </script>
  <script id="packet" type="text/html">
    {{#  
    return (d.packet == 0 ? "散装":"斤装"); 
    }} 
 </script>
 <script id="barOption" type="text/html">
	<a class="layui-btn layui-btn-mini" lay-event="info">详情</a>
    <a class="layui-btn layui-btn-mini layui-btn-normal" lay-event="edit">编辑</a>
	{{# if(d.status == 0){ }} 
		<a class='layui-btn layui-btn-mini layui-btn-danger' lay-event='pull'>下架</a>
	{{# }else if(d.status == 1){ }}
	<a class='layui-btn layui-btn-mini layui-btn-normal' lay-event='put'>上架</a>
	{{# } }}
</script>
<script type="text/javascript" src="<%=basePath %>static/js/goods/index.js"></script>
</body>
</html>