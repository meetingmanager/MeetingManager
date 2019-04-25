<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<a id="signOnList" name="signOnList" style="display:none">${list}</a>
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
					<th>联系电话</th>
					<th>是否有签到</th>
				</tr>
			</thead>
			<tbody id="body">
		
			</div>
			</tbody>
		</table>
		<!--分页-->
		<div class="Paging" id="pagination">
		<div class="row">
                <div class="col-md-7">
                    当前为第${myPageInfo.pageNum}页，总共有${myPageInfo.pages}页，共有${myPageInfo.total}条记录
                </div>
                <div class="col-md-5">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li><a href="${pageContext.request.contextPath}/SignOn/find?pn=1">首页</a>
                            </li>
                            <li>
                                <c:if test="${myPageInfo.hasPreviousPage}">
                                    <a href="${pageContext.request.contextPath}/SignOn/find?pn=${myPageInfo.pageNum-1}"
                                       aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </c:if>
                            </li>
                            <c:forEach items="${myPageInfo.navigatepageNums}" var="page_num">
                                <c:if test="${page_num==myPageInfo.pageNum}">
                                    <li class="active"><a
                                            href="${pageContext.request.contextPath}/SignOn/find?pn=${page_num}">${page_num}</a>
                                    </li>
                                </c:if>
                                <c:if test="${page_num!=myPageInfo.pageNum}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/SignOn/find?pn=${page_num}">${page_num}</a>
                                    </li>
                                </c:if>
                            </c:forEach>
                            <li>
                                <c:if test="${myPageInfo.hasNextPage}">
                                    <a href="${pageContext.request.contextPath}/SignOn/find?pn=${myPageInfo.pageNum+1}"
                                       aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </c:if>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/SignOn/find?pn=${myPageInfo.pages}">末页</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
		</div>
	</body>
<script type="text/javascript">
	function excelExport(){
		$.ajax({
			url:"${pageContext.request.contextPath}/SignOn/excel",
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
    function judgeAll(){
    	
		var list=document.getElementById("signOnList").innerHTML;
		var list1 = jQuery.parseJSON(list);
        $.each(list1,function(index,value){

            	$("#body").append("<tr class='relative human'>"+
                //获得待审核人员姓名
                "<td class='humanName'>"+value.user.username+"</td>"+
                "<td class='table-edit sex'>"+value.user.usersex+"</td>"+
                "<td>"+"<img style=\"width:50px;height:50px\" src=/pictures/"+value.user.headphoto+"></td>"+
                "<td class='table-edit unit'>"+value.user.phone+"</td>"+
                "<td class='table-edit pnum'>"+value.sflag+"</td>"+
                "<td class='judge'>"+"<button class='btn btn-danger padding5'>"+"未签到"+"</button>"+"<button class='btn btn-danger padding5'>"+"已签到"+"</button>"+"</td>"+
                "</tr>");
        	
        });
        	
    	var judge = document.getElementsByClassName('judge');
        var pnum = document.getElementsByClassName('pnum');
        for(var i = 0;i<pnum.length;i++){
    		if (pnum[i].innerHTML != 1) {
    				//alert("yes");
    				judge[i].style.color = 'red';
    				judge[i].innerHTML = '未签到';
    			}else if(pnum[i].innerHTML == 1){
    				judge[i].style.color = 'green';
    				judge[i].innerHTML = '已签到';
    			}
    	}
       }
</script>