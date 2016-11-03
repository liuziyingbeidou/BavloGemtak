<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>金塔宝石库|Gemtak</title>
<link rel="stylesheet" href="${ctx }/resources/client/css/bootstrap.css" />
<link href="${ctx }/resources/client/css/index.css" rel="stylesheet"/>
<link href="${ctx }/resources/client/css/login.css" rel="stylesheet"/>
<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/jquery.js"></script>

</head>
<body>
<div>
  <jsp:include page="../head.jsp"></jsp:include> 
</div>
<div class="tit_all m_bottom_80 conbg">
	  <div class="container">
			<div class="wrap">
			     <div class="gw_tite">订单</div>
				 <div class="gw_nav">
			   <ul>
			     <li class="col-xs-4"><span>1</span>购物车</li>
				 <li class="col-xs-4"><span>2</span>确认定单</li>
			     <li class="gw_nav_sel col-xs-4"><span>3</span>成功提交订单</li>
			   </ul>
			  
			</div>  
				 <div class="wrap_br wrap_br_d">
					<h2><span>订单已生成</span></h2>
					<div class="scdd scdd1">
						 <p  class="fc_0">订单号为：<span>${orderNo}</span></p>
						 <p>总金额为：<span>￥${totalPrice}元</span></p>
						 <div class="qzf"><a href="javascript:jsPayFee();">去支付</a></div>
					</div>
				 </div>
		   </div>   	  
	  </div>
</div>
<div class="footer hidden-xs hidden-sm">
    <jsp:include page="../../admin/foot.jsp"></jsp:include>
</div>
</body>
<script>
	var ua = navigator.userAgent.toLowerCase();
		   if(ua.match(/MicroMessenger/i)=="micromessenger") {
		    } else {
		    	alert("支付!请在微信端打开!");
		    }
			function jsPayFee() {
				var str = window.navigator.userAgent;
				var version = str.substring(8, 11);
				if (version != "5.0") {
					alert("请将微信升级至5.0以上");
				} else {
						WeixinJSBridge.invoke('getBrandWCPayRequest', {
							"appId" :'${map.pr.appId}', //公众号名称，由商户传入
							"timeStamp" :'${map.pr.timeStamp}' , //戳
							"nonceStr" : '${map.pr.nonceStr}', //随机串
							"package" :'${map.pr.packageurl}' ,//统一支付接口返回的prepay_id 参数值，提交格式如：prepay_id=***
							"signType" : "MD5", //微信签名方式:sha1
							"paySign" : '${map.pr.paySign}'//微信签名
							
						}, function(res) {
								if (res.err_msg == "get_brand_wcpay_request:ok") {
									alert("付款成功！");
									rewriteOrderSatus(); //支付成功后 修改订单状态 为已支付
								} else if (res.err_msg == "get_brand_wcpay_request:cancel") {
									//alert("取消支付");
								} else if (res.err_msg == "get_brand_wcpay_request:fail") {
									alert("支付失败");
								}
							});
					}
			}
			//修改 订单状态
			function rewriteOrderSatus(){
			  var orderno = ${orderNo};
			  var totalPrice = ${totalPrice};
			  var url = "/gemtak/gemClient/rewriteOrderStatus.do";
			  $.post(url,{orderno:orderno},function(data){
			    location.href = "/gemtak/gemClient/goOrderPay.do?orderno="+orderno+"&totalPrice="+totalPrice;
			  });
			}
</script>
</html>