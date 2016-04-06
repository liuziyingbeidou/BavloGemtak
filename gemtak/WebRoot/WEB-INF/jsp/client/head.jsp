<%@ page language="java" import="java.util.*,com.bavlo.gemtak.constant.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Object username = request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
 %>
<c:set var="uname" value="<%=username %>"/>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<style>
#collapse-nav{
	background-color:#fff;
}
.am-slides{
	list-style:none;
}
.am-slides li{
	list-style:none;
	float:left;
	padding-left:5px;
}
.am-slides li img{
	width:80px;
	height:100px;
}
</style>
<div class="top_nav hidden-xs hidden-sm">
  <div class="top container">
	<span><image src="${ctx }/resources/client/images/call.png" />0086-010-82830789&nbsp;</span>
	<span class="h-lang">[${pagehfvo['hLanguage'] }]</span>
	<div class="top_a">
	  <c:if test="${uname != null}">
	    <t class="t-css"> Hi, ${uname}</t>
	    <a class="replaceA" href="${ctx }/gemClient/logout.do">注销</a>|
		<a class="replaceB" href="">我的订单</a>|
	  </c:if>
	  <c:if test="${uname == null}">
	    <t class="t-css"></t>
	    <a class="replaceA" href="${ctx }/gemClient/login.do?dengluNUM=1">登录</a>|
		<a class="replaceB" href="${ctx }/gemClient/login.do">注册</a>|
	  </c:if>
		<a href="javascript:void(0)" class="myCollapse" cls="cls-folder">收藏夹</a>|
	  <c:if test="${uname == null}">
	    <a  href="${ctx }/gemClient/login.do">购物车 <t class="cart-num"></t></a>
	  </c:if>
	  <c:if test="${uname != null}">
	    <a  href="${ctx }/gemClient/viewShoppingCar.do">购物车 <t class="cart-num"></t></a>
	  </c:if>
		<a href="" class="jesuan">去结算</a>
	</div>
  </div>
  <!-- 折叠下拉 -->
	<nav>
	  <ul id="collapse-nav" class="am-nav am-collapse">
	    <li>
		    <ul class="am-slides show-cookies">
		      <c:forEach items="${gemList}" var="gem">
			    
			   </c:forEach>
			 </ul>
		 
	    </li>
	  </ul>
	</nav>
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

<!-- amazeui -->
<link rel="stylesheet" href="${ctx }/resources/amazeui/css/amazeui.min.css"/>
<script type="text/javascript" src="${ctx }/resources/amazeui/js/handlebars.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/amazeui/js/amazeui.min.js"></script>	

<script>
  //加载购物车中 商品数量
  function selCarNO(num){
   $(".cart-num").text("("+num+")");
  }
   //动态查询购物车数量
  function getCarNum(){
   var url = "/gemtak/gemClient/getCarNum.do";
   $.post(url,function(data){
    selCarNO(data);
   });
  }
  $(function(){
     //点击触发收藏夹
  	$(".myCollapse").click(function(){
		$("#collapse-nav").collapse('toggle');
  		if(!$("#collapse-nav").hasClass('am-in')){
  			var cls = $(this).attr("cls");
	  		if(cls == "cls-folder"){
	  			//收藏夹处理
	  			var url = "/gemtak/gemClient/showCookies.do";
	  			$.post(url,function(data){
	  			  $(".show-cookies").empty();
	  			  if(data != null){
	  			    var len = data.length;
	  			    if(len > 0){
		  			    for(var i=0;i<len;i++){
		  			     $(".show-cookies").append("<li class='delectPic-"+data[i].id+"'><a onclick='goDetail("+data[i].id+")'><img src='http://s.amazeui.org/media/i/demos/pure-4.jpg?imageView2/0/w/640'  alt='"+data[i].retail_price+"'/></a><span onclick='delCookie("+data[i].id+")'>X</span></li>");
		  			    }
	  			    }else{
	                   alert("您还没有收藏任何宝贝哟！");
	                }
	  			  }
                });
	  		}
  		}
	});
  });
  
  /**
 * 跳转详情页
 */
function goDetail(id){
	location.href = "viewGemDetaile.do?id="+id;
}
  /**
 * 刪除cookie中選中的商品
 */
function delCookie(id){
	 var url = "removeCookie.do";
	  $.post(url,{gemid:id},function(data){
		  data = $.parseJSON(data);
		  var flag = data.msg;
		  if(flag=="Y"){
			  alert("您已成功删除该宝贝！");
			  $(".delectPic-"+id+"").remove();
		  }
	  });
}
</script>