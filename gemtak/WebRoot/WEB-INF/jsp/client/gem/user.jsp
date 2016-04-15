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

</head>
<body>
<div>
  <jsp:include page="../head.jsp"></jsp:include> 
</div>
<div class="tit_all m_bottom_80 conbg">
	  <div class="container">
          <div class="inmenu ">
				<h2 class="doname"><a href="./.html">订单记录<font>（2）</font></a></h2>
				<i class="icon-me icon-me1"></i>
		   </div> 
		   <div class="ddjl">
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
					 <li>状态：未支付<a href="">立即支付</a></li>
					</c:if>
					
				 </ul>
				 </c:forEach>	 
				 <dl>
					<dt class="col-xs-3"><a href=""><img src="${ctx }/resources/client/images/gw1.jpg"  /></a></dt>
					<dd class="col-xs-9"><p><b>神话•双鱼座</b></p><p>数量：<span>1 </span></p><p>原价：<span>￥3090000</span></p></dd>
				 </dl>
				 <%-- <dl>
					<dt class="col-xs-3"><a href=""><img src="${ctx }/resources/client/images/gw1.jpg"  /></a></dt>
					<dd class="col-xs-9"><p><b>神话•双鱼座</b></p><p>数量：<span>1 </span></p><p>原价：<span>￥3090000</span></p></dd>
				 </dl> --%>
			   </div>
			    <div class="line "></div>
			   <%-- <div class="user_br">
				 <ul>
					<li>订单号：<b>61818204</b></li>
					<li>下单时间：2013-11-09 17:19</li>
					<li>总金额：￥1685</li>
					<li>状态：已支付</li>	 
				 </ul>
				 <dl>
					<dt class="col-xs-3"><a href=""><img src="${ctx }/resources/client/images/gw1.jpg" width="100%" /></a></dt>
					<dd class="col-xs-9"><p><b>神话•双鱼座</b></p><p>数量：<span>1 </span></p><p>原价：<span>￥3090000</span></p></dd>
				 </dl>
			   </div>  --%>
		   </div>
		   <div class="inmenu ">
				<h2 class="doname"><a href="./.html">收货地址管理</a></h2>
				<i class="icon-me icon-me1"></i>
		   </div>
		   <div class="ddgl">
			   <div class="user_br1">
					 <ul>
						<li>收货人：丁力    </li>
						<li>手机：13810539493</li>
						<li>地址：北京市海淀区清华东路17号院29楼</li>
						<li>邮编：100086    </li>
						<li>座机：010-55669923</li>
					 </ul>
					 <div class="xgdz"><span style="float:left"><input type="checkbox" value="0" name="showFlag" checked=""> 设为默认地址</span><span style="float:right"><a href="">修 改</a><a href="">删 除</a></span></div>			 
			   </div>
			   <div class="user_br1">
					 <ul>
						<li>收货人：丁力    </li>
						<li>手机：13810539493</li>
						<li>地址：北京市海淀区清华东路17号院29楼</li>
						<li>邮编：100086    </li>
						<li>座机：010-55669923</li>
					 </ul>
					 <div class="xgdz"><span style="float:left"><input type="checkbox" value="0" name="showFlag" checked=""> 设为默认地址</span><span style="float:right"><a href="">修 改</a><a href="">删 除</a></span></div>			 
			   </div>
			   <p class="add_new"><a href=""><img src="${ctx }/resources/client/images/add.png"  />添加新地址</a></p>
			   <div class="ddgl"> 
				   <form action="" method="post" > 
					   <ul class="add_new1">
						  <li><input  type="text"   name="key" value="收货人姓名" /></li>
						  <li><select>
									<option>请选择地区</option>
									<option>华北</option>
									<option>东北</option>
									<option>长江</option>
								</select></li>
								<li><select>
									<option>请选择城市</option>
									<option>北京</option>
									<option>上海</option>
									<option>天津</option>
								</select></li>
								<li><select>
									<option>请选择城区</option>
									<option>城区</option>
									<option>城外</option>
								</select></li>
						  
						  <li><input  type="text"   name="key" value="详细地址" /></li>
						  <li><input  type="text"   name="key" value="邮政编码" /></li>
						  <li><input  type="text"   name="key" value="固定电话（可不填）" /></li>
						  <li><input  type="text"   name="key" value="手机号码" /></li>
						  <li><input  type="text"   name="key" value="E-mail" /></li>
						  <li class="del_s"><a href="">取 消</a><a href="">保 存</a></li>
					   </ul>
					 </form>
				</div>
			 </div>	
				<div class="inmenu ">
					<h2 class="doname"><a href="./.html">修改地址</a></h2>
					<i class="icon-me icon-me1"></i>
				</div>
					<div class="ddgl"> 
					   <form action="" method="post" > 
						   <ul class="add_new1 m_top">
							  <li><input  type="text"   name="key" value="原密码" /></li>
							  <li><input  type="text"   name="key" value="新密码" /></li>
							  <li><input  type="text"   name="key" value="确认密码" /></li>
							  <li class="del_s"><a href="">取 消</a><a href="">保 存</a></li>
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