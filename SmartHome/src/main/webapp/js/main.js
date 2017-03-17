$(function(){
	$('#nav').onePageNav({
				scrollSpeed: 400,
				filter: ':not(.external)',
	});

	// 快速捲動
	  $('a.gotodiv').on('click', function(event) {
		var $anchor = $(this);
		$('html, body').stop().animate({
			scrollTop: $($anchor.attr('href')).offset().top-42
		}, 400, 'easeInOutExpo');
		return false;
	  });


	// 預設顯示第一個 Tab
		var _showTab = 0;
		var $defaultLi = $('ul.tabs li').eq(_showTab).addClass('active');
		$($defaultLi.find('a').attr('href')).siblings().hide();

		// 當 li 頁籤被點擊時...
		// 若要改成滑鼠移到 li 頁籤就切換時, 把 click 改成 mouseover
		$('ul.tabs li').click(function() {
			// 找出 li 中的超連結 href(#id)
			var $this = $(this),
				_clickTab = $this.find('a').attr('href');
			// 把目前點擊到的 li 頁籤加上 .active
			// 並把兄弟元素中有 .active 的都移除 class
			$this.addClass('active').siblings('.active').removeClass('active');
			// 淡入相對應的內容並隱藏兄弟元素
			$(_clickTab).stop(false, true).fadeIn().siblings().hide();

			return false;
		}).find('a').focus(function(){
			this.blur();
		});

	// 幫 div.qa_title 加上 hover 及 click 事件
		// 同時把兄弟元素 div.qa_content 隱藏起來
		$('.accordionPart li h4.qa_title').hover(function(){
			$(this).addClass('qa_title_on');
		}, function(){
			$(this).removeClass('qa_title_on');
		}).click(function(){
			// 當點到標題時，若答案是隱藏時則顯示它；反之則隱藏
			$(this).next('div.qa_content').slideToggle();
		}).siblings('div.qa_content').hide();

		$('.accordionPart li div.qa_content:first').show();

	// 輪播
		var first_time = 0;
		var picName = '';
		var carouselItem = 0;
		$("#function").owlCarousel({
		lazyLoad : true,
		navigation : true, // Show next and prev buttons
		slideSpeed : 300,
		paginationSpeed : 400,
		singleItem:true,
		afterAction: function() {
			switch (this.owl.currentItem) {
				case 0:
					picName = '一';
					first_time++;
					break;
				case 1:
					picName = '二';
					first_time++;
					break;
				case 2:
					picName = '三';
					first_time++;
					break;
				case 3:
					picName = '四';
					first_time++;
					break;
				case 4:
					picName = '五';
					first_time++;
					break;
				case 5:
					picName = '六';
					first_time++;
					break;
				default:
					break;
			}
			carouselItem = this.owl.currentItem + 1;
			if (first_time >= 2) {
				dcsMultiTrack('DCS.dcsuri','/smarthome/#feature_img' + (this.owl.currentItem + 1), 'DCSext.WTClick_n','服務功能_圖' + picName, 'DCSext.WTClick_t','服務功能');
			}
		}
		});

	  $("#program").owlCarousel({
		navigation:true,
		items : 3,
		itemsDesktopSmall : [1024,3],
		itemsTablet: [768,2],
		itemsMobile : [568,1],
	  });

	  $("#fitting").owlCarousel({
		  navigation:true,
		  items : 5, //10 items above 1000px browser width
		  itemsDesktopSmall : [1024,4],
		  itemsTablet: [768,3],
		  itemsMobile : [568,2],
	  });


	  $("#product").owlCarousel({
		navigation:true,
		items : 3,
		itemsDesktopSmall : [1024,3],
		itemsTablet: [768,2],
		itemsMobile : [568,1],
	  });

	 // lightbox

	  $(".fancybox").fancybox({
		maxWidth	: 800,
		maxHeight	: 600,
		width		: '95%',
		height		: '80%',
		openEffect	: 'none',
		closeEffect	: 'none'
	});

	  $(".various").fancybox({
		maxWidth	: 800,
		maxHeight	: 380,
		fitToView	: false,
		width		: '95%',
		height		: '80%',
		autoSize	: false,
		closeClick	: false,
		openEffect	: 'none',
		closeEffect	: 'none'
	});

		$(".variousinfo").fancybox({
		maxWidth	: 400,
		maxHeight	: 600,
		fitToView	: false,
		width		: '95%',
		height		: '80%',
		autoSize	: false,
		closeClick	: false,
		openEffect	: 'none',
		closeEffect	: 'none'
	});

	var scrollPart = '';
	$(window).scroll(function () {
		if ($(this).scrollTop() <= 0) {
			dcsMultiTrack('DCS.dcsuri','/smarthome/#home', 'DCSext.WTClick_n','Home', 'DCSext.WTClick_t','首頁');
		} else if ($(this).scrollTop() > 200) {
			$('.backtop').fadeIn();
		} else {
			$('.backtop').fadeOut();
		}
		// var bodyScroll = $('window').scrollTop();
		var bodyScroll = (document.documentElement && document.documentElement.scrollTop) ||
              document.body.scrollTop;
		var finalSecScrollTop = $('body').height() - $(window).height() - 50;
		// console.log('test: ' + bodyScroll);
		if ((bodyScroll >= 0) && (bodyScroll < 638)) {
			if (scrollPart !== 'home') {
				dcsMultiTrack('DCS.dcsuri','/smarthome/#home','WT.ti','smarthome首頁','DCSext.WTClick_n','Home', 'DCSext.WTClick_t','首頁');
				scrollPart = 'home';
			}
		} else if ((bodyScroll >= 638) && (bodyScroll < 1188)) {
			if (scrollPart !== 'cf') {
				dcsMultiTrack('DCS.dcsuri','/smarthome/#cf','WT.ti','smarthome情境體驗', 'DCSext.WTClick_n','情境體驗', 'DCSext.WTClick_t','情境體驗');
				scrollPart = 'cf';
			}
		} else if ((bodyScroll >= 1188) && (bodyScroll < 1773)) {
			if (scrollPart !== 'feature') {
				dcsMultiTrack('DCS.dcsuri','/smarthome/#feature','WT.ti','smarthome服務功能', 'DCSext.WTClick_n','服務功能', 'DCSext.WTClick_t','服務功能');
				scrollPart = 'feature';
				dcsMultiTrack('DCS.dcsuri','/smarthome/#feature_img' + (carouselItem), 'DCSext.WTClick_n','服務功能_圖' + picName, 'DCSext.WTClick_t','服務功能');
			}
		} else if ((bodyScroll >= 1773) && (bodyScroll < 2404)) {
			if (scrollPart !== 'feature_6') {
				dcsMultiTrack('DCS.dcsuri','/smarthome/#feature_6','WT.ti','smarthome服務特色', 'DCSext.WTClick_n','服務特色', 'DCSext.WTClick_t','服務特色');
				scrollPart = 'feature_6';
			}
		} else if ((bodyScroll >= 2404) && (bodyScroll < 3103)) {
			if (scrollPart !== 'instructions') {
				dcsMultiTrack('DCS.dcsuri','/smarthome/#instructions','WT.ti','smarthome操作說明', 'DCSext.WTClick_n','操作說明', 'DCSext.WTClick_t','操作說明');
				scrollPart = 'instructions';
			}
		} else if ((bodyScroll >= 3103) && (bodyScroll < 3693)) {
			if (scrollPart !== 'device_home') {
				dcsMultiTrack('DCS.dcsuri','/smarthome/#device_home','WT.ti','smarthome設備介紹', 'DCSext.WTClick_n','設備介紹', 'DCSext.WTClick_t','設備介紹');
				scrollPart = 'device_home';
			}
		} else if ((bodyScroll >= 3693) && (bodyScroll < 4562)) {
			if (scrollPart !== 'promotion') {
				dcsMultiTrack('DCS.dcsuri','/smarthome/#promotion','WT.ti','smarthome優惠方案', 'DCSext.WTClick_n','優惠方案', 'DCSext.WTClick_t','優惠方案');
				scrollPart = 'promotion';
			}
		} else if ((bodyScroll >= 4562) && (bodyScroll < 4946)) {
			if (scrollPart !== 'buy') {
				dcsMultiTrack('DCS.dcsuri','/smarthome/#promotion_1','WT.ti','smarthome選購配件', 'DCSext.WTClick_n','選購配件', 'DCSext.WTClick_t','優惠方案');
				scrollPart = 'buy';
			}
		} else if ((bodyScroll >= 4946) && (bodyScroll < 5286)) {
			if (scrollPart !== 'apply') {
				dcsMultiTrack('DCS.dcsuri','/smarthome/#apply','WT.ti','smarthome申請方式', 'DCSext.WTClick_n','申請方式', 'DCSext.WTClick_t','申請方式');
				scrollPart = 'apply';
			}
		} else if ((bodyScroll >= 5286) && (bodyScroll < 6438)) {
			if (scrollPart !== 'eservice') {
				dcsMultiTrack('DCS.dcsuri','/smarthome/#eservice','WT.ti','smarthome客戶服務', 'DCSext.WTClick_n','客戶服務', 'DCSext.WTClick_t','客戶服務');
				scrollPart = 'eservice';
			}
		} else if ((bodyScroll >= 6438) && (bodyScroll < 7115)) {
			if (scrollPart !== 'company') {
				dcsMultiTrack('DCS.dcsuri','/smarthome/#company','WT.ti','smarthome企業用戶', 'DCSext.WTClick_n','企業用戶', 'DCSext.WTClick_t','企業用戶');
				scrollPart = 'company';
			}
		} else if ((bodyScroll >= 7115) && (bodyScroll < finalSecScrollTop)) {
			if (scrollPart !== 'download') {
				dcsMultiTrack('DCS.dcsuri','/smarthome/#download','WT.ti','smarthome軟體下載', 'DCSext.WTClick_n','軟體下載', 'DCSext.WTClick_t','軟體下載');
				scrollPart = 'download';
			}
		}
	});
	$('.backtop').click(function () {
		$('body,html').animate({
			scrollTop: 0
		}, 400);
		return false;
	});



});