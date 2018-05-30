layui.use(['form'],function() {
	//获取url中的id参数
	var id = common_ops.g_getQueryString("id");
	//初始化表单中的数据
	$.ajax({
		url : basePath + "goods/info/" + id,
		method: "GET",
		type: "text/json",
		success: function(res){
			   var data = $.parseJSON(res.data);
			   console.log(data);
			   if(res.code == 0){
				   $(".layui-form img").attr("src",basePath + data.imagePath);
				   $(".layui-form input[name='name']").val(data.name);
				   $(".layui-form input[name='categoryName']").val(data.categoryName);
				   $(".layui-form input[name='categoryParentName']").val(data.categoryParentName);
				   $(".layui-form input[name='brandName']").val(data.brandName);
				   $(".layui-form input[name='weight']").val(data.weight + "KG");
				   $(".layui-form input[name='storage']").val(data.storage + "个月");
				   $(".layui-form input[name='packet']").val(data.packet == 0 ? "散装":"斤装");
				   $(".layui-form input[name='sales']").val(data.sales);
				   $(".layui-form input[name='sort']").val(data.sort);
				   $(".layui-form input[name='standrds']").val(data.standrds);
				   $(".layui-form input[name='discoutPrice']").val("￥" + data.discoutPrice + " 元");
				   $(".layui-form input[name='launcTime']").val(new Date(data.launcTime.time).format("yyyy-MM-dd hh:mm:ss"));
				   $(".layui-form textarea[name='description']").val(data.description);
			   }
		   }
	});
})
			
	