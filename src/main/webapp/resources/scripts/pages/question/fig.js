function submitFIG() {
	var url = '/sustaes/question/create';
	var options = [];
	var i=0;
	while(true){
		if( document.getElementById('fig-gaps-'+i+'-text') == null) break;
		var opt = {};
		opt["index"] = i;
		opt["answer"] = document.getElementById('fig-gaps-' + i + '-text').value;
		options.push(opt);
		i++;
	}
	
	var question = {};
	question['questionText'] = document.getElementById('fig-question-text').value;
	question['questionMarks'] = document.getElementById('fig-marks').value;
	question['requiredTime'] = document.getElementById('fig-time').value;
	question['courseId.courseId'] = document.getElementById('courseId').value;
	question['questionType'] = "FILL_IN_THE_GAPS";
	question['questionBody'] = JSON.stringify(options);
	//console.log(question);
	

		$.ajax({
		method : "POST",
		url : url,
		data : question
	}).success(

			function(msg) {
				if (msg != null) {
					console.log("Success:" + msg);
					console.log("Question [questionId=" + msg['questionId']
							+ ", questionBody=" + msg['questionBody']);
					$('#success-modal').modal('show');
					appendQuestion(msg);
				} else {
					$('#error-modal').modal('show');
				}
			}).error(function(msg) {
		$('#error-modal').modal('show');
	});
}
