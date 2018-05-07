<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>订单状态返回</title>
</head>
<body>
<!--header-->
<header>
 <a class="iconfont backIcon">&#60;</a>
 <h1>订单状态</h1>
</header>
<div style="height:1rem;"></div>
<section class="return_state">
 <!--订单状态图标：0为成功；1为失败-->
 <h2 class="state_0">订单提交成功！</h2>
 <p>订单编号：${orderId}</p>
 <p>订单金额：<strong>${orderTotalPrice}</strong></p>
 <p>支付时间：<time>${orderDate}</time></p>
 <p>
  <a href="<%=basePath%>order/list">查看订单</a>
  <a href="<%=basePath%>index">返回首页</a>
 </p>
</section>
</body>
</html>

