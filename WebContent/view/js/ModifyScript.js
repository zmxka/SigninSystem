$("#submit").click(function() {
			var x = $("#pass1").val();
			var y = $("#pass2").val();
			var tmp = hex_md5($("#pass2").val());
			console.log(tmp);
			if(x == ""){
				$("#p1").show();
				$("#p2").hide();
				return;
			}else if(y != x){
				$("#p2").show();
				$("#p1").hide();
				return;
			}else{
				$("#p1").hide();
				$("#p2").hide();
			}

			$.post("/SigninSystem/Modify",{
				newPassword : tmp
			}, function(flag2) {
				if (flag2) {
					alert('修改成功!');
					location.href="Login.jsp";
				} else {
					alert('修改失败!');
				}
			})
		});