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
	<script language="javascript" type="text/javascript" src="${ctx }/resources/reel/js/jquery-1.9.1.min.js"></script>
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
	<br><br><br>
	<!-- 以下是下拉框 -->
	<span class="am-btn am-btn-secondary" id="doc-dropdown-toggle">下拉域</span>
	<div class="am-dropdown" id="doc-dropdown-js">
	    <div class="am-dropdown-content">
	   	 填充内容
	    </div>
	</div>
	<script>
	  $(function() {
	  	var $dropdown = $('#doc-dropdown-js');
	    $('.am-dropdown-toggle').on("click", function(e) {
	      if($("#doc-dropdown-js").hasClass("am-active")){
              $("#doc-dropdown-js").removeClass('am-active');
          }else{
          	  $("#doc-dropdown-js").addClass('am-active');
          }
	      return false;
	    });
	    
	    $('#doc-dropdown-toggle').on('click', function(e) {
	      if($("#doc-dropdown-js").hasClass("am-active")){
              $("#doc-dropdown-js").removeClass('am-active');
          }else{
          	  $("#doc-dropdown-js").addClass('am-active');
          }
	      return false;
	    });
	  });
	</script>
	
	<!-- 折叠下拉 -->
	<button class="am-btn am-btn-primary" data-am-collapse="{target: '#collapse-nav'}">Menu <i class="am-icon-bars"></i></button>
	<nav>
	  <ul id="collapse-nav" class="am-nav am-collapse">
	    <li><a href="">开始使用</a></li>
	    <li><a href="">CSS 介绍</a></li>
	    <li class="am-active"><a href="">JS 介绍</a></li>
	    <li><a href="">功能定制</a></li>
	  </ul>
	</nav>
  </body>
</html>
