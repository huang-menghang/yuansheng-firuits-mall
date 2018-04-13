;
var member_login_ops = {
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
				var inputPass = $("#input-password").val();
				var salt = g_passsword_salt;
				var str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4);
				var password = md5(str);
				$(this).attr("disabled",true).addClass("disabled");
				$that = $(this);
				if(that.validateForm().form()){
				$.ajax({
					url:basePath+"member/doLogin",
					method:"POST",
					type:"json",
					data:{
						mobile:mobile,
						password:password
					},
					success:function(res){
					    var	callback = null;
						if(res.code == 0){
						 callback = function(){
							 var rurl = common_ops.g_getQueryString("rurl");
							 if(rurl == null){
								 rurl = basePath+"index";
							 }
							 window.location.href = rurl;
						 };	
						}else{
							$that.attr("disabled",false).removeClass("disabled");
						}
						common_ops.msg(res.msg,callback);
					}			
				})
				}else{
					$that.attr("disabled",false).removeClass("disabled");
				}
			});
		}
}
$(function(){
	member_login_ops.init();
})