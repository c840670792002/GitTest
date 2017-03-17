<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico"> 
<link href="${pageContext.request.contextPath}/js/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/smarthome.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form id="logoutForm" action="<spring:message code="logout.url" />" method="post">
	<input type="hidden" name="url" value="<spring:message code="home.url" />">
</form>
<div class="headerwrapper">
	<div class="header">
		<div class="logo"><a href="http://www.fetnet.net/homepage/"><img src="${pageContext.request.contextPath}/images/logo.jpg" alt="FETnet"></a></div>
		<div class="theme"><img src="${pageContext.request.contextPath}/images/theme.jpg"></div>
		<div class="tools">
			<a href="<spring:message code="ecare.url" />" class="btnservice">用戶服務</a>
			<a href="<spring:message code="service_location.url" />" class="btnretail">服務據點</a>
			<a href="<spring:message code="member_center.url" />" class="btnmenber">會員中心</a>
		</div>
	</div>
</div>
<div class="menber"><a href="<spring:message code="home.url" />" class="btnsmarthome">回全能行動管家首頁</a><a href="javascript:logout();">您好，${userProfile.nickName}│登出</a></div>
<div class="content">
	<h1 class="pagetitle">用戶專區-警報通知設定</h1>
	<div id="sh-set-nav">
		<ul>
			<li><a href="${pageContext.request.contextPath}/device/listAllDevice.action">警報設備查詢</a></li>
			<li><a href="${pageContext.request.contextPath}/device/recordInquiryInit.action">警報紀錄查詢</a></li>
			<li class="active"><a href="${pageContext.request.contextPath}/device/settingsInit.action">警報通知設定</a></li>
		</ul>
	</div>
	<div class="main"><c:choose><c:when test="${empty offerList}">查無資料</c:when><c:otherwise>
		<div class="item">
			<h3>攝影機編號</h3>
				<label for="nb"></label>
				<select id="deviceSerial"><c:forEach items="${offerList}" var="offer">
					<option value="${offer.deviceSerial}">${offer.deviceSerial}</option></c:forEach>
				</select>
			<button id="btnSelect">查詢</button></c:otherwise></c:choose>
		</div>
		<ul class="ullist">
			<li>可設定簡訊數說明：服務申請人門號+2個其他親友門號（限遠傳門號）</li>
			<li>可設定E-mail通知：任一方案皆可設定3個收件e-mail信箱 </li>
			<li> 申請人設定完畢後，將會以「簡訊」或「E-mail」通知您所設定的對象，待其完成認證流程後，才能正式接收警報簡訊。 </li>
			<li>承上，本服務寄出的<span class="txtred">認證碼有效時間為24小時，僅限使用一次</span>，若您設定的對象未於時效內完成認證，該認證通知將會失效；<br>
			屆時，您只要刪除再重新設定，系統將重發認證信。 </li>
		</ul>
		<div id="displayBlock">
<c:if test="${(not empty offerList) and ((not empty smsList) or (not empty emailList))}">
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
		</div>
<c:if test="${not empty offerList}">

                    <div class="footer">
                        <p><a href="${pageContext.request.contextPath}/device/user_manual.action" style="color: #666;text-decoration: none;font-size: 15px;">使用手冊下載</a>
                            &nbsp;｜&nbsp;<a href="${pageContext.request.contextPath}/device/sh_player.action" style="color: #666;text-decoration: none;font-size: 15px;">軟體下載</a>
                        </p>
                    </div>
					</c:if>
	</div>
</div>
<div class="footer">
	<p><a onClick="sendCTRLog1('M')" href="http://www.fetnet.net/FETnet/security.html">隱私權</a> ｜ <a onClick="sendCTRLog1('M')" href="http://www.fetnet.net/cs/Satellite/FETnet/FnCopyright">著作權條款</a> ｜ <a onClick="sendCTRLog1('M')" href="http://www.cpc.ey.gov.tw/" target="_blank" rel="nofollow">行政院消保會</a> </p>
	<p>遠傳電信版權所有Copyright &copy;</p>
</div>
<!--============================== 彈出訊息彈出訊息彈出訊息 ==============================-->
<div id="dialog" title="">
	<p><span id="dialogMsg"></span></p>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script> 
<script>
function showMessage(message) {
	$("#dialog").prop("title", "警告");
	$("#dialogMsg").text(message);
	$( "#dialog" ).dialog({
      height: 140,
      modal: true
    });
}

function logout() {
	$.ajax({
		url: "${pageContext.request.contextPath}/logout.action",
		type: 'POST',
		success: function(response) {
			$("#logoutForm").submit();
		},
		error: function(xhr, ajaxOptions, thrownError) {
		}
	});
}

var smsLimit = <spring:message code="alert_notice.limit.sms" />;
var emailLimit = <spring:message code="alert_notice.limit.email" />;

$(function() {
	$("#btnSelect").click(function() {
		var deviceSerial = $("#deviceSerial").val();
		$("#displayBlock").load("${pageContext.request.contextPath}/device/settings.action", {
			deviceSerial : deviceSerial
		})
	})
	<c:if test="${not empty errMsg}">
	showMessage("${errMsg}");
	</c:if>
	$("#btnSelect").click();
});

</script>
</body>
</html>