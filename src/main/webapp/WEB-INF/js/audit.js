		function judgeAll(){
			var list=document.getElementById("list").innerHTML;
			var list1 = jQuery.parseJSON(list);
			$.each(list1, function(index,value){
            	if(value.pflag == 0){		//当传来的值是什么时载入
                	$(".body").append("<div class='human'>"+
                    //获得待审核人员姓名
                    "<div class='humanName'>"+value.pname+"</div>"+
                    "<div class='judge'>"+"<input type='button' value='是' class='yes'>"+
                    "<input type='button' value='否' class = 'no'>"+"</div>"+
                    "<div class='pnum'>"+value.pnum+"</div>"+
                    "<div class='cl'>"+"</div>"+
                    "</div>");
            	}
            });
//			console.log(list);
        	var yes = document.getElementsByClassName('yes');
        	var no = document.getElementsByClassName('no');
        	var judge = document.getElementsByClassName('judge');
        	var humanName = document.getElementsByClassName('humanName');
        	var humanNum = document.getElementsByClassName('pnum');
        	var judgeAll = function(obj1,ok,i){
        		obj1[i].onclick = function(){
        			humanName[i].style.color = "#888";
        			//可以写发送ok值的数据传送
        			if (obj1[i] == yes[i]) {
        				//alert("yes");
        				no[i].disabled = 'disabled';
        			}else{
        				//alert("no");
        				yes[i].disabled = 'disabled';
        			}
        			var pnum = humanNum[i].innerHTML;
        			var pflag = ok;
        			var xmlhttp = new XMLHttpRequest();
        	    	xmlhttp.onreadystatechange = function(){
        	  			if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
        	    			//document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
        	  				
        	    			window.location.href="/MeetingManager/participants/findByMnum";
        	  			//location.href="http://www.baidu.com";
        	    		}
        	  		}
        	    	
        	    	xmlhttp.open("POST","/MeetingManager/participants/updateByPnum",true);	//服务器地址
        			//xmlhttp.setRequestHeader("Content-type","application/json;charset=UTF-8");
        	    	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        			xmlhttp.send("&pnum="+pnum+"&pflag="+pflag);
        			
        			
//        			$.ajax({
//    					url:"${pageContext.request.contextPath}/participants/updateByPnum",			//请求的服务器地址
//    					type:'post',
//    					data:
//    					{
//    						pflag:ok,
//    						pnum:pnum
//    					},//参数	`			
//    					success: function(data){
//    						alert(data);
//            			}
//            		})
        		}
        	}
        	for(var i = 0;i<yes.length;i++){
        		judgeAll(yes,1,i);
        	}
        	for(var i = 0;i<no.length;i++){
        		judgeAll(no,2,i);
        	}
		
        	
        }