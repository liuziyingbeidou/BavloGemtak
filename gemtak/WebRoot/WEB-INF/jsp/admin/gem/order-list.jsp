<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
   <meta http-equiv="x-ua-compatible" content="ie=7"/>
   <meta content="text/html; charset=UTF-8" http-equiv="content-type" />
   <link rel="stylesheet" href="${ctx }/resources/common/css/css.page.css" />
   <title>Insert title here</title>
   <link rel="stylesheet" href="${ctx }/resources/common/css/page.css" type="text/css"></link>
   <script type="text/javascript" src="${ctx}/resources/client/js/My97DatePicker/WdatePicker.js"></script>
   <script type="text/javascript" src="${ctx}/resources/client/js/jquery-1.12.4.js"></script>
   <script language="javascript" type="text/javascript" src="${ctx }/resources/common/js/jquery.min.js"></script>
   
   <script type="text/javascript">
     
function delOrder(id){
    if(confirm("确定要删除这条数据吗？")){
      location.href="${ctx}/gemClient/delOrderListById.do?id="+id;
    }
}
 
 
function addShippingDate(id){
  var shippingDate = document.getElementById("shippingDate").value;
  var shippingNo = $(".shippingNo").val();
  var url = "${ctx}/gemClient/updateShippingDateById.do?id="+id;
  $.post(url,{shippingDate:shippingDate,shippingNo:shippingNo},function(data){
     data = $.parseJSON(data);
     if(data.msg == "Y"){
      alert("保存成功！");
      window.location.reload();
     }
  });
}

//搜索 
function searchResult(p){
      var url = "${ctx }/gemClient/viewOrderListBytype.do";
	  var typeNo = $(".typeNo").val();
	  var start = document.getElementById("startDate").value;
	  var end = document.getElementById("endDate").value;
	  if(p != undefined && p != null && p != ""){
	 		url += "?dgpage="+p;
 	  }else{
 		url += "?dgpage=1";
 	  }
	  if(typeNo != null && typeNo != ""){ 
	 		url += "&typeNo="+typeNo;
	  }
	   if(start != null || start != ""){
	     url += "&startDate="+start;
	   }
	   if(end != null || end != ""){
	     url += "&endDate="+end;
	   }
	
	 	window.location.href= url; 
     /* $("#pager").pager({
      pagenumber: '${dgpage}',
      pagecount: Math.ceil('${total}'/ '${rows}'),
      buttonClickCallback: function (p) {
	      var url = "${ctx }/gemClient/viewOrderList.do";
		  var typeNo = $(".typeNo").val();
		  var start = document.getElementById("startDate").value;
		  var end = document.getElementById("endDate").value;
		  if(p != undefined && p != null && p != ""){
		 		url += "?dgpage="+p;
	 	  }else{
	 		url += "?dgpage=1";
	 	  }
		  if(typeNo != null && typeNo != ""){ 
		 		url += "&typeNo="+typeNo;
		  }
		   if(start != null || start != ""){
		     url += "&startDate="+start;
		   }
		   if(end != null || end != ""){
		     url += "&endDate="+end;
		   }
		
		 	window.location.href= url; 
      },
        TotalCount:'${total}',
        PageEnter: true 
    });*/
}

   </script>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0" width="100%">
	<tr>
		<td align="center" colspan="21" bgcolor="#EBEBEB" height="128">
			<input type="hidden" name="page" value="${page }" id="page"/>
			<input type="hidden" name="orderNo" id="orderNo"/>
			<input type="hidden" name="shippingNo" id="shippingNo"/>
			<input type="text" class="typeNo" size="40" placeholder="请输入订单号或快递单号"/><font size="2"> </font>
			<!-- <input type="button" value="搜索" onclick="selectOrderByType();"/> --><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</font>
			<!-- <select size="1" name="">
				<option selected value="">全部订单</option>
				<option value="0" >未支付</option>
				<option value="1" >已支付</option>
				<option value="2" >已发货</option>
				<option value="3" >交易完成</option>
			</select><font size="2"> </font> -->
			<font size="2">发货时间</font>
			<input class="Wdate" type="text" onClick="WdatePicker()" name="startDate" id="startDate"/>
			<font size="2"> - </font>
			<input class="Wdate" type="text" onClick="WdatePicker()" name="endDate" id="endDate"/>
			<font size="2"> </font> 
			<input type="button" value="搜索" onclick="searchResult();"/>
			<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
			<!-- <input type="checkbox" name="sortDir" value="desc" checked/><font size="2">时间倒序</font> -->
			
			<!-- 
			<input type="button" value="导出订单" style="float: right; margin-right: 150px;" onclick="javaScript:window.location.href='importExcel'" />
			 -->
		</td>
	</tr>
	<tr>
	
		<td align="center" width="123">
		 <font size="2">宝石图片</font>
		</td>
		
		<td align="center" width="63">
		 <font size="2">宝石id</font>
		</td>
		
		<td align="center" width="64">
		 <font size="2">宝石单价</font>
		</td>
		
		<td align="center" width="59">
		 <font size="2">数量</font>
		</td>
		
		<td align="center" width="70">
		 <font size="2">订单号</font>
		</td>
		
		<td align="center" width="144">
		 <font size="2">客户</font>
		</td>
		
		<td align="center" width="145">
		 <font size="2">收件人姓名、联系方式、地址、邮编</font>
		</td>
		
		<td align="center" width="114">
		 <font size="2">配送(运费+保费)</font>
		</td>
		
		<td align="center" width="71">
		 <font size="2">本单总价</font>
		</td>
		
		<td align="center" width="71">
		 <font size="2">优惠券（元）</font>
		</td>
		
		<td align="center" width="71">
		 <font size="2">实付金额</font>
		</td>
		
		<td align="center" width="71">
		 <font size="2">发票信息</font>
		</td>
		
		<td align="center" width="82">
		 <font size="2">付款</font><p><font size="2">（日期）</font>
		</td>
		
		<td align="center" width="84">
		 <font size="2">订单状态</font>
		</td>
		
		<td align="center" width="78">
		 <font size="2">快递单号</font><p>
		</td>
		
		<td align="center" width="78">
		 <font size="2">预计发货时间</font><p><font size="2">（日期）</font>
		</td>
		
		<td align="center" height="129" width="200">
			备注
		</td>
		
		<td align="center"  width="85">
		 <font size="2">优惠码</font>
		</td>
		
		<td align="center" height="129" width="75">
		 <font size="2">操作订单</font>
		</td>
		
		<td align="center" height="129" width="75">
			<font size="2">导出委托加工单</font>
		</td>
		
		<td align="center" height="129" width="75">
			<font size="2">导出产品证书</font>
		</td>
	</tr>
	
	<c:forEach items="${list}" var="order" varStatus="sta">
	 <c:if test="${sta.index%2==0}">
	  <tr style="background-color:#e5e5e5; ">
	 </c:if>
	 <c:if test="${sta.index%2!=0}">
	  <tr>
	 </c:if>
		<td align="center" width="123">
		 <font size="2">${order.vdef1}</font>
		</td>
		<td align="center" width="63">
		 <font size="2">${order.vdef2}</font>
		</td>
		<td align="center" width="64">
		 <font size="2">${order.vdef3}</font>
		</td>
		<td align="center" width="59">
		 <font size="2">${order.vdef4}</font>
		</td>
		<td align="center" width="70">
		 <font size="2">${order.order_no}</font>
		</td>
		<td align="center" width="144">
		 <font size="2">${order.username}</font>
		</td>
		<td align="center" width="145">
		 <font size="2">${order.real_name} ${order.mail_address}</font>
		</td>
		<td align="center" width="114">
		 <c:if test="${order.support_fee==null}"><font size="2">(23+0.0)</font></c:if>
		 <c:if test="${order.support_fee!=null}"><font size="2">(23+${order.support_fee})</font></c:if>
		</td>
		<td align="center" width="71">
		 <c:if test="${order.coupon_fee==null}"><font size="2">${order.totalPrice}+0.0</font></c:if>
		 <c:if test="${order.support_fee!=null}"><font size="2">${order.totalPrice}+${order.coupon_fee}</font></c:if>
		</td>
		<td align="center" width="71">
		 <c:if test="${order.coupon_fee==null}"><font size="2">0.0</font></c:if>
		 <c:if test="${order.support_fee!=null}"><font size="2">${order.coupon_fee}</font></c:if>
		</td>
		<td align="center" width="71">
		 <font size="2">${order.totalPrice}</font>
		</td>
		
		<td align="center" width="71">
		 <font size="2">${order.invoice_title} ${order.invoice_content}</font>
		</td>
		<td align="center" width="82">
		 <font size="2">${order.pay_date}</font>
		</td>
		<td align="center" width="84">
		 <font size="2">
		   <c:if test="${order.status=='N'}">未支付</c:if>
		   <c:if test="${order.status=='Y'}">已支付</c:if>
		 </font>
		</td>
		
		<td align="center" width="78">
		 <font size="2">
		 <c:if test="${order.shipping_no==null}">
		  <c:if test="${order.status=='Y'}">
		    <input type="text" class="shippingNo" placeholder="请填写快递单号" /><br />
		  </c:if>
		 </c:if>
		 <c:if test="${order.shipping_no!=null}">
		  <input type="text" class="shippingNo"  value=" ${order.shipping_no}"/><br />
		 </c:if>
		 </font>
		</td>
		<td align="center" width="78">
		 <font size="2">
		  <c:if test="${order.shipping_date==null && order.status=='Y'}">
		    <input class="Wdate" type="text" onClick="WdatePicker()" name="" id="shippingDate" />
		    
		  </c:if>
		   <input class="Wdate" type="text" onClick="WdatePicker()" name="" id="shippingDate"  value="${order.shipping_date}"/>
		 </font>
		</td>
		<td align="center" height="129" width="200">
			
		</td>
		
		<td align="center"  width="85">
		 <font size="2">${order.coupon}</font>
		</td>
		
		<td align="center" height="129" width="75">
		 <c:if test="${order.status=='N'}">
		   <a href="javascript:void(0)" onclick="delOrder(${order.id});">删除</a>
		 </c:if>
		 <c:if test="${order.status=='Y' && order.shipping_no==null}">
		 <a onclick="addShippingDate(${order.id});"  href="javascript:void(0)">保存</a>
		 </c:if>
		 <c:if test="${order.status=='Y' && order.shipping_no!=null}">
		 <a onclick="addShippingDate(${order.id})"  href="javascript:void(0)">修改</a>
		 </c:if>
		</td>
		<td align="center" height="129" width="75">
		 <font size="2">导出委托加工单</font>
		</td>
		<td align="center" height="129" width="75">
		 <font size="2">导出产品证书</font>
		</td>
	</tr>
	<c:if test="${empty order}">
	  <tr ><td align="center" width="500" style="color: red;font-size: 16px;text-align: center;">对不起，没有查询到该订单！！！</td></tr>
	</c:if>
	</c:forEach>
	
	<tr>
		<td colspan="8" height="128" valign="top">
		
		<font size="2">说明：</font><p><font size="2">1 
		未付款订单，则不能标记为产状态，不是在产状态，就不能填写运单号，不进入物流环节则不能标记交易“完成”。</font></p>
		<p><font size="2">2 运费中增加保费，不同的物流公司一般收取2%-5%不等，希望能有个数据库表来存放物流公司的运费和保费数据。</font></p>
		<p><font size="2">3 未付款的订单允许删除</font></p></td>
		<td colspan="13" height="128"  valign="top"  align="right">
		
			<!-- 分页插件  start -->
		    <div id="pager" class="page"  ></div>
	        <!-- 分页插件  end -->
		</td>
	</tr>
</table>
</body>
<script type="text/javascript" src="${ctx }/resources/common/js/jquery.pager.js"></script>
<script type="text/javascript">
//------------------------------分页js start---------------------------------------
    //pagenumber页码，
    //pagecount分页数量，
    //buttonClickCallback点击分页的函数，
    //TotalCount记录总数
    //PageEnter：true 跳页false不跳页
    $("#pager").pager({
      pagenumber: '${dgpage}',
      pagecount: Math.ceil('${total}'/ '${rows}'),
      buttonClickCallback: function (p) {
	      var url = "${ctx }/gemClient/viewOrderList.do";
		  var typeNo = $(".typeNo").val();
		  var start = document.getElementById("startDate").value;
		  var end = document.getElementById("endDate").value;
		  if(p != undefined && p != null && p != ""){
		 		url += "?dgpage="+p;
	 	  }else{
	 		url += "?dgpage=1";
	 	  }
		  if(typeNo != null && typeNo != ""){ 
		 		url += "&typeNo="+typeNo;
		  }
		   if(start != null || start != ""){
		     url += "&startDate="+start;
		   }
		   if(end != null || end != ""){
		     url += "&endDate="+end;
		   }
		
		 	window.location.href= url; 
      },
        TotalCount:'${total}',
        PageEnter: true
    });
//-----------------------------分页js end-------------------------------------
  

</script>
</html>