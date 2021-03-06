<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="TotalCartPices" value="0" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<meta name="description" content="bavlo"/>
<meta name="keywords" content="bavlo"/>
<meta name="author" content="bavlo"/>
<title>彩色宝石、钻石、报价、3D、鉴定、珠宝定制、Gemtak</title>
<link rel="stylesheet" href="${ctx}/resources/client/css/bootstrap.css" />
<link rel="stylesheet" href="${ctx }/resources/client/css/layer.css" type="text/css"></link>
<link href="${ctx}/resources/client/css/index.css" rel="stylesheet"/>
<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/jquery.js"></script>
<script type="text/javascript" src="${ctx }/resources/client/js/layer.js"></script>
<script>
$(function(){
 getCarNum();
 
 $(".qjz").click(function(){
     var url = "/gemtak/gemClient/checkGemShoppingCar.do";
	 $.post(url,function(data){
	  if(data == "N"){
	    /* layer.alert('您的购物车还没有宝贝哟！', {
		  skin: 'layui-layer-molv' //样式类名
		  ,closeBtn: 0
		}, function(){
		  layer.alert('赶快去逛逛吧！', {
		    skin: 'layui-layer-lan'
		    ,closeBtn: 0
		    ,shift: 4 //动画类型
		  });
		}); */
		layer.alert('您的购物车空空如也，请先去购物吧！', {
	       title:'gemtak 提示:',
	       icon: 1,
	       skin: 'layui-layer-molv'
	   });
	  }else if(data == "Y"){
	   location.href = "/gemtak/gemClient/order.do";
	  }
	 });
 });
});
 //删除购物车中 选中的商品
function delShoppCar(id){
  layer.confirm('确定要删除吗?', function(){
    var url = "/gemtak/gemClient/delShoppingCar.do";
    $.post(url,{shoppingCarId:id},function(data){
    data = $.parseJSON(data);
    var flag = data.mess;
    if(flag=="Y"){
     var price = $(".price-"+id).text();
     var totalprice = $(".total-price").text();
     var money = totalprice - price;
     getCarNum();  //方法在head.jsp 
     $(".del-car-"+id).remove();
     $(".total-price").text(money);
    }
  });
  layer.msg('删除成功！');
			  
  });
}
 
 
 
</script>
<link  rel="shortcut icon" href="../favicon.ico"/>
</head>
<body>
<div>
  <jsp:include page="../head.jsp"></jsp:include>
</div>
<div class="tit_all m_bottom_80 conbg">
	  <div class="container">
	      <div class="wrap">
		     <div class="gw_tite">购物车</div>
			 <div class="wrap_br">
			  <c:forEach items="${gemList}" var="gem">
				<div class="wrap_bj del-car-${gem.vdef2}"><h3>${gem.type_cn}<b>${gem.weight}</b></h3><a href="javascript:void(0)" onclick="delShoppCar('${gem.vdef2}')"></a></div>	 
				<dl class="gwc1 del-car-${gem.vdef2}">
					<dt class="col-xs-12 col-sm-5"><a href="javascript:void(0)"><img src="http://gemtakimg.b0.upaiyun.com/Gemtak/${gem.gid}/${gem.is_cover}!mid"/></a></dt>
					<dd class="col-xs-12 col-sm-7"><p>${gem.company}</p>
						<p>形状： ${gem.shape_cn}</p>
						<p>尺寸：  ${gem.size_l}x${gem.size_w}x${gem.size_h} </p>
						<p>颜色：${gem.average_color}</p>
						<p>净度： ${gem.clarity_cn}</p>
						<p>切工： ${gem.cut_cn} </p>
						<p>产地： ${gem.origin_cn}</p>
						<p>处理： ${gem.treatment_cn}</p>
						<p>证书： 国检${gem.lab_cn} </p>
						<p>卖家： ${gem.supplier} </p>
						<p>价格： ${gem.retail_price} </p>
					</dd>
				</dl>
				<div class="wrap_bj wrap_bj1 del-car-${gem.vdef2}"><span>数量<input  class="" readonly="readonly" type="text" name=""  value="${gem.vdef1}" /></span><span>总价：￥<m class="price-${gem.vdef2}">${gem.retail_price*gem.vdef1}</m>元</span></div>
			  	<c:set var="TotalCartPices" value="${TotalCartPices + gem.retail_price*gem.vdef1}" />
			  </c:forEach>  
			 </div>
		   </div>
   	 <div class="wrap_all">
		   <p><span style="float:right">合计：￥<b class="total-price">${TotalCartPices}</b>元</span></p>
		   <p><a href="${ctx }/gemClient/viewGemList.do" class="zgg">再逛逛</a><a href="javascript:void(0)" class="qjz">去结账</a></p>
	 </div>   	  
	</div>
</div>
<div class="footer hidden-xs hidden-sm">
    <jsp:include page="../../admin/foot.jsp"></jsp:include>
</div>
</body>
</html>