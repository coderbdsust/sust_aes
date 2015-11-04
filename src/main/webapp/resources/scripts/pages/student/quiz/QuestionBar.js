function nextQuestion(id, totalQuestion) {
	console.log('Question id :' + id);
	$("#questionNo-" + id).hide();
	id = id + 1;
	console.log('NextId :' + id);
	$("#questionNo-" + id).show();

}
function prevQuestion(id, totalQuestion) {
	// alert('Question id: ' + id);
	console.log('Question id :' + id);
	$("#questionNo-" + id).hide();
	id = id - 1;
	console.log('PreviousId :' + id);
	$("#questionNo-" + id).show();

}

function switchQuestion(id) {
	// alert('Question id: ' + id);

	$('div[id^="fake-root-"]').hide();

	console.log('Switch Question ' + id);
	$("#fake-root-" + id).show();
}

function submitExam() {
	// alert('Question id: ' + id);
	console.log('Complete Exam');
}