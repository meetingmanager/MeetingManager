<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会议管理系统</title>
<link rel="stylesheet" type="text/css"
	href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<style>
html {
	/*height: 100%;*/
	
}

body {
	/*padding: 100px;*/
	/*height: 100%;*/
	
}

::-webkit-scrollbar {
	width: 9px;
	height: 9px;
}

::-webkit-scrollbar-track-piece {
	background-color: #ebebeb;
	-webkit-border-radius: 4px;
}

::-webkit-scrollbar-thumb:vertical {
	height: 32px;
	background-color: #ccc;
	-webkit-border-radius: 4px;
}

::-webkit-scrollbar-thumb:horizontal {
	width: 32px;
	background-color: #ccc;
	-webkit-border-radius: 4px;
}

ul, li {
	padding: 0;
	margin: 0
}

.mySelect {
	position: relative;
}

.mySelect .inputWrap {
	width: 100%;
	min-height: 40px;
	border: 1px solid #ccc;
	border-radius: 3px;
	position: relative;
	cursor: pointer;
}

.mySelect ul {
	padding: 0 5px;
	margin: 0;
	padding-right: 35px;
}

.mySelect ul, li {
	list-style: none;
}

.mySelect li {
	display: inline-block;
	background: #eaeaea;
	padding: 5px;
	margin: 5px 5px 5px 0;
	border-radius: 5px;
}

.mySelect .fa-close {
	cursor: pointer;
}

.mySelect .fa-close:hover {
	color: #237eff;
}

.mySelect .mySelect-option {
	width: 100%;
	border: 1px solid #ccc;
	max-height: 200px;
	overflow-y: scroll;
	position: absolute;
	height: 0;
	opacity: 0;
}

.mySelect .mySelect-option div {
	padding: 10px;
}

.mySelect .inputWrap>i {
	position: absolute;
	padding: 13px;
	right: 0;
	top: 0;
}

.mySelect-option div {
	cursor: pointer;
	border-bottom: 1px solid #e7e7e7;
	margin: 5px;
}

.mySelect-option div i {
	float: right;
	color: #ffffff;
}

.mySelect-option div.selected {
	background: #237eff;
	color: #ffffff;
	border-radius: 5px;
}

.noselected {
	background: #a9afb7;
	color: #ffffff;
	border-radius: 5px;
}

.mySelect-option div:hover {
	/*background: #9ec6ff;*/
	color: #9ec6ff;
	border-bottom: 1px solid #9ec6ff;
}

.tail {
	text-align: center;
	padding-top: 27px;
	padding-left: 69px;
	padding-bottom: 0px;
}

.tail .save {
	height: 30px;
	width: 94px;
	padding-left: 22px;
	padding-right: 22px;
	font-size: 12px;
	color: #0bd;
	border: 1px solid #0bd;
	background-color: white;
	cursor: pointer;
	margin-right: 20px;
}

.tail  {
	height: 30px;
	width: 100%;
	padding-left: 22px;
	padding-right: 22px;
	font-size: 12px;
	color: #666;
	/*border: 1px solid #666;*/
	background-color: white;
	cursor: pointer;
}
.cancel {
	height: 30px;
	width: 94px;
	padding-left: 33px;
	padding-right: 33px;
	padding-top: 6px;
	padding-bottom: 8px;
	font-size: 12px;
	color: #666;
	border: 1px solid #666;
	background-color: white;
	cursor: pointer;
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
</style>
</head>
<body>
	<a id="list" name="list" style="display: none">${list}</a>
	<a id="htnum" name="htnum" style="display: none">${htnum}</a>
	<!--<div style="float: left; position: relative">&nbsp;&nbsp;多选&nbsp;&nbsp;</div>-->
	<div class="tail">
		<div id="mySelect" class="mySelect" style="width: 50%; float: left"></div>
		<div style="padding-left: 580px; width: 20%">
			<div style="width: 96px;height:32px">
				<input type="button" value="保存" class="save" onclick="save()" />
			</div>
			<div style="width: 96px;height:32px;margin: -26px 0px 0 100px;">
				<a href="${pageContext.request.contextPath}/html/eat" class="cancel">取消</a>
			</div>
		</div>
		<!--<input type="button" value="一键全选" class="save" onclick="doSelectAll()" /> -->
		<!--<input type="button" value="取消全选" class="cancel" onclick="doRemoveAll()" />-->
	</div>
	<div style="padding-top: 14px">
		<div id="app">
			<div class="panel">
				<div class="panel-heading">
					<table class="table table-striped table-hover" id="tab">
						<thead>
							<tr>
								<td>姓名</td>
								<td>电话号码</td>
								<td>性别</td>
								<td>操作</td>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/json.js"></script>
	<script src="${pageContext.request.contextPath}/js/select.js"></script>
	<script>
	//页面加载时获取数据
    window.onload=function () {  
    	var htnum1 = document.getElementById("htnum").innerHTML;
        var url='${pageContext.request.contextPath}/hotel/selectUser'; //要请求的服务器url
        $.ajax({
            type: "POST",
            async:true,
            url:url, //请求路径
            data: {htnum:htnum1},  //请求参数
            dataType: "json",
            success: (list)=>{
                list.forEach((item)=>{
                	//alert(item.username);
                    var userName=item.username;
                    var Phone=item.phone;
                    var userSex=item.usersex;
                    
                    var tab=document.getElementById('tab');
                    var row=tab.insertRow(1);
                    row.id=item.hnum ; //把行id命名成标识符item.标识符属性名
                    
                    var uN=row.insertCell(0);
                    var phone=row.insertCell(1);
                    var uS=row.insertCell(2);//留一个删除，就可以
                    var option=row.insertCell(3);
                    uN.innerHTML=userName;
                    phone.innerHTML=Phone;
                    uS.innerHTML=userSex;               
                    option.innerHTML='<input type="button" class="btn btn-link" onclick="delForm(this)" value="删除">';
                });

            }
        });
    };
	
	</script>

	<script>
		var list = document.getElementById("list").innerHTML;
		var lists = jQuery.parseJSON(list);

		var htnum = document.getElementById("htnum").innerHTML;
		var options = new Array();
		var res1 = new Array();
		var selectAll = new Array();
		var mySelect;
		$.each(lists, function(index, value) {
			var option = {
				label : value.pname,
				value : value.pnum
			};
			options[index] = option;
			selectAll[index] = value.pnum;
			console.log("ainiyo..." + selectAll);
		});
		$(function() {
			mySelect = $("#mySelect").mySelect({
				mult : true,//true为多选,false为单选
				option : options,
				onChange : function(res) {//选择框值变化返回结果
					res1 = res;
				}
			});
			mySelect.setResult(selectAll);
		})
		function save() {
			console.log("res1[]..." + res1);
			var url = '${pageContext.request.contextPath}/hotel/insertHotelTab'; //要请求的服务器url
			$.ajax({
						url : url,//要请求的服务器url
						data : {
							res : res1,
							htnum : htnum
						}, //传标识符，id未标识符的值
						async : true, //是否为异步请求
						type : "POST", //请求方式为POST
						//dataType:"json",   //服务器返回的数据是什么类型
						success : function(data) {
							var data = eval('(' + data + ')');
							//alert("测试");
							if (data.status == 1) {
								var htnum = document.getElementById("htnum").innerHTML;
								window.location.href="${pageContext.request.contextPath}/hotel/selectHotelParticipants?htnum="+htnum;
							}
						}
					});

		}

		function doSelectAll() {

		}
		function doRemoveAll() {

			var rmall = document.getElementById("fa fa-close");
			console.log("yes");
			for (var i = 0; i < rmall.length; i++) {
				console.log(rmall[i]);
				rmall[i].click();
			}
		}
		
		function delForm(obj) {
	        var tr = obj.parentNode.parentNode;
	        var flag=tr.id;
	        
	        var url='${pageContext.request.contextPath}/hotel/deleteHotelTab';  //要请求的服务器url
	        $.ajax({
	            url:url,//要请求的服务器url
	            data:{
	            	hnum:flag
	            },  //传标识符，id未标识符的值
	            async:true,   //是否为异步请求
	            type:"POST", //请求方式为POST
	            //dataType:"json",   //服务器返回的数据是什么类型
	            success: function(data){
				 	var data = eval('(' + data + ')');
					//alert("测试");
					
					if (data.status==1){
						var htnum = document.getElementById("htnum").innerHTML;
						window.location.href="${pageContext.request.contextPath}/hotel/selectHotelParticipants?htnum="+htnum;
						//location.href="http://www.baidu.com";
					}  
	            }
	        });

	    }
	</script>
</body>
</html>