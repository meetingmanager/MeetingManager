<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
		.header .title a{
			font-size: 18px;
			color: #868686;
			float: left;
			font-weight: bold;
			line-height: 50px;
			text-decoration: none;
		}
		.header .self{
			float: right;
			font-size: 14px;
			line-height: 50px;
			color: #333;
		}
		.header .self input{
    	    color: #333;    
    	    background-color: #FFFFFF;
    	    border: 0px none;
    	}
    	.header .self input:hover{
    	    color: #00BBDD;
    	    border: none;
    	    cursor: hand;
    	    cursor: pointer;
    	}
    	.header .self input:focus { 
    	    outline: none;    
    	}
		.cl{
			border: 1px solid #E1E1E1;
		}
		.box{
			background-color: #F4F4F4;
			color: #333;
		}
		.box .content{
			margin: 0 auto;
			width: 980px;
		}
		.box .content p{
			height: 40px;
			line-height: 40px;
			font-size: 12px;
		}
		.box .content p a{
			color: #333;
			text-decoration: none;
		}
		.box .content p a:hover{
			text-decoration: underline;
		}
		.box .content .content-main{
			background-color: white;
			padding-top: 60px;
			height: 980px;
		}
		.box .content .content-main form{
			width: 600px;
			margin: 0 auto;
		}
		.box .content .content-main form span{
			color: red;
		}
		.box .content .content-main form input{
			width: 600px;
			height: 30px;
			border: 1px solid #ccc;
		}
		.box .content .content-main form textarea{
			border: 1px solid #ccc;
		}
		.box .content .content-main form .wall{
			padding-top: 40px;
			text-align: center;
		}
		.box .content .content-main form p .right-btn{
			border: 1px solid #0bd;
			width: 90px;
			height: 30px;
			color: #0bd;
			background-color: white;
			border-radius:3px;
			margin-left: 5px;
			cursor: pointer;
		}
		.box .content .content-main form p .left-btn{
			border: 1px solid #666;
			width: 90px;
			height: 30px;
			color: #666;
			background-color: white;
			border-radius:3px;
			margin-right: 5px;
			cursor: pointer;
		}
	</style>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/build-one.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/laydate.js"></script>

<script type="text/javascript">
        !function () {
            laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
            laydate({ elem: '#demo' });//绑定元素
        }();
  </script>


</head>
<body>
	<div class="header">
		<div class="title"><a href="${pageContext.request.contextPath}/html/homepage.jsp">我的会议</a></div>
		<div class="self">XXX &nbsp<input type="button" onclick="postMsg()" value="退出"></div>
	</div>
	<div class="cl"></div>
	<div class="box">
		<div class="content">
			<p>当前位置：<a href="${pageContext.request.contextPath}/html/homepage">会议列表</a> > 创建临时会议</p>
			<div class="content-main">
				<form action="" name="date" id="one">
					<p id="bd">会议名称: <span>*</span></p><input type="text" name="" id="huiyi">
					<p>会议开始时间: <span>*</span></p>
			       
			            <input id = "time" placeholder="请输入日期" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" />
			  
					<!-- <input type="date" value="2015-09-24"/>
					<select name="year" id="sele1" onchange="sele(this.id)"><option value="">选择 年</option></select>
					<select name="month" id="sele2" onchange="sele(this.id)"><option value="">选择 月</option></select>
					<select name="day" id="sele3" onchange="sele(this.id)"><option value="">选择 日</option></select>
					<select name="hour" id="sele4" onchange="sele(this.id)"><option value="">选择 小时</option></select>
					<select name="minute" id="sele5" onchange="sele(this.id)"><option value="">选择 分钟</option></select> -->
				
					<!-- <p>会议结束时间: <span>*</span></p>
					<select name="year_end" id="sele6" onchange="sele(this.id)"><option value="">选择 年</option></select>
					<select name="month_end" id="sele7" onchange="sele(this.id)"><option value="">选择 月</option></select>
					<select name="day_end" id="sele8" onchange="sele(this.id)"><option value="">选择 日</option></select>
					<select name="hour_end" id="sele9" onchange="sele(this.id)"><option value="">选择 小时</option></select>
					<select name="minute_end" id="sele10" onchange="sele(this.id)"><option value="">选择 分钟</option></select> -->
					<p>地点: <span>*</span></p><input type="text" name="" id="place">
					<p>内容: <span>*</span></p><textarea name="" id="content" cols="91" rows="10"></textarea>
					<p>会议议程</p><textarea name="" id="yicheng" cols="91" rows="10"></textarea>
					<p>参会指南</p><textarea name="" id="zhinan" cols="91" rows="10"></textarea>
					<p class="wall">
						<input type="button" value="取消" class="left-btn" onclick="window.location.href='${pageContext.request.contextPath}/html/homepage'">
						<input type="button" value="完成" class="right-btn" onclick="check()">
					</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>