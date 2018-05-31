;

layui.use(['upload','form','laydate','layer'], function(){
	  var $ = layui.jquery
	  ,form = layui.form
	  ,laydate=layui.laydate
	  ,layer=layui.layer
	  ,upload = layui.upload;
	  var filePath;
	  var index=parent.layer.getFrameIndex(window.name);  
  var uploadInst = upload.render({
    elem: '#scroll_add'
    ,url: basePath+'scroll/upload'
    ,accept:"images"
    ,size: 1024
    ,before: function(obj){
      //预读本地文件示例，不支持ie8
      obj.preview(function(index, file, result){    	   	  
          $('#image_add').attr('src', result); //图片链接（base64）       
          $("#image_add").show();
                                                                                                                                                                                                                                                                                                                                             
      });
    }
    ,done: function(res){
      //如果上传失败
    	
    	  var res =res; 
    	   filePath = res.msg;
    	$("input[name='imageUrl']").val(res.msg);
    	common_ops.btnDisable($("#scroll_add"));
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
  });
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
  	var name = resource.name;
  	console.log("sort = "+resource.sort);
  	console.log("name: "+name);
  	var imageHref = resource.imageHref;
  	var imageUrl = resource.imageUrl;
  	var sort = resource.sort;
  	var status = resource.status;
  	var createTime = resource.createTime;
  	$.ajax({
  		url:basePath+"scroll/save",
  		method:"get",
  		type:"text/json",
  		data:{
  			name:name,
  			imageHref:imageHref,
  			imageUrl:imageUrl,
  			sort:sort,
  			status:status     			
  		},
  		success:function(res){
  			var callback=null;
  			console.log("上传成功res的数据是 ： "+res);
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