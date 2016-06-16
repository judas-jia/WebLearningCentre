<%@page import="java.util.List" %>
<%@page import="com.xupt.entity.PaperInfoByTeacher" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web学习-课程-js</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />

</head>
<body>
<!-- 导航栏 -->
<div class="header">
	<div id="logo"></div>
	<div id="welcome">
		欢迎进入教师界面
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

<!--课程导航-->
<div class="lessonIcon">
	<div class="lessonLead">
		<h4 style="display:block; position:absolute; bottom:10px">全部课程</h4>
	</div>
	<div class="lessonLead">
		<span>分类:</span>
		<ul>
			<li style="color:red"><a href="questionWriteJS.jsp">JavaScript</a></li>
			<li><a href="questionWriteCss.jsp">CSS3</a></li>
			<li><a href="questionWriteHtml5.jsp">Html5</a></li>
			<li><a href="questionWritejQuery.jsp">jQuery</a></li>
			<li><a href="questionWriteAugularJS.jsp">AugularJs</a></li>
			<li><a href="questionWriteNodeJs.jsp">Node.js</a></li>
			<li><a href="questionWriteBootstrap.jsp">Bootstrap</a></li>
		</ul>
	</div>
	<div style="width:100%; height:40px; background-color:#F9F9F9; line-height:40px; ">
		<span style="color:#999999; font-size:16px"> 课程列表</span>
	</div>
	<div class="lessonsBox">
		<%
		int j=0; 
		List<PaperInfoByTeacher> list = (List<PaperInfoByTeacher>)session.getAttribute("PaperInfoByTeacher");
		for(j=0; j<list.size(); j++)
		{
			//List<Student> list = (List<Student>)session.getAttribute("allStudentInfoList");
		
	 	%>
		<div class="lessonBox">
			<img src="images/web.jpg" />
			<p><%=list.get(j).getTitle() %></p>
			<p><%=list.get(j).getDescription() %></p>
			<span>出题老师:<%=list.get(j).getTeacher_name() %></span><span>题型:<%=list.get(j).getGenre() %></span>
		</div>
		<%} %>
	
		
	</div>
</div>
<div id="footer">
	<div class="friendly-link">
    	<span>友情链接：</span>
        <a href="http://hao.360.cn" target="_blank" title="360导航">360导航</a>
        <a href="http://www.php-z.com/" target="_blank" title="PHP站中文网">PHP站中文网</a>
        <a href="http://www.hao123.com" target="_blank" title="hao123">hao123</a>
        <a href="http://www.lagou.com" target="_blank" title="拉勾网">拉勾网</a>
        <a href="http://www.admin10000.com/" target="_blank" title="web开发者">web开发者</a>
        <a href="/about/friendly" title="友情链接">更多...</a>
    </div>
    <div class="footer-copyright">
      Copyright © 2016 Judas-jia.com All Rights Reserved | 京ICP备 13046642号-2
    </div>
</div>
</body>
</html>
