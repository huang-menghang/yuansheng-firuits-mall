var update = null;
var id = common_ops.g_getQueryString("id");
var countEditItem = 0;
layui.use(['form'],function(){
	var form = layui.form;
	$.ajax({
		url: basePath + "brand/edit/getBrand/" + id,
		method: "GET",
		type: "text/json",
		success: function(res) {
			var data = $.parseJSON(res.data);
			update = data;
			console.log(JSON.stringify(update));
			if (res.code == 0) {
				$(".layui-form input[name='name']").val(data.name);
				$(".layui-form textarea[name='description']").val(data.description);
			}
		}
	});
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
	form.on("submit(edit)",function(data){
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		var dataField = data.field;
		if (update.name == dataField.name) {
			dataField.name = null;
			countEditItem++;
		}
		if (update.description == dataField.description) {
			dataField.description = null;
			countEditItem++;
		}
		console.log(countEditItem);
		if (countEditItem == 2) {
			countEditItem = 0;
			layer.alert("没有改动,无需修改");
			return;
		}
		dataField._method = "PUT";
		dataField.id = id;
		console.log(JSON.stringify(dataField));
		$.ajax({
			url : basePath + "brand/edit/update",
			method: "POST",
			type: "text/json",
			data:	dataField,
			success: function(res) {
				if (res.code == 0) {
					layer.alert(res.msg);
				}
                parent.layer.close(index);
			}
		});
	});

});