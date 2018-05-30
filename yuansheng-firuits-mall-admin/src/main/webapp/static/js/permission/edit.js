;
var permission_edit_ops = {
	init:function(){
	   $('#btn-save').on('click',function () {
		   var id = common_ops.g_getQueryString("id");
		   $.ajax({
			   url:basePath+"permission/"+id,
			   method:"POST",
			   type:"text/json",
			   data:{
				   permissionName:$(".layui-form input[name='permissionName']").val(),
				   permissionUrl:$(".layui-form input[name='permissionUrl']").val(),
				   userParentId:$(".layui-form input[name='userParentId']").val(),
				   permissionHref:$(".layui-form input[name='permissionHref']").val(),
				   permissionLevel:$(".layui-form input[name='permissionLevel']").val(),
				   permissionDescription:$(".layui-form input[name='permissionDescription']").val(),
			   },
		       success:function(res){
		    	   if (res.code == 0) {
					console.log("AAAAAAA");
				}
		       }
		   })
	   })
	   
	}	
		
}
$(function(){
	permission_edit_ops.init();
})