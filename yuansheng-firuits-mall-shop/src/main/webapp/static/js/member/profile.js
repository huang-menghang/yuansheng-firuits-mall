var member_profile_ops = {
		init:function(){
			this.initMemberInfo();
			this.eventBind();
		},
		initMemberInfo:function(){
			$.ajax({
				url:basePath+"member/info",
				method:"GET",
				type:"text/json",
				success:function(res){
					if(res.code == 0){
						var data = $.parseJSON(res.data);
						console.log(res);
						var name = data.name;
						if(name != null&& name != ''){
							console.log($("#member-name").children("span"));
							$($("#member-name").children("span")[1]).html(name);
						};
						var mobile = data.mobile;
						if(mobile != null&& mobile != ''){
							$($("#member-mobile").children("span")[1]).html(mobile);
						};				
					}
				}	
			})
		},
		eventBind:function(){
			$(".backIcon").click(function(){
				window.location.href = basePath+"member/center";
			});
		}
}
$(function(){
	member_profile_ops.init();
})