	<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>员工考勤系统</title>
  <link rel="stylesheet" href="view/css/layui.css">
  <script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">员工考勤系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    
    <h2 style="
    float: left;
    margin-left: 46%;
    font-family:微软雅黑;
    color: white;
    font-size: 32px;
    margin-top: 1vh;">
    	欢迎使用
    </h2>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a id="userName1" href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          贤心
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="Logout">注销</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a id="userInfo" href="javascript:;" >个人信息</a>
        </li>
        <li class="layui-nav-item" >
        	<a id="attendance" href="javascript:;">考勤管理</a>
        </li>
        <li class="layui-nav-item">
        	<a id="leave" href="javascript:;" >请假申请</a>
        </li>
        <li class="layui-nav-item">
        	<a id="Approve" href="javascript:;" >请假结果查看</a>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <iframe src="userInfoServlet" style="width: 100%;height: 100%;" id="1"></iframe>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
      Made by Group
  </div>
  
</div>
<script src="view/js/layui/layui.js"></script>
<script type="text/javascript" src="view/js/jquery.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
$(document).ready(function () {
	  $("#userInfo").click(function (e) { 
	  		$('iframe').attr('src','userInfoServlet'); 
	  });
	  $("#attendance").click(function (e) { 
		  $('iframe').attr('src','view/jsp/AttendanceInquiry.jsp'); 
		  });
	  $("#leave").click(function (e) { 
		    $('iframe').attr('src','LeaveRequestServlet'); 
		  });
	  $("#Approve").click(function (e) { 
		    $('iframe').attr('src','view/jsp/LeaveApprovalresults.jsp'); 
		  });
	  $("#userName1").html("<img src=\"http://t.cn/RCzsdCq\" class=\"layui-nav-img\">" + Cookies.get("username"));
	});

</script>
</body>
</html>