/**
 * 宝石后台管理
 */
$(function(){
	
	loadGemList(1);
	$(".sear_ch_sub").click(function(){
		  loadGemList(1);
	  });
});
//ajax加载Gem数据
function loadGemList(p){
	var url = "/gemtak/gemAdmin/getGemListByWh.do";
	var gemType = $(".sel-gem-type").val();
	//中英文
	var ltGemDel = $(".btn-del").val();
	var ltGemRelease = $(".btn-relf").val();
	var ltGemClose = $(".btn-close").val();
	var	ltTypeGem = $(".nm-gem").val();
	var	ltTypeProduct = $(".nm-prod").val();
	var	ltStorage = $(".cv-insert").val();
	var	ltSign = $(".cv-sign").val();
	//查询条件
	var allgem = $(".all-gem").val();
	var shapegem = $(".shape-gem").val();
	var typegem = $(".type-gem").val();
	var inputgem = $(".input-gem").val();
	$.post(url,{dgpage:p,gemType:gemType,allgem:allgem,shapegem:shapegem,typegem:typegem,inputgem:inputgem},function(data){
		//console.log(data);
		//将数据显示到UI  发布成功后
		$(".list-gem").empty();
		if(data != null){
			for(var i=0;i<data.length;i++){
				var btnRefAndClose = ltGemRelease;
				
				if(data[i].is_release == "Y"){
					btnRefAndClose = ltGemClose;
				}
				$(".list-gem").append("<dl class='nr_con col-md-12'>"+
			     "<dt class='col-md-1 col-xs-3'>"+
					"<img src='/gemtak/resources/admin/images/cp8.jpg' style='width:100%'/>"+
					 "<p class='hidden-md hidden-lg'><a href='' class='col-md-6 col-xs-6'>"+ltGemDel+"</a><a href='' class='col-md-6 col-xs-6'>"+btnRefAndClose+"</a></p>"+
				 "</dt>"+
				 "<dd class='col-md-11 col-xs-9'>"+
					 "<p class='col-md-5 col-xs-12'><span class='col-md-6 col-xs-12'><font>"+data[i].type_cn+"</font><font>"+data[i].shape_cn+"</font><font>"+data[i].lab_cn+"</font></span><span class='col-md-6 col-xs-12'><font>"+data[i].weight+"</font><font>"+data[i].stock_qty+""+data[i].pairs+"</font><font class='fc_001'>¥"+data[i].retail_price+"</font></span></p>"+
					 "<p class='col-md-5 col-xs-12'><span class='col-xs-12 col-md-6'>"+ltTypeGem+"：<a href='./game.html'>"+ltStorage+"</a><a href=''>"+ltSign+"</a></span><span class='col-xs-12 col-md-6 pad_0'>"+ltTypeProduct+"：<a href=''>"+ltStorage+"</a><a href=''>"+ltSign+"</a></span></p>"+
					 "<p class='col-md-2 hidden-xs hidden-sm'>"+
					   "<a href='javascript:updeIs_del("+data[i].id+")' class='btn-del-"+data[i].id+"' ms-state='"+data[i].is_release+"'>"+ltGemDel+"</a>"+
					   "<a href='javascript:updeIs_release("+data[i].id+")' class='btn-rele-"+data[i].id+"' ms-state='"+data[i].is_release+"'>"+btnRefAndClose+"</a>"+
					 "</p>"+
				 "</dd>"+
			  "</dl>");
			}
		}
	});
}