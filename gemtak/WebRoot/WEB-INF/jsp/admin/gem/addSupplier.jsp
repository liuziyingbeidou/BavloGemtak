<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String type = request.getParameter("type");
if("edit".equals(type)){
	type = "修改";
}else{
	type = "新增";
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;" />
<title>宝石供应商管理系统</title>
<link rel="stylesheet" href="<%=path %>/resources/admin/css/style.css" type="text/css" media="all" />
<script type="text/javascript" src="<%=path %>/resources/client/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
function check()
{
        var theForm = document.form1;
		var errMsg = "";
		var setfocus = "";
		if (theForm['vsupplierName'].value == "") {
				errMsg = "品牌为空";
				setfocus = "['vsupplierName']";
			}else if (theForm['company'].value == "") {
				errMsg = "公司全称为空";
				setfocus = "['company']";
				errMsg =" 开户人为空";
				setfocus = "['account_holder']";
			}else if (theForm['deposit_bank'].value == "") {
				errMsg =" 开户行为空";
				setfocus = "['deposit_bank']";
			}else if (theForm['card_no'].value == "") {
				errMsg =" 卡号为空";
				setfocus = "['card_no']";
			}
			
		if (errMsg != "") {
			alert(errMsg);
			eval("theForm" + setfocus + ".focus()");
			return true;
		} else
			theForm.submit();	
}

function save(){

	 if(check()){
		return ;
	} 
  var url = "<%=path %>/gemAdmin/saveSupplier.do";
  $.post(url,$('#supplierVO').serialize(),function(data){
	  alert("保存成功！");
	  location.href = "<%=path %>/gemAdmin/viewSupplier.do";
  });
}

</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>
<body class="ContentBody">
  <form id="supplierVO" action="" method="post" name="form1" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" ><%=type %>宝石供应商</th>
  </tr>
  <tr>
    <td class="CPanel">
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		</td></tr>
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend><%=type %>宝石供应商</legend>
				<input name="id" type="hidden" value="${equipment.id}">
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td nowrap align="right" width="11%">品牌:</td>
					    <td width="27%"><input name='vsupplierName' id="shopcode" type="text"  class="text  vsupplierName" style="width:300px" value="${equipment.vsupplierName }" /></td>
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					  </tr>
					  <tr>
					    <td nowrap align="right" width="11%">公司全称:</td>
					    <td width="27%"><input name='company' id="shopcode" type="text" class="text  company"  style="width:300px" value="${equipment.company }" /></td>
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					  </tr>
					  <tr>
					    <td nowrap align="right" width="11%">卡号:</td>
					    <td width="27%"><input name='card_no' id="shopname" type="text" class="text   cardNo" style="width:300px" value="${equipment.card_no }" /></td>
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					  </tr>
					  <tr>
					    <td nowrap align="right" width="11%">开户行:</td>
					    <td width="27%"><input name='deposit_bank' id="shopcode" type="text"  class="text  bank" style="width:300px" value="${equipment.deposit_bank }" /></td>
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					  </tr>
					  <tr>
					    <td nowrap align="right" width="11%">开户人:</td>
					    <td width="27%"><input name='account_holder' id="shopcode" type="text" class="text  holder" style="width:300px" value="${equipment.account_holder }" /></td>
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					  </tr>
					  <tr>
					    <td nowrap align="right" width="11%">地址:</td>
					    <td width="27%"><input name='address' id="shopcode" type="text"  class="text  address" style="width:300px" value="${equipment.address }" /></td>
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					  </tr>
					 <tr>
					    <td width="14%" align="right" nowrap>邮编:</td>
					    <td width="27%"><input name='post' id="shopname" type="text" class="text  post" style="width:300px" value="${equipment.post }" /></td>
					  </tr>
					  </table>
			  <br />
				</fieldset></TD>
		</TR>
		</TABLE>
	 </td>
  </tr>
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="button" onclick="javascript:save()" name="Submit" value="保存" class="button"/>　
			<input type="reset" name="Submit2" value="关闭" class="button" onclick="javascript:window.close()"/></TD>
		</TR>
		</TABLE>
</div>
</form>
</body>
</html>
