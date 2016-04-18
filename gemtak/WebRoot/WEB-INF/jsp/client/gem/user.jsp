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
<meta name="description" content="bavlo">
<meta name="keywords" content="bavlo">
<meta name="author" content="bavlo">
<title>bavlo</title>
<link rel="stylesheet" href="${ctx }/resources/client/css/bootstrap.css" />
<link href="${ctx }/resources/client/css/index.css" rel="stylesheet">
<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/jquery.js"></script>
<script type="text/javascript" src="${ctx }/resources/client/js/area_cus.js"></script>
<script>
$(function(){
  getCarNum();
  showUserOrder();
  closeUserOrder();
  manageAddress();
  closeAddress();
  addUserAddress();
  btnclean();
  btnSave();
  deluser();
  updateUPassWord();
  cleanPwd();
});

//收货地址管理
function manageAddress(){
 $(".userAddress").click(function(){
  selectUaddress();
 });
}
//查询收货地址
function selectUaddress(){
 $(".uaddress").empty();
  $(".uaddress").show();
  var url = "/gemtak/gemClient/getUserAddress.do";
  $.post(url,function(data){
   if(data != null){
    for(var i = 0; i <data.length; i++){
     $(".shouhuo").append("<ul><li >收货人：<span class='urealname"+data[i].id+"'>"+data[i].realName+"</span></li>"+
                        "<li >地区：<span class='area"+data[i].id+"'>"+data[i].area+"</span> </li>"+
						"<li >手机：<span class='uphone"+data[i].id+"'>"+data[i].cellphone+"</span></li>"+
						"<li >地址：<span class='uaddress"+data[i].id+"'>"+data[i].detailAddress+"</span></li>"+
						"<li >邮编：<span class='uzipcode"+data[i].id+"'>"+data[i].zipcode+"</span></li>"+
						"<li >座机：<span class='utel"+data[i].id+"'>"+data[i].tel+"</span></li></ul>"+
						"<li style='display:none'>E-mail：<span class='uemail"+data[i].id+"'>"+data[i].email+"</span></li></ul>"+
						"<div class='xgdz'><span style='float:left'><input type='checkbox' class='aaa' value='0' name='showFlag' nid='"+data[i].id+"'> 设为默认地址</span><span style='float:right'><a href='javascript:void(0)' onclick='updateuser("+data[i].id+")'>修 改</a><a href='javascript:void(0)' onclick='deluser("+data[i].id+")'>删 除</a></span></div>");
    }
   }
  });
}

function closeAddress(){
 $(".close-address").click(function(){
  $(".uaddress").hide();
 });
}

//显示订单记录
function showUserOrder(){
 $(".userOrder").click(function(){
   $(".uOrder").show();
 });
}

function closeUserOrder(){
 $(".close-order").click(function(){
   $(".uOrder").hide();
 });
}

function addUserAddress(){
 $(".addUaddress").click(function(){
  $(".tianjiaAddress").show();
 });
}

function btnclean(){
  $(".btn-clean").click(function(){
   $(".username").val("");
   $(".detailAddress").val("");
   $(".zipcode").val("");
   $(".tel").val("");
   $(".cellphone").val("");
   $(".email").val("");
   $(".tianjiaAddress").hide();
  });
}

function btnSave(){
 //新增时 保存
 $(".btn-save").click(function(){
  saveOrUpdate();
 });
}

 //新增用户收货地址
 function saveOrUpdate(){
  var realName = $(".username").val();
  var area = $(".area1").find("option:selected").text()+","+$(".area2").find("option:selected").text()+","+$(".area3").find("option:selected").text();
  var detailAddress =$(".detailAddress").val();
  var zipcode = $(".zipcode").val();
  var tel = $(".tel").val();
  var cellphone = $(".cellphone").val();
  var email = $(".email").val();
  var aid = null;
  if($(".btn-save").attr("ntype") == "update"){
           aid = $(".aaa").attr("nid");
  }
  $.ajax({ 
	url:"/gemtak/gemClient/addUserAddress.do", 
	type:"post", //数据发送方式 
	data:{aid:aid,realName:realName,area:area,detailAddress:detailAddress,zipCode:zipcode,tel:tel,cellphone:cellphone,email:email}, //要传递的数据 
	contentType:"application/x-www-form-urlencoded;charset=UTF-8",
	success: function(data){ //成功 
	 if(data == "true"){
     alert("添加成功！");
     $(".shouhuo").empty();
     $(".tianjiaAddress").hide();
     $(".shouhuo").append("<ul><li >收货人：<span class='urealname'>"+realName+"</span></li>"+
                        "<li >地区：<span class='area'>"+area+"</span> </li>"+
						"<li >手机：<span class='uphone'>"+cellphone+"</span></li>"+
						"<li >地址：<span class='uaddress'>"+detailAddress+"</span></li>"+
						"<li >邮编：<span class='uzipcode'>"+zipcode+"</span></li>"+
						"<li >座机：<span class='utel'>"+tel+"</span></li></ul>"+
						"<div class='xgdz'><span style='float:left'><input type='checkbox' value='0' name='showFlag' > 设为默认地址</span><span style='float:right'><a href='javascript:void(0)' onclick='updateuser("+id+")'>修 改</a><a href='javascript:void(0)' onclick='deluser("+id+")'>删 除</a></span></div>");
     } 
	} 
  }); 
}

 //修改收货地址
function updateuser(id){
  $(".tianjiaAddress").show();
  updateAddress(id);//修改 用户收货地址
  $(".btn-save").attr("ntype","update");
}
  //修改用户收货地址方法
 function updateAddress(id){
    $(".username").val($(".urealname"+id).text());
    var area = $(".area"+id).text();
    var nums = area.split(",");
    for (var i=0 ; i<nums.length ; i++){
     $(".area"+(i+1)).val(nums[i]);
     if(i < 2){
     	change(i+1);
     }
    } 
    
    $(".detailAddress").val($(".uaddress"+id).text());
    $(".zipcode").val($(".uzipcode"+id).text());
    $(".tel").val($(".utel"+id).text());
    $(".cellphone").val($(".uphone"+id).text());
    $(".email").val($(".uemail"+id).text());
 }

//删除收货地址
function deluser(id){
  var url = "/gemtak/gemClient/delUserAddress.do";
   $.post(url,{id:id},function(data){
    if(data == "true"){
     alert("删除成功！");
     selectUaddress();
    }
   });
}

//修改密码
function updateUPassWord(){
 $(".updatePwd").click(function(){
  $(".newPwd").show();
  var oldPwd = $(".oldPwd").val();
  var newPwd = $(".newPwd").val();
  var rePwd = $(".rePwd").val();
  $(".oldPwd").blur(function(){
   if(oldPwd == "" || oldPwd == null){
	   $(".oldpass").text("请输入原密码！");
	   return;
   }
  });
  $(".newPwd").blur(function(){
   if(newPwd == "" || newPwd == null){
	   $(".newpass").text("请输入新密码！");
	   return;
  }
  });
  
   $(".rePwd").blur(function(){
    if(rePwd != newPwd){
    $(".error").text("两次输入的密码不相同！");
    return;
  }
   });
  
  
 });
}


function cleanPwd(){
 $(".cleanPwd").click(function(){
  $(".oldPwd").val();
  $(".newPwd").val();
  $(".rePwd").val();
  $(".newPwd").hide();
 });
}

function selOrderGem(id){
 var url = "/gemtak/gemClient/selOrderGemById.do";
 $.post(url,{orderid:id},function(data){
  if(data != null){
   for ( var i = 0; i < data.length; i++) {
	  $(".selectGem"+id).append("<dl><dt class='col-xs-3'><a href=''><img src='${ctx }/resources/client/images/gw1.jpg'  /></a></dt>"+
					"<dd class='col-xs-9'><p><b>"+data[i].type_cn+"</b></p><p>数量：<span>"+data[i].vdef2+"</span></p><p>原价：<span>￥"+data[i].vdef1+"</span></p></dd></dl>");
    }
  }
 });
 $(".shouqi-"+id).show();
 $(".chakan-"+id).hide(); 
}

//***************************
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
//***************************
</script>
</head>
<body>
<div>
  <jsp:include page="../head.jsp"></jsp:include> 
</div>
<div class="tit_all m_bottom_80 conbg">
	  <div class="container">
          <div class="inmenu ">
				<h2 class="doname"><a href="javascript:void(0)" class="userOrder">订单记录<font>（${num}）</font></a></h2>
				<i class="icon-me icon-me1 close-order"></i>
		   </div> 
		   <div class="ddjl uOrder" style="display: none">
			   <div class="user_br">
				 <c:forEach items="${orderList}" var="order">
				 <ul>
					<li>订单号：<b>${order.order_no}</b></li>
					<li>下单时间：${order.created}</li>
					<li>总金额：￥${order.totalPrice}</li>
					<c:if test="${order.status=='Y'}">
					 <li>状态：已支付</li>
					</c:if>
					<c:if test="${order.status=='N'}">
					 <li>状态：未支付<a href="${ctx }/gemClient/balancePay.do">立即支付</a></li>
					</c:if>
				 </ul>
				 <ul>
				   <li  style="list-style:outside;"><a href="javascript:void(0)" class="chakan-${order.id}" onclick="javascript:selOrderGem(${order.id})" oid="${order.id}">查看</a></li>
				   <li  style="list-style:outside; display: none"><a href="javascript:void(0)" class="shouqi-${order.id}">收起</a></li>
				 </ul>
				 <b class="selectGem${order.id}">
				   <%-- <dl>
					<dt class="col-xs-3"><a href=""><img src="${ctx }/resources/client/images/gw1.jpg"  /></a></dt>
					<dd class="col-xs-9"><p><b>神话•双鱼座</b></p><p>数量：<span>1 </span></p><p>原价：<span>￥3090000</span></p></dd>
				   </dl> --%>
				 </b>
				</c:forEach>
			   </div>
			    <div class="line "></div>
		   </div>
		   <div class="inmenu ">
				<h2 class="doname"><a href="javascript:void(0)" class="userAddress">收货地址管理</a></h2>
				<i class="icon-me icon-me1 close-address"></i>
			</div>
		   <div class="ddgl" >
			   <div class="user_br1 uaddress shouhuo" style="display: none">
					<%--  <ul>
						<li>收货人：${order.real_name}</li>
						<li>手机：${order.cellphone}</li>
						<li>地址：${order.mail_address}</li>
						<li>邮编：${order.zipcode} </li>
						<li>座机：${order.tel}</li> 
					 </ul>
					 <div class="xgdz"><span style="float:left"><input type="checkbox" value="0" name="showFlag" checked=""> 设为默认地址</span><span style="float:right"><a href="">修 改</a><a href="">删 除</a></span></div> --%>
			   </div>
			   <p class="add_new"><a href="javascript:void(0)" class="addUaddress"><img src="${ctx }/resources/client/images/add.png"  />添加新地址</a></p>
			   <div class="ddgl tianjiaAddress" style="display: none"> 
				   <form action="" method="post" > 
					   <ul class="add_new1">
						  <li><input  type="text" class="username"  name="username"  value="" placeholder="收货人姓名"/></li>
						  <li>
						       <select class="area1" id="vpovince" name="vpovince">
									<!-- <option>请选择地区</option>
									<option>华北</option>
									<option>东北</option>
									<option>长江</option> -->
								</select></li>
								<li><select class="area2" id="vcity" name="vcity">
									<!-- <option>请选择城市</option>
									<option>北京</option>
									<option>上海</option>
									<option>天津</option> -->
								</select></li>
								<li><select class="area3" id="vdistrict" name="vdistrict">
									<!-- <option>请选择城区</option>
									<option>城区</option>
									<option>城外</option> -->
								</select></li>
						  
						  <li><input  type="text" class="detailAddress"  name="key" value="" placeholder="详细地址"/></li>
						  <li><input  type="text" class="zipcode"  name="key" value="" placeholder="邮政编码"/></li>
						  <li><input  type="text" class="tel"  name="key" value="" placeholder="固定电话（可不填）" /></li>
						  <li><input  type="text" class="cellphone"  name="key" value="" placeholder="手机号码"/></li>
						  <li><input  type="text" class="email"  name="key" value="" placeholder="E-mail"/></li>
						  <li class="del_s"><a href="javascript:void(0)" class="btn-clean">取 消</a><a href="javascript:void(0)" class="btn-save">保 存</a></li>
					   </ul>
					 </form>
				</div>
			 </div>	
				<div class="inmenu ">
					<h2 class="doname"><a href="javascript:void(0)" class="updatePwd">修改密码</a></h2>
					<i class="icon-me icon-me1"></i>
				</div>
					<div class="ddgl newPwd" style="display: none"> 
					   <form action="" method="post" > 
						   <ul class="add_new1 m_top">
							  <li><input  type="text" class="oldPwd"  name="key" placeholder="原密码" value="" /></li><b style="color: red;size: 14px;text-align: center;" class="oldpass"></b>
							  <li><input  type="text" class="newPwd"  name="pwd" placeholder="新密码" value="" /></li><b style="color: red;size: 14px;text-align: center;" class="newpass"></b>
							  <li><input  type="text" class="rePwd"  name="key" placeholder="确认密码" value="" /></li><b style="color: red;size: 14px;text-align: center;" class="error"></b>
							  <li class="del_s"><a href="javascript:void(0)" class="cleanPwd">取 消</a><a href="javascript:void(0)" class="addPwd">保 存</a></li>
						   </ul>
						 </form>
					</div>	
			</div>    	  
	</div>
<div class="footer hidden-xs hidden-sm">
    <jsp:include page="../../admin/foot.jsp"></jsp:include>
</div>
</body>
</html>