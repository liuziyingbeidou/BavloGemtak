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
<link rel="stylesheet" href="${ctx}/resources/client/css/bootstrap.css" />
<link href="${ctx}/resources/client/css/index.css" rel="stylesheet">
<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/jquery.js"></script>

</head>
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
			     <li class="col-xs-4"><span>1</span>购物车</li>
				 <li class="gw_nav_sel col-xs-4"><span>2</span>确认定单</li>
			     <li class="col-xs-4"><span>3</span>成功提交订单</li>
			   </ul>
			  
			</div>     
			 <form action="./finish_order.html" method="post" >
			 <div class="wrap_br wrap_br_d">
				<h2><span>收货人信息</span></h2>	  
				 <ul class="srxx">
				   <li>常用地址</li>
				   <li><input type="radio" name="month"  value="0" checked="checked"/><span>丁力</span>北京市海淀区清华东路17号院29楼</li>
				   <li class="sel"><input  class="s_input" type="radio" name="month"  value="0" checked="checked"/><span>丁力</span>清华东路17号院29号楼B座1003</li>
				 </ul>
				 <ul class="srxx">
						<li>收货人姓名：丁力 </li>
						<li>地区： 北京市 海淀区</li>
						<li>地址：清华东路17号院29号楼B座1003</li>
						<li>邮编：100086 </li>
						<li>座机：010-82830789 </li>
						<li>手机：13810539493 </li>
						<li>E-mail：mtvdb@sina.com</li>
						<li class="del_s"><a href="#" class="btn  btn-lg active" role="button">新 增</a>
<a href="#" class="btn btn-default btn-lg active" role="button">修 改</a><a href="#" class="btn btn-default btn-lg active" role="button">删 除</a></li>
						
				</ul>         
					   <ul class="srxx1">
						  <li><input type="text" class="form-control" placeholder="收货人姓名"></li>
						  <li><select class="form-control">
                                    <option>请选择地区</option>
									<option>华北</option>
									<option>东北</option>
									<option>长江</option>
                              </select>
						  </li>
						  <li><select class="form-control">
									<option>请选择城市</option>
									<option>北京</option>
									<option>上海</option>
									<option>天津</option>
								</select></li>
								<li><select class="form-control">
									<option>请选择城区</option>
									<option>城区</option>
									<option>城外</option>
								</select></li>
						  
						  <li><input  type="text" class="form-control" placeholder="详细地址" /></li>
						  <li><input  type="text" class="form-control" placeholder="邮政编码" /></li>
						  <li><input  type="text" class="form-control" placeholder="固定电话（可不填）" /></li>
						  <li><input  type="text" class="form-control" placeholder="手机号码" /></li>
						  <li><input  type="text" class="form-control" placeholder="E-mail" /></li>
						  <li class="del_s"><a href="#" class="btn btn-8c btn-lg active" role="button">保存</a>
<a href="#" class="btn btn-default btn-lg active" role="button">取 消</a></li>
						  
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
					  <dl class="spqd">
						 <dt><a href=""><img src="${ctx }/resources/client/images/gw1.jpg" width="100%" /></a></dt>
						 <dd><p><b>神话•双鱼座</b></p>
							 <p>数量：<span>1 </span></p>
							 <p>原价：<span>￥3090000</span></p></dd>
						 
						 </dd>
					  </dl>
					  <dl class="spqd br_top" >
						 <dt><a href=""><img src="${ctx }/resources/client/images/gwc1.png" width="100%" /></a></dt>
						 <dd><p><b>神话•双鱼座</b></p>
							 <p>数量：<span>1 </span></p>
							 <p>原价：<span>￥3090000</span></p></dd>
					  </dl>
				   <h2><span>结算信息</span></h2>
					  <div class="jsxx">
						 <p><input class="jsxx_m" type="text"   name="key" value="输入优惠券编码" /><input class="jsxx_b"   type="submit" title="添加" value="添加"/></p>
						 <p class="jsxx_p">订单总金额: ￥2415元</p>
					  </div>
			   </div>
			   <div class="tjdd"><input   type="submit" title="提交订单" value="提交订单"/></div>
			   </form>
	 </div>
  </div>
</div>
<div class="footer hidden-xs hidden-sm">
    <jsp:include page="../../admin/foot.jsp"></jsp:include>
</div>
</body>
</html>