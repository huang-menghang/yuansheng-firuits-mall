var isClose = false;
layui.use(['table','element','laydate'],function(){
	var table = layui.table
		  ,laydate = layui.laydate
		  ,element = layui.element;
	var initTable = table.render({
		elem:"#dateTable",
		url: basePath+"brand/pagination",
		method: "GET",
		page: true,
		limits: [10,20,30],
		limit: 10,
		id:"dataCheck",
		cols: [[
			{checkbox: true,sort: true,fixed: true,space: true},
			{field: 'id',title:'ID',width:80},
			{field: 'name',title:'品牌名',width:80},
			{field: 'description',title:'商品描述',width:170},
			{field: 'createTime',title:'创建时间',width:170,templet:'#createTime'},
			{field: 'updateTime',title:'修改时间',width:170,templet:'#updateTime'},
			{field: 'status',title:'状态',width:80,templet:'#status'},
			{fixed: 'right',title:'操作',width:120,align: 'center', templet: '#barOption'},
		]],
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
			url : basePath + "brand/deleteBatch",
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
	//刷新
	$("#btn-refresh").on("click", function () {
		initTable.reload();
	});
	//重置
	$("#btn-reset").on("click",function(){
		$(".layui-form input").val('');
		$(".layui-form select option[value='']").attr("selected", true);
	});
	$("#btn-search").on("click",function(){
		var name  = $(".layui-form input[name='name']").val();
		var description  = $(".layui-form input[name='description']").val();
		var createTimeStart  = $(".layui-form input[name='createTimeStart']").val();
		var createTimeEnd  = $(".layui-form input[name='createTimeEnd']").val();
		var updateTimeStart  = $(".layui-form input[name='updateTimeStart']").val();
		var updateTimeEnd  = $(".layui-form input[name='updateTimeEnd']").val();
		var status = $(".layui-form select[ name='status']").val();
		initTable.reload({
			where : {
				name : name,
				description : description,
				createTimeStart : createTimeStart,
				createTimeEnd : createTimeEnd,
				updateTimeStart : updateTimeStart,
				updateTimeEnd : updateTimeEnd,
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
	        area : ['700px','300px'], 
	        scrollbar: false,//禁止浏览器滚动
	        content: basePath + "brand/add",
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
	})
	//上架、下架、编辑
	table.on("tool(table-data)",function(obj){
		var data = obj.data;
		if (obj.event == "edit") {
			 layer.open({
			        type: 2,
			        title: '修改商品',
			        area : ['700px','300px'], 
			        scrollbar: false,//禁止浏览器滚动
			        content: basePath + "brand/edit?id=" + data.id,
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
							url : basePath + "brand/update/" + data.id,
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
							url : basePath + "brand/update/" + data.id,
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
	

	var createTimeStart = {
			elem : ".layui-form input[name='createTimeStart']",
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

		var createTimeEnd = {
			elem : ".layui-form input[name='createTimeEnd']",
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
		var updateTimeStart = {
				elem : ".layui-form input[name='updateTimeStart']",
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
		var updateTimeEnd = {
				elem : ".layui-form input[name='updateTimeEnd']",
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
		laydate.render(createTimeStart);
		laydate.render(createTimeEnd);
		laydate.render(updateTimeStart);
		laydate.render(updateTimeEnd);

})