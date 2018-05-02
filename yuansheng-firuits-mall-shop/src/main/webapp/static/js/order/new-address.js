var new_address_ops = {
	init:function(){
		this.initAddress();
		this.eventBind();
	},
	validateForm:function(){
		return $(".userForm").validate();
	},
	initAddress:function(){
		 $("#ul_adress").citySelect({  
		      prov: '',  
		      city: '',  
		      dist: '',  
		      nodata: "hidden"  
	    });		 
	},
	eventBind:function(){
	   var that = this;
       $(".formLastBtn").click(function(){
    	   var $that = $(this);
		   common_ops.btnDisable($that);
		   if(that.validateForm().form()){
				$.ajax({
					url : basePath+"order/changeAddress",
					method : "PUT",
					type : "json",
					data : {
						memberProvince: $(".prov").val(),
						memberCity : $("#select_city").val(),
						memberDist: $("#select_dist").val(),
						orderDetailAddress: $("#input_detail_address").val(),					
						memberMobile : $("#input_mobile").val(),
						memberPhone : $("#input_phone").val(),
						id:common_ops.g_getQueryString("orderId"),
						defaultAddress:$("#input_default").prop("checked")
					},
					success : function(res) {
						var callback = null;
						if(res.code == 0){
						  callback = function(){
							  window.location.href = basePath+"order/confirm?orderId="+common_ops.g_getQueryString("orderId");
						  }
						}else{
						  callback = function(){
							common_ops.btnDisable($that);  
						  }
						}
						common_ops.msg(res.msg,callback);
						
					},
					error : function(res) {
						common_ops.btnDisable($that);
					}
				});
		   }else{
				common_ops.btnDisable($that);
			}
    	   
    	   
       })
	}
		
};
$(function(){
  new_address_ops.init();
})