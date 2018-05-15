<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<input type="hidden" name="basePath" value="<%=basePath%>" />
<script type="text/javascript" src="<%=basePath%>static/js/plugin/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/plugin/common/common.js"></script>
<script type="text/javascript" src="<%=basePath %>static/plugin/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>static/js/plugin/index/index.js"></script>

