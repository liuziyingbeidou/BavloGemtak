<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta charset="utf-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<meta name="author" content="bavlo"/>
	<title>彩色宝石、钻石、报价、3D、鉴定、珠宝定制、Gemtak</title>
    <meta content="彩色宝石、钻石、报价、3D、鉴定、珠宝定制、Gemtak" name="keywords"/>
    <meta content="彩色宝石、钻石、报价、3D、鉴定、珠宝定制、Gemtak" name="description"/>

	<link rel="stylesheet" href="${ctx }/resources/client/css/bootstrap.css" />
	<link rel="stylesheet" href="${ctx }/resources/client/css/swiper.css"/>
	<link rel="stylesheet" href="${ctx }/resources/client/css/newfly.css" type="text/css"/>
	<link href="${ctx }/resources/client/css/index.css" rel="stylesheet"/>
	<link rel="stylesheet" href="${ctx }/resources/client/css/files/demo.css" type="text/css"></link>
    <%-- <link rel="stylesheet" href="${ctx }/resources/client/css/files/loaders.css" type="text/css"></link> --%>
	<script type="text/javascript" src="${ctx }/resources/client/js/jquery-1.12.4.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/gemClient.js"></script>

<style type="text/css">
.black_overlay{
display: none;
position: absolute;
top: 0%;
left: 0%;
width: 100%;
height: 100%;
background-color: #DDDDDD;
z-index:1001;
-moz-opacity: 0.8;
opacity:.80;
filter: alpha(opacity=80);
}

.white_content {
position: absolute;
top: 40%;
left: 20%;
width: 55%;
height: 75%;
z-index:1002;
overflow: auto;
}
</style>

<script language=javaScript>

function show_menuone(ID){
   var totalCat=8;
   for(i=1;i<totalCat;i++){
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
   for(i=1;i<totalCat;i++){
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
         
$(window).scroll(function(){
    t = $(document).scrollTop();
    if(t > 20){
        $('#gotop').fadeIn('slow');
    }else{
        $('#gotop').fadeOut('slow');
    }
});

</script>
 <style type="text/css">
.yemianyanchi{
	  /* position:fixed;
	  left:900px;
	  top:500px; */
     text-align: center;
 } 
 
 </style>
 <link  rel="shortcut icon" href="../favicon.ico"/>
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
		  <input class="sear_ch_input input-type-sel" type="text"  placeholder="巴黎之吻"><input class="sear_ch_sub select-type" type="button"  value="">
		</div>
	  </div>
	  <div class="line "></div>
	  <div class="tit_all">	
		  <div class="tab_cont col-xs-12 col-sm-12 " id="contid1" style="displays:none">
		    <div class="swiper-container swiper-container-horizontal swiper1" >
				<div class="swiper-wrapper list_ul2">
					   <div class="swiper-slide"><a class="p_default" id="gemid" vid="a" vn="全部" style="background: url('/gemtak/resources/client/images/game/a.png') top center no-repeat;"></a><span >全部</span></div>
					   <%-- <c:forEach var="bean" items="${listGemType}" varStatus="status">
						  <div class="swiper-slide">
						   <a id="gemid${bean.pKey }" class="p_default type-gem"  vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/game/${bean.pKey }.png') top center no-repeat;"></a>
						  <span>${bean.pValue}</span>
						  </div>
					   </c:forEach> --%>
					   <div class="swiper-slide">
						   <a id="gemid1" class="p_default type-gem"  vn="钻石" vid="1" style="background: url('/gemtak/resources/client/images/game/1.png') top center no-repeat;"></a>
						  <span>钻石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid2" class="p_default type-gem"  vn="红宝石" vid="2" style="background: url('/gemtak/resources/client/images/game/2.png') top center no-repeat;"></a>
						  <span>红宝石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid3" class="p_default type-gem"  vn="蓝宝石" vid="3" style="background: url('/gemtak/resources/client/images/game/3.png') top center no-repeat;"></a>
						  <span>蓝宝石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid4" class="p_default type-gem"  vn="祖母绿" vid="4" style="background: url('/gemtak/resources/client/images/game/4.png') top center no-repeat;"></a>
						  <span>祖母绿</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid5" class="p_default type-gem"  vn="紫晶" vid="5" style="background: url('/gemtak/resources/client/images/game/5.png') top center no-repeat;"></a>
						  <span>紫晶</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid6" class="p_default type-gem"  vn="海蓝宝" vid="6" style="background: url('/gemtak/resources/client/images/game/6.png') top center no-repeat;"></a>
						  <span>海蓝宝</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid7" class="p_default type-gem"  vn="黄晶" vid="7" style="background: url('/gemtak/resources/client/images/game/7.png') top center no-repeat;"></a>
						  <span>黄晶</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid8" class="p_default type-gem"  vn="碧玺" vid="8" style="background: url('/gemtak/resources/client/images/game/8.png') top center no-repeat;"></a>
						  <span>碧玺</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid9" class="p_default type-gem"  vn="柠檬黄" vid="9" style="background: url('/gemtak/resources/client/images/game/9.png') top center no-repeat;"></a>
						  <span>柠檬黄</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid10" class="p_default type-gem"  vn="橄榄石" vid="10" style="background: url('/gemtak/resources/client/images/game/10.png') top center no-repeat;"></a>
						  <span>橄榄石</span>
						 </div>
						 <div class="swiper-slide">
						   <a id="gemid11" class="p_default type-gem"  vn="石榴石" vid="11" style="background: url('/gemtak/resources/client/images/game/11.png') top center no-repeat;"></a>
						  <span>石榴石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid12" class="p_default type-gem"  vn="透辉石" vid="12" style="background: url('/gemtak/resources/client/images/game/12.png') top center no-repeat;"></a>
						  <span>透辉石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid13" class="p_default type-gem"  vn="坦桑石" vid="13" style="background: url('/gemtak/resources/client/images/game/13.png') top center no-repeat;"></a>
						  <span>坦桑石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid14" class="p_default type-gem"  vn="托帕石" vid="14" style="background: url('/gemtak/resources/client/images/game/14.png') top center no-repeat;"></a>
						  <span>托帕石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid16" class="p_default type-gem"  vn="星光红宝石" vid="16" style="background: url('/gemtak/resources/client/images/game/16.png') top center no-repeat;"></a>
						  <span>星光红宝石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid17" class="p_default type-gem"  vn="星光蓝宝石" vid="17" style="background: url('/gemtak/resources/client/images/game/17.png') top center no-repeat;"></a>
						  <span>星光蓝宝石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid19" class="p_default type-gem"  vn="金绿宝石" vid="19" style="background: url('/gemtak/resources/client/images/game/19.png') top center no-repeat;"></a>
						  <span>金绿宝石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid20" class="p_default type-gem"  vn="猫眼" vid="20" style="background: url('/gemtak/resources/client/images/game/20.png') top center no-repeat;"></a>
						  <span>猫眼</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid21" class="p_default type-gem"  vn="摩根石" vid="21" style="background: url('/gemtak/resources/client/images/game/21.png') top center no-repeat;"></a>
						  <span>摩根石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid22" class="p_default type-gem"  vn="绿柱石" vid="22" style="background: url('/gemtak/resources/client/images/game/22.png') top center no-repeat;"></a>
						  <span>绿柱石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid23" class="p_default type-gem"  vn="变石" vid="23" style="background: url('/gemtak/resources/client/images/game/23.png') top center no-repeat;"></a>
						  <span>变石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid24" class="p_default type-gem"  vn="变石猫眼" vid="24" style="background: url('/gemtak/resources/client/images/game/24.png') top center no-repeat;"></a>
						  <span>变石猫眼</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid34" class="p_default type-gem"  vn="锰铝榴石" vid="34" style="background: url('/gemtak/resources/client/images/game/34.png') top center no-repeat;"></a>
						  <span>锰铝榴石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid35" class="p_default type-gem"  vn="沙佛莱石" vid="35" style="background: url('/gemtak/resources/client/images/game/35.png') top center no-repeat;"></a>
						  <span>沙佛莱石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid36" class="p_default type-gem"  vn="翠榴石" vid="36" style="background: url('/gemtak/resources/client/images/game/36.png') top center no-repeat;"></a>
						  <span>翠榴石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid37" class="p_default type-gem"  vn="钙铝榴石" vid="37" style="background: url('/gemtak/resources/client/images/game/37.png') top center no-repeat;"></a>
						  <span>钙铝榴石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid38" class="p_default type-gem"  vn="铁铝榴石" vid="38" style="background: url('/gemtak/resources/client/images/game/38.png') top center no-repeat;"></a>
						  <span>铁铝榴石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid39" class="p_default type-gem"  vn="镁铝榴石" vid="39" style="background: url('/gemtak/resources/client/images/game/39.png') top center no-repeat;"></a>
						  <span>镁铝榴石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid40" class="p_default type-gem"  vn="尖晶石" vid="40" style="background: url('/gemtak/resources/client/images/game/40.png') top center no-repeat;"></a>
						  <span>尖晶石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid41" class="p_default type-gem"  vn="月光石" vid="41" style="background: url('/gemtak/resources/client/images/game/41.png') top center no-repeat;"></a>
						  <span>月光石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid42" class="p_default type-gem"  vn="尖晶石" vid="42" style="background: url('/gemtak/resources/client/images/game/42.png') top center no-repeat;"></a>
						  <span>欧泊</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid43" class="p_default type-gem"  vn="锆石" vid="43" style="background: url('/gemtak/resources/client/images/game/43.png') top center no-repeat;"></a>
						  <span>锆石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid44" class="p_default type-gem"  vn="柱晶石" vid="44" style="background: url('/gemtak/resources/client/images/game/44.png') top center no-repeat;"></a>
						  <span>柱晶石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid45" class="p_default type-gem"  vn="榍石" vid="45" style="background: url('/gemtak/resources/client/images/game/45.png') top center no-repeat;"></a>
						  <span>榍石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid46" class="p_default type-gem"  vn="堇青石" vid="46" style="background: url('/gemtak/resources/client/images/game/46.png') top center no-repeat;"></a>
						  <span>堇青石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid47" class="p_default type-gem"  vn="方柱石" vid="47" style="background: url('/gemtak/resources/client/images/game/47.png') top center no-repeat;"></a>
						  <span>方柱石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid48" class="p_default type-gem"  vn="红柱石" vid="48" style="background: url('/gemtak/resources/client/images/game/48.png') top center no-repeat;"></a>
						  <span>红柱石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid49" class="p_default type-gem"  vn="蓝晶石" vid="49" style="background: url('/gemtak/resources/client/images/game/49.png') top center no-repeat;"></a>
						  <span>蓝晶石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid50" class="p_default type-gem"  vn="长石" vid="50" style="background: url('/gemtak/resources/client/images/game/50.png') top center no-repeat;"></a>
						  <span>长石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid51" class="p_default type-gem"  vn="锂辉石" vid="51" style="background: url('/gemtak/resources/client/images/game/51.png') top center no-repeat;"></a>
						  <span>锂辉石</span>
					   </div>
					    <div class="swiper-slide">
						   <a id="gemid52" class="p_default type-gem"  vn="赛黄晶" vid="52" style="background: url('/gemtak/resources/client/images/game/52.png') top center no-repeat;"></a>
						  <span>赛黄晶</span>
					   </div>
					    <div class="swiper-slide">
						   <a id="gemid53" class="p_default type-gem"  vn="磷灰石" vid="53" style="background: url('/gemtak/resources/client/images/game/53.png') top center no-repeat;"></a>
						  <span>磷灰石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid54" class="p_default type-gem"  vn="太阳石" vid="54" style="background: url('/gemtak/resources/client/images/game/54.png') top center no-repeat;"></a>
						  <span>太阳石</span>
					   </div>
					    <div class="swiper-slide">
						   <a id="gemid55" class="p_default type-gem"  vn="火玛瑙" vid="55" style="background: url('/gemtak/resources/client/images/game/55.png') top center no-repeat;"></a>
						  <span>火玛瑙</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid57" class="p_default type-gem"  vn="钙铁榴石" vid="57" style="background: url('/gemtak/resources/client/images/game/57.png') top center no-repeat;"></a>
						  <span>钙铁榴石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid58" class="p_default type-gem"  vn="葡萄石" vid="58" style="background: url('/gemtak/resources/client/images/game/58.png') top center no-repeat;"></a>
						  <span>葡萄石</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid61" class="p_default type-gem"  vn="粉晶" vid="61" style="background: url('/gemtak/resources/client/images/game/61.png') top center no-repeat;"></a>
						  <span>粉晶</span>
					   </div>
					   <div class="swiper-slide">
						   <a id="gemid63" class="p_default type-gem"  vn="人造锆" vid="63" style="background: url('/gemtak/resources/client/images/game/63.png') top center no-repeat;"></a>
						  <span>人造锆</span>
					   </div>
				</div>
					
             </div>
			 <div class="swiper-button-prev hidden-xs hidden-sm" ></div>
             <div class="swiper-button-next hidden-xs hidden-sm"></div>
		  </div>
		  <div class="tab_cont col-xs-12 col-sm-12" id="contid2" style="displays:none">
			<div class="swiper-container swiper-container-horizontal swiper2" >
				 <div class="swiper-wrapper lt_ul2">
				 	<div class="swiper-slide"><a class="nav_default" id="metalid0" vid="a" vn="全部" style="background: url('/gemtak/resources/client/images/mot/a.png') top center no-repeat;"></a><span>全部</span></div>	
				 	<%-- <c:forEach var="bean" items="${listGemShape}" varStatus="status">
					    <div class="swiper-slide">
					     <a id="metalid${bean.pKey }" class="nav_default  shape-gem" vn="${bean.pValue}" vid="${bean.pKey }" style="background: url('/gemtak/resources/client/images/mot/${bean.pKey }.png') top center no-repeat;"></a>
					     <span>${bean.pValue}</span>
					    </div>
					</c:forEach> --%>
					 <div class="swiper-slide">
					     <a id="metalid4" class="nav_default  shape-gem" vn="圆形" vid="4" style="background: url('/gemtak/resources/client/images/mot/4.png') top center no-repeat;"></a>
					     <span>圆形</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid5" class="nav_default  shape-gem" vn="长方形" vid="5" style="background: url('/gemtak/resources/client/images/mot/5.png') top center no-repeat;"></a>
					     <span>长方形</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid6" class="nav_default  shape-gem" vn="八角形" vid="6" style="background: url('/gemtak/resources/client/images/mot/6.png') top center no-repeat;"></a>
					     <span>八角形</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid7" class="nav_default  shape-gem" vn="心形形" vid="7" style="background: url('/gemtak/resources/client/images/mot/7.png') top center no-repeat;"></a>
					     <span>心形</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid8" class="nav_default  shape-gem" vn="马眼形" vid="8" style="background: url('/gemtak/resources/client/images/mot/8.png') top center no-repeat;"></a>
					     <span>马眼形</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid9" class="nav_default  shape-gem" vn="椭圆形" vid="9" style="background: url('/gemtak/resources/client/images/mot/9.png') top center no-repeat;"></a>
					     <span>椭圆形</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid10" class="nav_default  shape-gem" vn="梨形" vid="10" style="background: url('/gemtak/resources/client/images/mot/10.png') top center no-repeat;"></a>
					     <span>梨形</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid11" class="nav_default  shape-gem" vn="方形" vid="11" style="background: url('/gemtak/resources/client/images/mot/11.png') top center no-repeat;"></a>
					     <span>方形</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid12" class="nav_default  shape-gem" vn="三角形" vid="12" style="background: url('/gemtak/resources/client/images/mot/12.png') top center no-repeat;"></a>
					     <span>三角形</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid13" class="nav_default  shape-gem" vn="圆形" vid="13" style="background: url('/gemtak/resources/client/images/mot/13.png') top center no-repeat;"></a>
					     <span>圆形</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid14" class="nav_default  shape-gem" vn="梨形" vid="14" style="background: url('/gemtak/resources/client/images/mot/14.png') top center no-repeat;"></a>
					     <span>梨形</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid15" class="nav_default  shape-gem" vn="椭圆形" vid="15" style="background: url('/gemtak/resources/client/images/mot/15.png') top center no-repeat;"></a>
					     <span>椭圆形</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid16" class="nav_default  shape-gem" vn="心形" vid="16" style="background: url('/gemtak/resources/client/images/mot/16.png') top center no-repeat;"></a>
					     <span>心形</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid17" class="nav_default  shape-gem" vn="马眼形" vid="17" style="background: url('/gemtak/resources/client/images/mot/17.png') top center no-repeat;"></a>
					     <span>马眼形</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid18" class="nav_default  shape-gem" vn="球形" vid="18" style="background: url('/gemtak/resources/client/images/mot/18.png') top center no-repeat;"></a>
					     <span>球形</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid19" class="nav_default  shape-gem" vn="垫形" vid="19" style="background: url('/gemtak/resources/client/images/mot/19.png') top center no-repeat;"></a>
					     <span>垫形</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid20" class="nav_default  shape-gem" vn="长方形2" vid="20" style="background: url('/gemtak/resources/client/images/mot/20.png') top center no-repeat;"></a>
					     <span>长方形2</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid21" class="nav_default  shape-gem" vn="正方形2" vid="21" style="background: url('/gemtak/resources/client/images/mot/21.png') top center no-repeat;"></a>
					     <span>正方形2</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid22" class="nav_default  shape-gem" vn="三角形2" vid="22" style="background: url('/gemtak/resources/client/images/mot/22.png') top center no-repeat;"></a>
					     <span>三角形2</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid23" class="nav_default  shape-gem" vn="阿斯切" vid="23" style="background: url('/gemtak/resources/client/images/mot/23.png') top center no-repeat;"></a>
					     <span>阿斯切</span>
					  </div>
					  <div class="swiper-slide">
					     <a id="metalid24" class="nav_default  shape-gem" vn="雷帝恩" vid="24" style="background: url('/gemtak/resources/client/images/mot/24.png') top center no-repeat;"></a>
					     <span>雷帝恩</span>
					  </div>
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
      
      <div class="tit_all col-md-12">	  
          <div class="so_item col-md-12 hidden-xs hidden-sm">
          	 <span class="selects-type ms-sel" ms-key=""></span>
		     <span class="selects-shape ms-sel" ms-key=""></span>
		     <span class="selects-weight ms-sel" ></span>
		     <span class="selects-price ms-sel" ></span>
			 <span class="span_item" ><input type="checkbox" class="pairs-sl" name="renamed" value="sl"/>单粒</span>
			 <span class="span_item"><input type="checkbox"  class="pairs-pl" name="renamed" value="pl"/>配对</span>
			 <span class="span_item"><input type="checkbox" class="pairs-ml" name="renamed" value="ml"/>多粒</span>
			 <span class="span_item"><input type="checkbox" class="pairs-h" name="renamed" value="1"/>弧面</span>
			 <span class="span_item"><input type="checkbox" class="pairs-k" name="renamed" value="1"/>刻面</span>
		  </div>
		  
		  
		  
          <div class="cup_nav col-md-12">
		     <ul class="hidden-xs hidden-sm">
			    <li ><a class="a_sel" id="type1"  onclick="javascript:show_menu(1);" href="javascript:void(0);" >结果（Resault <i class="selGemNO"></i>）</a></li>
			    <li><a  id="type2"  onclick="javascript:show_menu(2);" href="javascript:void(0);" >比较（Comparsion 5）</a></li>
			 </ul>
			 <p class="col-xs-12 col-md-4"><b class="visible-xs-inline-block visible-sm-inline-block ">找到&nbsp;<i class="selPhGemNO">${gemNo}</i>&nbsp;颗宝石</b>
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
	          </div> 
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
 <!--弹出层时背景层DIV-->
<div id="fade" class="black_overlay  yemianyanchi">
	<div id="" class="white_content">
	<img src="${ctx }/resources/client/images/load2.gif"  style="text-align: center;"/>
	</div>
</div>

<div class="footer hidden-xs hidden-sm">
    <jsp:include page="../../admin/foot.jsp"></jsp:include>
</div>
<!-- 延迟加载   start  loaders.css-->
		   
<!-- 延迟加载   end -->
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