<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="bavlo">
<meta name="keywords" content="bavlo">
<meta name="author" content="bavlo">
<title>bavlo</title>
<link rel="stylesheet" href="${ctx }/resources/admin/css/bootstrap.css" />
<link href="${ctx }/resources/admin/css/index.css" rel="stylesheet">
<script language="javascript" type="text/javascript" src="${ctx }/resources/admin/js/jquery.js"></script>
</head>
<body>

<div class="nav col-xs-12">
     <div class="container">
		 <div class="nav_logo"><a href="./.html">Gemtak后台管理 </a></div>
	 </div>
</div>  
<div class="tit_all">
	<div class="container">
	  <div class="tit tit_p">	  
			<a href="javascript:void(0);" id="typeid1"  onmouseover="javascript:show_menuone(1);">全部产品 </a>
			<a href="javascript:void(0);" id="typeid2"  onmouseover="javascript:show_menuone(2);">入库宝石</a>
			<a href="javascript:void(0);" id="typeid3"  onmouseover="javascript:show_menuone(3);">签收宝石</a>
			<a href="javascript:void(0);" id="typeid4"  onmouseover="javascript:show_menuone(4);">新上传</a>
		  <span class="fbgb">
			<a href="javascript:void(0);" id="typeid5"  onmouseover="javascript:show_menuone(5);">已发布 </a>
			<a href="javascript:void(0);" id="typeid6"  onmouseover="javascript:show_menuone(6);">已关闭</a>
		  </span>
	  </div>
	  <div class="tit ">
	    <ul class="tit_ul">
			<li class="col-sm-3 col-xs-6"><select class="form-control input-lg"><option>宝石类型</option><option></option><option></option><option></option></select></li>
			<li class="col-sm-3 col-xs-6"><select class="form-control input-lg"><option>宝石形状</option><option></option><option></option><option></option></select></li>
			<li class="col-sm-3 col-xs-6"><select class="form-control input-lg"><option>宝石形状</option><option></option><option></option><option></option></select></li>
			<li class="col-sm-3 col-xs-6"><p><input class="sear_ch_input" type="text" value="巴黎之吻"><input class="sear_ch_sub" type="submit" value=""></p></li>
		</ul>
	  
	  </div>
	  <div class="tit_table col-md-12 ">
		 <div class="nr_tit">
			 <p class="col-md-1 col-xs-3" style="text-align:center">图片</p>
			 <p class="col-md-11 col-xs-9">
				 <span class="col-md-5 hidden-xs hidden-sm" style="text-align:center">概览</span>
				 <span class="col-md-5 hidden-xs hidden-sm">编辑选项</span>
				 <span class="col-md-2 hidden-xs hidden-sm">操作</span>
				 <span class="col-xs-12 hidden-md hidden-lg" style="text-align:center">信息与操作</span>
			</p>
		 </div>  
		 <dl class="nr_con col-md-12">
		     <dt class="col-md-1 col-xs-3">
				 <img src="${ctx }/resources/admin/images/cp8.jpg" style="width:100%"/>
				 <p class=" hidden-md hidden-lg"><a href="" class="col-md-6 col-xs-6">删除</a><a href="" class="col-md-6 col-xs-6">发布</a></p>
			 </dt>
			 <dd class="col-md-11 col-xs-9">
				 <p class="col-md-5 col-xs-12"><span class="col-md-6 col-xs-12"><font>碧玺</font><font>心形</font><font>NGTC</font></span><span  class="col-md-6 col-xs-12"><font>8.50ct</font><font>1颗</font><font class="fc_001">¥168000</font></span></p>
				 <p class="col-md-5 col-xs-12"><span class="col-xs-12 col-md-6" >宝石：<a href="./game.html">入库</a><a href="">签收</a></span><span  class="col-xs-12 col-md-6 pad_0">成品：<a href="">入库</a><a href="">签收</a></span></p>
				 <p class="col-md-2 hidden-xs hidden-sm"><a href="">删除</a><a href="">发布</a></p>
			 </dd>
		  
		  </dl>
		  <dl class="nr_con col-md-12">
		     <dt class="col-md-1 col-xs-3">
				 <img src="${ctx }/resources/admin/images/cp8.jpg" style="width:100%"/>
				 <p class=" hidden-md hidden-lg"><a href="" class="col-md-6 col-xs-6">删除</a><a href="" class="col-md-6 col-xs-6">发布</a></p>
			 </dt>
			 <dd class="col-md-11 col-xs-9">
				 <p class="col-md-5 col-xs-12"><span class="col-md-6 col-xs-12"><font>碧玺</font><font>心形</font><font>NGTC</font></span><span  class="col-md-6 col-xs-12"><font>8.50ct</font><font>1颗</font><font class="fc_001">¥168000</font></span></p>
				 <p class="col-md-5 col-xs-12"><span class="col-xs-12 col-md-6" >宝石：<a href="./game.html">入库</a><a href="">签收</a></span><span  class="col-xs-12 col-md-6 pad_0">成品：<a href="">入库</a><a href="">签收</a></span></p>
				 <p class="col-md-2 hidden-xs hidden-sm"><a href="">删除</a><a href="">发布</a></p>
			 </dd>
		  
		  </dl>
		  <dl class="nr_con col-md-12">
		     <dt class="col-md-1 col-xs-3">
				 <img src="${ctx }/resources/admin/images/cp8.jpg" style="width:100%"/>
				 <p class=" hidden-md hidden-lg"><a href="" class="col-md-6 col-xs-6">删除</a><a href="" class="col-md-6 col-xs-6">发布</a></p>
			 </dt>
			 <dd class="col-md-11 col-xs-9">
				 <p class="col-md-5 col-xs-12"><span class="col-md-6 col-xs-12"><font>碧玺</font><font>心形</font><font>NGTC</font></span><span  class="col-md-6 col-xs-12"><font>8.50ct</font><font>1颗</font><font class="fc_001">¥168000</font></span></p>
				 <p class="col-md-5 col-xs-12"><span class="col-xs-12 col-md-6" >宝石：<a href="./game.html">入库</a><a href="">签收</a></span><span  class="col-xs-12 col-md-6 pad_0">成品：<a href="">入库</a><a href="">签收</a></span></p>
				 <p class="col-md-2 hidden-xs hidden-sm"><a href="">删除</a><a href="">发布</a></p>
			 </dd>
		  
		  </dl>
		  <dl class="nr_con col-md-12">
		     <dt class="col-md-1 col-xs-3">
				 <img src="${ctx }/resources/admin/images/cp8.jpg" style="width:100%"/>
				 <p class=" hidden-md hidden-lg"><a href="" class="col-md-6 col-xs-6">删除</a><a href="" class="col-md-6 col-xs-6">发布</a></p>
			 </dt>
			 <dd class="col-md-11 col-xs-9">
				 <p class="col-md-5 col-xs-12"><span class="col-md-6 col-xs-12"><font>碧玺</font><font>心形</font><font>NGTC</font></span><span  class="col-md-6 col-xs-12"><font>8.50ct</font><font>1颗</font><font class="fc_001">¥168000</font></span></p>
				 <p class="col-md-5 col-xs-12"><span class="col-xs-12 col-md-6" >宝石：<a href="./game.html">入库</a><a href="">签收</a></span><span  class="col-xs-12 col-md-6 pad_0">成品：<a href="">入库</a><a href="">签收</a></span></p>
				 <p class="col-md-2 hidden-xs hidden-sm"><a href="">删除</a><a href="">发布</a></p>
			 </dd>
		  
		  </dl>
		  <dl class="nr_con col-md-12">
		     <dt class="col-md-1 col-xs-3">
				 <img src="${ctx }/resources/admin/images/cp8.jpg" style="width:100%"/>
				 <p class=" hidden-md hidden-lg"><a href="" class="col-md-6 col-xs-6">删除</a><a href="" class="col-md-6 col-xs-6">发布</a></p>
			 </dt>
			 <dd class="col-md-11 col-xs-9">
				 <p class="col-md-5 col-xs-12"><span class="col-md-6 col-xs-12"><font>碧玺</font><font>心形</font><font>NGTC</font></span><span  class="col-md-6 col-xs-12"><font>8.50ct</font><font>1颗</font><font class="fc_001">¥168000</font></span></p>
				 <p class="col-md-5 col-xs-12"><span class="col-xs-12 col-md-6" >宝石：<a href="./game.html">入库</a><a href="">签收</a></span><span  class="col-xs-12 col-md-6 pad_0">成品：<a href="">入库</a><a href="">签收</a></span></p>
				 <p class="col-md-2 hidden-xs hidden-sm"><a href="">删除</a><a href="">发布</a></p>
			 </dd>
		  
		  </dl>
		  <dl class="nr_con col-md-12">
		     <dt class="col-md-1 col-xs-3">
				 <img src="${ctx }/resources/admin/images/cp8.jpg" style="width:100%"/>
				 <p class=" hidden-md hidden-lg"><a href="" class="col-md-6 col-xs-6">删除</a><a href="" class="col-md-6 col-xs-6">发布</a></p>
			 </dt>
			 <dd class="col-md-11 col-xs-9">
				 <p class="col-md-5 col-xs-12"><span class="col-md-6 col-xs-12"><font>碧玺</font><font>心形</font><font>NGTC</font></span><span  class="col-md-6 col-xs-12"><font>8.50ct</font><font>1颗</font><font class="fc_001">¥168000</font></span></p>
				 <p class="col-md-5 col-xs-12"><span class="col-xs-12 col-md-6" >宝石：<a href="./game.html">入库</a><a href="">签收</a></span><span  class="col-xs-12 col-md-6 pad_0">成品：<a href="">入库</a><a href="">签收</a></span></p>
				 <p class="col-md-2 hidden-xs hidden-sm"><a href="">删除</a><a href="">发布</a></p>
			 </dd>
		  
		  </dl>
           <div class="more hidden-md hidden-lg"><p><a href="" >更多</a></p></div>
		  
	  </div>
	
  </div>
</div>
<div class="footer hidden-xs hidden-sm">
    <div class="foot"> 
	   <p><a href="">关于Gemtak</a><font>|</font><a href="">隐私条款</a><font>|</font><a href="">版权声明</a><font>|</font><a href="">质量承诺</a><font>|</font><a href="">加入我们</a><font>|</font><a href="">京ICP备11048465号</a><font>|</font> 恭候致电 010-82830789</p>
	   <p>Copyright © 2016 Gemtak.com All Right Reserved。</p>
	</div>
</div>	
	  
 <script language="Javascript">
  $(function(){
  $(".tit_table table tr").hover(function(){
		$(this).css("background","#eeeeee");
	},function(){
		$(this).css("background","#FFF");
	})
})
 </script>
</body>
</html>