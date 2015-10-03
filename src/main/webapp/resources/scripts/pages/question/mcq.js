function submitMCQ() {
	var options = [];
	for (var i = 1; i <= 5; i++) {
		var opt = {};
		opt["text"] = document.getElementById('mcq-opt-' + i + '-text').value;
		opt["status"] = document.getElementById('mcq-opt-' + i + '-status').checked == true ? true
				: false;
		options.push(opt);
	}
	
	var question = {};
	question['question_text'] = document.getElementById('mcq-question-text').value;
	question['marks'] = document.getElementById('mcq-marks').value;
	question['time'] = document.getElementById('mcq-time').value;
	question['question_type_id'] = 1;
	question['question_type_name'] = "mcq";
	question['question_body'] = options;

	var data = JSON.stringify(question);
	console.log(data);

}
