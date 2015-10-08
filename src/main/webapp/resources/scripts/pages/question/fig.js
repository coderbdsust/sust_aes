function submitFIG() {
	var url = '/sustaes/question/create';
	var options = [];
	for (var i = 0; i < 4; i++) {
		var opt = {};
		opt["index"]=i;
		opt["answer"] = document.getElementById('fig-gaps-'+i+'-text').value;
		options.push(opt);
	}
	var question = {};
	question['questionText'] = document.getElementById('fig-question-text').value;
	question['questionMarks'] = document.getElementById('fig-marks').value;
	question['requiredTime'] = document.getElementById('fig-time').value;
	question['courseId.courseId'] = document.getElementById('courseId').value;
	question['questionType'] = "FILL_IN_THE_GAPS";
	question['questionBody'] = JSON.stringify(options);
	console.log(question);
	$.ajax({
		method : "POST",
		url : url,
		data : question
	}).success(function(msg) {
		console.log("Success:" + msg);
	});
}
