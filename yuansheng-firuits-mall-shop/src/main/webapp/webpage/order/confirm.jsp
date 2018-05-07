<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/context/begin-tags.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<title>确认订单</title>
</head>
<body>
<!--header-->
<header>
 <a class="iconfont backIcon">&#60;</a>
 <h1>确认订单</h1>
</header>
<div style="height:1rem;"></div>
<aside class="confirmAddr">
 <p >
  <span class="order-member-name">收货人：</span>
  <span class="order-member-telephone"></span>
 </p>
 <address></address>
 <a class="iconfont">&#60;</a>
</aside>
<dl class="payment">
 <dt>选择支付方式</dt>
 <dd>
  <label><input type="radio" value="ali-pay" name="pay"/>支付宝支付</label>
  <label><input type="radio" value="weixin-pay" name="pay"/>微信支付</label>
 </dd>
</dl>
<section class="order_msg">
 <h2>我要留言</h2>
 <textarea placeholder="选填(亲可以在这里添加想说的话)"></textarea>
</section>
<!--bottom nav-->
<div style="height:1rem;"></div>
<aside class="btmNav">
 <a class="order-total-price" style="background:#64ab5b;color:white;text-shadow:none;"></a>
 <a style="background:#6bc75f;color:white;text-shadow:none;" class="pay">提交订单</a>
</aside>
<jsp:include page="/context/js-tags.jsp"/>
<script src="<%=basePath%>static/js/order/confirm.js" type="text/javascript"></script>
</body>
</html>
