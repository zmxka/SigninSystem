$("#getYzm").click(function() {
			var x = $("#username").val();
			var y = $("#email").val();
			if (x == "") {
				$("#p0").show();
				$("#p1").hide();
				return;
			} else if(y == ""){
				$("#p0").hide();
				$("#p1").show();
				return;
			} else{
				$("#p0").hide();
				$("#p1").hide();
			}
			$.post("/SigninSystem/Forget",{
				userName : $("#username").val(),
				email : $("#email").val()
			}, function(flag) {
				if (flag == 0) {
					alert('邮件发送失败!');
				} else if (flag == 2) {
					alert('邮件地址与用户名不对应!');
				} else {
					document.getElementById('x').value = flag;
					alert('邮件发送成功!');
				    roof();
					$(this).prop('disabled',true);
					$("#getYzm").attr("class","disYanzheng");
				} 
			})
		});

var times = 60;
function roof(){
    if(times == 0){
        $("#getYzm").text('发送验证码 ('+times+'s)');
        $("#getYzm").prop('disabled',false);
        $("#getYzm").attr("class","yanzheng");
        $("#getYzm").text('发送验证码');
        times = 60;
        return
    }
    $("#getYzm").text('已发送('+times+'s)');
    times--;
    setTimeout(roof,1000);
}


$("#submit").click(function() {
	var x = $("#yanzhengma").val();
	var y = $("#x").val();
	if (x == "") {
		$("#p2").show();
		return;
	} else if(x != y){
		$("#p2").hide();
		alert('验证码错误!');
	} else{
		$("#p2").hide();
		alert('验证成功!');
		location.href="ModifyPassword.jsp";
	}
	
})