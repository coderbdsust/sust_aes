function submitExam(totalQuestion) {
	// alert('Question id: ' + id);
	var questionList = {};
	console.log('Answer Wraping');
	for (var i = 1; i <= totalQuestion; i++) {
		var questionAnswer = {};
		questionAnswer['quizRegistrationId.quizRegistrationId'] = document
				.getElementById('quizRegistrationId').value;
		var questionType = document.getElementById('fake-root-' + i + '-type').value;
		var questionId = document.getElementById('fake-root-' + i + '-id').value;
		questionAnswer['questionId.questionId']=questionId;
		if (questionType == 'MCQ') {
			console.log(questionType + " " + questionId);
			questionAnswer['answerBody'] = loadMCQanswerBody('questionNo-'
					+ questionId);
		} else if (questionType == 'DESCRIPTIVE') {
			console.log(questionType + " " + questionId);
			questionAnswer['answerBody'] = loadDESCanswerBody('questionNo-'
					+ questionId);
		} else if (questionType == 'FILL_IN_THE_GAPS') {
			console.log(questionType + " " + questionId);
			questionAnswer['answerBody'] = loadFIGanswerBody('questionNo-'
					+ questionId);
		}
		//console.log(questionAnswer);
		saveQuestion(questionAnswer);
	}
	console.log('Answer Wraped!');
}

function loadMCQanswerBody(questionLabel) {
	var options = [];
	var i = 0;
	while (true) {
		if (document.getElementById(questionLabel + '-mcq-opt-' + i + '-text') == null)
			break;
		var opt = {};
		opt["index"] = i;
		opt["text"] = document.getElementById(questionLabel + '-mcq-opt-' + i
				+ '-text').value;
		opt["answer"] = document.getElementById(questionLabel + '-mcq-opt-' + i
				+ '-answer').checked == true ? true : false;
		options.push(opt);
		i++;
	}
	return JSON.stringify(options);
}

function loadFIGanswerBody(questionLabel) {
	var options = [];
	var i = 0;
	while (true) {
		if (document.getElementById(questionLabel + '-fig-gaps-' + i
				+ '-answer') == null)
			break;
		var opt = {};
		opt["index"] = i;
		opt["answer"] = document.getElementById(questionLabel + '-fig-gaps-'
				+ i + '-answer').value;
		options.push(opt);
		i++;
	}
	return JSON.stringify(options);
}

function loadDESCanswerBody(questionLabel) {
	console.log(questionLabel);
	var options = [];
	var opt = {};
	console.log(questionLabel + '-desc-answer-text');
	opt["answer"] = document
			.getElementById(questionLabel + '-desc-answer-text').value;
	options.push(opt);
	return JSON.stringify(options);
}

function saveQuestion(questionAnswer) {
	var url = '/sustaes/student/quiz/answer/save';
	$.ajax({
		method : "POST",
		url : url,
		data : questionAnswer
	}).success(function(msg) {
		console.log('SUCCESS MCQ ' + msg);
	}).error(function(msg) {
		console.log('ERROR MCQ ' + msg);
	});
}