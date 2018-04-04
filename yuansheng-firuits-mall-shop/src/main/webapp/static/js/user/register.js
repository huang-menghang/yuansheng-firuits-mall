;
var user_register_ops = {
	init : function() {
		this.initComponent();
		this.validateForm();
		this.eventBind();
	},
	initComponent : function() {
		$("#select-address").empty().append("<option value=''>请选择</option>");
		$.getJSON("../static/js/city/city.min.js", function(data) {
			$.each(data.citylist, function(i, prov) {
				if (prov.p != '国外') {
					$('#select-address').append(
							"<optgroup label='" + prov.p + "' ></optgroup>")
					$.each(data.citylist[i].c,
							function(i, city) {
								$('#select-address').append(
										"<option value='" + city.n + "' prov='"
												+ prov.p + "'>" + city.n
												+ "</option>");
							});
				}
			});
		});
		
	},
	validateForm : function() {
		return $(".formarea").validate();
	},
	eventBind : function() {
		var that = this;
		$("#input-regesiter").click(function() {
			var $that = $(this);
		    common_ops.btnDisable($that);
			if (that.validateForm().form()) {
				var password = $("#input-password").val();
				var confirmPassword = $("#input-confirm-password").val();
				if(password != confirmPassword){
				 common_ops.msg("两次密码输入不一致",common_ops.btnDisable($that));
				 return ;
				}
				$.ajax({
					url:"../user/register",
					method:"POST",
					type:"json",
					data:{
						mobile:$("#input-telephonephoneNo").val(),
						password:$("#input-password").val(),
						confirmPassword:$("#input-confirm-password").val(),
						restaurant:$("#input-restaurant").val(),
						name:$("#input-customer-name").val(),
						telephone:$("#input-phoneNo").val(),
						detailAddress:$("#input-detailAdd").val(),
						province:$('#select-address option:selected').attr("prov"),
						city:$('#select-address').val()
					},
					success:function(res){
						console.log(res);
					},
					error:function(res){
				      common_ops.btnDisable($that);
					}
				});
			}else{
			      common_ops.btnDisable($that);
			}
		});
	}
}
$(function() {
	user_register_ops.init();
})