;
layui.use(['upload','form','table','laydate','layer'], function(){
	  var $ = layui.jquery
	  ,form = layui.form
	  ,laydate=layui.laydate
	  ,table = layui.table
	  ,layer=layui.layer
	  ,upload = layui.upload;
	  var filePath;
	  var index=parent.layer.getFrameIndex(window.name);  
  
	  form.on('select(level)', function(data){
		  console.log("qaz 0000 ");
		  console.log("data.value= "+data.value);
		  console.log("select 选中的值 ： "+JSON.stringify(data));
		  if(data.value !=1){
			  $("#category_add").hide();
			  $("#image_add").hide();
			  $("input[name='imageUrl']").val("#").attr("readonly","readonly");
			  $("input[name='parentId']").val("").removeAttr("readonly");
		  }else{
			  $("#category_add").show();
			  $("input[name='imageUrl']").val("").removeAttr("readonly");
			  $("input[name='parentId']").val("-1").attr("readonly","readonly");
		  }		  
	  })	
		  var uploadInst = upload.render({
			    elem: '#category_add'
			    ,url: basePath+'categoryList/upload'
			    ,accept:"images"
			    ,size: 1024
			    ,before: function(obj){
			      //预读本地文件示例，不支持ie8
			      obj.preview(function(index, file, result){
			    	
			          $('#image_add').attr('src', result);			        
			          $("#image_add").show();			                                                                                                                                                                                                                                                                                                                                                    
			      });
			    }
			    ,done: function(res){
			      //如果上传失败			    	
			    	  var res =res; 
			    	   filePath = res.msg;
			    	$("input[name='imageUrl']").val(res.msg);
			    	common_ops.btnDisable($("#category_add"));
			    	common_ops.msg("图片上传成功 ！ ",null);
			    	
			    	console.log("图片上传 ： "+JSON.stringify(res));
			    	if(res.code<0){
			    		return layer.msg("图片上传失败！");
			    	}
			    }
			    ,error: function(){
			        // 演示失败状态，并实现重传
			        var demoText = $('#demoText');
			        demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
			        demoText.find('.demo-reload').on('click', function(){
			              
			      	  uploadInst.upload();      
			        });
			      }
	  })

  form.on('submit(add_upload)',function(data){ 
	var $that = $(this);
	
	common_ops.btnDisable($that);
  	
  	console.log("图片不上传，路径为 : "+$("input[name='imageUrl']").val());
  	if($("input[name='imageUrl']").val()==null || $("input[name='imageUrl']").val()==""){
  		console.log("图片路径为空了 ！！！！");
  		common_ops.msg("图片没有上传或上传失败，请重新上传 ！");
  		return;
  	}
  	var resource = data.field;
  	console.log(JSON.stringify(resource));
  	resource.level=$(".select-level option:selected").val();
  	console.log("获取option的值 ： "+resource.level);
  	var name = resource.name;
  	console.log("sort = "+resource.sort);
  	console.log("name: "+name);
  	
  	var imageUrl = resource.imageUrl;
  	
  	var sort = resource.sort;
  	var status = resource.status;
  	
  	resource.description=$(".layui-textarea").val();
  	console.log("description ="+resource.description);
  	console.log("createTime ="+resource.createTime);
  	
  	$.ajax({
  		url:basePath+"categoryList/save",
  		method:"get",
  		type:"text/json",
  		data:{
  			name:name,  			
  			imageUrl:imageUrl,
  			level:resource.level,
  			parentId:resource.parentId,
  			sort:sort,
  			status:status ,  			
  			description:resource.description  			
  		},
  		success:function(res){
  			var callback=null;
  			console.log("上传成功res的数据是 ： "+JSON.stringify(res));
  			if(res.code==0){
  				callback=function(){
  					common_ops.btnDisable($that);
  					parent.layer.close(index);
  				}
  				common_ops.msg(res.msg,callback);
  			}
  		},
  		error:function(){
  			common_ops.btnDisable($that);
  		}
  	})
  })
  $(".btn_cancel").on("click",function(){
	  $.ajax({
		  url:basePath+"scroll/deleteImage",
	      method:"post",
	      type:"text/json",
	      data:{
	    	  _method:"delete",
	    	  filePath:filePath
	      },
	      success:function(res){
	    	  if(res.code==0){
	    		  console.log("取消后打印的是 ： "+res.msg);
	    		  console.log("index : "+index);
	    		  parent.layer.close(index);
	    	  }
	    	  
	      },
	      error:function(){
	    	  common_ops.msg("请重新取消");
	    	  parent.layer.close(index);
	      }
	  })
	  
  })
   
  var start = {
		elem : "input[name='createTime']",
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
})