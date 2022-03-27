
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
<meta name="description" content="particles.js is a lightweight JavaScript library for creating particles." />
<meta name="author" content="Vincent Garreau" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" media="screen" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
</head>
<body>
<div id="particles-js">
	<div class="login">
	<h2 align="center">监考信息管理系统</h2>
		<div class="login-top">
			登录
		</div>
		
<form method="POST" action="login">
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="img/name.png"/></div>
				<div class="login-center-input">
					<input type="text" id="username" name="username" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'" required/>
					<div class="login-center-input-text">用户名</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="img/password.png"/></div>
				<div class="login-center-input">
					<input type="password" id="password" name="password" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'" required/>
					<div class="login-center-input-text">密码</div>
				</div>
			</div>
	   <div class="login-button">
		<button type="submit" name ="login">登录</button>&nbsp;&nbsp;&nbsp;<a href="adminController?action=register">注册</a>
			</div>
	<!-- scripts -->
<script type="text/javascript">
	function form_submit(){
		if(check_username($("#username"))){
			var password=$("#password").val();
			$("#password").val(sha1(password));
			$("#login_form").submit();
		}
	}
	function check_username(username){
		if(username.val() == ""){
			alert("用户名不能为空！");
			return false;
		}
		return true;
	}
</script>
<script src="js/particles.min.js"></script>
<script src="js/app.js"></script>
<script src="js/encrypt.js"></script>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	</form>
</body>
</html>
