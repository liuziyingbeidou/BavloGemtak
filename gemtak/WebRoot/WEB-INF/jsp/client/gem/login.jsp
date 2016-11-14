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
<title>Gemtak登录页面</title>
<link rel="stylesheet" href="${ctx }/resources/client/css/bootstrap.css" />
<link rel="stylesheet" href="${ctx }/resources/client/css/files/loaders.css" type="text/css"></link>
<link href="${ctx }/resources/client/css/index.css" rel="stylesheet">
<link href="${ctx }/resources/client/css/login.css" rel="stylesheet">
<script language="javascript" type="text/javascript" src="${ctx }/resources/client/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/common/js/jquery_cookie.js"></script>
<style type="text/css">
 .yemianyanchi{
 	text-align: center;
 }
 </style>
<script type="text/javascript">
 $(function (){
  $(".yemianyanchi").show();
  //用户登录
  refush('authcodeimg');
  $(".login").click(function(){
    var uname = $(".input-username").val();
    var pwd = $(".input-pwd").val();
    var status = $(".addpwd").is(':checked');
    var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var url = "${ctx }/gemClient/loginSuccess.do";
    if(uname == "" || uname == null){
       $(".name-error").text("请输入E-mail！！");
       return false;
    }else if (!filter.test(uname)){
       $(".name-error").text("输入的E-mail格式不正确！！");
       return false;
    }else if(pwd == "" || pwd == null){
       $(".name-error").text("");
       $(".pwd-error").text("请输入密码！！");
       return false;
    }else{
      $(".name-error").text("");
      $(".pwd-error").text("");
    }
    if(uname != "" || uname != null && pwd != "" || pwd != null ){
      $.post(url,{uname:uname,upwd:pwd,status:status},function(data){
        //data = $.parseJSON(data);
        if(data == "true"){
        	//登录成功处理...
        	var number = "${dengluNo}";  //默认dengluNo为 1 
        	if(number == "1"){
        	 //location.href = "${ctx}/gemClient/goToList.do?uname="+uname;
        	 location.href = "${ctx}/gemClient/viewGemList.do";
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
        	$(".pwd-error").text("您输入的密码错误！！");
        }
      });
    }
  });
  $(".yemianyanchi").hide();
 });
 
 //用户注册
 $(function(){
   $(".register").click(function(){
   var reguname = $(".reg-uname").val();
   var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
   if(reguname == ""|| reguname == null){
     $(".errorname").empty();
     $(".errorname").append("<label>&nbsp;</label><div class='s_te '>E-mail不能为空！</div>");
     return false;
   }else if (!filter.test(reguname)){
     $(".errorname").empty();
     $(".errorname").append("<label>&nbsp;</label><div class='s_te '>您的E-mail格式不正确!</div>");
	return false;
   }else{
      $(".errorname").empty();
   }
		 
   
   var regpwd = $(".reg-pwd").val();
   if(regpwd == ""|| regpwd == null){
     $(".errorpwd").empty();
     $(".errorpwd").append("<label>&nbsp;</label><div class='s_te '>密码不能为空！</div>");
     return false;
   }else if(regpwd.length < 6){
     $(".errorpwd").empty();
     $(".errorpwd").append("<label>&nbsp;</label><div class='s_te '>密码最少六个字符！</div>");
     return false;
   }else{
      $(".errorpwd").empty();
   }
   var regrpwd = $(".reg-rpwd").val();
   if(regrpwd == ""|| regrpwd == null){
     $(".errorcpwd").empty();
     $(".errorcpwd").append("<label>&nbsp;</label><div class='s_te '>请确认密码！</div>");
     return false;
   }else{
     $(".errorcpwd").empty();
   }
   if(regrpwd != regrpwd){
     $(".errorcpwd").empty();
     $(".errorcpwd").append("<label>&nbsp;</label><div class='s_te '>两次输入的密码不相同！</div>");
     return false;
   }else{
     $(".errorcpwd").empty();
   }
   var regauthcode = $(".reg-authcode").val();
   if(regauthcode == ""|| regauthcode == null){
     $(".errorauthcode").empty();
     $(".errorauthcode").append("<label>&nbsp;</label><div class='s_te '>请输入验证码！</div>");
     return false;
   }else{
     $(".errorauthcode").text("");
   }
   var url = "${ctx }/gemClient/registerSuccess.do";
   $.post(url,{uname:reguname,upwd:regpwd,regauthcode:regauthcode},function(data){
       var flag = data;
       if(flag == "error1"){
         $(".errorname").empty();
         $(".errorname").append("<label>&nbsp;</label><div class='s_te '>该E-mail已被注册！</div>");
       }else if(flag == "true"){
         $(".errorname").empty();
         $(".errorname").append("<label>&nbsp;</label><div class='s_te '>恭喜您，注册成功！</div>");
       }
   });
   });
   
   //登录切换
   $(".menu-normal").click(function(){
   	$(this).css({"color":"red","font-weight":"bold"});
   	$(".menu-busi").css({"color":"#777","font-weight":"normal"});
   	$(".sign-busi").hide();
   	$(".sign-normal").show();
   });
   $(".menu-busi").click(function(){
   $(this).css({"color":"red","font-weight":"bold"});
   	$(".menu-normal").css({"color":"#777","font-weight":"normal"});
   	$(".sign-busi").show();
   	$(".sign-normal").hide();
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
  var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  if(email == ""|| email == null){
     $(".error11").text("E-mail不能为空！");
     return false;
   }else if (!filter.test(email)){
     $(".error11").text("您的E-mail格式不正确!");
		 return false;
   }
  var url = "${ctx }/gemClient/forgetpwd.do";
  $.post(url,{email:email},function(data){
   if(data == "true"){
    alert("新密码已发送至你的邮箱！");
   }
  });
 });
 });
 
 

</script>
 <link  rel="shortcut icon" href="../favicon.ico"/>
</head>
<body>
<div>
  <jsp:include page="../head.jsp"></jsp:include>
</div>
<div class="tit_all m_bottom_80 conbg">
	  <div class="container">
	       <h2 class="tit_log col-sm-12">登录 | 注册</h2>
	        <div class="loader yemianyanchi" style="display: none;">
		        <div class="loader-inner ball-pulse-rise">
		          <div></div>
		          <div></div>
		          <div></div>
		          <div></div>
		          <div></div>
		        </div>
		    </div>
			<div class="w_442 col-sm-12 col-md-6">
				<form name="mailBox" id="mailBox" method="post" action="mother.html">
				<h3><span>会员登录</span></h3>
				<div class="side">
					<ul class="word sign-normal">
						<li><label>E-mail：</label><div class="s_te"><input class="inp_text input-username" type="text" value="" /><b class="error name-error"></b></div></li>
						<li><label>密码：</label><div class="s_te"><input class="inp_text input-pwd" type="password" value="" /><b class="error pwd-error"></b></div></li>
						<li><label>&nbsp;</label><div class="s_te"><span><input class="inp_che " id="remember" type="checkbox" value=""/>记住密码</span><input class="inp_sub login" type="button" value="登录" /></div></li>
					</ul>
				</form>
					<p class="forget">忘记密码？</p>
					<p>请在下面输入您的Email地址，然后点击“发送”按钮，我们立即把新密码发送到您的邮箱！</p>
					<ul class="word redo">
						<li class="mail"><label>E-mail：</label><div class="s_te"><input class="inp_text findPwd" type="text" value="" /></div></li>
						<li style="margin:0px auto;line-height:20px;color: red;"><label>&nbsp;</label><div class="s_te error11"></div></li>
						<li><input class="inp_sub forgetpassword" type="button" value="发送" /></li>
					</ul>
				</div>
			</div>
			<div class="w_442 col-sm-12 col-md-6">
				<h3><span>新用户注册</span></h3>
				
				<div class="pass">
					<ul class="word">
						<li><label>E-mail：</label><div class="s_te"><input class="inp_text reg-uname" type="text" value="" /><b class="error "></b></div></li>
						<li style="margin:0px auto;line-height:20px;color: red;" class="errorname"></li>
						<li><label>密码：</label><div class="s_te"><input class="inp_text reg-pwd" type="password" value="" /><b class="error "></b></div></li>
						<li style="margin:0px auto;line-height:20px;color: red;" class="errorpwd"></li>
						<li><label>确认密码：</label><div class="s_te"><input class="inp_text reg-rpwd" type="password" value="" /><b class="error "></b></div></li>
						<li style="margin:0px auto;line-height:20px;color: red;" class="errorcpwd"></li>
						<li><label>验证码：</label><div class="s_te"><input class="inp_text reg-authcode" type="password" style="width:50%" value="" />&nbsp;<img src="" class="authcodeimg" onclick="refush('authcodeimg')"/><b class="error"></b></div></li>
						<li style="margin:0px auto;line-height:20px;color: red;" class="errorauthcode"></li>
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