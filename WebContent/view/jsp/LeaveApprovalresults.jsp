<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/button.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="../css/Attendance.css">  
</head>
<body>
	<div class="main">
			<span id="result"></span>

	</div>
	
	
	<script type="text/javascript">
$(document).ready(function(){
	//这里通过ajax查询到总记录数totalCount
	//设定每页显示记录数pageSize,算出总页数totalPageNum
	$("#sp1").hide();
	var u = "${sessionScope.userId}";
	$.ajax({
		type: "POST",
		dataType:"JSON",
		data:{
			userId:u
		},
		url: "../../ApprovalResults",//请求的后台地址
		success: function(msg){
			$("#result").html("<table class='table_style table' id='sp1'>"+
					"<tr><th>请假时间</th><th>请假开始</th><th>请假结束</th><th>审批结果</th></tr>"+
	                "<tr><td>"+msg.leave.recordTime+"</td><td>"+msg.leave.startTime+"</td><td>"
	                +msg.leave.endTime+"</td><td>"+msg.leave.result+"</td></tr>"+"</table>"
	           ); 
		}
		});	
})

</script>
</body>
</html>
