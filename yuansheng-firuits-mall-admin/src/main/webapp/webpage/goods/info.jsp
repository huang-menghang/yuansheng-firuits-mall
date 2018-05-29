<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>用户详情</title>
</head>
<body class="body">
<form class="layui-form layui-form-pane" >

	<div class="layui-form-item">
        <div class="layui-input-inline">
     	   <img width="160" alt="商品图片" src="" onMouseover="this.width=320" onMouseout="this.width=160">
        </div>
    </div>
<div class="layui-form-item">
	<label class="layui-form-label">商品名</label>
        <div class="layui-input-inline">
            <input type="text" name="name"  
                   class="layui-input">
        </div>
        <label class="layui-form-label">商品销量</label>
        <div class="layui-input-inline">
            <input type="text" name="sales" 
                   class="layui-input">
        </div>
</div>

     <div class="layui-form-item">
        <label class="layui-form-label">商品主分类</label>
        <div class="layui-input-inline">
            <input type="text" name="categoryParentName" 
                   class="layui-input">
        </div>
        <label class="layui-form-label">商品子分类</label>
        <div class="layui-input-inline">
            <input type="text" name="categoryName" 
                   class="layui-input">
        </div>
    </div>
<div class="layui-form-item">
        <label class="layui-form-label">商品售价</label>
        <div class="layui-input-inline">
            <input type="text" name="discoutPrice"  
                   class="layui-input">
        </div>
        <label class="layui-form-label">商品包装</label>
        <div class="layui-input-inline">
            <input type="text" name="packet"  
                   class="layui-input">
        </div>
        </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品品牌</label>
        <div class="layui-input-inline">
            <input type="text" name="brandName"  
                   class="layui-input">
        </div>
        <label class="layui-form-label">上市时间</label>
        <div class="layui-input-inline">
            <input type="text" name="launcTime"  
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">商品重量</label>
        <div class="layui-input-inline">
            <input type="text" name="weight"  
                   class="layui-input">
        </div>
        <label class="layui-form-label">保质期</label>
        <div class="layui-input-inline">
            <input type="text" name="storage"  
                   class="layui-input">
        </div>
    </div>

 <div class="layui-form-item">
    	<label class="layui-form-label">请输入规格</label>
        <div class="layui-input-inline">
            <input type="text" name="standrds"  
                   class="layui-input">
        </div>
	    <label class="layui-form-label">排序权重</label>
        <div class="layui-input-inline">
            <input type="text"  name="sort"  
                   class="layui-input">
        </div>
</div>

    <div class="layui-form-item">
        <label class="layui-form-label">商品描述</label>
        <div class="layui-input-block">
        	<textarea id="LAY_demo_editor" name="description" class="layui-textarea"></textarea>
        </div>
    </div>
</form>
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript" src="<%=basePath %>static/js/goods/info.js"></script>

</body>
</html>