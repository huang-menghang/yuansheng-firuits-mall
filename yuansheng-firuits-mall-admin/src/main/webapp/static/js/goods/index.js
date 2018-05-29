var isClose = false;
layui.use(['table','element','laydate'],function(){
	var table = layui.table;
	var element = layui.element;
	var laydate = layui.laydate;
	var initTable = table.render({
		elem:"#dateTable",
		url: basePath+"goods/pagination",
		method: "GET",
		page: true,
		limits: [10,20,30],
		limit: 10,
		id:"dataCheck",
		cols: [[
			{checkbox: true,sort: true,fixed: true,space: true},
			{field: 'id',title:'ID',width:80},
			{field: 'name',title:'商品名',width:80},
			{field: 'categoryName',title:'分类',width:80},
			{field: 'brandName',title:'品牌',width:80},
			{field: 'sales',title:'销量',width:60},
			{field: 'price',title:'原价',width:60},
			{field: 'discoutPrice',title:'售价',width:60},
			{field: 'packet',title:'包装',width:60,templet:'#packet'},
			{field: 'launcTime',title:'上市时间',width:170,templet:'#launcTime'},
			{field: 'status',title:'状态',width:80,templet:'#status'},
			{fixed: 'right',title:'操作',width:160,align: 'center', templet: '#barOption'},
		]],
	})
	//搜索
	$("#btn-search").on("click",function(){
		var name  = $(".layui-form input[name='name']").val();
		var categoryName  = $(".layui-form input[name='categoryName']").val();
		var brandName  = $(".layui-form input[name='brandName']").val();
		var startSales  = $(".layui-form input[name='startSales']").val();
		var endSales  = $(".layui-form input[name='endSales']").val();
		var startPrice  = $(".layui-form input[name='startPrice']").val();
		var endPrice  = $(".layui-form input[name='endPrice']").val();
		var startTime  = $(".layui-form input[name='startTime']").val();
		var endTime  = $(".layui-form input[name='endTime']").val();
		var status = $(".layui-form select[ name='status']").val();
		if(startSales != null && endSales != null ){
			if (startSales > endSales) {
				layer.alert("最高销量不能小于最低销量");
				return;
			}
		}
		if(startPrice != null && endPrice != null ){
			if (startPrice > endPrice) {
				layer.alert("最高价不能小于最低价");
				return;
			}
		}
		initTable.reload({
			where : {
				name : name,
				categoryName : categoryName,
				brandName : brandName,
				startSales : startSales,
				endSales : endSales,
				startPrice : startPrice,
				endPrice : endPrice,
				startTime : startTime,
				endTime : endTime,
				status : status
			},page: {
			     curr: 1 //重新从第 1 页开始
			}
		});
	});
	//添加
	$("#btn-add").on("click",function(){
		layer.open({
	        type: 2,
	        title: '商品详情',
	        area : ['700px','550px'], 
	        scrollbar: false,//禁止浏览器滚动
	        content: basePath + "goods/add",
	        cancel : function(index, layero) {
	        	console.log("111111111111");
	        	isClose = true;
			},
	        end: function () {
	        	if (!isClose) {
	        		initTable.reload();
				}
	        	isClose = false;
            }
	  });
	})
	//刷新
	$("#btn-refresh").on("click", function () {
		initTable.reload();
	});
	//重置
	$("#btn-reset").on("click",function(){
		$(".layui-form input").val('');
		$(".layui-form select option[value='']").attr("selected", true);
	});
	//批量删除
	$("#btn-delete-batch").on("click",function(){
		var checkData = table.checkStatus("dataCheck").data;
		var ids = [];
		$.each(checkData,function(i,v){
			ids.push(v.id);
		});
		if (ids.length == 0) {
			common_ops.alert("请选择要删除的商品");
			return;
		}
		$.ajax({
			url : basePath + "goods/deleteBatch",
			method: "POST",
			data: {
				_method: "DELETE",
				ids : ids
			},
			success: function(res) {
				var msg = null;
				if(res.code == 0){
					msg = "批量删除成功"
				}else {
					msg = "批量删除失败"
				}
				common_ops.alert(msg,function(){
					initTable.reload();
				});
			},
			error: function() {
				common_ops.alert("批量删除失败",function(){
					initTable.reload();
				});
			}
		});
	})
	//查看、下架、编辑
	table.on("tool(table-data)",function(obj){
		var data = obj.data;
		if (obj.event == "info") {
			 layer.open({
			        type: 2,
			        title: '商品详情',
			        area : ['700px','500px'], 
			        scrollbar: false,//禁止浏览器滚动
			        content: basePath + "goods/info?id=" + data.id,
			  });
		}else if (obj.event == "edit") {
			 layer.open({
			        type: 2,
			        title: '修改商品',
			        area : ['700px','500px'], 
			        scrollbar: false,//禁止浏览器滚动
			        content: basePath + "goods/edit?id=" + data.id,
			        cancel : function(index, layero) {

			        	isClose = true;
					},
			        end: function () {
			        	if (!isClose) {
			        		initTable.reload();
						}
			        	isClose = false;
		            }
			  });
		}else if (obj.event == "pull") {
			var callback = {
					ok : function() {
						$.ajax({
							url : basePath + "goods/update/" + data.id,
							method: "POST",
							data: {
								_method :"PUT"
							},
							success: function(res) {
								var msg = null;
								if (res.code == 0) {
									msg = "成功下架";
								}else {
									msg = "操作失败";
								}
								common_ops.alert(msg,function(){
									initTable.reload();
								});
							},
							error: function() {
								common_ops.alert("操作失败",function(){
									initTable.reload();
								});
							}
						})
					},
					cancle:null
			}
			common_ops.confirm("确认要下架吗?",callback);
		}else if (obj.event == "put") {
			var callback = {
					ok : function() {
						$.ajax({
							url : basePath + "goods/update/" + data.id,
							method: "POST",
							data: {
								_method :"PUT"
							},
							success: function(res) {
								var msg = null;
								if (res.code == 0) {
									msg = "成功上架";
								}else {
									msg = "操作失败";
								}
								common_ops.alert(msg,function(){
									initTable.reload();
								});
							},
							error: function() {
								common_ops.alert("操作失败",function(){
									initTable.reload();
								});
							}
						})
					},
					cancle:null
			}
			common_ops.confirm("确认要上架吗?",callback);
		}
	});
	var start = {
			elem : ".layui-form input[name='startTime']",
			min : '2017-01-01 23:59:59',
			max : '2099-06-16 23:59:59',
			format : 'yyyy-MM-dd HH:mm:ss',
			type : 'datetime',
			trigger : 'click',
			zIndex : 99999999,
			ready : function(data) {
				start.min = data; // 开始日选好后，重置结束日的最小日期
			},
			change : function(value, date, endDate) {
				start.value = value;
			}
		};

		var end = {
			elem : ".layui-form input[name='endTime']",
			min : '2017-01-01 23:59:59',
			max : '2099-06-16 23:59:59',
			format : 'yyyy-MM-dd HH:mm:ss',
			type : 'datetime',
			trigger : 'click',
			zIndex : 99999999,
			ready : function(data) {
				end.max = data; // 结束日选好后，重置开始日的最大日期
			},
			change : function(value, date, endDate) {
				end.value = value;
			}
		};

		laydate.render(start);
		laydate.render(end);
  
});