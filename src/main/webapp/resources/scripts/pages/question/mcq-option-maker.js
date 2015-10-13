function addOption(optionNo) {
	var newOptionNo = optionNo+1;
	var newOptionLabel = "Option "+(newOptionNo+1);
	var optionDiv = $('<div id="mcq-opt-'+newOptionNo+'" class="form-group"><label class="col-md-3 control-label">'+newOptionLabel+'</label><div class="row"><div class="col-md-6"><div class="input-group"><input id="mcq-opt-'+newOptionNo+'-text" type="text" class="form-control" /> <span class="input-group-addon"> <input id="mcq-opt-'+newOptionNo+'-answer" type="checkbox" /></span></div></div></div></div>');
	$('#mcq-opt-'+optionNo).after(optionDiv);
	var newAddFunction = 'addOption('+newOptionNo+')';
	console.log(newAddFunction);
	var newRemoveFunction = 'removeOption('+newOptionNo+')';
	
	$('#addOptionBtn').attr('onclick', newAddFunction);
	$('#removeOptionBtn').attr('onclick', newRemoveFunction);
}
	
function removeOption(optionNo) {
	console.log('option:' + optionNo);
	if(optionNo>1){
		$('#mcq-opt-'+optionNo).remove();
		
		var newOptionNo=optionNo-1;
		var newAddFunction = 'addOption('+newOptionNo+')';
		var newRemoveFunction = 'removeOption('+newOptionNo+')';
		
		$('#addOptionBtn').attr('onclick', newAddFunction);
		$('#removeOptionBtn').attr('onclick', newRemoveFunction);
	}
}