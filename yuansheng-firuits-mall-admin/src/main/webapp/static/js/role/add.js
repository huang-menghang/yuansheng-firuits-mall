 layui.use(['form', 'layedit', 'laydate', 'element'], function () {
        var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
                , laydate = layui.laydate
                , element = layui.element;
        
       $(function(){
    	  $.ajax({
    		 url:basePath+"permission/list",
    		 method:"post",
    		 type:"text/json",
    		 success:function(res){
    			 if (res.code==0) {
    				 $.each($.parseJSON(res.data),function(i, v){
 						$("#checkbox").append(
 								"<input type='checkbox' name='"+v.id+"' lay-skin='primary' title='"+v.permissionName+"'>");
 						if (i%2==1) {
 							$("#checkbox").append("</br>");
						}
 					});
    				 form.render();
				}
    		 }
    	  });
       });


        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            }
            , pass: [/(.+){6,12}$/, '密码必须6到12位']
            , content: function (value) {
                layedit.sync(editIndex);
            }
        });

        //监听提交
        form.on('submit(sub)', function (data) {
        	$("#btn-submit").addClass('layui-btn-disabled');
        	layer.confirm('确认添加该角色？',function(index){
        		var message = JSON.stringify(data.field);
         	   $.ajax({
         		  url:basePath+"role/add",
         		  method:"POST",
         		  type:"text/json",
         		  contentType : "application/json",
         		  data:message,
         		  success:function(){
         			 layer.close(index);
         			 layer.msg('添加成功!', {
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

        // you code ...


    });