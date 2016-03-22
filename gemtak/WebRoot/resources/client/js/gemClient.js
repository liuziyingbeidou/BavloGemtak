/**
 * GemTak 前端
 */

$(function(){
	/**查询域**/
	//宝石种类
	$(".p_default").click(function(){
		$(this).css({"border":"2px solid #e17878"}).parents("div").siblings().find(".p_default").css("border","0px");
		$(".a_item_type").remove();
		$(".selects-type").append("<a href='#' class='a_item a_item_type'>种类："+$(this).attr("vn")+"</a>");
	});
	//宝石形状
	$(".nav_default").click(function(){
		$(this).css({"border":"2px solid #e17878"}).parents("div").siblings().find(".nav_default").css("border","0px");
		$(".a_item_shape").remove();
		$(".selects-shape").append("<a href='#' class='a_item a_item_shape'>形状："+$(this).attr("vn")+"</a>");
		//$(this).css({"background":"url('/gemtak/resources/client/images/mot/Round_a.png') top center no-repeat"}).parents("div").siblings().find(".nav_default").css("background","");
	});
	//宝石重量
	$(".btn-weight").click(function(){
		var fromv = $(".from-weight").val();
		var tov = $(".to-weight").val();
		if(fromv == "" || fromv == null || fromv == undefined){
			fromv = 0.0;
		}
		if(tov == "" || tov == null || tov == undefined){
			tov = 0.0;
		}
		$(".a_item_weight").remove();
		$(".selects-weight").append("<a href='#' class='a_item a_item_weight'>重量："+fromv+"克-"+tov+"克</a>");
	});
	//宝石价格
	$(".btn-price").click(function(){
		
		var fromv = $(".from-price").val();
		var tov = $(".to-price").val();
		if(fromv == "" || fromv == null || fromv == undefined){
			fromv = 0.0;
		}
		if(tov == "" || tov == null || tov == undefined){
			tov = 0.0;
		}
		$(".a_item_price").remove();
		$(".selects-price").append("<a href='#' class='a_item a_item_price'>价格："+fromv+"元-"+tov+"元</a>");
	});
	
	//查询条件
	//宝石类型
	$(".selects-type").click(function(){
		$(this).empty();
		$(".p_default").css("border","0px");
		//以下调用相应的事件
	});
	//宝石形状
	$(".selects-shape").click(function(){
		$(this).empty();
		$(".nav_default").css("border","0px");
		//以下调用相应的事件
	});
	//宝石重量
	$(".selects-weight").click(function(){
		$(this).empty();
		$(".from-weight").val("");
		$(".to-weight").val("");
		//以下调用相应的事件
	});
	//宝石价格
	$(".selects-price").click(function(){
		$(this).empty();
		$(".from-price").val("");
		$(".to-price").val("");
		//以下调用相应的事件
	});
});

//ajax
function remoteApi(){
	
}