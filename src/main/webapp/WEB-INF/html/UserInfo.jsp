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
		form .body .body-left{
			float: left;
			width: 50%;
			border-right: 1px solid #e1e1e1;
		}
		form .body .body-right{
			float: left;
			width: 45.5%;
			padding-left: 4.3%;
		}
		.cl{
			clear: both;
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
		select{
			height: 30px;
			width: 110px;
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
		.item-title {
		    line-height: 12px;
		    font-size: 12px;
		    color: #333;
		    padding: 20px 0px 8px 0px;
		}
		
		form .body .body-right .form-group .selectPic{
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
		<div class="header"><div class="fang"></div>用户信息</div>
		<div class="body">
			<div class="body-left">
				<div>姓名：</div><input type="text" value="${user.username}" id="username" name="username">
				<div>电子邮箱：</div><input type="text" value="${user.email}" id="email" name="email">
				<div>性别：</div>
					<select name = "usersex" value="${user.usersex}">
					  <option value ="男">男</option>
					  <option value ="女">女</option>
					</select>
				<div>手机号码：</div><input type="text" value="${user.phone}" id="phone" name="phone">	
			</div>
			<div class="body-right">
				<div class="form-group" >
                <div class="fileinput fileinput-new selectPic" data-provides="fileinput"  id="exampleInputUpload">
                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                        <img id='picImg' style="width: 100%;height: auto;max-height: 140px;" src="/pictures/${user.headphoto}" alt="" />
                    </div>
                    <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                    <div>
                        <span class="btn btn-primary btn-file">
                            <span class="fileinput-new">选择文件</span>
                            <span class="fileinput-exists">换一张</span>
                            <input type="file" name="pic1" id="picID" accept="image/gif,image/jpeg,image/x-png"/>
                        </span>
                        <a href="javascript:;" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
                    </div>
                </div>
            </div>
			</div>
            
			<p class="cl"></p>
		</div>
		<div class="tail">
			<input type="submit" value="保存" class="save" />
			<input type="button" value="取消" class="cancel" />
		</div>
	</form>
	<div class="wall"></div>
</body>
</html>