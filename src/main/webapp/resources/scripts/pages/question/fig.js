function submitFIG() {
	var url = '/sustaes/question/create/fig';
	var options = [];
	for (var i = 1; i <= 4; i++) {
		var opt = {};
		opt["text"] = document.getElementById('fig-ans-'+i+'-text').value;
		options.push(opt);
	}
	var question = {};
	question['questionText'] = document.getElementById('fig-question-text').value;
	question['questionMarks'] = document.getElementById('fig-marks').value;
	question['requiredTime'] = document.getElementById('fig-time').value;
	question['courseId.courseId'] = 1;
	question['questionTypeId.questionTypeId'] = 3;
	question['questionTypeId.questionTypeName'] = "fig";
	question['questionBody'] = JSON.stringify(options);

	$.ajax({
		method : "POST",
		url : url,
		data : question
	}).success(function(msg) {
		
	});
}
