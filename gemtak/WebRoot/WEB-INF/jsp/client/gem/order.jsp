<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="TotalPrice" value="0"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="bavlo">
<meta name="keywords" content="bavlo">
<meta name="author" content="bavlo">
<title>bavlo</title>
<link rel="stylesheet" href="${ctx}/resources/client/css/bootstrap.css" />
<link href="${ctx}/resources/client/css/index.css" rel="stylesheet">
<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/jquery.js"></script>
<script type="text/javascript" src="${ctx }/resources/client/js/area_cus.js"></script>
</head>
<script>
$(function(){
  selectUserAddress();
});
 function selchecked(em){
  var aid = $(em).attr("nid");
   var url = "/gemtak/gemClient/getUserAddressByAid.do";
   $.post(url,{aid:aid},function(data){
     $(".selUser").empty();
     if(data != null){
       for(var i=0;i<data.length;i++){
        $(".selUser").append("<li class='urealname'>收货人姓名：<span>"+data[i].realName+"</span></li>"+
			"<li class=''>地区： <span>"+data[i].area+"</span></li>"+
			"<li class='uaddress'>地址：<span>"+data[i].detailAddress+"</span></li>"+
			"<li class='uzipcode'>邮编：<span>"+data[i].zipcode+"</span> </li>"+
			"<li class='utel'>座机：<span>"+data[i].tel+"</span> </li>"+
			"<li class='uphone'>手机：<span>"+data[i].cellphone+"</span> </li>"+
			"<li class='uemail'>E-mail：<span>"+data[i].email+"</span></li>");
       }
     }
   });
 }
 
 function selectUserAddress(){
 var url = "/gemtak/gemClient/getUserAddress.do";
 $.post(url,function(data){
  $(".addUser").empty();
  $(".addUser").append("<li>常用地址</li>");
  if(data != null){
  	//data = $.parseJSON(data);
    for(var i=0;i<data.length;i++){
        if(i == 0){
    	$(".addUser").append("<li class='sel'><input nid='"+data[i].id+"' value='"+data[i].id+"'  class='s_input aaa' type='radio' name='month'  checked='checked'/><span>"+data[i].realName+"</span>"+data[i].detailAddress+"</li>");
    	$(".selUser").append("<li class='urealname'>收货人姓名：<span>"+data[i].realName+"</span></li>"+
						"<li class='area'>地区：<span>"+data[i].area+"</span> </li>"+
						"<li class='uaddress'>地址：<span>"+data[i].detailAddress+"</span></li>"+
						"<li class='uzipcode'>邮编：<span>"+data[i].zipcode+"</span> </li>"+
						"<li class='utel'>座机：<span>"+data[i].tel+"</span> </li>"+
						"<li class='uphone'>手机：<span>"+data[i].cellphone+"</span> </li>"+
						"<li class='uemail'>E-mail：<span>"+data[i].email+"</span></li>");
        }else{
        	$(".addUser").append("<li class='sel'><input nid='"+data[i].id+"' class='s_input aaa' type='radio' name='month'  value='"+data[i].id+"' /><span>"+data[i].realName+"</span>"+data[i].detailAddress+"</li>");
        }
    }
    
    $(".aaa").click(function(){
     selchecked(this);
    });
  }
  $(".addUser").append("<li class='del_s'><a href='javascript:void(0)' class='btn  btn-lg active insert-user' role='button'>新 增</a>"+
								 "<a href='javascript:void(0)' class='btn btn-default btn-lg active update-user' role='button'>修 改</a>"+
								 "<a href='javascript:void(0)' class='btn btn-default btn-lg active del-user' role='button'>删 除</a></li>");
		 $(".insert-user").bind("click",function(){
		   $(".show-addUser").show();
		   $(".btn-save").attr("ntype","insert");
		 });
		 $(".update-user").bind("click",function(){
		   $(".aaa").each(function(){
		   	if ($(this).is(':checked')) {
                updateAddress($(this).attr("nid"));//修改 用户收货地址
                $(".btn-save").attr("ntype","update");
            }
		   });
		 });
		 $(".del-user").bind("click",function(){
		   $(".aaa").each(function(){
		   	if ($(this).is(':checked')) {
		   	    $(".selUser").remove();
                deleteAddress($(this).attr("nid"));//删除用户收货地址
            }
		   });
		 });
 });
 }
 
 function selectUserAddressHead(){
 var url = "/gemtak/gemClient/getUserAddress.do";
 $.post(url,function(data){
  $(".addUser").empty();
  $(".addUser").append("<li>常用地址</li>");
  if(data != null){
  	//data = $.parseJSON(data);
    for(var i=0;i<data.length;i++){
    	$(".addUser").append("<li class='sel'><input nid='"+data[i].id+"' value='"+data[i].id+"'  class='s_input aaa' type='radio' name='month'  checked='checked'/><span>"+data[i].realName+"</span>"+data[i].detailAddress+"</li>");
     }
     $(".addUser").append("<li class='del_s'><a href='javascript:void(0)' class='btn  btn-lg active insert-user' role='button'>新 增</a>"+
								 "<a href='javascript:void(0)' class='btn btn-default btn-lg active update-user' role='button'>修 改</a>"+
								 "<a href='javascript:void(0)' class='btn btn-default btn-lg active del-user' role='button'>删 除</a></li>");
		 $(".insert-user").bind("click",function(){
		   $(".show-addUser").show();
		   $(".btn-save").attr("ntype","insert");
		 });
		 $(".update-user").bind("click",function(){
		   $(".aaa").each(function(){
		   	if ($(this).is(':checked')) {
                updateAddress($(this).attr("nid"));//修改 用户收货地址
                $(".btn-save").attr("ntype","update");
            }
		   });
		 });
		 $(".del-user").bind("click",function(){
		   $(".aaa").each(function(){
		   	if ($(this).is(':checked')) {
		   	    $(".selUser").remove();
                deleteAddress($(this).attr("nid"));//删除用户收货地址
            }
		   });
		 });
  }
 });
 }
 
 
 var s = ["vpovince","vcity","vdistrict"];
 var opt0 = ["省份","城市","区县"];
 
 $(function(){
  change(0);
  $("#vpovince").bind("change",function(){
    change(1);
  });
  $("#vcity").bind("change",function(){
    change(2);
  });
 });
</script>
<body>
<div>
  <jsp:include page="../head.jsp"></jsp:include> 
</div>
<div class="tit_all m_bottom_80 conbg">
	  <div class="container">
	     <div class="wrap">
		    <div class="gw_tite">确认定单</div>
            <div class="gw_nav">
			   <ul>
			     <li class="col-xs-4" type="hi"><span>1</span>购物车</li>
				 <li class="gw_nav_sel col-xs-4"><span>2</span>确认定单</li>
			     <li class="col-xs-4"><span>3</span>成功提交订单</li>
			   </ul>
			  
			</div>     
			 
			 <div class="wrap_br wrap_br_d">
				<h2><span>收货人信息</span></h2>	  
				 <ul class="srxx addUser">
				   <%-- <c:forEach items="" var="user">
				   <li class="sel"><input  class="s_input" type="radio" name="month"  value="0" checked="checked"/><span>${user.realName}</span>${user.detailAddress}</li>
				   </c:forEach> --%>
				 </ul>
				 <ul class="srxx selUser">
						<!-- <li>收货人姓名：丁力 </li>
						<li>地区： 北京市 海淀区</li>
						<li>地址：清华东路17号院29号楼B座1003</li>
						<li>邮编：100086 </li>
						<li>座机：010-82830789 </li>
						<li>手机：13810539493 </li>
						<li>E-mail：mtvdb@sina.com</li>
						<li class="del_s"><a href="#" class="btn  btn-lg active" role="button">新 增</a>
										  <a href="#" class="btn btn-default btn-lg active" role="button">修 改</a>
										  <a href="#" class="btn btn-default btn-lg active" role="button">删 除</a></li> -->
				</ul>         
			    <ul style="display:none;" class="srxx1 show-addUser" >
			    <form action="./finish_order.html" id="addUserAddress" method="post" >
				  <li><input type="text" class="form-control username" placeholder="收货人姓名"></li>
				  <li><select class="form-control area1" id="vpovince" name="vpovince">
                            <!-- <option value="-1">请选择地区</option>
							<option >华北</option>
							<option>东北</option>
							<option>长江</option> -->
                            </select>
				  </li>
				  <li><select class="form-control area2" id="vcity" name="vcity">
							<!-- <option>请选择城市</option>
							<option>北京</option>
							<option>上海</option>
							<option>天津</option> -->
						</select></li>
						<li><select class="form-control area3" id="vdistrict" name="vdistrict">
							<!-- <option>请选择城区</option>
							<option>城区</option>
							<option>城外</option> -->
						</select></li>
				  
				  <li><input  type="text" class="form-control detailAddress" placeholder="详细地址" /></li>
				  <li><input  type="text" class="form-control zipcode" placeholder="邮政编码" /></li>
				  <li><input  type="text" class="form-control tel" placeholder="固定电话（可不填）" /></li>
				  <li><input  type="text" class="form-control cellphone" placeholder="手机号码" /></li>
				  <li><input  type="text" class="form-control email" placeholder="E-mail" /></li>
				  </form>
				  <li class="del_s">
				     <a href="javascript:void(0)" class="btn btn-8c btn-lg active btn-save" ntype="insert" role="button">保存</a>
                     <a href="javascript:void(0)" class="btn btn-default btn-lg active btn-clean" role="button">取 消</a>
                  </li>
			    </ul>		 
				<h2><span>快递方式</span></h2>
				<ul class="srxx">
				   <li>优先顺丰快递，顺丰不及地区用EMS</li>
				   <li><input type="checkbox" value="0" name="showFlag" checked=""> <span>需要全额保价</span>（费用是总价值的千分之五）</li>
				</ul>
				   
			    <h2><span>发票信息 ——商业零售机打发票</span></h2>
				<div class="status">
					<p>需开发票？<span><input type="radio" name="month"  value="1" checked="checked"/>开发票</span><span><input type="radio" name="month"  value="2" />不开发票</span></p>
					<p>发票抬头：<b><input  type="text" placeholder="个人" /></b></p>
					<p>发票内容：<span><input type="radio" name="month"  value="3" checked="checked"/>珠宝首饰</span><span><input type="radio" name="month"  value="4" /></span>办公用品</p>
			    </div> 
				<h2><span>商品清单</span></h2>
			    <c:forEach items="${gemList}" var="gem">
				  <dl class="spqd">
					 <dt><a href=""><img src="${ctx }/resources/client/images/gw1.jpg" width="100%" /></a></dt>
					 <dd><p><b>${gem.type_cn}•${gem.type_cn}</b></p>
						 <p>数量：<span>${gem.vdef1}</span></p>
						 <p>原价：<span>￥${gem.retail_price}</span></p>
				     </dd>
				  </dl>
				  <c:set var="TotalPrice" value="${TotalPrice+gem.retail_price*gem.vdef1}"/>
				 </c:forEach>
				 <h2><span>结算信息</span></h2>
				  <div class="jsxx">
					 <p><input class="jsxx_m" type="text"   name="key" value="输入优惠券编码" /><input class="jsxx_b"   type="submit" title="添加" value="添加"/></p>
					 <p class="jsxx_p">订单总金额: ￥${TotalPrice}元</p>
				  </div>
			   </div>
			   <div class="tjdd saveOrder"><input  type="submit" title="提交订单" value="提交订单"/></div>
			   
	 </div>
  </div>
</div>
<div class="footer hidden-xs hidden-sm">
    <jsp:include page="../../admin/foot.jsp"></jsp:include>
</div>
</body>
<script>
$(function(){
//新增时 保存
 $(".btn-save").click(function(){
  saveOrUpdate();
 });
 //新增用户收货地址
 function saveOrUpdate(){
  var realName = $(".username").val();
  var area = $(".area1").find("option:selected").text()+","+$(".area2").find("option:selected").text()+","+$(".area3").find("option:selected").text(); 
  var detailAddress = $(".detailAddress").val();
  var zipcode = $(".zipcode").val();
  var tel = $(".tel").val();
  var cellphone = $(".cellphone").val();
  var email = $(".email").val();
  var aid = null;
  if($(".btn-save").attr("ntype") == "update"){
    $(".aaa").each(function(){
   	if ($(this).is(':checked')) {
           aid = $(this).attr("nid");
          }
   });
  }
  $.ajax({ 
	url:"/gemtak/gemClient/addUserAddress.do", 
	type:"post", //数据发送方式 
	data:{aid:aid,realName:realName,area:area,detailAddress:detailAddress,zipCode:zipcode,tel:tel,cellphone:cellphone,email:email}, //要传递的数据 
	contentType:"application/x-www-form-urlencoded;charset=UTF-8",
	success: function(data){ //成功 
	 if(data == "true"){
     alert("添加成功！");
     $(".selUser").empty();
     selectUserAddressHead();
     $(".selUser").append("<li class='urealname'>收货人姓名：<span>"+realName+"</span></li>"+
			"<li class=''>地区：<span> "+area+"</span></li>"+
			"<li class='uaddress'>地址：<span>"+detailAddress+"</span></li>"+
			"<li class='uzipcode'>邮编：<span>"+zipcode+"</span> </li>"+
			"<li class='utel'>座机：<span>"+tel+"</span> </li>"+
			"<li class='uphone'>手机：<span>"+cellphone+"</span> </li>"+
			"<li class='uemail'>E-mail：<span>"+email+"</span></li>");
     } 
	} 
  }); 
}
 
 //新增时 点击取消按钮
 $(".btn-clean").click(function(){
  $(".username").val("");
  $(".detailAddress").val("");
  $(".zipcode").val("");
  $(".tel").val("");
  $(".cellphone").val("");
  $(".email").val("");
  $(".show-addUser").hide();
	
});

});
 
   //修改用户收货地址
 function updateAddress(id){
   $(".show-addUser").show();
    $(".username").val($(".urealname span").text());
    $(".area1").find("option:selected").text()+","+$(".area2").find("option:selected").text()+","+$(".area3").find("option:selected").text(); 
    $(".detailAddress").val($(".uaddress span").text());
    $(".zipcode").val($(".uzipcode span").text());
    $(".tel").val($(".utel span").text());
    $(".cellphone").val($(".uphone span").text());
    $(".email").val($(".uemail span").text());
 }
 
 //删除用户收货地址
 function deleteAddress(id){
   var url = "/gemtak/gemClient/delUserAddress.do";
   $.post(url,{id:id},function(data){
    if(data == "true"){
     alert("删除成功！");
      selectUserAddress();
    }
   });
 }


 

</script>
</html>