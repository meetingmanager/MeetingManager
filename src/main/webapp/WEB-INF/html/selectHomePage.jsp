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
		.header .title{
			font-size: 18px;
			color: #868686;
			float: left;
			font-weight: bold;
			line-height: 50px;
			cursor: pointer;
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
			height:100%;
		}
		.box .mid{
			height: 50px;
			margin: 0 auto;
			width: 980px;
			padding: 30px 0 40px;
		}
		.box .mid .icon{
			height: 40px;
			width: 40px;
			background-image: url("${pageContext.request.contextPath}/images/icon-found.png");
			cursor: pointer;
			float: left;
		}
		.box .mid .tishi{
			height: 46px;
			width: 100px;
			margin-top: 5px;
			border-radius:10px;
			color: #aaa;
			background-color: white;
			float: left;
			line-height: 30px;
			text-align: center;
			box-shadow: 1px 1px 2px #888888;
			display: none;
			font-size: 12px;
			padding: 7px 0px;
		}
		.box .mid .tishi p{
			height: 23px;
			line-height: 23px;
		}
		.open{
			background-color: #ddd;
		}
		.box .mid .tishi a{
			color: black;
			text-decoration: none;
		}
		.box .mid .qipao{
			width:0;
            height:0;
            border-top:8px solid transparent;
            border-left:8px solid transparent;
            border-right:8px solid white;
            border-bottom:8px solid transparent;
            float: left;
            margin-left: 5px;
            margin-top: 12px;
            display: none;
		}
		.box .mid .search{
			float: right;
			margin-right: 300px;
			border: 1px solid rgb(0,187,211);
			margin-top: 5px;
			border-radius:5px;
		}
		.box .mid .search .shuru{
			height: 26px;
			width: 350px;
		}
		.box .mid .search .submit{
			width: 50px;
			height: 30px;
			background:rgb(0,187,211);
			color: white;
			cursor: pointer;
		}
		.box .mid .search .submit-change{
			background: rgb(0,163,195);
		}
		.box .running,.end{
			height: 42px;
			line-height: 42px;
			font-size: 12px;
			color: #333;
			margin: 0 auto;
			width: 980px;
			border-bottom: 1px solid #E1E1E1;
		}
		.box .RN,.EN{
			width: 980px;
			margin: 0 auto;
		}
		.box .mod{
			height: 330px;
			width: 230px;
			margin-right: 20px;
			margin-top: 20px;
			display:inline-block;
		}
		.box .mod .mod_h{
			height: 222px;
			width: 222px;
			border: 4px solid white;
			background-color: white;
		}
		.box .mod .mod_b{
			height: 50px;
			width: 230px;
			background-color: white;
			font-size:20px;
			line-height:50px;
		}
		.box .mod .mnumber,.mflag{
			display:none;
		}
	</style>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".icon").click(function () {
                //alert("1");
                /*$(".tishi").show();
                $(".qipao").show();*/
                if($(".tishi").is(":hidden")){
                	$(".tishi").show();
                	$(".qipao").show();
                }else{
                	$(".tishi").hide();
                	$(".qipao").hide();
                }
            });
        	$(".tishi p").mouseenter(function(){
        		var $this = $(this),
        			index = $this.index();
        		$this.addClass("open").siblings("p").removeClass("open");
        	});
        	$(".tishi").mouseleave(function(){
            	$(".tishi p").removeClass("open");
            });
            
            $(".submit").mouseenter(function(){
            	//alert("1");
            	$(".submit").addClass("submit-change");
            });
            $(".submit").mouseleave(function(){
            	$(".submit").removeClass("submit-change");
            })
            $(".box").css({"height":window.innerHeight});
            $(".title").click(function(){
            	$(location).attr('href', 'homepage.html');
            })
		})

		function userN(){
			var list=document.getElementById("list").innerHTML;
			var data = jQuery.parseJSON(list);
    		addBox(data);
            var modR = document.getElementById("runningN").getElementsByClassName("mod");
        	var modE = document.getElementById("endN").getElementsByClassName("mod");
        	var modJ = document.getElementById("join").getElementsByClassName("mod");
        	var numR = document.getElementById("runningN").getElementsByClassName('mnumber');
        	var numE = document.getElementById("endN").getElementsByClassName('mnumber');
        	var numJ = document.getElementById("join").getElementsByClassName('mnumber');
        	var flagE = document.getElementById("endN").getElementsByClassName('mflag');
        	var flagR = document.getElementById("runningN").getElementsByClassName('mflag');
        	var flagJ = document.getElementById("join").getElementsByClassName('mflag');
        	
    		var funny = function(obj1,obj2,obj3,i){
    			var mnum = obj2[i].innerHTML;
    			var mf = obj3[i].innerHTML;
    			
                obj1[i].onclick = function(){
                	$("#mnum").val(mnum);
                	$("#mflag").val(mf);
        			$("#select_form").submit();
                    
                } 
            }
		
            for(var i=0;i<modR.length;i++){
                funny(modR,numR,flagR,i);
            }
            for(var i=0;i<modE.length;i++){
                funny(modE,numE,flagE,i);
            }
            for(var i=0;i<modJ.length;i++){
                funny(modJ,numJ,flagJ,i);
            }
		}
        function addBox(data){
            $.each(data,function(index,obj){
            	var mnum = obj["mnum"];
            	var mtime=timeFilter(obj['mtime']);
            	if(obj['mflag'] == 2){
                	$("#join").append("<div class='mod' value='mnum'>"+//获得图片地址
                    	"<div><img class='mod_h' src=/pictures/"+obj['mimage']+"></div>"+
                    	//获得会议名称
                    	"<div class='mod_b'>"+obj['mname']+"</div>"+
                    	"<div class='mod_b'>"+mtime+"</div>"+
                    	"<div class='mnumber'>"+obj['mnum']+"</div>"+
                    	"<div class='mflag'>"+"2"+"</div>"+
                    	"</div>");
            	}
            	
            	if(obj['mflag'] == 0){
                	$("#endN").append("<div class='mod' value='mnum'>"+//获得图片地址
                    	"<div><img class='mod_h' src=/pictures/"+obj['mimage']+"></div>"+
                    	//获得会议名称
                    	"<div class='mod_b'>"+obj['mname']+"</div>"+
                    	"<div class='mod_b'>"+mtime+"</div>"+
                    	"<div class='mnumber'>"+obj['mnum']+"</div>"+
                    	"<div class='mflag'>"+"0"+"</div>"+
                    	"</div>");
            	}else if(obj['mflag'] == 1){
            		$("#runningN").append("<div class='mod'>"+//获得图片地址
                        "<div><img class='mod_h' src=/pictures/"+obj['mimage']+"></div>"+
                        //获得会议名称
                        "<div class='mod_b'>"+obj['mname']+"</div>"+
                        "<div class='mod_b'>"+mtime+"</div>"+
                        "<div class='mnumber'>"+obj['mnum']+"</div>"+
                        "<div class='mflag'>"+"1"+"</div>"+
                        "</div>");
            	}
            });
        }
        
        function timeFilter(dateStr) {
            var date = new Date(dateStr);
            var y = date.getFullYear();
            var m = (date.getMonth() + 1).toString().padStart(2, '0');
            var d = date.getDate().toString().padStart(2, '0');
            var hh = date.getHours().toString().padStart(2, '0');
            var mm = date.getMinutes().toString().padStart(2, '0');
            var ss = date.getSeconds().toString().padStart(2, '0');
            //return "${y}-${m}-${d} ${hh}:${mm}:${ss}";
            return y+"-"+m+"-"+d+" "+hh+":"+mm;
        }
        
	</script>
</head>
<body onload="userN()">
	<a id="list" name="list" style="display:none">${list}</a>
	<form action="${pageContext.request.contextPath}/meeting/select" id="select_form" style="display:none">
		<input id="mnum" name="mnum">
		<input id="mflag" name="mflag">
	</form>
	<div class="header">
		<div class="title">查询会议结果</div>
	</div>
	<div class="cl"></div>
	<div class="box">
		<div class="running">作为参会人员参加的会议列表</div>
		<div id="join" class="RN"></div>
		<div class="running">作为会议管理者的会议列表（进行中）</div>
		<div id="runningN" class="RN"></div>
		<div class="end">作为会议管理者的会议（已结束）</div>
		<div id="endN" class="EN"></div>
	</div>
</body>
</html>