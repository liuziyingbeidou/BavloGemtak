<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>宝石供应商管理系统</title>
<script type="text/javascript" src="<%=path %>/resources/client/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/admin/js/blbasejs.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>
<link rel="stylesheet" href="<%=path %>/resources/admin/css/css.css" type="text/css"></link>
<script type="text/JavaScript">

</script>
<style type="text/css">
<!--
.STYLE1 {color: #FF0000}
.menu{
	font-family: "宋体";
	font-size:14px;
	float:right;
}
.menu-btn{
	cursor: pointer;
}
-->
</style>
<link rel="stylesheet" href="<%=path %>/resources/admin/css/style.css" type="text/css"></link>
</head>
<SCRIPT language=JavaScript>

//新增供应商联系人
function add(){
    var equipmentId = $(".supplierid").attr("value");
   	var url = "/gemtak/gemAdmin/addLinkman.do?equipmentId="+equipmentId+"&type=add&";//
	winOpen(url);
}

//修改供应商联系人
function editLinkman(id){
    var equipmentId = $(".supplierid").attr("value");
   	var url = "/gemtak/gemAdmin/addLinkman.do?id="+id+"&equipmentId="+equipmentId+"&type=edit&";//
	winOpen(url);
}

//删除供应商联系人
function delLinkman(id){
	if(confirm('确定要删除?')){
		//method!delpattern?id=${bean.id}
		$.ajax({
	     type : "POST",
	     url : "/gemtak/gemAdmin/delLinkman.do?id="+id,
	     async:false,
	     cache:false,
	     success : function(data) {
	        var flag = data.msg;
	        if(flag == "Y"){
	           alert("删除成功！");
	        }
	    	window.location.reload();
	     },
	     error : function(e) {
	     	alert("删除失败");
	     }
	    });
	}
}


</SCRIPT>

<body>
<form name="fom" id="fom" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="../images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td style="display: none" width="24"><img src="../images/ico07.gif" width="20" height="18" /></td>
			<td width="519"></td>	
		  </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="linkman">
          <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0"  >
          	 <tr style="display: none">
               <td height="20"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
		           <input name="Submit" type="button" class="right-button08" value="删除所选类型" />
				   <input name="button" type="button" class="right-button08" value="添加记录" onclick="javascript:location.href='method!addshop'"/>
	              </td>
          </tr>
              <tr>
                <td height="40" class="font42">
                   <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					<tr>
                    <td height="100" colspan="10" align="center" bgcolor="#EEEEEE"class="tablestyle_title">宝石供应商联系人信息列表 &nbsp;
                    <span class="menu"> 
                    	【<a onclick="javascript:add()" class="menu-btn">新增</a>】 &nbsp;
                    </span>
                    </td>
                    </tr>
                  <tr>
                    <td width='4%' align='center' bgcolor='#EEEEEE'>编号</td>
				    <td width='4%' align='center' bgcolor='#EEEEEE'>联系人</td>
				    <td width='10%' height='20' align='center' bgcolor='#EEEEEE'>企业号账号</td>
                    <td width='10%' align='center' bgcolor='#EEEEEE'>个人微信号</td>
                     <td width='10%' align='center' bgcolor='#EEEEEE' >邮箱</td>
                    <td width='10%' align='center' bgcolor='#EEEEEE'>QQ</td>
                    <td width='10%' align='center' bgcolor='#EEEEEE'>手机</td>
                    <td width='10%' align='center' bgcolor='#EEEEEE'> 座机</td>
                    <td width='10%' align='center' bgcolor='#EEEEEE'>地址</td>
                    <td width='10%' align='center' bgcolor='#EEEEEE'>操作</td>
                  </tr>
                  <c:forEach items="${linkmanList}" var="bean" varStatus="status">
                  <tr>
				    <td bgcolor="#FFFFFF"><div align="center">
				      ${status.index + 1 }
				      </div></td>
				   <td height='20' bgcolor='#FFFFFF'><div align='center'>
					  ${bean.lname}
					</div></td>
					<td height='20' bgcolor='#FFFFFF' align='center'><div align='center' class='STYLE1  companyid'  >${bean.supplier}</div></td>
					 <td height='20' bgcolor='#FFFFFF' align='center'><div align='center'  class='STYLE1'>${bean.wxcode}</div></td>
					<td height='20' bgcolor='#FFFFFF' align='center'><div align='center'  class='STYLE1'>${bean.email}</div></td>
					<td height='20' bgcolor='#FFFFFF' align='center'><div align='center'  class='STYLE1'>${bean.qq}</div></td>
                    <td height='20' bgcolor='#FFFFFF' align='center'><div align='center'  class='STYLE1'>${bean.phone}</div></td>
                    <td height='20' bgcolor='#FFFFFF' align='center'><div align='center'  class='STYLE1'>${bean.tel}</div></td>
                    <td height='20' bgcolor='#FFFFFF' align='center'><div align='center'  class='STYLE1'>${bean.address}</div></td>
                    <td bgcolor='#FFFFFF'><div align='center'><a onclick='javasctipt:editLinkman(${bean.id})' href='javascript:void(0)'>修改</a> | <a onclick='javasctipt:delLinkman(${bean.id})' href='javascript:void(0)'>删除</a></div></td>
                  </tr>
                  </c:forEach>
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <input type="hidden"  class="supplierid"  value="${id }"/>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33">
          
          ${pagerinfo }
          </td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
</body>
</html>