<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="bavlo">
	<title>彩色宝石、钻石、报价、3D、鉴定、珠宝定制</title>
    <meta content="彩色宝石、钻石、报价、3D、鉴定、珠宝定制、gemtak" name="keywords"/>
    <meta content="彩色宝石、钻石、报价、3D、鉴定、珠宝定制、gemtak" name="description"/>

	<link rel="stylesheet" href="${ctx }/resources/client/css/bootstrap.css" />
	<link rel="stylesheet" href="${ctx }/resources/client/css/swiper.css">
	<link rel="stylesheet" href="${ctx }/resources/client/css/newfly.css" type="text/css"/>
	<link href="${ctx }/resources/client/css/index.css" rel="stylesheet">
	
    <link rel="stylesheet" href="${ctx }/resources/client/css/files/loaders.css" type="text/css"></link>
	<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/jquery.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/gemClient.js"></script>
<script language=javaScript>
	 
	function show_menuone(ID){
			 var totalCat=8;
         	 for(i=1;i<totalCat;i++)
         	 {
         	   if(ID!=i){
               $('#typeid'+i).removeClass("pa_sal");
			   $('#typeid'+i).addClass("");
               $('#contid'+i).css({display:"none"});
             }else{
              $('#typeid'+i).addClass("pa_sal");
			  $('#typeid'+i).removeClass("");
              $('#contid'+ID).css({display:"block"});  
         	          
             }
           }
         }	
		 
		 function show_menu(ID){
			 var totalCat=3;
         	 for(i=1;i<totalCat;i++)
         	 {
         	   if(ID!=i){
               $('#type'+i).removeClass("a_sel");
			   $('#type'+i).addClass("");
               $('#cont'+i).css({display:"none"});
             }else{
              $('#type'+i).addClass("a_sel");
			  $('#type'+i).removeClass("");
              $('#cont'+ID).css({display:"block"});  
         	          
             }
           }
         }
         
         
         
         $(function(){
         
           //1.根据类型名称或id模糊查询 
           $(".select-type").click(function(){
            var typeval = $(".input-type-sel").val();
            location.href = "selectClientByType.do?&typegem="+typeval;
           });
           
           //2.按时间排序
           $(".select-createdate").change(function(){
            var switchover = $(".sel-show").val();
            selectClientList(switchover);
           });
           
           //3.横排展示界面
           $(".show-line").click(function(){
            $(".sel-show").val(2);
            selectClientList(2);
           });
           
           //4.宫格展示界面
           $(".show-speed").click(function(){
            $(".sel-show").val(1);
             selectClientList(1);
           });
           
         });
         
         
 
</script>
 <style type="text/css">
 .yemianyanchi{
 	text-align: center;
 }
 </style>
</head>
<body>
<input type="hidden" class="juname" value="${uname }"/>
<div>
   <jsp:include page="../head.jsp"></jsp:include>
</div> 
<div class="tit_all m_bottom_80 conbg">
	<div class="container">
	  <div class="tit  ">
	    <p class="col-sm-12 col-md-8">
			<a href="javascript:void(0);" id="typeid1"  onclick="javascript:show_menuone(1);" class="pa_sal">种类<b class="hidden-xs hidden-sm">Component</b></a>
			<a href="javascript:void(0);" id="typeid2"  onclick="javascript:show_menuone(2);">形状<b class="hidden-xs hidden-sm">Shape</b></a>
			<a href="javascript:void(0);" id="typeid3"  onclick="javascript:show_menuone(3);">重量<b class="hidden-xs hidden-sm">Weight</b></a>
			<a href="javascript:void(0);" id="typeid4"  onclick="javascript:show_menuone(4);">价格<b class="hidden-xs hidden-sm">Price</b></a>
		</p>
		<div class="sou col-md-4 hidden-xs hidden-sm">
		  <input class="sear_ch_input input-type-sel" type="text" value="巴黎之吻"><input class="sear_ch_sub select-type" type="button"  value="">
		</div>
	  </div>
	  <div class="line "></div>
	  <div class="tit_all">	
		  <div class="tab_cont col-xs-12 col-sm-12 " id="contid1" style="displays:none">
		    <div class="swiper-container swiper-container-horizontal swiper1" >
				<div class="swiper-wrapper list_ul2">
					   <div class="swiper-slide">
					   <a class="p_default " id="gemid" vid="a" vn="全部" style="background: url('/gemtak/resources/client/images/game/g0.png') top center no-repeat;"></a><span >全部</span></div>
					   <c:forEach var="bean" items="${listGemType}" varStatus="status">
						  <div class="swiper-slide">
						  <c:if test="${bean.pKey==3}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/3.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==2}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/2.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==5}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/5.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==6}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/6.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==7}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/7.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==8}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/8.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==10}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/10.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==11}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/11.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==12}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/12.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==13}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/13.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==14}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/43.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==23}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/341.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==34}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/346.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==36}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/396.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==40}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/676.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==43}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/878.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==44}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/1317.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==46}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/795.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==58}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/36.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==61}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/40.png') top center no-repeat;"></a>
						  </c:if>
						  <c:if test="${bean.pKey==63}">
						   <a id="gemid${status.index+1}" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/46.png') top center no-repeat;"></a>
						  </c:if>
						  <span>${bean.pValue}</span>
						  </div>
					   </c:forEach>
				</div>
					
             </div>
			 <div class="swiper-button-prev hidden-xs hidden-sm" ></div>
             <div class="swiper-button-next hidden-xs hidden-sm"></div>
		  </div>
		  <div class="tab_cont col-xs-12 col-sm-12" id="contid2" style="displays:none">
			<div class="swiper-container swiper-container-horizontal swiper2" >
				 <div class="swiper-wrapper lt_ul2">
				 	<div class="swiper-slide"><a class="nav_default" id="metalid0" vid="a" vn="全部" style="background: url('/gemtak/resources/client/images/mot/a1.png') top center no-repeat;"></a><span>全部</span></div>	
				 	<c:forEach var="bean" items="${listGemShape}" varStatus="status">
					  <div class="swiper-slide"><a id="metalid${status.index+1}" class="nav_default  shape-gem" vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/mot/Round.png') top center no-repeat;"></a>
					  <span>${bean.pValue}</span></div>
					</c:forEach>
                 </div>
			</div> 
			<div id="btn1"  class="hidden-xs hidden-sm swiper-button-prev2"></div>
			<div id="btn2" class="hidden-xs hidden-sm swiper-button-next2"></div>
			</div>
			<div class="tab_cont " id="contid3" style="display:none">
			      <div class="wpxz">
					  <label>重量范围（ct）</label><input class="inp_s from-weight" type="text" >-&nbsp;<input class="inp_s to-weight" type="text" ><input class="inp_z btn-weight" type="submit" value="搜索" >
				  </div>
			</div>
			<div class="tab_cont " id="contid4" style="display:none">
			      <div class="wpxz">
					  <label>价格范围（元）</label><input class="inp_s from-price" type="text" >-&nbsp;<input class="inp_s to-price" type="text" ><input class="inp_z btn-price" type="submit" value="搜索" >
				  </div>
			</div>
	  </div>
      <div class="line "></div>
      <div class="loader yemianyanchi" style="display: none;">
        <div class="loader-inner ball-pulse-rise">
          <div></div>
          <div></div>
          <div></div>
          <div></div>
          <div></div>
        </div>
	  </div>
      <div class="tit_all col-md-12">	  
          <div class="so_item col-md-12 hidden-xs hidden-sm">
          	 <span class="selects-type ms-sel" ms-key=""></span>
		     <span class="selects-shape ms-sel" ms-key=""></span>
		     <span class="selects-weight ms-sel" ></span>
		     <span class="selects-price ms-sel" ></span>
			 <span class="span_item" ><input type="checkbox" class="pairs-sl" name="renamed" value="sl">单粒</span>
			 <span class="span_item"><input type="checkbox"  class="pairs-pl" name="renamed" value="pl">配对</span>
			 <span class="span_item"><input type="checkbox" class="pairs-ml" name="renamed" value="ml">多粒</span>
			 <span class="span_item"><input type="checkbox" class="pairs-h" name="renamed" value="1">弧面</span>
			 <span class="span_item"><input type="checkbox" class="pairs-k" name="renamed" value="1">刻面</span>
		  </div>
          <div class="cup_nav col-md-12">
		     <ul class="hidden-xs hidden-sm">
			    <li><a class="a_sel" id="type1"  onclick="javascript:show_menu(1);" href="javascript:void(0);" >结果（Resault 166）</a></li>
			    <li><a  id="type2"  onclick="javascript:show_menu(2);" href="javascript:void(0);" >比较（Comparsion 5）</a></li>
			 </ul>
			 <p class="col-xs-12 col-md-4"><b class="visible-xs-inline-block visible-sm-inline-block ">找到266颗宝石</b>
			    <select class="select-createdate">
						<option value="-1">按上架时间</option>
						<option value="htol">高到低</option>
						<option value="ltoh">低到高</option>
				</select>
				<span class="hidden-xs hidden-sm">
				 <a href="#" class="show-line"><image src="${ctx }/resources/client/images/tu1.png" /></a>
				 <a href="#" class="show-speed"><image src="${ctx }/resources/client/images/tu2.png" /></a>
				 <input type="hidden" class="sel-show" value="1"/>
				</span>
			</p>
		  
		  </div>
		  <div class="appendClientList">
	          <%-- <div class="job_xq col-md-12 "  id="cont1">
			      <ul class="">
			      <c:forEach items="${gems}" var="gem">		
				    <li class="col-md-3 col-xs-6">
					  <span><a class="select-detaile"><image src="${ctx }/resources/client/images/cp1.png" /></a></span>
					  <h6><b>${gem.type_cn}<font class="hidden-xs hidden-sm">（${gem.type_en}）</font></b><i>¥${gem.retail_price}</i></h6>
					  <p><b>${gem.weight} ${gem.clarity_en} ${gem.cut_en}</b><i><image src="${ctx }/resources/client/images/tu3.png" /></i></p>
					</li>
					</c:forEach>
				  </ul>
			      <div class="jzgd hidden-md hidden-lg" ><a href="">更多</a></div>
	          </div> --%>
          </div>
		  <%-- <div class="job_xq  col-md-12"  id="cont2" style="display:none">
		      <ul>
			    <li class="col-md-3 col-xs-6">		
				  <span><a href="./detail.html"><image src="${ctx }/resources/client/images/cp2.jpg" /></a></span>
				  <h6><b>${gem.type_cn}<font class="hidden-xs hidden-sm">（${gem.type_en}）<font></b><i>¥${gem.retail_price}</i></h6>
				  <p><b>${gem.weight} ${gem.clarity_en} ${gem.cut_en}</b><i><image src="${ctx }/resources/client/images/tu3.png" /></i></p>
				</li>
			  </ul>
          </div> --%>
	  </div>
	</div>
</div>
<div class="footer hidden-xs hidden-sm">
    <jsp:include page="../../admin/foot.jsp"></jsp:include>
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

<!-- Swiper JS -->
    <script src="${ctx }/resources/client/js/swiper.js"></script>
 <script language="Javascript">
  $(function(){
  $(".appendClientList .tit_table table tr").on("hover",function(){
		$(this).css("background","#eeeeee");
	},function(){
		$(this).css("background","#FFF");
	});
	
});
</script>
    <!-- Initialize Swiper -->
   
	  <script>
     var swiper = new Swiper('.swiper1', {

		prevButton:'.swiper-button-prev',
        nextButton:'.swiper-button-next',
        paginationClickable: true,
        slidesPerView: 'auto',
        spaceBetween: 0
    });
	 
    var swiper2 = new Swiper('.swiper2', {
		
        paginationClickable: true,
        slidesPerView: 'auto',
        spaceBetween: 0
    });
    $('#btn1').click(function(){
	 	swiper2.slidePrev();
	})
	$('#btn2').click(function(){
		swiper2.slideNext();
	})
	show_menuone(1);
    </script>

</body>
</html>