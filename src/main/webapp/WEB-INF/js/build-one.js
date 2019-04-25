/*function dateStart()   
{   
      //月份对应天数
       MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];   
   
      //给年下拉框赋内容   
      var y  = new Date().getFullYear();   
      for (var i = (y-10); i < (y+50); i++) //以今年为准，前10年，后50年   
      	    document.date.year.options.add(new Option(" "+ i +" 年", i));   
      //给月下拉框赋内容   
      for (var i = 1; i < 13; i++)  {
      	if(i<10){
      		i = "0"+i;
      		document.date.month.options.add(new Option(" " + i + " 月", i));}
      	else{
      		document.date.month.options.add(new Option(" " + i + " 月", i));
      	}
      }
      var n = MonHead[new Date().getMonth()]; 
      //alert(n);																							
      if (  new Date().getMonth() ==1 && IsPinYear(yearvalue)  ) 
      	     n++;   
      writeDay(n); //赋日期下拉框 
      for(var i = 0;i<=23;i++) {
      	if (i<10) {
      		i="0"+i;
      		document.date.hour.options.add(new Option(" " + i + " 时",i)); }   //赋小时下拉框
      	else{
      		document.date.hour.options.add(new Option(" " + i + " 时",i));
      	}
      }
      	for(var i = 0;i<=59;i++){
      		if (i<10) {
      			i="0"+i;
      			document.date.minute.options.add(new Option(" " + i + " 分",i));}	    //赋分钟下拉框
      		else{
      			document.date.minute.options.add(new Option(" " + i + " 分",i));
      		}
      	}
   } 
      if(document.attachEvent)   
      	window.attachEvent("onload", dateStart);   
      else   
      	window.addEventListener('load', dateStart, false);   
  function selectYear(str) //年发生变化时日期发生变化(主要是判断闰平年)   
  {   
  	    var monthvalue = document.date.month.options[document.date.month.selectedIndex].value;   
  	if (monthvalue == "")
  	   {
  		     var e = document.date.day;
  		     optionsClear(e);
  		     return;
  	   }   
  	var n = MonHead[monthvalue - 1];   
  	if (  monthvalue ==2 && IsPinYear(str)  ) 
  		     n++;   
  	writeDay(n);   
  }   
  function selectMonth(str)   //月发生变化时日期联动   
  {   
  	var yearvalue = document.date.year.options[document.date.year.selectedIndex].value;   
  	if (yearvalue == "")
  	    { 
  		      var e = document.date.day; 
  		      optionsClear(e);
  		      return;
  	    }   
  	var n = MonHead[str - 1];   
  	if (  str ==2 && IsPinYear(yearvalue)  ) 
  		      n++;   
  	     writeDay(n);  
       } 
  function dateStart_end()   
  {   
      //月份对应天数
       MonHead_end = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];   
   
      //给年下拉框赋内容   
      var y  = new Date().getFullYear();   
      for (var i = (y-10); i < (y+50); i++) //以今年为准，前10年，后50年   
      	    document.date.year_end.options.add(new Option(" "+ i +" 年", i));   
      //给月下拉框赋内容   
      for (var i = 1; i < 13; i++)  {
      	if(i<10){
      		i = "0"+i;
      		document.date.month_end.options.add(new Option(" " + i + " 月", i));}
      	else{
      		document.date.month_end.options.add(new Option(" " + i + " 月", i));
      	}
      }
      var n = MonHead_end[new Date().getMonth()];   
      if (  new Date().getMonth() ==1 && IsPinYear(yearvalue)  ) 
      	     n++;   
      writeDay_end(n); //赋日期下拉框 
      for(var i = 0;i<=23;i++) {
      	if (i<10) {
      		i="0"+i;
      		document.date.hour_end.options.add(new Option(" " + i + " 时",i)); }   //赋小时下拉框
      	else{
      		document.date.hour_end.options.add(new Option(" " + i + " 时",i));
      	}
      }
      	for(var i = 0;i<=59;i++){
      		if (i<10) {
      			i="0"+i;
      			document.date.minute_end.options.add(new Option(" " + i + " 分",i));}	    //赋分钟下拉框
      		else{
      			document.date.minute_end.options.add(new Option(" " + i + " 分",i));
      		}
      	}
      } 
      if(document.attachEvent)   
      	window.attachEvent("onload", dateStart_end);   
      else   
      	window.addEventListener('load', dateStart_end, false);   
  function selectYear_end(str) //年发生变化时日期发生变化(主要是判断闰平年)   
  {   
  	    var monthvalue = document.date.month_end.options[document.date.month_end.selectedIndex].value;   
  	if (monthvalue == "")
  	   {
  		     var e = document.date.day_end;
  		     optionsClear(e);
  		     return;
  	   }   
  	var n = MonHead_end[monthvalue - 1];   
  	if (  monthvalue ==2 && IsPinYear(str)  ) 
  		     n++;   
  	writeDay_end(n);   
  }   
  function selectMonth_end(str)   //月发生变化时日期联动   
  {   
  	var yearvalue = document.date.year_end.options[document.date.year_end.selectedIndex].value;   
  	if (yearvalue == "")
  	    { 
  		      var e = document.date.day_end; 
  		      optionsClear(e);
  		      return;
  	    }   
  	var n = MonHead_end[str - 1];   
  	if (  str ==2 && IsPinYear(yearvalue)  ) 
  		      n++;   
  	     writeDay_end(n);  
       }  
  function writeDay(n)   //据条件写日期的下拉框   
  {   
  	    var e = document.date.day; 
  	optionsClear(e);   
  	for (var i=1; i<(n+1); i++) { 
  		if (i<10) {
  			i="0"+i;
  		    e.options.add(new Option(" "+ i + " 日", i)); } 
  		else{
  			e.options.add(new Option(" "+ i + " 日", i));
  		}
  	}  
  } 
  function writeDay_end(n)   //据条件写日期的下拉框   
  {   
  	    var e = document.date.day_end; 
  	optionsClear(e);   
  	for (var i=1; i<(n+1); i++) { 
  		if (i<10) {
  			i="0"+i;
  		    e.options.add(new Option(" "+ i + " 日", i)); } 
  		else{
  			e.options.add(new Option(" "+ i + " 日", i));
  		}
  	}
  }  
  function IsPinYear(year)//判断是否闰平年   
  {     
  	    return(  0 == year%4 && ( year%100 !=0 || year%400 == 0 )  );
  }
  
  function optionsClear(e) 
     { 
  	       e.options.length = 1; 
     }

function sele(id) {
    var sele_a = [sele1.value,sele2.value,sele3.value,sele4.value,sele5.value,sele6.value,sele7.value,sele8.value,sele9.value,sele10.value];  
    // alert(sele_a);		//成功将值赋予数组
    var judge = "";
    for(i=0;i<5;i++){
    	if (sele_a[i]==sele_a[i+5]) {
    		continue;
    	}else if(sele_a[i]>sele_a[i+5]){
    		judge = false;
    	}else{
    		judge = true;
    	}
    	break;
    }
    if(judge == ""){
    	judge = false;
    }
    return{judge:judge,sele_a:sele_a};
};
*/
function check(){
//	var a = sele();
	var huiyi = document.getElementById("huiyi").value;
	var time = document.getElementById("time").value;//a.sele_a;
	console.log(time);
	var place = document.getElementById("place").value;
	var content = document.getElementById("content").value;
	var yicheng = document.getElementById("yicheng").value;
	var zhinan = document.getElementById("zhinan").value;
	if (huiyi == "") {
		alert("请输入会议名称！")
	}else if(time == ""){
		alert("请选择正确的时间！")
	/*}else if(a.judge == false){
		alert("请选择正确的时间！")*/
	}else if(place == ""){
		alert("请输入地点！")
	}else if(content == ""){
		alert("请输入内容！")
	}else{
		console.log(time);
    	var xmlhttp;
    	xmlhttp = new XMLHttpRequest();
    	xmlhttp.onreadystatechange = function(){
  			if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
    			//document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
  				//location.href="http://www.baidu.com";
  				alert("会议创建成功!");
    			window.location.href="/MeetingManager/html/homepage";
    		}
  		}
    	
    	xmlhttp.open("POST","/MeetingManager/meeting/add",true);	//服务器地址
		//xmlhttp.setRequestHeader("Content-type","application/json;charset=UTF-8");
    	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("mname="+huiyi+"&mplace="+place+"&mtime="+time+"&mflow="+yicheng+"&mguide="+zhinan+"&mcontent="+content);
	
	}
}