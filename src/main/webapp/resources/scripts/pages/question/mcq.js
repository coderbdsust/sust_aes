function submitMCQ() {
	var url = '/sustaes/question/create/mcq';
	var options = [];
	for (var i = 1; i <= 5; i++) {
		var opt = {};
		opt["text"] = document.getElementById('mcq-opt-' + i + '-text').value;
		opt["status"] = document.getElementById('mcq-opt-' + i + '-status').checked == true ? true
				: false;
		options.push(opt);
	}
	var question = {};
	question['questionText'] = document.getElementById('mcq-question-text').value;
	question['questionMarks'] = document.getElementById('mcq-marks').value;
	question['requiredTime'] = document.getElementById('mcq-time').value;
	// question['courseId'] = 1;
	// question['question_type_id'] = 1;
	// question['question_type_name'] = "mcq";
	//question['question_body'] = options;

	var data = JSON.stringify(question);
	// $("#resultsBlock").load(url);
	console.log(question);
	$.post(url, "questionMarks=" + question['questionMarks'] + "&"
			+ "questionText=" + question['questionText'] + "&"
			+ "requiredTime=" + question['requiredTime']);

}
