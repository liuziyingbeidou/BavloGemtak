/**
 * GemTak 前端
 */

$(function() {
	selectClientList(1);
	/** 查询域* */
	// 宝石种类
	$(".p_default").click(
			function() {
				$(this).css({
					"border" : "2px solid #e17878"
				}).parents("div").siblings().find(".p_default").css("border",
						"0px");
				$(".a_item_type").remove();
				$(".selects-type").append(
						"<a href='#' class='a_item a_item_type'>种类："
								+ $(this).attr("vn") + "</a>");
				$(".selects-type").attr("ms-key", $(this).attr("vid"));
				// 以下查询处理
				var switchover = $(".sel-show").val();
				selectClientList(switchover);
			});
	// 宝石形状
	$(".nav_default").click(
			function() {
				$(this).css({
					"border" : "2px solid #e17878"
				}).parents("div").siblings().find(".nav_default").css("border",
						"0px");
				$(".a_item_shape").remove();
				$(".selects-shape").append(
						"<a href='#' class='a_item a_item_shape'>形状："
								+ $(this).attr("vn") + "</a>");
				$(".selects-shape").attr("ms-key", $(this).attr("vid"));
				// $(this).css({"background":"url('/gemtak/resources/client/images/mot/Round_a.png')
				// top center
				// no-repeat"}).parents("div").siblings().find(".nav_default").css("background","");
				var switchover = $(".sel-show").val();
				selectClientList(switchover);
			});
	// 宝石重量
	$(".btn-weight").click(
			function() {
				var fromv = $(".from-weight").val();
				var tov = $(".to-weight").val();
				if (fromv == "" || fromv == null || fromv == undefined) {
					fromv = 0.0;
				}
				if (tov == "" || tov == null || tov == undefined) {
					tov = 0.0;
				}
				$(".a_item_weight").remove();
				$(".selects-weight").append(
						"<a href='#' class='a_item a_item_weight'>重量：" + fromv
								+ "克-" + tov + "克</a>");
				var switchover = $(".sel-show").val();
				selectClientList(switchover);
			});
	// 宝石价格
	$(".btn-price").click(
			function() {

				var fromv = $(".from-price").val();
				var tov = $(".to-price").val();
				if (fromv == "" || fromv == null || fromv == undefined) {
					fromv = 0.0;
				}
				if (tov == "" || tov == null || tov == undefined) {
					tov = 0.0;
				}
				$(".a_item_price").remove();
				$(".selects-price").append(
						"<a href='#' class='a_item a_item_price'>价格：" + fromv
								+ "元-" + tov + "元</a>");
				var switchover = $(".sel-show").val();
				selectClientList(switchover);
			});

	// 单粒
	$(".pairs-sl").click(function() {
		var switchover = $(".sel-show").val();
		selectClientList(switchover);
	});
	// 配对
	$(".pairs-pl").click(function() {
		var switchover = $(".sel-show").val();
		selectClientList(switchover);
	});
	// 多粒
	$(".pairs-ml").click(function() {
		var switchover = $(".sel-show").val();
		selectClientList(switchover);
	});
	// 弧面
	$(".pairs-h").click(function() {
		var switchover = $(".sel-show").val();
		selectClientList(switchover);
	});
	// 刻面
	$(".pairs-k").click(function() {
		var switchover = $(".sel-show").val();
		selectClientList(switchover);
	});
	/**
	 * 查询条件
	 */
	// 宝石类型
	$(".selects-type").click(function() {
		$(this).empty();
		$(this).attr("ms-key", "a");
		$(".p_default").css("border", "0px");
		// 以下调用相应的事件
		var switchover = $(".sel-show").val();
		selectClientList(switchover);
	});
	// 宝石形状
	$(".selects-shape").click(function() {
		$(this).empty();
		$(this).attr("ms-key", "a");
		$(".nav_default").css("border", "0px");
		// 以下调用相应的事件
		var switchover = $(".sel-show").val();
		selectClientList(switchover);
	});
	// 宝石重量
	$(".selects-weight").click(function() {
		$(this).empty();
		$(".from-weight").val("");
		$(".to-weight").val("");
		// 以下调用相应的事件
		var switchover = $(".sel-show").val();
		selectClientList(switchover);
	});
	// 宝石价格
	$(".selects-price").click(function() {
		$(this).empty();
		$(".from-price").val("");
		$(".to-price").val("");
		// 以下调用相应的事件
		var switchover = $(".sel-show").val();
		selectClientList(switchover);
	});

});

/**
 * 跳转详情页
 */
function goDetail(id) {
	location.href = "viewGemDetaile.do?id=" + id;
}

function selGemNUM() {
	var url = "selGemNO.do?";
	var gemType = $(".selects-type").attr("ms-key");
	var gemShape = $(".selects-shape").attr("ms-key");
	var fromv = $(".from-weight").val();
	var tov = $(".to-weight").val();
	var fromPri = $(".from-price").val();
	var toPri = $(".to-price").val();
	var inwhere = "'";// 单粒、多粒、配对
	var inwheres = "'";// 弧度、切面
	if ($(".pairs-sl").prop("checked")) {
		var pairssl = $(".pairs-sl").val();
		inwhere += pairssl + "','";
	}
	if ($(".pairs-pl").prop("checked")) {
		var pairspl = $(".pairs-pl").val();
		inwhere += pairspl + "','";
	}
	if ($(".pairs-ml").prop("checked")) {
		var pairsml = $(".pairs-ml").val();
		inwhere += pairsml + "','";
	}
	inwhere = inwhere.substring(0, inwhere.length - 2);
	if ($(".pairs-h").prop("checked")) {
		var pairsh = $(".pairs-h").val();
		inwheres += pairsh + "','";
	}
	if ($(".pairs-k").prop("checked")) {
		var pairsk = $(".pairs-k").val();
		inwheres += pairsk + "','";
	}
	inwheres = inwheres.substring(0, inwheres.length - 2);
	$.post(url, {
		typegem : gemType,
		shapegem : gemShape,
		fromWeight : fromv,
		toWeight : tov,
		fromPrice : fromPri,
		toPrice : toPri,
		inwhere : inwhere,
		inwheres : inwheres
	}, function(data) {
		dat = $.parseJSON(data);
		var gemNo = dat.gemNo;
		if (gemNo != null) {
			var uname = $(".juname").val();
			if (uname == "WxLogin") {
				$(".selPhGemNO").empty();
				$(".selPhGemNO").append(" " + gemNo + "");
			} else {
				$(".selGemNO").empty();
				$(".selGemNO").append(" " + gemNo + "");
			}
		}

	});
}

function selectClientList(switchover) {
	$(".yemianyanchi").show();
	var url = "getGemClientListBy.do?";
	var gemType = $(".selects-type").attr("ms-key");
	var gemShape = $(".selects-shape").attr("ms-key");
	var fromv = $(".from-weight").val();
	var tov = $(".to-weight").val();
	var fromPri = $(".from-price").val();
	var toPri = $(".to-price").val();
	var seldate = $(".select-createdate").find("option:selected").val();
	var inwhere = "'";// 单粒、多粒、配对
	var inwheres = "'";// 弧度、切面
	// 切换宫格显示、横行显示 1为宫格宫格展示 2为横排展示
	if (switchover == undefined) {
		switchover = 1;
	}
	if ($(".pairs-sl").prop("checked")) {
		var pairssl = $(".pairs-sl").val();
		inwhere += pairssl + "','";
	}
	if ($(".pairs-pl").prop("checked")) {
		var pairspl = $(".pairs-pl").val();
		inwhere += pairspl + "','";
	}
	if ($(".pairs-ml").prop("checked")) {
		var pairsml = $(".pairs-ml").val();
		inwhere += pairsml + "','";
	}
	inwhere = inwhere.substring(0, inwhere.length - 2);
	if ($(".pairs-h").prop("checked")) {
		var pairsh = $(".pairs-h").val();
		inwheres += pairsh + "','";
	}
	if ($(".pairs-k").prop("checked")) {
		var pairsk = $(".pairs-k").val();
		inwheres += pairsk + "','";
	}
	inwheres = inwheres.substring(0, inwheres.length - 2);
	$
			.post(
					url,
					{
						typegem : gemType,
						shapegem : gemShape,
						fromWeight : fromv,
						toWeight : tov,
						fromPrice : fromPri,
						toPrice : toPri,
						inwhere : inwhere,
						inwheres : inwheres,
						selDate : seldate
					},
					function(data) {
						$(".appendClientList").empty();
						appendToHead(switchover);
						if (data != null) {
							var len = data.length;
							var jiage = null;
							for ( var i = 0; i < len; i++) {
								var uname = $(".juname").val();
								if (uname == "WxLogin") {
									jiage = data[i].trade_price;
								} else {
									jiage = data[i].retail_price;
								}
								if (switchover == 1) {
									var NM = "3";
									if (data[i].vdef3 == "T") {
										NM = "5";
									}
									$(".appendClientList .cCard")
											.append(
													// <b>"+data[i].weight+"
													// "+data[i].clarity_en+"
													"<li class='col-md-3 col-xs-6'>"
															+ "<span><a href='javascript:void(0)' onclick='goDetail("
															+ data[i].id
															+ ")'><image class='360tupian'  src='http://stylepics.bavlo.com/Gemtak/gempic/"+data[i].gid+"s/001.jpg' /></a></span>"
															+ "<h6><b>"
															+ data[i].type_cn
															+ "<font class='hidden-xs hidden-sm'>（"
															+ data[i].type_en
															+ "）</font></b><i>¥"
															+ jiage
															+ "</i></h6>"
															+ "<p><b>"
															+ data[i].weight
															+ " "
															+ data[i].clarity_en
															+ " </b><i  onclick='addFavorite("
															+ data[i].id
															+ ")'><image class='changimg-"
															+ data[i].id
															+ "' src='/gemtak/resources/client/images/tu"
															+ NM
															+ ".png' /></i></p>"
															+ "</li>");
								} else if (switchover == 2) {
									$(".appendClientList .cList")
											.append(
													"<tr>"
															+ "<td><image src='http://stylepics.bavlo.com/Gemtak/gempic/"+data[i].gid+"s/001.jpg'' width='120px'/></td>"
															+ "<td><b>"
															+ data[i].type_cn
															+ "</b> <br />"
															+ data[i].type_en
															+ "</td>"
															+ "<td><b class='fon1'>"
															+ data[i].clarity_cn
															+ "</b><br /> "
															+ data[i].clarity_en
															+ "</td>"
															+ "<td><b class='fon1'>"
															+ data[i].cut_cn
															+ "</b><br />"
															+ data[i].cut_en
															+ "</td>"
															+ "<td>"
															+ data[i].weight
															+ "</td>"
															+ "<td>"
															+ data[i].lab_en
															+ "</td>"
															+ "<td><font class='fc_0a'>¥"
															+ jiage
															+ "</font></td>"
															+ "<td><a href='javascript:void(0)' onclick='goDetail("
															+ data[i].id
															+ ")'><image  src='/gemtak/resources/client/images/tu4.png' /></a></td>"
															+ "</tr>");
								}
							}
							appendToFoot(switchover);
							getCarNum(); // 查询购物车
							$(".yemianyanchi").hide();
							selGemNUM();
						}
					});
}

function appendToHead(switchover) {
	if (switchover == 2) {// 横行展示时，添加第一行
		$(".appendClientList")
				.append(
						"<div class='tit_table col-md-12' id='cont1'><table class='cList'>"
								+ "<tr height='40'>"
								+ "<th bgcolor='eeeeee' width='10%' style='text-align:center'>图片</th>"
								+ "<th bgcolor='eeeeee'>种型</th>"
								+ "<th bgcolor='eeeeee'>净度</th>"
								+ "<th bgcolor='eeeeee'>切工</th>"
								+ "<th bgcolor='eeeeee'>重量</th>"
								+ "<th bgcolor='eeeeee'>证书</th>"
								+ "<th bgcolor='eeeeee'>价格</th>"
								+ "<th bgcolor='eeeeee' width='10%'>360°展示</th></tr>");
	} else if (switchover == 1) {
		$(".appendClientList").append(
				"<div class='job_xq col-md-12'  id='cont1'><ul class='cCard'>");
	}
}

function appendToFoot(switchover) {
	if (switchover == 2) {
		$(".appendClientList").append("</table>" + "</div>");
	} else if (switchover == 1) {
		$(".appendClientList")
				.append(
						"</ul>"
								+ "<div class='jzgd hidden-md hidden-lg' ><a href=''>更多</a></div>"
								+ "</div>");
	}
}

/*
 * //宝石详情 function selectClientDetaile(id){ var url = "viewGemDetaile.do?";
 * $.post(url,{id:id},function(data){
 * 
 * }); }
 */

// 添加到收藏夹
function addFavorite(id) {
	var url = "favorite.do";
	$.post(url, {
		gemid : id
	}, function(data) {
		data = $.parseJSON(data);
		var flag = data.msg;
		if (flag == "Y") {
			/* alert("您已成功收藏该宝贝！"); */
			$(".changimg-" + id).prop("src",
					'/gemtak/resources/client/images/tu5.png');
		}
	});

}

// ajax
function remoteApi() {

}