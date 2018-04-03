;
var user_register_ops = {
	init:function(){
		this.initComponent();
		this.eventBind();
	},
	initComponent:function(){
		$("#select-address").empty().append("<option value=''>请选择</option>");
		$.getJSON("../static/js/city/city.min.js",function(data){
			$.each(data.citylist,function(i,prov){
				 if(prov.p !='国外'){
				     $.each(data.citylist[i].c,function(i,city){
				    	   console.log(city.n);
				       // $('#select_address').append("<option value='"+city.n+"' prov='"+prov.p+"'>"+city.n+"</option>");
				     });
				 }
			});
		});		
	},
	validateForm:function(){
		
	},
	eventBind:function(){
		
	}
}
$(function(){
	user_register_ops.init();
})