 layui.use(['form', 'layedit', 'laydate', 'element'], function () {
        var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
                , laydate = layui.laydate
                , element = layui.element;

        var id;
        
        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

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
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            });
            return false;
        });

        // you code ...

        $(function () {
        	var url = window.location.href;
			id = url.split("id=")[1];
			$.ajax({
				url:basePath+"role/getRole/"+id,
				method:"get",
				type:"text/json",
				success:function(res){
					var data = $.parseJSON(res.data);
					$('#roleName').text(data.name);
					form.render();
				}
			});
		});
        
        form.on('submit(sub)', function (data) {
        	$("#btn-submit").addClass('layui-btn-disabled');
        	layer.confirm('确定修改？',function(index){
        		var message = JSON.stringify(data.field);
         	   $.ajax({
         		  url:basePath+"role/edit/"+id,
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
    });