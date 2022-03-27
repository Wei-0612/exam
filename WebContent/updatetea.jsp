<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改教师信息</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">修改教师信息</div>
			<form method="POST" action="TeacherController?action=update&tid=${tea.getTid()}">
				<table class="table">
					<tr class="row">
						<th class="col-md-offset-2 col-md-2">姓名</th>
						<td class="col-md-4"><input type ="text" name ="tname" value ="<c:out value="${tea.getTname()}"/>"></td>
						<td class="col-md-4"></td>
					</tr>
					<tr class="row">
						<th class="col-md-offset-2 col-md-2">密码</th>
						<td class="col-md-4"><input type ="text"  name ="password" value="<c:out value="${tea.getPassword()}"/>"></td>
						<td class="col-md-4"></td>
					</tr>
					<tr class="row">
						<th class="col-md-offset-2 col-md-2">年龄</th>
						<td class="col-md-4"><input type ="text"   name ="age" value ="<c:out value="${tea.getAge()}"/>"></td>
						<td class="col-md-4"></td>
					</tr>
					<tr class="row">
						<th class="col-md-offset-2 col-md-2">性别</th>
						<td class="col-md-4"><input type ="text"  name ="gender"  value="<c:out value="${tea.getGender()}"/>"></td>
						<td class="col-md-4"></td>
					</tr>
					
					<tr class="row">
						<td>
							<input type="submit" name="update" class="btn btn-primary" value="更新" />
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