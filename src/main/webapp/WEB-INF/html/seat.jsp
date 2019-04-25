<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" style="width:100%;overflow:auto">
<head>
	<meta charset="UTF-8">
	<title>会务管理系统</title>
	<style type="text/css">
		html, body, div, ul, li, h1, h2, h3, h4, h5, h6, p, dl, dt, dd, ol, form, input, textarea, th, td, select {
    		margin: 0;
   		 	padding: 0;
		}
		.lie{
			border: 1px solid black;
			background-color: skyblue;
			color: #333;
			height: 30px;
			line-height: 30px;
			width: 80px;
			float: left;
			margin-left: 10px;
			margin-right: 10px;
			margin-bottom: 10px;
		}
		.cl{
			clear: both;
		}
		.wall{
			width: 100%;
			border-bottom: 1px solid black;
			padding-top: 30px;
		}
		.body{
			padding-top: 30px;
			width: 100%;
			width: fit-content;
			margin: 0 auto;
		}
		.sel{
			width: 100px;
			height:40px;
			line-height:40px
			z-index:4;
			margin:0
			padding:0;
			*margin-top:12px;
			filter:alpha(opacity=0);
			cursor:pointer;
			font-size: 16px;
		}
		.change-code{
			width: 35%;
			height: 150px;
			position: absolute;
			top: 200px;
			right: 32.5%;
			border: 1px solid black;
			border-radius:10px;
			background-color: #fff;
			display: none;
		}
		.change-code .close{
			float: right;
			padding-right: 10px;
			padding-top: 10px;
		}
		.change-code .close{
			color: #3d3d3d;
			cursor: pointer;
		}
		.change-code .close:hover{
			color: #CA0C16;
		}
		.change-code .change-code-major{
			float: left;
			width: 100%;
			text-align: center;
		}
		.change-code .change-code-major div{
			width: 90%;
			padding: 10px 0 5px 10%;
		}
		.change-code .change-code-major div p{
			padding-bottom: 5px;
		}
		.change-code .change-code-major div input{
			width: 85%;
			height: 30px;
			padding-left: 5px;
			font-size: 14px;
		}
		.anniu{
			float: left;
			padding-left: 25%;
			padding-top: 20px;
			width: 100%;
        }
        #anniu{
        	width: 50%; /* 宽度 */
			height: 40px; /* 高度 */
			border-width: 0px; /* 边框宽度 */
			border-radius: 3px; /* 边框半径 */
			background: #1E90FF; /* 背景颜色 */
			outline: none; /* 不显示轮廓线 */
			font-family: Microsoft YaHei; /* 设置字体 */
			color: white; /* 字体颜色 */
			font-size: 17px; /* 字体大小 */
        }
        .header{
        	width: 100%;
        	padding-top: 20px;
        	text-align: center;
        }
        .header p .inp{
			height: 25px;
			padding-left: 8px;	
			width: 50px;
			margin-bottom: 10px;
        }
        .header .number{
			color:skyblue;
			padding-bottom: 10px;
        }
        .header .btn{
        	margin-right: 20px;
        	cursor: pointer;
        	width: 100px; /* 宽度 */
			height: 40px; /* 高度 */
			border-width: 0px; /* 边框宽度 */
			border-radius: 3px; /* 边框半径 */
			background: #1E90FF; /* 背景颜色 */
			outline: none; /* 不显示轮廓线 */
			font-family: Microsoft YaHei; /* 设置字体 */
			color: white; /* 字体颜色 */
			font-size: 17px; /* 字体大小 */
        }
        .nowNum,.coumol{
        	float: left;
			color: #333;
			height: 30px;
			line-height: 30px;
			width: 80px;
			float: left;
			margin-left: 10px;
			margin-right: 10px;
			margin-bottom: 10px;
        }
	</style>
	</head>
<body style="overflow-x:auto;width: 100%">
	<a id="names" name="names" style="display:none">${names}</a>
	<a id="seattype" name="seattype" style="display:none">${seattype}</a>
	<a id="distribute" name="distribute" style="display:none">${distribute}</a>
	<a id="numbers" name="numbers" style="display:none">${numbers}</a>
	<a id="notDistributeName" name="notDistributeName" style="display:none">${notDistributeName}</a>
	<a id="distributeNumber" name="distributeNumber" style="display:none">${distributeNumber}</a>
	 <div id="allBody" class="header">
	 	<div class="number">该会议共有<span style="color:red"></span>人，请输入会议座位的行和列！</div>
	 	<p><input type="text" id="hang" class="inp">&nbsp 行&nbsp&nbsp&nbsp&nbsp<input type="text" id="lie" class="inp">&nbsp 列</p>
	 	<input type="button" id="btn" class="btn" value="确定" onclick="sign()">
	 	<input type="button" id="btn" class="btn" value="重新输入" onclick="again()">
	 	<div class="wall"></div>
	 	<form action="" id="all" class="body">
	 		
	 	</form>	
	 		<input type="button" id="save" name="" value="保存" class="btn">
	 </div>
	 <div class="change-code" id="change-code">
			<p class="close" id="x">X</p>
			<div class="change-code-major">
				<select id="sel" class="sel"></select>
			</div>
			<div class="anniu"><input type="button" name="" value="确认修改" id="anniu"></div>
	</div>
</body>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/json.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		var names=document.getElementById("names").innerHTML;
		var namess = jQuery.parseJSON(names);
		var seattypes=document.getElementById("seattype").innerHTML;
		var seattypess = jQuery.parseJSON(seattypes);
		var distributes=document.getElementById("distribute").innerHTML;
		var distributess = jQuery.parseJSON(distributes);
		var distributeNumber=document.getElementById("distributeNumber").innerHTML;
		var distributeNumbers = jQuery.parseJSON(distributeNumber);
		var numbers=document.getElementById("numbers").innerHTML;
		var numberss = jQuery.parseJSON(numbers);
		var notDistributeName=document.getElementById("notDistributeName").innerHTML;
		var notDistributeNames = jQuery.parseJSON(notDistributeName);
	
		function $1(id){return document.getElementById(id);}
		var hang = document.getElementById('hang');
		var lie = document.getElementById('lie');
		var hangN = document.getElementsByClassName('hang');
		var lieN = document.getElementsByClassName('lie');
		//console.log(namess);				
		//["谢彬", "曾环乐", "徐豪曼", "徐胜杰", "徐杰", "袁杰", "黄连", "马云", "王豪"]
		//console.log(distributeNumbers);	
		//[null, null, null, "15", null, null, null, null, null]
		//console.log(distributess);
		//[null, null, null, "徐豪曼", null, null, null, null, null]
		//console.log(numberss);
		//[13, 14, 15, 16, 17, 18, 19, 20, 21]
		var judge;//模拟是否已存在座位表
		if(seattypess.line != null){
			judge = 1;
		}else{
			judge = 0;
		}
		//var a1 = new Array("谢彬", "曾环乐", "徐豪曼", "徐胜杰", "徐杰", "袁杰", "黄连", "马云", "王豪");		//a1记录传进来所有的数据
		//var a3 = new Array("谢彬", "曾环乐", "徐豪曼", "徐胜杰", "徐杰", "袁杰", "黄连", "马云", "王豪");		//a3记录未被使用的数据
		var a1 = new Array();
		var a3 = new Array();
		for(var i in namess){
			a1[i] = namess[i];
			
		}
		for(var i in notDistributeNames){
			a3[i] = notDistributeNames[i];
			
		}
		
		//var a4 = new Array(null, null, null, "徐豪曼", null, null, null, null, null);
		var a4 = new Array();
		for(var i in distributess){
			a4[i] = distributess[i];
			
		}
		var a2 = new Array();																							//a2记录已被使用的数据,同时，数组的第几个就是第几个嘉宾，无需记录列数，数组已记录
		
		//var aa = new Array(13, 14, 15, 16, 17, 18, 19, 20, 21);												//记录所有的人员号
		var aa = new Array();
		//var ac = new Array(null, null, null, "15", null, null, null, null, null);												//记录传进来的人员号
		var ac = new Array();
		for(var i in numberss){
			aa[i] = numberss[i];
			// [null, null, null, "15", null, null, null, null, null]
		}
		for(var i in distributeNumbers){
			ac[i] = distributeNumbers[i];
			// [null, null, null, "15", null, null, null, null, null]
		}
		var ab = new Array();												//记录已被使用的人员号

		if(judge == 1){				//需要传入judge进行判断
			var hValue = seattypess.line;	//传来行的值，需后面修改 
			var lValue = seattypess.row;//传来列的值
			var all = document.getElementById("all");
			lie.value = lValue;
			hang.value = hValue;
			var coumolClass = document.getElementsByClassName('coumol');
			for(var h=0;h<=lValue;h++){
					var coumol = document.createElement('div');
					coumol.className = 'coumol';
					coumol.innerHTML = "第" + h + "列";
					all.appendChild(coumol);
					coumolClass[0].style.opacity = '0';
				}
			var ir = coumolClass.length;
			hw = 102*ir;
			for(var i=0;i<hValue;i++){
				//alert('yes');
				var hangNum = document.createElement('div');
				var cl = document.createElement('div');
				all.appendChild(hangNum);
				hangNum.className = 'hang';
				hangNum.style.height = '32px';
				hangNum.style.width = hw+'px';
				cl.className = 'cl';
				all.appendChild(cl);
				var nowNum = document.createElement('div');
				nowNum.className = 'nowNum';
				var lineNum = i+1;
				nowNum.innerHTML = "第" + lineNum + "行";
				hangNum.appendChild(nowNum);
				for(var n=0;n<lValue;n++){
					var numL = document.createElement('div');
					numL.className = 'lie';
					var j = i*hValue + n;
					numL.innerHTML = a4[j];
					hangNum.appendChild(numL);						//增加一个盒子，用来存储参会人员号
				}
				hang.style.pointerEvents= 'none';
				lie.style.pointerEvents= 'none';
				document.getElementById('btn').style.pointerEvents= 'none';
			}
			get();
		}
		function sign(){
			var hangValue = hang.value;
			var lieValue = lie.value;
			var all = document.getElementById('all');
			if(hangValue==''||isNaN(hangValue)||lieValue==''||isNaN(lieValue)){
				alert('请输入数字');
			}else{
				var coumolClass = document.getElementsByClassName('coumol');
				for(var h=0;h<=lieValue;h++){
					var coumol = document.createElement('div');
					coumol.className = 'coumol';
					coumol.innerHTML = "第" + h + "列";
					all.appendChild(coumol);
					coumolClass[0].style.opacity = '0';
				}
				var ir = coumolClass.length;
				hw = 102*ir;
				
				for(var i=0;i<hangValue;i++){
					
					var hangNum = document.createElement('div');
					var cl = document.createElement('div');
					all.appendChild(hangNum);
					hangNum.className = 'hang';
					hangNum.style.height = '32px';
					hangNum.style.width = hw+'px';				//如何加上变量宽度
					
					cl.className = 'cl';
					all.appendChild(cl);
					var nowNum = document.createElement('div');
					nowNum.className = 'nowNum';
					var lineNum = i+1;
					nowNum.innerHTML = "第" + lineNum + "行";
					hangNum.appendChild(nowNum);
					for(var n=0;n<lieValue;n++){
						var lieNum = document.createElement('div');
						lieNum.className = 'lie';
						hangNum.appendChild(lieNum);
					}
				}
				hang.style.pointerEvents= 'none';
				lie.style.pointerEvents= 'none';
				document.getElementById('btn').style.pointerEvents= 'none';
			}
			get();
		}	
		function get(){
			function open(obj1,i){
				
				obj1[i].onclick = function(){
	           		$1("change-code").style.display = "block";
	           		$1("change-code").style.opacity = "1";
	           		$1("allBody").style.disabled = false;
	           		$1("allBody").style.opacity = "0.3";
	           		$1("allBody").style.pointerEvents='none';
	           		//console.log(document.getElementById('sel'));
	           		var sel = document.getElementById('sel');
	           		while(sel.hasChildNodes())
	   				{
	   				    sel.removeChild(sel.firstChild);		//清除上次创建的option
	   				}
	   				var kong=document.createElement("option");
	   				sel.appendChild(kong);
	   				for(var n=0;n<a3.length;n++){		//重新创建option
	           			var op=document.createElement("option");
	           			op.innerHTML = a3[n];
	           			op.value = a3[n];
	           			op.class = 'op';
	           			op.id='guest'+n;
	           			sel.appendChild(op);
	           		}
	           		$1("anniu").onclick = function(){
						obj1[i].innerHTML = sel.value;		//点击确定按钮，将select的值赋给当前座位
						
						var a = sel.value;
						Array.prototype.indexValue = function () {
						  	for (var z = 0; z < a1.length; z++) {
						    	if (a == a1[z]) {
						      		//alert(aa[z]);
						      		ac[i] = aa[z];
						      		console.log(ac);
						    	}else if(a == ""){
						    		ac[i] = "";
						    		console.log(ac);
						    	}
						  	}
						}
						// alert(arr);
						// 得到1在arr数组中的下标0
						var humanNum = obj1[i].innerHTML;
						a1.indexValue(humanNum);
						$1("change-code").style.display = "none";
	           			$1("allBody").style.opacity = "1";
	           			$1("allBody").style.pointerEvents='auto';
	           			a3.splice(0,a3.length);		
	           			
	           			for(var q = 0;q < obj1.length;q++){
	           				a2[q] = obj1[q].innerHTML;
	           			}
	           			for(Anum=0;Anum<a1.length;Anum++){
	           				a3[Anum] = a1[Anum];
	           				
	           			}				//重复两次后a1会被清除
	           			//alert(a1);
	           			for(j=0;j<a2.length;j++){
	           				for(m=0;m<a3.length;m++){				//判断，若是已被使用的数据，则不加入a3；若未被使用，则加入a3
	           					if(a2[j] == a3[m]){
	           						//alert(a3[m]);
	           						a3.splice(m,1);
	           					}
	           				}
	           			}
	           			//alert(obj1.length);
					}
				}	
			}
			for(i=0;i<lieN.length;i++){
				open(lieN,i);
				//alert(a.length);
			}
		}
		function again(){
			var all = document.getElementById('all');
			while(all.hasChildNodes()) //当all下还存在子节点时 循环继续
   			{
   			    all.removeChild(all.firstChild);
   			}
   			document.getElementById('hang').style.pointerEvents= 'auto';
			document.getElementById('lie').style.pointerEvents= 'auto';
			document.getElementById('btn').style.pointerEvents= 'auto';
		}
		$1("x").onclick = function()
            {
            	$1("change-code").style.display = "none";
            	$1("allBody").style.opacity = "1";
            	$1("allBody").style.pointerEvents='auto';
            }

		
	</script>
	<script>
	
	$('#save').click(function() {
		
		
		 for(i=0;i<lieN.length;i++){
			a2[i] = $('.lie').eq(i).html();	
		}
	
        $.ajax({
        	async : false,
        	cache : false,
            traditional: true,
            url: "${pageContext.request.contextPath}/seat/updateSeat",
            type: "POST",
            data: {
            	name:a2,
        	    numbers:ac,						//人员号
        	    hang:hangN.length,			//将传过去三个值，名字的数组和行、列
        	    lie:lieN.length,
            },			
    		success: function(data){
                        var data = eval('(' + data + ')');
                        if (data.status==1){
                        	alert("更新成功");
                        }
                     }
        });

     
    })
	
	</script>
</html>