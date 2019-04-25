<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 4.01 Transitional//EN">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>会议管理系统</title>
	<style type="text/css">
		html, body, div, ul, li, h1, h2, h3, h4, h5, h6, p, dl, dt, dd, ol, form, input, textarea, th, td, select {
    		margin: 0;
   		 	padding: 0;
		}
		body{
			background-color: #f4f6f9;
		}
		form{
			margin-top: 40px;
			margin-bottom: 40px;
		}
		form .Mall{
			padding-left: 25px;
			padding-right: 25px;
			margin:auto;
			margin-bottom: 14px;
			background-color: white;
			width: 55%;
			padding-bottom: 25px;
		}
		form .Mname{
			font-size: 24px;
			line-height: 104px;
			height: 104px;
		}
		form div .Mbtn{
			margin-left: 80%;
			width: 60px;
			height: 25px;
			line-height: 25px;
			background-color: #61a6f5;
			border: hidden;
			cursor: pointer;
			border-radius:5px;
			color: white;
		}
		form div .Mbtn:hover{
			color: black;
			background-color: #4090ec;
		}
		form .Mall .Mcon{
			margin-bottom:0px;
			padding-left: 14%;
			width: 75%;
			word-wrap:break-word;
			color:#666;
		}
		#targin{
			background-color: white;
			border-radius:15px;
			width: 41%;
			border: 1px solid black;
			position: absolute;
			left: 30%;
			position:fixed;
			display: none;
		}
		#targin #targin-name{
			font-size: 18px;
			padding-left: 25px;
			height: 50px;
			line-height: 50px;
		}
		#targin div{
			padding-left: 25px;
		}
		#targin div #Minp{
			height: 100px;
			width: 95%;
		}
		#targin .btn{
			padding-top: 20px;
			padding-bottom: 20px;
		}
		#targin .btn input,.btnTop{
			width: 60px;
			height: 25px;
			line-height: 25px;
			border: hidden;
			cursor: pointer;
			border-radius:5px;
		}
		.btnTop{
			width: 80px;
			height: 40px;
			line-height: 40px;
			border: hidden;
			cursor: pointer;
			border-radius:5px;
			background-color: skyblue;
		}
		.btnT{
			margin:20px auto;
			padding-left: 68%;
		}
		.Mcon-con{
			height: 100px;
			width: 95%;
		}
		.others{
			display: none;
		}
	</style>
</head>
<body onload="sub()">
	<form action="${pageContext.request.contextPath}/meeting/update">
		<input type="text" value="${meeting.mnum}" name="mnum" class="others">
		<div class="btnT">
			<input type="submit" value="确认" class="btnTop">
			<input type="button" value="取消" class="btnTop" onclick="Go()">
		</div>
		<div id="targin">
			<div id="targin-name">会议名称</div>
			<div><textarea id="Minp"></textarea></div>
			<div class="btn">
				<input type="button" value="确定" id="yes">
				<input type="button" value="取消" id="no">
			</div>
		</div>
		<div class="Mall">
			<div><span class="Mname">会议名称</span><input type="button" value="修改" class="Mbtn"></div>
			<div class="Mcon"><textarea class="Mcon-con" type="text" name="mname" readonly="readonly">${meeting.mname}</textarea></div>
		</div>
		<div class="Mall">
			<div><span class="Mname">会议时间</span><input type="button" value="修改" class="Mbtn"></div>
			<div class="Mcon"><textarea class="Mcon-con" name = "mtime" readonly="readonly" >${meeting.mtime}</textarea></div>
		</div>
		<div class="Mall">
			<div><span class="Mname">会议地点</span><input type="button" value="修改" class="Mbtn"></div>
			<div class="Mcon"><textarea class="Mcon-con" name = "mplace" readonly="readonly">${meeting.mplace}</textarea></div>
		</div>
		<div class="Mall">
			<div><span class="Mname">会议内容</span><input type="button" value="修改" class="Mbtn"></div>
			<div class="Mcon"><textarea class="Mcon-con" name = "mcontent" readonly="readonly">${meeting.mcontent}</textarea></div>
		</div>
		<div class="Mall">
			<div><span class="Mname">会议议程</span><input type="button" value="修改" class="Mbtn"></div>
			<div class="Mcon"><textarea class="Mcon-con" name = "mflow" readonly="readonly">${meeting.mflow}</textarea></div>
		</div>
		<div class="Mall">
			<div><span class="Mname">会议指南</span><input type="button" value="修改" class="Mbtn"></div>
			<div class="Mcon"><textarea class="Mcon-con" name = "mguide" readonly="readonly">${meeting.mguide}</textarea></div>
		</div>
	</form>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/updataMeeting.js"></script>
</body>
</html>