<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>会议管理系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/audit.css" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/json.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/audit.js"></script>
</head>

<body onload="judgeAll()">
	<a id="list" name="list" style="display:none">${list}</a>
	<form>
		<div class="name">会议名称</div>
		<div style="color: #888;padding-left: 25px;padding-bottom: 16px">待审核人员</div>
		<div class="body">
			<div class="human">
				<div class="humanName1">待审核人员姓名</div>
				<div class="judge1">是否同意加入此会议</div>
				<div class="cl"></div>
			</div>
		</div>
		<div style="padding-top: 25px"></div>
	</form>
</body>
</html>