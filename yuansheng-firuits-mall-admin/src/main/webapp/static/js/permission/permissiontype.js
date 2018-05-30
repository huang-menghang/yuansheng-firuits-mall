layui.use('element', function(){
  var element = layui.element;
  
   element.on('collapse(test)', function(data){
		var id =data.title[0].id;
	    if(data.show==true){
	    	$.ajax({
	    		url:basePath+"permission/category/"+id,
	    		method:"post",
	    		type:"text/json",
	    		success:function(res){
	    			var msg = $.parseJSON(res.data);
	    			console.log(res.data);
	    			$.each(msg,function(i,v){
	    				data.content.append("<div class='layui-collapse' >"+
		    		    		"<div class='layui-colla-item'>"+
		    		            "<h2 class='layui-colla-title'id ='"+v.id+"'>"+v.permissionName+"</h2>"+
		    		            "<div class='layui-colla-content'></div>"+
		    		            "</div>"+
		    		         "</div>"); 
	    				console.log(v.permissionName);
	    			});
	    			element.init();
	    		}
	    	});
	    }else if (data.show==false) {
	    	data.content.children().remove();
		}	
	    element.init();
	  }); 
  
   $(function() {
	   var id = -1;
	   $.ajax({
			url:basePath+"permission/category/"+id,
			method:"post",
			 type:"text/json",
			 success:function(res){
				 if(res.code==0){
					 var data = $.parseJSON(res.data)
					   if(data != null && data.length > 0 ){
						 $.each(data,function(i,v){
						 $("#collapse").append(
								 "<div class='layui-colla-item'>"+
			    		            "<h2 class='layui-colla-title'id ='"+v.id+"'>"+v.permissionName+"</h2>"+
			    		            "<div class='layui-colla-content'></div>"+
			    		            "</div>"
								 );
					   });
						 element.init();
					 }
				 }
			 }
		});
}); 
  //…
});