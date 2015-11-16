function submitExam(totalQuestion) {
	// alert('Question id: ' + id);
	var questionList = {};
	console.log('Answer Wraping');
	for(var i=1;i<=totalQuestion;i++){
		var question = {};
		question['quizRegistrationId']=document.getElementById('quizRegistrationId').value;
		var questionType = document.getElementById('fake-root-'+i+'-type').value;
		var questionId = document.getElementById('fake-root-'+i+'-id').value;

		if(questionType=='MCQ'){
			console.log(questionType+" "+questionId);
			question['questionBody']=loadMCQanswerBody(questionId);
		}else if(questionType=='DESCRIPTIVE'){
			console.log(questionType+" "+questionId);
			question['questionBody']=loadDESCanswerBody(questionId);
		}else if(questionType=='FILL_IN_THE_GAPS'){
			console.log(questionType+" "+questionId);
			question['questionBody']=loadFIGanswerBody(questionId);
		}
		console.log(question);
	}
	console.log('Answer Wraped!');
}

function loadMCQanswerBody(questionId){
	var options = [];
	var i = 0;
	while (true) {
		if (document.getElementById(questionId+'-mcq-opt-' + i+'-text') == null)
			break;
		var opt = {};
		opt["index"] = i;
		opt["text"] = document.getElementById(questionId+'-mcq-opt-' + i+'-text').value;
		opt["answer"] = document.getElementById(questionId+'-mcq-opt-' + i+'-answer').checked == true ? true
				: false;
		options.push(opt);
		i++;
	}
	return JSON.stringify(options);
}

function loadFIGanswerBody(questionId){
	var options = [];
	var i = 0;
	while (true) {
		if (document.getElementById(questionId+'-fig-gaps-'+i+'-answer') == null)
			break;
		var opt = {};
		opt["index"] = i;
		opt["answer"] = document.getElementById(questionId+'-fig-gaps-'+i+'-answer').value;
		options.push(opt);
		i++;
	}
	return JSON.stringify(options);
}

function loadDESCanswerBody(questionId){
	console.log(questionId);
	var options = [];
	var opt = {};
	console.log(questionId+'-desc-answer-text');
	opt["answer"] = document.getElementById(questionId+'-desc-answer-text').value;
	options.push(opt);
	return JSON.stringify(options);
}