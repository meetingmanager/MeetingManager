<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>会议管理系统</title>
	<style>
	select {
		overflow: auto;
	}
	.timeUp{
		text-align: center;
		font-size: 18px;
		padding-left: 90px;
		padding-right: 90px;
		color: #2988E3;
	}
	</style>
</head>
<body style="background-color: #F4F4F4">
	<a id="date" name="date" style="display:none">${date}</a>
	<a id="time" name="time" style="display:none">${time}</a>
	<div style="display: none">
			<select id="year-select">
				<option value="2000">2000</option>
				<option value="2001">2001</option>
				<option value="2002">2002</option>
				<option value="2032">2032</option>
			</select>
		
			<select id="month-select">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="12">12</option>
			</select>
		
			<select id="day-select">
				<option value="1">1</option>
				<option value="2">2</option>
				……
				<option value="31">31</option>
			</select>
		
			<select id="hour-select">
				<option value="0">00</option>
				<option value="1">01</option>        
				
				<option value="23">23</option>
			</select>
		
			<select id="minite-select">
				<option value="0">0</option>
				<option value="1">1</option>
				……
				<option>59</option>
			</select>
		
			<select id="second-select">
				<option value="0">0</option>
				<option value="1">1</option>
				……
				<option>59</option>
			</select>
		</div>
	<div style="width: 400px;height: 150px;background-color: white">
        <div><p style="padding-bottom: 20px"></p></div>
		<p id="result-wrapper" class="timeUp">现在距离 2001年1月1日星期X HH:MM:SS 还有 X 天 X 小时 X 分 X 秒</p>
	</div>
	<script>
	var monthSelect = document.querySelector('#month-select');
	var yearSelect = document.querySelector('#year-select');
	var daySelect = document.querySelector('#day-select');
	var houeSelect = document.querySelector('#hour-select');
	var miniteSelect = document.querySelector('#minite-select');
	var secondSelect = document.querySelector('#second-select');
	var result = document.querySelector('#result-wrapper');
	var date1=document.getElementById("date").innerHTML;			//这是日期的传入值
	var result0=date1.split("-");
	var time1=document.getElementById("time").innerHTML;			//这是时间的传入值
	var result1=time1.split(":");
	var time = {};
	eval("time.year" + "=" + result0[0] + ","+"time.month" + "=" + result0[1] + ","+"time.day" + "=" + result0[2] + ","+"time.hour" + "=" + result1[0]  + ","+"time.min" + "=" + result1[1] + ","+"time.second" + "=" + result1[2] );
	//console.info(time.year);

	// var time = {
	// 	"year" : 2000,
	// 	"month": 1,
	// 	"day" : 1,
	// 	"hour" : 0, 
	// 	"min" : 0, 
	// 	"second" : 0		//只需要这里修改成传来的值即可
	// }
	init();

	function init(select, nums) {
		var t;
		initSelect(yearSelect, 2000, 2024, "year");
		initSelect(monthSelect, 1, 12, "month");
		initSelect(daySelect, 1, 31, "day");
		initSelect(houeSelect, 0, 23, "hour");
		initSelect(miniteSelect, 0, 60, "min");
		initSelect(secondSelect, 0, 60, "second");

		t = setInterval(updateContent, 1000);
	}

	//初始化每个下拉列表项
	function initSelect(select, start, end, date) {
		var value;
		select.options.length = 0;
		for(var i = start; i<=end; i++){
			//转换时间值类型：1->01
			value = i;
			if(date == "hour" || date == "min" || date == "second") {
				value = changeTimeType(i);
			}
			select.add(new Option(value, value));
		}
		//给每个列表添加事件
		select.onchange = function(e) {
			time[date] = Number(select.options[select.selectedIndex].value);
			//每个月天数不同
			if(e.target.id == "month-select" || e.target.id == "year-select") {
				updateDaySelect();
			}
			updateContent();
			console.log(time);
		}
	}

	function changeTimeType(i) {
		return i<10 ? '0'+i : i;
	}

	function updateDaySelect() {
		daySelect.options.length = 0;
		var days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
		if(checkLeapYear()){
			days[1] = 29;
		}
		console.log(time.month);
		for(var i=1; i<=days[time.month-1]; i++) {
			daySelect.add(new Option(i, i));
		}
		time.day = Number(daySelect.options[daySelect.selectedIndex].value);
	}

	function updateContent() {
		var timeNow = new Date();
		var timeSet = new Date(time.year, time.month-1, time.day, time.hour, time.min, time.second);
		result.innerHTML = computeTime(timeSet, timeNow);
	}

	function computeTime(timeSet, timeNow) {
		var dayBetween, hourBetween, minuteBetween, secondBetween, compare;
		var ts = new Date(timeSet.getFullYear(), timeSet.getMonth(), timeSet.getDate());
		var tn = new Date(timeNow.getFullYear(), timeNow.getMonth(), timeNow.getDate());
		var compare = timeSet > timeNow? "还有" : "已经过去";

		dayBetween = Math.abs((tn - ts)/(60*60*1000*24));
		hourBetween = Math.abs(timeNow.getHours() - timeSet.getHours());
		
		minuteBetween = Math.abs(timeNow.getMinutes() - timeSet.getMinutes());
		secondBetween = Math.abs(timeNow.getSeconds() - timeSet.getSeconds());

		return  "现在距离会议开始" + compare + " " + dayBetween + " 天 " + hourBetween + " 小时 " + minuteBetween + " 分 " + secondBetween + "秒";
	}

	function getWeekday(day) {
		var week =[
		"星期日",
		"星期一",
		"星期二",
		"星期三",
		"星期四",
		"星期五",
		"星期六"];
		return week[day];
	}

	function checkLeapYear() {
		var year = time.year;
		if(year%400 ==0 || (year%4==0 && year%100!=0)){
			return true;
		}
		else return false;
	}
	</script>
</body>
</html>

