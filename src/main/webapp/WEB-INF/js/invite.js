var i = 1;
		function start(){
            var invite = document.getElementById('invite');
            var guest=document.createElement("div");
                guest.style.border='1px solid #666';
                guest.style.paddingTop='10px';
                guest.style.paddingBottom='10px';
                guest.style.marginBottom='10px';
                guest.id='guest'+i;
            invite.appendChild(guest);
            var header=document.createElement("div");
            guest.appendChild(header);
            var headerLeft=document.createElement("div");
                headerLeft.innerHTML = '嘉宾'+i;
                headerLeft.style.float='left';
                headerLeft.style.paddingLeft='27px';
                headerLeft.style.paddingBottom='5px';
                headerLeft.style.fontSize='20px';
            header.appendChild(headerLeft);
            var headerRight = document.createElement("div");
                headerRight.id = ''+i;
                headerRight.onclick=move;
                headerRight.innerHTML='X';
                headerRight.style.float='right';
                headerRight.style.paddingRight='10px';
                headerRight.style.cursor='pointer';
            header.appendChild(headerRight);
            var cl = document.createElement('div');
                cl.style.clear='both';
            header.appendChild(cl);
            var cname = document.createElement('div');
                cname.innerHTML = '嘉宾姓名：';
            guest.appendChild(cname);
            var cspan = document.createElement('span');
                cspan.innerHTML = '（必填）';
                cspan.style.color = 'red';
            cname.appendChild(cspan);
            var cinput = document.createElement('input');
                cinput.type='text';
                cinput.className='gname';
                cinput.style.paddingLeft = '10px';
            cname.appendChild(cinput);
            var cphone = document.createElement('div');
                cphone.innerHTML = '联系方式：';
            guest.appendChild(cphone);
            var sspan = document.createElement('span');
                sspan.innerHTML = '（必填）';
                sspan.style.color = 'red';
            cphone.appendChild(sspan);
            var sinput = document.createElement('input');
                sinput.type='text';
                sinput.className='gphone';
                sinput.style.paddingLeft = '10px';
            cphone.appendChild(sinput);
            var last1 = document.createElement('div');
                last1.innerHTML = '嘉宾职称：';
                last1.style.paddingLeft = '64px';
            guest.appendChild(last1);
            var gtitle = document.createElement('input');
                gtitle.className = 'gtitle';
                gtitle.style.paddingLeft = '10px';
            last1.appendChild(gtitle);
            var last2 = document.createElement('div');
                last2.innerHTML = '嘉宾简介：';
                last2.style.paddingLeft = '64px';
            guest.appendChild(last2);
            var gintroduction = document.createElement('input');
                gintroduction.className = 'gintroduction';
                gintroduction.style.paddingLeft = '10px';
            last2.appendChild(gintroduction);
            i++;
        }
        function sub(){
            var xmlhttp;
            var gname = document.getElementsByClassName('gname');
            var gphone = document.getElementsByClassName('gphone');
            var gtitle = document.getElementsByClassName('gtitle');
            var gintroduction = document.getElementsByClassName('gintroduction');
            var aN = new Array();           //试着研究如何动态生成数组
            var aP = new Array();
            var aT = new Array();
            var aI = new Array();
            
            for (i=0;i<gname.length;i++){
                aN[i] = gname[i].value;
                aP[i] = gphone[i].value;
                aT[i] = gtitle[i].value;
                aI[i] = gintroduction[i].value;
                if(aT[i] == ""){
                    aT[i] = "没有输入";         
                }else if(aI == ""){
                    aI[i] = "没有输入";
                }
            }
            xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function(){
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
                    //成功
                }
            }
            xmlhttp.open("POST","/MeetingManager/guest/add",true);   //服务器地址
            xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
            xmlhttp.send("aN="+aN+"&aP="+aP+"&aT="+aT+"&aI="+aI);
            //xmlhttp.send("aN="+aN);
            //xmlhttp.send("aN="+aN+"&aP="+aP);
        }
        function show(){
            //上一步要跳转到哪
        }
        function move(){
            var id = this.id;
            //console.log(id);      //为什么输出window，换种写法 //1.通过A.fn()形式调用时，this是A。2.通过fn()形式调用时，this是window。
            document.getElementById('invite').removeChild(document.getElementById('guest'+id));
        }