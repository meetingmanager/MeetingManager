function sub(){
	var mbtn = document.getElementsByClassName("Mbtn");
	var mval = document.getElementsByClassName("Mcon-con");
	var mname = document.getElementsByClassName("Mname");
	var targin = document.getElementById('targin');
	var targinName = document.getElementById("targin-name");
	var minp = document.getElementById("Minp");
	var funny = function(obj1,obj2,obj3,i){
		obj1[i].onclick = function(){
			targin.style.display = "block";
			targinName.innerHTML = obj3[i].innerHTML;
			minp.value = obj2[i].innerHTML;
			document.getElementById("yes").onclick = function(){
				//alert(obj2[i].innerHTML);
				mval[i].innerHTML = minp.value;
				mval[i].value = minp.value;
				targin.style.display = "none";
				//console.log(test[i].value);
				
			}
	 	}
	}
	for(var i=0;i<mbtn.length;i++){
		funny(mbtn,mval,mname,i);
	}
	document.getElementById("no").onclick = function(){
		targin.style.display = "none";
	}
}
function Go(){
	window.location.href = "homepage.html";
}
function sendData(){
	
}