;
var member_info_ops = {
	init:function(){
	   var id = common_ops.g_getQueryString("id");
	   $.ajax({
		   url:basePath+"member/"+id,
		   method:"GET",
		   type:"text/json",
		   success:function(res){
			   var data = res.data;
			   if(res.code == 0){
				  $(".layui-form input[name='memberName']").val(data.name);
				  $(".layui-form input[name='mobile']").val(data.mobile);
				  $(".layui-form input[name='telephone']").val(data.telephone);
				  $(".layui-form input[name='address']").val(data.detailAddress);
				  $(".layui-form input[name='restaurant']").val(data.restaurant);
				  $(".layui-form input[name='createTime']").val(new Date(data.createTime).format("yyyy-MM-dd hh:mm:ss"));
			   }
		   }
		   
	   })
	}	
		
}
$(function(){
	member_info_ops.init();
})