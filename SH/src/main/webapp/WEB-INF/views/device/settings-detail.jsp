<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
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
<title>遠傳全能行動管家 - 遠傳電信 FETnet</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pure-min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/grids-responsive-min.css">

<!--<![endif]-->
<link href="${pageContext.request.contextPath}/js/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/smarthome.css" rel="stylesheet" type="text/css" />
</head>
<body>
<c:if test="${(not empty smsList) or (not empty emailList)}">
		<div class="itemtitle downline">
			<h3>簡訊通知設定</h3>
		</div>
		<form class="pure-form">
			<div class="pt10 pb10">
				<h3 class="pb5">手機號碼</h3>
				<fieldset>
					<input name="mobile" id="txtMobile" type="text" class="input100" placeholder="輸入的手機號碼須為遠傳門號" size="30">
					<button type="button" id="btnSendMobile" class="pure-button">加入以下通知清單</button>
				</fieldset>
			</div>
		</form>
		<table width="100%" class="pure-table pure-table-bordered">
			<thead>
				<tr>
					<th>手機號碼</th>
					<th width="60" align="center">狀態</th>
					<th width="70">&nbsp;</th>
				</tr>
			</thead><c:forEach items="${smsList}" var="sms" varStatus="smsIndex">
			<tr<c:if test="${(smsIndex.index % 2) eq 1}"> class="pure-table-odd"</c:if>>
				<td>${sms.value}</td>
				<td align="center"><p class="txt13"><c:choose><c:when test="${sms.value eq userProfile.msisdn}"></c:when><c:otherwise>${sms.status}</c:otherwise></c:choose></p></td>
				<td align="center"><p class="txt13"><c:choose><c:when test="${sms.value eq userProfile.msisdn}">申請人</c:when><c:otherwise><button type="button" class="pure-button btnRemoveSms" value="${sms.value}">刪 除</button></c:otherwise></c:choose></p></td>
			</tr></c:forEach>
		</table>
		<div class="itemtitle downline">
			<h3>Email通知設定</h3>
		</div>
		<form class="pure-form">
			<div class="pt10 pb10">
				<h3 class="pb5">Email</h3>
				<fieldset>
					<input name="mobile" id="txtEmail" type="text" class="input100" placeholder="請輸入正確Email格式" size="30">
					<button type="button" id="btnSendEmail" class="pure-button">加入以下通知清單</button>
				</fieldset>
			</div>
		</form>
		<table width="100%" class="pure-table pure-table-bordered">
			<thead>
				<tr>
					<th>E mail</th>
					<th width="60" align="center">狀態</th>
					<th width="70">&nbsp;</th>
				</tr>
			</thead><c:forEach items="${emailList}" var="email" varStatus="emailIndex">
			<tr<c:if test="${(emailIndex.index % 2) eq 1}"> class="pure-table-odd"</c:if>>
				<td class="txtbreak">${email.value}</td>
				<td align="center"><p class="txt13">${email.status}</p></td>
				<td align="center"><p class="txt13"><button type="button" class="pure-button btnRemoveEmail" value="${email.value}">刪 除</button></p></td>
			</tr></c:forEach>
		</table></c:if>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script> <script>
var smsLimit = <spring:message code="alert_notice.limit.sms" />;
var emailLimit = <spring:message code="alert_notice.limit.email" />;
$(function() {
	$("#btnSendMobile").click(function() {
		var deviceSerial = $("#deviceSerial").val();
		var value = $("#txtMobile").val();
		if(value.match(/^\d{10}$/)) {
			var valid = true;<c:forEach items="${smsList}" var="sms">
			valid = valid & ("${sms.value}" != value);</c:forEach>
			if(valid) {
				if(${fn:length(smsList)} < smsLimit) {
					$("#displayBlock").load("${pageContext.request.contextPath}/device/settings.action", {
						action : "add",
						deviceSerial : deviceSerial,
						type : "sms",
						value : value
					});	
				}
				else {
					showMessage("設定數超過上限");
				}
			}
			else {
				showMessage("電話號碼重複");
			}
		}
		else {
			showMessage("請輸入正確電話號碼");
		}
	});
	
	$("#btnSendEmail").click(function() {
		var deviceSerial = $("#deviceSerial").val();
		var value = $("#txtEmail").val();
		if(value.match(/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i)) {
			var valid = true;<c:forEach items="${emailList}" var="email">
			valid = valid & ("${email.value}" != value);</c:forEach>
			if(valid) {
				if(${fn:length(emailList)} < emailLimit) {
					$("#displayBlock").load("${pageContext.request.contextPath}/device/settings.action", {
						action : "add",
						deviceSerial : deviceSerial,
						type : "email",
						value : value
					});	
				}
				else {
					showMessage("設定數超過上限");
				}
			}
			else {
				showMessage("email信箱重複");
			}
		}
		else {
			showMessage("請輸入正確Email格式");
		}
	});
	
	$(".btnRemoveSms").click(function() {
		var deviceSerial = $("#deviceSerial").val();
		var value = $(this).val();
		$("#displayBlock").load("${pageContext.request.contextPath}/device/settings.action", {
			action : "remove",
			deviceSerial : deviceSerial,
			type : "sms",
			value : value
		});
	});
	
	$(".btnRemoveEmail").click(function() {
		var deviceSerial = $("#deviceSerial").val();
		var value = $(this).val();
		$("#displayBlock").load("${pageContext.request.contextPath}/device/settings.action", {
			action : "remove",
			deviceSerial : deviceSerial,
			type : "email",
			value : value
		});
	});
	<c:if test="${not empty errMsg}">
	showMessage("${errMsg}");
	</c:if>
});
</script>
</body>
</html>