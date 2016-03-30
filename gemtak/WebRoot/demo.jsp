<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Demo</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/jquery.js"></script>
	<!-- amazeui -->
	<link rel="stylesheet" href="${ctx }/resources/amazeui/css/amazeui.min.css"/>
	<script type="text/javascript" src="${ctx }/resources/amazeui/js/handlebars.min.js"></script>
	<script type="text/javascript" src="${ctx }/resources/amazeui/js/amazeui.min.js"></script>	
  </head>
  
  <body>
	<span class="am-btn am-btn-danger"
	  data-am-modal="{target: '#my-popup'}">弹框</span>
	<div class="am-popup" id="my-popup">
	  <div class="am-popup-inner">
	    <div class="am-popup-hd">
	      <h4 class="am-popup-title">登录注册</h4>
	      <span data-am-modal-close
	            class="am-close">&times;</span>
	    </div>
	    <div class="am-popup-bd">
	      <iframe id="iframe" src="${ctx }/gemClient/login.do" frameborder="no" height="600" width="100%"></iframe>
	    </div>
	  </div>
	</div>
  </body>
</html>
