<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加入临时会议</title>
	<style type="text/css">
		html, body, div, ul, li, h1, h2, h3, h4, h5, h6, p, dl, dt, dd, ol, form, input, textarea, th, td, select {
    		margin: 0;
   		 	padding: 0;
		}
		body{
			background-color: #f4f4f4;
		}
		.wall{
			height: 40px;
		}
		form{
			width: 60%;
			background-color: white;
			margin: auto;
		}
		form .header{
			width: 90%;
			margin:auto;
			border-bottom: 1px solid #e1e1e1;
			padding-top: 14px;
			padding-bottom: 14px; 
		}
		.fang{
			height: 9px;
			width: 9px;
			display:inline-block;
			background-color: #0bd;
			margin-right: 16px;
		}
		form .body{
			padding-top: 0px;
			width: 86%;
			margin: auto;
			font-size: 12px;
		}
		form .body .body-center{
			float: center;
			width: 50%;
			border-right: 1px solid #e1e1e1;
		}
		form .body .body-left div,.body .body-right div{
			height: 28px;
			line-height: 28px;
			padding-top: 0px;
		}
		form .body .body-left input,.body .body-right input{
			height: 30px;
			border: 1px solid #e1e1e1;
			padding-left: 9px;
			width: 90%;
		}
		form .tail{
			text-align: center;
			padding-top: 40px;
			padding-bottom: 40px;
		}
		form .tail .save{
			height: 30px;
			width: 94px;
			padding-left: 22px;
			padding-right: 22px;
			font-size: 12px;
			color:#0bd;
			border: 1px solid #0bd;
			background-color: white;
			cursor: pointer;
			margin-right: 20px;
		}
		form .tail .cancel{
			height: 30px;
			width: 94px;
			padding-left: 22px;
			padding-right: 22px;
			font-size: 12px;
			color:#666;
			border: 1px solid #666;
			background-color: white;
			cursor: pointer;
		}
	</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/participants/applyJoinMeeting">
		<div class="body">
			<div class="tail">请输入临时会议号</div>
			<div class="body-center" style="width:100%;text-align:center">
				<input type="text" id="mnum" name="mnum" style="height:25px;padding-left:8px">
				${message}
			</div>
			<div class="tail">
				<input type="submit" value="保存" class="save" />
				<input type="button" value="取消" class="cancel" onclick="window.location.href='${pageContext.request.contextPath}/html/homepage'"/>
			</div>
		</div>
	</form>
</body>
</html>