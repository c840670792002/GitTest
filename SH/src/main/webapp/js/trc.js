// var count = 0;
var functionCTR = function( anelem,title,title2) {
if( dcsMultiTrack ) {       
if (_tag) {                // with webtrend.js script
          _tag. dcsMultiTrack('DCS.dcsuri','/smarthome/Click.dat','DCSext.WTClick_n', title,'DCSext.WTClick_t',title2);
           } else {                    // with sdc1.js, sdc2.js script
                  dcsMultiTrack('DCS.dcsuri','/smarthome/Click.dat','DCSext.WTClick_n', title,'DCSext.WTClick_t',title2);
                     }
           }
           window['ctrlocation'] = anelem;
           if (_tag) {     // with webtrend.js script
                      _tag.images[_tag.index -1 ].onload = function() { 
                                window.location.href = window['ctrlocation'];    // 圖檔有傳回來，導過去
                     }         
           } else {         // with sdc1.js, sdc2.js script
                     gImages[gIndex-1].onload = function() {
                                window.location.href = window['ctrlocation'];    // 圖檔有傳回來，導過去
                     };
           }  
                     
           // 2011-01-17 end use of timeout feature
           setTimeout(function() {
           window.location.href = anelem;        // 10秒內如果webtrend沒回應，就還是導過去
           }, 3000);
 };