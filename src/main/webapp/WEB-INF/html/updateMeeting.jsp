<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%--//时间格式化引用--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/bootstrap-fileinput.css" rel="stylesheet">
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
			font-size: 30px;
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
			font-size: 20px;
		}
		form .body .body-left{
			float: left;
			width: 100%;
			text-align: center;
			padding-left: 5%;
			/*border-right: 1px solid #e1e1e1;*/
		}
		.cl{
			clear: both;
		}
		form .body .body-left div{
			height: 55px;
			line-height: 66px;
			padding-top: 0px;
			width: 90%;
		}
		form .body .body-left div input{
			height: 30px;
			border: 1px solid #e1e1e1;
			padding-left: 9px;
			width: 80%;
		}
		select{
			height: 30px;
			width: 110px;
		}
		form .tail{
			text-align: center;
			/*padding-top: 40px;*/
			top: 40px;
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
		.item-title {
			line-height: 12px;
			font-size: 20px;
			color: #333;
			padding: 20px 0px 8px 0px;
		}

		form .body .form-group .selectPic{
			padding:100px;
		}
	</style>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-fileinput.js"></script>
</head>
<body>
<div class="wall"></div>
<form action="${pageContext.request.contextPath}/User/UpdateUserInfo"  enctype="multipart/form-data" method="post">
	<div class="header"><div class="fang"></div>会议信息</div>
	<div class="body">
		<div class="body-left">
			<div>会议名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="${meeting.mname}" id="username" name="mname"></div>
			<div>会议开始时间：<input type="text" value="${meeting.mtime}" id="mtime" name="mtime"></div>
			<div>会议地点：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="${meeting.mplace}" id="mplace" name="mplace"></div>
			<div>会议内容：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="${meeting.mcontent}" id="mcontent" name="mcontent"></div>
			<div>会议议程：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="${meeting.mflow}" id="mflow" name="mflow"></div>
			<div>会议指南：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="${meeting.mguide}" id="mguide" name="mguide"></div>
			<div style="height: 30px"></div>
		</div>
	</div>
	<div class="tail">
		<input type="submit" value="保存" class="save" />
		<input type="button" value="取消" class="cancel" />
	</div>
</form>
<div class="wall"></div>
</body>
</html>