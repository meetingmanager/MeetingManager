<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!--引入css,配置成你的路径-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <!--引入js,配置成你的路径-->
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
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
    </style>
</head>
<body>
<div id="app">
    <div class="panel">
        <div class="panel-heading">
            <div class="header">
                <span class="h_left"><h3>添加住宿</h3></span>
                <span class="h_right"> <button type="button" class="btn btn-info btn-sm" onclick="addForm()">+添加住宿</button></span>
            </div>
            <table class="table table-striped table-hover" id="tab">
                <thead>
                <tr>
                    <td>住宿地点</td>
                    <td>入住时间</td>
                    <td>退房时间</td>
                    <td>住宿类型</td>
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
                <label for="schoolName" class="col-sm-2 control-label">住宿地点:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="schoolName">
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-6">
                    <label for="startTime" class="col-sm-4 control-label">入住时间:</label>
                    <div class="col-sm-8">
                        <input type="date" class="form-control" id="startTime" placeholder="">
                    </div>
                </div>
                <div class="col-xs-6">
                    <label for="endTime" class="col-sm-4 control-label">退房时间:</label>
                    <div class="col-sm-8">
                        <input type="date" class="form-control" id="endTime" placeholder="">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="type" class="col-sm-2 control-label">住宿类型:</label>
                <div class="col-sm-10">
                    <select class="form-control" id="type">
                        <option>单人房</option>
                        <option>双人房</option>
                        <option>三人房</option>
                        <option>四人房</option>
                    </select>
                </div>
            </div>
            <div class="form-group" style="display: none">
                <label for="flag" class="col-sm-2 control-label">标识:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="flag" placeholder="">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <!-- <input type="button" value="保存并提交" class="btn btn-info" onclick="submit()">-->
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
    window.onload=function () {
        let url='${pageContext.request.contextPath}/hotel/selectHotel'; //要请求的服务器url
        $.ajax({
            type: "POST",
            async:true,
            url:url, //请求路径
            data: {},  //请求参数
            dataType: "json",
            success: (list)=>{
                list.forEach((item)=>{
                    var startTime=timeFilter(item.starttime);
                    var endTime=timeFilter(item.endtime);
                    var schoolName=item.hotelplace;
                    var type=item.hoteltype;
                    var tab=document.getElementById('tab');
                    var row=tab.insertRow(1);
                    row.id=item.htnum ; //把行id命名成标识符item.标识符属性名
                    var sN=row.insertCell(0);
                    var sT=row.insertCell(1);
                    var eT=row.insertCell(2);
                    var TY=row.insertCell(3);
                    var option=row.insertCell(4);
                    sN.innerHTML=schoolName;
                    sT.innerHTML=startTime;
                    eT.innerHTML=endTime;
                    TY.innerHTML=type;
                    option.innerHTML='<input type="button" class="btn btn-link" onclick="displayForm(this)" value="编辑">'+
                        '<input type="button" class="btn btn-link" onclick="delForm(this)" value="删除">'+
                        '<input type="button" class="btn btn-link" onclick="addParticipant(this)" value="管理住宿人员">';

                });

            }
        });
    };
    //点击添加
    function addForm() {
       // alert("添加");
        document.getElementById('form').style.display='block';
        document.getElementById('schoolName').value="";
        document.getElementById('startTime').value="";
        document.getElementById('endTime').value="";
        document.getElementById('type').value="";
        document.getElementById('flag').value="";
        //console.log( document.getElementById('schoolName').value);
    }
    //点击编辑
    function displayForm(obj){
        var tr = obj.parentNode.parentNode;
        var schoolName=tr.cells[0].innerText;
        var startTime=tr.cells[1].innerText;
        var endTime=tr.cells[2].innerText;
        var type=tr.cells[3].innerText;
        document.getElementById('schoolName').value=schoolName;
        //document.getElementById('startTime').value=startTime.split(" ")[0]+'T'+startTime.split(" ")[1];
        document.getElementById('startTime').value=startTime;
        //document.getElementById('endTime').value=endTime.split(" ")[0]+'T'+endTime.split(" ")[1];
        document.getElementById('endTime').value=endTime
        document.getElementById('type').value=type;
        document.getElementById('flag').value=tr.id;
        document.getElementById('form').style.display='block';
    }
    function delForm(obj) {
        var tr = obj.parentNode.parentNode;
        var flag=tr.id;
        var url='${pageContext.request.contextPath}/hotel/deleteHotel';  //要请求的服务器url
        $.ajax({
            url:url,//要请求的服务器url
            data:{
                htnum:flag
            },  //传标识符，id未标识符的值
            async:true,   //是否为异步请求
            type:"POST", //请求方式为POST
            success: function(data){
			 	var data = eval('(' + data + ')');
				//alert("测试");
				if (data.status==1){
					location.href="${pageContext.request.contextPath}/html/hotel";
					//location.href="http://www.baidu.com";
				}  
			}
        })

    }
    //点击取消
    function formCancle(){
        document.getElementById('form').style.display='none';
    }
    function formSubmit(){
        if ( document.getElementById('schoolName').value=='') {
            alert("请输入住宿地点");
            return;
        }else if( document.getElementById('startTime').value==''){
            alert("请选择入住时间");
            return;
        }
        else if( document.getElementById('endTime').value==''){
            alert("请选择退房时间");
            return;
        }
        else if( document.getElementById('type').value==''){
            alert("请选择住宿类型");
            return;
        }else {
            //console.log("haha");
            //var endTime=document.getElementById('endTime').value.split("T")[0]+" "+document.getElementById('endTime').value.split("T")[1];
            //var startTime=document.getElementById('startTime').value.split("T")[0]+" "+document.getElementById('startTime').value.split("T")[1];
            var endTime=new Date(document.getElementById('endTime').value);
            var startTime=new Date(document.getElementById('startTime').value);
            console.log(endTime)
            if (document.getElementById('flag').value==''){
                var url='${pageContext.request.contextPath}/hotel/insertHotel'; //新增
                var data = {
                	starttime:startTime,
                	endtime:endTime,
                	hotelplace:document.getElementById('schoolName').value,
                	hoteltype:document.getElementById('type').value
                };
            } else {
                var url='${pageContext.request.contextPath}/hotel/updateHotel'; //更新
                var data = {
                	starttime:startTime,
                	endtime:endTime,
                    hotelplace:document.getElementById('schoolName').value,
                    hoteltype:document.getElementById('type').value,
                    htnum:document.getElementById('flag').value
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
    					location.href="${pageContext.request.contextPath}/html/hotel";
    					//location.href="http://www.baidu.com";
    				}  
    			}
            });
        }

    }
    function timeFilter(dateStr) {
        var date = new Date(dateStr);
        var y = date.getFullYear();
        var m = (date.getMonth() + 1).toString().padStart(2, '0');
        var d = date.getDate().toString().padStart(2, '0');
        // return `${y}-${m}-${d} ${hh}:${mm}:${ss}`;
        return y+"-"+m+"-"+d;
    }
    function addParticipant(obj){
		var tr = obj.parentNode.parentNode;
        var flag=tr.id;
        var url='${pageContext.request.contextPath}/hotel/jumpPage';  //要请求的服务器url
        $.ajax({
            url:url,//要请求的服务器url
            data:{
                htnum:flag
            },  //传标识符，id未标识符的值
            async:true,   //是否为异步请求
            type:"POST", //请求方式为POST
            //dataType:"json",   //服务器返回的数据是什么类型
            success: function(data){
				window.location.href = '${pageContext.request.contextPath}/hotel/selectHotelParticipants?htnum='+flag;
				}  
            }
        );
	}
</script>
</html>

