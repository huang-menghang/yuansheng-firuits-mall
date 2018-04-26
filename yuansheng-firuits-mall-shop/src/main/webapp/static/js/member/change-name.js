var member_change_name_ops ={
   init:function(){
	   this.initName();
	   this.eventBind();
   },
   initName:function(){
	 $.ajax({
		 url:basePath+"member/info",
		 method:"GET",
		 type:"text/json",
		 success:function(res){
			 if(res.code == 0){
				 var data = $.parseJSON(res.data);
				 $("#input_petname").val(data.name);
			 }
		 }
	 });  
   },
   eventBind:function(){
	   $("#btn-save").click(function(){
		   var name = $("#input_petname").val();
		   if(name == null || common_ops.trim(name) == ""){
			   common_ops.msg("用户姓名为空");
			   return;
		   }
		   $.ajax({
				 url:basePath+"member/info/changeName",
				 method:"PUT",
				 data:{name:name},
				 type:"text/json",
				 success:function(res){
					 if(res.code == 0){
						 common_ops.msg(res.msg);
					 }
				 }
			 }); 
		   
		   
	   });
   }
		
}
$(function(){
	member_change_name_ops.init();
})