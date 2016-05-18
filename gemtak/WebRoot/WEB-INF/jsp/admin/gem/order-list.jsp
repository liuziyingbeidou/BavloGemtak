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
   <title>Insert title here</title>
   <script type="text/javascript" src="${ctx}/resources/client/js/My97DatePicker/WdatePicker.js"></script>
   <script type="text/javascript" src="${ctx}/resources/client/js/jquery-1.7.2.min.js"></script>
   <script type="text/javascript">
     
     function selectOrderByType(){
      var typeNo = $(".typeNo").val();
      location.href="${ctx}/gemClient/viewOrderListByType.do?typeNo="+typeNo;
     };
     
     function delOrder(id){
       if(confirm("确定要删除这条数据吗？")){
         location.href="${ctx}/gemClient/delOrderListById.do?id="+id;
       }
     }
     
     function selectOrderByTime(){
      var start = document.getElementById("startDate").value;
      var end = document.getElementById("endDate").value;
      var url = "${ctx}/gemClient/viewOrderListByDate.do?";
      if(start != null || start != ""){
        url += "startDate="+start;
      }
      if(end != null || end != ""){
        url += "&endDate="+end;
      }
      location.href=url;
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
			<input type="button" value="搜索" onclick="selectOrderByType();"/><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
			<input type="button" value="搜索" onclick="selectOrderByTime();"/>
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
		   ${order.shipping_no}
		 </c:if>
		 </font>
		</td>
		<td align="center" width="78">
		 <font size="2">
		  <c:if test="${order.shipping_date==null && order.status=='Y'}">
		    <input class="Wdate" type="text" onClick="WdatePicker()" name="" id="shippingDate" />
		    
		  </c:if>
		  ${order.shipping_date} 
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
		 <c:if test="${order.status=='Y'}">
		 <a onclick="addShippingDate(${order.id});"  href="javascript:void(0)">保存</a>
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
		<p><font size="2">3 未付款的订单允许删除</font></td>
		<td colspan="13" height="128">
		
		<p align="right">
		<c:if test="${pageResult.totalPageTwelve > 1 }">
		<c:if test="${page > 1 }">
		&nbsp;&nbsp;&nbsp; <span onclick="goPage(1)"> &lt;&lt;&nbsp;</span> <span onclick="goPage(${page-1})">&lt;</span>
		</c:if> 
		<c:forEach begin="1" end="${pageResult.totalPageTwelve}" var="i">
				<span onclick="goPage(${i});" style="cursor: pointer;text-decoration: underline;<c:if test="${page==i}">color:red;</c:if>">${i}</span>
		</c:forEach>
		<c:if test="${page < pageResult.totalPageTwelve }">
		<span onclick="goPage(${page+1})">&gt;</span>&nbsp; <span onclick="goPage(${pageResult.totalPageTwelve})">&gt;&gt;</span>
		</c:if>
		</c:if>
		</td>
	</tr>
</table>
</body>
<script type="text/javascript">
/* function goPage(i){
	if(i<1){
		i=1;
	}
	$('#page').val(i);
	$('#form1').submit();
}
function updateProgress(){
	var sid = $(this).attr('sid');
	var progress = $(this).parent().find('select').val();
	$.post('updateProgress',{sid : sid,progress : progress},function(){
		alert('修改成功');
		window.location.reload();
	},'json');
}
function updateStatus(){
	var sid = $(this).attr('sid');
	var status = $(this).parent().find("#orderStatus").val();
	$.post('updateStatus',{sid : sid,status : status},function(){
		alert('修改成功');
		window.location.reload();
	},'json');
}
function updateShoppingNo(){
	var sid = $(this).attr('sid');
	var shippingNo = $(this).parent().find('input[name="shippingNo"]').val();
	if(shippingNo.length!=12){
		alert('运单号为12位');
		return ;
	}
	$.post('updateShoppingNo',{sid : sid,shippingNo : shippingNo},function(){
		alert('修改成功');
		window.location.reload();
	},'json');
}
function sendEmail(){
	var sid = $(this).attr('sid');
	var shoppingNo = $(this).attr('shippingNo');
	if(shoppingNo.length!=12){
		alert('运单号为12位,请修改');
		return ;
	}
	$.post('sendEmail',{sid : sid},function(){
		alert('发送成功');
		window.location.reload();
	},'json');
}
function updateDeliveryDate(){
	var orderId = $(this).attr('orderId');
	var deliveryDate = $(this).parent().find('input[name="deliveryDate"]').val();
	$.post('updateDeliveryDate',{sid : orderId,deliveryDate : deliveryDate},function(){
		alert('修改成功');
		window.location.reload();
	},'json');
}
$(function(){
	$('#form1').submit(function(){
		var type=$('#type').val();
		if(type==1){
			$('#orderNo').val($('#no').val());
		}
		else if(type==3){
			$('#str').val($('#no').val());
		}
		else{
			$('#shippingNo').val($('#no').val());
		}
	});
	
	$('.update').click(function(){
		var id=$(this).attr('orderId');
		var tr=$(this).parent().parent();
		var manufacture=$('input[name="manufacture"]',tr).is(':checked');
		var complete=$('input[name="complete"]',tr).is(':checked');
		var shippingNo=$('input[name="shippingNo"]',tr).val();
		var processingComments=$('textarea',tr).val();
		$.post('update',{
			id:id,
			shippingNo:shippingNo,
			isManufacturing:manufacture,
			complete:complete,
			processingComments:processingComments
			
		},function(){window.location.reload();},'json');
	});
	$(".updateCom").click(function(){
		var id=$(this).attr('orderId');
		var processingComments=$(this).prev().val();
		$.ajax({
				url : 'updateCom',				
				type : 'POST',
				data : {
					id:id,
					processingComments:processingComments
				 },
				dataType : 'json',
				success : function(data, sts) {
					alert("保存成功！");
				}
		});
	})
	$('.importHtml').click(function(){
		var itemId = $(this).attr('itemId');
		window.open('toImportHtml?id='+itemId,'_blank'); 
	});
	
	$('.importCertificate').click(function(){
		var itemId = $(this).attr('itemId');
		window.open('importCertificate?id='+itemId,'_blank'); 
	});
	
	$('.delete').click(function(){
		if(confirm("确定要删除所选数据吗？")){
			var id=$(this).attr('orderId');
			$.post('delete',{
				id:id
			},function(){window.location.reload();},'json');
		}
	});
	
	$('.updateProgress').click(updateProgress);
	$('.updateStatus').click(updateStatus);
	$('.updateShoppingNo').click(updateShoppingNo);
	$('.sendEmail').click(sendEmail);
	$('.updateDeliveryDate').click(updateDeliveryDate); 
});*/
</script>
</html>