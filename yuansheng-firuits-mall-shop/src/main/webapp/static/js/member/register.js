;
var i;
var time = 180;
var isCount = false;
var member_register_ops = {
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
	getCode : function() {
		isCount = true;
		i = setInterval(function() {
			$(".checkCode").html(time + ",秒后重新发送");
			time--;
			if (time < 0) {
				i = window.clearInterval(i);
				time = 180;
				//将session中的code把它删除,120秒以后就失效
				$.ajax({
					url:'../member/invalidateMobileMsg',
					method:'POST',
					type:'text/json',
					success:function(res){
						console.log(res.msg);
					}
				})
				$(".checkCode").html("获取手机校验码");
				isCount = false;
			}
		}, 1000);
	},
	eventBind : function() {
		var that = this;
		$("#input-regesiter").click(
				function() {
					var $that = $(this);
					common_ops.btnDisable($that);
					if (that.validateForm().form()) {
						var password = $("#input-password").val();
						var confirmPassword = $("#input-confirm-password")
								.val();
						if (password != confirmPassword) {
							common_ops.msg("两次密码输入不一致", common_ops
									.btnDisable($that));
							return;
						}
						$.ajax({
							url : "../member/register",
							method : "POST",
							type : "json",
							data : {
								mobile : $("#input-telephonephoneNo").val(),
								password : $("#input-password").val(),
								confirmPassword : $("#input-confirm-password")
										.val(),
								restaurant : $("#input-restaurant").val(),
								name : $("#input-customer-name").val(),
								telephone : $("#input-phoneNo").val(),
								detailAddress : $("#input-detailAdd").val(),
								province : $('#select-address option:selected')
										.attr("prov"),
								city : $('#select-address').val(),
								messageCode:$("#check-code").val()
							},
							success : function(res) {
								var callback = null;
								if (res.code == 0) {
								   callback = function(){
									   window.location.href = "../member/login"
								   }
								} 
								common_ops.msg(res.msg,callback);							
								common_ops.btnDisable($that);
							},
							error : function(res) {
								common_ops.btnDisable($that);
							}
						});
					} else {
						common_ops.btnDisable($that);
					}
				});
		$(".checkCode").click(function() {
			if (isCount) {
				return;
			}
			var $that = $(this);
			if (that.validateForm().form()) {
				$.ajax({
					url : "../member/getMobileMsg",
					method : "post",
					data : {
						mobile : $("#input-telephonephoneNo").val()
					},
					type : "text/json",
					success : function(res) {
						common_ops.msg("请注意查收手机短信");
						that.getCode();
					},
					error : function() {
						common_ops.btnDisable($that);
					}
				})
			} 
			
			
		});
	}
}
$(function() {
	member_register_ops.init();
})