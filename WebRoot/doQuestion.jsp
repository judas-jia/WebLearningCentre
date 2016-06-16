<%@page import="java.util.List" %>
<%@page import="com.xupt.entity.QuestionDetail" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web学习--答题界面</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link href="css/doQuestion.css" rel="stylesheet" type="text/css" />
<script src="js/doQuestion.js" languge="javascript"></script>
</head>
<body>
<script type="text/javascript">

window.onload=function()
{
	
};
function sureTo(q0,q1,q2,q3,q4)
{
	var answer=document.getElementsByClassName("answer");
	var imgT=document.getElementsByClassName("t");
	var imgF=document.getElementsByClassName("f");
	var testDescrible=document.getElementById("testDescrible");
	var q=new Array();
	var sumit=new Array();
	//alert(imgT.length);
	//alert(imgT[0].getAttribute("display"));
//alert(2);
	q[0]=q0;
	q[1]=q1;
	q[2]=q2;
	q[3]=q3;
	q[4]=q4;
	//alert(2);
	//alert(answer.length);
	var i=0;
	var T=0;
	for(i=0; i<5; i++)
	{
		
		if(answer[i].value==q[i])
		//   imgT[0].style.display="block";
		{	T++;
			imgT[i].style.display="inline";
		}
		else
			imgF[i].style.display="inline";
	}
	//	alert("得分为"+T*20);
	testDescrible.setAttribute("value","您的总分为："+T*20);
	testDescrible.setAttribute("readonly","readonly");
	testDescrible.style.color="red";
}





</script>


<!-- 导航栏 -->
<div class="header">
	<div id="logo"></div>
	<div id="welcome">
		<span>祝愿您能取得好成绩</span>
	</div>
	<div id="linkCenter">
		<div class="linkIcon">
		<img style="height:100%" src="images/massageRemind.png" />
		</div>
		<div class="linkIcon">
		<a href="studentLoginedIndex.jsp">返回</a>
		</div>
		<div class="linkIcon">
		<a href="index.jsp">退出</a>
		</div>
	</div>
</div>
<div id="ad">
<% 
	int j=0; 
		String[] a = new String[5];
		List<QuestionDetail> list2 = (List<QuestionDetail>)session.getAttribute("allQuestionInfo");
		for(j=0; j<5; j++)
		{
			
			a[j]=list2.get(j).getResult();
		}
%>
		<a id="sureToSubmit" onclick="sureTo('<%=a[0]%>','<%=a[1]%>','<%=a[2]%>','<%=a[3]%>','<%=a[4]%>')">确认交卷</a>
</div>
<form>
<div class="content">
	
	<div id="contentHeader">
		<div id="testNameBox">
			
				<input type="text" id="testName" value="试卷名称" readonly="readonly" />
			
		</div>
		<div style="width:7%; height:50px; border-right:1px solid #f3f3f3; float:left; "></div>
		<div id="testDescribleBox">
			
				<input type="text"  id="testDescrible" value="描述"/>
				
		</div>
	</div>
	<%
		int i=0; 
	
		for(i=0; i<5; i++)
		{
			List<QuestionDetail> list1 = (List<QuestionDetail>)session.getAttribute("allQuestionInfo");
		
	 %>
	<div class="questionRadio" id="questionRadio1">
		<p class="questionNum">Q<%=i+1 %></p>
		<div class="questionForm">
			<script type="text/javascript">
			
			</script>
			
			<input type="text" class="questionSubject" value="<%=list1.get(i).getQuestion()%> " readonly="readonly" />
			<p>
				<input name="usertype" type="radio" id="aa" value="A" />
				<input type="text" value="<%=list1.get(i).getAnswer1()%>" class="questionOption" readonly="readonly"  />
				
			</p>
  			<p>
				<input name="usertype" type="radio" id="aa" value="B" />
				<input type="text" value="<%=list1.get(i).getAnswer2()%>" class="questionOption" readonly="readonly" />
			</p>
			<p>
				<input name="usertype" type="radio" id="aa" value="C" />
				<input type="text" value="<%=list1.get(i).getAnswer3()%>"  class="questionOption" readonly="readonly" />
			</p>
			<p>
				<input name="usertype" type="radio" id="aa" value="D"  />
				<input type="text" value="<%=list1.get(i).getAnswer4()%>"  class="questionOption" readonly="readonly" />
			</p>
			<p>
				
				<input type="text" placeholder="请输入正确答案"  class="answer" /><img src="images/T.jpg" class="t" /><img src="images/F.jpg"  class="f" />
				
			</p>
			
		</div>
		
	</div>
	<% } %>
	
	
	
</div>
</form>

<div id="footer">
	<div></div>
	
</div>

</body>
</html>