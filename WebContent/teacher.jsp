<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询所有教师信息</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
		<nav class="navbar" role="navigation">
			<div class="container-fluid">
				<div>
					<ul class="nav nav-pills">
						<li class="active"><a href="index.jsp">首页</a></li>
						<li class="active"><a href="TeacherController?action=add">新增教师信息</a></li>
						<li class="active"><a href="adminController?action=exit">退出</a></li>
						<li class="active"><a href="">教师姓名信息</a></li>
						<li class="active"><a href="checkin.jsp">开始监考登记</a></li>
						<li class="active"><a href="checkout.jsp">结束监考登记</a></li>
						<li class="active"><a href="employee.jsp">教师密码管理</a></li>
						<li class="active"><a href="job.jsp">职位管理</a></li>
						<li class="active"><a href="userview.jsp">教师管理</a></li>
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
        	<c:forEach items="${teac}" var="tea">  <!-- 迭代输出标签 -->
        		<tr>
        			<td align="center" valign="middle"><c:out value="${tea.getTid()}"/></td>
        			<td align="center" valign="middle"><c:out value="${tea.getTname()}"/></td>
        			<td align="center" valign="middle"><c:out value="${tea.getAge()}"/></td>
        			<td align="center" valign="middle"><c:out value="${tea.getGender()}"/></td>
        			<td align="center" valign="middle"><c:out value="${tea.getPassword()}"/></td>
        			<td align="center" valign="middle"><a href="TeacherController?action=delete&tid=<c:out value="${tea.getTid()}"/>">删除</a></td>
        			<td align="center" valign="middle"><a href="TeacherController?action=update&tid=<c:out value="${tea.getTid()}"/>">修改</a></td>       			
        		</tr>
        	</c:forEach>
        </tbody>
	</table>
</body>
</html>