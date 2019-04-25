<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>会议管理系统</title>
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/image/vim_shortcut.ico">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mycss.css">
	<script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/myjs.js"></script>
</head>
<body >
	<!-- 页面加载时，传入mnum和userid -->
	<a id="mnum" name="mnum" style="display:none">${mnum}</a>
	<a id="userid" name="userid" style="display:none">${userid}</a>
	<!-- 导航 -->
	<nav class="navbar navbar-inverse navbar-fixed-top ">
		<div class="container ">
			<div class="navbar-header">
				<a class="navbar-brand" href="">
					<span class="glyphicon glyphicon-th-large"></span >
					会议聊天室
				</a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse">
				<form class="navbar-form navbar-left">
					<div class="form-group ">
						<input type="text" class="form-control " placeholder="请输入内容" id="chat">
					</div>
					<button type="button" class="btn btn-warning " id="sendMessage">发送</button>
					<button type="button" class="btn btn-danger "  onclick="clean()">删除记录</button>
				</form>

			</div>

		</div>
	</nav>

	<br><br><br>
	<!-- 主体模块 -->
	<div class="container-fluid main">
		<div class="row">
			<div class="col-md-9">
				<ul class="media-list" id="messageList"> 
					<!-- 存放消息 -->
				</ul>
			</div>
			<div class="col-md-3 hidden-xs hidden-sm ">
				<div class="list-group " id="userlist">
					<!-- 存放在线用户 -->
				</div>
			</div>
		</div>
	</div>

	<!--
		 登陆必须先输入名字
		隐藏模态框
	-->
	<div class="container">
		<div class="modal fade " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true" data-backdrop="static" data-keyboard="false">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h2 class="modal-title" id="myModalLabel">创建群聊</h2>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-info " onclick="savename()">确定</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>