;
layui.use(['laydate','form'],function(){
	var form = layui.form;
	var laydate = layui.laydate;
	form.on('submit(save)',function(data){
		alert("点击成功");
		alert($(".layui-form input[name='permissionName']").val());
			$.ajax({
				url:basePath + "permission/insert",
				method : "POST",
				data:{
					  permissionName:$("input[name='permissionName']").val(),
					   permissionUrl:$("input[name='permissionUrl']").val(),
					   permissionId:$("input[name='userParentId']").val(),
					   permissionHref:$("input[name='permissionHref']").val(),
					   permissionLevel:$("input[name='permissionLevel']").val(),
					   permissionDescription:$("input[name='permissionDescription']").val(),
					   createTime:$("input[name='createTime']").val(),
					   status:$("input[name='status']").val()
				},
				success:function(res){
					console.log(res);
				}
			})
		});
	
    var create = {
    		elem : ".layui-form input[name='createTime']",
    		min : '2017-01-01 23:59:59',
    		max : '2099-06-16 23:59:59',
    		format : 'yyyy-MM-dd HH:mm:ss',
    		type : 'datetime',
    		trigger : 'click',
    		zIndex : 99999999
    		
            };
    
    var update = {
    		elem : ".layui-form input[name='updateTime']",
    		min : '2017-01-01 23:59:59',
    		max : '2099-06-16 23:59:59',
    		format : 'yyyy-MM-dd HH:mm:ss',
    		type : 'datetime',
    		trigger : 'click',
    		zIndex : 99999999
    		
           };
     
      laydate.render(create);
      laydate.render(update);
//      $.ajax({
//		   url:basePath+"permission/insert",
//		   method:"POST",
//		   type:"text/json",
//		   data:{
//			  // id:data.field.id
//			   //id:$(".layui-form input[name='id']").val(),
//			   permissionName:$("input[name='permissionName']").val(),
//			   permissionUrl:$("input[name='permissionUrl']").val(),
//			   permissionId:$("input[name='permissionId']").val(),
//			   permissionHref:$("input[name='permissionHref']").val(),
//			   permissionLevel:$("input[name='permissionLevel']").val(),
//			   permissionDescription:$("input[name='permissionDescription']").val(),
//			   status:$("input[name='status']")
//			//   createTime:$("input[name='createTime']").val(),
//			//   updateTime:$("input[name='updateTime']").val()
//		   },
//		   success:function(res){
//			   console.log(res);
//		   },
//		   error:function(){
//			   console.log("11111");
//		   }
//	   }) 

})