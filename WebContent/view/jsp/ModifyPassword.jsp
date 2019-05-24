<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN" style="height: 100%;">
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="../css/ModifyStyle.css">
<script src="../js/md5.js"></script>
</head>
<body class="body">
	<div class="dowebok a-bounceinT">
		<br><br><br><br>
		<div id="login" class="form-item">
			<p class="title">修改密码</p>
		</div>
		<br>
		<br>
		<div class="form-item">
			<input id="pass1" type="password" autocomplete="off"
				placeholder="请输入新的密码"  style="background: url(../img/password.png) 20px 14px no-repeat;">
			<p id="p1" class="tip">请输入合法的密码!</p>
		</div>
		<br>
		<div class="form-item">
			<input id="pass2" type="password" autocomplete="off"
				placeholder="请再输入一次新密码"  style="background: url(../img/password.png) 20px 14px no-repeat;">
			<p id="p2" class="tip">两次输入密码不一致!</p>
		</div>
		<br><br>
		<div class="form-item">
			<button id="submit" class="login-btu">提交</button>
		</div>
		<br>
	</div>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script src="../js/ModifyScript.js"></script>
</body>
</html>