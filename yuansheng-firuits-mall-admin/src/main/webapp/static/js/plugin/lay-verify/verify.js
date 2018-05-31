;
layui.use(['form'],function(){
	var form = layui.form
	   ,$ = layui.jquery;
	form.verify({
		
		name:function(value){
			
			if(value.length<2){
				   return "最少输入2个字";
			   }
			if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
		          return '用户名不能有特殊字符';
		        }
			 if(/(^\_)|(\__)|(\_+$)/.test(value)){
		          return '用户名首尾不能出现下划线\'_\'';
		        }
			 if(/^\d+\d+\d$/.test(value)){
		          return '用户名不能全为数字';
		        }
			 
		}
	   ,description:function(value){
		   if(value.length<=5){
			   return "最少输入5个字";
		   }
		   
	   }
	   
	
	})
	
})