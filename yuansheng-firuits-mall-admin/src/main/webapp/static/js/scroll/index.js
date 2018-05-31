;		
 layui.use(['table', 'form','laydate', 'layer', 'vip_table'], function () {

			        // 操作对象
				 console.log("0000  ..");
				 console.log(basePath+" .....");
			        var form = layui.form
			                , table = layui.table
			                , layer = layui.layer
			                , laydate = layui.laydate
			                , vipTable = layui.vip_table
			                , $ = layui.jquery;

			        // 表格渲染
			        var tableIns = table.render({
			            elem: '#dateTable'                  //指定原始表格元素选择器（推荐id选择器）
			            , cols: [[                  //标题栏
			                {checkbox: true, sort: true, fixed: true, space: true}
			                , {field: 'id', title: 'ID', width: 50}
			                , {field: 'name', title: '轮播图名称', width: 100}
			                , {field: 'imageHref', title: '轮播图跳转路径', width: 120}
			                , {field: 'imageUrl', title: '图片路径', width: 180}
			                , {field: 'sort', title: '图片索引', width: 100}
			                , {field: 'description', title: '轮播图详情', width: 150}
			                , {field: 'createTime', templet:'#createTime', title: '创建时间', width: 180}
			                , {field: 'status', title: '状态',templet:'#status', width: 70}
			                , {fixed: 'right', title: '操作', width: 160, align: 'center',templet: '#barOption' /*toolbar: '#barOption'*/} //这里的toolbar值是模板元素的选择器
			            ]]
			            , id: 'dataCheck'
			            , url: basePath+'scroll/query'
			            , method: 'get'
			            , page: true
			            , limits: [10, 20, 30, 40, 50]
			            , limit: 10 //默认采用30
			            , loading: false
			            , done: function (res, curr, count) {
			                //如果是异步请求数据方式，res即为你接口返回的信息。
			                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
			                console.log(res);

			                //得到当前页码
			                console.log(curr);

			                //得到数据总量
			                console.log(count);
			            }
			        });

			        // 获取选中行
			        table.on('checkbox(dataCheck)', function (obj) {
			            layer.msg('123');
			            console.log(obj.checked); //当前是否选中状态
			            console.log(obj.data); //选中行的相关数据
			            console.log(obj.type); //如果触发的是全选，则为：all，如果触发的是单选，则为：one
			        });

			        // 刷新
			        $('#btn-refresh').on('click', function () {
			            tableIns.reload();
			        });
			        // you code ...

			 $("#btn_query").on("click",function(){
				
				 console.log($("input[name='id']").val()+"   00   222");
									 
			            var id = $("input[name='id']").val(),
			             name = $("input[name='name']").val(),
			             description = $("input[name='description']").val();
						 startTime = $("input[name='startTime']").val(),
						 endTime = $("input[name='endTime']").val();		 
					
					  tableIns.reload({
						  where: { //设定异步数据接口的额外参数，任意设
							  id: id,
							  name: name,
							  description:description,
							  startTime : startTime,
							  endTime : endTime							  
						   }
						   ,page: {
						     curr: 1 
						   }
						 });
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
					// 激活和下架操作
					table.on('tool(table-data)',function(obj){  
						   var data = obj.data;
						   console.log("激活下架操作 ： "+data.id);
						   if(obj.event === 'detail'){
					           common_ops.x_admin_show("轮播图详情", basePath+"scroll/info?id="+data.id, '750', '600');
					       } else if(obj.event === 'del'){
					    	   var callback = {
					    			   ok:function(){
					    				   $.ajax({
					    					 // 名称/id
					    					 url:basePath+"scroll/"+data.id,
					    					 method:'post',
					    					 data:{_method:'delete'},
					    					 success:function(res){
					    						 var msg = null;
					    						 if(res.code == 0){
					    							 msg = "下架成功";
					    							
					    						 }else{
					    							 msg = "下架失败";
					    						 }
					    						 common_ops.alert(msg, function(){
													 tableIns.reload();
												 });
					    					 },
					    					 error:function(){
					    						 common_ops.alert("下架失败", function(){
													 tableIns.reload();
												 });
					    					 } 
					    				   })
					    				   
					    			   },
					    			   cancle:null
					    	   }
					    	   common_ops.confirm("确认下架吗?", callback);
					    	 
					       } 
						   
					       else if(obj.event === 'rec'){
					    	   var callback = {
					    			   ok:function(){
					    				   $.ajax({
					    					 // 名称/id
					    					 url:basePath+"scroll/"+data.id,
					    					 method:'post',
					    					 data:{_method:'delete'},
					    					 success:function(res){
					    						 var msg = null;
					    						 if(res.code == 0){
					    							msg = "激活成功";
					    						 }else{
					    						    msg = "激活失败";
					    						 }
					    						 common_ops.alert(msg, function(){
													 tableIns.reload();
												 });
					    					 },
					    					 error:function(){
					    						 common_ops.alert("激活失败", function(){
													 tableIns.reload();
												 });
					    					 }
											 
					    				   });
					    			   },
					    			   cancle:null
					    	   }
					    	   common_ops.confirm("确认激活?", callback);
					       }else if(obj.event === 'edit'){
					    	   
					    	   common_ops.x_admin_show("轮播图编辑", basePath+"scroll/edit?id="+data.id, '750', '600');
					    	   
					       }
						});
					 $('#btn-delete-all').on('click',function(){
						  var checkData= table.checkStatus('dataCheck').data;
						
						  var ids = [];
						  $.each(checkData,function(i,v){
							  ids.push(v.id);
						  })
						  
						  console.log("删除  ids 操作 ： "+ids.length);
						  if(ids.length == 0){
							  common_ops.alert("请选择要删除的条目");
							  return ;
						  }
						  $.ajax({
							  url:basePath+'scroll/delete/batch',
							  method:'post',
							  data:{_method:'delete',ids:ids},
							  success:function(res){
								  var msg = null;
								  if(res.code == 0){
									  msg = "批量删除成功";
								  }
								  else{
									  msg = "批量删除失败....";
								  }
								  common_ops.alert(msg,function(){
									  tableIns.reload();
								  });
							  },
							  error:function(){
								  common_ops.alert("批量删除失败",function(){
									  tableIns.reload();
								  });
							  }
							  
						  })
						  
							   					  
					   });
					 console.log("添加操作  之前 ： ");
					 $("#btn-add").on("click",function(){
						
							 console.log("添加操作 , 进来了 ");
							 common_ops.x_admin_show("轮播图添加",basePath+"scroll/add", '750', '600');
		
					 });
					 
 } )
	
		
