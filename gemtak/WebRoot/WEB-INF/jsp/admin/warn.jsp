<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="TotalCartPices" value="0" />

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
<title>GemTak Warning</title>
<link rel="stylesheet" href="${ctx}/resources/client/css/bootstrap.css" />
<link href="${ctx}/resources/client/css/index.css" rel="stylesheet">
<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/jquery.js"></script>
<style type="text/css">
.conbg{
    background: none;
}
</style>
</head>
<body>
<div>
  <div class="nav col-xs-12">
     <ul>
	    <li class="nav_list hidden-md hidden-lg"><a href="javascript:void(0)"><image src="${ctx }/resources/client/images/list.png" /></a></li>
		<li class="nav_logo hidden-xs hidden-sm"><a href="javascript:void(0)"><image src="${ctx }/resources/client/images/logo.png" /></a></li>
		<li class="nav_logo hidden-md hidden-lg"><a href="javascript:void(0)"><image src="${ctx }/resources/client/images/logos.png" /></a></li>
		<li class="nav_home hidden-md hidden-lg"><a href="javascript:void(0)"><image src="${ctx }/resources/client/images/home.png" /></a></li>
	 </ul>
  </div>  
</div>
<div class="tit_all m_bottom_80 conbg">
	  <div class="container">
	      <div class="wrap">
		     <div class="gw_tite"></div>
			 <div class="wrap_br">
				<div class="wrap_bj del-car-${gem.vdef2}"><h3>抱歉，您暂时没有权限访问...</h3></div>	 
			 </div>
		   </div>
	</div>
</div>
<div class="footer hidden-xs hidden-sm">
    <div class="foot"> 
	   <p><a href="javascript:void(0)">关于Gemtak</a><font>|</font><a href="javascript:void(0)">隐私条款</a><font>|</font><a href="javascript:void(0)">版权声明</a><font>|</font><a href="javascript:void(0)">质量承诺</a><font>|</font><a href="javascript:void(0)">加入我们</a><font>|</font><a href="javascript:void(0)">京ICP备11048465号</a><font>|</font> 恭候致电 010-82830789</p>
	   <p>Copyright © 2016 Gemtak.com All Right Reserved。</p>
	</div>
</div>
</body>
</html>