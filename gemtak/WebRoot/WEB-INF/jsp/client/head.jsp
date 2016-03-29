<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="top_nav hidden-xs hidden-sm">
  <div class="top container">
<span><image src="${ctx }/resources/client/images/call.png" />0086-010-82830789&nbsp;</span><span class="h-lang">[${pagehfvo['hLanguage'] }]</span>
<div class="top_a">Hi, ${username}<a href="${ctx }/gemClient/login.do">登录</a>|<a href="${ctx }/gemClient/login.do">注册</a>|<a href="">收藏夹</a>|<a  href="./shopping_car.html">购物车 <t class="cart-num">(0)</t></a><a href="" class="jesuan">去结算</a></div>
  </div>
</div>
<div class="nav col-xs-12">
   <ul>
   <li class="nav_list hidden-md hidden-lg"><a href="./nav.html"><image src="${ctx }/resources/client/images/list.png" /></a></li>
<li class="nav_logo hidden-xs hidden-sm"><a href="./list.html"><image src="${ctx }/resources/client/images/logo.png" /></a></li>
<li class="nav_logo hidden-md hidden-lg"><a href="./list.html"><image src="${ctx }/resources/client/images/logos.png" /></a></li>
<li class="nav_home hidden-md hidden-lg"><a href="./login.html"><image src="${ctx }/resources/client/images/home.png" /></a></li>
</ul>
</div>  

<script language="javascript" type="text/javascript" src="${ctx }/resources/admin/js/gem-common.js"></script>
<link rel="stylesheet" href="${ctx }/resources/admin/css/gem-common.css" />

<script>
  //加载购物车中 商品数量
  function selCarNO(num){
   $(".cart-num").text("("+num+")");
  }
  
</script>