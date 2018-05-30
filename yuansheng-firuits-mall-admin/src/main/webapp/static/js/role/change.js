layui.use(['form', 'layedit', 'laydate', 'element'],function(){
	var form = layui.form
    , layer = layui.layer
    , layedit = layui.layedit
    , laydate = layui.laydate
    , element = layui.element;
	
	var id;
	
	$(function(){
		var url = window.location.href;
		id = url.split("id=")[1];
		$.ajax({
			url:basePath+"permission/ishave/"+id,
			method:"POST",
			type:"json",
			success:function(res){
				console.log(res);
				var data = $.parseJSON(res.data);
				$.each(data.roleHave,function(i, v){
						$("#have").append(
								"<input type='checkbox' name='"+v.id+"' lay-skin='primary' title='"+v.permissionName+"'>");
						if (i%2==1) {
							$("#checkbox").append("</br>");
					}
					});
				$.each(data.roleNotHave,function(i, v){
					$("#notHave").append(
							"<input type='checkbox' name='"+v.id+"' lay-skin='primary' title='"+v.permissionName+"'>");
					if (i%2==1) {
						$("#checkbox").append("</br>");
				}
				});
				 form.render();
			}
		});
	});
	
	form.on('submit(sub)', function (data) {
    	$("#btn-submit").addClass('layui-btn-disabled');
    	layer.confirm('确认修改权限？',function(index){
    		var message = JSON.stringify(data.field);
     	   $.ajax({
     		  url:basePath+"role/changePermission/"+id,
     		  method:"POST",
     		  type:"text/json",
     		  contentType : "application/json",
     		  data:message,
     		  success:function(){
     			 layer.close(index);
     			 layer.msg('修改成功!', {
                    icon: 6,
                    time: 800 //2秒关闭（如果不配置，默认是3秒）
                  }, function(){
                	  var thisIndex = parent.layer.getFrameIndex(window.name);
                  	  parent.layer.close(thisIndex);
                  });  
     		  }
     	   });
        });
    	$("#btn-submit").removeClass('layui-btn-disabled');
    	return false;
    });
})