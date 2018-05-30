layui.use(['form','laydate','upload'],function(){
	var form = layui.form;
	var laydate = layui.laydate;
	var upload = layui.upload;
	//初始化一级分类、品牌下拉框
	$.ajax({
		url: basePath + "goods/add/getBrandsAndCategories",
		method: "GET",
		type: "text/json",
		success: function(res) {
			var data = $.parseJSON(res.data);
			if (res.code == 0) {
				$.each(data.categories,function(i,v){
					$("#categories").append("<option value='"+v.id+"'>"+v.name+"</option>");
				});
				$.each(data.brandsNames,function(i,v){
					$("#brandName").append("<option value='"+v.id+"'>"+v.name+"</option>");
				});
				form.render("select");
			}
		}
	});
	//上传文件
	upload.render({
		elem:"#chooseFile",
		url:basePath+"goods/upload",
		auto:false,
		bindAction: "#uploadFile",
		before: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
			$("#chooseFile").attr("disabled",true).removeClass("layui-btn-normal").addClass("layui-btn-disabled");
			$("#uploadFile").attr("disabled",true).addClass("layui-btn-disabled");
		},
		done: function(res){
			console.log(res);
			var data = $.parseJSON(res.data);
			if (res.code == 0) {
				layer.alert("上传成功");
				$(".layui-form img").attr("src",basePath + data.imagePath);
				$(".layui-form input[name='imagePath']").val(data.imagePath);
			}else {
				$("#chooseFile").attr("disabled",false).addClass("layui-btn-normal").removeClass("layui-btn-disabled");
				$("#uploadFile").attr("disabled",false).removeClass("layui-btn-disabled");
				layer.alert(res.msg);
			}
		},
		error: function(index, upload){
			$("#chooseFile").attr("disabled",false).addClass("layui-btn-normal").removeClass("layui-btn-disabled");
			$("#uploadFile").attr("disabled",false).removeClass("layui-btn-disabled");
			layer.alert("操作失败");
		}
	});
	//表单校验
	form.verify({
		name : function(value) {
			if (value.length < 2) {
				return "商品名不能小于两位";
			}
		},
		sort : function(value) {
			if (value.length > 1) {
				return "请输入0-9以内的数";
			}
		},
		number : function(value) {
			if (!new RegExp("^[0-9]+([.]{1}[0-9]+){0,1}$").test(value)) {
				return "输入的只能是小数";
			}
		},
		description : function(value) {
			if (value.length < 5 || value.length > 120 ) {
				return "字数需保持在5-120之间";
			}
		}
	});
	//添加
	form.on("submit(sub)",function(data){
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		console.log(data.field);
		if(data.field.imagePath == null || data.field.imagePath == ""){
			layer.alert("图片未上传");
			return;
		}
		console.log(data.field);
		$.ajax({
			url : basePath + "goods/add/save",
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
	//通过一级分分类监听遍历出二级分类
	form.on("select(categories)",function(data){
		var id = data.value;
		if (id == null || id =="") {
			$("#secondCategories").empty();
			$("#secondCategories").append("<option value=''>请选择子分类</option>");
			form.render("select");
			return;
		}
		$.ajax({
			url: basePath + "goods/getCategories/" + id,
			method: "GET",
			type: "text/json",
			success: function(res) {
				var data = $.parseJSON(res.data);
				if (res.code == 0) {
					$("#secondCategories").empty();
					$("#secondCategories").append("<option value=''>请选择子分类</option>");
					$.each(data.categories,function(i,v){
						$("#secondCategories").append("<option value='"+v.id+"'>"+v.name+"</option>");
					});
					form.render("select");
				}
			}
		});
	});
	//时间加载
	laydate.render({
	    elem: '#launcTime',
	    min : '2017-01-01 23:59:59',
		max : '2099-06-16 23:59:59',
		format : 'yyyy-MM-dd HH:mm:ss',
		type : 'datetime',
		trigger : 'click',
		zIndex : 99999999
	  });
});