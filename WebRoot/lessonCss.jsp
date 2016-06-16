<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web学习-课程-css</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />

</head>
<body>
<!-- 导航栏 -->
<div class="header">
	<div id="logo"></div>
	<div class="linkIcon">
	<a href="lessonJs.jsp" >课程</a>
	</div>
	<div class="linkIcon">
	<a href="lessonJs.jsp" >作业</a>
	</div>
	<div id="linkCenter">
		<div class="linkIcon">
		<img style="height:100%" src="images/massageRemind.png" />
		</div>
		<div class="linkIcon">
		<h4>Judas</h4>
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
			<li><a href="lessonJs.jsp">JavaScript</a></li>
			<li style="color:red">CSS3</li>
			<li><a href="lessonHtml.jsp">Html5</a></li>
			<li>jQuery</li>
			<li>AugularJs</li>
			<li>Node.js</li>
			<li>Bootstrap</li>
		</ul>
	</div>
	<div style="width:100%; height:40px; background-color:#F9F9F9; line-height:40px; ">
		<span style="color:#999999; font-size:16px"> 课程列表</span>
	</div>
	<div class="lessonsBox">
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
      Copyright © 2016 imooc.com All Rights Reserved | 京ICP备 13046642号-2
    </div>
</div>
</body>
</html>
