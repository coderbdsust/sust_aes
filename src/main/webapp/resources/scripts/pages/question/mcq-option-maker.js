function handleClick(state, id) {
	$('#uniform-mcq-opt-' + id + '-answer').click(function() {
		if (state) {
			$('span:first', this).attr('class', '');
			state = false;
		} else {
			$('span:first', this).attr('class', 'checked');
			state = true;
		}
		var updateHandleClick = 'handleClick('+state+','+id+')';
		$('#mcq-opt-'+id+'-answer').attr('onclick',updateHandleClick);
	})
}

function addOption(optionNo) {
	var newOptionNo = optionNo + 1;
	var newOptionLabel = "Option " + (newOptionNo + 1);
	var optionDiv = $('<div id="mcq-opt-' + newOptionNo
			+ '" class="form-group">'
			+ '<label class="col-md-3 control-label">' + newOptionLabel
			+ '</label>' + '<div class="row"><div class="col-md-6">'
			+ '<div class="input-group">' + '<input id="mcq-opt-' + newOptionNo
			+ '-text" type="text" class="form-control" />'
			+ ' <span class="input-group-addon">'
			+ '<div class="checker" id="uniform-mcq-opt-' + newOptionNo
			+ '-answer"><span><input id="mcq-opt-' + newOptionNo
			+ '-answer" type="checkbox" onclick="handleClick(false,' + newOptionNo
			+ ')"/>' + '</span></div></span></div></div></div></div>');
	$('#mcq-opt-' + optionNo).after(optionDiv);
	var newAddFunction = 'addOption(' + newOptionNo + ')';
	var newRemoveFunction = 'removeOption(' + newOptionNo + ')';

	$('#addOptionBtn').attr('onclick', newAddFunction);
	$('#removeOptionBtn').attr('onclick', newRemoveFunction);
	// $('#uniform-mcq-opt-'+newOptionNo+'-answer').addClass('checker');
	// console.log('CHECKER CLASS ADDED');
}

function removeOption(optionNo) {
	console.log('option:' + optionNo);
	if (optionNo > 1) {
		$('#mcq-opt-' + optionNo).remove();

		var newOptionNo = optionNo - 1;
		var newAddFunction = 'addOption(' + newOptionNo + ')';
		var newRemoveFunction = 'removeOption(' + newOptionNo + ')';

		$('#addOptionBtn').attr('onclick', newAddFunction);
		$('#removeOptionBtn').attr('onclick', newRemoveFunction);
	}
}
