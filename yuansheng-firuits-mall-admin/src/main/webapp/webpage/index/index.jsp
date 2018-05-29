<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>     
<!DOCTYPE html>
<html >
<head>
    <jsp:include page="/context/css-tags.jsp"/>
    <title>首页 </title>
</head>   
<body>

<!-- layout admin -->
<div class="layui-layout layui-layout-admin"> <!-- 添加skin-1类可手动修改主题为纯白，添加skin-2类可手动修改主题为蓝白 -->
    <!-- header -->
    <div class="layui-header my-header">
        <a href="index.html">
            <!--<img class="my-header-logo" src="" alt="logo">-->
            <div class="my-header-logo">源盛智慧农业管理系统</div>
        </a>
        <div class="my-header-btn">
            <button class="layui-btn layui-btn-small btn-nav"><i class="layui-icon">&#xe65f;</i></button>
        </div>

    

        <!-- 顶部右侧添加选项卡监听 -->
        <ul class="layui-nav my-header-user-nav" lay-filter="side-top-right">
            <li class="layui-nav-item">
                <a class="name" href="javascript:;"><i class="layui-icon">&#xe629;</i>主题</a>
                <dl class="layui-nav-child">
                    <dd data-skin="0"><a href="javascript:;">默认</a></dd>
                    <dd data-skin="1"><a href="javascript:;">纯白</a></dd>
                    <dd data-skin="2"><a href="javascript:;">蓝白</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a class="name" href="javascript:;"><img src="<%=basePath %>static/images/code.png" alt="logo"> Admin </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" href-url="demo/login.html"><i class="layui-icon">&#xe621;</i>登录页</a></dd>
                    <dd><a href="javascript:;" href-url="demo/map.html"><i class="layui-icon">&#xe621;</i>图表</a></dd>
                    <dd><a href="/"><i class="layui-icon">&#x1006;</i>退出</a></dd>
                </dl>
            </li>
        </ul>

    </div>
    <!-- side -->
    <div class="layui-side my-side">
        <div class="layui-side-scroll">
            <!-- 左侧主菜单添加选项卡监听 -->
            <ul class="layui-nav layui-nav-tree" lay-filter="side-main">
                <!-- layui-nav-itemed 表示选中 -->
                <li class="layui-nav-item "> 
                    <a href="javascript:;"><i class="layui-icon">&#xe620;</i>商品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="<%=basePath %>brand"><i class="layui-icon">&#xe621;</i>品牌列表</a></dd>
                        <dd><a href="javascript:;" href-url="demo/form.html"><i class="layui-icon">&#xe621;</i>分类列表</a></dd>
                        <dd><a href="javascript:;" href-url="<%=basePath %>goods"><i class="layui-icon">&#xe621;</i>商品列表</a></dd>
                        <dd><a href="javascript:;" href-url="demo/table.html"><i class="layui-icon">&#xe621;</i>优惠劵列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item "> 
                    <a href="javascript:;"><i class="layui-icon">&#xe613;</i>会员管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="<%=basePath %>member"><i class="layui-icon">&#xe621;</i>会员列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item "> 
                    <a href="javascript:;"><i class="layui-icon">&#xe612;</i>用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="demo/login.html"><i class="layui-icon">&#xe621;</i>用户列表</a></dd>
                    </dl>
                </li>
                 <li class="layui-nav-item "> 
                    <a href="javascript:;"><i class="layui-icon">&#xe63c;</i>订单管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="demo/login.html"><i class="layui-icon">&#xe621;</i>订单列表</a></dd>
                    </dl>
                </li>
                 <li class="layui-nav-item "> 
                    <a href="javascript:;"><i class="layui-icon">&#xe634;</i>轮播图管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="demo/login.html"><i class="layui-icon">&#xe621;</i>首页轮播图列表</a></dd>
                    </dl>
                </li>
                  <li class="layui-nav-item "> 
                    <a href="javascript:;"><i class="layui-icon">&#xe62e;</i>权限管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="demo/login.html"><i class="layui-icon">&#xe621;</i>角色列表</a></dd>
                        <dd><a href="javascript:;" href-url="demo/login.html"><i class="layui-icon">&#xe621;</i>权限列表</a></dd>
                        <dd><a href="javascript:;" href-url="demo/login.html"><i class="layui-icon">&#xe621;</i>权限分类列表</a></dd>
                    </dl>
                </li>
                 <li class="layui-nav-item "> 
                    <a href="javascript:;"><i class="layui-icon">&#xe620;</i>系统管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="demo/login.html"><i class="layui-icon">&#xe621;</i>系统日志列表</a></dd>
                        <dd><a href="javascript:;" href-url="demo/login.html"><i class="layui-icon">&#xe621;</i>异常日志列表</a></dd>
                    </dl>
                </li>
                   <li class="layui-nav-item "> 
                    <a href="javascript:;"><i class="layui-icon">&#xe62c;</i>统计管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="demo/login.html"><i class="layui-icon">&#xe621;</i>商品销量统计</a></dd>
                        <dd><a href="javascript:;" href-url="demo/login.html"><i class="layui-icon">&#xe621;</i>会员统计</a></dd>   
                    </dl>
                </li>
            </ul>

        </div>
    </div>
    <!-- body -->
    <div class="layui-body my-body">
        <div class="layui-tab layui-tab-card my-tab" lay-filter="card" lay-allowClose="true">
            <ul class="layui-tab-title">
                <li class="layui-this" lay-id="1"><span><i class="layui-icon">&#xe638;</i>欢迎页</span></li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <iframe id="iframe" src="<%=basePath%>main/welcome" frameborder="0"></iframe>
                </div>
            </div>
        </div>
    </div>
    <!-- footer -->
    <div class="layui-footer my-footer">
        <p><a href="http://vip-admin.com/index/gather/index.html" target="_blank">杭州源盛智慧农业后台管理系统</a></p>
        <!-- <p>2017 © copyright 蜀ICP备17005881号</p> -->
    </div>
</div>

<!-- 右键菜单 -->
<div class="my-dblclick-box none">
    <table class="layui-tab dblclick-tab">
        <tr class="card-refresh">
            <td><i class="layui-icon">&#x1002;</i>刷新当前标签</td>
        </tr>
        <tr class="card-close">
            <td><i class="layui-icon">&#x1006;</i>关闭当前标签</td>
        </tr>
        <tr class="card-close-all">
            <td><i class="layui-icon">&#x1006;</i>关闭所有标签</td>
        </tr>
    </table>
</div>
<jsp:include page="/context/js-tags.jsp"/>
<script type="text/javascript" src="<%=basePath %>static/plugin/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>static/js/plugin/vip/vip_comm.js"></script>
<script type="text/javascript">
layui.use(['layer','vip_nav'], function () {

    // 操作对象
    var layer       = layui.layer
        ,vipNav     = layui.vip_nav
        ,$          = layui.jquery;

    // 顶部左侧菜单生成 [请求地址,过滤ID,是否展开,携带参数]
    // vipNav.top_left('./json/nav_top_left.json','side-top-left',false);
    // // 主体菜单生成 [请求地址,过滤ID,是否展开,携带参数]
    // vipNav.main('./json/nav_main.json','side-main',true);

    // you code ...



});
</script>
</body>
</html>