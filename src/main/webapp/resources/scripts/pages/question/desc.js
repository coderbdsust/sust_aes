function submitDESC() {
	var url = '/sustaes/question/create';

	var options = [];
	var opt = {};
	opt["answer"] = document.getElementById('desc-answer-text').value;
	options.push(opt);

	var question = {};
	question['questionText'] = document.getElementById('desc-question-text').value;
	question['questionMarks'] = document.getElementById('desc-marks').value;
	question['requiredTime'] = document.getElementById('desc-time').value;
	question['courseId.courseId'] = document.getElementById('courseId').value;
	question['questionType'] = "DESCRIPTIVE";
	question['questionBody'] = JSON.stringify(options);
	console.log(question);
	$.ajax({
		method : "POST",
		url : url,
		data : question
	}).success(
			function(msg) {
				console.log("Question [questionId=" + msg['questionId']
						+ ", questionBody=" + msg['questionBody']);
				console.log("Success:" + msg);
				$('#success-modal').modal('show');
			}).error(function(msg) {
		$('#error-modal').modal('show');
	});
}
