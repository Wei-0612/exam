<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>新增教师信息</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">新增教师信息</div>
			<form method="POST" action="TeacherController?action=add">
				<table class="table">
					<tr class="row">
						<th class="col-md-offset-2 col-md-2">请输入教师姓名</th>
						<td class="col-md-4"><input name="tname" class="form-control" type="text" /></td>
						<td class="col-md-4"></td>
					</tr>
					<tr class="row">
						<th class="col-md-offset-2 col-md-2">请输入教师密码</th>
						<td class="col-md-4"><input name="password" class="form-control" type="text" /></td>
						<td class="col-md-4"></td>
					</tr>
					<tr class="row">
						<th class="col-md-offset-2 col-md-2">请输入教师年龄</th>
						<td class="col-md-4"><input name="age" class="form-control" type="text" /></td>
						<td class="col-md-4"></td>
					</tr>
					<tr class="row">
						<th class="col-md-offset-2 col-md-2">请输入教师性别</th>
						<td class="col-md-4"><input name="gender" class="form-control" type="text" /></td>
						<td class="col-md-4"></td>
					</tr>
					<tr class="row">
						<td>
							<input type="submit" name="add" class="btn btn-primary" value="确定增加" />
							<input type="button" name="cancel" class="btn btn-primary" value="取消" onclick="history.back();" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>