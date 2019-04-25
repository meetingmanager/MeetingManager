<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>会议管理系统</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/adminStyle.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/layui.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/modules/layer/default/layer.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo" style="font-weight:bold;font-size:25px">会议管理</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/html/homepage">会议列表</a></li>
            <li class="layui-nav-item"><button type="button" onclick="closeMeeting()" style="background-color:#23262E;border:0px solid white;">结束会议</button></li>
            
            <!-- 
            <button href="${pageContext.request.contextPath}/meeting/closeMeetng">结束会议
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li> -->
            
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="/pictures/${ni.headphoto}" class="layui-nav-img">
                    ${ni.userid}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath}/User/find">基本资料</a></dd>
                    <dd><a href="${pageContext.request.contextPath}/User/updatePw">修改密码</a></dd>

                </dl>
            </li>
            <li class="layui-nav-item"><input type="button" onclick="postMsg()" value="退出" style="background-color:#23262E;border:0px solid white;"></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">会议基本信息</a>
                    <dl class="layui-nav-child">
                        <dd>
	                        <a id="selectMyself"
	                           data-url="/html/updateMeeting"
	                           data-id="selectMyself" data-title="基本信息" class="site-liebiao-active"
	                           data-type="tabAdd">基本信息</a>
                        </dd>
                        
                        <dd>
                            <a id="meetingImage"
                               data-url="/meeting/meetingImage"
                               data-id="meetingImage" data-title="图片上传" class="site-liebiao-active"
                               data-type="tabAdd">图片上传</a>
                        </dd>
                        
                        <dd>
                            <a id="Cockpit"
                               data-url="/Delayering/Cockpit"
                               data-id="Cockpit" data-title="倒计时" class="site-liebiao-active"
                               data-type="tabAdd">倒计时</a>
                        </dd>
                        
                        <dd>
                            <a id="copyMnum"
                               data-url="/meeting/copyMnum"
                               data-id="copyMnum" data-title="复制会议号" class="site-liebiao-active"
                               data-type="tabAdd">复制会议号</a>
                        </dd>
              
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">参会人员</a>
                    <dl class="layui-nav-child">
                        <dd>
	                        <a id="show"
	                           data-url="/guest/show"
	                           data-id="show" data-title="嘉宾管理" class="site-liebiao-active"
	                           data-type="tabAdd">嘉宾管理</a>
                        </dd>
                        <dd>
	                        <a id="findByMnum"
	                           data-url="/participants/findByMnum"
	                           data-id="findByMnum" data-title="参会人员审批" class="site-liebiao-active"
	                           data-type="tabAdd">参会人员审批</a>
                        </dd>
                        <dd>
	                        <a id="find"
	                           data-url="/participants/find"
	                           data-id="find" data-title="参会名单" class="site-liebiao-active"
	                           data-type="tabAdd">参会名单</a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">后勤保障</a>
                    <dl class="layui-nav-child">
                        <dd>
	                        <a id="eat"
	                           data-url="/html/eat"
	                           data-id="eat" data-title="吃" class="site-liebiao-active"
	                           data-type="tabAdd">吃</a>
                        </dd>
                        <dd>
	                        <a id="hotel"
	                           data-url="/html/hotel"
	                           data-id="hotel" data-title="住" class="site-liebiao-active"
	                           data-type="tabAdd">住</a>
                        </dd>
                    </dl>
                </li>
                
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">座位安排</a>
                    <dl class="layui-nav-child">
                        <dd>
	                        <a id="seat"
	                           data-url="/seat/seat"
	                           data-id="seat" data-title="座位表" class="site-liebiao-active"
	                           data-type="tabAdd">座位表</a>
                        </dd>  
                        <dd>
	                        <a id="signOnFind"
	                           data-url="/SignOn/find"
	                           data-id="signOnFind" data-title="签到表" class="site-liebiao-active"
	                           data-type="tabAdd">签到表</a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <div class="layui-tab" lay-filter="liebiao" lay-allowclose="true" style="padding-top: 2px">
            <ul class="layui-tab-title">
            </ul>
            <ul class="rightmenu" style="display: none;position: absolute;">
                <li data-type="closethis">关闭当前</li>
                <li data-type="closeall">关闭所有</li>
            </ul>
            <div class="layui-tab-content">
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
         -会议管理系统-
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"></script>
<script src="${pageContext.request.contextPath}/js/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/lay/modules/table.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/lay/modules/laypage.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/lay/modules/layer.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/lay/modules/laydate.js" charset="utf-8"></script>

<script>
	function postMsg(){
		$.ajax({
			url:"${pageContext.request.contextPath}/User/cancel",			//请求的服务器地址
			type:'post',
			data:{},//参数				
		
		success: function(data){
	                var data = eval('(' + data + ')');
	                if (data.status==1){
	                	window.location.replace("${pageContext.request.contextPath}/html/index");
	                }
	                else if(data.status==2){
	                    alert("错误！");
	                }
	                //假如账号冲突返回什么
	            }})
	}
    //JavaScript代码区域
    layui.use('element', function () {
        var $ = jQuery = layui.jquery;
        var element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
        //触发事件

        var active = {
            tabAdd: function (url, id, title) {
                //新增一个Tab项
                element.tabAdd('liebiao', {
                    title: title,
                    content: "<iframe width='100%' heigh='100%' src=\'" + '${pageContext.request.contextPath}' + url + "\'></iframe>",
                    id: id,
                });
                CustomRightClick(id);//绑定右键菜单
                FrameWH();//计算框架高度
            }
            , tabChange: function (id) {
                //切换到指定Tab项
                element.tabChange('liebiao', id); //切换到：用户管理
                $("iframe[data-frameid='" + id + "']").attr("src", $("iframe[data-frameid='" + id + "']").attr("src"))//切换后刷新框架
            }
            , tabDelete: function (id) {
                element.tabDelete("liebiao", id);//删除
            }
            , tabDeleteAll: function (ids) {//删除所有
                $.each(ids, function (i, item) {
                    element.tabDelete("liebiao", item);
                })
            }
        };

        //结合菜单展示内容
        $("#selectMyself").click(function () {
            Toselect("selectMyself");
        });
        $("#signManasignMana").click(function () {
            Toselect("signManasignMana");
        });
        $("#show").click(function () {
            Toselect("show");
        });
        $("#findByMnum").click(function () {
            Toselect("findByMnum");
        });
        $("#find").click(function () {
            Toselect("find");
        });
        $("#eat").click(function () {
            Toselect("eat");
        });
        $("#hotel").click(function () {
            Toselect("hotel");
        });
        $("#seat").click(function () {
            Toselect("seat");
        });
        $("#meetingImage").click(function () {
            Toselect("meetingImage");
        });
        $("#Cockpit").click(function () {
            Toselect("Cockpit");
        });
        $("#signOnFind").click(function () {
            Toselect("signOnFind");
        });
        $("#copyMnum").click(function () {
            Toselect("copyMnum");
        });
        
        function Toselect(id) {
            var dataid = $(document.getElementById(id));
            if ($(".layui-tab-title li[lay-id]").length <= 0) {
                active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"));
            } else {
                var isData = false;
                $.each($(".layui-tab-title li[lay-id]"), function () {
                    if ($(this).attr("lay-id") == dataid.attr("data-id")) {
                        isData = true;
                    }
                })
                if (isData == false) {
                    active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"));
                }
            }
            active.tabChange(dataid.attr("data-id"));
        }

        //绑定右键菜单
        function CustomRightClick(id) {
            //取消右键
            $('.layui-tab-title li').on('contextmenu', function () {
                return false;
            })
            $('.layui-tab-title,.layui-tab-title li').click(function () {
                $('.rightmenu').hide();
            });
            //桌面点击右击
            $('.layui-tab-title li').on('contextmenu', function (e) {
                var popupmenu = $(".rightmenu");
                popupmenu.find("li").attr("data-id", id);
                l = ($(document).width() - e.clientX) < popupmenu.width() ? (e.clientX - popupmenu.width()) : e.clientX;
                t = ($(document).height() - e.clientY) < popupmenu.height() ? (e.clientY - popupmenu.height()) : e.clientY;
                popupmenu.css({left: l, top: t}).show();
                //alert("右键菜单")
                return false;
            });
        }

        $(".rightmenu li").click(function () {
            if ($(this).attr("data-type") == "closethis") {
                active.tabDelete($(this).attr("data-id"))
            } else if ($(this).attr("data-type") == "closeall") {
                var tabtitle = $(".layui-tab-title li");
                var ids = new Array();
                $.each(tabtitle, function (i) {
                    ids[i] = $(this).attr("lay-id");
                })
                active.tabDeleteAll(ids);
            }
            $('.rightmenu').hide();
        })

        function FrameWH() {
            var h = $(window).height();
            $("iframe").css("height", h + "px");
        }

        $(window).resize(function () {
            FrameWH();
        })
    });
    
    function closeMeeting() {
        var url='${pageContext.request.contextPath}/meeting/closeMeeting';  //要请求的服务器url
        $.ajax({
            url:url,//要请求的服务器url
            data:{
            },  //传标识符，id未标识符的值
            async:true,   //是否为异步请求
            type:"POST", //请求方式为POST
            //dataType:"json",   //服务器返回的数据是什么类型
            success: function(data){
			 	var data = eval('(' + data + ')');
				//alert("测试");
				if (data.status==1){
					location.href="${pageContext.request.contextPath}/html/homepage";
					//location.href="http://www.baidu.com";
				}  
            }
        });

    }
</script>
</body>
</html>