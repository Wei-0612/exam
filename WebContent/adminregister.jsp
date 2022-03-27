<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
 <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
  <meta name="author" content="Vincent Garreau" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link rel="stylesheet" media="screen" href="css/style.css">
  <link rel="stylesheet" type="text/css" href="css/reset.css"/>
</head>
<body>
	<div id="particles-js">
	<div class="login">
		<div class="login-top">
		   注册
		</div>
		<form  method="POST" action="adminController?action=add">
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="img/name.png"/></div>
				<div class="login-center-input">
					<input type="text" id="adminname" name="adminname" placeholder="请输入您的姓名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的姓名'" required/>
					<div class="login-center-input-text">姓名</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="img/password.png"/></div>
				<div class="login-center-input">
					<input type="password" id="password" name="password" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'" required/>
					<div class="login-center-input-text">密码</div>
				</div>
			</div>
	        <div class="login-center clearfix">
				<div class="login-center-img"><img src="img/name.png"/></div>
				<div class="login-center-input">
					<input type="password" id="password1" name="password1" placeholder="请确认你的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请确认你的密码'" required/>
					<div class="login-center-input-text">确认密码</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="img/password.png"/></div>
				<div class="login-center-input">
					<input type="text" id="invite" name="invite" placeholder="请输入邀请码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入邀请码'" required/>
					<div class="login-center-input-text">邀请码</div>
				</div>
			</div>
	<div class="login-button">
				<button type="submit">提交</button>
			</div>
		</form>
	</div>
	<div class="sk-rotating-plane"></div>
</div>

<!-- scripts -->
<script type="text/javascript">
	function form_submit(){
		if(check_username($("#username"))){
			var password=$("#password").val();
			$("#password").val(sha1(password));
			$("#register_form").submit();
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
</body>
</html>