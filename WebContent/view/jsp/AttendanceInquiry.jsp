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
<script type="text/javascript">
$(document).ready(function(){
	//这里通过ajax查询到总记录数totalCount
	//设定每页显示记录数pageSize,算出总页数totalPageNum
	$("#sp1").hide();
	var u = "${sessionScope.userId}";
	$.ajax({
		type: "GET",
		data:{
			userId:u
		},
		url: "../../AttendanceInquiryServlet",//请求的后台地址
		success: function(msg){
			pageSize = Number(1);
			number = Number(msg);
			totalPageNum = Number(Math.ceil(number/pageSize));
			js_method(0,totalPageNum);
		}
		});	

	$("#attend").click(function(){
		$.ajax({
			type: "post",
			data:{
				userId:u
			},
			url: "../../SigninServlet",//请求的后台地址
			success: function(msg){
				alert(msg);
			}
			});		
	})
	
})
/**
 * 传入当前页和和总页数
 */
function js_method(currentPageNum,totalPageNum) {
	currentPageNum = Number(currentPageNum);
    var startPageNum = currentPageNum - 2; //起始页
    var endPageNum = currentPageNum + 2; //结束页
    $("#pag").text("") //清空导航条
    if (startPageNum <= 0) {
        startPageNum = 1
        endPageNum = startPageNum + 4
    }
    if (endPageNum > totalPageNum) {
        endPageNum = totalPageNum
        startPageNum = endPageNum - 4
    }

    if (currentPageNum != 1) {
        $("#pag").append(
			"<a href='javascript:void(0);' onclick='js_method(1,"+totalPageNum+")' >首页</a>"
		)
        $("#pag").append(
        "<a href='javascript:void(0);' onclick='js_method($(\".active\").text()-1,"+totalPageNum+")' id='prePageNum'>&laquo;</a>"
		)
    }
    for (var i = 0; i <= endPageNum; i++) {
        if (i >= startPageNum) {

            if (i == currentPageNum) {
                var ele = "<a href='javascript:void(0);' class='active' onclick='js_method($(this).text(),"+totalPageNum+")' >" +
                    i + "</a>"
            } else {
                var ele = "<a href='javascript:void(0);' onclick='js_method($(this).text(),"+totalPageNum+")' >" + i + "</a>"
            }
        }
        $("#pag").append(ele)
    }
    if (currentPageNum != totalPageNum) {
        $("#pag").append(
            "<a href='javascript:void(0);' onclick='js_method(Number($(\".active\").text())+1,"+totalPageNum+")' id='prePageNum' rel='pre'>&raquo;</a>"
        )
		$("#pag").append(
			"<a href='javascript:void(0);' onclick='js_method("+totalPageNum+","+totalPageNum+")' >尾页</a>"
		)
    }
	//在这里通过ajax去查询当前页的数据
	$.ajax({
		type: "GET",
		url: "../../fenyeServlet",//请求的后台地址
		dataType:"JSON",
		data:{
			current:currentPageNum
		},
		success: function(msg){
			$("#sp").html("<table class='table_style table'><tr><th>签到日期</th><th>是否签到</th></tr>"+
	                "<tr><td>"+msg.people[0].time+"</td><td>"+msg.people[0].type+"</td></tr>"+
	                "</table>"); 
		}
		});
}
</script>
<link rel="stylesheet" href="../css/Attendance.css">  
</head>
<body>
	<img src="../img/sign.png" alt="个人签到">
	<button type="button" id="attend" class="u-btn u-btn-c4" style="position:relative;top:85px;left:22px;"> 签到 </button>
	<div class="main">
		<div>
			 <span id="sp"></span>
			 <div class="page" id="pag" align="center">
        		<!--<a href="javascript:void(0);" onclick="js_method($(this).html())">4</a>  -->
    		</div>

		</div>
		<table class='table_style table' id="sp1">
			<tr><th>签到日期</th><th>是否签到</th></tr>
		</table>
	</div>
</body>
</html>
