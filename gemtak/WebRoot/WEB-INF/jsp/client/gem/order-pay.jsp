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
<title>彩色宝石、钻石、报价、3D、鉴定、珠宝定制、Gemtak</title>
<link rel="stylesheet" href="${ctx }/resources/client/css/bootstrap.css" />
<link href="${ctx }/resources/client/css/index.css" rel="stylesheet"/>
<link href="${ctx }/resources/client/css/login.css" rel="stylesheet"/>
<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/jquery.js"></script>
<link  rel="shortcut icon" href="../favicon.ico"/>
</head>
<body>
<div>
  <jsp:include page="../head.jsp"></jsp:include> 
</div>
<div class="tit_all m_bottom_80 conbg">
	  <div class="container">
			<div class="wrap">
			     <div class="gw_tite">支付</div>
				 <div class="wrap_br wrap_br_d">
					<h2><span>支付提示</span></h2>
					<div class="scdd scdd1">
						 <p class="fc_0">支付已成功！</p>
						 <p>订单号为：<span>${orderno}</span></p><p>
						 总金额为：<span>￥${totalPrice}元</span></p>
						 <div class="qzf"><a href="${ctx }/gemtak/gemClient/viewGemList.do">关 闭</a></div>
					</div>
				 </div>
		   </div>   	  
    </div>
</div>
<div class="footer hidden-xs hidden-sm">
    <jsp:include page="../../admin/foot.jsp"></jsp:include>
</div>
</body>
</html>