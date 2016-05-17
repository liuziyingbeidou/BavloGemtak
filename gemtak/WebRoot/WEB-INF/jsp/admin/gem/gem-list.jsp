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
	<link rel="stylesheet" href="${ctx }/resources/common/css/css.page.css" />
	<link href="${ctx }/resources/admin/css/index.css" rel="stylesheet">
	<%-- <script language="javascript" type="text/javascript" src="${ctx }/resources/admin/js/jquery.js"></script> --%>
	<script language="javascript" type="text/javascript" src="${ctx }/resources/common/js/jquery.min.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx }/resources/admin/js/gem-list.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx }/resources/admin/js/gem-common.js"></script>

	<script type="text/javascript">
	 //1.点击发布按钮
	 function updeIs_release(id){
		 var st = $(".btn-rele-"+id+"").attr("ms-state");
		 var url = "/gemtak/gemAdmin/findGemVOByID.do";
		  $.post(url,{id:id,st:st},function(data){
			data = $.parseJSON(data);
		    //根据返回值做相应处理
		    var flg = data.msg;
		    if(flg=="Y"){
		    	alert(data.warName+"成功！");
		    	$(".btn-rele-"+id+"").text(data.btnNm);
		    	$(".btn-rele-"+id+"").attr("ms-state",data.bkst);
		        location.reload();
		    }else{
		    	alert(data.warName+"失败！");
		    	location.reload();
		    }
		  });
		 
	 }
	 
	  //2.点击删除按钮
	  function updeIs_del(id){
		 if(confirm("您确定要删除吗？")){
		  var url = "/gemtak/gemAdmin/updateDrGemById.do";
		  $.post(url,{id:id},function(data){
			
		    //根据返回值做相应处理
		    var back = $.parseJSON(data).mess;
		     if(back=="Y"){
		       alert("删除成功！");
		       location.reload();
		    }else{
		    	alert("删除失败！");
		    	location.reload();
		    }
		  });
	 
	     }
	 }
	 
	 //点击图片跳转宝石修改界面
	 function selGemCard(gemid){
	  window.location.href = "${ctx}/gemAdmin/updateGem.do?gemid="+gemid;
	 }
	 
	 //点击宝石 入库跳转 修改宝石页面
    function updateGemVO(gemid){
      window.location.href = "${ctx}/gemAdmin/updateGem.do?gemid="+gemid;
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
	  <div class="tit ">
	  <!-- 筛选条件 -->
	    <ul class="tit_ul">
	    	<li class="col-sm-3 col-xs-6">
				<select class="form-control input-lg all-gem" name="" onchange="searchResult()">
				 <option value="A">${pagevo['fltAllGem'] }</option>
				 <option value="S">${pagevo['fltStorageGem'] }</option>
				 <option value="E">${pagevo['fltNewGem'] }</option>
				 <option value="Y">${pagevo['fltReleaseGem'] }</option>
				 <option value="C">${pagevo['fltCloseGem'] }</option>
				</select>
			</li>
			<li class="col-sm-3 col-xs-6">
			<!-- 宝石类型 -->
				<select class="form-control input-lg sel-gem-type type-gem" name="type_id" onchange="searchResult()">
				 <option value="-1">${pagevo['fltGemType'] }</option>
				  <c:forEach var="bean" items="${listGemType}">
				   <option value="${bean.pKey}">${bean.pValue}</option>
				  </c:forEach>
				</select>
			</li>
			<li class="col-sm-3 col-xs-6">
			<!-- 宝石形状 -->
			<select class="form-control input-lg shape-gem" name="shape_id" onchange="searchResult()">
			<option value="-1">${pagevo['fltGemShape'] }</option>
			 <c:forEach var="bean" items="${listGemShape}">
			  <option value="${bean.pKey}">${bean.pValue}</option>
			 </c:forEach>
			</select>
			</li>
			<!-- 搜索 -->
			<li class="col-sm-3 col-xs-6"><p><input class="sear_ch_input input-gem" type="text" placeholder="${pagevo['fltGemSearch'] } " value=""><input class="sear_ch_sub" type="button" value="" onclick="searchResult()"></p></li>
		</ul>
	  
	  </div>
	
	  
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
		 <!-- 宝石列表 -后续完善-->
		 <!-- <span class="list-gem"></span> -->
		 <c:forEach items="${gems}" var="gem">
		 <dl class="nr_con col-md-12">
		     <dt class="col-md-1 col-xs-3">
		         <!-- 宝石列表 -后续完善-->
				 <img onclick="selGemCard(${gem.id})" src="${ctx }/resources/1024/hbx/001.jpg" style="width:100%"/>
				 <p class=" hidden-md hidden-lg"><a href="" class="col-md-6 col-xs-6">${pagevo['ltGemDel'] }</a><a href="" class="col-md-6 col-xs-6">${pagevo['ltGemRelease'] }</a></p>
			 </dt>
			 <dd class="col-md-11 col-xs-9">
				 <p class="col-md-5 col-xs-12"><span class="col-md-6 col-xs-12"><font>${gem.type_cn}</font><font>${gem.shape_cn}</font><font>${gem.lab_cn}</font></span><span  class="col-md-6 col-xs-12"><font>${gem.weight}</font><font>${gem.stock_qty}${gem.pairs}</font><font class="fc_001">¥${gem.retail_price}</font></span></p>
				 <p class="col-md-5 col-xs-12">
				   <span class="col-xs-12 col-md-6" >
				      <!-- 宝石 入库、签收 -->
				      ${pagevo['ltTypeGem'] }：<a href="javascript:updateGemVO(${gem.id})">${pagevo['ltStorage'] }</a><a href="">${pagevo['ltSign'] }</a>
				   </span>
				   <span  class="col-xs-12 col-md-6 pad_0">
				      <!-- 产品 -->
				      ${pagevo['ltTypeProduct'] }：<a href="">${pagevo['ltStorage'] }</a><a href="">${pagevo['ltSign'] }</a>
				   </span>
				 </p>
				 <p class="col-md-2 hidden-xs hidden-sm">
				   <a href="javascript:updeIs_del(${gem.id})" class="btn-del-${gem.id}" ms-state="${gem.is_release}">${pagevo['ltGemDel'] }</a>
				   <c:if test="${gem.is_release=='Y'}">
				    <a href="javascript:updeIs_release(${gem.id})" class="btn-rele-${gem.id}" ms-state="${gem.is_release}">${pagevo['ltGemClose'] }</a>
				   </c:if>
				   <c:if test="${gem.is_release=='C'||gem.is_release=='E'}">
				    <a href="javascript:updeIs_release(${gem.id})" class="btn-rele-${gem.id}" ms-state="${gem.is_release}">${pagevo['ltGemRelease'] }</a>
				   </c:if>
				 </p>
			 </dd>
		  </dl>
		  </c:forEach> 
		  <!-- “更多”按钮 -->
          <div class="more hidden-md hidden-lg"><p><a href="" >${pagevo['btnMore'] }</a></p></div>
		  
	  </div>
	  <!-- 分页插件 -->
	  <div class="tcdPageCode"></div>
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
		});
	});
</script>
<!-- 宝石列表中中英文 -->
<input type="hidden" class="btn-del" value="${pagevo['ltGemDel'] }">
<input type="hidden" class="btn-relf" value="${pagevo['ltGemRelease'] }">
<input type="hidden" class="btn-close" value="${pagevo['ltGemClose'] }">
<input type="hidden" class="nm-gem" value="${pagevo['ltTypeGem'] }">
<input type="hidden" class="nm-prod" value="${pagevo['ltTypeProduct'] }">
<input type="hidden" class="cv-insert" value="${pagevo['ltStorage'] }">
<input type="hidden" class="cv-sign" value="${pagevo['ltSign'] }">
<input type="hidden" class="btn-close" value="${pagevo['ltGemClose'] }">
</body>
<script src="${ctx }/resources/common/js/jquery.page.js"></script>
<script type="text/javascript">
	var pg = getParam("dgpage");
	if(pg == undefined){
		pg = 1;
	}
	//设置当前条件
	var allgem =  getParam("allgem");
	 if(allgem != undefined){
		$(".all-gem").val(allgem);
	 }else{
		$(".all-gem").val("A");
	 }
	var gemtype =  getParam("typegem");
	 if(gemtype != undefined){
		$(".type-gem").val(gemtype);
	 }else{
		$(".type-gem").val("-1");
	 }
	 var shapegem =  getParam("shapegem");
	 if(shapegem != undefined){
		$(".shape-gem").val(shapegem);
	 }else{
		$(".shape-gem").val("-1");
	 }  
	 var itgem =  getParam("inputgem");
	 if(itgem != undefined){
		$(".input-gem").val(itgem);
	 }else{
		$(".input-gem").val("");
	 }  
    $(".tcdPageCode").createPage({
        pageCount:"${total}",
        current:pg,
        backFn:function(p){
            //window.location.href="${ctx}/gemAdmin/viewGemList.do?dgpage="+p;
            searchResult(p);
        }
    }); 
    
    //-----------------------条件查询-------------------------
    function searchResult(p){
    	var gemType = $(".type-gem").find("option:selected").val();   //取宝石类型下拉框中的值
    	var gemShape =  $(".shape-gem").find("option:selected").val();//宝石形状下拉框中的值
    	var gemStatus =  $(".all-gem").find("option:selected").val(); //全部产品
    	var gemInput =  $(".input-gem").val();    //搜索框
    	var url = "${ctx}/gemAdmin/viewGemList.do?";
    	if(gemType != null && gemType != ""){     //宝石类型
    		url += "&typegem="+gemType;
    	}
		if(gemShape != null && gemShape != ""){   //宝石形状
    		url += "&shapegem="+gemShape;
    	}
		if(gemStatus != null && gemStatus != ""){  //全部产品
    		url += "&allgem="+gemStatus;
    	}
		if(gemInput != null && gemInput != ""){    //模糊搜索
    		url += "&inputgem="+gemInput;
    	}
    	if(p != undefined && p != null && p != ""){
    		url += "&dgpage="+p;
    	}else{
    		url += "&dgpage=1";
    	}
    	window.location.href= url;
    }
    
    
</script>
</html>