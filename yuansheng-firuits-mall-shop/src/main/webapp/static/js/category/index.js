;
var category_index_ops = {
	init : function() {
		this.getCategory(this.getParentId());
		//this.eventBind();
	},
	getCategory : function(parentId) {
		var that = this;
		$.ajax({
			url : basePath + 'category',
			method : 'GET',
			type : 'text/json',
			success : function(res) {
				if (res.code == 0) {
					$(".class_tree ul").empty();
					$.each($.parseJSON(res.data), function(i, v) {
						$(".class_tree ul").append(
								"<li id='class_tree_li_" + v.id + "' value='"
										+ v.id + "'>" + "<a>" + "<img src='"
										+ basePath + v.imagePath
										+ "'/> <strong>" + v.name + "</strong>"
										+ "</a>" + "</li>");
					});
					$(".class_tree li").siblings(".class_tree li").removeClass(
					"current_style");
			        $("#class_tree_li_"+parentId).addClass("current_style");
			        $.ajax({
			        	url:basePath+"/category/"+parentId,
			        	method:"GET",
			        	type:"text/json",
			        	success:function(res){
			        		if(res.code == 0){
			        			$(".category_cont").empty();
			        			$(".category_cont").append("<li><a href='"+basePath+"goods'>全部</a></li>")
			        			$.each($.parseJSON(res.data),function(i,v){
				        			$(".category_cont").append("<li><a href='"+basePath+"goods'>"+v.name+"</a></li>");				        				
		        			    });
			        		}
			        	}
			        });
			        $(".class_tree li a").click(function(){
			     	   var parentId = $(this).parent().val();
			     	   that.getCategory(parentId);
			        });
				}
			}
		});
	
	},
	getParentId:function(){
		var splitArray=	(window.location.href).split("/");
		if(splitArray!=null){
			return splitArray[splitArray.length-1];
		}
	},
};
$(function() {
	category_index_ops.init();
});
