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
           , {field: 'id', title: 'ID', width: 90}
           , {field: 'user', title: '用户', width: 150}
           , {field: 'ip', title: '请求ip', width: 180}
           , {field: 'requstUrl', title: '请求地址', width: 250}
           , {field: 'osAndBrowser', title: '系统/浏览器', width: 150}
           , {field: 'requestMethod', title: '请求方式', width: 120}
           , {field: 'requestParams', title: '请求参数', width: 200,templet:'#params'}
           , {fixed: 'right', title: '操作', width: 100, align: 'center', templet: '#barOption'} //这里的toolbar值是模板元素的选择器
       ]]
       , id: 'dataCheck'
       , url: basePath+'actionlog/pagination'
       , method: 'get'
       , page: true
       , limit: 20 //默认采用30
       , limits :[20,40,60]
       , loading: false
       , done: function (res, curr, count) {
    	  
       }
   });
   
   // 刷新
   $('#btn-refresh').on('click', function () {
	   tableIns.reload();
   });
   
   table.on('tool(table-data)',function(obj){  
	   var data = obj.data;
	   if(obj.event === 'detail'){
		   layer.open({
				type:2,
				title:"日志信息",
				area:['500px','600px'],
			    content:basePath+"actionlog/showlog?id="+data.id,
			});
       } 
	}); 
   
   
	$("#btn-reset").on('click',function(){
		$(".layui-form input").val('');
		$(".layui-form select option[value='']").attr("selected", true);
	});
	
   $('#btn-search').on('click',function(){
	   user = $(".layui-form input[ name='user']").val();
	   ip = $(".layui-form input[ name='ip']").val();
	   requestUrl = $(".layui-form input[ name='requestUrl']").val();
	  
	  startTime = $(".layui-form input[ name='startTime']").val();
	  endTime = $(".layui-form input[ name='endTime']").val();
	  tableIns.reload({
		   where: { //设定异步数据接口的额外参数，任意设
			   user : user,
			   ip : ip,
			   requestUrl : requestUrl,
			   startTime : startTime,
			   endTime : endTime
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