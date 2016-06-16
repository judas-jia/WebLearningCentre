<%@page import="java.util.List" %>
<%@page import="com.xupt.entity.Paper" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web学习-试卷</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />

</head>
<body>
<!-- 导航栏 -->
<div class="header">
	<div id="logo"></div>
	<div id="welcome">
		<span>欢迎进入学生界面</span>
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
			<li><a href="#">JavaScript</a></li>
			<li><a href="#">CSS3</a></li>
			<li><a href="#">Html5</a></li>
			<li>jQuery</li>
			<li>AugularJs</li>
			<li>Node.js</li>
			<li>Bootstrap</li>
		</ul>
	</div>
	<div style="width:100%; height:40px; background-color:#F9F9F9; line-height:40px; ">
		<span style="color:#999999; font-size:16px">所有试卷</span>
	</div>
	<div class="lessonsBox">
	<%
		
		int i=0,num=(Integer)session.getAttribute("paperLength");
		for(i=0; i<num; i++)
		{
			int j=0;
			//List<Paper> list = new List<Paper>();
			List<Paper> list = (List<Paper>)session.getAttribute("paperList");
	 %>
	 <a href="searchQuestionServlet?paper_id=<%= list.get(i).getId() %>">
		<div class="lessonBox">
			<img src="images/web.jpg"  />
	
			<p><%= list.get(i).getTitle() %> &nbsp;&nbsp; &nbsp;  <span>试卷号：<%= list.get(i).getId() %></span></p>
			
			<p><%= list.get(i).getDescription() %></p>
			<span>出题完毕</span><span>121人答题</span>
		</div>
		</a>
		<%} %>
		<!--<div class="lessonBox">
			<img src="images/js1.jpg" />
			<p>DOM探索-基础详情篇</p>
			<p>前端大牛都是从精通DOM开始的</p>
			<span>出题完毕</span><span>121人答题</span>
		</div>
		<div class="lessonBox">
			<img src="images/js1.jpg" />
			<p>DOM探索-基础详情篇</p>
			<p>前端大牛都是从精通DOM开始的</p>
			<span>出题完毕</span><span>121人答题</span>
		</div>
		<div class="lessonBox">
			<img src="images/js1.jpg" />
			<p>DOM探索-基础详情篇</p>
			<p>前端大牛都是从精通DOM开始的</p>
			<span>出题完毕</span><span>121人答题</span>
		</div>
		  -->
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
