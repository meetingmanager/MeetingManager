<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>会议管理系统</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/userShow.css"
	type="text/css" media="all" />
<style type="text/css">
.content-body {
	height: 300px;
	overflow-y: auto;
	width: 500px;
	margin-left: 50px;
}

.content-body-second {
	width: 580px;
	height: 250px;
	overflow-y: auto;
}

.content-body div {
	text-align: center;
}

.content-body div p {
	float: left;
	width: 49%;
}

.cl {
	clear: both;
}

.header {
	height: 50px;
	margin: 0 auto;
	width: 980px;
}

.header .title {
	font-size: 18px;
	color: #868686;
	float: left;
	font-weight: bold;
	line-height: 50px;
	cursor: pointer;
}

.header .self {
	float: right;
	font-size: 14px;
	line-height: 50px;
	color: #333;
}

.header .self input {
	color: #333;
	background-color: #FFFFFF;
	border: 0px none;
}

.header .self input:hover {
	color: #00BBDD;
	border: none;
	cursor: hand;
	cursor: pointer;
}

.header .self input:focus {
	outline: none;
}

.form {
	display: flex;
	flex-direction: column;
	width: 80%;
	text-align: left;
	justify-content: flex-start;
	margin: 50px auto;
	display: none;
}

label {
	font-size: 16px;
	color: #999;
	font-weight: 300;
	letter-spacing: 1.39px;
	width: 122px;
	display: inline-block;
}

td {
	text-align: center;
}

.form-group {
	margin-bottom: 30px;
}

#endTime, #startTime {
	text-align: left;
}

a {
	text-decoration: none;
}

.header {
	width: 100%;
}


</style>
</head>

<body style="background: #f5f5f5;" onload="Guest()">

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/function.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/json.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#cardArea").cardArea()
		});

		function timeFilter(dateStr) {
			var date = new Date(dateStr);
			var y = date.getFullYear();
			var m = (date.getMonth() + 1).toString().padStart(2, '0');
			var d = date.getDate().toString().padStart(2, '0');
			var hh = date.getHours().toString().padStart(2, '0');
			var mm = date.getMinutes().toString().padStart(2, '0');
			var ss = date.getSeconds().toString().padStart(2, '0');
			//return "${y}-${m}-${d} ${hh}:${mm}:${ss}";
			return y + "-" + m + "-" + d + " " + hh + ":" + mm;
		}

		$(function() {
			var meetingTime = $("#meetingTime").html();
			var return_date = timeFilter(meetingTime);
			$("#meetingTime").html(return_date);
		})

		function Guest() {
			var guestList = document.getElementById("guestList").innerHTML;
			var guestLists = jQuery.parseJSON(guestList);
			$.each(guestLists, function(index, value) { //列表的传入数据怎么传入
				$("#content-body").append(
						"<div>" + "<p>" + value.guestName + "</p>" + //这两个写什么
						"<p>" + value.guestTitle + "</p>" + "<div class='cl'>"
								+ "</div>" + "</div>");
			});

				var eat = document.getElementById("eat").innerHTML;
				var eats = jQuery.parseJSON(eat);
				
				var hotel = document.getElementById("hotel").innerHTML;
				var hotels = jQuery.parseJSON(hotel);
				console.log(hotels);
					eats.forEach((item)=>{
	                    var startTime=timeFilter(item.ettimestart);
	                    var endTime=timeFilter(item.ettimeend);
	                    var schoolName=item.etplace;
	                    var tab=document.getElementById('tab');
	                    var row=tab.insertRow(1);
	                    row.id=item.etnum ; //把行id命名成标识符item.标识符属性名
	                    var sN=row.insertCell(0);
	                    var sT=row.insertCell(1);
	                    var eT=row.insertCell(2);                 
	                    sN.innerHTML=schoolName;
	                    sT.innerHTML=startTime;
	                    eT.innerHTML=endTime;
	                });
					
					hotels.forEach((item)=>{
	                    var startTime=timeFilter(item.starttime);
	                    var endTime=timeFilter(item.endtime);
	                    var schoolName=item.hotelplace;
	                    var tab=document.getElementById('tabHotel');
	                    var row=tab.insertRow(1);
	                    row.id=item.htnum ; //把行id命名成标识符item.标识符属性名
	                    var sN=row.insertCell(0);
	                    var sT=row.insertCell(1);
	                    var eT=row.insertCell(2);                 
	                    sN.innerHTML=schoolName;
	                    sT.innerHTML=startTime;
	                    eT.innerHTML=endTime;
	                });
	           
			
			
		
			/*$.each(eats, function(index, value) { //列表的传入数据怎么传入
				var starttime = timeFilter(value.ettimestart);//
				var endtime = timeFilter(value.ettimeend);
				
				$("#content-eat").append(
						"<div>" + "<p>" + value.etplace + "</p>" + //这两个写什么
						"<p>" + starttime + "</p>" + "<p>" + endtime + "</p>"
								+ "<div class='cl'>" + "</div>" + "</div>");
			});*/
		}

		function Eat() {
		}
		function list() {
			// body...跳转函数
		}
		function postMsg() {
			$
					.ajax({
						url : "${pageContext.request.contextPath}/User/cancel", //请求的服务器地址
						type : 'post',
						data : {},//参数				

						success : function(data) {
							var data = eval('(' + data + ')');
							if (data.status == 1) {
								window.location
										.replace("${pageContext.request.contextPath}/html/index");
							} else if (data.status == 2) {
								alert("错误！");//成功后需要把这反馈改成在验证码右边显示
							}
							//假如账号冲突返回什么
						}
					})
		}
	</script>
	<script>
		function signon() {
			$.ajax({
				url : "${pageContext.request.contextPath}/SignOn/update", //请求的服务器地址
				type : 'post',
				success : return_date,
				error : return_erro
			});
			function return_date(data) {
				alert(data.msg);
			}
			function return_erro() {
				alert("签到失败!");
			}
		}
	</script>
	<div class="header">
		<div class="title">
			<a href="${pageContext.request.contextPath}/html/homepage">会议列表</a>
		</div>
		<div class="self">
			<span id="username"> xxx</span> &nbsp<input type="button"
				onclick="postMsg()" value="退出">
		</div>
	</div>
	<a id="meeting" name="meeting" style="display: none">${meeting}</a>
	<a id="guestList" name="guestList" style="display: none">${guestList}</a>
	<a id="seatnum" name="seatnum" style="display: none">${seatnum}</a>
	<a id="eat" name="eat" style="display: none">${eat}</a>
	<a id="hotel" name="hotel" style="display: none">${hotel}</a>
	<ul id="cardArea" class="card-area clearfix">
		<li class="card-item">
			<div class="card">
				<div class="card-title title-even">
					<div class="content">
						<h1>会议嘉宾信息</h1>
					</div>
				</div>
				<div class="card-content content-first">
					<div style="padding: 50px;">嘉宾参与，会议给力</div>
				</div>
				<div class="card-content content-second">
					<div class="main-info">
						<ul>
							<li style="height: 90px">
								<div class="left">
									<p class="tit">嘉宾资料</p>
								</div>

								<div class="content-body" id="content-body"></div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</li>
		<li class="card-item active">
			<div class="card">
				<div class="card-title title-even">
					<div class="content">
						<h1>会议基本信息</h1>
					</div>
				</div>
				<div class="card-content content-first">
					<div style="padding: 50px;">会议名称、会议时间、会议地点</div>
				</div>

				<div class="card-content content-second">
					<div class="main-info">
						<ul class="content-body-second">
							<li>
								<div class="left">
									<p class="tit">
										会议名称：<a style="font-size: 14px; color: #a9b0b4;">${meeting.mname}</a>
									</p>

								</div>
							</li>
							<li>
								<div class="left">
									<p class="tit">
										会议时间：<a style="font-size: 14px; color: #a9b0b4;"
											id="meetingTime">${meeting.mtime}</a>
									</p>

								</div>
							</li>
							<li>
								<div class="left">
									<p class="tit">
										会议地点：<a style="font-size: 14px; color: #a9b0b4;">${meeting.mplace}</a>
									</p>

								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</li>
		<li class="card-item">
			<div class="card">
				<div class="card-title title-even">
					<div class="content">
						<h1>会议座位与签到</h1>
					</div>
				</div>
				

				<div class="card-content content-second">
					<div class="main-info">
						<ul>
							<li>
								<div class="left">
									<p class="tit">会议座位</p>
									<p class="hys">${seatnum}</p>
								</div>
							</li>
							<li>
								<div class="left">
									<p class="tit">会议签到</p>
								</div>
								<div class="right">
									<button onclick="signon()">签到</button>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</li>
		<li class="card-item">
			<div class="card">
				<div class="card-title title-even">
					<div class="content">
						<h1>用餐</h1>
					</div>
				</div>
				<div class="card-content content-first">
					<div style="padding: 50px;">用餐</div>
				</div>

				<div class="card-content content-second">
					<div class="main-info">
						<ul>
							<li>
								<div class="content-body" id="content-eat">
									<div class="panel">
										<div class="panel-heading">
											<table class="table table-striped table-hover" id="tab">
												<thead>
													<tr>
														<td>用餐地点</td>
														<td>开始时间</td>
														<td>结束时间</td>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
									</div>

								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</li>
		
		<li class="card-item">
			<div class="card">
				<div class="card-title title-even">
					<div class="content">
						<h1>住宿</h1>
					</div>
				</div>
				<div class="card-content content-first">
					<div style="padding: 50px;">住宿</div>
				</div>

				<div class="card-content content-second">
					<div class="main-info">
						<ul>
							<li>
								<div class="content-body" id="content-eat">
									<div class="panel">
										<div class="panel-heading">
											<table class="table table-striped table-hover" id="tabHotel">
												<thead>
													<tr>
														<td>住宿地点</td>
														<td>开房时间</td>
														<td>退房时间</td>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
									</div>

								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</li>
		<!--  
	 <li class="card-item">
		<div class="card">
			<div class="card-title title-even">
				<div class="content"><h1>电商与业务</h1></div>
			</div>
			<div class="card-content content-first">
				<div style="padding:50px;">结合大数据能力，帮助企业快速搭建各大电商平台</div>
			</div>

			<div class="card-content content-second">
				<div class="main-info">
                	<ul>
                    	<li>
                        	<div class="left">
                            	<p class="tit">店铺购买</p>
                                <p class="hys">国内专业店铺交易平台</p>
                            </div>
                            <div class="right">
                            	<button>查看详情</button>
                            </div>
                        </li>
                    	<li>
                        	<div class="left">
                            	<p class="tit">店铺评估/出售</p>
                                <p class="hys">由专业人员进行评估、交易</p>
                            </div>
                            <div class="right">
                            	<button>查看详情</button>
                            </div>
                        </li>
                    </ul>
				</div>
			</div>
		</div>
	</li>-->
	</ul>


</body>

<script>
	
</script>
</html>
