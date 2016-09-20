<%@page import="com.bavlo.gemtak.util.weixin.IContant"%>
<%@ page language="java" import="java.util.*,com.bavlo.gemtak.constant.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
  Object uname = request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
  Object type = request.getSession().getAttribute("type");
  Object shape = request.getSession().getAttribute("shape");
  Object weight = request.getSession().getAttribute("weight");
 %>
 <c:set var="uname" value="<%=uname %>"/>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<meta name="description" content="bavlo"/>
<meta name="keywords" content="bavlo"/>
<meta name="author" content="bavlo"/>
<title>Gemtak 金塔_<%=type%>_<%=shape%>_<%=weight%></title>
<link rel="stylesheet" href="${ctx }/resources/client/css/bootstrap.css" />
<link href="${ctx }/resources/client/css/index.css" rel="stylesheet"/>
<link rel="stylesheet" href="${ctx }/resources/client/css/newfly.css" type="text/css"/>
<link href="${ctx }/resources/client/css/bootstrap-slider.min.css" rel="stylesheet" type="text/css" />
<%-- <link rel="stylesheet" href="${ctx }/resources/client/css/files/loaders.css" type="text/css"></link> --%>

<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/jquery-1.7.2.min.js"></script>
<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/bootstrap-slider.min.js"></script>
<!-- amazeui -->
<link rel="stylesheet" href="${ctx }/resources/amazeui/css/amazeui.min.css"/>
<script type="text/javascript" src="${ctx }/resources/amazeui/js/handlebars.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/amazeui/js/amazeui.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/client/js/jsKnob/jquery.knob.js"></script>
<%
  String bis = (String)session.getAttribute("bisBis");
 %>
 <c:set value="<%=bis %>" var="bis"/>
<script>
$(document).ready(function() {
    $(".yemianyanchi").show();
	getCarNum();
	$(".dial").knob({
	 max: 360,
     min: 0
	});
	 $(".dial-station").knob({
	 max: 360,
     min: 0,
	 change:function(){
	 	//alert("change");
	 },
	 release:function(frame){
	 	//$(".clz-v-station").text(frame);
	 }
	 });
	
	$("#ex8").slider({
		tooltip: 'always'
	});
	 $(".yemianyanchi").hide(); 
});

//jquery.bavlo.js 颜色/方位
function setStation(frame){
	var vl = frame * 1.8;
	$(".dial-station").val(vl);
	$(".dial-station").trigger("change");
}
function setDial(frame){   //视角
   var dl = 90;
   $(".dial").val(dl);
   $(".dial").trigger("change");
}


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


//添加到购物车
function addShoppCar(id){
      var uname = $(".hiduname").attr("nid");
      if(uname == null||uname == ""){  //沒取到用戶名  跳转到登录
        $("#my-popup").modal('toggle');
      }else{
        //加入购物车效果getCarNum();
        layer.alert('恭喜您，宝贝已加入购物车！', {
		  skin: 'layui-layer-molv' //样式类名
		  ,closeBtn: 0
		}, function(){
		  layer.alert('Gemtak,欢迎您的光临！', {
		    skin: 'layui-layer-lan'
		    ,closeBtn: 0
		    ,shift: 4 //动画类型
		  });
		});
        
      }
      var quantity =  $(".selquantity").text();
	  var url = "/gemtak/gemClient/addShoppingCar.do";
	  $.post(url,{gemId:id,quantity:quantity},function(data){
	    data = $.parseJSON(data);
	    var flag = data.mess;
	    var num = data.carNum;
	    if(flag=="Y"){
	      selCarNO(num);  //方法在head.jsp 
	    }
	  });
  
} 
 //登录成功 关闭登录弹窗
 function closeMwin(name){ 
  /* getCarNum();
  $(".t-css").text("Hi,"+name);//登录成功后，将用户名传过来
  $(".replaceA").text("注销");
  $(".replaceA").attr("href","${ctx }/gemClient/logout.do");
  $(".replaceB").text("我的订单");
  $(".replaceB").attr("href",""); */
  //$("#my-popup").modal('close');
  window.location.reload(); 
 }

 function viewFullScreen(){
  var gid = $(".tit_sm").attr("gid");
  location.href="/gemtak/gemClient/viewGemPic.do?id="+gid;
 }

</script>

<style type="text/css">
 .yemianyanchi{
 	text-align: center;
 }
</style>
</head>
<body>
<div>
  <jsp:include page="../head.jsp"></jsp:include>
  <input type="hidden" class="hiduname" nid="${uname }" />
</div>
	<div class="am-popup" id="my-popup">
	  <div class="am-popup-inner">
	    <div class="am-popup-hd">
	      <span data-am-modal-close
	            class="am-close">.&times;</span>
	    </div>
	    <div class="am-popup-bd">
	      <iframe id="iframe" src="${ctx }/gemClient/login.do?dengluNUM=2" frameborder="no" height="550" width="100%"></iframe>
	    </div>
	  </div>
	</div>
	
<div class="tit_all m_bottom_80 conbg">
	  <div class="container">
		  <div class="tit_all_left col-sm-12 col-md-7">
             <!-- <div class="loader yemianyanchi" style="display: none;">
		        <div class="loader-inner ball-pulse-rise">
		          <div></div>
		          <div></div>
		          <div></div>
		          <div></div>
		          <div></div>
		        </div>
			 </div> -->
		     <div class="tit_img">
			   <!--<image src="${ctx }/resources/client/images/ad.jpg" style="width:100%"/>-->
			   <!--<iframe id="iframe" src="${ctx }/gemClient/loadImg.do" frameborder="no" width="100%"></iframe>-->
			   <jsp:include  page="load-img.jsp"></jsp:include>
			   
			   <span><a href="javascript:void(0)" >
			      <img  src="${ctx }/resources/client/images/360.png" />
			   </a></span>
			   <p>Gemtak</p>
			   <b>
			     <a href="javascript:void(0)" onclick="viewFullScreen();">
			      <img src="${ctx }/resources/client/images/full.png"  alt="全屏显示"/>
			     </a>
			   </b>
			 </div>
			 <!-- 延迟加载   start  loaders.css-->
				<div class="yemianyanchi">
				<img src="${ctx }/resources/client/images/load2.gif"></img>
				</div>
			<!-- 延迟加载   end -->
			 <ul class="tit_ul">
				<li  class="tit_lie col-md-6 col-xs-12">
				   <div class="col-xs-6">
					   <div class="text-center shangbiao" >       						
							<h3 class="font-bold no-margins">颜色/方位</h3>
							<div class="m-b-md inline">
								<input type="text" value="0" class="dial-station m-r-sm" data-fgColor="#faa668" data-width="85" data-height="85" />
								<!-- <span class="clz-v-station"></span> -->
							</div>
					   </div>
					</div>
					<div class="col-xs-6"  data-dismiss="modal">
					   <div class="text-center shangbiao" >       
							<h3 class="font-bold no-margins">视角</h3>
							<div class="m-b-md inline">
								<input type="text" value="90" class="dial m-r-sm" data-fgColor="#faa668" data-width="85" data-height="85" />
							</div>				
					   </div>
					</div>   
				</li>
				<%-- <li class="tit_lir col-md-6 col-xs-12">				  				 
				   	<div class="para">
				   	  <span onclick="javascript:jian();" style="text-align:right"><img src="${ctx }/resources/client/images/j.png"/>
					  <font>X4.5<font>
					  </span>
					  <input id="ex8"  type="text" data-slider-min="1" data-slider-max="30" data-slider-step="1" data-slider-value="14"/>
					  <span style="float:right" onclick="javascript:jia();"><img src="${ctx }/resources/client/images/ja.png"/>
					  <font>X0.7<font>
					  </span>
					</div>
				</li> --%>			 
			 </ul>      		    
			</div>
			<div class="tit_sm  col-sm-12 col-md-5" gid="${gem.id}">
				<h6>${gem.weight} ${gem.type_cn} （${gem.type_en}）</h6>
				<ul>
					<li><span>${gem.company}</span> </li><li>TEL：${gem.supplier_tel}
					</li><li>形状：<slian>${gem.shape_cn}</span>
					</li><li>尺寸：<span>${gem.size_l} * ${gem.size_w} * ${gem.size_h}</span>
					</li><li>颜色：<span> ${gem.average_color}</span>
					</li><li>净度：<span>${gem.clarity_cn}（${gem.clarity_en}）</span>
					</li><li>切工：<span>${gem.cut_cn}</span>
					</li><li>产地：<span>${gem.origin_cn}</span>
					</li><li>处理：<span>${gem.treatment_cn}</span>
					</li><li>证书：<span>国检（${gem.lab_en}） ${gem.lab_no}</span>
					</li><li>编号：<span>${gem.lab_no}</span>
					</li><li>卖家：<span>${gem.company}</span></li>
					</li><li>数量：<span class="selquantity">1</span>
				</ul>
				<c:if test="${bis=='Y'}">
				 <c:if test="${gem.pairs=='sl'}">
				   <p>价格：<span>¥${gem.trade_price} <em>/单粒</em></span></p>
				 </c:if>
				 <c:if test="${gem.pairs=='pl'}">
				   <p>价格：<span>¥${gem.trade_price} <em>/配对</em></span></p>
				 </c:if>
				 <c:if test="${gem.pairs=='ml'}">
				   <p>价格：<span>¥${gem.trade_price} <em>/</em>多粒</span></p>
				 </c:if>
				</c:if>
				<c:if test="${bis!='Y'}">
				  <c:if test="${gem.pairs=='sl'}">
				   <p>价格：<span>¥${gem.retail_price} <em>/单粒</em></span></p>
				 </c:if>
				 <c:if test="${gem.pairs=='pl'}">
				   <p>价格：<span>¥${gem.retail_price} <em>/配对</em></span></p>
				 </c:if>
				 <c:if test="${gem.pairs=='ml'}">
				   <p>价格：<span>¥${gem.retail_price} <em>/</em>多粒</span></p>
				 </c:if>
				</c:if>
				<b style="display: none"><img  class="360tupian" src="${ctx }/resources/client/images/cp2.jpg"/></b>
				<div class="add_gu">
				  <a href="javascript:void(0)" class="gw_a addcar" onclick="addShoppCar(${gem.id})">购物车</a>
				  <a href="${ctx }/gemClient/viewGemList.do">去首页</a>
				</div>
		  </div>
	  </div>
</div>
<div class="footer hidden-xs hidden-sm">
    <jsp:include page="../../admin/foot.jsp"></jsp:include>
</div>

<script>

</script>
</body>
</html>