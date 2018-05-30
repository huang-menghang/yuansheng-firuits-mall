;
var logs_info_ops = {
	init:function(){
	   var id = common_ops.g_getQueryString("id");
	   $.ajax({
		   url:basePath+"logs/"+id,
		   method:"GET",
		   type:"text/json",
		   success:function(res){
			   var data = res.data;
			   if(res.code == 0){
				  $(".layui-form input[name='location']").val(data.location);
				  $(".layui-form input[name='date']").val(data.date);
				  $(".layui-form input[name='logger']").val(data.logger);
				  $(".layui-form input[name='level']").val(data.level);
				  $(".layui-form textarea[name='message']").val(data.message);
			   }
		   }
		   
	   })
	}	
		
}
$(function(){
	logs_info_ops.init();
})
//layui.use(['form'],function(){
//	 var form = layui.form;
//	 var id = common_ops.g_getQueryString("id");
//	   $.ajax({
//		   url:basePath+"logs/"+id,
//		   method:"GET",
//		   type:"text/json",
//		   success:function(res){
//			   var data = res.data;
//			   if(res.code == 0){
//				  $(".layui-form input[name='location']").val(data.location);
//				  $(".layui-form input[name='date']").val(data.date);
//				  $(".layui-form input[name='logger']").val(data.logger);
//				  $(".layui-form input[name='level']").val(data.level);
//				  $(".layui-form textarea[name='message']").val(data.message);
//			   }
//		   }
//		   
//	   })
//})