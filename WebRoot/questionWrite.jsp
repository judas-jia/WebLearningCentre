<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web学习-试卷编写</title>

<link href="css/index1.css" rel="stylesheet" type="text/css" />
<link href="css/questionTest.css" rel="stylesheet" type="text/css" />
<script src="js/questionTest.js" languge="javascript"></script>

<script type="text/javascript">
   	var xrequest;
   	function createXrequest(){
   		try {
		
		xrequest = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
			
				xrequest = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				try {
			
					xrequest = new XMLHttpRequest();
				     
					if (xmlhttp.overrideMimeType) {
						xmlhttp.overrideMimeType("text/xml");
					}
				} catch (e) {
				}
			}
		}
   	}
   	function search(i){
   		createXrequest();
   		xrequest.onreadystatechange=callback(i);
   		xrequest.open("get","SearchServlet",true);
   		xrequest.send(null);
   	}
   	function callback(i){
   		if(xrequest.readyState==4&&xrequest.status==200){   	
   			if(i<=5)
   			{
   				var questionSubmit=document.getElementById("questionSubmit"+i);
   				var	questionRadio=document.getElementById("questionRadio"+i);
   				var	success=document.getElementById("success"+i);
   				questionRadio.style.display="none";
   				success.style.display="block";
   				
   				
   			}
   			if(i>=6&&i<=10)
   			{
   				var j=i-5;
   				var questionSubmit=document.getElementById("questionSubmit"+i);
   				var	questionCheckbox=document.getElementById("questionCheckbox"+j);
   				var	success=document.getElementById("success"+i);
   				questionCheckbox.style.display="none";
   				success.style.display="block";
   				
   			}
   		}
   	}

   </script>

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
		<h4>Judas</h4>
		</div>
		<div class="linkIcon">
		<a href="index.jsp">退出</a>
		</div>
	</div>
</div>

<!-- 表单开始 -->


<div id="ad">

	
		<a id="sureToSubmit">确认发布</a>
	
</div>
<form>
<div class="content">
	<div id="contentNav">
		<p><a>常用题型 一</a></p>
		<p><img src="images/radio.png" /><a id="singleChoice">单选题</a></p>
		<p><img src="images/checkbox.png" /><a id="multipleChoice">多选题</a></p>
	</div>
	<div id="contentHeader">
		<div id="testNameBox">
			
				<input type="text" id="testName" placeholder="请输入试卷标题"/>
			
		</div>
		<div style="width:7%; height:50px; border-right:1px solid #f3f3f3; float:left; "></div>
		<div id="testDescribleBox">
			
				<input type="text"  id="testDescrible" placeholder="请输入试题描述" />
				
		</div>
	</div>
	<div class="questionRadio" id="questionRadio1">
		<p class="questionNum">Q1</p>
		<div class="questionForm">
			<input type="text" class="questionSubject" placeholder="单选题" />
			<p>
				<input name="usertype" type="radio" id="aa" value="A" />
				<input type="text" placeholder="选项1" class="questionOption"  />
			</p>
  			<p>
				<input name="usertype" type="radio" id="aa" value="B" />
				<input type="text" placeholder="选项2" class="questionOption"  />
			</p>
			<p>
				<input name="usertype" type="radio" id="aa" value="C" />
				<input type="text" placeholder="选项3"  class="questionOption" />
			</p>
			<p>
				<input name="usertype" type="radio" id="aa" value="D" />
				<input type="text" placeholder="选项4"  class="questionOption" />
			</p>
			<p>
				<input name="" type="button" class="questionSubmit" id="questionSubmit1" onclick="search(1)"   value="确定" />
			</p>
			
		</div>
		
	</div>
	<div class="success" id="success1" >
				<span> Q1 上传成功！</span>
				<img alt="成功" src="images/success.jpg" style="width:20px; height:20px">
	</div>
	<div class="questionRadio" id="questionRadio2">
		<p class="questionNum" id="questionNum1">Q2</p>
		<div class="questionForm">
			<input type="text" class="questionSubject" placeholder="单选题" />
			<p>
				<input name="usertype" type="radio" id="aa" value="A" />
				<input type="text" placeholder="选项1" class="questionOption"  />
			</p>
  			<p>
				<input name="usertype" type="radio" id="aa" value="B" />
				<input type="text" placeholder="选项2" class="questionOption"  />
			</p>
			<p>
				<input name="usertype" type="radio" id="aa" value="C" />
				<input type="text" placeholder="选项3"  class="questionOption" />
			</p>
			<p>
				<input name="usertype" type="radio" id="aa" value="D" />
				<input type="text" placeholder="选项4"  class="questionOption" />
			</p>
			<p>
				<input name="" type="button" class="questionSubmit" id="questionSubmit2" onclick="search(2)" value="确定" />
			</p>
		</div>
	</div>
	<div class="success" id="success2">
				<span>Q2 上传成功！</span>
				<img alt="成功" src="images/success.jpg" style="width:20px; height:20px">
	</div>
	<div class="questionRadio" id="questionRadio3">
		<p class="questionNum">Q3</p>
		<div class="questionForm">
			<input type="text" class="questionSubject" placeholder="单选题" />
			<p>
				<input name="usertype" type="radio" id="aa" value="A" />
				<input type="text" placeholder="选项1" class="questionOption"  />
			</p>
  			<p>
				<input name="usertype" type="radio" id="aa" value="B" />
				<input type="text" placeholder="选项2" class="questionOption"  />
			</p>
			<p>
				<input name="usertype" type="radio" id="aa" value="C" />
				<input type="text" placeholder="选项3"  class="questionOption" />
			</p>
			<p>
				<input name="usertype" type="radio" id="aa" value="D" />
				<input type="text" placeholder="选项4"  class="questionOption" />
			</p>
			<p>
				<input name="" type="button" class="questionSubmit" id="questionSubmit3" onclick="search(3)"  value="确定" />
			</p>
		</div>
	</div>
	<div class="success" id="success3" >
				<span>Q3 上传成功！</span>
				<img alt="成功" src="images/success.jpg" style="width:20px; height:20px">
	</div>
	<div class="questionRadio" id="questionRadio4">
		<p class="questionNum">Q4</p>
		<div class="questionForm">
			<input type="text" class="questionSubject" placeholder="单选题" />
			<p>
				<input name="usertype" type="radio" id="aa" value="A" />
				<input type="text" placeholder="选项1" class="questionOption"  />
			</p>
  			<p>
				<input name="usertype" type="radio" id="aa" value="B" />
				<input type="text" placeholder="选项2" class="questionOption"  />
			</p>
			<p>
				<input name="usertype" type="radio" id="aa" value="C" />
				<input type="text" placeholder="选项3"  class="questionOption" />
			</p>
			<p>
				<input name="usertype" type="radio" id="aa" value="D" />
				<input type="text" placeholder="选项4"  class="questionOption" />
			</p>
			<p>
				<input name="" type="button" class="questionSubmit" id="questionSubmit4" onclick="search(4)" value="确定" />
			</p>
		</div>
	</div>
	<div class="success" id="success4" >
				<span>Q4 上传成功！</span>
				<img alt="成功" src="images/success.jpg" style="width:20px; height:20px">
	</div>
	<div class="questionRadio" id="questionRadio5">
		<p class="questionNum">Q5</p>
		<div class="questionForm">
			<input type="text" class="questionSubject" placeholder="单选题" />
			<p>
				<input name="usertype" type="radio" id="aa" value="A" />
				<input type="text" placeholder="选项1" class="questionOption"  />
			</p>
  			<p>
				<input name="usertype" type="radio" id="aa" value="B" />
				<input type="text" placeholder="选项2" class="questionOption"  />
			</p>
			<p>
				<input name="usertype" type="radio" id="aa" value="C" />
				<input type="text" placeholder="选项3"  class="questionOption" />
			</p>
			<p>
				<input name="usertype" type="radio" id="aa" value="D" />
				<input type="text" placeholder="选项4"  class="questionOption" />
			</p>
			<p>
				<input name="" type="button" class="questionSubmit" id="questionSubmit5" onclick="search(5)" value="确定" />
			</p>
		</div>
	</div>
	<div class="success" id="success5" >
				<span>Q5 上传成功！</span>
				<img alt="成功" src="images/success.jpg" style="width:20px; height:20px">
	</div>
	<div class="questionCheckbox" id="questionCheckbox1">
		<p class="questionNum">Q6</p>
		<div class="questionForm">
			<input type="text" class="questionSubject" placeholder="多选题" />
			<p>
				<input name="usertype" type="checkbox" id="aa" value="A" />
				<input type="text" placeholder="选项1" class="questionOption"  />
			</p>
  			<p>
				<input name="usertype" type="checkbox" id="aa" value="B" />
				<input type="text" placeholder="选项2" class="questionOption"  />
			</p>
			<p>
				<input name="usertype" type="checkbox" id="aa" value="C" />
				<input type="text" placeholder="选项3"  class="questionOption" />
			</p>
			<p>
				<input name="usertype" type="checkbox" id="aa" value="D" />
				<input type="text" placeholder="选项4"  class="questionOption" />
			</p>
			<p>
				<input name="" type="button" class="questionSubmit" id="questionSubmit6" onclick="search(6)" value="确定" />
			</p>
		</div>
	
	</div>
	<div class="success" id="success6">
				<span>Q6 上传成功！</span>
				<img alt="成功" src="images/success.jpg" style="width:20px; height:20px">
	</div>
	<div class="questionCheckbox" id="questionCheckbox2">
		<p class="questionNum">Q7</p>
		<div class="questionForm">
			<input type="text" class="questionSubject" placeholder="多选题" />
			<p>
				<input name="usertype" type="checkbox" id="aa" value="A" />
				<input type="text" placeholder="选项1" class="questionOption"  />
			</p>
  			<p>
				<input name="usertype" type="checkbox" id="aa" value="B" />
				<input type="text" placeholder="选项2" class="questionOption"  />
			</p>
			<p>
				<input name="usertype" type="checkbox" id="aa" value="C" />
				<input type="text" placeholder="选项3"  class="questionOption" />
			</p>
			<p>
				<input name="usertype" type="checkbox" id="aa" value="D" />
				<input type="text" placeholder="选项4"  class="questionOption" />
			</p>
			<p>
				<input name="" type="button" class="questionSubmit" id="questionSubmit7" onclick="search(7)" value="确定" />
			</p>
		</div>
	
	</div>
	<div class="success" id="success7">
				<span>Q7 上传成功！</span>
				<img alt="成功" src="images/success.jpg" style="width:20px; height:20px">
	</div>
	<div class="questionCheckbox" id="questionCheckbox3">
		<p class="questionNum">Q8</p>
		<div class="questionForm">
			<input type="text" class="questionSubject" placeholder="多选题" />
			<p>
				<input name="usertype" type="checkbox" id="aa" value="A" />
				<input type="text" placeholder="选项1" class="questionOption"  />
			</p>
  			<p>
				<input name="usertype" type="checkbox" id="aa" value="B" />
				<input type="text" placeholder="选项2" class="questionOption"  />
			</p>
			<p>
				<input name="usertype" type="checkbox" id="aa" value="C" />
				<input type="text" placeholder="选项3"  class="questionOption" />
			</p>
			<p>
				<input name="usertype" type="checkbox" id="aa" value="D" />
				<input type="text" placeholder="选项4"  class="questionOption" />
			</p>
			<p>
				<input name="" type="button" class="questionSubmit" id="questionSubmit8" onclick="search(8)" value="确定" />
			</p>
		</div>
	
	</div>
	<div class="success" id="success8" >
				<span>Q8 上传成功！</span>
				<img alt="成功" src="images/success.jpg" style="width:20px; height:20px">
	</div>
	<div class="questionCheckbox" id="questionCheckbox4">
		<p class="questionNum">Q9</p>
		<div class="questionForm">
			<input type="text" class="questionSubject" placeholder="多选题" />
			<p>
				<input name="usertype" type="checkbox" id="aa" value="A" />
				<input type="text" placeholder="选项1" class="questionOption"  />
			</p>
  			<p>
				<input name="usertype" type="checkbox" id="aa" value="B" />
				<input type="text" placeholder="选项2" class="questionOption"  />
			</p>
			<p>
				<input name="usertype" type="checkbox" id="aa" value="C" />
				<input type="text" placeholder="选项3"  class="questionOption" />
			</p>
			<p>
				<input name="usertype" type="checkbox" id="aa" value="D" />
				<input type="text" placeholder="选项4"  class="questionOption" />
			</p>
			<p>
				<input name="" type="button" class="questionSubmit" id="questionSubmit9" onclick="search(9)" value="确定" />
			</p>
		</div>
	
	</div>
	<div class="success" id="success9" >
				<span>Q9 上传成功！</span>
				<img alt="成功" src="images/success.jpg" style="width:20px; height:20px">
	</div>
	<div class="questionCheckbox" id="questionCheckbox5">
		<p class="questionNum">Q10</p>
		<div class="questionForm">
			<input type="text" class="questionSubject" placeholder="多选题" />
			<p>
				<input name="usertype" type="checkbox" id="aa" value="A" />
				<input type="text" placeholder="选项1" class="questionOption"  />
			</p>
  			<p>
				<input name="usertype" type="checkbox" id="aa" value="B" />
				<input type="text" placeholder="选项2" class="questionOption"  />
			</p>
			<p>
				<input name="usertype" type="checkbox" id="aa" value="C" />
				<input type="text" placeholder="选项3"  class="questionOption" />
			</p>
			<p>
				<input name="usertype" type="checkbox" id="aa" value="D" />
				<input type="text" placeholder="选项4"  class="questionOption" />
			</p>
			<p>
				<input name="" type="button" class="questionSubmit" id="questionSubmit10" onclick="search(10)" value="确定" />
			</p>
		</div>
	</div>
	<div class="success" id="success10">
				<span>Q10 上传成功！</span>
				<img alt="成功" src="images/success.jpg" style="width:20px; height:20px">
	</div>
	<!-- 表单结束 -->
	</form>
	<div id="footer">
		<div></div>
	
	</div>
</div>



