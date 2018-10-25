<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>会务管理系统</title>
	<style type="text/css">
		html, body, div, ul, li, h1, h2, h3, h4, h5, h6, p, dl, dt, dd, ol, form, input, textarea, th, td, select {
    		margin: 0;
   		 	padding: 0;
		}
		.header{
			height: 50px;
			margin: 0 auto;
			width: 980px;
		}
		.header .title{
			font-size: 18px;
			color: #868686;
			float: left;
			font-weight: bold;
			line-height: 50px;
			cursor: pointer;
		}
		.header .self{
			float: right;
			font-size: 14px;
			line-height: 50px;
			color: #333;
		}
		.header .self a{
			color: #333;
			text-decoration: none;
		}
		.header .self a:hover{
			color: #00BBDD;
		}
		.cl{
			border: 1px solid #E1E1E1;
		}
		.box{
			background-color: #F4F4F4;
		}
		.box .mid{
			height: 50px;
			margin: 0 auto;
			width: 980px;
			padding: 30px 0 40px;
		}
		.box .mid .icon{
			height: 40px;
			width: 40px;
			background-image: url("images/icon-found.png");
			cursor: pointer;
			float: left;
		}
		.box .mid .tishi{
			height: 30px;
			width: 90px;
			margin-top: 5px;
			border-radius:10px;
			//display: none;
			color: #aaa;
			background-color: white;
			float: left;
			line-height: 30px;
			text-align: center;
			box-shadow: 1px 1px 2px #888888;
			display: none;
		}
		.box .mid .qipao{
			width:0;
            height:0;
            border-top:8px solid transparent;
            border-left:8px solid transparent;
            border-right:8px solid white;
            border-bottom:8px solid transparent;
            float: left;
            margin-left: 5px;
            margin-top: 12px;
            display: none;
		}
		.box .mid .search{
			float: right;
			margin-right: 300px;
			border: 1px solid rgb(0,187,211);
			margin-top: 5px;
			border-radius:5px;
		}
		.box .mid .search .shuru{
			height: 26px;
			width: 350px;
		}
		.box .mid .search .submit{
			width: 50px;
			height: 30px;
			background:rgb(0,187,211);
			color: white;
			cursor: pointer;
		}
		.box .mid .search .submit-change{
			background: rgb(0,163,195);
		}
		.box .running{
			height: 42px;
			line-height: 42px;
			font-size: 12px;
			color: #333;
			margin: 0 auto;
			width: 980px;
			border-bottom: 1px solid #E1E1E1;
		}
	</style>
	<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".icon").hover(function () {
                //alert("1");
                $(".tishi").show();
                $(".qipao").show();
            }, 
            function () {
                $(".tishi").hide();
                $(".qipao").hide();
            });
            $(".submit").mouseenter(function(){
            	//alert("1");
            	$(".submit").addClass("submit-change");
            })
            $(".submit").mouseleave(function(){
            	$(".submit").removeClass("submit-change");
            })
            $(".box").css({"height":window.innerHeight});
            $(".icon").click(function(){
            	$(location).attr('href', 'build-one.html');
            })
            $(".title").click(function(){
            	$(location).attr('href', 'homepage.html');
            })
		})
		function sub(){
			//做搜索的Ajax 
		}
	</script>
</head>
<body>
	<div class="header">
		<div class="title">我的会议</div>
		<div class="self">XXX &nbsp<a href="index.html">退出</a></div>
	</div>
	<div class="cl"></div>
	<div class="box">
		<div class="mid">
			<div class="icon" ></div><div class="qipao"></div><div class="tishi">创建会议</div>
			<div class="search"><input type="text" class="shuru" placeholder="输入会议名称" id="sousuo"><input type="button" value="搜索" class="submit" click="sub()"></div>
		</div>
		<div class="running">进行中的会议</div>
	</div>
</body>
</html>