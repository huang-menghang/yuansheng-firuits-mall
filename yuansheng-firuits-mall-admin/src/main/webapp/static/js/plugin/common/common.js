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
	x_admin_show : function(title,url,w,h){
		if (title == null || title == '') {
	        title=false;
	    };
	    if (url == null || url == '') {
	        url="404.html";
	    };
	    if (w == null || w == '') {
	        w=800;
	    };
	    if (h == null || h == '') {
	        h=($(window).height() - 50);
	    };
	    layer.open({
	        type: 2,
	        area: [w+'px', h +'px'],
	        fix: false, //不固定
	        maxmin: true,
	        shadeClose: true,
	        shade:0.4,
	        title: title,
	        content: url
	    });
	
	},
	x_admin_close : function(){
	    var index = parent.layer.getFrameIndex(window.name);
	    parent.layer.close(index);
	},
	g_getQueryString : function(name) {
		//console.log(name);
		if(name == "rurl"){
			var r = window.location.search.split("rurl=")[1];
			return r;
		}
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if(r != null) return unescape(r[2]);
		return null;
	},
	//去掉左括号
	ltrim :function(s)
	{
	 return s.replace(/^\s*/g,''); 
	},
	//去掉右括号
	rtrim:function(s)
	{
	 return s.replace(/\s*$/g,'');
	},
	//去掉左右括号
	trim:function(s)
	{
	   return this.rtrim(this.ltrim(s));
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


Math.add = function(v1, v2)
{
   ///<summary>精确计算加法。语法：Math.add(v1, v2)</summary>
   ///<param name="v1" type="number">操作数。</param>
  ///<param name="v2" type="number">操作数。</param>
  ///<returns type="number">计算结果。</returns>
  var r1, r2, m;
   try
       { 
           r1 = v1.toString().split(".")[1].length;
       }
   catch (e)
       {
         r1 = 0;
       }
   try
   {
     r2 = v2.toString().split(".")[1].length;
   }
   catch (e)
   {
     r2 = 0;
   }
   m = Math.pow(10, Math.max(r1, r2));

   return (v1 * m + v2 * m) / m;
 }


 Number.prototype.add = function(v)
 {
 ///<summary>精确计算加法。语法：number1.add(v)</summary>
 ///<param name="v" type="number">操作数。</param>
 ///<returns type="number">计算结果。</returns>
   return Math.add(v, this);
 }


 Math.sub = function(v1, v2)
 {
 ///<summary>精确计算减法。语法：Math.sub(v1, v2)</summary>
 ///<param name="v1" type="number">操作数。</param>
 ///<param name="v2" type="number">操作数。</param>
 ///<returns type="number">计算结果。</returns>
   return Math.add(v1, -v2);
 }


 Number.prototype.sub = function(v)
 {
 ///<summary>精确计算减法。语法：number1.sub(v)</summary>
 ///<param name="v" type="number">操作数。</param>
 ///<returns type="number">计算结果。</returns>
   return Math.sub(this, v);
 }


 Math.mul = function(v1, v2)
 {
 ///<summary>精确计算乘法。语法：Math.mul(v1, v2)</summary>
 ///<param name="v1" type="number">操作数。</param>
 ///<param name="v2" type="number">操作数。</param>
 ///<returns type="number">计算结果。</returns>
   var m = 0;
   var s1 = v1.toString();
   var s2 = v2.toString();
   try
   {
     m += s1.split(".")[1].length;
   }
   catch (e)
   {
   }
   try
   {
     m += s2.split(".")[1].length;
   }
   catch (e)
   {
   }

   return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m);
 }


 Number.prototype.mul = function(v)
 {
 ///<summary>精确计算乘法。语法：number1.mul(v)</summary>
 ///<param name="v" type="number">操作数。</param>
 ///<returns type="number">计算结果。</returns>
   return Math.mul(v, this);
 }


 Math.div = function(v1, v2)
 {
 ///<summary>精确计算除法。语法：Math.div(v1, v2)</summary>
 ///<param name="v1" type="number">操作数。</param>
 ///<param name="v2" type="number">操作数。</param>
 ///<returns type="number">计算结果。</returns>
   var t1 = 0;
   var t2 = 0;
   var r1, r2;
   try
   {
     t1 = v1.toString().split(".")[1].length;
   }
   catch (e)
   {
   }
   try
   {
     t2 = v2.toString().split(".")[1].length;
   }
   catch (e)
   {
   }

   with (Math)
   {
     r1 = Number(v1.toString().replace(".", ""));
     r2 = Number(v2.toString().replace(".", ""));
     return (r1 / r2) * pow(10, t2 - t1);
   }
 }


 Number.prototype.div = function(v)
 {
 ///<summary>精确计算除法。语法：number1.div(v)</summary>
 ///<param name="v" type="number">操作数。</param>
 ///<returns type="number">计算结果。</returns>
   return Math.div(this, v);
 }
//返回刷新
 function backAndRefresh(){
	    var referrer = document.referrer;
	    var curWwwPath=window.document.location.href;  
	    if((referrer.indexOf("login")!=-1)&&(curWwwPath.indexOf("registe")==-1)){
	    	window.location.href=basePath+"index";
	    }else{
	        window.location.href=referrer;  
	    }
 }
 