<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>会议管理系统</title>
    <!--引入css,配置成你的路径-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <!--引入js,配置成你的路径-->
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>

    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/style1.css"/>
    <style>
        .form {
            display: flex;
            flex-direction: column;
            width: 80%;
            text-align: left;
            justify-content:flex-start;
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
        #endTime,#startTime {
            text-align: left;
        }

        a {
            text-decoration: none;
        }
        .header {
            width: 100%;
        }
        .h_left {
            width: 200px;
            height: 75px;
            line-height: 75px;
            text-align: center;
            overflow: hidden;
            float: left;
        }
        .h_right {
            float: right;
            height: 75px;
            line-height: 75px;
            vertical-align: center;
            padding-right: 70px;
        }
        .login .login-input .sel{
        	height:35px;
        	width:350px;
        }
        .row{
        	display:none;
        }
        .gstate-change{
            width: 13%;
            height: 145px;
            position: absolute !important;
            border: 1px solid black;
            border-radius:10px;
            background-color: #fff;
            display: none;
            color: red;
            margin-left: 160px;
            margin-top: -135px;
            /*z-index:999;*/
        }
    </style>
</head>
<body>

<div class="login">
    <div class="login-title">修改嘉宾参会状态<span><a href="javascript:void(0);" class="close-login">关闭</a></span></div>
    <div class="login-input-content">
        <div class="login-input">
            <label>&nbsp;&nbsp;状&nbsp;态：</label>
            <select id="username" class = "sel">
                 <option>出席</option>
                 <option>不出席</option>
                 <option>晚到</option>
            </select>
        </div>
        <div class="login-input">
            <label>&nbsp;&nbsp;原&nbsp;因：</label>
            <input type="text" placeholder="请输入原因" name="reason" id="reason" class="list-input"/>
        </div>
        <input type="text" name="Gnum" id="Gnum" style="display:none"/>
        <!-- <div id="gnum"></div> -->
    </div>
    <div class="login-button"><a href="javascript:void(0);" id="login-button-submit">更改状态</a></div>
</div>
<div class="login-bg"></div>

<div id="app">
    <div class="panel">
        <div class="panel-heading">
            <div class="header">
                <span class="h_left"><h3>添加嘉宾</h3></span>
                <span class="h_right"> <button type="button" class="btn btn-info btn-sm" onclick="addForm()">+添加嘉宾</button></span>
            </div>
            <table class="table table-striped table-hover" id="tab">
                <thead>
                <tr>
                    <td>嘉宾姓名</td>
                    <td>联系方式</td>
                    <td>职位</td>
                    <td>介绍</td>
                    <td>参会状态</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
    <div class="form" id="form">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="gname" class="col-sm-2 control-label">嘉宾姓名:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="gname" placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="gphone" class="col-sm-2 control-label">联系方式:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="gphone" placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="gtitle" class="col-sm-2 control-label">嘉宾职称:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="gtitle" placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="gintroduction" class="col-sm-2 control-label">嘉宾简介:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="gintroduction" placeholder="">
                </div>
            </div>
            <div class="form-group" style="display: none">
                <label for="flag" class="col-sm-2 control-label">标识</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="flag" placeholder="">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button class="btn btn-info" type="button" onclick="formSubmit()">保存并提交</button>
                    <button  class="btn btn-default" type="button" onclick="formCancle()">取消</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script>
    //页面加载时获取数据
        let url='${pageContext.request.contextPath}/guest/selectGuest'; //要请求的服务器url
        $.ajax({
            type: "POST",
            async:true,
            url:url, //请求路径
            data: {},  //请求参数
            dataType: "json",
            success: (list)=>{
                list.forEach((item)=>{
                    var gname=item.gname;
                    var gphone=item.gphone;
                    var gtitle=item.gtitle;
                    var gintroduction=item.gintroduction;
                    var gstate=item.gstate;
                    var greason=item.greason;
                    var tab=document.getElementById('tab');
                    var row=tab.insertRow(1);//需要这个row的值
                    row.id=item.gnum ; //把行id命名成标识符item.标识符属性名
                    var sN=row.insertCell(0);
                    var sT=row.insertCell(1);
                    var eT=row.insertCell(2);
                    var TY=row.insertCell(3);
                    var AA=row.insertCell(4);
                    var option=row.insertCell(5);
                    sN.innerHTML=gname;
                    sT.innerHTML=gphone;
                    eT.innerHTML=gtitle;
                    TY.innerHTML=gintroduction;
                    AA.innerHTML="<div class='login-header'><a href='javascript:void(0);' class = 'a' onmousemove='gstate_show(this)' onmouseout='gstate_out(this)'>"+gstate+"</a>" +
                        "<div class='gstate-change'>"+greason+"</div>"+
                        "</div>"+
                        "<div class='row'>"+row.id+"</div>";
                    option.innerHTML='<input type="button" class="btn btn-link" onclick="displayForm(this)" value="编辑">'+
                        	'<input type="button" class="btn btn-link" onclick="delForm(this)" value="删除">'
                });
			state();
            }
        });

    function state(){
    	H_login = {};
        H_login.openLogin = function(){
            $('.login-header a').click(function(){
            	var username = document.getElementById("username");
            	var Gnum = document.getElementById("Gnum");
            	var Row = document.getElementsByClassName("row");
            	username.value = this.innerHTML;
            	Gnum.value = Row[$('.a').index(this)].innerHTML;
                $('.login').show();
                $('.login-bg').show();
            });
        };
        H_login.closeLogin = function(){
            $('.close-login').click(function(){
                $('.login').hide();
                $('.login-bg').hide();
            });
        };
        H_login.loginForm = function () {
            $("#login-button-submit").on('click',function(){
                  var username = $("#username");
                  var usernameValue = $("#username").val();
                  var reason = $("#reason");
                  var reasonValue = $("#reason").val();
                  var gnumValue = $("#Gnum").val();;
                if(reasonValue == ""){
                    alert("原因不能为空");
                    password.focus();
                    return false;
                }else{
                	$.ajax({
                        url:"${pageContext.request.contextPath}/guest/updateState",//要请求的服务器url
                        data:{
                            gnum:gnumValue,
                            gstate:usernameValue,
                            greason:reasonValue
                        },
                        async:true,   //是否为异步请求
                        type:"POST", //请求方式为POST
                        success: function(data){
            			 	var data = eval('(' + data + ')');
            				//alert("测试");
            				if (data.status==1){
            					location.href="${pageContext.request.contextPath}/guest/show";
            					//location.href="http://www.baidu.com";
            				}
                        }
                    });
                }
            });
        };
        H_login.run = function () {
            this.closeLogin();
            this.openLogin();
            this.loginForm();
        };
        H_login.run();
    }
    //点击添加
    function addForm() {
       // alert("添加");
        document.getElementById('form').style.display='block';
        document.getElementById('gname').value="";
        document.getElementById('gphone').value="";
        document.getElementById('gtitle').value="";
        document.getElementById('gintroduction').value="";
    }
    //点击编辑
    function displayForm(obj){
        var tr = obj.parentNode.parentNode;
        var gname=tr.cells[0].innerText;
        var gphone=tr.cells[1].innerText;
        var gtitle=tr.cells[2].innerText;
        var gintroduction=tr.cells[3].innerText;
        document.getElementById('gname').value=gname;
        document.getElementById('gphone').value=gphone;
        document.getElementById('gtitle').value=gtitle;
        document.getElementById('gintroduction').value=gintroduction;
        document.getElementById('flag').value=tr.id;
        document.getElementById('form').style.display='block';
    }
    function delForm(obj) {
        var tr = obj.parentNode.parentNode;
        var flag=tr.id;
        var url='${pageContext.request.contextPath}/guest/delete';  //要请求的服务器url
        $.ajax({
            url:url,//要请求的服务器url
            data:{
                gnum:flag
            },  //传标识符，id未标识符的值
            async:true,   //是否为异步请求
            type:"POST", //请求方式为POST
            //dataType:"json",   //服务器返回的数据是什么类型
            success: function(data){
			 	var data = eval('(' + data + ')');
				//alert("测试");
				if (data.status==1){
					location.href="${pageContext.request.contextPath}/guest/show";
					//location.href="http://www.baidu.com";
				}
            }
        });

    }
    //点击取消
    function formCancle(){
        document.getElementById('form').style.display='none';
    }
    function formSubmit(){
        if ( document.getElementById('gname').value=='') {
            alert("请输入嘉宾姓名");
            return;
        }else if( document.getElementById('gphone').value==''){
            alert("请输入嘉宾联系方式");
            return;
        }else {
            if (document.getElementById('flag').value==''){
                var url='${pageContext.request.contextPath}/guest/insert'; //新增
                var data = {
                	gname:document.getElementById('gname').value,
                	gphone:document.getElementById('gphone').value,
                	gtitle:document.getElementById('gtitle').value,
                	gintroduction:document.getElementById('gintroduction').value,
                };
            } else {
                var url='${pageContext.request.contextPath}/guest/update'; //更新
                var data = {
               		gname:document.getElementById('gname').value,
                   	gphone:document.getElementById('gphone').value,
                   	gtitle:document.getElementById('gtitle').value,
                   	gintroduction:document.getElementById('gintroduction').value,
                    gnum:document.getElementById('flag').value
                };
            }
            $.ajax({
                url:url,//要请求的服务器url
                //看一下参数名字是否匹配
                data:JSON.stringify(data),
                async:true,   //是否为异步请求
                type:"POST", //请求方式为POST
                //dataType:"json",   //服务器返回的数据是什么类型
                contentType:"application/json",
                success: function(data){
			 	var data = eval('(' + data + ')');
				//alert("测试");
				if (data.status==1){
					location.href="${pageContext.request.contextPath}/guest/show";
					//location.href="http://www.baidu.com";
				}
			}
            });
        }

    }
</script>
<%--参会原因显示--%>
<script>
    function gstate_show(obj){
        var gstate_reason = obj.parentNode.lastChild;
        if (gstate_reason.innerHTML != ''){
            gstate_reason.style.display = "block";
        }
    }

    function gstate_out(obj){
        var gstate_reason = obj.parentNode.lastChild;
        gstate_reason.style.display = "none";
    }
</script>
</html>
