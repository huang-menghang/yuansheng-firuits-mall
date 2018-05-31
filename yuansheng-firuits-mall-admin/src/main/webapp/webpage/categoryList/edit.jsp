<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>编辑图片分类</title>
</head>
<body>
	<form class="layui-form">
		<div class="layui-colla-content layui-show" id="add_category_info">

			<div class="layui-input-inline" style="margin-left: 220px;">
				<image class="layui-upload-img" id="categoryImage" src="#" style="display:none;width:300px;height:200px;margin: 10px auto;" />
			</div><br /> 
			
			<label class="layui-form-label" style="width: 160px;">图片分类名称：</label>
			<div class="layui-input-inline">
				<input type="text" autocomplete="off" name="name" class="layui-input" style="margin: 5px; width: 240px;">
			</div><br /> 
			
			<label class="layui-form-label" style="width: 160px;">图片分类存放路径：</label>
			<div class="layui-input-inline">
				<input type="text" autocomplete="off" name="imageUrl" class="layui-input" style="margin: 5px; width: 240px;">
			</div><br/> 
			
			<label class="layui-form-label" style="width: 160px;">轮播图排序：</label>
			<div class="layui-input-inline">
				<input type="text" autocomplete="off" name="sort" class="layui-input" style="margin: 5px; width: 240px;">
			</div><br /> 
			
			<label class="layui-form-label" style="width: 160px; margin-right: 5px">图片分类状态： </label>
			<div class="layui-input-inline">
				<select width="240px" lay-verify="status" name="status" style="margin-left: 15px;">
					<option>请选择</option>
					<option value="0">0</option>
					<option value="1">1</option>
				</select>
			</div><br /> 
			
			<label class="layui-form-label" style="width: 160px;">图片分类父类id：</label>
			<div class="layui-input-inline">
				<input type="text" autocomplete="off" name="parentId" class="layui-input" style="margin: 5px; width: 240px;">
			</div><br />
			
			<label class="layui-form-label" style="width: 160px;">图片分类创建时间：</label>
			<div class="layui-input-inline">
				<input type="text" autocomplete="off" name="createTime" class="layui-input" style="margin: 5px; width: 240px;">
			</div><br/>
			
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label" style="width: 153px;">请输入内容:</label>

				<div class="layui-input-block" style="width: 500px; heigjt: 300">
					<textarea id="LAY_demo_editor" placeholder="请输入内容" class="layui-textarea" style="margin-left: 70px;" cols="150" rows="8"></textarea>
				</div><br/>
				
				<div style="margin: 0 250px;">
					<button type="button" class="layui-btn layui-btn-normal btn_commit" lay-submit lay-filter="category_info_submit" style="margin: 30px;">提交</button>
					<button class="layui-btn layui-btn-warm btn_cancel" lay-submit lay-filter="category_info_cancel">取消</button>
				</div>
			</div>
		</div>
	</form>
	<jsp:include page="/context/js-tags.jsp" />
	<script type="text/javascript" src="<%=basePath%>static/js/category-list/edit.js"></script>

</body>
</html>