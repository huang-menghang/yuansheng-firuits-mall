layui.use(['layer','table'],function(){
	var layer = layui.layer
	,table =layui.table;
	
	var tableIns = table.render({
        elem: '#dateTable'                  //指定原始表格元素选择器（推荐id选择器）
        , cols: [[                  //标题栏
            {checkbox: true, sort: true, fixed: true, space: true}
            , {field: 'id', title: 'ID', width: 70}
            , {field: 'name', title: '角色名称', width: 120}
            , {field: 'permission',templet:'#permission',title: '角色权限', width: 270}
            , {field: 'description', title: '角色描述', width: 350}
            , {fixed: 'right', title: '操作', width: 200, align: 'center', toolbar: '#barOption'} //这里的toolbar值是模板元素的选择器
        ]]
        , id: 'dataCheck'
        , url:basePath+'role/list'
        , method: 'get'
        , page: true
        ,where:JSON
        , limits: [10, 20, 30, 40, 50]
        , limit: 10 //默认采用30
        , loading: false
        , done: function (res, curr, count) {
            //如果是异步请求数据方式，res即为你接口返回的信息。
            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
            //console.log(res);

            //得到当前页码
            //console.log(curr);

            //得到数据总量
            //console.log(count);
        }
    });	 
	
	$('#btn-add').on('click',function(){
		layer.open({
			type:2,
			title:"添加角色",
			area:['400px','500px'],
		    content:basePath+"page/roleAdd",
		    end:function(){
		    	tableIns.reload();
		    }
		});
	});
	
	$('#btn-refresh').on('click',function(){
		tableIns.reload();
	});
	
	
	table.on('tool(table-data)',function(obj){
		var data = obj.data;
		if(obj.event==='edit'){
			layer.open({
				type:2,
				title:"修改角色信息",
				area:['600px','500px'],
			    content:basePath+"page/roleEdit?id="+data.id,
			    end:function(){
			    	tableIns.reload();
			    }
			});
		}else if(obj.event==='del'){
			layer.confirm('确认要删除吗？',function(index){
				$.ajax({
					url:basePath+"role/"+data.id,
					method:"POST",
					data:{_method:'delete'},
					success:function(res){
						if(res.code==0){
							layer.msg("删除成功");
						}else{
							layer.msg("删除失败");
						}
					}
				});
				tableIns.reload();
			});	
		}else if(obj.event==='change'){
			layer.open({
				type:2,
				title:"修改角色权限",
				area:['400px','500px'],
			    content:basePath+"page/roleChange?id="+data.id,
			    end:function(){
			    	tableIns.reload();
			    }
			});
		}
	});
	
	
});