var member_set_changePwd_ops ={
	init:function(){
		this.validateForm();
		this.eventBind();
	},
	validateForm:function(){
		return $(".userForm").validate();
	},
	eventBind:function(){
		var that = this;
		$("#input_change_password").click(function(){
			if (that.validateForm().form()) {
				var oldPassword = $("#input_old_password").val();
				var salt = g_passsword_salt;
				var str = ""+salt.charAt(0)+salt.charAt(2) + oldPassword +salt.charAt(5) + salt.charAt(4);
			    oldPassword = md5(str);		
				var newPassword = $("#input_new_password").val();
				var newConfirmPassword = $("#input_confirm_password").val();
				if(newPassword!=newConfirmPassword){
					common_ops.msg("两次输入密码不一致");
					return ;
				}
				$.ajax({
					url:basePath+"member/set/changePassword",
					method:"PUT",
					data:{oldPassword:oldPassword,
						  newPassword:newPassword,
						  newConfirmPassword:newConfirmPassword},
				    type:"text/json",
				    success:function(res){
				    	if(res.code == 0){
				    		common_ops.msg("修改成功");
				    	}else{
				    		common_ops.msg(res.msg);
				    	}
				    }
					
				})
				
			}
		});
	}
};
$(function(){
	member_set_changePwd_ops.init();
});