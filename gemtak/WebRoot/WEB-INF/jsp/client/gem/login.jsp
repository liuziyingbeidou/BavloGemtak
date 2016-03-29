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
<link href="${ctx }/resources/client/css/login.css" rel="stylesheet">
<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/jquery.js"></script>

<script type="text/javascript">
 $(function (){
  //用户登录
  $(".login").click(function(){
    var uname = $(".input-username").val();
    var pwd = $(".input-pwd").val();
    var url = "www.bavlo.com/gemtak-invoke/register?";
    if(uname != "" && uname != null && pwd != "" && pwd != null ){
      $.post(url,{uname:uname,upwd:pwd},function(data){
       if(data == "用户没找到"){
         alert("你输入的用户名错误！");
       }
       if(data == "密码错误"){
         alert("你输入的密码错误！");
       }
       if(data == "true"){
         location.href = "gemClient/login.do?username="+uname;
       }
      });
    }
  });
 });
</script>

</head>
<body>
<div>
  <jsp:include page="../head.jsp"></jsp:include>
</div>
<div class="tit_all m_bottom_80 conbg">
	  <div class="container">
	       <h2 class="tit_log col-sm-12">登录 | 注册</h2>
			<div class="w_442 col-sm-12 col-md-6">
				<form name="mailBox" id="mailBox" method="post" action="mother.html">
				<h3><span>会员登录</span></h3>
				<div class="side">
					<ul class="word">
						<li><label>E-mail：</label><div class="s_te"><input class="inp_text input-username" type="text" value="" /><b class="error">输入有误</b></div></li>
						<li><label>密码：</label><div class="s_te"><input class="inp_text input-pwd" type="password" value="" /></div></li>
						<li><label>&nbsp;</label><div class="s_te"><span><input class="inp_che" type="checkbox" value=""/>记住密码</span><input class="inp_sub login" type="button" value="登录" /></div></li>
					</ul>
				</form>
					<p class="forget">忘记密码？</p>
					<p>请在下面输入您的Email地址，然后点击“发送”按钮，我们立即把新密码发送到您的邮箱！</p>
					<ul class="word redo">
						<li class="mail"><label>E-mail：</label><div class="s_te"><input class="inp_text" type="text" value="" /></div></li>
						<li><input class="inp_sub" type="submit" value="发送" /></li>
					</ul>
				</div>
			</div>
			<div class="w_442 col-sm-12 col-md-6">
				<h3><span>新用户注册</span></h3>
				<div class="pass">
					<ul class="word">
						<li><label>E-mail：</label><div class="s_te"><input class="inp_text" type="text" value="" /><b class="error">输入有误</b></div></li>
						<li><label>密码：</label><div class="s_te"><input class="inp_text" type="password" value="" /></div></li>
						<li style="margin:0px auto;line-height:20px"><label>&nbsp;</label><div class="s_te">密码最少六个字符</li>
						<li><label>确认密码：</label><div class="s_te"><input class="inp_text" type="password" value="" /></div></li>
						<li><label>验证码：</label><div class="s_te"><input class="inp_text" type="password" style="width:50%" value="" /><img src="" /></div></li>
					</ul>
					
					<ul class="word redo">
						<li class="once"><input class="inp_sub  register" type="submit" value="立即注册" /></li>
					</ul>
				</div>
				
			</div>

	  </div>	  
	</div>
</div>
<div class="footer hidden-xs hidden-sm">
    <jsp:include page="../../admin/foot.jsp"></jsp:include>
</div>
</body>
</html>