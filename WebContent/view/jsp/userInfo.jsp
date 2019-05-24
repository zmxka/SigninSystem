<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>用户信息</title>

    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">    

    <link rel="stylesheet" href="view/css/grid.css">
    
    <link rel="stylesheet" href="view/css/button.css">
        
    <script type="text/javascript" src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    
</head>
<body>
	<img src="view/img/userInfo.png" alt="个人信息">
	<div class="main" >
		<form class="pure-form pure-form-aligned" action="userInfoServlet" method="POST">
			<fieldset>
				<img src="view/img/change.png" alt="修改" id="img1" class="edit">
			    <div class="pure-control-group" id="name">
			        <label for="name" >姓名</label>
			        <input  type="text" placeholder="Username" value="${uInfo.name}">
			    </div>
			    <div class="pure-control-group"  id="sex">
			        <label for="sex">性别</label>
			        <input type="text" placeholder="sex" value="${sex}">
			    </div>
			    <div class="pure-control-group" id="email">
			        <label for="email">电子邮箱</label>
			        <input  type="text" placeholder="Email Address" value="${uInfo.email}">
			        <input id="email1" type="email" placeholder="Email" name="email">
			    </div>
			    <div class="pure-control-group" id="tel">
			        <label for="tel">联系方式</label>
			        <input  type="text" placeholder="tel" value="${uInfo.telephoneNumber}">
			        <input id="tel1" type="text" placeholder="Phone" name="phone">
			    </div>
			    <button type="submit" id="s1" class="u-btn u-btn-c4" style="position: relative;left: 355px;top:25px">提交</button>
			</fieldset>
		</form>
</div>
	
<script type="text/javascript">
    	$(document).ready(function(){
    		$("#name1").hide();
    		$("#sex1").hide();
    		$("#email1").hide();
    		$("#tel1").hide();
    		$("#department1").hide();
			$("#s1").hide();
		    $("#img1").click(function(){
				$("#name1").show();
				$("#sex1").show();
				$("#email1").show();
				$("#tel1").show();
				$("#s1").show();
			})
});
    	
	</script>
</body>
</html>