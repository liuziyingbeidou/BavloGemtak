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

/**  
 * 获取指定的URL参数值  
 * URL:http://www.quwan.com/index?name=tyler  
 * 参数：paramName URL参数  
 * 调用方法:getParam("name")  
 * 返回值:tyler  
 */  
function getParam(paramName) {  
    paramValue = "", isFound = !1;  
    if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) {  
        arrSource = unescape(this.location.search).substring(1, this.location.search.length).split("&"), i = 0;  
        while (i < arrSource.length && !isFound) arrSource[i].indexOf("=") > 0 && arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase() && (paramValue = arrSource[i].split("=")[1], isFound = !0), i++  
    }  
    return paramValue == "" && (paramValue = null), paramValue  
}  