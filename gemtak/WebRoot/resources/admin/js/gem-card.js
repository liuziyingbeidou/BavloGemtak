/**
 * 后台管理卡片编辑
 */

$(function(){
	
	//根据是否非标准形状 决定显示那个域
 	setShowShape();
 	
 	//是否标准形状 切换事件
 	$(".select-st").change(function(){
 		setShowShape();
 	});
});

//根据是否非标准形状 决定显示那个域
function setShowShape(){
	var stVE = $(".select-st").val();
 	if(stVE == "sst"){//
 		$(".select-shape").show();
 		$(".input-shape").hide();
 	}else{
 		$(".select-shape").hide();
 		$(".input-shape").show();
 	}
}