<%@page import="com.bavlo.gemtak.util.weixin.IContant"%>
<%@ page language="java" import="java.util.*,com.bavlo.gemtak.constant.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
  Object uname = request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
 %>
 <c:set var="uname" value="<%=uname %>"/>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width,minimum-scale=0.5,maximum-scale=0.5,initial-scale=0.5"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no,maximum-scale=1.0"/>
<meta name="description" content="bavlo"/>
<meta name="keywords" content="bavlo"/>
<meta name="author" content="bavlo"/>
<title>bavlo</title>
<link rel="stylesheet" href="${ctx }/resources/client/css/bootstrap.css" />
<link href="${ctx }/resources/client/css/index.css" rel="stylesheet"/>
<link rel="stylesheet" href="${ctx }/resources/client/css/newfly.css" type="text/css"/>
<link href="${ctx }/resources/client/css/bootstrap-slider.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx }/resources/client/css/files/loaders.css" type="text/css"></link>

<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/jquery-1.7.2.min.js"></script>
<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/bootstrap-slider.min.js"></script>
<!-- amazeui -->
<link rel="stylesheet" href="${ctx }/resources/amazeui/css/amazeui.min.css"/>
<script type="text/javascript" src="${ctx }/resources/amazeui/js/handlebars.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/amazeui/js/amazeui.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/client/js/jsKnob/jquery.knob.js"></script>
<script language="javascript" type="text/javascript">

// 找到支持的方法, 使用需要全屏的 element 调用
function launchFullScreen(element) {
  if(element.requestFullscreen) {
    element.requestFullscreen();
  } else if(element.mozRequestFullScreen) {
    element.mozRequestFullScreen();
  } else if(element.webkitRequestFullscreen) {
    element.webkitRequestFullscreen();
  } else if(element.msRequestFullscreen) {
    element.msRequestFullscreen();
  }
}
// 在支持全屏的浏览器中启动全屏
launchFullScreen(document.getElementById("videoElement"));

</script>

<style type="text/css">
 .yemianyanchi{
 	text-align: center;
 }
</style>
</head>
<body> 
	<div id="videoElement" class="tit_img" style="width: 100%;">
	   <jsp:include  page="load-img.jsp"></jsp:include>
	   
	   <span><a href="javascript:void(0)" >
	      <img  src="${ctx }/resources/client/images/360.png" />
	   </a></span>
	   <p>Gemtak</p>
	   <b>
	     <a href="javascript:void(0)" onclick="history.go(-1);">
	      <img src="${ctx }/resources/client/images/small.png"  alt="回看原图"/>
	     </a>
	   </b>
	</div>
	
	
</body>
</html>