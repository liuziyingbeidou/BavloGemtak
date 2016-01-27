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
	    <div class="tit col-sm-12">		    
		   <div class="tit_game">
		      <h2 class="col-sm-12 col-md-5 "><span>${pagevo['titleEdit'] }</span>GID 2281559</h2>
			  <div class="line col-sm-12 hidden-md hidden-lg"></div>
			  <p class="col-sm-12 col-md-5 "><span>更新:2016-02-09-23 20:11</span><span>已浏览:287次</span></p>
			  <div class="line col-sm-12 hidden-xs hidden-sm"></div>
		   </div>
		   <div class="game_ul">
		       <ul class="col-sm-5">

			       	 <li>
			       	 <select class="form-control input-lg">
			       	 <c:forEach var="bean" items="${listGemType}">
					  <option value="${bean.pKey}">${bean.pValue}</option>
					 </c:forEach>
			       	 </select>
			       	 </li>  
					 <li><select class="form-control input-lg"><option>标准形状 非标规格</option><option></option><option></option><option></option></select></li> 
					 <li><select class="form-control input-lg"><option>圆形</option><option></option><option></option><option></option></select></li> 
				     <li>
						  <div class="li_inp_p0 col-xs-4"><input type="text" class="form-control" placeholder="长"></div>
						  <div class="col-xs-4"><input type="text" class="form-control" placeholder="宽"></div>
						  <div class="li_inp_p0 col-xs-4"><input type="text" class="form-control" placeholder="高"></div>
					</li>
					<li>
					     <div class="li_inp_pl col-xs-6"><select class="form-control input-lg fc_a1"><option>切工  很好</option><option></option><option></option><option></option></select></div>
					     <div class="li_inp_pr col-xs-6"><select class="form-control input-lg fc_a1"><option>净度  VS</option><option></option><option></option><option></option></select></div>
					</li> 
                    <li><div class="li_inp_pl col-xs-6"><input type="text" class="form-control  fc_a2" placeholder="视角"></div>
					     <div class="li_inp_pr col-xs-6"><input type="text" class="form-control  fc_a3" placeholder="平均值"></div>
					</li> 						
					 <li>
					     <div class="li_inp_pl col-xs-6"><select class="form-control input-lg"><option>产地  巴西</option><option></option><option></option><option></option></select></div>
					     <div class="li_inp_pr col-xs-6"><select class="form-control input-lg"><option>处理  heated</option><option></option><option></option><option></option></select></div>
					 </li>
					 <li><textarea class="form-control" rows="5"></textarea><li>					
			   </ul>
			   <ul class="col-sm-1 col-md-2 hidden-xs"></ul>
		       <ul class="mt_0 col-sm-6 col-md-5">
				     <li>
						  <div class="li_inp_p0 col-xs-4"><input type="text" class="form-control fc_a2" placeholder="6.65ct"></div>
						  <div class="col-xs-4"><input type="text" class="form-control" placeholder="库存数 1"></div>
						  <div class="li_inp_p0 col-xs-4"><select class="form-control input-lg"><option>单位</option><option></option><option></option><option></option></select></div>
					</li>
					<li>
					     <div class="li_inp_pl col-xs-6"><input type="text" class="form-control" placeholder="进价 13500"></div>
					     <div class="li_inp_pr col-xs-6"><select class="form-control input-lg"><option>元/ct</option><option></option><option></option><option></option></select></div>
					</li> 
                    <li><div class="li_inp_pl col-xs-6"><input type="text" class="form-control" placeholder="批发价 155000"></div>
					     <div class="li_inp_pr col-xs-6"><select class="form-control input-lg"><option>元/ct</option><option></option><option></option><option></option></select></div>
					</li> 	
                    <li><div class="li_inp_pl col-xs-6"><input type="text" class="form-control" placeholder="零售价 188000"></div>
					     <div class="li_inp_pr col-xs-6"><select class="form-control input-lg"><option>元/ct</option><option></option><option></option><option></option></select></div>
					</li>					
					 <li>
					     <div class="li_inp_pl col-xs-6"><select class="form-control input-lg"><option>证书 GIT</option><option></option><option></option><option></option></select></div>
					     <div class="li_inp_pr col-xs-6"><input type="text" class="form-control" placeholder="编码"></div>
					 </li>
					 <li>
					     <div class="li_inp_pl col-xs-6"><input type="text" class="form-control" placeholder="卖家"></div>
					     <div class="li_inp_pr col-xs-6"><input type="text" class="form-control" placeholder="自编码"></div>
					</li>
					<li><select class="form-control input-lg"><option>货址  惠兴宝石有限公司</option><option></option><option></option><option></option></select></li>  
			         <li>
					     <div class="li_inp_pl col-xs-5">
						   <div class="radio">
								 <label class="li_inp_pl col-xs-12"><input type="radio" name="blankRadio" id="blankRadio1" value="option1" aria-label="...">所有人可见 </label>
								 <label class="li_inp_pl col-xs-12"><input type="radio" name="blankRadio" id="blankRadio2" value="option2" aria-label="...">商家可见 </label>
								 <label class="li_inp_pl col-xs-12"><input type="radio" name="blankRadio" id="blankRadio3" value="option3" aria-label="...">只自己可见 </label>
							</div>
						 </div>
						 <div class=" col-xs-2"><p class="s_xian"></p></div>
					     <div class="li_inp_pr col-xs-5">
						    <p>
							  <button type="button" class="btn btn-col btn-lg btn-block" style="margin-bottom:15px">查看详细页面</button>
							  <button type="button" class="btn btn-col btn-lg btn-block">查看我的宝石</button>
							</p>
						 </div>
					</li>
			   
			   </ul>
		   </div>
	  </div>
	  <div class="line col-sm-12 col-md-12 "></div>
	  <div class="tit tit_bnt col-sm-12 col-md-12">
	     <div class="col-xs-6 col-md-5">
		    <p class=" sc_file col-xs-6 col-md-4"><input type="file" name="file"><button type="button" class="btn btn-col btn-lg btn-block">上传证书</button></p>
			<p class="zhizhao col-xs-2 col-md-4"><img src="${ctx }/resources/admin/images/zhizhao.jpg"  /></p>
			<p class="col-xs-4 col-md-4"><a href="#" class="btn btn-col btn-lg btn-block" role="button">删除</a></p>
		 </div>
		 <div class="col-xs-1 col-md-2"></div>
		 <div class="col-xs-5 col-md-5">
			 <p class="col-xs-6 col-md-5" ><button type="button" class="btn btn-col btn-lg btn-block">退出编辑</button></p>
			 <p class="col-xs-1 col-md-2" ></p>
			 <p class="col-xs-5 col-md-5"><button type="button" class="btn btn-col btn-lg btn-block">保存</button></p>
		 </div>
		 
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