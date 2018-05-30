;
var permission_info_ops = {
	init:function(){
	   var id = common_ops.g_getQueryString("id");
	   $.ajax({
		   url:basePath+"permission/"+id,
		   method:"GET",
		   type:"text/json",
		   success:function(res){
			   var data = res.data;
			   if(res.code == 0){
				  $(".layui-form input[name='permissionName']").val(data.userPermissionName);
				  $(".layui-form input[name='permissionUrl']").val(data.userPermissionUrl);
				  $(".layui-form input[name='userParentId']").val(data.parentId);
				  $(".layui-form input[name='permissionHref']").val(data.userPermissionHref);
				  $(".layui-form input[name='permissionLevel']").val(data.userPermissionLevel);
				  $(".layui-form input[name='permissionDescription']").val(data.userPermissionDescription);
				  $(".layui-form input[name='createTime']").val(new Date(data.createTime).format("yyyy-MM-dd hh:mm:ss"));
			   }
		   }
		   
	   })
	}	
		
}
$(function(){
	permission_info_ops.init();
})