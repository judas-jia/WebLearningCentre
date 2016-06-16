<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web学习-首页</title>
<link href="css/load.css" rel="stylesheet" type="text/css" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script src="js/load.js" languge="javascript"></script>

</head>
<body>

<!-- 导航栏 -->
<div class="header">
	<div id="logo"></div>
	<div id="welcome">
		WebLearningCentre
	</div>

	<div id="linkCenter">
		<div class="linkIconx">
			<img src="images/massageRemind.png" />
		</div>
		<div class="linkIconx">
			<a id="btnLogin">登录</a>
		</div>
		<div class="linkIconx">
			<a id="btnRegist">注册</a>
		</div>
	</div>
</div>

<!--轮播广告-->
<div id="ad">
	<img src="images/ad1.jpg" />
</div>
<div id="footer" >
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



<div id="login">
	<div class="loginCon">
		<div id="login-Box">
			<span id="loginLogin">登录</span>
			<span id="loginRegist">注册</span>
		</div>
		<div id="close"></div>
		
		<form id="login-form" action="LoginServlet" method="post">
			<input type="text" class="login-input" name="username" placeholder="   请输入用户名"  />
			<input type="password" class="login-input" name="password" placeholder="   请输入密码"  /><br /><br />
		<!--	<label style="font-size:13px; color:#666" ><input name="Fruit" type="checkbox" value="" /> 下次自动登录 </label>-->
			<label style="font-size:13px; color:#666" ><input name="usertype" type="radio" id="aa" value="student"  checked="checked" />学生</label>
  			<label style="font-size:13px; color:#666" ><input name="usertype" type="radio" id="aa" value="teacher" />教师</label>
			<label style="font-size:13px; color:#666" ><input name="usertype" type="radio" id="aa" value="administrator" />管理员</label>
			<a style=" font-size:15px; color:#666; float:right; display:block" >忘记密码</a>
			
			<!-- <input type="submit" id="loginSubmit" value="登录" /> -->
			<br/><br/>
			<input type="submit" id="loginSubmitx" value="登录" />
		</form>
	</div>
</div>
<div id="regist">
	<div class="loginCon">
		<div id="login-Box1">
			<span id="loginLoginx">登录</span>
			<span id="loginRegistx">注册</span>
		</div>
		<div id="close1"></div>
		
		<form id="login-form1" action="RegisterServlet" method="post">
			<input type="text" class="login-input1" name="username" placeholder="   请输入注册用户名"  />
			<input type="password" class="login-input1" name="password" placeholder="   请输入密码"  />
			<input type="password" class="login-input1" placeholder="   请确认密码"  />
			<label style="font-size:13px; color:#666" ><input name="usertype" type="radio" id="aa" value="学生" checked="checked" />学生</label>
  			<label style="font-size:13px; color:#666" ><input name="usertype" type="radio" id="aa" value="教师" />教师</label>
			<label style="font-size:13px; color:#666" ><input name="usertype" type="radio" id="aa" value="管理员" />管理员</label>
			<input type="submit" id="registSubmit" value="注册" />
		</form>
	</div>
</div>

</body>
</html>
