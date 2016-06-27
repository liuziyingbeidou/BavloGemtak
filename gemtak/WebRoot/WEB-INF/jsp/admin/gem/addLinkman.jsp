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
	    if (theForm['name'].value == "") {
				errMsg = "联系人姓名";
				setfocus = "['name']";
			}else if (theForm['supplier'].value == "") {
				errMsg = "企业号账号";
				setfocus = "['supplier']";
			}else if (theForm['wxcode'].value == "") {
				errMsg = "微信号为空";
				setfocus = "['wxcode']";
			}else if (theForm['email'].value == "") {
				errMsg = "邮箱为空";
				setfocus = "['email']";
			}else if (theForm['email'].value == "") {
				errMsg = "QQ为空";
				setfocus = "['qq']";
			}else if (theForm['phone'].value == "") {
				errMsg = "手机号为空";
				setfocus = "['phone']";
			}else if (theForm['tel'].value == "") {
				errMsg = "座机号为空";
				setfocus = "['tel']";
			}else if (theForm['address'].value == "") {
				errMsg = "地址为空";
				setfocus = "['address']";
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
  var url = "<%=path %>/gemAdmin/saveLinkman.do";
  $.post(url,$('#linkmanVO').serialize(),function(data){
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
  <form id="linkmanVO" action="" method="post" name="form1" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" ><%=type %>宝石供应商联系人</th>
  </tr>
  <tr>
    <td class="CPanel">
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		</td></tr>
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend><%=type %>宝石供应商联系人</legend>
				<input name="id" type="hidden" value="${linkman.id}">
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td nowrap align="right" width="11%">联系人姓名:</td>
					    <td width="27%"><input name=''name id="shopcode" type="text"  class="text  supplier" style="width:300px" value="${linkman.supplier}" /></td>
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					  </tr>
					  <tr>
					    <td nowrap align="right" width="11%">企业号账号:</td>
					    <td width="27%"><input name='supplier' id="shopcode" type="text"  class="text  supplier" style="width:300px" value="${linkman.supplier}" /></td>
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					  </tr>
					  <tr>
					    <td nowrap align="right" width="11%">微信号:</td>
					    <td width="27%"><input name='wxcode' id="shopcode" type="text"  class="text   wxcode" style="width:300px" value="${linkman.wxcode }" /></td>
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					  </tr>
					  <tr>
					    <td nowrap align="right" width="11%">邮箱:</td>
					    <td width="27%"><input name='email' id="shopcode" type="text"  class="text  qq" style="width:300px" value="${linkman.email }" /></td>
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					  </tr>
					  <tr>
					    <td nowrap align="right" width="11%">QQ:</td>
					    <td width="27%"><input name='qq' id="shopcode" type="text"  class="text  qq" style="width:300px" value="${linkman.qq }" /></td>
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					  </tr>
					  <tr>
					    <td nowrap align="right" width="11%">手机:</td>
					    <td width="27%"><input name='phone' id="shopcode" type="text"  class="text  phone" style="width:300px" value="${linkman.phone }" /></td>
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					  </tr>
					  <tr>
					    <td nowrap align="right" width="11%">座机:</td>
					    <td width="27%"><input name='tel' id="shopcode" type="text" class="text  tel" style="width:300px" value="${linkman.tel }" /></td>
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					  </tr>
					  <tr>
					    <td nowrap align="right" width="11%">地址:</td>
					    <td width="27%"><input name='address' id="shopcode" type="text"  class="text  address" style="width:300px" value="${linkman.address }" /></td>
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					  </tr>
					 <tr>
					    <td width="14%" align="right" nowrap>邮编:</td>
					    <td width="27%"><input name='post' id="shopname" type="text" class="text  post" style="width:300px" value="${linkman.post }" /></td>
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
