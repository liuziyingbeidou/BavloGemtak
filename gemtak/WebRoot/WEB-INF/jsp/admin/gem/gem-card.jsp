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
<script language="javascript" type="text/javascript" src="${ctx }/resources/admin/js/gem-card.js"></script>
<script type="text/javascript">

</script>

<style type="text/css">
.input-shape{
	display: none;
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
		   <div class="game_ul">
		       <ul class="col-sm-5">

			       	 <li>
			       	 <select class="form-control input-lg">
			       	 <c:forEach var="bean" items="${listGemType}">
					  <option value="${bean.pKey}">${bean.pValue}</option>
					 </c:forEach>
			       	 </select>
			       	 </li>
					 <li>
					 <select class="form-control input-lg select-st">
					 <option value="sst">${pagevo['tableSTSPNCB'] }</option>
					 <option value="cst">${pagevo['tableNSPNCB'] }</option>
					 </select>
					 </li> 
					 <li>
					 <select class="form-control input-lg select-shape">
					 <c:forEach var="bean" items="${listGemShape}">
					  <option value="${bean.pKey}">${bean.pValue}</option>
					 </c:forEach>
					 </select>
					 <input name="shape_str" type="text" class="form-control input-shape" placeholder="${pagevo['tableGemShape'] }">
					 </li> 
				     <li>
						  <div class="li_inp_p0 col-xs-4"><input type="text" class="form-control" placeholder="${pagevo['tableGemCalibratedL'] }"></div>
						  <div class="col-xs-4"><input type="text" class="form-control" placeholder="${pagevo['tableGemCalibratedW'] }"></div>
						  <div class="li_inp_p0 col-xs-4"><input type="text" class="form-control" placeholder="${pagevo['tableGemCalibratedH'] }"></div>
					</li>
					<li>
					     <div class="li_inp_pl col-xs-6">
					     <select class="form-control input-lg">
					     <c:forEach var="bean" items="${listGemCut}">
						  <option value="${bean.pKey}">${pagevo['tableGemCut'] } ${bean.pValue}</option>
						 </c:forEach>
					     </select>
					     </div>
					     <div class="li_inp_pr col-xs-6">
					     <select class="form-control input-lg">
					      <c:forEach var="bean" items="${listGemClarity}">
						  <option value="${bean.pKey}">${pagevo['tableGemClarity'] } ${bean.pValue}</option>
						  </c:forEach>
					     </select>
					     </div>
					</li> 
                    <li><div class="li_inp_pl col-xs-6"><input type="text" class="form-control  fc_a2" placeholder="${pagevo['tableViewpoint'] }"></div>
					     <div class="li_inp_pr col-xs-6"><input type="text" class="form-control  fc_a3" placeholder="${pagevo['tableAverageColor'] }"></div>
					</li> 						
					 <li>
					     <div class="li_inp_pl col-xs-6">
					     <select class="form-control input-lg">
					      <c:forEach var="bean" items="${listGemOrigin}">
						  <option value="${bean.pKey}">${pagevo['tableOrigin'] } ${bean.pValue}</option>
						  </c:forEach>
					     </select>
					     </div>
					     <div class="li_inp_pr col-xs-6">
					     <select class="form-control input-lg">
					      <c:forEach var="bean" items="${listGemTreatment}">
						  <option value="${bean.pKey}">${pagevo['tableTreatment'] } ${bean.pValue}</option>
						  </c:forEach>
					     </select>
					     </div>
					 </li>
					 <li><textarea class="form-control" rows="5"></textarea><li>					
			   </ul>
			   <ul class="col-sm-1 col-md-2 hidden-xs"></ul>
		       <ul class="mt_0 col-sm-6 col-md-5">
				     <li>
						  <div class="li_inp_p0 col-xs-4"><input type="text" class="form-control fc_a2" placeholder="6.65ct"></div>
						  <div class="col-xs-4"><input type="text" class="form-control" placeholder="${pagevo['tableStockQty'] }"></div>
						  <div class="li_inp_p0 col-xs-4">
						  <select class="form-control input-lg">
						  <option value="sl">${pagevo['tablePairsSL'] }</option>
						  <option value="ml">${pagevo['tablePairsML'] }</option>
						  <option value="pl">${pagevo['tablePairsPL'] }</option>
						  </select>
						  </div>
					</li>
					<li>
					     <div class="li_inp_pl col-xs-6"><input type="text" class="form-control" placeholder="${pagevo['tablePurchasePrice'] }"></div>
					     <div class="li_inp_pr col-xs-6">
					     <select class="form-control input-lg">
					      <option value="gl">${pagevo['tablePriceUnitGL'] }</option>
						  <option value="ct">${pagevo['tablePriceUnitCT'] }</option>
					     </select>
					     </div>
					</li> 
                    <li><div class="li_inp_pl col-xs-6"><input type="text" class="form-control" placeholder="${pagevo['tableTradePrice'] }"></div>
					     <div class="li_inp_pr col-xs-6">
					     <select class="form-control input-lg">
					      <option value="gl">${pagevo['tablePriceUnitGL'] }</option>
						  <option value="ct">${pagevo['tablePriceUnitCT'] }</option>
					     </select>
					     </div>
					</li> 	
                    <li><div class="li_inp_pl col-xs-6"><input type="text" class="form-control" placeholder="${pagevo['tableRetailPrice'] }"></div>
					     <div class="li_inp_pr col-xs-6">
					     <select class="form-control input-lg">
					      <option value="gl">${pagevo['tablePriceUnitGL'] }</option>
						  <option value="ct">${pagevo['tablePriceUnitCT'] }</option>
					     </select>
					     </div>
					</li>
					 <li>
					     <div class="li_inp_pl col-xs-6">
					     <select class="form-control input-lg">
					      <c:forEach var="bean" items="${listGemLab}">
						  <option value="${bean.pKey}">${pagevo['tableLabType'] } ${bean.pValue}</option>
						  </c:forEach>
					     </select>
					     </div>
					     <div class="li_inp_pr col-xs-6"><input type="text" class="form-control" placeholder="${pagevo['tableLabNo'] }"></div>
					 </li>
					 <li>
					     <div class="li_inp_pl col-xs-6"><input type="text" class="form-control" placeholder="${pagevo['tableSupplier'] }"></div>
					     <div class="li_inp_pr col-xs-6"><input type="text" class="form-control" placeholder="${pagevo['tableSupplierCode'] }"></div>
					</li>
					<li><input type="text" class="form-control" placeholder="${pagevo['tableLocation'] }"></li>  
			         <li>
					     <div class="li_inp_pl col-xs-5">
						   <div class="radio">
								 <label class="li_inp_pl col-xs-12"><input type="radio" name="blankRadio" id="blankRadio1" value="option1" aria-label="...">${pagevo['tableAllPower'] } </label>
								 <label class="li_inp_pl col-xs-12"><input type="radio" name="blankRadio" id="blankRadio2" value="option2" aria-label="...">${pagevo['tableSupplierPower'] } </label>
								 <label class="li_inp_pl col-xs-12"><input type="radio" name="blankRadio" id="blankRadio3" value="option3" aria-label="...">${pagevo['tableSelfPower'] }</label>
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
	  <div class="line col-sm-12 col-md-12 "></div>
	  <!-- 按钮域 -->
	  <div class="tit tit_bnt col-sm-12 col-md-12">
	     <div class="col-xs-6 col-md-5">
		    <p class=" sc_file col-xs-6 col-md-4"><input type="file" name="file"><button type="button" class="btn btn-col btn-lg btn-block">${pagevo['buttonCert'] }</button></p>
			<p class="zhizhao col-xs-2 col-md-4"><img src="${ctx }/resources/admin/images/zhizhao.jpg"  /></p>
			<p class="col-xs-4 col-md-4"><a href="#" class="btn btn-col btn-lg btn-block" role="button">${pagevo['buttonDelete'] }</a></p>
		 </div>
		 <div class="col-xs-1 col-md-2"></div>
		 <div class="col-xs-5 col-md-5">
			 <p class="col-xs-6 col-md-5" ><button type="button" class="btn btn-col btn-lg btn-block">${pagevo['buttonClose'] }</button></p>
			 <p class="col-xs-1 col-md-2" ></p>
			 <p class="col-xs-5 col-md-5"><button type="button" class="btn btn-col btn-lg btn-block">${pagevo['buttonSave'] }</button></p>
		 </div>
	  </div>
	
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