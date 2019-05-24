<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.group.entity.*,java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="MyFirstTag" prefix="mytag"%>
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
							<h1 class="text-dark">考勤信息</h1>
						</div>
					</div>
				</div>
			</div>
			<div>
				<div class="container-fluid">
					<div class="row-form mb-2 clearfix">

						<form method="POST" action="../../view/jsp/attinfo.do">
							<!-- 
							<div class="form-group clearfix">
								<label>部门</label> <select class="form-control">
									<option value="">全部</option>
									<option value="">部门A</option>
									<option value="">部门B</option>
									<option value="">部门C</option>
								</select>
							</div>
							 -->

							<div class="form-group clearfix">
								<label>开始日期</label> <input type="date"
									class="form_date form-control" id="meeting" value=""
									name="startdate">
							</div>
							<div class="form-group clearfix">
								<label>结束日期</label> <input type="date"
									class="form_date form-control" value="" name="enddate">
							</div>
							<button type="submit"
								class="btn btn-primary btn-flat pull-right btn-groupform">查询</button>
						</form>

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
										style="width: 140px; padding: .75rem 0 !important;">序号</th>
									<th>部门ID</th>
									<th>员工ID</th>
									<th>姓名</th>
									<th>签到时间</th>
									<th>签到类型</th>
								</tr>

								<!-- 使用自定义标签 -->
								<mytag:showTag />

							</tbody>
						</table>

						<nav>
						<ul class="pager">
							<li><a href="?start=0">首 页</a></li>
							<li><a href="?start=${pre}">上一页</a></li>
							<li><a href="?start=${next}">下一页</a></li>
							<li><a href="?start=${last}">末 页</a></li>
						</ul>
						</nav>
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

</html>