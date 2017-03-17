function sendCTRLog(anelem,arg1,arg2){
	dcsMultiTrack('DCS.dcsuri','/smarthome/Click.dat','DCSext.WTClick_t',arg1,'DCSext.WTClick_n',arg2);
	waitCTR(anelem);
}


function waitCTR(arg){
	var timeId=setTimeout(function() {
		window.location.href = arg;        
	}, 3000);
	gImages[gIndex-1].onload = function() {
		clearTimeout(timeId);
		window.location.href = arg;			
	};		
}
    
function waitCTRBlank(){
	var timeId=setTimeout(function() {
		return true;       
	}, 5000);
	gImages[gIndex-1].onload = function() {
		clearTimeout(timeId);
		return true;
	};	
}