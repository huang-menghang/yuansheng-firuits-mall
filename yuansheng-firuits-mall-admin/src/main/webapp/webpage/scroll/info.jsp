<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/context/css-tags.jsp"/>
<title>轮播图详情</title>
</head>
<body>
  <div class="layui-colla-content layui-show" id="add_scroll_info">
        
        <div class="layui-input-inline" style="margin-left:220px;" >
            <image id="scrollImage" src="#" style="width:300px;height:200px;margin: 10px auto;"/>
        </div><br/>
        
        <label class="layui-form-label" style="width:120px;">轮播图id： </label>
        <div class="layui-input-inline">
            <input type="text" autocomplete="off" name="id" placeholder="请输入搜索id" class="layui-input" style="margin:5px;width:240px;" readonly="readonly">
        </div><br/>
        
        <label class="layui-form-label" style="width:120px;">轮播图名称：</label>
        <div class="layui-input-inline">
            <input type="text" autocomplete="off" name="name" placeholder="请输入轮播图名称" class="layui-input" style="margin:5px;width:240px;" readonly="readonly">
        </div><br/>
        
        <label class="layui-form-label" style="width:120px;">轮播图存放路径：</label>
        <div class="layui-input-inline">
            <input type="text" autocomplete="off" name="imageUrl" placeholder="请输入轮播图存放路径" class="layui-input" style="margin:5px;width:240px;" readonly="readonly">
        </div><br/>
        
       <label class="layui-form-label" style="width:120px;">轮播图跳转路径： </label>
        <div class="layui-input-inline">
            <input type="text" autocomplete="off" name="imageHref" placeholder="请输入轮播图跳转路径" class="layui-input" style="margin:5px;width:240px;" readonly="readonly">
        </div><br/>
        
        <label class="layui-form-label" style="width:120px;">轮播图索引： </label>
        <div class="layui-input-inline">
            <input type="text" autocomplete="off" name="sort" placeholder="请输入轮播图索引" class="layui-input" style="margin:5px;width:240px;" readonly="readonly">
        </div><br/>
        
         <label class="layui-form-label" style="width:120px;">轮播图状态：</label>
        <div class="layui-input-inline">
            <input type="text" autocomplete="off" name="status" placeholder="请输入轮播图状态" class="layui-input" style="margin:5px;width:240px;" readonly="readonly">
        </div><br/>
        
        <label class="layui-form-label" style="width:120px;">轮播图创建时间：</label>
        <div class="layui-input-inline">
            <input type="text" autocomplete="off" name="createTime" placeholder="请输入轮播图创建时间" class="layui-input" style="margin:5px;width:240px;" readonly="readonly">
        </div><br/>
        
       <div class="layui-form-item layui-form-text">
	       <label class="layui-form-label" style="width:120px;">请输入内容:</label>
	       <div class="layui-input-block" style="width:500px;heigjt:300">
	           <textarea id="LAY_demo_editor" placeholder="请输入内容" class="layui-textarea" style="margin-left:40px;" cols="150" rows="8" readonly="readonly"></textarea>
	       </div>        
       </div>
       
   </div>
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript" src="<%=basePath%>static/js/scroll/info.js"></script>
</body>
</html>