<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/context/css-tags.jsp"/>
<title>分类添加</title>
</head>
<body>
 <form class="layui-form"  method="post" id="myForm" enctype="multipart/form-data"> 
   
	 <div class="layui-form-item">
        <div class="layui-upload">		
		  <div class="layui-upload-list">
		    <img class="layui-upload-img" id="image_add" style="width:300px;height:200px;display:none;margin-left:200px;">
		    <p id="demoText"></p>
		  </div>
		</div>         
         <div class="layui-form-item">    
        <label class="layui-form-label" style="width:150px;margin-right:6px;">分类图片等级：</label>
           <div class="layui-input-inline">         
              <select class="select-level" width="240px" lay-filter="level" lay-verify="level" name="level" style="margin-left:5px;">
                   <option>请选择</option>
                   <option value="1">1</option>
                   <option value="2">2</option>
              </select>             
           </div>           
           <div class="layui-upload">
			  <button type="button" class="layui-btn" id="category_add">上传图片</button>			 
			  </div>
		   </div>		
     </div>
         
     <div class="layui-form-item">          
        <label class="layui-form-label" style="width:150px;">分类图片名称：</label>
        <div class="layui-input-inline">                     
           <input type="text" autocomplete="off" lay-verify="name" name="name" placeholder="请输入分类图片名称" class="layui-input" style="margin:5px;width:240px;"> 
        </div>
     </div>
        
     <div class="layui-form-item">          
        <label class="layui-form-label" style="width:150px;">父类id：</label>
        <div class="layui-input-inline">                     
           <input type="text" autocomplete="off" lay-verify="parentId" name="parentId" placeholder="请输入分类父类id" class="layui-input" style="margin:5px;width:240px;"> 
        </div>
      </div>
        
      <div class="layui-form-item"> 
        <label class="layui-form-label" style="width:150px;">分类图片存放路径：</label>
        <div class="layui-input-inline">
            <input type="text" autocomplete="off" lay-verify="imageUrl" name="imageUrl" placeholder="请输入分类图片存放路径" class="layui-input" style="margin:5px;width:240px;">
        </div>
      </div>
        
      <div class="layui-form-item">
        <label class="layui-form-label" style="width:150px;margin-right:5px;">分类图片索引： </label>
        <div class="layui-input-inline">
          <select width="240px" lay-verify="sort" name="sort" style="margin-left:5px;">
                   <option>请选择</option>
                   <option value="0">0</option>
                   <option value="1">1</option>
           </select>           
         </div>
       </div>
       
       <div class="layui-form-item">
         <label class="layui-form-label" style="width:150px;margin-right:5px;">分类图片状态：</label>
          <div class="layui-input-inline">
          <select width="240px" lay-verify="status" name="status" style="margin-left:5px;">
                   <option>请选择</option>
                   <option value="0">0</option>
                   <option value="1">1</option>
           </select>          
         </div>
       </div>
    
       <div class="layui-form-item">
	       <div class="layui-form-item layui-form-text">
		       <label class="layui-form-label" style="width:150px;">请输入内容:</label>
		        
		        <div class="layui-input-block" style="width:500px;heigjt:300">
		            <textarea id="LAY_demo_editor" placeholder="请输入内容" lay-verify="description" class="layui-textarea" style="margin-left:70px;" cols="150" rows="8"></textarea>
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
 <script type="text/javascript" src="<%=basePath%>static/js/category-list/add.js"></script>
 <script type="text/javascript" src="<%=basePath%>static/js/plugin/lay-verify/verify.js"></script> 

</body>
</html>