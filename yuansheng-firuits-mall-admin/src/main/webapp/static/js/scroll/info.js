;
var scroll_info_ops={
		init:function(){
			this.initInfo();			
		},
		initInfo:function(){
			var id = common_ops.g_getQueryString("id");
			console.log("info 中 id : "+id);
			$.ajax({
				url:basePath+"scroll/list/"+id,
				method:"post",
				type:"text/json",
				success:function(res){
					if(res.code==0){
						console.log("321___000000");
						var data = $.parseJSON(res.data);
						console.log(data.createTime);
						$("#scrollImage").attr("src",basePath+data.imageUrl);
						$("input[name='id']").val(data.id);
						$("input[name='name']").val(data.name);
						$("input[name='imageHref']").val(data.imageHref);
						$("input[name='imageUrl']").val(data.imageUrl);
						$("input[name='sort']").val(data.sort);
						$("input[name='status']").val(data.status);
						$("textarea[name='description']").val(data.description);
						$("input[name='createTime']").val(new Date(data.createTime.time).format("yyyy-MM-dd hh:mm:ss"));
					}
				},
				error:function(){
			      common_ops.msg(" 查看失败！",null);					
			    }
			})
		}		
};
$(function(){
	scroll_info_ops.init();
})