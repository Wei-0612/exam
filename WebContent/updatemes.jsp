<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改监考信息</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">修改考试信息</div>
			<form method="POST" action="MessageController?action=update&mid=${mes.getMid()}">
				<table class="table">
					<tr class="row">
						<th class="col-md-offset-2 col-md-2">科目</th>
						<td class="col-md-4"><input type ="text" name ="subject" value ="<c:out value="${mes.getSubject()}"/>"></td>
						<td class="col-md-4"></td>
					</tr>
					<tr class="row">
						<th class="col-md-offset-2 col-md-2">监考老师</th>
						<td class="col-md-4"><input type ="text"   name ="teacher" value ="<c:out value="${mes.getTeacher()}"/>"></td>
						<td class="col-md-4"></td>
					</tr>
					<tr class="row">
						<th class="col-md-offset-2 col-md-2">日期</th>
						<td class="col-md-4"><input type ="text"  name ="date"  value="<c:out value="${mes.getDate()}"/>"></td>
						<td class="col-md-4"></td>
					</tr>
					<tr class="row">
						<th class="col-md-offset-2 col-md-2">地点</th>
						<td class="col-md-4"><input type ="text"  name ="place" value="<c:out value="${mes.getPlace()}"/>"></td>
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