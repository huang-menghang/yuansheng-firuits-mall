var member_address_ops = {
	init:function(){
		this.initAddress();
		this.validateForm();
		this.eventBind();
	},
	validateForm:function(){
		return $(".userForm").validate();
	},
	initAddress:function(){	
   	  $.ajax({
		url:basePath+"member/info",
		type:"text/json",
		method:"get",
		success:function(res){
			if(res.code == 0){
			 var data = $.parseJSON(res.data);
		 	 $("#input-name").val(data.name);
		 	 $("#textarea_detail").val(data.detailAddress);
			 $("#ul_adress").citySelect({  
				      prov: data.province,  
				      city: data.city,  
				      dist: data.town,  
				      nodata: "hidden"  
			 });
			}
		}
   	  });	
	},
	eventBind:function(){
		var that = this;
		$("#input_change_address").click(function(){
			var $that = $(this);
			common_ops.btnDisable($that);
			if(that.validateForm().form()){
		       $.ajax({
		    	   url:basePath+"member/set/changeAddress",
		    	   method:"PUT",
		    	   data:{province:$("#select_prov").val(),
		    		    city:$("#select_city").val(),
		    		    town:$("#select_dist").val(),
		    		    detailAddress:$("#textarea_detail").val()
		    	   },
		    	   success:function(res){
		    		    common_ops.msg(res.msg);
		    		    common_ops.btnDisable($that);
		    	   }
		       })
	
			}else{
				common_ops.btnDisable($that);
			}
		})
	}
}
$(function(){
   member_address_ops.init();
})