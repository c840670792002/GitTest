<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content='遠傳全能行動管家'>
<meta name="keywords" content='遠傳全能行動管家'>
<meta name ='WT.cg_n' content='遠傳全能行動管家'>
<meta name ='WT.cg_s' content='遠傳全能行動管家'>
<meta name ='WT.cg_sub' content='na'>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pure-min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/grids-responsive-min.css">
<!--<![endif]-->
<link href="${pageContext.request.contextPath}/js/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/smarthome.css" rel="stylesheet" type="text/css" />
</head>
<body>
<c:if test="${empty errMsg}">

		<div class="itemtitle">
			<h3>警報紀錄結果查詢<small>以下預設顯示最新的10筆，若須查詢其他日期區間，請重新輸入搜尋區間。</small></h3>
		</div>
		<ul id="listitem2"><c:forEach items="${alertEventList}" var="alertEvent">
			<li>
				<div class="listitem-time">
					<p><strong>警報時間</strong>${alertEvent.time}</p>
				</div>
				<div class="listitem-main">
					<p><strong>設備編號</strong>${alertEvent.device.serial}</p>
					<p><strong>設備名稱</strong>${alertEvent.device.type}</p>
				</div>
				
                                <c:set var="picUrl" value="${alertEvent.picUrl}" scope="request"/>
                                <%
                                    String picUrl= (String) request.getAttribute("picUrl");
                                %>
				<div class="listitem-other"> <a href="javascript:openImage('<%= java.net.URLEncoder.encode( picUrl) %>')"><img src="${pageContext.request.contextPath}/images/icon_photo.png" alt="PHOTO" width="20" height="16"> PHOTO </a></div>
			</li></c:forEach>
		</ul><c:if test="${not empty alertEventList}">
		<div class="paginationbox">
			<ul class="pagination">
				<c:if test="${1 ne currPage}"><li> <a href="javascript:showPage(${currPage - 1});" aria-label="Previous"> <img src="${pageContext.request.contextPath}/images/icon_Previous.png" alt="Previous" width="5" height="10"></a> </li></c:if><c:forEach begin="1" end="${totalPage}" var="pageIndex">
				<li<c:if test="${pageIndex eq currPage}"> class="active"</c:if>><a href="javascript:showPage(${pageIndex});">${pageIndex}</a></li></c:forEach>
				<c:if test="${totalPage ne currPage}"><li> <a href="javascript:showPage(${currPage + 1});" aria-label="Next"> <img src="${pageContext.request.contextPath}/images/icon_Next.png" alt="next" width="5" height="10"></a> </li></c:if>
			</ul>
			<ul class="pagination">
				<li><a href="javascript:showPage(1);">第一頁</a></li>
				<li><a href="javascript:showPage(${totalPage});">最後一頁</a></li>
			</ul>
		</div></c:if>
</c:if>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script> 
<script>
<c:if test="${not empty errMsg}">
$(function() {
	showMessage("${errMsg}");
})
</c:if>
</script>
</body>
</html>