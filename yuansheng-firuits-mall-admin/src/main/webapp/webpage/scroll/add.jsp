<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>   
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp"/>
<title>轮播图添加</title>
</head>
<body>
 <form class="layui-form"  method="post" id="myForm" enctype="multipart/form-data"> 
   
		<div class="layui-form-item">
	        <div class="layui-upload">
			    <button type="button" class="layui-btn" id="scroll_add">上传图片</button>
			    <div class="layui-upload-list">
				    <img class="layui-upload-img" id="image_add" style="width:300px;height:200px;display:none;">
				    <p id="demoText"></p>
			    </div>
		    </div>  
        </div> 
         
        <div class="layui-form-item">    
	        <label class="layui-form-label" style="width:120px;">轮播图名称：</label>
	        <div class="layui-input-inline">
	            <input type="text" autocomplete="off" lay-verify="name" name="name" placeholder="请输入轮播图名称" class="layui-input" style="margin:5px;width:240px;">
	        </div>
        </div>
        
        <div class="layui-form-item"> 
	        <label class="layui-form-label" style="width:120px;">轮播图存放路径：</label>
	        <div class="layui-input-inline">
	            <input type="text" autocomplete="off" lay-verify="imageUrl" name="imageUrl" placeholder="请输入轮播图存放路径" class="layui-input" style="margin:5px;width:240px;">
	        </div>
	    </div>
	    
        <div class="layui-form-item">
	       <label class="layui-form-label" style="width:120px;">轮播图跳转路径： </label>
	        <div class="layui-input-inline">
	            <input type="text" autocomplete="off" lay-verify="imageHref" name="imageHref" placeholder="请输入轮播图跳转路径" class="layui-input" style="margin:5px;width:240px;">
	        </div>
	    </div>
	    
        <div class="layui-form-item">
	        <label class="layui-form-label" style="width:125px;">轮播图索引： </label>
	        <div class="layui-input-inline">
	          <select width="240px" lay-verify="sort" name="sort" style="margin-left:5px;">
	                   <option>请选择</option>
	                   <option value="0">0</option>
	                   <option value="1">1</option>
	           </select>	           
	         </div>
	     </div>
	     
         <div class="layui-form-item">
	         <label class="layui-form-label" style="width:125px;">轮播图状态：</label>
	          <div class="layui-input-inline">
		          <select width="240px" lay-verify="sort" name="sort" style="margin-left:5px;">
		                   <option>请选择</option>
		                   <option value="0">0</option>
		                   <option value="1">1</option>
		           </select>
	           
	          </div>
	     </div>
         
         <div class="layui-form-item">
	         <label class="layui-form-label" style="width:120px;">轮播图创建时间：</label>
		     <div class="layui-input-inline">
		            <input id="add_createTime" type="text" autocomplete="off" lay-verify="createTime" name="createTime" placeholder="请输入轮播图创建时间" class="layui-input" style="margin:5px;width:240px;">
		     </div>
	     </div>   
	        
        <div class="layui-form-item">
	       <div class="layui-form-item layui-form-text">
		       <label class="layui-form-label" style="width:120px;">请输入内容:</label>
		        
		        <div class="layui-input-block" style="width:500px;heigjt:300">
		            <textarea id="LAY_demo_editor" placeholder="请输入内容" lay-verify="description" class="layui-textarea" style="margin-left:40px;" cols="150" rows="8"></textarea>
		        </div>
		    </div>    
        </div>
        
        <div class="layui-form-item">
	        <div id="btn_add" style="margin:0 250px;">
	           <button type="button" class="layui-btn layui-btn-normal btn_commit" lay-submit lay-filter="add_upload" style="margin:30px;">提交</button>
	           <button class="layui-btn layui-btn-warm btn_cancel">取消</button>           
	        </div>
        </div>
  
 </form> 
<jsp:include page="/context/js-tags.jsp"/>
 <script type="text/javascript" src="<%=basePath%>static/js/scroll/add.js"></script>
 <script type="text/javascript" src="<%=basePath%>static/js/plugin/lay-verify/verify.js"></script> 

</body>
</html>