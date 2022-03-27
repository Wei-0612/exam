<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>增加考试信息</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">增加考试信息</div>
			<form method="POST" action="MessageController?action=add">
				<table class="table">
					<tr class="row">
						<th class="col-md-offset-2 col-md-2">请输入考试科目</th>
						<td class="col-md-4"><input name="subject" class="form-control" type="text" /></td>
						<td class="col-md-4"></td>
					</tr>
					<tr class="row">
						<th class="col-md-offset-2 col-md-2">请输入监考老师</th>
						<td class="col-md-4"><input name="teacher" class="form-control" type="text" /></td>
						<td class="col-md-4"></td>
					</tr>
					<tr class="row">
						<th class="col-md-offset-2 col-md-2">请输入考试日期</th>
						<td class="col-md-4"><input name="date" class="form-control" type="text" /></td>
						<td class="col-md-4"></td>
					</tr>
					<tr class="row">
						<th class="col-md-offset-2 col-md-2">请输入考试地点</th>
						<td class="col-md-4"><input name="place" class="form-control" type="text" /></td>
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