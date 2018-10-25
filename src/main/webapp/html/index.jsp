<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>登录</title>
	<style type="text/css">
		html, body, div, ul, li, h1, h2, h3, h4, h5, h6, p, dl, dt, dd, ol, form, input, textarea, th, td, select {
    		margin: 0;
   		 	padding: 0;
		}
		html,body{height: 100%;width: 100%;margin:0;padding:0;} 
		body{
			background-size:100% 100%;
			-moz-background-size:100% 100%;
		}
		.top{
			height:79px;
			font-size: 24px;
			color: #868686;
			padding-left: 256px;
			line-height: 79px;
		}
		.all{
			position: relative;
			width: 1534.2px;
			height: 600px;		

		}
		.all .bg{
			background: url(${pageContext.request.contextPath}/images/denglubeijing.jpg) no-repeat;
			width: 1534.2px;
			height: 600px;
			-webkit-filter: blur(2px);
            -moz-filter: blur(2px);
            -o-filter: blur(2px);
            -ms-filter: blur(2px);
            filter: blur(2px);
			background-position: center;
			background-size:100% 100%;
			-moz-background-size:100% 100%;
		}
		.all .denglu{
			position: absolute;
			top:80px;
			left: 936px;		}
		.all .denglu form{
			height: 450px;
			width: 405px;
			background-color: white;
			border-radius:5px;

		}
		.all .denglu li{
			float: left;
			height: 32px;
			font-size: 16px;
			width: 202.5px;
			padding-top: 13px;
			list-style: none;
			text-align: center;
			background-color: #f5f5f5;	
			cursor: pointer;			
		}
		.all .denglu .li-left{
			border-top-left-radius:5px;

		}
		.all .denglu .li-right{
			border-top-right-radius:5px;
		}
		.all .denglu li.open{
			background-color: #0bd;
			color: white;
		}
		
		.all .denglu form .yanzheng{
			padding-top: 35px;
			height: 370px;
			float: left;
			text-align: center;
		}
		.all .denglu form .yanzheng input{
			height: 45px;
			margin-top: 22px;
			width: 291px;
			background-color: #faffbd;
			border: 1px solid #ccc;
			font-size: 14px;
			padding: 0px 5px 0px 42px;
		}
		.all .denglu form .yanzheng .rem{
			padding-top: 27px;
			float: left;
			height: 15px;
			font-size: 15px;
			width: 140px;
			color: #888;

		}
		.all .denglu form .yanzheng .rem input{
			height: 15px;
			width: 15px;
			padding: 0px;
			margin: 0px;
			cursor: pointer;
		}
		.all .denglu form .yanzheng .mima{
			padding-top: 27px;
			float: right;
			font-size: 15px;
			height: 15px;
			width: 140px;
		}
		.all .denglu form .yanzheng .mima a{
			color:#0bd;
			text-decoration: none;
		}
		.all .denglu form .yanzheng .mima a:hover{
			text-decoration: underline;
		}
		.all .denglu form .yanzheng .dibu{
			width: 405px;
			padding-top: 87px;
		}
		.all .denglu form .yanzheng .dibu button{
			width: 338px;
			height: 43px;
			border: 1px solid #0bd;
			font-size: 15px;
			background-color: white;
			color:#0bd;
			cursor: pointer;
		}
		.all .denglu form .yanzheng .dibu .zhuce{
			width: 338px;
			height: 43px;
			border: 1px solid #0bd;
			font-size: 15px;
			background-color:white;
			color:#0bd;
			padding: 0px;
			cursor: pointer;
		}
		.all .denglu form .mobile{
			display: none;
		}
		.all .denglu form .mobile.select{
			display: block;
		}
	</style>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript"> 
        $(function(){
        	$(".denglu li").click(function(){
        		var $this = $(this),
        			index = $this.index();
        		$this.addClass("open").siblings("li").removeClass("open");
        		$("form div").eq(index).addClass("select").siblings("div").removeClass("select");
        	});
        });
        function login() {
        	var userid=document.getElementById("txtUserName").value;   
    		var userpw=document.getElementById("TextBox2").value;
            $.ajax({
                type: "POST",//方法类型
                //dataType: "json",//预期服务器返回的数据类型
                url:"${pageContext.request.contextPath}/User/login",//url
                data: {
                	userid:userid,
                	userpw:userpw,
 			   },
 			  success: function(data){
				 	  var data = eval('(' + data + ')');
					//alert("测试");
					if (data.status==1){
						location.href="${pageContext.request.contextPath}/html/homepage.jsp";
						//location.href="http://www.baidu.com";
					}else if(data.status==0){
						alert("用户不存在！");
					}else if(data.status==-1){
						alert("密码错误！");
					}   
				}
            });
        };
       
    </script>
</head>
<body>
	<div class="top">会务管理系统</div>
	<div class="all">
		<div class="bg"></div>
		<div class="denglu">
			<li class="li-left open">账号密码登录</li>
			<li class="li-right">短信验证登录</li>
			<form action="">
				<div class="yanzheng mobile select">
					<input name="userName" type="text" id="txtUserName" tabindex="1" size="15" value=""/>
					<input name="password" type="password" id="TextBox2" tabindex="2" size="16" value=""/>
					<p class="rem"><input type="checkbox" name="" id="jizhu"><label for="jizhu">记住密码</label></p>
					<p class="mima"><a href="">忘记密码？</a></p>
					<p class="dibu">
						<input type="button" class="zhuce" onclick="login()" value="登录">
						<input type="button" value="注册" class="zhuce" onclick="window.location.href='${pageContext.request.contextPath}/html/zhuce.jsp'">
						
					</p>	
				</div>
				<div class="mobile">
					这里是手机验证登录
				</div>
			</form>
		</div>
	</div>
</body>
</html>
