$("#submit").click(function() {
	
			var x = $("#username").val();
			var y = $("#password").val();
			var tmp = hex_md5($("#password").val());
			if (x == "" && y == "") {
				$("#p1").show();
				$("#p2").show();
				return;
			} else if (y == "") {
				$("#p1").hide();
				$("#p2").show();
				return;
			} else if (x == "") {
				$("#p2").hide();
				$("#p1").show();
				return;
			} else{
				$("#p1").hide();
				$("#p2").hide();
			}
			
			$.post("/SigninSystem/Login",{
				userName : $("#username").val(),
				password : tmp
			}, function(data) {
				if (data == "2") {
					Cookies.set('username', $("#username").val(), {
						expires : 1
					});
					Cookies.set('password', $("#password").val(), {
						expires : 1
					});
					location.href="../../UserSystem";
				} else if (data == "3") {
					Cookies.set('username', $("#username").val(), {
						expires : 1
					});
					Cookies.set('password', $("#password").val(), {
						expires : 1
					});
					location.href='../../index/index.html';
				} else if (data == "0") {
					alert('用户名不存在!');
				} else if (data == "1") {
					alert('用户名或密码错误!');
				}
			})
		});