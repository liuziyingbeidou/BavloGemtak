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
    <script type="text/javascript" src="${ctx }/resources/common/js/jquery.min.js"></script>
    <script language="javascript" type="text/javascript" src="${ctx }/resources/admin/js/gem-card.js"></script>
    
	<script type="text/javascript">
	//宝石保存
	$(function(){
		//保存
		$(".btn-save").click(function(){	
			saveOrupdate();
		});
		
		//删除证书
		$(".btn-delete").click(function(){
			deleteCert();
		});
	});
	
		
	  function saveOrupdate(){
		  
		  //宝石类型-隐藏域
		  $(".h-type-cn").val($(".sel-type").find("option:selected").attr("lab-cn"));
		  $(".h-type-en").val($(".sel-type").find("option:selected").attr("lab-en"));
		  
		  //宝石形状 -隐藏域
		  $(".h-shape-cn").val($(".select-shape").find("option:selected").attr("lab-cn"));
		  $(".h-shape-en").val($(".select-shape").find("option:selected").attr("lab-en"));
		  
		  //宝石切工 -隐藏域
		  $(".h-cut-cn").val($(".sel-cut").find("option:selected").attr("lab-cn"));
		  $(".h-cut-en").val($(".sel-cut").find("option:selected").attr("lab-en"));
		  
		  //宝石净度-隐藏域
		  $(".h-clarity-cn").val($(".sel-clarity").find("option:selected").attr("lab-cn"));
		  $(".h-clarity-en").val($(".sel-clarity").find("option:selected").attr("lab-en"));
		  
		  //宝石产地-隐藏域
		  $(".h-origin-cn").val($(".sel-origin").find("option:selected").attr("lab-cn"));
		  $(".h-origin-en").val($(".sel-origin").find("option:selected").attr("lab-en"));
		  
		  //宝石处理 -隐藏域
		  $(".h-treatment-cn").val($(".sel-treatment").find("option:selected").attr("lab-cn"));
		  $(".h-treatment-en").val($(".sel-treatment").find("option:selected").attr("lab-en"));
		  
		  //宝石证书 -隐藏域
		  $(".h-lab-cn").val($(".sel-lab").find("option:selected").attr("lab-cn"));
		  $(".h-lab-en").val($(".sel-lab").find("option:selected").attr("lab-en"));
		  
		  var url = "${ctx}/gemAdmin/saveOrUpdate.do";
		  $.post(url,$('#gemVO').serialize(),function(data){
			  
			  alert("保存成功！");
		  });
		 /*  $.ajax({
			  url:"${ctx}/gemAdmin/saveOrUpdate.do",
			  type:"post",
			  data:$('#gemVO').serialize(),// formid
			  dataType:"",
			  success:function(){
				  alert("保存成功！");
			  },
		      error:function(){
		    	  alert("保存失败!");
		      }
		  }); */
	  }
	  
	  
	//********************上传证书 start*****************
	$(function (){
	 $(".btn-upload").bind("click",function (){
	   upfile();
	 });
	});
	
	function upfile(){
	 var formData = new FormData($("#sgform") [0]);
	 $.ajax({
	   url:"${ctx}/upload/uploadSGFile.do",
	   type:"post",
	   data:formData,
	   async:false,
	   cache:false,
	   contentType:false,
	   processData:false,
	   success:function (data){
	   	 if(data == "false"){
	   	 	alert("上传图片超过5M,请处理后上传！");
	   	 }else{
		   	alert("上传成功！");
		    $(".input-lab_url").val(data);
		    $(".sfile-name").prop("src","${ctx}/cert/"+data);
		    $(".btn-upload").hide();
		    $(".btn-delete").show();
	   	 }
	   }
	 });
	}
	
	//获取当前图片的名字
	 function setFileName(){
   		var index = $("#sfile").val().lastIndexOf('\\');
    	var len = $("#sfile").val().length;
    	var name = $("#sfile").val().substring(index+1,len);
	    $(".spic-name").text(name);
	    $(".input-lab_url").val(name);
	    $(".btn-delete").hide();
	    $(".btn-upload").show();
    }
	
	//删除证书
	function deleteCert(){
		var url = "${ctx}/upload/delSGFile.do";
		$.post(url,{fileName:$(".input-lab_url").val()},function(data){
			if(data == "true"){
				$(".input-lab_url").val("");
				$(".sfile-name").prop("src","");
				$(".btn-delete").hide();
			}
		});
	}
	//****************************end********************************
	</script>
	
	<style type="text/css">
		.input-shape{
			display: none;
		}
		.btn-upload{
			display: none;
		}
		.btn-delete{
			display: none;
		}
		.btn-select-cert{
			margin-top: -20;
		}
	</style>
</head>
<body>

<div class="nav col-xs-12">
	<!-- 头部 -->
	<jsp:include page="../head.jsp"></jsp:include>
</div>  
<div class="tit_all">
	<div class="container">
	    <div class="tit col-sm-12">
	       <!-- 表头 -->
		   <div class="tit_game">
		      <h2 class="col-sm-12 col-md-5 "><span>${pagevo['titleEdit'] }</span>GID 2281559</h2>
			  <div class="line col-sm-12 hidden-md hidden-lg"></div>
			  <p class="col-sm-12 col-md-5 "><span>${pagevo['tableModify'] }: 2016-02-09-23 20:11</span><span>${pagevo['tablePageviews'] }: 287 ${pagevo['tablePageviewsTime'] }</span></p>
			  <div class="line col-sm-12 hidden-xs hidden-sm"></div>
		   </div>
		   <!-- Body域 -->
		 <form id="gemVO" >
		  <input type="hidden" name="supplier_id">
		   <div class="game_ul">
		       <ul class="col-sm-5">

			       	 <li>
				       	 <select class="form-control input-lg sel-type" name="type_id">
					       	<c:forEach var="bean" items="${listGemType}">
							  <option value="${bean.pKey}" lab-en="${bean.pValueEN}" lab-cn="${bean.pValueCN}">${bean.pValue}</option>
							</c:forEach>
				       	 </select>
				       	 <input type="hidden" name="type_cn" class="h-type-cn">
				       	 <input type="hidden" name="type_en" class="h-type-en">
			       	 </li>
					 <li>
						 <select class="form-control input-lg select-st" name="isstand">
							 <option value="sst">${pagevo['tableSTSPNCB'] }</option>
							 <option value="cst">${pagevo['tableNSPNCB'] }</option>
						 </select>
					 </li> 
					 <li>
						 <select class="form-control input-lg select-shape " name="shape_id">
							 <c:forEach var="bean" items="${listGemShape}">
							  <option value="${bean.pKey}" lab-en="${bean.pValueEN}" lab-cn="${bean.pValueCN}">${bean.pValue}</option>
							 </c:forEach>
						 </select>
						 <input type="hidden" name="shape_cn" class="h-shape-cn">
						 <input type="hidden" name="shape_en" class="h-shape-en">
					 <input name="shape_str" type="text" class="form-control input-shape" placeholder="${pagevo['tableGemShape'] }">
					 </li> 
				     <li>
						  <div class="li_inp_p0 col-xs-4"><input type="text" name="size_l" class="form-control" placeholder="${pagevo['tableGemCalibratedL'] }"></div>
						  <div class="col-xs-4"><input type="text" name="size_w" class="form-control" placeholder="${pagevo['tableGemCalibratedW'] }"></div>
						  <div class="li_inp_p0 col-xs-4"><input type="text" name="size_h" class="form-control" placeholder="${pagevo['tableGemCalibratedH'] }"></div>
					</li>
					<li>
					     <div class="li_inp_pl col-xs-6">
					      <select class="form-control input-lg sel-cut" name="cut_id">
					       <c:forEach var="bean" items="${listGemCut}">
						     <option value="${bean.pKey}" lab-en="${bean.pValueEN}" lab-cn="${bean.pValueCN}">${pagevo['tableGemCut'] } ${bean.pValue}</option>
						   </c:forEach>
					     </select>
					      <input type="hidden" name="cut_cn" class="h-cut-cn">
					      <input type="hidden" name="cut_en" class="h-cut-en">
					     </div>
					     <div class="li_inp_pr col-xs-6">
					      <select class="form-control input-lg sel-clarity" name="clarity_id">
					        <c:forEach var="bean" items="${listGemClarity}">
						      <option value="${bean.pKey}" lab-en="${bean.pValueEN}" lab-cn="${bean.pValueCN}" >${pagevo['tableGemClarity'] } ${bean.pValue}</option>
						    </c:forEach>
					      </select>
					      <input type="hidden" name="clarity_cn" class="h-clarity-cn">
					      <input type="hidden" name="clarity_en" class="h-clarity-en">
					     </div>
					</li> 
                    <li>
                         <div class="li_inp_pl col-xs-6"><input type="text" name="viewpoint" class="form-control  fc_a2" placeholder="${pagevo['tableViewpoint'] }"></div>
					     <div class="li_inp_pr col-xs-6"><input type="text" name="average_color" class="form-control  fc_a3" placeholder="${pagevo['tableAverageColor'] }"></div>
					</li> 						
					<li>
					     <div class="li_inp_pl col-xs-6">
					       <select class="form-control input-lg sel-origin" name="origin_id">
					         <c:forEach var="bean" items="${listGemOrigin}">
						       <option value="${bean.pKey}" lab-en="${bean.pValueEN}" lab-cn="${bean.pValueCN}">${pagevo['tableOrigin'] } ${bean.pValue}</option>
						     </c:forEach>
					       </select>
					       <input type="hidden" name="origin_cn" class="h-origin-cn">
					       <input type="hidden" name="origin_en" class="h-origin-en">
					     </div>
					     <div class="li_inp_pr col-xs-6">
						     <select class="form-control input-lg sel-treatment" name="treatment_id">
						      <c:forEach var="bean" items="${listGemTreatment}">
							  <option value="${bean.pKey}" lab-en="${bean.pValueEN}" lab-cn="${bean.pValueCN}">${pagevo['tableTreatment'] } ${bean.pValue}</option>
							  </c:forEach>
						     </select>
						     <input type="hidden" name="treatment_cn" class="h-treatment-cn">
					         <input type="hidden" name="treatment_en" class="h-treatment-en">
					     </div>
					 </li>
					 <li><textarea name="vmemo" class="form-control" rows="5"></textarea><li>					
			   </ul>
			   <ul class="col-sm-1 col-md-2 hidden-xs"></ul>
		       <ul class="mt_0 col-sm-6 col-md-5">
				     <li>
						  <div class="li_inp_p0 col-xs-4"><input type="text" name="weight" class="form-control fc_a2" placeholder="6.65ct"></div>
						  <div class="col-xs-4"><input type="text" name="stock_qty" class="form-control" placeholder="${pagevo['tableStockQty'] }"></div>
						  <div class="li_inp_p0 col-xs-4">
						  <select class="form-control input-lg" name="pairs">
							  <option value="sl">${pagevo['tablePairsSL'] }</option>
							  <option value="ml">${pagevo['tablePairsML'] }</option>
							  <option value="pl">${pagevo['tablePairsPL'] }</option>
						  </select>
						  </div>
					</li>
					<li>
					     <div class="li_inp_pl col-xs-6"><input type="text" name="purchase_price" class="form-control" placeholder="${pagevo['tablePurchasePrice'] }"></div>
					     <div class="li_inp_pr col-xs-6">
					     <select class="form-control input-lg" name="purchase_unit">
					      <option value="gl">${pagevo['tablePriceUnitGL'] }</option>
						  <option value="ct">${pagevo['tablePriceUnitCT'] }</option>
					     </select>
					     </div>
					</li> 
                    <li><div class="li_inp_pl col-xs-6"><input type="text" name="trade_price" class="form-control" placeholder="${pagevo['tableTradePrice'] }"></div>
					     <div class="li_inp_pr col-xs-6">
					     <select class="form-control input-lg" name="trade_unit">
					      <option value="gl">${pagevo['tablePriceUnitGL'] }</option>
						  <option value="ct">${pagevo['tablePriceUnitCT'] }</option>
					     </select>
					     </div>
					</li> 	
                    <li><div class="li_inp_pl col-xs-6"><input type="text" name="retail_price" class="form-control" placeholder="${pagevo['tableRetailPrice'] }"></div>
					     <div class="li_inp_pr col-xs-6">
					     <select class="form-control input-lg" name="retail_unit">
					      <option value="gl">${pagevo['tablePriceUnitGL'] }</option>
						  <option value="ct">${pagevo['tablePriceUnitCT'] }</option>
					     </select>
					     </div>
					</li>
					 <li>
					    <div class="li_inp_pl col-xs-6">
						    <select class="form-control input-lg sel-lab" name="lab_id">
						      <c:forEach var="bean" items="${listGemLab}">
							    <option value="${bean.pKey}" lab-en="${bean.pValueEN}" lab-cn="${bean.pValueCN}">${pagevo['tableLabType'] } ${bean.pValue}</option>
							  </c:forEach>
						    </select>
						    <input type="hidden" name="lab_cn" class="h-lab-cn">
					        <input type="hidden" name="lab_en" class="h-lab-en">
					    </div>
					    <div class="li_inp_pr col-xs-6"><input type="text" name="lab_no" class="form-control" placeholder="${pagevo['tableLabNo'] }"></div>
					 </li>
					 <li>
					     <div class="li_inp_pl col-xs-6"><input type="text" name="supplier" class="form-control" placeholder="${pagevo['tableSupplier'] }"></div>
					     <div class="li_inp_pr col-xs-6"><input type="text" name="supplier_code" class="form-control" placeholder="${pagevo['tableSupplierCode'] }"></div>
					</li>
					<li><input type="text" name="location" class="form-control" placeholder="${pagevo['tableLocation'] }"></li>  
			         <li>
					     <div class="li_inp_pl col-xs-5">
							   <div class="radio">
									 <label class="li_inp_pl col-xs-12"><input type="radio" name="power" id="blankRadio1" value="A" aria-label="...">${pagevo['tableAllPower'] } </label>
									 <label class="li_inp_pl col-xs-12"><input type="radio" name="power" id="blankRadio2" value="B" aria-label="...">${pagevo['tableSupplierPower'] } </label>
									 <label class="li_inp_pl col-xs-12"><input type="radio" name="power" id="blankRadio3" value="M" aria-label="...">${pagevo['tableSelfPower'] }</label>
							   </div>
						 </div>
						 <div class=" col-xs-2"><p class="s_xian"></p></div>
					     <div class="li_inp_pr col-xs-5">
						    <p>
							  <button type="button" class="btn btn-col btn-lg btn-block" style="margin-bottom:15px">${pagevo['buttonInfo'] }</button>
							  <button type="button" class="btn btn-col btn-lg btn-block">${pagevo['buttonViewGem'] }</button>
							</p>
						 </div>
					</li>
			   </ul>
		   </div>
	  </div>
	   <input type="hidden" class="input-lab_url" name="lab_url" value="">
	</form>
	<form id="sgform" action="" method="post" enctype="multipart/form-data">
	  <input type="hidden" name="filemodel" id="filemodel" value="cert">
	  <input type="hidden" name="filetype" id="filetype" value="pic">	
	  <div class="line col-sm-12 col-md-12 "></div>
	  <!-- 按钮域 -->
	  <div class="tit tit_bnt col-sm-12 col-md-12">
	     <div class="col-xs-6 col-md-5">
		    <p class=" sc_file col-xs-6 col-md-4"><input type="file" onchange="setFileName()" name="sfile" id="sfile">
		    　　　<button type="button" class="btn btn-col btn-lg btn-block btn-select-cert">${pagevo['buttonSelCert'] }</button>
		       <span class="spic-name"></span>
		    </p>
			<p class="zhizhao col-xs-2 col-md-4"><img src="${ctx }/resources/admin/images/zhizhao.jpg" class="sfile-name" /></p>
			<p class="col-xs-4 col-md-4 btn-delete"><a href="javascript:void(0)" class="btn btn-col btn-lg btn-block" role="button">${pagevo['buttonDelete'] }</a></p>
			<p class="col-xs-4 col-md-4 btn-upload"><a href="javascript:void(0)" class="btn btn-col btn-lg btn-block" role="button">${pagevo['buttonCert'] }</a></p>
		 </div>
		 <div class="col-xs-1 col-md-2"></div>
		 <div class="col-xs-5 col-md-5">
			 <p class="col-xs-6 col-md-5" ><button type="button" class="btn btn-col btn-lg btn-block">${pagevo['buttonClose'] }</button></p>
			 <p class="col-xs-1 col-md-2" ></p>
			 <p class="col-xs-5 col-md-5"><button type="button" class="btn btn-col btn-lg btn-block btn-save">${pagevo['buttonSave'] }</button></p>
		 </div>
	  </div>
	</form>
  </div>
</div>
<div class="footer hidden-xs hidden-sm">
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