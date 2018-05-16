// layui方法
layui.use([ 'table', 'form', 'layer', 'laydate','vip_table' ], function() {
    // 操作对象
	  var form = layui.form
      , table = layui.table
      , layer = layui.layer
      , laydate = layui.laydate//日期插件
      , vipTable = layui.vip_table
      , $ = layui.jquery;
	  memberPhoneNo= null ,memberName = null,address = null,startTime=null,endTime= null,status = null ;
	  
	  
   // 表格渲染
   var tableIns = table.render({
       elem: '#dateTable'                  //指定原始表格元素选择器（推荐id选择器）  //容器高度
       , cols: [[                  //标题栏
           {checkbox: true, sort: true, fixed: true, space: true}
           , {field: 'id', title: 'ID', width: 80}
           , {field: 'name', title: '会员名', width: 100}
           , {field: 'mobile', title: '手机号码', width: 120}
           , {field: 'telephone', title: '电话号码', width: 120}
           , {field: 'detailAddress', title: '地址', width: 180}
           , {field: 'createTime', templet:'#createTime',title: '创建时间', width: 160}
           , {field: 'status', title: '状态',templet:'#status', width: 80}
           , {fixed: 'right', title: '操作', width: 150, align: 'center', templet: '#barOption'} //这里的toolbar值是模板元素的选择器
       ]]
       , id: 'dataCheck'
       , url: 'member/pagination'
       , method: 'get'
       , page: true
       , limit: 10 //默认采用30
       , limits :[10]
       , loading: false
       , done: function (res, curr, count) {
    	   console.log(res);

           //得到当前页码
           console.log(curr);

           //得到数据总量
           console.log(count);
       }
   });
   
   // 刷新
   $('#btn-refresh').on('click', function () {
	   tableIns.reload();
   });
   // 批量删除
   $('#btn-delete-batch').on('click',function(){
	  var checkData= table.checkStatus('dataCheck').data;
	  var ids = [];
	  $.each(checkData,function(i,v){
		  ids.push(v.id);
	  })
	  if(ids.length == 0){
		  common_ops.alert("请选择要删除的条目");
		  return ;
	  }
	  $.ajax({
		  url:basePath+'member/delete/batch',
		  method:'post',
		  data:{_method:'delete',ids:ids},
		  success:function(res){
			  var msg = null;
			  if(res.code == 0){
				  msg = "批量删除成功";
			  }
			  else{
				  msg = "批量删除失败";
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
   
   
 
   // 删除或则注销
   table.on('tool(table-data)',function(obj){  
	   var data = obj.data;
	   if(obj.event === 'detail'){
           common_ops.x_admin_show("用户详情", basePath+"member/info?id="+data.id, '600', '500');
       } else if(obj.event === 'del'){
    	   var callback = {
    			   ok:function(){
    				   $.ajax({
    					 // 名称/id
    					 url:basePath+"member/"+data.id,
    					 method:'post',
    					 data:{_method:'delete'},
    					 success:function(res){
    						 var msg = null;
    						 if(res.code == 0){
    							 msg = "注销成功";
    							
    						 }else{
    							 msg = "注销失败";
    						 }
    						 common_ops.alert(msg, function(){
								 tableIns.reload();
							 });
    					 },
    					 error:function(){
    						 common_ops.alert("注销失败", function(){
								 tableIns.reload();
							 });
    					 } 
    				   })
    				   
    			   },
    			   cancle:null
    	   }
    	   common_ops.confirm("确认删除吗?", callback);
    	 
       } 
	   
       else if(obj.event === 'rec'){
    	   var callback = {
    			   ok:function(){
    				   $.ajax({
    					 // 名称/id
    					 url:basePath+"member/"+data.id,
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
       }
	});
   
   
   
	$("#btn-reset").on('click',function(){
		$(".layui-form input").val('');
		$(".layui-form select option[value='']").attr("selected", true);
	});
	
   $('#btn-search').on('click',function(){
	  memberPhoneNo = $(".layui-form input[ name='memberPhoneNo']").val();
	  console.log(memberPhoneNo);
	  memberName = $(".layui-form input[ name='memberName']").val();
	  address = $(".layui-form input[ name='address']").val();
	  startTime = $(".layui-form input[ name='startTime']").val();
	  endTime = $(".layui-form input[ name='endTime']").val();
	  status = $(".layui-form select[ name='status']").val();
	  tableIns.reload({
		   where: { //设定异步数据接口的额外参数，任意设
			   memberPhoneNo: memberPhoneNo,
			   memberName: memberName,
			   address : address,
			   startTime : startTime,
			   endTime : endTime,
			   status : status
		   }
		   ,page: {
		     curr: 1 //重新从第 1 页开始
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
  
   
});
