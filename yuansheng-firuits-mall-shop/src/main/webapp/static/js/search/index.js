;
var search_cookie_value;
var search_index_ops ={
	init:function(){
		this.initSearchHistory();
		this.eventBind();
	},
	eventBind:function(){
		var that = this;
		$(".searchBtn").click(function(){
			var querySearch =  common_ops.trim($(".searchCondition").val());
			if(querySearch==""||querySearch.length==0){
				  common_ops.msg("请输入查询信息");
				  return ; 
			}
			
			that.addSearchToCookie(querySearch);
		    window.location.href = basePath+"goods?query="+querySearch;
		});
		//清空历史记录
		$("#a_empty_history").click(function(){
			$.cookie('search-history', null);
			$("#ul_search").empty();
			$(this).hide();
		});
	},
	initSearchHistory:function(){
		search_cookie_value = $.cookie('search-history');
		console.log(search_cookie_value);
        if(search_cookie_value == undefined || search_cookie_value == "null"){
        	 $("#a_empty_history").hide();
        	 console.log("没有记录");
        	 return;
        }
		var querys = search_cookie_value.split(",");
		if(querys.length >0){
	     $.each(querys,function(i,v){
	    	 $("#ul_search").append("<li><a href='"+basePath+"goods?query="+v+"'>"+v+"</a></li>");   
		 });
	     $("#a_empty_history").show();
		}else{
		 $("#a_empty_history").hide();
		}
	},
	addSearchToCookie:function(search){
		//把东西放在cookie
		var search_array;
		if(search_cookie_value==undefined || search_cookie_value=="null"){
			search_array = new Array();
			search_array.push(search);
		}else{
			search_array = search_cookie_value.split(",");
			search_array.push(search);
		}
		$.cookie('search-history', search_array.join(','),{expires: 7});
		
	}
	
};
$(function(){
	search_index_ops.init();
});

