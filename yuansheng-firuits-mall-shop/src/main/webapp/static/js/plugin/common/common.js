var common_ops = {
	alert : function(msg, cb) {
		layer.alert(msg, {
			yes : function(index) {
				if (typeof cb == "function") {
					cb();
				}
				layer.close(index);
			}
		});
	},
	msg:function(msg,cb){
		if(typeof cb == "function"){
			layer.msg(msg,cb);
		}
		else{
			layer.msg(msg);
		}
	},
	confirm : function(msg, callback) {
		callback = (callback != undefined) ? callback : {
			'ok' : null,
			'cancel' : null
		};
		layer.confirm(msg, {
			btn : [ '确定', '取消' ]
		// 按钮
		}, function(index) {
			// 确定事件
			if (typeof callback.ok == "function") {
				callback.ok();
			}
			layer.close(index);
		}, function(index) {
			// 取消事件
			if (typeof callback.cancel == "function") {
				callback.cancel();
			}
			layer.close(index);
		});
	},
	tip : function(msg, target) {
		layer.tips(msg, target, {
			tips : [ 3, '#e5004f' ]
		});
		$('html, body').animate({
			scrollTop : target.offset().top - 10
		}, 100);
	},
	btnDisable : function(btn){
		if(btn.hasClass('disabled')){
			btn.attr("disabled",false).removeClass("disabled");
		}else{
			btn.attr("disabled",true).addClass("disabled");
		}
	}
	

}