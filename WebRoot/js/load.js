function openNew(){
	//获取页面的高度和宽度
	var sWidth=document.body.scrollWidth;
	var sHeight=document.body.scrollHeight;
	
	//获取页面的可视区域高度和宽度
	var wHeight=document.documentElement.clientHeight;
	
	var oMask=document.createElement("div");
		oMask.id="mask";
		oMask.style.height=sHeight+"px";
		oMask.style.width=sWidth+"px";
		document.body.appendChild(oMask);
//	var oLogin=document.createElement("div");
var oLogin=document.getElementById("login");
		//oLogin.id="login";
		oLogin.style.display="block";
	//	oLogin.innerHTML="<div class='loginCon'><div id='close'>点击关闭</div></div>";
//		document.body.appendChild(oLogin);
	
	//获取登陆框的宽和高
	var dHeight=oLogin.offsetHeight;
	var dWidth=oLogin.offsetWidth;
		//设置登陆框的left和top
		oLogin.style.left=sWidth/2-dWidth/2+"px";
		oLogin.style.top=wHeight/2-dHeight/2+"px";
	//点击关闭按钮
	var oClose=document.getElementById("close");
	
		//点击登陆框以外的区域也可以关闭登陆框
		oClose.onclick=oMask.onclick=function(){
					//document.body.removeChild(oLogin);
					document.body.removeChild(oMask);
					oLogin.style.display="none";
					};
				
					
	};
	
	
	function openNewRegist(){
	//获取页面的高度和宽度
	var sWidth=document.body.scrollWidth;
	var sHeight=document.body.scrollHeight;
	
	//获取页面的可视区域高度和宽度
	var wHeight=document.documentElement.clientHeight;
	
	var oMask=document.createElement("div");
		oMask.id="mask";
		oMask.style.height=sHeight+"px";
		oMask.style.width=sWidth+"px";
		document.body.appendChild(oMask);
//	var oLogin=document.createElement("div");
	var oLogin=document.getElementById("regist");
		//oLogin.id="login";
		oLogin.style.display="block";
	//	oLogin.innerHTML="<div class='loginCon'><div id='close'>点击关闭</div></div>";
//		document.body.appendChild(oLogin);
	
	//获取登陆框的宽和高
	var dHeight=oLogin.offsetHeight;
	var dWidth=oLogin.offsetWidth;
		//设置登陆框的left和top
		oLogin.style.left=sWidth/2-dWidth/2+"px";
		oLogin.style.top=wHeight/2-dHeight/2+"px";
	//点击关闭按钮
	var oClose=document.getElementById("close1");
	
		//点击登陆框以外的区域也可以关闭登陆框
		oClose.onclick=oMask.onclick=function(){
					//document.body.removeChild(oLogin);
					document.body.removeChild(oMask);
					oLogin.style.display="none";
					};		
	};
			
	function changereturnlogin()
	{
		var loginSubmit=document.getElementById("loginSubmit");
		loginSubmit.value="登录";
		
		};
	function changereturnregist()
	{
		var registSubmit=document.getElementById("registSubmit");
		registSubmit.value="注册";
		
		};
	
	
	
	
					
	window.onload=function(){
			var oBtn=document.getElementById("btnLogin");
			var registBtn=document.getElementById("btnRegist");
			var litterlogin=document.getElementById("loginLogin");	
			var litterregist=document.getElementById("loginRegist");
			var litterloginx=document.getElementById("loginLoginx");
			var litterregistx=document.getElementById("loginRegistx");
			var litteroLogin=document.getElementById("login");
			var litteroRegist=document.getElementById("regist");
			var loginSubmit=document.getElementById("loginSubmit");
			var registSubmit=document.getElementById("registSubmit");
			
				//点击登录按钮
				oBtn.onclick=function(){
					openNew();
					
					return false;
					}
				registBtn.onclick=function(){
					openNewRegist();
					
					return false;
					}	
				//小登录跟小注册
			
			//var litteroRegist=document.getElementById("regist");
		
			litterregistx.onclick=litterregist.onclick=function()
			{
				litteroLogin.style.display="none";
				litteroRegist.style.display="block";
				//alert(1);
			};
			
			litterloginx.onclick=litterlogin.onclick=function()
			{
				
				litteroLogin.style.display="block";
				litteroRegist.style.display="none";
				//alert(2);
			};
			
			//正在登陆正在注册
			loginSubmit.onclick=function(){
					
					loginSubmit.value="正在登录..."
					setTimeout("changereturnlogin()",2000);
					return false;
					};
			registSubmit.onclick=function(){
					
					registSubmit.value="正在注册..."
					setTimeout("changereturnregist()",2000);
					return false;
					};
			
				
		}