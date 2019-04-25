function add(){
	// var invite = document.getElementById ("invite");
 	//    var node = invite.children[0];
 	//    var str = node.outerHTML;
 	//    invite.innerHTML += str + "<br / >";
 	//以上是失败的创建空白输入框，每次增加新输入框会使原本输入框的值消失
 	var li13 = document.getElementById("li13");
    //创建li
    var li15 = document.createElement("li");
    //创建文本
    var text15 =document.createElement('input');
    text15.setAttribute('type', 'text');//输入框的类型
    text15.setAttribute('name', "man");//输入框的名字
    text15.setAttribute('id', "mans");//输入框的id
    //把文本添加到li下面 appendChild
    li15.appendChild(text15);
    //获取到ul
    var ul21 = document.getElementById("invite"); 
    //insertBefore(newNode,oldNode)
    ul21.insertBefore(li15,li13);
}

function show(){
	//取消返回哪里？
}

function sub(){
	var inp = document.getElementsByName("man");
	var inputs = new Array();
	for(var i=0; i<inp.length;i++){
	//	alert(inp[i].value);				//获得输入框的值
		inputs[i] = inp[i].value;
	}
	//alert(inputs);						//将输入框的值赋予inputs数组中
    if(inputs){
        $.ajax({
            type: "POST",
            url: "",
            data: {
                inputs:inputs,
            },
            success: function(data){
                var data = eval('(' + data + ')');
                if (data.status==1){
                    location.href="homepage.html";
                }
                else if(data.status==2){
                    alert("失败！");
                }
                //假如账号冲突返回什么
            }
        });
    }
}
function getCookie(cookieName) {
		    var strCookie = document.cookie;
		    var arrCookie = strCookie.split("; ");
		    for(var i = 0; i < arrCookie.length; i++){
		        var arr = arrCookie[i].split("=");
		        if(cookieName == arr[0]){
		            return arr[1];
		        }
		    }
		    return "";	
}
function start(){
	var user_id = getCookie("userid");//拿到名字为userid的cookie值
	var username = document.getElementById("username");
	username.innerHTML = user_id;
}