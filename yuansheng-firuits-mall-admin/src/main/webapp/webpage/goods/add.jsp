<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>添加商品</title>
</head>
<body class="body">
<form class="layui-form layui-form-pane"  method="post" id="myForm" enctype="multipart/form-data">
<div class="layui-form-item">
        <div class="layui-input-inline">
     	   <img width="160" alt="商品图片" src="" onMouseover="this.width=320" onMouseout="this.width=160">
        </div>
    </div>
<div class="layui-form-item">
	<label class="layui-form-label">商品名</label>
        <div class="layui-input-inline">
            <input type="text" lay-verify="required|name" placeholder="请输入商品名称" name="name"  
                   class="layui-input">
        </div>
                <label class="layui-form-label">上市时间</label>
        <div class="layui-input-inline">
            <input type="text"   lay-verify="required" placeholder="请选择上市时间" name="launcTime"  
                   class="layui-input" id="launcTime">
        </div>
	</div>
     <div class="layui-form-item">
        <label class="layui-form-label">商品分类</label>
        <div class="layui-input-inline" >
        <select name="categoryParentName" lay-verify="required" id="categories"  lay-filter="categories">
                <option value="">请选择主分类</option>
         </select>
         </div>
         <div class="layui-input-inline">
          <select name="categoryName"  lay-verify="required" id="secondCategories">
                <option value="">请选择子分类</option>
         </select>
         </div>
    </div>
	<div class="layui-form-item">
        <label class="layui-form-label">商品原价</label>
        <div class="layui-input-inline">
            <input type="text" placeholder="请输入商品原价,纯数字" lay-verify="required|number" name="price"  
                   class="layui-input">
        </div>
                <label class="layui-form-label">商品售价</label>
        <div class="layui-input-inline">
            <input type="text"  lay-verify="number|required" placeholder="请输入商品售价,纯数字" name="discoutPrice"  
                   class="layui-input" id="">
        </div>
        </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品品牌</label>
        <div class="layui-input-inline">
        <select name="brandName"  lay-verify="required" id = "brandName">
                <option value="">请选择品牌</option>
         </select>
         </div>
         <label class="layui-form-label">商品包装</label>
         <div class="layui-input-inline">
        <select name="packet"  lay-verify="required">
                <option value="">请选择包装</option>
                <option value="0">散装</option>
                <option value="1">斤装</option>     
         </select>
         </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">商品重量</label>
        <div class="layui-input-inline">
            <input type="text" lay-verify="required|number" placeholder="重量,纯数字,XXkg" name="weight"  
                   class="layui-input">
        </div>
        <label class="layui-form-label">保质期</label>
        <div class="layui-input-inline">
            <input type="text"  lay-verify="required|number" placeholder="保质期,纯数字,XX个月" name="storage"  
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
    	<label class="layui-form-label">请输入规格</label>
        <div class="layui-input-inline">
            <input type="text"  lay-verify="required" placeholder="例:XX/包,XX/盒,XX/袋,散装" name="standrds"  
                   class="layui-input">
        </div>
	    <label class="layui-form-label">排序权重</label>
        <div class="layui-input-inline">
            <input type="text"  lay-verify="sort|number|required" placeholder="请输入排序号,0-9" name="sort"  
                   class="layui-input">
        </div>
</div>
	  <div class="layui-form-item">
	<div class="layui-upload">
				<input type="text" name="imagePath" style="display: none;">
			  <button type="button" class="layui-btn layui-btn-normal" id="chooseFile">选择文件</button>
			  <button type="button" class="layui-btn" id="uploadFile">开始上传</button>
		</div>
</div>
    <div class="layui-form-item">
        <label class="layui-form-label" >商品描述</label>
        <div class="layui-input-block">
        	<textarea lay-verify="required|description" name="description"  placeholder="请输入内容5-120字" class="layui-textarea"></textarea>
        </div>
    </div>
     <div class="layui-input-inline">
        <button type="button" class="layui-btn" lay-submit lay-filter="sub">提交</button>
        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
</form>
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript" src="<%=basePath %>static/js/goods/add.js"></script>
</body>
</html>