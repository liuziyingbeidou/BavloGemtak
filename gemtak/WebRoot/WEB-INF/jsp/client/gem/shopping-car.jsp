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
<link rel="stylesheet" href="${ctx}/resources/client/css/bootstrap.css" />
<link href="${ctx}/resources/client/css/index.css" rel="stylesheet">
<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/jquery.js"></script>

</head>
<body>
<div>
  <jsp:include page="../head.jsp"></jsp:include>
</div>
<div class="tit_all m_bottom_80 conbg">
	  <div class="container">
	      <div class="wrap">
		     <div class="gw_tite">购物车</div>
			 <div class="wrap_br">
				<div class="wrap_bj"><h3>幸福蓝海<b>戒指</b><b>女款</b></h3><a href=""></a></div>	 
				<dl class="gwc1">
					<dt class="col-xs-12 col-sm-5"><a href=""><img src="${ctx}/resources/client/images/gwc1.png"/></a></dt>
					<dd class="col-xs-12 col-sm-7"><p>碧玺：1粒   约 0.28 ct</p>
					<p>颜色： 153,22,131(RGB)</p>
					<p>规格： 6.00,4.00,2.29 </p>
					<p>钻石：14粒   共约 0.16 ct</p>
					<p>颜色： H</p>
					<p>规格： 1.40 x 1.40 x 0.84 </p>
					<p>金属： 白18K金</p>
					<p>手寸：12号</p>
					<p>尺寸： 19.36×9.09×21.24 </p></dd>
				</dl>
				<div class="wrap_bj wrap_bj1"><span>数量<input  class="" type="text" name=""  value="1" /></span><span>总价：￥5780 元</span></div>  
			 </div>
			 
		   </div>
   	 <div class="wrap_all">
		   <p><span style="float:right">合计<b>￥8865.00</b>元</span></p>
		   <p><a href="" class="zgg">再逛逛</a><a href="./order.html" class="qjz">去结账</a></p>
	 </div>   	  
	</div>
</div>
<div class="footer hidden-xs hidden-sm">
    <jsp:include page="../../admin/foot.jsp"></jsp:include>
</div>
</body>
</html>