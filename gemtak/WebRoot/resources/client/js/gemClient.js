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
		$(".selects-type").attr("ms-key",$(this).attr("vid"));
		//以下查询处理
		selectClientList();
	});
	//宝石形状
	$(".nav_default").click(function(){
		$(this).css({"border":"2px solid #e17878"}).parents("div").siblings().find(".nav_default").css("border","0px");
		$(".a_item_shape").remove();
		$(".selects-shape").append("<a href='#' class='a_item a_item_shape'>形状："+$(this).attr("vn")+"</a>");
		$(".selects-shape").attr("ms-key",$(this).attr("vid"));
		//$(this).css({"background":"url('/gemtak/resources/client/images/mot/Round_a.png') top center no-repeat"}).parents("div").siblings().find(".nav_default").css("background","");
		selectClientList();
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
		selectClientList();
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
		selectClientList();
	});

	//单粒
	$(".pairs-sl").click(function(){
		
		selectClientList();
	});
	//配对
	$(".pairs-pl").click(function(){
		
		selectClientList();
	});
	//多粒
	$(".pairs-ml").click(function(){
		
		selectClientList();
	});
	//弧面
	$(".pairs-h").click(function(){
		
		selectClientList();
	});
	//刻面
	$(".pairs-k").click(function(){
		
		selectClientList();
	});
	/**
	 * 查询条件
	 */
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

  function selectClientList(){
	/*var url = "viewGemList.do?";
	var gemType = $(".selects-type").attr("ms-key"); 
	if(gemType != null && gemType != ""){
		url += "&typegem="+gemType;
	}
	var gemShape = $(".selects-shape").attr("ms-key"); 
	if(gemShape != null && gemShape != ""){
		url += "&shapegem="+gemShape;
	}
	var fromv = $(".from-weight").val();
	var tov = $(".to-weight").val();
	if(fromv != null && fromv != "" && tov != null && tov != ""){
		url += "&fromWeight="+fromv+"&toWeight="+tov;
	}
	var fromPri = $(".from-price").val();
	var toPri = $(".to-price").val();
	if(fromPri != null && fromPri != "" && toPri != null && toPri != ""){
		url += "&fromPrice="+fromPri+"&toPrice="+toPri;
	}
	window.location.href= url;*/
	     var url = "getGemClientListBy.do?";
		 var gemType = $(".selects-type").attr("ms-key"); 
		 var gemShape = $(".selects-shape").attr("ms-key"); 
		 var fromv = $(".from-weight").val();
	     var tov = $(".to-weight").val();
	     var fromPri = $(".from-price").val();
	 	 var toPri = $(".to-price").val();
	 	 var seldate = $(".select-createdate").find("option:selected").val();
	 	 var inwhere = "'";//单粒、多粒、配对
	 	 var inwheres = "'";//弧度、切面
	 	 if($(".pairs-sl").prop("checked")){
	 	  var pairssl = $(".pairs-sl").val(); 
	 	  inwhere += pairssl + "','";
	 	 }
	 	 if($(".pairs-pl").prop("checked")){
	 		var pairspl = $(".pairs-pl").val(); 
	 		inwhere += pairspl + "','";
		 }
	 	 if($(".pairs-ml").prop("checked")){
	 		var pairsml = $(".pairs-ml").val(); 
	 		inwhere += pairsml + "','";
		 }
	 	inwhere = inwhere.substring(0, inwhere.length-2);
	 	 if($(".pairs-h").prop("checked")){
	 		var pairsh = $(".pairs-h").val(); 
	 		inwheres += pairsh + "','";
		 }
	 	 if($(".pairs-k").prop("checked")){
	 		var pairsk = $(".pairs-k").val(); 
	 		inwheres += pairsk + "','";
		 }
	 	inwheres = inwheres.substring(0, inwheres.length-2);
		  $.post(url,{typegem:gemType,shapegem:gemShape,fromWeight:fromv,toWeight:tov,
			  fromPrice:fromPri,toPrice:toPri,inwhere:inwhere,inwheres:inwheres,
			  selDate:seldate},function(data){
			  $(".appendClientList").empty();
				if(data != null){
					var len = data.length;
					for(var i=0;i<len;i++){
						$(".appendClientList").append("<li class='col-md-3 col-xs-6'>"+
								  "<span><a href='./detail.html'><image src='/gemtak/resources/client/images/cp1.png' /></a></span>"+
								  "<h6><b>"+data[i].type_cn+"<font class='hidden-xs hidden-sm'>"+data[i].type_en+"</font></b><i>¥"+data[i].retail_price+"</i></h6>"+
								  "<p><b>"+data[i].weight+" "+data[i].clarity_en+" "+data[i].cut_en+"</b><i><image src='/gemtak/resources/client/images/tu3.png' /></i></p>"+
								"</li>");
					}
				}
		  });
  }



//ajax
function remoteApi(){


}