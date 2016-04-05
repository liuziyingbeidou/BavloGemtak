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
<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/common/js/jquery_cookie.js"></script>
<script type="text/javascript">
 $(function (){
  //用户登录
  refush('authcodeimg');
  $(".login").click(function(){
    var uname = $(".input-username").val();
    var pwd = $(".input-pwd").val();
    var status = $(".addpwd").is(':checked');
    var url = "${ctx }/gemClient/loginSuccess.do";
    if(uname != "" && uname != null && pwd != "" && pwd != null ){
      $.post(url,{uname:uname,upwd:pwd,status:status},function(data){
        //data = $.parseJSON(data);
        if(data == "true"){
        	//登录成功处理...
        	var number = "${dengluNo}";  //默认dengluNo为 1
        	if(number == "1"){
        	 location.href = "${ctx}/gemClient/goToList.do?uname="+uname;
        	}else if(number == "2"){
        	 /* window.parent.location.reload(); */
        	 window.parent.closeMwin(uname);  //closeMwin()在detaile.jsp 将用户名作为参数
        	} 
        	//登录成功 将用户名和密码保存到cookie中
        	if($("#remember").is(':checked')){
        	 $.cookie('username',$(".input-username").val(),{path:'/',expires:30});
        	 $.cookie('password',$(".input-pwd").val(),{path:'/',expires:30});
        	}else{
        	 $.cookie('username',null,{path:'/'});
        	 $.cookie('password',null,{path:'/'});
        	}
        }else{
        	alert("密码错误！！");
        }
      });
    }
  });
 });
 
 //用户注册
 $(function(){
   $(".register").click(function(){
   var reguname = $(".reg-uname").val();
   if(reguname == ""|| reguname == null){
     $(".errorname").text("E-mail不能为空！");
   }
   var regpwd = $(".reg-pwd").val();
   if(regpwd == ""|| regpwd == null){
     $(".errorpwd").text("密码不能为空！");
     return;
   }
   var regrpwd = $(".reg-rpwd").val();
   if(regrpwd == ""|| regrpwd == null){
     $(".errorcpwd").text("请确认密码！");
     return;
   }
   if(regrpwd != regrpwd){
     $(".errorcpwd").text("两次输入的密码不相同！");
     return;
   }
   var regauthcode = $(".reg-authcode").val();
   if(regauthcode == ""|| regauthcode == null){
     $(".errorauthcode").text("请输入验证码！");
     return;
   }
   var url = "${ctx }/gemClient/registerSuccess.do";
   $.post(url,{uname:reguname,upwd:regpwd,regauthcode:regauthcode},function(data){
       var flag = data;
       if(flag == "error1"){
         alert("该用户名已被注册！");
       }else if(flag == "error2"){
         alert("该用户名已被注册！");
       }else if(flag == "true"){
         alert("恭喜您，注册成功！");
       }
   });
   });
 });
 
 //生成验证码
 function refush(obj){
 $("."+obj).attr('src','${ctx}/gemClient/imgValidate.do?'+Math.random());
 };
 
 //记住密码
 $(function(){
  if($.cookie('username')){
   $(".input-username").val($.cookie('username'));
  }
  if($.cookie('password')){
   $(".input-pwd").val($.cookie('password'));
   $("#remember").attr('checked','checked');
  }
   //忘记密码
 $(".forgetpassword").click(function(){
  var email = $(".findPwd").val();
  var url = "${ctx }/gemClient/forgetpwd.do";
  $.post(url,{email:email},function(data){
   if(data == "true"){
    alert("新密码已发送至你的邮箱！");
   }
  });
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
						<li><label>E-mail：</label><div class="s_te"><input class="inp_text input-username" type="text" value="" /><b class="error"></b></div></li>
						<li><label>密码：</label><div class="s_te"><input class="inp_text input-pwd" type="password" value="" /></div></li>
						<li><label>&nbsp;</label><div class="s_te"><span><input class="inp_che " id="remember" type="checkbox" value=""/>记住密码</span><input class="inp_sub login" type="button" value="登录" /></div></li>
					</ul>
				</form>
					<p class="forget">忘记密码？</p>
					<p>请在下面输入您的Email地址，然后点击“发送”按钮，我们立即把新密码发送到您的邮箱！</p>
					<ul class="word redo">
						<li class="mail"><label>E-mail：</label><div class="s_te"><input class="inp_text findPwd" type="text" value="" /></div></li>
						<li><input class="inp_sub forgetpassword" type="button" value="发送" /></li>
					</ul>
				</div>
			</div>
			<div class="w_442 col-sm-12 col-md-6">
				<h3><span>新用户注册</span></h3>
				
				<div class="pass">
					<ul class="word">
						<li><label>E-mail：</label><div class="s_te"><input class="inp_text reg-uname" type="text" value="" /><b class="error errorname"></b></div></li>
						<li><label>密码：</label><div class="s_te"><input class="inp_text reg-pwd" type="password" value="" /><b class="error errorpwd"></b></div></li>
						<li style="margin:0px auto;line-height:20px"><label>&nbsp;</label><div class="s_te">密码最少六个字符</li>
						<li><label>确认密码：</label><div class="s_te"><input class="inp_text reg-rpwd" type="password" value="" /><b class="error errorcpwd"></b></div></li>
						<li><label>验证码：</label><div class="s_te"><input class="inp_text reg-authcode" type="password" style="width:50%" value="" />&nbsp;<img src="" class="authcodeimg" onclick="refush('authcodeimg')"/><b class="error errorauthcode"></b></div></li>
					</ul>
					
					<ul class="word redo">
						<li class="once"><input class="inp_sub  register" type="button" value="立即注册" /></li>
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