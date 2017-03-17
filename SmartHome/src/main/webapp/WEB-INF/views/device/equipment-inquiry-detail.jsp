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
<div class="item">
	<h3>方案資料</h3>
	<p><strong id="offerName"></strong></p>
</div>
<ul id="listitem"><c:forEach items="${deviceList}" var="device">
	<li>
		<div class="listitem-main">
			<p><strong>設備名稱</strong>${device.type}</p>
			<p><strong>設備編號</strong>${device.serial}</p>
		</div>
		<div class="listitem-time">
			<p><strong>上次連線時間</strong></p>
			<p>${device.connTime}</p>
		</div>
		<div class="listitem-other">
			<div class="otherleft">
				<p><strong>電量</strong></p>
				<p><strong>連線狀態</strong></p>
			</div>
			<p>
			<c:choose>
				<c:when test="${device.power eq '0'}"><img src="${pageContext.request.contextPath}/images/icon_wrong.png" alt="異常" width="10" height="10"> 異常</c:when>
				<c:otherwise><img src="${pageContext.request.contextPath}/images/icon_normal.png" alt="正常" width="10" height="10"> 正常</c:otherwise>
			</c:choose></p>
			<p>
			<c:choose>
				<c:when test="${device.status eq '0'}"><img src="${pageContext.request.contextPath}/images/icon_wrong.png" alt="異常" width="10" height="10"> 異常</c:when>
				<c:otherwise><img src="${pageContext.request.contextPath}/images/icon_normal.png" alt="正常" width="10" height="10"> 正常</c:otherwise>
			</c:choose></p>
		</div>
	</li></c:forEach>
</ul>
<div class="comment">* 僅呈現磁簧、紅外線偵測器…等警報設備的連線狀態 </div>
</c:if>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script> 
<script>
$(function() {
	$("#offerName").html(offerNameMap["${deviceSerial}"]);
	<c:if test="${not empty errMsg}">
	showMessage("${errMsg}");
	</c:if>
});
</script>
</body>
</html>