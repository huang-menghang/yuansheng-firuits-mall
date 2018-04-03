;
var user_login_ops = {
		init:function(){
			this.eventBind();
		},
		validateForm:function(){
		 return  $(".formarea").validate(); 
		},
		eventBind:function(){
			var that = this;
			$(".formarea .btn-login").click(function(){
				var mobile = $("#input-mobile").val();
				var password = $("#input-password").val();
				$(this).attr("disabled",true).addClass("disabled");
				$that = $(this);
				if(that.validateForm().form()){
				$.ajax({
					url:"user/doLogin",
					method:"POST",
					type:"json",
					data:{
						mobile:mobile,
						password:password
					},
					success:function(res){
						common_ops.msg(res.msg);
						$that.attr("disabled",false).removeClass("disabled");
					}			
				})
				}else{
					$that.attr("disabled",false).removeClass("disabled");
				}
			});
		}
}
$(function(){
	user_login_ops.init();
})