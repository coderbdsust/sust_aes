function addFigField(optionNo) {
	console.log('ADD FIG FIELD:'+optionNo);
	var newFigOption=optionNo+1;
	
	var figDiv = $('<div id="fig-gaps-'+newFigOption+'" class="form-group"><label class="col-md-2 control-label"><strong><em>'+newFigOption+'.</em></strong></label><div class="row"><div class="col-md-8"><div class="input-group"><input id="fig-gaps-'+optionNo+'-text" placeholder="type this answer" type="text"class="form-control" /></div></div></div></div>');
	$('#fig-gaps-'+optionNo).after(figDiv);
	
	var newAddFigField = 'addFigField('+newFigOption+')';
	var newRemoveFigField = 'removeFigField('+newFigOption+')';
	
	$('#addFigFieldBtn').attr('onclick', newAddFigField);
	$('#removeFigFieldBtn').attr('onclick', newRemoveFigField);
}
	
function removeFigField(optionNo) {
	console.log('REMOVE FIG FIELD:' + optionNo);
	if(optionNo>1){
		$('#fig-gaps-'+optionNo).remove();
		
		var newFigOption=optionNo-1;
		var newAddFigField = 'addFigField('+newFigOption+')';
		console.log(newAddFigField);
		var newRemoveFigField = 'removeFigField('+newFigOption+')';
		console.log(newRemoveFigField);
		
		$('#addFigFieldBtn').attr('onclick', newAddFigField);
		$('#removeFigFieldBtn').attr('onclick', newRemoveFigField);
	}
}