<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="">
    <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport"
              content="width=device-width; initial-scale=1.0; user-scalable=0;">
        <meta name="keywords" content="全能行動管家,智慧管家,智慧家庭,智慧住宅,智能住宅,網路攝影機,智慧插座,寵物餵食機,關懷家人,照顧寵物">
        <meta name="description" content="月租優惠最低$199起，立即申辦享好康!! 好康一：免費到府安裝 。好康二：32G記憶卡，容量瞬間加大 。好康三：加碼抽馬爾地夫豪華雙人遊">
        <title>遠傳全能行動管家</title>
        <link rel="shortcut icon"
              href="${pageContext.request.contextPath}/favicon.ico">
        <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/apple-touch-icon.png">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pure-min.css">
        <!--[if lte IE 8]>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/grids-responsive-old-ie-min.css">
        <![endif]-->
        <!--[if gt IE 8]><!-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/grids-responsive-min.css">
        <!--<![endif]-->
        <script src="${pageContext.request.contextPath}/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        <link rel="stylesheet" href="js/owl-carousel/owl.carousel.css">
        <link rel="stylesheet" href="js/fancyBox/jquery.fancybox.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/produucts.css">
        <!-- track -->
        <script src="${pageContext.request.contextPath}/js/SDC1.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/SDC2.js" type="text/javascript"></script>
        <noscript>
    <div>
        <img alt="DCSIMG" id="DCSIMG" width="1" height="1"
             src="http://weblog.fetnet.net/dcs08y8fj10000g8dgxavl6yn_3w8q/njs.gif?dcsuri=/nojavascript&amp;WT.js=No&amp;WT.tv=8.6.2" />
    </div>
    </noscript>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->
        <form id="logoutForm" action="<spring:message code="logout.url" />"
              method="post">
            <input type="hidden" name="url"
                   value="<spring:message code="home.url" />">
        </form>
        <header class="headerwrapper">
            <div class="header">
                <div class="logo">
                    <a href="javascript:;"
                       onClick="javascript:sendCTRLog('http://www.fetnet.net/', 'Header', '遠傳logo');"><img
                            src="${pageContext.request.contextPath}/img/logo.jpg" alt="FETnet">
                    </a>
                </div>
                <div class="theme">
                    <img src="${pageContext.request.contextPath}/img/theme.jpg" alt="FETnet">
                </div>
                <div class="tools">
                    <a href="<spring:message code="ecare.url" />"
                       onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '用戶服務', 'DCSext.WTClick_t', 'Header');"
                       class="btnservice">用戶服務</a> <a
                       href="<spring:message code="service_location.url" />"
                       onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '服務據點', 'DCSext.WTClick_t', 'Header');"
                       class="btnretail">服務據點</a> <a
                       href="<spring:message code="member_center.url" />"
                       onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '會員中心', 'DCSext.WTClick_t', 'Header');"
                       class="btnmenber">會員中心</a> <a href="javascript:;"
                       onClick="javascript:sendCTRLog('http://m.fetnet.net/mHome/eservice_ShopCenter3.html', 'Header', '門市');"
                       class="mobileretail">門市</a>
                </div>
            </div>
        </header>
        <article class="home coverbg bg01" id="top">
            <nav class="nav">
                <ul id="nav">
                    <li><a href="#top" id="nav00">home</a></li>
                    <li><a href="#cf" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '情境體驗', 'DCSext.WTClick_t', '選單');" id="nav01"><img src="${pageContext.request.contextPath}/img/nav_00.png" alt="情境體驗">情境體驗</a></li>
                    <li><a href="#feature" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '服務功能', 'DCSext.WTClick_t', '選單');" id="nav02"><img src="${pageContext.request.contextPath}/img/nav_01.png" alt="服務功能">服務功能</a></li>
                    <li><a href="#feature_6" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '服務特色', 'DCSext.WTClick_t', '選單');" id="nav03"><img src="${pageContext.request.contextPath}/img/nav_02.png" alt="服務特色">服務特色</a></li>
                    <li><a href="#instructions" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '操作說明', 'DCSext.WTClick_t', '選單');" id="nav04"><img src="${pageContext.request.contextPath}/img/nav_03.png" alt="操作說明">操作說明</a></li>

                    <li><a href="#device_home" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '設備介紹', 'DCSext.WTClick_t', '選單');" id="nav05"><img src="${pageContext.request.contextPath}/img/nav_05.png" alt="設備介紹">設備介紹</a></li>

                    <li><a href="#promotion" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '優惠方案', 'DCSext.WTClick_t', '選單');" id="nav06"><img src="${pageContext.request.contextPath}/img/nav_04.png" alt="優惠方案">優惠方案</a></li>

                    <li><a href="#apply" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '申請方式', 'DCSext.WTClick_t', '選單');" id="nav07"><img src="${pageContext.request.contextPath}/img/nav_06.png" alt="申請方式">申請方式</a></li>
                    <li><a href="#eservice" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '客戶服務', 'DCSext.WTClick_t', '選單');" id="nav08"><img src="${pageContext.request.contextPath}/img/nav_07.png" alt="客戶服務">客戶服務</a></li>
                </ul>
            </nav>
            <nav class="navdown"><a href="<spring:message code="login.url" />" target="_blank" class="" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '用戶專區', 'DCSext.WTClick_t', '選單');">用戶專區</a>
                | 	
                <a href="#company" class="gotodiv" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '企業用戶', 'DCSext.WTClick_t', '選單');">企業用戶</a>
            </nav>
            <div class="hometitle">
                <h1>遠傳全能行動管家</h1>
            </div>
            <img src="${pageContext.request.contextPath}/img/homekv.png" alt="遠傳全能行動管家" class="homekv" data-wow-delay="0.5s"> 
            <a href="http://promotion.fetnet.net/Pmt/smarthome/index.html" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '限時優惠活動', 'DCSext.WTClick_t', '首頁');" class="homesale" target="_blank"><img src="${pageContext.request.contextPath}/img/icon_sale.png" alt="限時優惠活動">限時優惠活動</a>
            <a href="http://promotion.fetnet.net/Pmt/smarthome/mobile/index.html" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '限時優惠活動', 'DCSext.WTClick_t', '首頁');" class="homesalem" target="_blank"><img src="${pageContext.request.contextPath}/img/icon_sale.png" alt="限時優惠活動">限時優惠活動</a>
                <c:choose>
                    <c:when test="${not empty userProfile}"> <a href="javascript:logout();" class="login">您好，${userProfile.nickName}│登出</a> </c:when>
                <c:otherwise> <a href="<spring:message code="member_login_url" />" onClick="javascript:sendCTRLog('
                       <spring:message code="member_login_url" />
                    ','Header','會員登入');" class="login">會員登入</a> <a href="<spring:message code="member_login_url" />" onClick="javascript:sendCTRLog('
                       <spring:message code="member_login_url" />
                        ','Header','註冊');" class="register">註冊</a> </c:otherwise>
            </c:choose> 
        </article>
        <article id="cf">
            <div class="coverbg bg02">
                <div class="wrapper cf">
                    <h3 class="pagetitle" id="color00">情境體驗</h3>
                    <div class="pure-g">
                        <div class="pure-u-1 pure-u-md-1-2">
                            <div class="mr10">
                                <section class="cfbox shadow">
                                    <a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '全能行動管家情境體驗_情境體驗篇', 'DCSext.WTClick_t', '情境體驗');" class="various fancybox.iframe" href="https://www.youtube.com/embed/HIjb166Vqmg?autoplay=1">
                                        <img src="${pageContext.request.contextPath}/img/cf01.jpg" alt="情境體驗篇">
                                        <h3>情境體驗篇</h3>
                                    </a>
                                </section>
                            </div>
                        </div>
                        <div class="pure-u-1 pure-u-md-1-2">
                            <div class="mr10 ml10">
                                <section class="cfbox shadow">
                                    <a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '全能行動管家情境體驗_搞鬼篇', 'DCSext.WTClick_t', '情境體驗');" class="various fancybox.iframe" href="https://www.youtube.com/embed/hy5a_IGo-w4?autoplay=1">
                                        <img src="${pageContext.request.contextPath}/img/cf02.jpg" alt="搞鬼篇">
                                        <h3>搞鬼篇</h3>
                                    </a>
                                </section>
                            </div>
                        </div>
                    </div>
                    <div class="pure-g">
                        <div class="pure-u-1 pure-u-md-1-2">
                            <div class="mr10">
                                <section class="cfbox shadow">
                                    <a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '全能行動管家情境體驗_申辦方案篇', 'DCSext.WTClick_t', '情境體驗');" class="various fancybox.iframe" href="https://www.youtube.com/embed/H70vSHldRUU?autoplay=1">
                                        <img src="${pageContext.request.contextPath}/img/cf03.jpg" alt="申辦方案篇">
                                        <h3>申辦方案篇</h3>
                                    </a>
                                </section>
                            </div>
                        </div>
                        <div class="pure-u-1 pure-u-md-1-2">
                            <div class="mr10 ml10">
                                <section class="cfbox shadow">
                                    <a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '全能行動管家情境體驗_APP操作篇', 'DCSext.WTClick_t', '情境體驗');" class="various fancybox.iframe" href="https://www.youtube.com/embed/KiS-Po5DFFM?autoplay=1">
                                        <img src="${pageContext.request.contextPath}/img/cf04.jpg" alt="APP操作篇">
                                        <h3>APP操作篇</h3>
                                    </a>
                                </section>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </article>


        <article id="feature">
            <div class="coverbg bg01">
                <div class="wrapper">
                    <h3 class="pagetitle" id="color01">服務功能</h3>
                    <div id="function" class="owl-carousel owl-theme">
                        <div class="item" id="feature_img1"><img src="${pageContext.request.contextPath}/img/function01.jpg" alt="遠端連線家中影像 零死角" class="pure-img lazyOwl">
                            <h3>遠端連線家中影像 零死角</h3>
                        </div>
                        <div class="item" id="feature_img2"><img src="${pageContext.request.contextPath}/img/function02.jpg" alt="双重入侵偵測設備 好安心" class="pure-img lazyOwl">
                            <h3>雙重入侵偵測設備 好安心</h3>
                        </div>
                        <div class="item" id="feature_img3"><img src="${pageContext.request.contextPath}/img/function03.jpg" alt="鏡頭自動轉向拍照 真聰明" class="pure-img lazyOwl">
                            <h3>鏡頭自動轉向拍照 真聰明</h3>
                        </div>
                        <div class="item" id="feature_img4"><img src="${pageContext.request.contextPath}/img/function04.jpg" alt="遠端遙控家中電器 超方便" class="pure-img lazyOwl">
                            <h3>遠端遙控家中電器 超方便</h3>
                        </div>
                        <div class="item" id="feature_img5"><img src="${pageContext.request.contextPath}/img/function05.jpg" alt="情境設定智慧排程 最貼心" class="pure-img lazyOwl">
                            <h3>情境設定智慧排程 最貼心</h3>
                        </div>
                        <div class="item" id="feature_img6"><img src="${pageContext.request.contextPath}/img/function06.jpg" alt="寵物智慧餵食裝置 夠便利" class="pure-img lazyOwl">
                            <h3>寵物智慧餵食裝置 夠便利</h3>
                        </div>
                    </div>
                </div>
            </div>
        </article>


        <article id="feature_6">
            <div class="coverbg bg02">
                <div class="wrapper feature">
                    <h3 class="pagetitle" id="color02">六大特色</h3>
                    <div class="pure-g">
                        <div class="pure-u-1 pure-u-md-1-2">
                            <div class="mr10">
                                <section class="featurebox shadow"><img src="${pageContext.request.contextPath}/img/feature01.gif" alt="智慧家庭 一機搞定"> <span class="nb">1</span>
                                    <h3>智慧家庭 一機搞定</h3>
                                    <p>市場唯一！結合智慧家庭控制主機、網路攝影機、警報器、溫溼偵測器…等多功合一的智慧型主機。</p>
                                </section>
                            </div>
                        </div>
                        <div class="pure-u-1 pure-u-md-1-2">
                            <div class="mr10 ml10">
                                <section class="featurebox shadow"> <img src="${pageContext.request.contextPath}/img/feature02.gif" alt="旋轉鏡頭 全面防護"> <span class="nb">2</span>
                                    <h3>旋轉鏡頭 全面防護</h3>
                                    <p>智慧主機搭載可水平355度,垂直100度旋轉的鏡頭，用戶可隨時透過本服務APP，觀看不同角度的影像；若偵測到警報事件，鏡頭還能自動旋轉進行拍照。</p>
                                </section>
                            </div>
                        </div>
                    </div>
                    <div class="pure-g">
                        <div class="pure-u-1 pure-u-md-1-2">
                            <div class="mr10">
                                <section class="featurebox shadow"> <img src="${pageContext.request.contextPath}/img/feature03.gif" alt="QR Code配對 步驟簡易"> <span class="nb">3</span>
                                    <h3>QR Code配對 步驟簡易</h3>
                                    <p>若要為智慧主機新增控制的週邊設備，只要透過本服務APP簡單掃描設備上的QR Code，即可完成配對。</p>
                                </section>
                            </div>
                        </div>
                        <div class="pure-u-1 pure-u-md-1-2">
                            <div class="mr10 ml10">
                                <section class="featurebox shadow"> <img src="${pageContext.request.contextPath}/img/feature04.gif" alt="警報通知 三管齊下"> <span class="nb">4</span>
                                    <h3>警報通知 三管齊下</h3>
                                    <p>偵測到異常狀況，第一時間透過手機簡訊、E-mail及APP 推播訊息…等3種方式，通知用戶警報事件發生，並提供即時現場快照。</p>
                                </section>
                            </div>
                        </div>
                    </div>
                    <div class="pure-g">
                        <div class="pure-u-1 pure-u-md-1-2">
                            <div class="mr10">
                                <section class="featurebox shadow"> <img src="${pageContext.request.contextPath}/img/feature05.gif" alt="紅外線模擬  多元控制"> <span class="nb">5</span>
                                    <h3>智慧排程  聰明生活</h3>
                                    <p>搭配智慧插座讓您的家電變聰明，可透過本服務APP，遠端遙控家電開關電源，還可透過排程或情境設定的方式，聰明管理家電。</p>
                                </section>
                            </div>
                        </div>
                        <div class="pure-u-1 pure-u-md-1-2">
                            <div class="mr10 ml10">
                                <section class="featurebox shadow"> <img src="${pageContext.request.contextPath}/img/feature06.gif" alt="寵物照顧 貼心關懷"> <span class="nb">6</span>
                                    <h3>寵物照顧 貼心關懷</h3>
                                    <p>獨家的智慧型寵物餵食機與活水式飲水機，可隨時隨地遠端餵食，方便飼主貼心寵愛家中寵物。</p>
                                </section>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </article>



        <article id="instructions">
            <div class="coverbg bg01">
                <div class="wrapper mobileapp">
                    <h3 class="pagetitle" id="color03">手機操作</h3>
                    <img src="${pageContext.request.contextPath}/img/mobileapp.png" alt="手機操作" class="pure-img mobileimg"> <img src="${pageContext.request.contextPath}/img/mobileapp_line.png" alt="手機操作"  class="mobileline"> <img src="${pageContext.request.contextPath}/img/mobileapp320.png" alt="手機操作" class="pure-img mobileimg320">
                    <ul class="mobileapplist mobileappleft">
                        <li class="shadow"><span class="nb">1</span>
                            <h4>雙向通話及收聽現場聲音</h4>
                        </li>
                        <li class="shadow"><span class="nb">2</span>
                            <h4>警報設定開啟與取消</h4>
                        </li>
                        <li class="shadow"><span class="nb">3</span>
                            <h4>情境模式選擇</h4>
                        </li>
                        <li class="shadow"><span class="nb">4</span>
                            <h4>查看警報紀錄與網路攝影機記憶卡中的錄影紀錄</h4>
                        </li>
                    </ul>
                    <ul class="mobileapplist mobileappright">
                        <li class="shadow twotxt"><span class="nb">5</span>
                            <h4>即時影像錄影及拍照<em>(存在手機裡）</em></h4>
                        </li>
                        <li class="shadow twotxt"><span class="nb">6</span>
                            <h4>控制家中電器開關<em>（透過智慧開關）</em></h4>
                        </li>
                        <li class="shadow"><span class="nb">7</span>
                            <h4>警報與控制相關設備功能設定</h4>
                        </li>
                        <li class="shadow"><span class="nb">8</span>
                            <h4>攝影機鏡頭位置與警報通知設定</h4>
                        </li>
                    </ul>
                </div>
            </div>
        </article>

        <article id="device_home">
            <div class="coverbg bg02">
                <div class="wrapper product">
                    <h3 class="pagetitle" id="color04">設備介紹</h3>
                    <div id="product">
                        <div class="item">
                            <section class="productbox shadow">
                                <div class="productimg"><img src="${pageContext.request.contextPath}/img/products/01.jpg" alt="全能行動管家網路攝影機"></div>
                                <div class="productinfo">
                                    <h3>全能行動管家網路攝影機</h3>
                                    <div class="productlink"> <a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '全能行動管家網路攝影機_介紹', 'DCSext.WTClick_t', '設備介紹');" class="variousinfo fancybox.iframe" href="productinfo01.html">功能特色</a><a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '全能行動管家網路攝影機_規格', 'DCSext.WTClick_t', '設備介紹');"class="various fancybox.iframe" href="product01.html">硬體規格</a></div>
                                </div>
                            </section>
                        </div>
                        <div class="item">
                            <section class="productbox shadow">
                                <div class="productimg"><img src="${pageContext.request.contextPath}/img/products/05.jpg" alt="全能行動管家遙控器"></div>
                                <div class="productinfo">
                                    <h3>全能行動管家遙控器</h3>
                                    <div class="productlink"> <a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '全能行動管家遙控器_介紹', 'DCSext.WTClick_t', '設備介紹');" class="variousinfo fancybox.iframe" href="productinfo05.html">功能特色</a><a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '全能行動管家遙控器_規格', 'DCSext.WTClick_t', '設備介紹');" class="various fancybox.iframe" href="product05.html">硬體規格</a></div>
                                </div>
                            </section>
                        </div>
                        <div class="item">
                            <section class="productbox shadow">
                                <div class="productimg"><img src="${pageContext.request.contextPath}/img/products/04.jpg" alt="門窗磁簧感應器"></div>
                                <div class="productinfo">
                                    <h3>門窗磁簧感應器</h3>
                                    <div class="productlink"> <a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '門窗磁簧感應器_介紹', 'DCSext.WTClick_t', '設備介紹');" class="variousinfo fancybox.iframe" href="productinfo04.html">功能特色</a><a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '門窗磁簧感應器_規格', 'DCSext.WTClick_t', '設備介紹');" class="various fancybox.iframe" href="product04.html">硬體規格</a></div>
                                </div>
                            </section>
                        </div>
                        <div class="item">
                            <section class="productbox shadow">
                                <div class="productimg"><img src="${pageContext.request.contextPath}/img/products/03.jpg" alt="紅外線廣角偵測器"></div>
                                <div class="productinfo">
                                    <h3>紅外線廣角偵測器</h3>
                                    <div class="productlink"> <a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '紅外線廣角偵測器_介紹', 'DCSext.WTClick_t', '設備介紹');" class="variousinfo fancybox.iframe" href="productinfo03.html">功能特色</a><a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '紅外線廣角偵測器_規格', 'DCSext.WTClick_t', '設備介紹');"class="various fancybox.iframe" href="product03.html">硬體規格</a></div>
                                </div>
                            </section>
                        </div>
                        <div class="item">
                            <section class="productbox shadow">
                                <div class="productimg"><img src="${pageContext.request.contextPath}/img/products/07.jpg" alt="智慧型單孔插座"></div>
                                <div class="productinfo">
                                    <h3>智慧型單孔插座</h3>
                                    <div class="productlink"> <a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '智慧型單孔插座_介紹', 'DCSext.WTClick_t', '設備介紹');" class="variousinfo fancybox.iframe" href="productinfo07.html">功能特色</a><a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '智慧型單孔插座_規格', 'DCSext.WTClick_t', '設備介紹');"class="various fancybox.iframe" href="product07.html">硬體規格</a></div>
                                </div>
                            </section>
                        </div>
                        <div class="item">
                            <section class="productbox shadow">
                                <div class="productimg"><img src="${pageContext.request.contextPath}/img/products/08.jpg" alt="智慧型三孔排插"></div>
                                <div class="productinfo">
                                    <h3>智慧型三孔排插</h3>
                                    <div class="productlink"> <a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '智慧型三孔排插_介紹', 'DCSext.WTClick_t', '設備介紹');" class="variousinfo fancybox.iframe" href="productinfo08.html">功能特色</a><a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '智慧型三孔排插_規格', 'DCSext.WTClick_t', '設備介紹');" class="various fancybox.iframe" href="product08.html">硬體規格</a></div>
                                </div>
                            </section>
                        </div>
                        <div class="item">
                            <section class="productbox shadow">
                                <div class="productimg"><img src="${pageContext.request.contextPath}/img/products/09.jpg" alt="智慧型寵物餵食機" /></div>
                                <div class="productinfo">
                                    <h3>智慧型寵物餵食機</h3>
                                    <div class="productlink"> <a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '智慧型寵物餵食機_介紹', 'DCSext.WTClick_t', '設備介紹');" class="variousinfo fancybox.iframe" href="productinfo09.html">功能特色</a><a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '智慧型寵物餵食機_規格', 'DCSext.WTClick_t', '設備介紹');"class="various fancybox.iframe" href="product09.html">硬體規格</a></div>
                                </div>
                            </section>
                        </div>
                        <div class="item">
                            <section class="productbox shadow">
                                <div class="productimg"><img src="${pageContext.request.contextPath}/img/products/10.jpg" alt="智慧型寵物飲水機" /></div>
                                <div class="productinfo">
                                    <h3>智慧型寵物飲水機</h3>
                                    <div class="productlink"> <a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '智慧型寵物飲水機_介紹', 'DCSext.WTClick_t', '設備介紹');" class="variousinfo fancybox.iframe" href="productinfo10.html">功能特色</a><a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '智慧型寵物飲水機_規格', 'DCSext.WTClick_t', '設備介紹');"class="various fancybox.iframe" href="product10.html">硬體規格</a></div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
            </div>
        </article>


        <article id="promotion">
            <div class="coverbg bg01">
                <div class="wrapper program">
                    <h3 class="pagetitle" id="color05">優惠方案</h3>
                    <ul class="pagenav">
                        <li><a href="#promotion_1" class="gotodiv" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '選購配件', 'DCSext.WTClick_t', '優惠方案');" id="nav041">選購配件</a></li>
                        <li><a href="http://promotion.fetnet.net/Pmt/smarthome/index.html" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '促銷活動', 'DCSext.WTClick_t', '優惠方案');" >促銷活動</a></li>
                        <li><a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '安裝維護費用說明', 'DCSext.WTClick_t', '優惠方案');" class="fancybox" href="#ex-wage">安裝維護費用說明</a></li>
                        <li><a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '偏遠地區', 'DCSext.WTClick_t', '優惠方案');" class="various fancybox.iframe" href="area.html">偏遠地區定義</a></li>
                    </ul>
                    <div id="program">
                        <div class="item">
                            <section class="programbox shadow">
                                <div class="programicon programicon01">
                                    <h3>智慧管家</h3>
                                    <p>家中影像隨時看<br>
                                        居家關懷心安安</p>
                                </div>
                                <div class="programtable">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <th>&nbsp;</th>
                                            <th>智慧管家</th>
                                        </tr>
                                        <tr>
                                            <th>簽約三年<br>
                                                月租費</th>
                                            <td>$199</td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="programinfo">
                                    <ul>
                                        <li>全能行動管家網路攝影機  ╳ 1</li>
                                        <li>全能行動管家遙控器 ╳ 1 </li>
                                    </ul>
                                    <div class="programlink"> <a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '方案說明', 'DCSext.WTClick_t', '優惠方案');" class="fancybox" href="#ex-01">方案說明</a></div>
                                </div>
                            </section>
                        </div>
                        <div class="item">
                            <section class="programbox shadow">
                                <div class="programicon programicon02">
                                    <h3>終極管家</h3>
                                    <p>安防安控隨手得<br>
                                        智慧生活零距離</p>
                                </div>
                                <div class="programtable">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <th>&nbsp;</th>
                                            <th>										終極管家</th>
                                        </tr>
                                        <tr>
                                            <th>簽約兩年<br>
                                                月租費</th>
                                            <td>$399</td>
                                        </tr>
                                        <tr>
                                            <th>簽約三年<br>
                                                月租費</th>
                                            <td>$299</td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="programinfo">
                                    <ul>
                                        <li>全能行動管家網路攝影機  ╳ 1</li>
                                        <li>全能行動管家遙控器 ╳ 1</li>
                                        <li>門窗磁簧感應器 ╳ 1</li>
                                        <li>紅外線廣角偵測器 ╳ 1</li>
                                        <li>智慧型單孔插座  ╳ 1</li>
                                    </ul>
                                    <div class="programlink"> <a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '方案說明', 'DCSext.WTClick_t', '優惠方案');" class="fancybox" href="#ex-02">方案說明</a></div>
                                </div>
                            </section>
                        </div>
                        <div class="item">
                            <section class="programbox shadow">
                                <div class="programicon programicon03">
                                    <h3>終極管家</h3>
                                    <p>智能家居再進化<br>
                                        寵愛毛孩全家樂</p>
                                </div>
                                <div class="programtable">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <th>&nbsp;</th>
                                            <th>終極管家Plus</th>
                                        </tr>
                                        <tr>
                                            <th>簽約兩年<br>
                                                月租費</th>
                                            <td>$499</td>
                                        </tr>
                                        <tr>
                                            <th>簽約三年<br>
                                                月租費</th>
                                            <td>$399</td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="programinfo">
                                    <ul>
                                        <li>全能行動管家網路攝影機  ╳ 1</li>
                                        <li>全能行動管家遙控器 ╳ 1</li>
                                        <li>門窗磁簧感應器 ╳ 1</li>
                                        <li>紅外線廣角偵測器 ╳ 1</li>
                                        <li>智慧型單孔插座  ╳ 1</li>
                                        <li>智慧型寵物餵食機 ╳ 1</li>

                                    </ul>
                                    <div class="programlink"> <a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '方案說明', 'DCSext.WTClick_t', '優惠方案');" class="fancybox" href="#ex-03">方案說明</a></div>
                                </div>
                            </section>
                        </div>
                    </div>
                    <div id="promotion_1" class="fittingbox shadow">
                        <h3>選購配件&nbsp;(用戶可於全省遠傳直營門市或遠傳網路門市加購配件)</h3>
                        <div id="fitting" class="owl-carousel owl-theme">
                            <div class="item"> <img src="${pageContext.request.contextPath}/img/products/04.jpg" alt="門窗磁簧感應器">
                                <h4>門窗磁簧感應器</h4>
                                <a href="http://www.fetnet.net/estore/accessories/Smarthome01" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '門窗磁簧感應器_buynow', 'DCSext.WTClick_t', '優惠方案');" target="_blank" class="buynow">Buy Now</a> </div>
                            <div class="item"> <img src="${pageContext.request.contextPath}/img/products/03.jpg" alt="紅外線廣角偵測器">
                                <h4>紅外線廣角偵測器</h4>
                                <a href="http://www.fetnet.net/estore/accessories/Smarthome02" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '紅外線廣角偵測器_buynow', 'DCSext.WTClick_t', '優惠方案');" target="_blank" class="buynow">Buy Now</a> </div>
                            <div class="item"> <img src="${pageContext.request.contextPath}/img/products/07.jpg" alt="智慧型單孔插座">
                                <h4>智慧型單孔插座</h4>
                                <a href="http://www.fetnet.net/estore/accessories/Smarthome03" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '智慧型單孔插座_buynow', 'DCSext.WTClick_t', '優惠方案');" target="_blank" class="buynow">Buy Now</a> </div>
                            <div class="item"> <img src="${pageContext.request.contextPath}/img/products/08.jpg" alt="智慧型三孔排插">
                                <h4>智慧型三孔排插</h4>
                                <a href="http://www.fetnet.net/estore/accessories/Smarthome04" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '智慧型三孔排插_buynow', 'DCSext.WTClick_t', '優惠方案');" target="_blank" class="buynow">Buy Now</a> </div>
                            <div class="item"> <img src="${pageContext.request.contextPath}/img/products/05.jpg" alt="全能行動管家遙控器">
                                <h4>全能行動管家遙控器</h4>
                                <a href="http://www.fetnet.net/estore/accessories/Smarthome05" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '全能行動管家遙控器_buynow', 'DCSext.WTClick_t', '優惠方案');" target="_blank" class="buynow">Buy Now</a> </div>
                            <div class="item"> <img src="${pageContext.request.contextPath}/img/products/09.jpg" alt="智慧型寵物餵食機">
                                <h4>智慧型寵物餵食機</h4>
                                <a href="http://www.fetnet.net/estore/accessories/Smarthome06" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '智慧型寵物餵食機_buynow', 'DCSext.WTClick_t', '優惠方案');" target="_blank" class="buynow">Buy Now</a> </div>
                            <div class="item"><img src="${pageContext.request.contextPath}/img/products/10.jpg" alt="智慧型寵物飲水機">
                                <h4>智慧型寵物飲水機</h4>
                                <a href="http://www.fetnet.net/estore/accessories/Smarthome07" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '智慧型寵物飲水機_buynow', 'DCSext.WTClick_t', '優惠方案');" target="_blank" class="buynow">Buy Now</a> </div>
                        </div>
                    </div>
                </div>
            </div>
        </article>


        <article id="apply">
            <div class="coverbg bg02">
                <div class="wrapper apply">
                    <h3 class="pagetitle" id="color06">申請方式</h3>
                    <div class="pure-g shadow">
                        <div class="pure-u-1-2 pure-u-lg-1-3">
                            <div class="applybox apply01"> <img src="${pageContext.request.contextPath}/img/apply01.jpg" alt="攜帶雙證件至遠傳門市辦理"> <span class="nb">1</span>
                                <h4>攜帶雙證件至遠傳門市辦理</h4>
                            </div>
                        </div>
                        <div class="pure-u-1-2 pure-u-lg-1-6">
                            <div class="applybox apply02"><img src="${pageContext.request.contextPath}/img/apply02.jpg" alt="選擇方案"> <span class="nb">2</span>
                                <h4>選擇方案</h4>
                            </div>
                        </div>
                        <div class="pure-u-1-3 pure-u-lg-1-6">
                            <div class="applybox apply03"><img src="${pageContext.request.contextPath}/img/apply03.jpg" alt="申辦完成"> <span class="nb">3</span>
                                <h4>申辦完成</h4>
                            </div>
                        </div>
                        <div class="pure-u-1-3 pure-u-lg-1-6">
                            <div class="applybox apply04"><img src="${pageContext.request.contextPath}/img/apply04.jpg" alt="安排施工"> <span class="nb">4</span>
                                <h4>施工人員3<br>
                                    天內安排施工</h4>
                            </div>
                        </div>
                        <div class="pure-u-1-3 pure-u-lg-1-6">
                            <div class="applybox apply05"><img src="${pageContext.request.contextPath}/img/apply05.jpg" alt="安裝完成啟用服務"> <span class="nb">5</span>
                                <h4>安裝完成啟用服務</h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </article>
        <article id="eservice">
            <div class="coverbg bg01">
                <div class="wrapper">
                    <h3 class="pagetitle" id="color07">客戶服務</h3>
                    <ul class="pagenav">
                        <li><a href="#download" class="gotodiv" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '軟體下載', 'DCSext.WTClick_t', '客戶服務');" id="nav071">軟體下載</a></li>
                    </ul>
                    <div class="qa_tab">
                        <div class="shadow">
                            <ul class="tabs">
                                <li><a href="#tab1">常見問題</a></li>
                                <li><a href="#tab2">簡易障礙排除</a></li>
                            </ul>
                            <div class="tab_container">
                                <div id="tab1" class="tab_content">
                                    <ul class="accordionPart">
                                        <li>
                                            <h4 class="qa_title">什麼是遠傳全能行動管家？ </h4>
                                            <div class="qa_content">「遠傳全能行動管家」提供用戶最聰明的生活、最安心的居家環境 、以及最貼心的照顧，打造智慧家庭全新體驗。用戶只要透過手機APP即可同時滿足安全關懷與智慧控制的需求。</div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">遠傳全能行動管家服務有何特色？</h4>
                                            <div class="qa_content">遠傳全能行動管家有六大特色，是目前市場唯一結合智慧家庭控制主機、網路攝影機、警報器、溫溼偵測器…等多功合一的智慧型主機。智慧主機搭載可水平355度，垂直100度旋轉的鏡頭，用戶可隨時透過本服務APP，觀看不同角度的影像；若偵測到警報事件，鏡頭還能自動旋轉進行拍照。若要為智慧主機新增控制的週邊設備，只要透過本服務APP，簡單掃描設備上的QR Code，即可完成配對。並可透過本服務APP，遠端遙控搭配智慧插座家電，出門也能隨時連線回家開/關電器。獨家的智慧寵物餵食器與活水式飲水機，可隨時隨地遠端餵食，方便飼主貼心寵愛家中寵物。</div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">使用遠傳全能行動管家有什麼限制嗎？</h4>
                                            <div class="qa_content">本服務現階段只提供給遠傳行動電話用戶申請，申請人需要有智慧型手機且家中有頻寬20M以上之WIFI網路 (不得使用智慧手機分享熱點)，即可輕鬆使用遠傳全能行動管家。</div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">申請遠傳全能行動管家服務費如何計算？</h4>
                                            <div class="qa_content">遠傳全能行動管家有『智慧管家』、『終極管家』、『終極管家Plus』等三種方案供用戶選擇。費用依申辦方案不同，最低月費199元起（須簽約三年）。詳見各方案說明。</div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">安裝施工的費用如何計算？</h4>
                                            <div class="qa_content">本服務之標準安裝基本費用為1200元 / 次，偏遠地區需加價400元，如非標準安裝則需依據實際施工狀況收取額外費用(離島暫不供裝)。詳見<a onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '安裝維護費用說明', 'DCSext.WTClick_t', '優惠方案');" class="fancybox" href="#ex-wage">安裝維護費用說明</a>。</div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">設備保固多久?保固期過後設備損壞或人為損壞如何處理？</h4>
                                            <div class="qa_content">用戶繳交月租費使用本服務的期間，遠傳全能行動管家所有設備均提供免費保固服務，但若是人為損壞或用戶已終止服務，須自費進行設備維護及更換(工程師會依不同設備提供報價，取得用戶同意後更換設備)另酌收維護費500元。</div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">加購設備數量是否有限制?</h4>
                                            <div class="qa_content">加購設備數量限制為20台設備。</div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">一個門號可申請幾組遠傳全能行動管家服務?</h4>
                                            <div class="qa_content">一個3G/4G的月租型門號最多可申請3組遠傳全能行動管家。</div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">當有事件發生時，警報傳送方式為何?</h4>
                                            <div class="qa_content">事件發生時，遠傳全能行動管家會拍下即時的現場照片上傳雲端，透過手機簡訊、E-mail及手機APP通知用戶，除了申請人可收到警報外，申請人可另外設定兩組警報門號（限遠傳門號），設定方式可透過本服務網站「用戶專區」或手機APP，非遠傳門號僅能接收E-mail及手機APP通知無法接收簡訊。</div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">警報紀錄保存時間多久？可以透過什麼地方查詢?</h4>
                                            <div class="qa_content">警報紀錄將透過遠傳雲端保存，用戶可透過手機APP與本服務網站「用戶專區」查詢1個月內的警報紀錄。</div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">遠傳全能行動管家影像儲存方式為何?</h4>
                                            <div class="qa_content">為維護用戶隱私，除了警報照片會上傳雲端外，本服務所攝錄的影像主要儲存於網路攝影機的記憶卡當中，支援的記憶卡上限為32G，若記憶卡儲存空間已滿，將會自動覆蓋舊的影像，用戶透過手機APP即可觀看記憶卡內儲存的影像。</div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">遠傳全能行動管家APP支援什麼手機或平版電腦的型號? </h4>
                                            <div class="qa_content">遠傳全能行動管家APP，除 iOS 及 Android 以外之作業系統目前暫不支援。 Apple 廠牌僅支援 iPhone 且必需為 iOS 8.0以上之版本，目前暫不支援 iPad 及  iPad Mini。其他品牌手機則支援使用 Android 4.1.2以上版本之作業系統，且暫不支援平版電腦。 </div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">智慧型寵物餵食機在使用上是否有什麼限制 ?</h4>
                                            <div class="qa_content">智慧型寵物餵食機不具備防水功能設計，僅限於室內使用。
                                                同時，智慧型寵物餵食機適用0.8~1.5cm或1.5~2.0cm顆粒狀乾燥糧食(請依尺寸更換包裝內所附轉盤配件)，請勿使用片狀或濕式糧食，以免造成機器卡食故障。</div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">如何播放記憶卡裡的影片檔?</h4>
                                            <div class="qa_content">為保障遠傳全能行動管家用戶權益及隱私，遠傳全能行動管家提供專屬播放軟體予用戶使用。請至「用戶專區」下載使用。</div>
                                        </li>
                                    </ul>
                                </div>
                                <div id="tab2" class="tab_content">
                                    <ul class="accordionPart">
                                        <li>
                                            <h4 class="qa_title">為什麼登入APP後，有些設備的狀態資訊看不到？</h4>
                                            <div class="qa_content">透過APP可查詢到狀態的設備有攝影機，門窗磁簧感應器及紅外線廣角偵測器三種。在開關插座設定項目可查詢已加入的智慧插座項目。</div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">為什麼登入APP後,攝影機畫面無法上下左右移動？</h4>
                                            <div class="qa_content">有可能是當時手機連線網路速度過於緩慢, APP與攝影機的連線產生延遲或中斷，請退出APP後再重新進入。</div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">可以不要設定APP密碼嗎？</h4>
                                            <div class="qa_content">APP密碼雖可以不需設定，但避免手機在他人手上時有隱私外洩之風險，建議您務必設定APP密碼。</div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">收到權限認證碼簡訊不小心刪掉了怎麼辦？</h4>
                                            <div class="qa_content">需請原申請人重新進行認證程序後取得新的權限認證碼簡訊。 </div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">為什麼我設定家人的手機號碼為警報簡訊接收門號，但是卻收不到簡訊?</h4>
                                            <div class="qa_content">本服務僅限遠傳門號使用，如申請人可收到警報簡訊，請確認家人的手機號碼為遠傳門號，如申請人亦收不到警報簡訊，請聯繫客服人員進行處理。</div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">我已經透過APP打開某個電源插座開關了，但是電源卻沒有正常開啟?</h4>
                                            <div class="qa_content">請先按下遠傳全能行動管家之單孔或三孔排插上的電源按鈕，檢查指示燈是否開啟。
                                                有開啟 : 插座本身功能正常，請關閉APP後再試一次。如仍無法操作，請於APP上將該插座移除後，重新以QR Code掃瞄新增該電源插座後再進行測試，如仍無法操作，請洽遠傳客服進行障礙報修。
                                                未開啟 : 表示插座本身功能異常，請先確認該插座牆壁連接電源是否正常? (如:將該智慧型插座拔掉改插家中其他電器試試)，若確定其他電器設備沒問題，而此該智慧型插座仍異常,請洽遠傳客服進行
                                                障礙報修。
                                            </div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">我把紅外線廣角式偵測器換位置了，要如何更改拍照的定位?</h4>
                                            <div class="qa_content">請至APP [設備設定]>[警報設備設定]選擇您要更換拍照定位的設備名稱，進入點選[設定警報拍照位置]，選定後按儲存即可更新拍照的定位。</div>
                                        </li>
                                        <li>
                                            <h4 class="qa_title">忘記攝影機密碼怎麼辦?</h4>
                                            <div class="qa_content">請長按攝影機後面的Reset鍵約4秒，聽到"嗶"一聲後，密碼即恢復出廠值1234，請再以預設密碼登入APP後再進行修改密碼。</div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </article>
        <div id="company" class="coverbg bg02">
            <div class="wrapper company">
                <h3 class="pagetitle" id="color00">小資顧店好幫手</h3>
                <div class="companybox"><img src="${pageContext.request.contextPath}/img/companyimg.jpg"></div>
            </div>
        </div>
        <div id="download" class="coverbg bg01">
            <div class="wrapper">
                <h3 class="pagetitle" id="color01">軟體下載</h3>
                <div class="downloadbox">
                    <div class="pure-g">
                        <div class="pure-u-1-2 downloadinfo">
                            <h4>Android下載<small>支援Android 4.1.2以上版本</small></h4>
                            <a href="https://play.google.com/store/apps/details?id=net.fetnet.smarthomeapp" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', 'Android', 'DCSext.WTClick_t', '軟體下載');" target="_blank"><img src="${pageContext.request.contextPath}/img/download_android.png" alt="Android下載" class="pure-img"></a> </div>
                        <div class="pure-u-1-2 downloadinfo">
                            <h4>iOS 下載<small>支援iOS 8.0以上版本</small></h4>
                            <a href="https://itunes.apple.com/tw/app/yuan-chuan-quan-neng-xing/id1008613207?l=zh&mt=8" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', 'iOS', 'DCSext.WTClick_t', '軟體下載');" target="_blank"><img src="${pageContext.request.contextPath}/img/download_ios.png" alt="iOS 下載" class="pure-img"></a> </div>
                    </div>
                    <footer class="footer"> <a class="various fancybox.iframe" href="ex.html" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '服務條款及注意事項', 'DCSext.WTClick_t', 'Footer');" >服務條款及注意事項 </a>
                        <div class="otherlink"><a href="http://www.fetnet.net/FETnet/security.html" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '隱私權', 'DCSext.WTClick_t', 'Footer');">隱私權</a> ｜ <a href="http://www.fetnet.net/cs/Satellite/FETnet/FnCopyright" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '著作權條款', 'DCSext.WTClick_t', 'Footer');">著作權條款</a> ｜ <a href="http://www.cpc.ey.gov.tw/" target="_blank" rel="nofollow" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', '行政院消保會', 'DCSext.WTClick_t', 'Footer');">行政院消保會</a></div>
                        <div class="tools"> <a href="javascript:;" onClick="javascript:sendCTRLog('http://www.fetnet.net/cs/Satellite/M_MemberCenter/mMcHome', 'Footer', '會員中心');"  class="btnmenber"><img src="${pageContext.request.contextPath}/img/icon_footer02.jpg" /> 會員中心</a> <a href="javascript:;" onClick="javascript:sendCTRLog('http://www.fetnet.net/mobile/eservice/public/it/n/eServiceController/getEServicePage.action', 'Footer', '用戶服務');" class="btnservice"> <img src="${pageContext.request.contextPath}/img/icon_footer03.jpg" /> 用戶服務</a> </div>
                        <div class="copyright">遠傳電信版權所有 Copyright &copy; </div>
                    </footer>
                </div>
            </div>
        </div>


        <!--============================== content close ==============================-->
        <div class="backtop"><a href="#top" onClick="dcsMultiTrack('DCS.dcsuri', '/smarthome/Click.dat', 'DCSext.WTClick_n', 'TOP', 'DCSext.WTClick_t', 'TOP');">Back to Top</a></div>
        <!--安裝維護費用說明-->
        <div id="ex-wage" style="display: none;">
            <table width="100%" class="pure-table pure-table-bordered producttable">
                <tr>
                    <th></th>
                    <th>安裝維護費用說明</th>
                    <th>項目</th>
                    <th>金額</th>
                </tr>
                <tr>
                    <td rowspan="3">1</td>
                    <td rowspan="3">全能行動管家-安裝費<br />
                        (智慧管家、終極管家、終極管家Plus)</td>
                    <td rowspan="3">標準安裝費<br />
                        (指申辦方案之第一次安裝 含: 壓條、電源線)</td>
                    <td rowspan="3">$1,200</td>
                </tr>
                <tr> </tr>
                <tr> </tr>
                <tr>
                    <td>2</td>
                    <td>牆面铣孔(一式)費用</td>
                    <td>非標準安裝維護費</td>
                    <td>$300</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>電源線延長 (一式) 或 網路線延長 (一式) 費用</td>
                    <td>非標準安裝維護費</td>
                    <td>$300</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>網路線5米或壓條4米</td>
                    <td>非標準安裝維護耗材</td>
                    <td>$100</td>
                </tr>
                <tr>
                    <td>5</td>
                    <td>電源線</td>
                    <td>非標準安裝維護耗材</td>
                    <td>$100</td>
                </tr>
                <tr>
                    <td>6</td>
                    <td>偏遠地區派工加價</td>
                    <td>偏遠地區安裝維護加價</td>
                    <td>$400</td>
                </tr>
                <tr>
                    <td>7</td>
                    <td>人為損壞維修拆裝</td>
                    <td>維護費</td>
                    <td>$500</td>
                </tr>
                <tr>
                    <td>8</td>
                    <td>移機安裝/自費安裝加購配備、二次施工</td>
                    <td>維護費</td>
                    <td>$500</td>
                </tr>
                <tr>
                    <td>9</td>
                    <td>拆機</td>
                    <td>維護費</td>
                    <td>$500</td>
                </tr>
            </table>
        </div>
        <!--方案說明01-->
        <div id="ex-01" style="display: none;">
            <table width="100%" class="pure-table pure-table-bordered producttable">
                <tr>
                    <th>智慧管家方案說明</th>
                </tr>
                <tr>
                    <td><ol>
                            <li>本專案目前僅限遠傳3G／4G門號客戶申請(如因申請人變更或轉換門號為非遠傳門號時，將無法繼續使用本服務，視同申請人退租)。</li>
                            <li>若於合約期間內退租、取消或變更選用之方案者，須依勾選之專案內容繳交專案補貼款。實際應繳之專案補貼款以合約未到期之”日”為單位，按合約總日數比例計算。合約未到期之日數自解約當日起算，計算公式：專案補貼款 x(合約未到期日數／合約總日數)=實際應繳專案補貼款（四捨五入計算至整數）。合約期滿後，本服務仍提供客戶繼續使用。若欲停止此加值服務費率，請致電客服專線申請取消。相關資費及開通下載方式，以遠傳全能行動管家官網<a href="http://smarthome.fetnet.net/" target="_blank">http://smarthome.fetnet.net/</a> 公告為主。</li>
                            <li>本服務之標準安裝基本費用為1200元／次，偏遠地區(離島暫不供裝)需外加施工交通費400元，如非標準安裝則需依據實際施工狀況收取額外費用。<br />
                                <a class="fancybox" href="#ex-wage">安裝維護費用說明</a></li>
                        </ol></td>
                </tr>
                <tr>
                    <td class="producsub">本服務合約期間內，基本設備及所有加購設備均享有保固服務。合約期滿後,如用戶繼續支付服務月租費期間,基本設備及所有加購設備亦享有保固服務。如用戶解約或約滿後用戶停止支付服務月租費，將立即終止保固服務。保固期外如設備損壞維修或保固期內之人為損壞者,將收取維修費用及設備維修等相關費用。</td>
                </tr>
            </table>
        </div>
        <!--方案說明02-->
        <div id="ex-02" style="display: none;">
            <table width="100%" class="pure-table pure-table-bordered producttable">
                <tr>
                    <th>終極管家方案說明</th>
                </tr>
                <tr>
                    <td><ol>
                            <li>本專案目前僅限遠傳3G／4G門號客戶申請(如因申請人變更或轉換門號為非遠傳門號時，將無法繼續使用本服務，視同申請人退租)。</li>
                            <li>若於合約期間內退租、取消或變更選用之方案者，須依勾選之專案內容繳交專案補貼款。實際應繳之專案補貼款以合約未到期之”日”為單位，按合約總日數比例計算。合約未到期之日數自解約當日起算，計算公式：專案補貼款 x(合約未到期日數／合約總日數)=實際應繳專案補貼款（四捨五入計算至整數）。合約期滿後，本服務仍提供客戶繼續使用。若欲停止此加值服務費率，請致電客服專線申請取消。相關資費及開通下載方式，以遠傳全能行動管家官網<a href="http://smarthome.fetnet.net/" target="_blank">http://smarthome.fetnet.net/</a>公告為主。</li>
                            <li>本服務之標準安裝基本費用為1200元／次，偏遠地區(離島暫不供裝)需外加施工交通費400元，如非標準安裝則需依據實際施工狀況收取額外費用。<br />
                                <a class="fancybox" href="#ex-wage">安裝維護費用說明</a></li>
                        </ol></td>
                </tr>
                <tr>
                    <td class="producsub"><p>本服務合約期間內，基本設備及所有加購設備均享有保固服務。合約期滿後,如用戶繼續支付服務月租費期間,基本設備及所有加購設備亦享有保固服務。如用戶解約或約滿後用戶停止支付服務月租費，將立即終止保固服務。保固期外如設備損壞維修或保固期內之人為損壞者,將收取維修費用及設備維修等相關費用。 </p></td>
                </tr>
            </table>
        </div>
        <!--方案說明03-->
        <div id="ex-03" style="display: none;">
            <table width="100%" class="pure-table pure-table-bordered producttable">
                <tr>
                    <th>終極管家Plus方案說明</th>
                </tr>
                <tr>
                    <td><ol>
                            <li>本專案目前僅限遠傳3G／4G門號客戶申請(如因申請人變更或轉換門號為非遠傳門號時，將無法繼續使用本服務，視同申請人退租)。</li>
                            <li>若於合約期間內退租、取消或變更選用之方案者，須依勾選之專案內容繳交專案補貼款。實際應繳之專案補貼款以合約未到期之”日”為單位，按合約總日數比例計算。合約未到期之日數自解約當日起算，計算公式：專案補貼款 x(合約未到期日數／合約總日數)=實際應繳專案補貼款（四捨五入計算至整數）。合約期滿後，本服務仍提供客戶繼續使用。若欲停止此加值服務費率，請致電客服專線申請取消。相關資費及開通下載方式，以遠傳全能行動管家官網<a href="http://smarthome.fetnet.net/" target="_blank">http://smarthome.fetnet.net/</a> 公告為主。</li>
                            <li>本服務之標準安裝基本費用為1200元／次，偏遠地區(離島暫不供裝)需外加施工交通費400元，如非標準安裝則需依據實際施工狀況收取額外費用。<br />
                                <a class="fancybox" href="#ex-wage">安裝維護費用說明</a></li>
                        </ol></td>
                </tr>
                <tr>
                    <td class="producsub"><p>本服務合約期間內，基本設備及所有加購設備均享有保固服務。合約期滿後,如用戶繼續支付服務月租費期間,基本設備及所有加購設備亦享有保固服務。如用戶解約或約滿後用戶停止支付服務月租費，將立即終止保固服務。保固期外如設備損壞維修或保固期內之人為損壞者,將收取維修費用及設備維修等相關費用。 </p></td>
                </tr>
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/js/vendor/jquery-1.11.2.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/owl-carousel/owl.carousel.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/fancyBox/jquery.fancybox.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.nav.js"></script>
        <script src="${pageContext.request.contextPath}/js/wt_mobile3.js"></script>
        <script src="${pageContext.request.contextPath}/js/main.js"></script>

        <script type="text/javascript">
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
        </script>
        <!-- Google Code for 160606 -->
        <!-- Remarketing tags may not be associated with personally identifiable information or placed on pages related to sensitive categories. For instructions on adding this tag and more information on the above requirements, read the setup guide: google.com/ads/remarketingsetup -->
        <script type="text/javascript">
            /* <![CDATA[ */
            var google_conversion_id = 880472723;
            var google_conversion_label = "4EesCL6Mo2cQk-XrowM";
            var google_custom_params = window.google_tag_params;
            var google_remarketing_only = true;
            /* ]]> */
        </script>
        <script type="text/javascript" src="//www.googleadservices.com/pagead/conversion.js">
        </script>
        <noscript>
        <div style="display:inline;">
            <img height="1" width="1" style="border-style:none;" alt="" src="//googleads.g.doubleclick.net/pagead/viewthroughconversion/880472723/?value=1.00&amp;currency_code=TWD&amp;label=4EesCL6Mo2cQk-XrowM&amp;guid=ON&amp;script=0"/>
        </div>
        </noscript>
    </body>
</html>
