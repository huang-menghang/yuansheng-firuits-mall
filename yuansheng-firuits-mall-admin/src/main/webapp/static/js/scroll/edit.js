;
var lists={};
layui.use(['table','upload','form','laydate', 'layer', 'vip_table'], function () {

    // 操作对象
    var form = layui.form
            , table = layui.table
            , layer = layui.layer
            , laydate = layui.laydate
            , vipTable = layui.vip_table
            ,upload = layui.upload
            , $ = layui.jquery;
    
    var id = common_ops.g_getQueryString("id");
    // 把id存人lists中
    lists.id = id ;
	
	$.ajax({
		url:basePath+"scroll/list/"+id,
		method:"post",
		type:"text/json",
		success:function(res){
			if(res.code==0){
				console.log(res.data);
				var data = $.parseJSON(res.data);	
		
				console.log("data数据 = "+JSON.stringify(data));
				$("#scrollImage").attr("src",basePath+data.imageUrl);						
				$("input[name='name']").val(data.name);
				$("input[name='imageHref']").val(data.imageHref);
				$("input[name='imageUrl']").val(data.imageUrl);
				$("input[name='sort']").val(data.sort);
				$("input[name='status']").val(data.status);
				$("textarea[name='description']").val(data.description);
				$("input[name='createTime']").val(new Date(data.createTime.time).format("yyyy-MM-dd hh:mm:ss"));
				lists=data;
			}
		},
		error:function(){
	    
			common_ops.msg(" 编辑失败！",null);
	    }
	});

    var start = {
			elem : "#add_scroll_info input[name='createTime']",
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
    laydate.render(start);
    
    form.on('submit(scroll_info_submit)',function(data){  
    	var index=parent.layer.getFrameIndex(window.name);
    	    console.log(index);
    	var id = common_ops.g_getQueryString("id");
    	var res=data.field;
    	res.id=id;
    	   	
    	if(res.name==lists.name){
    		res.name=null;
    	}

    	if(res.imageHref==lists.imageHref){
    		res.imageHref=null;
    	}

    	if(res.imageUrl==lists.imageUrl){
    		res.imageUrl.name=null;
    	}

    	if(res.sort==lists.sort){
    		res.sort=null;
    	}

    	if(res.status==lists.status){
    		res.status=null;
    	}
    	
    	if(res.description==lists.description){
    		res.description=null;
    	}

    	if(res.createTime.time==lists.createTime.time){
    		res.createTime=null;
    	}
    	
    	$.ajax({
			url:basePath+"scroll/edit",
			method:"post",
			type:"text/json",
			data:{
				_method:"put",
				id:res.id,
				name:res.name,
				imageHref:res.imageHref,
				imageUrl:res.imageUrl,
				sort:res.sort,
				status:res.status,
				description:res.description,
				createTime:res.createTime
			},
			success:function(res){
				console.log("res.msg = "+res.msg);
				console.log("res内容是 ： "+JSON.stringify(res));
				if(res.code==0){	
					var callback=function(){
						parent.layer.close(index);
						};
											
					common_ops.msg("轮播图编辑成功 ",callback);										 
				}
			},
			error:function(){
				common_ops.msg("轮播图编辑失败 ",null);
			}
		});
    })
     form.on('submit(scroll_info_cancel)',function(data){     	 
    	 
    	 var index=parent.layer.getFrameIndex(window.name);
    	 parent.layer.close(index);
     })   
})

