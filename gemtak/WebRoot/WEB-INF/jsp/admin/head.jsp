<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div class="container">
	 <div class="nav_logo">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);">${pagehfvo['hTitle'] }</a>&nbsp;<span class="h-lang">[${pagehfvo['hLanguage'] }]</span></div>
</div>
<script language="javascript" type="text/javascript" src="${ctx }/resources/admin/js/gem-common.js"></script>
<link rel="stylesheet" href="${ctx }/resources/admin/css/gem-common.css" />
<!-- amazeui -->
<link rel="stylesheet" href="${ctx }/resources/amazeui/css/amazeui.min.css"/>
<script type="text/javascript" src="${ctx }/resources/amazeui/js/handlebars.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/amazeui/js/amazeui.min.js"></script>
<<script type="text/javascript">
 function selGemList(){
   location.href = "${ctx}/gemAdmin/viewGemList.do";
 }
 function selOrderList(){
  location.href = "${ctx}/gemClient/viewOrderList.do";
 }
</script>	
  <nav data-am-widget="menu" class="am-menu  am-menu-offcanvas1" data-am-menu-offcanvas> 
    <a href="javascript: void(0)" class="am-menu-toggle">
          <i class="am-menu-toggle-icon am-icon-bars"></i>
    </a>
    <div class="am-offcanvas" >
      <div class="am-offcanvas-bar">
      <ul class="am-menu-nav am-avg-sm-1">
          <li class="am-parent">
            <a href="javascript:void(0)" onclick="selGemList()" class="mn-mr-gem" >宝石管理</a>
          </li>
          <li class="am-parent">
            <a href="javascript:void(0)" onclick="" class="mn-mr-order" >订单管理</a><!--selOrderList()  -->
          </li>
      </ul>
      </div>
    </div>
  </nav>
