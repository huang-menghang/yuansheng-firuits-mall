//salt
var g_passsword_salt="1a2b3c4d";
var basePath = $("input[name='basePath']").val();
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
	},
	g_getQueryString : function(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if(r != null) return unescape(r[2]);
		return null;
	}
	
}

//设定时间格式化函数，使用new Date().format("yyyyMMddhhmmss");  
Date.prototype.format = function (format) {  
    var args = {  
        "M+": this.getMonth() + 1,  
        "d+": this.getDate(),  
        "h+": this.getHours(),  
        "m+": this.getMinutes(),  
        "s+": this.getSeconds(),  
    };  
    if (/(y+)/.test(format))  
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
    for (var i in args) {  
        var n = args[i];  
        if (new RegExp("(" + i + ")").test(format))  
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? n : ("00" + n).substr(("" + n).length));  
    }  
    return format;  
};  
