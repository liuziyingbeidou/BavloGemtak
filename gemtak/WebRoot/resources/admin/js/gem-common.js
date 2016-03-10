/**
 * 公共JS
 */

$(function(){
		$(".h-lang").click(function(){
			var url = "/gemtak/common/changeLang.do";
			$.get(url,function(rs){
				location.reload();
			});
		});
	});