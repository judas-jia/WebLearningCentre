<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web学习-JavaScript试卷编写</title>

<link href="css/index1.css" rel="stylesheet" type="text/css" />
<link href="css/questionTest.css" rel="stylesheet" type="text/css" />
<script src="js/questionTest.js" languge="javascript"></script>

</head>
<body>

<!-- 导航栏 -->
<div class="header">
	<div id="logo"></div>
	<div class="linkIcon">
		<a href="teacherLoginedIndex.jsp" >返回</a>
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

<!-- 表单开始 -->

<form action="MakejQueryQuestionServlet" method="post">
<div id="ad">
	
		<input type="submit" id="sureToSubmit" value="确认发布" />
	
</div>
<div class="content">
	<div id="contentNav">
		<p><a>常用题型 一</a></p>
		<p><img src="images/radio.png" /><a id="singleChoice">单选题</a></p>
		<!-- <p><img src="images/checkbox.png" /><a id="multipleChoice">多选题</a></p> -->
	</div>
	<div id="contentHeader">
		<div id="testNameBox">
			
				<input type="text" id="testName" name="title" placeholder="请输入试卷标题"/>
			
		</div>
		<div style="width:7%; height:50px; border-right:1px solid #f3f3f3; float:left; "></div>
		<div id="testDescribleBox">
			
				<input type="text"  id="testDescrible" name="description" placeholder="请输入试题描述" />
				
		</div>
	</div>
	<div class="questionRadio" id="questionRadio1">
		<p class="questionNum">Q1</p>
		<div class="questionForm">
			<input type="text" class="questionSubject" name="question1" placeholder="单选题" />
			<p>
				<input name="usertype1" type="radio" id="aa" value="1" />
				<input type="text" placeholder="选项1" name="answerA1" class="questionOption"  />
			</p>
  			<p>
				<input name="usertype1" type="radio" id="aa" value="2" />
				<input type="text" placeholder="选项2" name="answerB1" class="questionOption"  />
			</p>
			<p>
				<input name="usertype1" type="radio" id="aa" value="3" />
				<input type="text" placeholder="选项3" name="answerC1" class="questionOption" />
			</p>
			<p>
				<input name="usertype1" type="radio" id="aa" value="4" />
				<input type="text" placeholder="选项4" name="answerD1" class="questionOption" />
			</p>
		</div>
	</div>
	<div class="questionRadio" id="questionRadio2">
		<p class="questionNum" id="questionNum1">Q2</p>
		<div class="questionForm">
			<input type="text" class="questionSubject" name="question2" placeholder="单选题" />
			<p>
				<input name="usertype2" type="radio" id="aa" value="1" />
				<input type="text" placeholder="选项1" name="answerA2" class="questionOption"  />
			</p>
  			<p>
				<input name="usertype2" type="radio" id="aa" value="2" />
				<input type="text" placeholder="选项2" name="answerB2" class="questionOption"  />
			</p>
			<p>
				<input name="usertype2" type="radio" id="aa" value="3" />
				<input type="text" placeholder="选项3" name="answerC2" class="questionOption" />
			</p>
			<p>
				<input name="usertype2" type="radio" id="aa" value="4" />
				<input type="text" placeholder="选项4" name="answerD2" class="questionOption" />
			</p>
		</div>
	</div>
	<div class="questionRadio" id="questionRadio3">
		<p class="questionNum">Q3</p>
		<div class="questionForm">
			<input type="text" class="questionSubject" name="question3" placeholder="单选题" />
			<p>
				<input name="usertype3" type="radio" id="aa" value="1" />
				<input type="text" placeholder="选项1" name="answerA3" class="questionOption"  />
			</p>
  			<p>
				<input name="usertype3" type="radio" id="aa" value="2" />
				<input type="text" placeholder="选项2" name="answerB3" class="questionOption"  />
			</p>
			<p>
				<input name="usertype3" type="radio" id="aa" value="3" />
				<input type="text" placeholder="选项3" name="answerC3" class="questionOption" />
			</p>
			<p>
				<input name="usertype3" type="radio" id="aa" value="4" />
				<input type="text" placeholder="选项4" name="answerD3" class="questionOption" />
			</p>
		</div>
	</div>
	<div class="questionRadio" id="questionRadio4">
		<p class="questionNum">Q4</p>
		<div class="questionForm">
			<input type="text" class="questionSubject" name="question4" placeholder="单选题" />
			<p>
				<input name="usertype4" type="radio" id="aa" value="1" />
				<input type="text" placeholder="选项1" name="answerA4" class="questionOption"  />
			</p>
  			<p>
				<input name="usertype4" type="radio" id="aa" value="2" />
				<input type="text" placeholder="选项2" name="answerB4" class="questionOption"  />
			</p>
			<p>
				<input name="usertype4" type="radio" id="aa" value="3" />
				<input type="text" placeholder="选项3" name="answerC4" class="questionOption" />
			</p>
			<p>
				<input name="usertype4" type="radio" id="aa" value="4" />
				<input type="text" placeholder="选项4" name="answerD4" class="questionOption" />
			</p>
		</div>
	</div>
	<div class="questionRadio" id="questionRadio5">
		<p class="questionNum">Q5</p>
		<div class="questionForm">
			<input type="text" class="questionSubject" name="question5" placeholder="单选题" />
			<p>
				<input name="usertype5" type="radio" id="aa" value="1" />
				<input type="text" placeholder="选项1" name="answerA5" class="questionOption"  />
			</p>
  			<p>
				<input name="usertype5" type="radio" id="aa" value="2" />
				<input type="text" placeholder="选项2" name="answerB5" class="questionOption"  />
			</p>
			<p>
				<input name="usertype5" type="radio" id="aa" value="3" />
				<input type="text" placeholder="选项3" name="answerC5" class="questionOption" />
			</p>
			<p>
				<input name="usertype5" type="radio" id="aa" value="4" />
				<input type="text" placeholder="选项4" name="answerD5" class="questionOption" />
			</p>
		</div>
	</div>
	
	</form>
	<div id="footer">
		<div></div>
	</div>
</div>



