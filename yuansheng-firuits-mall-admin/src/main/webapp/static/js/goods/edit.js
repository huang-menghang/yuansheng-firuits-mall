var update = null;//用于存放后台传到前端的初始化参数(方便后期判断是否有做过改动)
var id = common_ops.g_getQueryString("id");//获取url中的参数
var countEditItem = 0;//用于记录未改动的条目数
layui.use(['form','laydate','upload'],function(){
	var form = layui.form;
	var laydate = layui.laydate;
	var upload = layui.upload;
	//初始化修改页面表单元素
	$.ajax({
		url: basePath + "goods/edit/getGoods/" + id,
		method: "GET",
		type: "text/json",
		success: function(res) {
			var data = $.parseJSON(res.data);
			update = data;
			console.log(JSON.stringify(update));
			if (res.code == 0) {
				$.each(data.categories,function(i,v){
					$("#categories").append("<option value='"+v.id+"'>"+v.name+"</option>");
				});
				$("#categories").find("option[value='"+data.categoryParentId+"']").attr("selected",true);
				$.each(data.brandsNames,function(i,v){
					$("#brandName").append("<option value='"+v.id+"'>"+v.name+"</option>");
				});
				$("#brandName").find("option[value='"+data.brandId+"']").attr("selected",true);
				$.each(data.secondCategories,function(i,v){
					$("#secondCategories").append("<option value='"+v.id+"'>"+v.name+"</option>");
				});
				$("#secondCategories").find("option[value='"+data.categoryId+"']").attr("selected",true);
				$("#packet").find("option[value='"+data.packet+"']").attr("selected",true);
				form.render("select");
				$(".layui-form img").attr("src",basePath + data.imagePath);
				$(".layui-form input[name='name']").val(data.name);
				$(".layui-form input[name='weight']").val(data.weight);
				$(".layui-form input[name='storage']").val(data.storage);
				$(".layui-form input[name='sales']").val(data.sales);
				$(".layui-form input[name='sort']").val(data.sort);
				$(".layui-form input[name='standrds']").val(data.standrds);
				$(".layui-form input[name='price']").val(data.price);
				$(".layui-form input[name='discoutPrice']").val(data.discoutPrice);
				$(".layui-form input[name='launcTime']").val(new Date(data.launcTime.time).format("yyyy-MM-dd hh:mm:ss"));
				$(".layui-form textarea[name='description']").val(data.description);
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
	//表单验证
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
	//修改点击事件
	form.on("submit(edit)",function(data){
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		var dataField = data.field;
		console.log(dataField);
		console.log(update.name + "==" + dataField.name);
		console.log(update.name == dataField.name);
		if (update.name == dataField.name) {
			dataField.name = null;
			countEditItem++;
		}
		if(new Date(update.launcTime.time).format("yyyy-MM-dd hh:mm:ss") == dataField.launcTime){
			dataField.launcTime = null;
			countEditItem++;
		}
		if (update.categoryId == dataField.categoryName) {
			dataField.categoryName = null;
			countEditItem++;
		}
		if (update.price == dataField.price) {
			dataField.price = null;
			countEditItem++;
		}
		if (update.discoutPrice == dataField.discoutPrice) {
			dataField.discoutPrice = null;
			countEditItem++;
		}
		if (update.brandId == dataField.brandName) {
			dataField.brandName = null;
			countEditItem++;
		}
		if (update.packet == dataField.packet) {
			dataField.packet = null;
			countEditItem++;
		}
		if (update.weight == dataField.weight) {
			dataField.weight = null;
			countEditItem++;
		}
		if (update.storage == dataField.storage) {
			dataField.storage = null;
			countEditItem++;
		}
		if (update.standrds == dataField.standrds) {
			dataField.standrds = null;
			countEditItem++;
		}
		if (update.sort == dataField.sort) {
			dataField.sort = null;
			countEditItem++;
		}
		if (update.description == dataField.description) {
			dataField.description = null;
			countEditItem++;
		}
		if(dataField.imagePath == null || dataField.imagePath ==""){
			countEditItem++;
		}
		console.log(countEditItem);
		if (countEditItem == 13) {
			countEditItem = 0;
			layer.alert("没有改动,无需修改");
			return;
		}
		dataField._method = "PUT";
		dataField.id = id;
		console.log(JSON.stringify(dataField));
		$.ajax({
			url : basePath + "goods/edit/update",
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
	//通过一级分类点击事件异步加载二级分类
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
	//时间模块加载
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