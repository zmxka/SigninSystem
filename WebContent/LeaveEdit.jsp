<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>请假审批</title>

<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div>

<table id="mediumBottomTask" class="table table-striped">
            <thead>
              <th class="shipId">用户</th>
              <th class="pointNumber">请假类型</th>
              <th class="pointNumber">请假内容</th>
              <th class="startTime">开始时间</th>
              <th class="endTime">结束时间</th>
              <th class="startTime">提交时间</th>
              <th class="pointNumber">结果</th>
              <th></th>
            </thead>
            <%
				int i = 0;
			%>
            <c:forEach items="${leaveList}" var="leave" varStatus="st">
            <tr>
				<td class="userName"> ${leave.userName}</td>
				<td class="leaveType"> ${leave.leaveType}</td>
				<td class="leaveContent"> ${leave.leaveContent}</td>
				<td class="startTime"> ${leave.startTime}</td>
				<td class="endTime"> ${leave.endTime}</td>
				<td class="recordTime"> ${leave.recordTime}</td>
				<td class="result" id="result-${leave.leaveId}"> ${leave.leaveResult}</td>
				<td class="editTd">
					<button type="button" style="color:green" class="btn btn-default edit" id="approve-${leave.leaveId}">同意</button>
					<button type="button" style="color: red" class="btn btn-default edit" id="reject-${leave.leaveId}">拒绝</button>
				</td>
			</tr>
			</c:forEach>
            <tbody>
            
            </tbody>
</table>

</div>

<script>

$(function(){
	$(".result").each(function(){
		var text = $(this).text();
		console.log(text);
		var color = "";
		if(text === " 已同意"){
			color = "green";
		}else if(text === " 已拒绝"){
			color = "red";
		}
		
		$(this).css("color",color);
	})
})

$(".edit").click(function(){
	
	var id = $(this).attr("id");
	var number = id.split("-")[1];
	var fun = id.split("-")[0];
	var result = "";
	var color;
	
	if (fun == "approve"){
		result = "已同意";
		color = "green";
	}else if(fun == "reject"){
		result = "已拒绝";
		color = "red";
	}
	
	$.post("LeaveEditServlet",
			{
				leaveId : number,
				result  : result
			},
			function(data,status){
				if(data == "1"){
					$("#result-" + number.toString()).text(result);
					$("#result-" + number.toString()).css("color",color);
				}else if(data == "0"){
					alert("网络问题，请稍后重试！");
				}
			})
	
})

</script>
</body>
</html>