<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN" style="height: 100%;">
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="../css/loginStyle.css">
<script src="../js/md5.js"></script>
</head>
<body class="body">
	<div class="dowebok a-bounceinT">
		<br>
		<br>
		<br>
		<div id="login" class="form-item">
			<p class="title">天天签到系统</p>
			<br>
			<br>
			<p class="title">登录</p>
		</div>
		<br>
		<div class="form-item">
			<input id="username" type="text" autocomplete="off"
				placeholder="请输入用户名"
				style="background: url(../img/login.png) 20px 14px no-repeat;">
			<p id="p1" class="tip">用户名为空!</p>
		</div>
		<br>
		<div class="form-item">
			<input id="password" type="password" autocomplete="off" placeholder="请输入密码"
				style="background: url(../img/password.png) 20px 14px no-repeat;">
			<p id="p2" class="tip">密码为空!</p>
		</div>
		<br>
		<div class="form-item">
			<p id="forget" class="forget" onclick="location='ForgetPassword.jsp'">忘记密码？</p>
		</div>
		<br>
		<div class="form-item">
			<button id="submit" class="login-btu">登录</button>
		</div>
		<br>
	</div>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>
	<script src="../js/loginScript.js"></script>
	<script>
	$(function(){
		var username = Cookies.get("username");
		var password = Cookies.get("password");
		if(username != ""){
			$("#username").val(username);
		}
		if(password != ""){
			$("#password").val(password);
		}
	})
	
	</script>

</body>
</html>