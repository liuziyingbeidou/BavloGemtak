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
<title>Gemtak</title>
<link rel="stylesheet" href="${ctx }/resources/admin/css/bootstrap.css" />

<link href="${ctx }/resources/admin/css/index.css" rel="stylesheet">
<script language="javascript" type="text/javascript" src="${ctx }/resources/admin/js/jquery.js"></script>



<link rel="stylesheet" href="${ctx }WebRoot/resources/common/pagination/pagination.css" />
<style type="text/css">
body{font-size:84%; color:#333333; line-height:1.4;}
a{color:#34538b;}
#Searchresult{width:300px; height:100px; padding:20px; background:#f0f3f9;}
</style>
<script type="text/javascript" src="${ctx }WebRoot/resources/common/pagination/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }WebRoot/resources/common/pagination/jquery.pagination.js"></script>
<script type="text/javascript">
$(function(){
	//此demo通过Ajax加载分页元素
	var initPagination = function() {
		var num_entries = $("#hiddenresult div.result").length;
		// 创建分页
		$("#Pagination").pagination(num_entries, {
			num_edge_entries: 1, //边缘页数
			num_display_entries: 4, //主体页数
			callback: pageselectCallback,
			items_per_page: 1, //每页显示1项
			prev_text: "前一页",
			next_text: "后一页"
		});
	 };
	 
	function pageselectCallback(page_index, jq){
		var new_content = $("#hiddenresult div.result:eq("+page_index+")").clone();
		$("#Searchresult").empty().append(new_content); //装载对应分页的内容
		return false;
	}
	//ajax加载
	$("#hiddenresult").load("load.html", null, initPagination);
});
</script>



<script type="text/javascript">
 function updeIs_release(id){
	 location.href = "${ctx}/gemAdmin/findGemVOByID.do&id=+"id;
	  alert(id);
	 
 }

</script>
</head>
<body>

<div class="nav col-xs-12">
	 <!-- 头部 -->
     <jsp:include page="../head.jsp"></jsp:include>
</div>  
<div class="tit_all">
	<div class="container">
	  <!-- 条件 -->
	  <!--<div class="tit tit_p">	  
			<a href="javascript:void(0);" id="typeid1"  onmouseover="javascript:show_menuone(1);">${pagevo['fltAllGem'] } </a>
			<a href="javascript:void(0);" id="typeid2"  onmouseover="javascript:show_menuone(2);">${pagevo['fltStorageGem'] }</a>
			<a href="javascript:void(0);" id="typeid3"  onmouseover="javascript:show_menuone(3);">${pagevo['fltSignGem'] }</a>
			<a href="javascript:void(0);" id="typeid4"  onmouseover="javascript:show_menuone(4);">${pagevo['fltNewGem'] }</a>
		  <span class="fbgb">
			<a href="javascript:void(0);" id="typeid5"  onmouseover="javascript:show_menuone(5);">${pagevo['fltReleaseGem'] }</a>
			<a href="javascript:void(0);" id="typeid6"  onmouseover="javascript:show_menuone(6);">${pagevo['fltCloseGem'] }</a>
		  </span>
	  </div>-->
	 <form action="" method="post">
	  <div class="tit ">
	  <!-- 筛选条件 -->
	    <ul class="tit_ul">
	    	<li class="col-sm-3 col-xs-6">
				<select class="form-control input-lg" name="">
				 <option value="A">${pagevo['fltAllGem'] }</option>
				 <option value="S">${pagevo['fltStorageGem'] }</option>
				 <option value="E">${pagevo['fltNewGem'] }</option>
				 <option value="Y">${pagevo['fltReleaseGem'] }</option>
				 <option value="C">${pagevo['fltCloseGem'] }</option>
				</select>
			</li>
			<li class="col-sm-3 col-xs-6">
			<!-- 宝石类型 -->
			<select class="form-control input-lg" name="type_id">
			<option value="-1">${pagevo['fltGemType'] }</option>
			 <c:forEach var="bean" items="${listGemType}">
			  <option value="${bean.pKey}">${bean.pValue}</option>
			 </c:forEach>
			</select>
			</li>
			<li class="col-sm-3 col-xs-6">
			<!-- 宝石形状 -->
			<select class="form-control input-lg" name="shape_id">
			<option value="-1">${pagevo['fltGemShape'] }</option>
			 <c:forEach var="bean" items="${listGemShape}">
			  <option value="${bean.pKey}">${bean.pValue}</option>
			 </c:forEach>
			</select>
			</li>
			<!-- 搜索 -->
			<li class="col-sm-3 col-xs-6"><p><input class="sear_ch_input" type="text" placeholder="${pagevo['fltGemSearch'] }" value=""><input class="sear_ch_sub" type="submit" value=""></p></li>
		</ul>
	  
	  </div>
	 </form>
	  
	  <div class="tit_table col-md-12 ">
	  	 <!-- 菜单标题 -->
		 <div class="nr_tit">
			 <p class="col-md-1 col-xs-3" style="text-align:center">${pagevo['tlGemPic'] }</p>
			 <p class="col-md-11 col-xs-9">
				 <span class="col-md-5 hidden-xs hidden-sm" style="text-align:center">${pagevo['tlGemInfo'] }</span>
				 <span class="col-md-5 hidden-xs hidden-sm">${pagevo['tlGemEditOption'] }</span>
				 <span class="col-md-2 hidden-xs hidden-sm">${pagevo['tlGemOperation'] }</span>
				 <span class="col-xs-12 hidden-md hidden-lg" style="text-align:center">${pagevo['tlGemInfoAndOpr'] }</span>
			</p>
		 </div>  
		 <!-- 宝石列表 -->
		 <c:forEach items="${gems}" var="gem">
		 <dl class="nr_con col-md-12">
		   
		     <dt class="col-md-1 col-xs-3">
				 <img src="${ctx }/resources/admin/images/cp8.jpg" style="width:100%"/>
				 <p class=" hidden-md hidden-lg"><a href="" class="col-md-6 col-xs-6">${pagevo['ltGemDel'] }</a><a href="" class="col-md-6 col-xs-6">${pagevo['ltGemRelease'] }</a></p>
			 </dt>
			 <dd class="col-md-11 col-xs-9">
			   
				 <p class="col-md-5 col-xs-12"><span class="col-md-6 col-xs-12"><font>${gem.type_cn}</font><font>${gem.shape_cn}</font><font>${gem.lab_cn}</font></span><span  class="col-md-6 col-xs-12"><font>${gem.weight}</font><font>${gem.stock_qty}${gem.pairs}</font><font class="fc_001">¥${gem.purchase_price}</font></span></p>
				 <p class="col-md-5 col-xs-12"><span class="col-xs-12 col-md-6" >${pagevo['ltTypeGem'] }：<a href="./game.html">${pagevo['ltStorage'] }</a><a href="">${pagevo['ltSign'] }</a></span><span  class="col-xs-12 col-md-6 pad_0">${pagevo['ltTypeProduct'] }：<a href="">${pagevo['ltStorage'] }</a><a href="">${pagevo['ltSign'] }</a></span></p>
				 <p class="col-md-2 hidden-xs hidden-sm">
				   <a href="javascript:del()">${pagevo['ltGemDel'] }</a>
				   <a href="javascript:updeIs_release(${gem.supplier_id})">${pagevo['ltGemRelease'] }</a>
				 </p>
			  
			 </dd>
		    
		  </dl>
		  </c:forEach>
		  <!-- “更多”按钮 -->
          <div class="more hidden-md hidden-lg"><p><a href="" >${pagevo['btnMore'] }</a></p></div>
		  
	  </div>
	
  </div>
</div>
<div class="footer hidden-xs hidden-sm">
	<!-- 尾部 -->
    <jsp:include page="../foot.jsp"></jsp:include>
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