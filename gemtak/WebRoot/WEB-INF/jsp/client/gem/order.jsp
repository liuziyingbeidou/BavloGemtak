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
<title>彩色宝石、钻石、报价、3D、鉴定、珠宝定制、Gemtakak</title>
<link rel="stylesheet" href="${ctx}/resources/client/css/bootstrap.css" />
<link href="${ctx}/resources/client/css/index.css" rel="stylesheet"/>
<link rel="stylesheet" href="${ctx }/resources/client/css/files/loaders.css" type="text/css"></link>
<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/jquery.js"></script>
<script type="text/javascript" src="${ctx }/resources/client/js/area_cus.js"></script>
<style type="text/css">
 .yemianyanchi{
	  position:fixed;
	  left:700px;
	  top:300px;
 }
 </style>
 <link  rel="shortcut icon" href="../favicon.ico"/>
</head>

<script language=javaScript>
$(function(){
  $(".yemianyanchi").show();
  selectUserAddress();
  $(".yemianyanchi").hide();
});
 function selchecked(em){
  var aid = $(em).attr("nid");
   var url = "/gemtak/gemClient/getUserAddressByAid.do";
   $.post(url,{aid:aid},function(data){
     $(".selUser").empty();
     if(data != null){
       for(var i=0;i<data.length;i++){
        $(".selUser").append("<li class='urealname'>收货人姓名：<span>"+data[i].realName+"</span></li>"+
			"<li class='area'>地区： <span>"+data[i].area+"</span></li>"+
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
    	$(".selUser").append("<li class='urealname' name='real_name'>收货人姓名：<span>"+data[i].realName+"</span><input type='hidden' name='real_name' value='"+data[i].realName+"'/></li>"+
						"<li class='area'>地区：<span>"+data[i].area+"</span> </li>"+
						"<li class='uaddress'name='mail_address'>地址：<span>"+data[i].detailAddress+"</span><input type='hidden' name='mail_address' value='"+data[i].area+","+data[i].detailAddress+"'/></li>"+
						"<li class='uzipcode' name='zipcode'>邮编：<span>"+data[i].zipcode+"</span><input type='hidden' name='zipcode' value='"+data[i].zipcode+"'/> </li>"+
						"<li class='utel' name='tel'>座机：<span>"+data[i].tel+"</span><input type='hidden' name='tel' value='"+data[i].tel+"'/> </li>"+
						"<li class='uphone' name='cellphone'>手机：<span>"+data[i].cellphone+"</span><input type='hidden' name='cellphone' value='"+data[i].cellphone+"'/> </li>"+
						"<li class='uemail' name='email'>E-mail：<span>"+data[i].email+"</span><input type='hidden' name='email' value='"+data[i].email+"'/></li>");
        }else{
        	$(".addUser").append("<li class='sel'><input nid='"+data[i].id+"' class='s_input aaa' type='radio' name='month'  value='"+data[i].id+"' /><span>"+data[i].realName+"</span>"+data[i].detailAddress+"</li>");
        }
    }
    getCarNum();
    $(".aaa").click(function(){
     selchecked(this);
    });
  }else{
  	getCarNum();
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
		   	    $(".selUser").empty();
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
		   	    $(".selUser").empty();
                deleteAddress($(this).attr("nid"));//删除用户收货地址
            }
		   });
		 });
  }
 });
 }
 
 
     //平台、设备和操作系统 
        var system = { 
            win: false, 
            mac: false, 
            xll: false, 
            ipad:false 
        }; 
        //检测平台 
        var p = navigator.platform; 
        system.win = p.indexOf("Win") == 0; 
        system.mac = p.indexOf("Mac") == 0; 
        system.x11 = (p == "X11") || (p.indexOf("Linux") == 0); 
        system.ipad = (navigator.userAgent.match(/iPad/i) != null)?true:false; 
        //跳转语句，如果是手机访问就自动跳转到wap.baidu.com页面 
        if (system.win || system.mac || system.xll||system.ipad) { 
           
        } else { 
          $(".mrtype").val("mobile");
        } 
 
 //**********************************************
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
			
		  <!-- 延迟加载   start  loaders.css-->
		      <div class="loader yemianyanchi" style="display: none;">
		        <div class="loader-inner ball-spin-fade-loader">
		          <div></div>
		          <div></div>
		          <div></div>
		          <div></div>
		          <div></div>
		          <div></div>
		          <div></div>
		          <div></div>
		        </div>
		      </div>
		      <!-- 延迟加载   end --> 
		         
			<form action="${ctx }/gemClient/balancePay.do" method="post"  id="orderForm">
			 <input name="mrType" class="mrtype" type="hidden" value="pc"/>
			 <div class="wrap_br wrap_br_d">
				<h2><span>收货人信息</span></h2>	  
				 <ul class="srxx addUser">
				   <%-- <c:forEach items="" var="user">
				   <li class="sel"><input  class="s_input" type="radio" name="month"  value="0" checked="checked"/><span>${user.realName}</span>${user.detailAddress}</li>
				   </c:forEach> --%>
				 </ul>
				 <ul class="srxx selUser">
						
				</ul>         
			    <ul style="display:none;" class="srxx1 show-addUser" >
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
				  <li class="del_s">
				     <a href="javascript:void(0)" class="btn btn-8c btn-lg active btn-save" ntype="insert" role="button">保存</a>
                     <a href="javascript:void(0)" class="btn btn-default btn-lg active btn-clean" role="button">取 消</a>
                  </li>
			    </ul>		 
				<h2><span>快递方式</span></h2>
				<ul class="srxx">
				   <li>优先顺丰快递，顺丰不及地区用EMS</li>
				   <li ><input class="addsupport" type="checkbox" value="" name="support_fee" > <span class="qebj">需要全额保价</span>（费用是总价值的千分之五）</li>
				</ul>
				   
			    <h2><span>发票信息 ——商业零售机打发票</span></h2>
				<div class="status">
					<p>需开发票？
					 <span>
					   <input type="radio" class="open-invoice" name="invoice"  value="开发票" />开发票</span><span>
					   <input type="radio" class="close-invoice" name="invoice"  value="不开发票" checked="checked"/>不开发票
					 </span>
					</p>
					<p class="show-intitle" style="display: none">发票抬头：<b><input  type="text" value="" placeholder="个人" name="invoice_title"/></b></p>
					<p class="show-incontent" style="display: none">发票内容：<span><input type="radio" name="invoice_content"  value="珠宝首饰" />珠宝首饰</span><span><input type="radio" name="invoice_content" value="办公用品" /></span>办公用品</p>
			    </div> 
				<h2><span>商品清单</span></h2>
			    <c:forEach items="${gemList}" var="gem">
				  <dl class="spqd">
					 <dt><a href="javascript:void(0);"><img  src="http://gemtakimg.b0.upaiyun.com/Gemtak/${gem.gid}/00001.jpg!mid" width="100%" /></a></dt>
					 <dd><p class="gemid" nid="${gem.id}" sid="${gem.vdef1}" jid="${gem.retail_price}"><b>${gem.type_cn}•${gem.type_cn}</b></p>
					     <p class="shopcarid" style="display:none"><span>${gem.vdef2}</span></p>
						 <p class="shuliang" name="quantity">数量：<span>${gem.vdef1}</span></p>
						 <p class="jiage" name="price">原价：￥<span>${gem.retail_price}</span></p>
				     </dd>
				  </dl>
				  <c:set var="TotalPrice" value="${TotalPrice+gem.retail_price*gem.vdef1}"/>
				 </c:forEach>
				 <h2><span>结算方式</span></h2>
				 <ul class="jsfs">			   
				   <li><input type="radio" style="text-align: center;" name="zhifu" class="zfb" value="1" /> <span>支付宝支付</span></li>
				   <li><input type="radio" style="text-align: center;" name="zhifu" class="wx" value="2"  checked="checked"/> <span>微信支付</span></li>
				 </ul>
				  
				 <h2><span>结算信息</span></h2>
				  <div class="jsxx">
					 <p>
					    <input class="jsxx_m couponNum" type="text"   name="coupon" value=""  placeholder="如有优惠劵，请在填写优惠券编码。"/>
					    <input class="jsxx_b sel_couppon"   type="button" title="添加" value="添加"/>
					    <b class="couponNo" style="font-size: 14px;color: #8c0000;"></b>
					    <input class="jsxx_m youhuijia" type="hidden"   name="coupon_fee" value="${youhuijia}" />
					 </p>
					 <p class="jsxx_p zongjia">订单总金额: ￥<span><b class="dingdan">${TotalPrice+23}</b>  &nbsp;(<b>运费：23</b>,保价：<b class="baoj">0</b>,优惠：<b class="huij">0</b>)</span>元</p>
					 <input type="hidden" name="totalPrice" value="${TotalPrice+23}"/>
				  </div>
			   </div>
			    <div class="tjdd"><input class="saveOrder" type="submit" title="提交订单" value="提交订单"/></div>
			  </form>
	  </div>
  </div>
</div>
<div class="footer hidden-xs hidden-sm">
    <jsp:include page="../../admin/foot.jsp"></jsp:include>
</div>
</body>
<script language=javaScript>
$(function(){
 
 //点击开发票
 $(".open-invoice").click(function(){
  $(".show-intitle").show();
  $(".show-incontent").show();
 });
 //点不开发票
 $(".close-invoice").click(function(){
  $(".show-intitle").hide();
  $(".show-incontent").hide();
 });


//新增时 保存
 $(".btn-save").click(function(){
  saveOrUpdate();
 });
 

 //新增用户收货地址
function saveOrUpdate(){
 // checkEmpty();
  var realName = $(".username").val();
  var area = $(".area1").find("option:selected").text()+","+$(".area2").find("option:selected").text()+","+$(".area3").find("option:selected").text();
  var detailAddress =$(".detailAddress").val();
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
     //alert("添加成功！");
      layer.alert('收货地址添加成功！', {
         title:'gemtak 提示:',
         icon: 1,
         skin: 'layui-layer-molv'
        });
     $(".selUser").empty();
     selectUserAddressHead();
     $(".selUser").append("<li class='urealname'>收货人姓名：<span>"+realName+"</span></li>"+
			"<li class='diqu'>地区：<span> "+area+"</span></li>"+
			"<li class='uaddress'>地址：<span>"+detailAddress+"</span></li>"+
			"<li class='uzipcode'>邮编：<span>"+zipcode+"</span> </li>"+
			"<li class='utel'>座机：<span>"+tel+"</span> </li>"+
			"<li class='uphone'>手机：<span>"+cellphone+"</span> </li>"+
			"<li class='uemail'>E-mail：<span>"+email+"</span></li>");
	 $(".show-addUser").hide();
     } 
	} 
  }); 
}
 
 //新增时 点击取消按钮
 $(".btn-clean").click(function(){
  $(".username").val("");
  $("#vcity").find("option:selected").text("城市");
  $("#vdistrict").find("option:selected").text("区县");
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
    var area = $(".area span").text();
        var nums = area.split(",");
	    for (var i=0 ; i< nums.length ; i++){
		     $(".area"+(i+1)).val(nums[i]);
		     if(i < 2){
		     	change(i+1);
		     }
	    } 
     
    
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
     //alert("删除成功！");
     layer.alert('收货地址删除成功！', {
         title:'gemtak 提示:',
         icon: 1,
         skin: 'layui-layer-molv'
        });
     selectUserAddress();
    }
   });
 }

 //获取优惠码 
  $(".sel_couppon").bind("click",function(){
   var code = $(".couponNum").val();
   if(code == null || code == ""){
      $(".couponNo").text("请填写优惠券编码!");
      return false;
    }else{
      $(".couponNo").text("");
    }
   var url = "/gemtak/gemClient/getcouppon.do";
   $.post(url,{code:code},function(data){
    if(data != null || data != ""){
      if(data == "优惠券编码不正确!"){
        $(".couponNo").text("优惠券编码不正确!");
        return false;
      }else{
        var couppon = data;
        $(".youhuijia").attr("value",couppon);
        var youhuijia = $(".youhuijia").val();   //获取的优惠码 价格
        var tprice = ${TotalPrice}-youhuijia+23; //23元为运费
        $(".dingdan").text(tprice);
        $(".huij").text(youhuijia);
        if($(".addsupport").is(":checked")){   //当有优惠码时  选择保价时
	        var baojia = ${TotalPrice*0.005};
	        var tprice = ${TotalPrice}+${TotalPrice*0.005}-youhuijia+23; //23元为运费
	        $(".dingdan").text(tprice);
	        $(".baoj").text(baojia);
	        $(".huij").text(youhuijia);
        }
      }
    }
   });
  });
  
  //当选中 全额保价
  $(".addsupport").bind("click",function(){
   if($(".addsupport").is(":checked")){
       $(".addsupport").attr("value","${TotalPrice*0.005}");
       var baojia = ${TotalPrice*0.005};
       var youhuijia = $(".youhuijia").val();
       var tprice = ${TotalPrice}+${TotalPrice*0.005}-youhuijia+23; //23元为运费
       $(".dingdan").text(tprice);
       $(".baoj").text(baojia);
       $(".huij").text(youhuijia);
      }else{
        $(".addsupport").attr("value","${TotalPrice*0.005}");
        var youhuijia = $(".youhuijia").val();
        var tprice = ${TotalPrice}-youhuijia+23; //23元为运费
        $(".dingdan").text(tprice);
        $(".baoj").text("0");
        $(".huij").text(youhuijia);
      }
  });
  
  
  
  
  /* $(".saveOrder").bind("click",function(){
  var realName = $(".username").val();
  var area = $(".area1").find("option:selected").text()+","+$(".area2").find("option:selected").text()+","+$(".area3").find("option:selected").text(); 
  var detailAddress = $(".area1").find("option:selected").text()+","+$(".area2").find("option:selected").text()+","+$(".area3").find("option:selected").text(),$(".detailAddress").val();
  var zipcode = $(".zipcode").val();
  var tel = $(".tel").val();
  var cellphone = $(".cellphone").val();
  var email = $(".email").val();
  var gemid = $(".baoshi span").text();
  var quantity = $("shuliang span").text();
  var price = $(".jiage span").text();
  var totalprice = $(".zongjia span").text();
  var shoppingCarid = $(".shopcarid").text();
  var url = "/gemtak/gemClient/orderSuccess.do";
   $.post(url,{realname:realName,address:detailAddress,zipcode:zipcode,tel:tel,cellphone:cellphone,email:email,gemid:gemid,quantity:quantity,price:price,
   totalprice:totalprice,shoppingCarid:shoppingCarid},function(data){
     
   });
  }); */
 
 //提交订单
  /* $(".saveOrder").click(function(){
   addOrder();
  });
  function addOrder(){
   var orderListJson = getOrderlistInfo();
   
   $.ajax({
    url:"/gemtak/gemClient/balancePay.do",
    type:"post",
    data:$("#orderForm").serialize()+"&list="+orderListJson,
    async:false,
    cache:false,
    success:function(data){
    }
   });
  } */
  
  //收集清单数据
  /* function getOrderlistInfo(){
   var listJson = "[";
   $(".gemid").each(function(){
    var gemid = $(this).attr("nid");
    var quantity = $(this).attr("sid");
    var price = $(this).attr("jid");
    listJson +="{\"gem_id\":\""+gemid+"\",\"quantity\":\""+quantity+"\",\"price\":\""+price+"\"},";
   });
   if(listJson.length>1){
     listJson = listJson.substring(0,listJson.length-1);
   }
   listJson += "]";
   return listJson;
  } */
  
</script>
</html>