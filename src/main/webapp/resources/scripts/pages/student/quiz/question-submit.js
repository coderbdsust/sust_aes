function submitExam(totalQuestion) {

	//console.log('Answer Wraping');
	var quizRegistrationId = document.getElementById('quizRegistrationId').value;
	var studentQuestionAnswers = {};
	var questionAnswers = [];
	studentQuestionAnswers['quizRegistrationId.quizRegistrationId'] = quizRegistrationId;
	for (var i = 1; i <= totalQuestion; i++) {
		var answerBody;
		var questionType = document.getElementById('fake-root-' + i + '-type').value;
		var questionId = document.getElementById('fake-root-' + i + '-id').value;

		if (questionType == 'MCQ') {
			answerBody = loadMCQanswerBody('questionNo-' + questionId);
		} else if (questionType == 'DESCRIPTIVE') {
			answerBody = loadDESCanswerBody('questionNo-' + questionId);
		} else if (questionType == 'FILL_IN_THE_GAPS') {
			answerBody = loadFIGanswerBody('questionNo-' + questionId);
		}
		studentQuestionAnswers['questionAnswers[' + (i - 1)
				+ '].quizRegistrationId.quizRegistrationId'] = quizRegistrationId;
		studentQuestionAnswers['questionAnswers[' + (i - 1)
				+ '].questionId.questionId'] = questionId;
		studentQuestionAnswers['questionAnswers[' + (i - 1) + '].answerBody'] = answerBody;
	}
	console.log(questionAnswers);

	saveQuestion(studentQuestionAnswers);
	var quizId = document.getElementById('quizId').value;
	showSubmitModal(quizId);
	//console.log('Answer Wraped!');
}

function redirectURL(quizId) {
	var url = '/sustaes/student/quiz/view/' + quizId;
	window.location = url;
}

function showSubmitModal(quizId) {
	$('#ajax').modal('show');
	setTimeout(function() {
		$('#ajax').modal('hide');
		redirectURL(quizId);
	}, 1200);
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
	//console.log(questionLabel + '-desc-answer-text');
	opt["answer"] = document
			.getElementById(questionLabel + '-desc-answer-text').value;
	options.push(opt);
	return JSON.stringify(options);
}

function saveQuestion(studentQuestionAnswers) {
	var url = '/sustaes/student/quiz/answer/save';
//	console.log('STUDENT ANSWERS SUBMITTING REQUEST');

	$.ajax({
		method : "POST",
		url : url,
		data : studentQuestionAnswers
	}).success(function(msg) {
		console.log('SUCCESSFULLY SUBMITTED STUDENT ANSWERS ' + msg);
	}).error(function(msg) {
		console.log('STUDENT ANSWERS SUBMISSION ERROR ' + msg);
	});
}