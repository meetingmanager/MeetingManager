<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
		<meta name="format-detection" content="telephone=no, email=no, date=no, address=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta http-equiv="Pragma" content="no-cache">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="format-detection" content="telephone=no" />
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/systable.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/json.js"></script>
		<title></title>
	</head>

	<body class="index_style" onload="judgeAll()">
		<a id="list" name="list" style="display:none">${list}</a>
		<div class="mtb10 clearfix" id="btn-operation">
			<button id="excelExport" onclick="excelExport()" class="btn btn-blue btnEvent">导出Excel</button>
			<span class="r-f search-style">
				<input type="text" placeholder="输入关键字查询" value="" name="searchText"  class="input-text" /><a href="javascript:;" class="btn btn-blue btnEvent" name="searchEvent">搜索</a>
			</span>
		</div>
		<table class="gallery table table_list table_striped table-bordered border " id="tableList" style="width: 100%;" cellpadding="0">
			<thead>
				<tr>
					<!-- <th width="50px">
						<label class="checkbox relative"><input type="checkbox" class="ace" name="checkbox"><span class="lbl"></span></label>
					</th> -->
					<th>姓名</th>
					<th>性别</th>
					<th>头像</th>
					<th>单位</th>
					<th>是否批准入会</th>
				</tr>
			</thead>
			<tbody id="body">
		
			</div>
			</tbody>
		</table>
		<!--分页-->
		<div class="Paging" id="pagination">
		</div>
	</body>
<script type="text/javascript">
	function excelExport(){
		$.ajax({
			url:"${pageContext.request.contextPath}/excel",
			type:"post",
			success:return_date,
			error:return_erro
		});
		function return_date(data){
			alert("导出成功!\n已导出 "+data.resultcount+"位参会人员至："+data.path+"目录下.");
		}
		function return_erro(){
			alert("导出失败");
		}
	}

</script>

</html>

<script>
	new SYSTableSorter({
		TableName: 'tableList', //表格区域
		btnArea: 'btn-operation', //按钮区域
		paginName: 'pagination', //分页区域
		curPage: 1, //默认页
		mode: 'table', //模式
		setItem: 'menu',
		timeFormat: 'yyyy-MM-dd hh:mm:ss', //时间显示格式
		Sequence: [,4,5 ],
		Callback: function(obj, index, curPage, pageSize) {
			index.ajaxGet("data.json", null, curPage, pageSize);
		},
		SearchEvent: function(index, value, curPage, pageSize) {
			index.PromptBox("请登录www.husysui.com查看具体操作！", 2, false);
		},
		SaveEvent: function(layer, index, id, data, evnet) {
			index.PromptBox("请登录www.husysui.com查看具体操作！", 2, false);
		},
		DeleteEvent: function(layer, index, id, curPage, pageSize) {
			index.PromptBox("请登录www.husysui.com查看具体操作！", 2, false);
		},
		CheckboxDeleteEvent: function(index, id, curPage, pageSize) {
			index.PromptBox("请登录www.husysui.com查看具体操作！", 2, false);
		},
		DetailedEvent: function(layer, index, id) {
			index.PromptBox("抱歉该功能暂未开发！", 2, false);
		}
	});
	/******************************/
	/* function addBox(data){
		
    } */
    function judgeAll(){
    	
		var list=document.getElementById("list").innerHTML;
		var list1 = jQuery.parseJSON(list);
        $.each(list1,function(index,value){

            	$("#body").append("<tr class='relative human'>"+
                //获得待审核人员姓名
                "<td class='humanName'>"+value.pname+"</td>"+
                "<td class='table-edit sex'>"+value.psex+"</td>"+
                "<td>"+"<img src=/pictures/"+value.image+"></td>"+
                "<td class='table-edit unit'>"+value.punit+"</td>"+
                "<td class='table-edit pnum'>"+value.pflag+"</td>"+
                "<td class='judge'>"+"<button class='btn btn-danger padding5'>"+"拒绝"+"</button>"+"<button class='btn btn-danger padding5'>"+"批准"+"</button>"+"</td>"+
                "</tr>");
        	
        });
        	
    	var judge = document.getElementsByClassName('judge');
        var pnum = document.getElementsByClassName('pnum');
        for(var i = 0;i<pnum.length;i++){
    		if (pnum[i].innerHTML == 2) {
    				//alert("yes");
    				judge[i].style.color = 'red';
    				judge[i].innerHTML = '拒绝入会';
    			}else if(pnum[i].innerHTML == 1){
    				judge[i].style.color = 'green';
    				judge[i].innerHTML = '批准入会';
    			}
    	}
        
        	/* var yes = document.getElementsByClassName('yes');
        	var no = document.getElementsByClassName('no');
        	var judge = document.getElementsByClassName('judge');
        	var humanName = document.getElementsByClassName('humanName');
            var humanNum = document.getElementsByClassName('pnum');
            var sex = document.getElementsByClassName('sex');
        	var unit = document.getElementsByClassName('unit');
        	var judgeAll = function(obj1,ok,i){
        		obj1[i].onclick = function(){
                    humanName[i].style.color = "#aaa";
                    sex[i].style.color = "#aaa";
        			unit[i].style.color = "#aaa";
        			
        			//可以写发送ok值的数据传送
        			if (obj1[i] == yes[i]) {
        				//alert("yes");
        				no[i].pointerEvents = 'none';
        				no[i].cursor = 'none';
        			}else{
        				//alert("no");
        				yes[i].pointerEvents = 'none';
        				no[i].cursor = 'none';
        			}
        			var pnum = humanNum[i].innerHTML;
        			alert(pnum);
        			$.ajax({
    					url:"${pageContext.request.contextPath}/participants/selectMP",			//请求的服务器地址
    					type:'post',
    					data:{pflag:ok,pnum:pnum},//参数	`			
    					success: function(data){
    						alert(data);
            			}
            		})
        		}
        	}
        	for(var i = 0;i<yes.length;i++){
        		judgeAll(yes,1,i);
        	}
        	for(var i = 0;i<no.length;i++){
        		judgeAll(no,2,i);
        	} */
        }
</script>