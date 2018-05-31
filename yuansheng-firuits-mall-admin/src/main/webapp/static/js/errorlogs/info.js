;
var member_info_ops = {
	init:function(){
	   var id = common_ops.g_getQueryString("id");
	   $.ajax({
		   url:basePath+"errorlogs/"+id,
		   method:"GET",
		   type:"text/json",
		   success:function(res){
			   var data = res.data;
			   if(res.code == 0){
				  $(".layui-form input[name='ip']").val(data.ip);
				  $(".layui-form input[name='osAndbroswer']").val(data.osAndbroswer);
				  $(".layui-form input[name='requestUrl']").val(data.requestUrl);
				  $(".layui-form input[name='requestMethod']").val(data.requestMethod);
				  $(".layui-form input[name='requestParmater']").val(data.requestParmater);
				  $(".layui-form input[name='exceptionMessage']").val(data.exceptionMessage);
				  $(".layui-form input[name='createTime']").val(new Date(data.createTime).format("yyyy-MM-dd hh:mm:ss"));
			   }
		   }
		   
	   })
	}	
		
}
$(function(){
	member_info_ops.init();
})