/* Common JavaScript */
var $j = jQuery.noConflict();

/**
 * show loading image
 * @param data
 */
function loading(data) {
	if (data == 'start') {
		$j(".loading-screen").show();
		$j(".loading-screen").css({opacity: 0.80});
		$j(".loading-screen").width($j(document).width());
		$j(".loading-screen").height($j(document).height());
		$j(".loading-screen-icon").css('background-size', '100%');
	} else if (data == 'stop') {
		setTimeout(function() {
			$j(".loading-screen").hide();
	    }, 1000);
	} 
}
