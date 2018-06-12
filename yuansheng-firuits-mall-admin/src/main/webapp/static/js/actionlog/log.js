var logs_info_ops = {
	init:function(){
	   var id = common_ops.g_getQueryString("id");
	   $.ajax({
		   url:basePath+"actionlog/log/"+id,
		   method:"GET",
		   type:"text/json",
		   success:function(res){
			   var data = res.data;
			   if(res.code == 0){
				  $(".layui-form input[name='user']").val(data.user);
				  $(".layui-form input[name='requstUrl']").val(data.requstUrl);
				  $(".layui-form input[name='ip']").val(data.ip);
				  $(".layui-form input[name='createTime']").val(new Date(data.createTime).format("yyyy-MM-dd hh:mm:ss"));
				  $(".layui-form input[name='requestMethod']").val(data.requestMethod);
				  $(".layui-form input[name='requestParams']").val(data.requestParams);
				  $(".layui-form input[name='requestControllerMethod']").val(data.requestControllerMethod);
				  $(".layui-form input[name='result']").val(data.result);
				  $(".layui-form input[name='exception']").val(data.exception);
				  $(".layui-form input[name='osAndBrowser']").val(data.osAndBrowser);
			   }
		   }
		   
	   })
	}	
		
}
$(function(){
	logs_info_ops.init();
})