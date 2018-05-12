var user_login_ops ={
	init:function(){
		this.eventBind();
	},
	validateForm:function(){
		 return  $(".layui-form").validate(); 
    },
	eventBind:function(){
		var that = this;
	
		$(".layui-form button[ type='submit']").click(function(){
			$(this).attr("disabled",true).addClass("layui-btn-disabled");
			$that = $(this);
			if(that.validateForm().form()){
				
				}else{
					$that.attr("disabled",false).removeClass("layui-btn-disabled");
				}
			
			
		});
		
	}	
}
$(function(){
	user_login_ops.init();
});