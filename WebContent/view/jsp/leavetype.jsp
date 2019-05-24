<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.group.entity.*,java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>网上考勤系统</title>
<link rel="stylesheet" href="../css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="../css/adminlte.min.css" type="text/css">
<link rel="stylesheet" type="text/css" href="../css/public.css">
</head>

<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<div>
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="text-dark">请假类型设置</h1>
						</div>
						<div class="col-sm-6">
							<button type="button"
								class="btn btn-primary btn-flat pull-right btn-groupform margin-r-5"
								data-toggle="modal" data-target="#approval" onclick="add()">新增类型</button>
						</div>
					</div>
				</div>
			</div>
			<div class="container-fluid">
				<div class="card">
					<div class="card-body table-responsive p-0">
						<table class="table text-center">
							<tbody>
								<tr>
									<th class="text-center"
										style="width: 140px; padding: .75rem 0 !important;">id</th>
									<th>请假类型</th>
									<th>操作</th>
								</tr>
								<c:forEach var="item" items="${leaveytpeinfos}"
									varStatus="status">
									<tr>
										<td class='text-center'
											style='width: 140px; padding: .75rem 0 !important;'>${item.leaveid}</td>
										<td>${item.leaveType}</td>
										<td>
											<button type="button" class="btn btn-primary btn-flat btn-xs"
												onclick="modifytype('${item.leaveid}');">修改</button>
											<button type="button" class="btn btn-danger btn-flat btn-xs"
												onclick="deletetype('${item.leaveid}');">删除</button>
										</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="../js/jquery.min.js" type="text/javascript"></script>
	<script src="../js/bootstrap.bundle.min.js" type="text/javascript"></script>
	<script src="../js/adminlte.js" type="text/javascript"></script>
	<script type="text/javascript" src="../js/bootstrap-datetimepicker.js"
		charset="UTF-8"></script>
	<script type="text/javascript"
		src="../js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
</body>

<script>
	function modifytype(id) {
		var x = prompt("输入想要更改的类型: ", "1111111111");/*第一个变量为提示语，第二个变量为默认初始值*/
		var r = confirm("你确定要将这个请假类型更改为 " + x + " 吗？");
		if (r == true) {
			//跳转到modifyleavetype.do
			//携带参数：type和id
			location.href = "modifyleavetype.do?type=" + x + "&id=" + id;
		} else {

		}
	}

	function deletetype(id) {
		var r = confirm("你确定要删除这个请假类型吗？");
		if (r == true) {
			//跳转到deleteleavetypeServlet
			//携带参数id
			location.href = "deleteleavetype.do?id=" + id;
		} else {

		}
	}

	function add() {
		var x = prompt("输入想要添加的类型: ", "");/*第一个变量为提示语，第二个变量为默认初始值*/
		//该功能由于leaveid的设置方式未确定，所以暂未实现
		if (x!=null && x!="") {//确保添加的类型不能为空
			var r = confirm("你确定要将 " + x + " 添加为新的请假类型吗？");
			if (r == true) {
				//跳转到deleteleavetypeServlet
				//携带参数type
				location.href="addleavetype.do?type=" + x;
			}
		} else if (x=="") { //如果x=""，则用户未输入就点击了确定
			alert("请勿输入空值！");
		} else if (x==null) { //如果x=null，则用户在初始化显示点击了取消；
			alert("取消添加！");
		}
		/*
		var r = confirm("你确定要将 " + x + " 添加为新的请假类型吗？");
		if (r == true) {
			//跳转到deleteleavetypeServlet
			//携带参数
			//location.href="addleavetype.do";
		}
		*/
	}
</script>

</html>