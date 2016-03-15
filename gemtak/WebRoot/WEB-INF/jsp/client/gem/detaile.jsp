<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="bavlo">
<meta name="keywords" content="bavlo">
<meta name="author" content="bavlo">
<title>bavlo</title>
<link rel="stylesheet" href="${ctx }/resources/client/css/bootstrap.css" />
<link href="${ctx }/resources/client/css/index.css" rel="stylesheet">
<link href="${ctx }/resources/client/css/bootstrap-slider.min.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/jquery.js"></script>
<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/bootstrap-slider.min.js"></script>

<script>
$(document).ready(function() {
$("#ex8").slider({
	tooltip: 'always'
});
})
function jian(){
var mySlider = $("#ex8").slider();
var num = $("#ex8").slider('getValue');
if(num>1){
$("#ex8").slider('setValue',--num);
}
}
function jia(){
var mySlider = $("#ex8").slider();
var num = $("#ex8").slider('getValue');
if(num<30){
$("#ex8").slider('setValue',++num);
}
}
</script>
</head>
<body>
<div>
  <jsp:include page="../head.jsp"></jsp:include>
</div>
<div class="tit_all m_bottom_80 conbg">
	  <div class="container">
		  <div class="tit_all_left col-sm-12 col-md-7">
		     <div class="tit_img">
			   <image src="${ctx }/resources/client/images/ad.jpg" style="width:100%"/>
			   <span><a href=""><image src="${ctx }/resources/client/images/360.png" /></a></span>
			   <p>Gemtak</p>
			 </div>
			 <ul class="tit_ul">
			    <li  class="tit_lie col-md-6 col-xs-12">
				   <p><span>颜色/方位</span><image src="${ctx }/resources/client/images/ad2.png" /></p>
				   <p><span>视角</span><img src="${ctx }/resources/client/images/ad3.png" /></p>
				</li>
				<li class="tit_lir col-md-6 col-xs-12">
				   	<div class="para">
					  <span onclick="javascript:jian();" style="text-align:right"><img src="${ctx }/resources/client/images/j.png">
					   <font>X4.5</font>
					  </span>
					  <input id="ex8"  type="text" data-slider-min="1" data-slider-max="30" data-slider-step="1" data-slider-value="14"/>
					  <span style="float:right" onclick="javascript:jia();"><img src="${ctx }/resources/client/images/ja.png">
					  <font>X0.7<font>
					  </span>
					</div>		
				</li>			 
			 </ul>      		    
			  </div>
			  <div class="tit_sm  col-sm-12 col-md-5">
				<h6>2.35ct 黄水晶 （Citrine）</h6>
				<ul>
					<li><span>广州番禺铭盛宝石有限公司</span> </li><li>TEL：021-55698821
					</li><li>形状（Shalie）：<slian>梨形（liear）</span>
					</li><li>尺寸（Measurement）：<span>12.03×11.35×7.88</span>
					</li><li>颜色（Average color）：<span> </span>
					</li><li>净度（Clarity）：<span>细小瑕疵（VVS）</span>
					</li><li>切工（Cut）：<span>很好（VG）</span>
					</li><li>产地（Origin）：<span>斯里兰卡（Sri Lanka）</span>
					</li><li>处理（Treatment）：<span>加热（Heated）</span>
					</li><li>证书（Cert.）：<span>国检（NGTC） 11358879902</span>
					</li><li>数量（Quantity）:  <span>1</span>
					</li><li>编号（ID）：<span>2037558</span>
					</li><li>卖家（Seller）：<span>惠兴宝石 （HuiXing Gemstone）</span></li>
				</ul>
				<p>价格（Price）：<span>¥ 1380.00 <em>/颗</em></span></p>
				<div class="add_gu"><a href="./shopping_car.html" class="gw_a">+ 购物车</a><a href="">订购款式 ></a></div>		  
		  </div>
	  </div>	  
</div>
<div class="footer hidden-xs hidden-sm">
    <jsp:include page="../../admin/foot.jsp"></jsp:include>
</div>
</body>
</html>