<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content='遠傳全能行動管家'>
<meta name="keywords" content='遠傳全能行動管家'>
<meta name='WT.cg_n' content='遠傳全能行動管家'>
<meta name='WT.cg_s' content='遠傳全能行動管家'>
<meta name='WT.cg_sub' content='na'>
<title>遠傳全能行動管家 - 遠傳電信 FETnet</title>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/favicon.ico">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/pure-min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/grids-responsive-min.css">

<!--<![endif]-->
<link href="${pageContext.request.contextPath}/js/jquery-ui.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/smarthome.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<form id="logoutForm" action="<spring:message code="logout.url" />"
		method="post">
		<input type="hidden" name="url"
			value="<spring:message code="home.url" />">
	</form>
	<div class="headerwrapper">
		<div class="header">
			<div class="logo">
				<a href="http://www.fetnet.net/homepage/"><img
					src="${pageContext.request.contextPath}/images/logo.jpg"
					alt="FETnet">
				</a>
			</div>
			<div class="theme">
				<img src="${pageContext.request.contextPath}/images/theme.jpg">
			</div>
			<div class="tools">
				<a href="<spring:message code="ecare.url" />" class="btnservice">用戶服務</a>
				<a href="<spring:message code="service_location.url" />"
					class="btnretail">服務據點</a> <a
					href="<spring:message code="member_center.url" />"
					class="btnmenber">會員中心</a>
			</div>
		</div>
	</div>
	<div class="menber">
		<a href="<spring:message code="home.url" />" class="btnsmarthome">回全能行動管家首頁</a><a
			href="javascript:logout();">您好，${userProfile.nickName}│登出</a>
	</div>
	<div class="content">
		<h2 class="pagetitle">用戶專區-警報設備查詢</h2>
		<div id="sh-set-nav">
			<ul>
				<li class="active"><a
					href="${pageContext.request.contextPath}/device/listAllDevice.action">警報設備查詢</a>
				</li>
				<li><a
					href="${pageContext.request.contextPath}/device/recordInquiryInit.action">警報紀錄查詢</a>
				</li>
				<li><a
					href="${pageContext.request.contextPath}/device/settingsInit.action">警報通知設定</a>
				</li>
			</ul>
		</div>
		<div class="main">
			<c:choose>
				<c:when test="${empty offerList}">查無資料</c:when>
				<c:otherwise>
					<div class="item">
						<h3>攝影機編號</h3>
						<label for="nb"></label> <select id="deviceSerial"><c:forEach
								items="${offerList}" var="offer">
								<option value="${offer.deviceSerial}">${offer.deviceSerial}</option>
							</c:forEach>
						</select>
						<button id="btnSelect">查詢</button>
					</div>
				</c:otherwise>
			</c:choose>
			<div id="displayBlock">
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
		<p>
			<a onClick="sendCTRLog1('M')"
				href="http://www.fetnet.net/FETnet/security.html">隱私權</a> ｜ <a
				onClick="sendCTRLog1('M')"
				href="http://www.fetnet.net/cs/Satellite/FETnet/FnCopyright">著作權條款</a> ｜ <a
				onClick="sendCTRLog1('M')" href="http://www.cpc.ey.gov.tw/"
				target="_blank" rel="nofollow">行政院消保會</a> 
		</p>
		<p>遠傳電信版權所有Copyright &copy;</p>
	</div>
	<!--============================== 彈出訊息彈出訊息彈出訊息 ==============================-->
	<div id="dialog" title="">
		<p>
			<span id="dialogMsg"></span>
		</p>
	</div>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
	<script>
		function showMessage(message) {
			$("#dialog").prop("title", "警告");
			$("#dialogMsg").text(message);
			$("#dialog").dialog({
				height : 140,
				modal : true
			});
		}

		function logout() {
			$.ajax({
				url : "${pageContext.request.contextPath}/logout.action",
				type : 'POST',
				success : function(response) {
					$("#logoutForm").submit();
				},
				error : function(xhr, ajaxOptions, thrownError) {
				}
			});
		}

		var offerNameMap = new Object();
		<c:forEach items="${offerList}" var="offer">
		offerNameMap["${offer.deviceSerial}"] = "${offer.offerName}";
		</c:forEach>
		$(function() {
			$("#btnSelect").click(function() {
				var deviceSerial = $("#deviceSerial").val();
				$("#displayBlock").load("${pageContext.request.contextPath}/device/queryDevice.action",{
					deviceSerial : deviceSerial
				});
			});
			<c:if test="${not empty errMsg}">
			showMessage("${errMsg}");
			</c:if>

			$("#btnSelect").click();
		});
	</script>
</body>
</html>