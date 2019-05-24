<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	    <%@ taglib uri="My" prefix="mytag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${path}view/css/LeaveRequest.css">
<script src="view/js/jquery1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="${path }view/css/buttons.css">
<link rel="stylesheet" href="view/css/button.css">  
<link href="http://cdn.bootcss.com/twitter-bootstrap/2.2.2/css/bootstrap.min.css" rel="stylesheet">
<script>	  
//这里代码多了几行，但是不会延迟显示，速度比较好，格式可以自定义，是理想的时间显示
	setInterval("fun(show_time)", 1)
	function fun(timeID) {
		var date = new Date(); //创建对象  
		var y = date.getFullYear(); //获取年份  
		var m = date.getMonth() + 1; //获取月份  返回0-11  
		var d = date.getDate(); // 获取日  
		var w = date.getDay(); //获取星期几  返回0-6   (0=星期天) 
		var ww = ' 星期' + '日一二三四五六'.charAt(new Date().getDay());//星期几
		var h = date.getHours(); //时
		var minute = date.getMinutes() //分
		var s = date.getSeconds(); //秒
		if (m < 10) {
			m = "0" + m;
		}
		if (d < 10) {
			d = "0" + d;
		}
		if (h < 10) {
			h = "0" + h;
		}

		if (minute < 10) {
			minute = "0" + minute;
		}

		if (s < 10) {
			s = "0" + s;
		}
		document.getElementById(timeID.id).innerHTML = y + "-" + m + "-" + d
				+ "   " + h + ":" + minute + ":" + s + "." + "  " + ww;
		//document.write(y+"-"+m+"-"+d+"   "+h+":"+minute+":"+s);  
	}
	
</script>

</head>
<body onload="getNowDate()">
	<img src="view/img/leaveRequest.png" alt="请假申请" style="position: relative;left:-320px">
	<div class="time">
		<p id="show_time"></p>
	</div>
	 
	<div class="leave">
	<form action="LeaveRequestServlet" method="POST">
		<p>开始时间--结束时间</p>
			<input type="date" value=""  name="startTime" class="span3"/>
			<input type="date" value=""  name="endTime" class="span3"/>
			<br><br>
			<p>请假类型:</p>
				<mytag:counter/>
				<br><br>
			<p>请假原因:</p>
			<textarea name="message" style="height: 100px;width: 300px"></textarea>
			<br/>
			<button type="submit" class="u-btn u-btn-c4">申请</button>
	</form>
	</div>
</body>
</html>