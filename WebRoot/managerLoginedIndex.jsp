<%@page import="java.util.List" %>
<%@page import="com.xupt.entity.Student" %>
<%@page import="com.xupt.entity.Teacher" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web学习-管理员界面</title>
<link href="css/index1.css" rel="stylesheet" type="text/css" />
<link href="css/manage.css" rel="stylesheet" type="text/css" />
<link href="css/Administrator.css" rel="stylesheet" type="text/css" />

</head>
<body>

<!-- 头部 -->
<div class="header">
	<div id="logo"></div>
	<div id="welcome">
		<span>欢迎进入管理员界面</span>
	</div>
	<div id="linkCenter">
		<div class="linkIcon">
		<img style="height:100%" src="images/massageRemind.png" />
		</div>
		<div class="linkIcon">
		<h4>${sessionScope.loginName }</h4>
		</div>
		<div class="linkIcon">
		<a href="index.jsp">退出</a>
		</div>
	</div>
</div>
<div class="content">
	<table border='1'cellspacing="0" cellpadding="0">
		<tr>
			<td>用户名：</td>
			<td>用户密码</td>
			<td>用户身份</td>
			<td>是否删除该用户</td>
		</tr>
		<%
		int j=0; 
		List<Teacher> list = (List<Teacher>)session.getAttribute("allTeacherInfoList");
		for(j=0; j<list.size(); j++)
		{
			//List<Student> list = (List<Student>)session.getAttribute("allStudentInfoList");
		
	 %>
		<tr>
			<td><%=list.get(j).getName() %></td>
			<td><%=list.get(j).getPassword() %></td>
			<td>教师</td>
			<td><a href="DeleteTeacherServlet?name=<%=list.get(j).getName() %>"style="color:red" >删除</a></td>
		</tr>
		<%} %>
		<%
		int i=0; 
		List<Student> list2 = (List<Student>)session.getAttribute("allStudentInfoList");
		for(i=0; i<list2.size(); i++)
		{
			//List<Student> list = (List<Student>)session.getAttribute("allStudentInfoList");
		
	 %>
		<tr>
			<td><%=list2.get(i).getName() %></td>
			<td><%=list2.get(i).getPassword() %></td>
			<td>学生</td>
			<td><a href="DeleteStudentServlet?name=<%=list2.get(i).getName() %>" style="color:red">删除</a></td>
		</tr>
		<%} %>
</table>


</div>


