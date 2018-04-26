var member_change_mobile_ops ={
   init:function(){
	   this.initMobile();
	   this.eventBind();
   },
   initMobile:function(){
	 $.ajax({
		 url:basePath+"member/info",
		 method:"GET",
		 type:"text/json",
		 success:function(res){
			 if(res.code == 0){
				 var data = $.parseJSON(res.data);
				 $("#input_telephoneno").val(data.mobile);
			 }
		 }
	 });  
   },
   eventBind:function(){
	  
	   
	   $("#btn-save").click(function(){
		   var mobile = $("#input_telephoneno").val();
		   if(mobile == null || common_ops.trim(mobile) == ""){
			   common_ops.msg("用户手机号码为空");
			   return;
		   }
		   var reg_phone=/^1[3|4|5|7|8]\d{9}$/;
		   if(!(reg_phone.test(mobile))){
			   common_ops.msg("用户手机号码格式错误");
			   return;
		   }
		   $.ajax({
				 url:basePath+"member/info/changeMobile",
				 method:"PUT",
				 data:{mobile:mobile},
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
	member_change_mobile_ops.init();
})
