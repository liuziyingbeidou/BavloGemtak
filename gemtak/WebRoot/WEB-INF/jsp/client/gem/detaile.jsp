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
			   <!--<image src="${ctx }/resources/client/images/ad.jpg" style="width:100%"/>-->
			   <img src="${ctx }/resources/1024/hbx/001.jpg" width="100%" height="100%" 
				class="reel"
			   	id="image"
			  	data-images="${ctx }/resources/1024/hbx/###.jpg"
			 	data-frames="200"
			  	data-footage="50"
			  	data-cw="true"
			  	data-orbital="0"
			  	data-inversed="true"
			  	data-speed="0.1"
				data-revolution="800"
				data-scrollable="true"
				data-cursor="hand"
				data-delay="1"
				data-timeout="1"/>
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
				<h6>${gem.weight} ${gem.type_cn} （${gem.type_en}）</h6>
				<ul>
					<li><span>${gem.supplier}</span> </li><li>TEL：${gem.supplier_tel}
					</li><li>形状（Shalie）：<slian>${gem.shape_cn}（${gem.shape_en}）</span>
					</li><li>尺寸（Measurement）：<span>${gem.size_l}×${gem.size_w}×${gem.size_h}</span>
					</li><li>颜色（Average color）：<span> ${gem.average_color}</span>
					</li><li>净度（Clarity）：<span>${gem.clarity_cn}（${gem.clarity_en}）</span>
					</li><li>切工（Cut）：<span>${gem.cut_cn}（${gem.cut_en}）</span>
					</li><li>产地（Origin）：<span>${gem.origin_cn}（Sri Lanka）</span>
					</li><li>处理（Treatment）：<span>${gem.treatment_cn}（${gem.treatment_en}）</span>
					</li><li>证书（Cert.）：<span>国检（${gem.lab_en}） ${gem.supplier_code}</span>
					</li><li>数量（Quantity）:  <span>${gem.stock_qty}</span>
					</li><li>编号（ID）：<span>${gem.stock_qty}</span>
					</li><li>卖家（Seller）：<span>${gem.supplier}（HuiXing Gemstone）</span></li>
				</ul>
				<p>价格（Price）：<span>¥${gem.retail_price} <em>/${gem.pairs}</em></span></p>
				<div class="add_gu"><a href="./shopping_car.html" class="gw_a">+ 购物车</a><a href="">订购款式 ></a></div>		  
		  </div>
	  </div>	  
</div>
<div class="footer hidden-xs hidden-sm">
    <jsp:include page="../../admin/foot.jsp"></jsp:include>
</div>
</body>
    
	<script type="text/javascript">
	$(function(){
		GetArgsFromHref();
	});

	 function GetArgsFromHref() 
	 { 
		$("#image").prop("src","${ctx }/resources/1024/${model}/001.jpg");
		$("#image").attr("data-images","${ctx }/resources/1024/${model}/###.jpg");
	 } 
 		
</script>
<script src='${ctx }/resources/reel/js/jquery.bavlo.js' type='text/javascript'></script>
</html>