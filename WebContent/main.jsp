<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询所有考试信息</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script>
/* 	window.onload = function(){
		 window.location.href = "MessageController?action=select";
	} */
</script>
</head>
<body>
<div class="container">
		<nav class="navbar" role="navigation">
			<div class="container-fluid">
				<div>
					<ul class="nav nav-pills">
						<li class="active"><a href="index.jsp">首页</a></li>
						<li class="active"><a href="MessageController?action=add">新增监考信息</a></li>
						<li class="active"><a href="adminController?action=exit">退出</a></li>
						<li class="active"><a href="">考试科目信息</a></li>
						<li class="active"><a href="checkin.jsp">考试开始登记</a></li>
						<li class="active"><a href="checkout.jsp">考试结束登记</a></li>
						<li class="active"><a href="employee.jsp">考试地点管理</a></li>
						<li class="active"><a href="job.jsp">考试日期管理</a></li>
						<li class="active"><a href="userview.jsp">用户管理</a></li>
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#">
								报表统计<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="QueryDayStatisticsByPaging?page=1">日统计表</a></li>
							</ul>
						</li>
						<li><a href="QueryLogByPaging?page=1">日志查看</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">监考信息</div>
        			
	<!-- 1、要展示数据  2、管理数据 -->
	<table  border=1 width="100%" height="100%" align="center" style="_margin-top:2%;">
	     <!-- 表头 -->
	     
		 <thead>
            <tr>
            	<th>编号</th>
                <th>科目</th>
                <th>监考老师</th>
                <th>时间</th>
                <th>地点</th>
                <th>删除</th>
                <th>修改</th>
            </tr>
        </thead>
        <!-- 表数据 -->
        <tbody>
        	<c:forEach items="${mess}" var="mes">  <!-- 迭代输出标签 -->
        		<tr>
        			<td align="center" valign="middle"><c:out value="${mes.getMid()}"/></td>
        			<td align="center" valign="middle"><c:out value="${mes.getSubject()}"/></td>
        			<td align="center" valign="middle"><c:out value="${mes.getTeacher()}"/></td>
        			<td align="center" valign="middle"><c:out value="${mes.getDate()}"/></td>
        			<td align="center" valign="middle"><c:out value="${mes.getPlace()}"/></td>
        			<td align="center" valign="middle"><a href="MessageController?action=delete&mid=<c:out value="${mes.getMid()}"/>">删除</a></td>
        			<td align="center" valign="middle"><a href="MessageController?action=update&mid=<c:out value="${mes.getMid()}"/>">修改</a></td>       			
        		</tr>
        	</c:forEach>
        </tbody>
	</table>
</body>
</html>