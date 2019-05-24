<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN" style="height: 100%;">
<head>
<meta charset="UTF-8">
<title>找回密码</title>
<link rel="stylesheet" type="text/css" href="../css/forgetStyle.css">
</head>
<body class="body">
<input id="x" type="hidden" >
	<div class="dowebok a-bounceinT">
		<br><br><br><br>
		<div id="login" class="form-item">
			<p class="title">找回密码</p>
		</div>
		<br>
		<div class="form-item">
			<input id="username" type="text" 
				placeholder="请输入用户名"  style="background: url(../img/login.png) 20px 14px no-repeat;">
			<p id="p0" class="tip">请输入合法的用户名!</p>
		</div>
		<br>
		<div class="form-item">
			<input id="email" type="text" 
				placeholder="请输入您的邮箱"  style="background: url(../img/login.png) 20px 14px no-repeat;">
			<button id="getYzm" class="yanzheng" >发送验证码</button>
			<p id="p1" class="tip">请输入合法的邮箱地址!</p>
			
		</div>
		<br>
		<div class="form-item">
			<input id="yanzhengma" type="password" autocomplete="off"
				placeholder="请输入验证码"  style="background: url(../img/password.png) 20px 14px no-repeat;">
			<button id="submit" class="submit" >提交</button>
			<p id="p2" class="tip">验证码为空!</p>
		</div>
		<br><br>
		<div class="form-item">
		<p class="forget" onclick="location='Login.jsp'">直接登录？</p>
		</div>
		<br><br>
		<br>
	</div>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script src="../js/ForgetScript.js"></script>
</body>
</html>