var update = null;
var id = common_ops.g_getQueryString("id");
var countEditItem = 0;
layui.use(['form'],function(){
	var form = layui.form;
	//表单校验
	form.verify({
		name : function(value) {
			if (value.length < 2) {
				return "品牌不能小于两位";
			}
		},
		description : function(value) {
			if (value.length < 5 || value.length > 120 ) {
				return "字数需保持在5-120之间";
			}
		}
	});
	//添加按钮
	form.on("submit(sub)",function(data){
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		$.ajax({
			url : basePath + "brand/add/save",
			method: "POST",
			type: "text/json",
			data:	data.field,
			success: function(res) {
				if (res.code == 0) {
					layer.alert(res.msg);
				}
                parent.layer.close(index);
			}
		});
	});

});