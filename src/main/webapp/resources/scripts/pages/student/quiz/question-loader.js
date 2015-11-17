function isQuestionUpdationReady() {
	if ($('#quizRegInputHeader').is(':visible')) {
		loadQuizQuestion();
	} else {
		setTimeout(isQuestionUpdationReady, 10);
	}

}

function loadQuizQuestion() {
	console.log('LOAD QUIZ QUESTION INSTANTIATED');
	var data = {};
	data['quizRegId'] = document.getElementById("quizRegistrationId").value;
	console.log('QUIZ REG ID: ' + data['quizRegId']);
	var questionList = "";
	var requestURL = '/sustaes/student/quiz/question/list';

	$.ajax({
		method : "POST",
		url : requestURL,
		data : data
	}).success(
			function(msg) {
				console.log('SUCCESS IN QUESTION LOADING');
				if (msg != null) {
					questionList = msg;
					console.log(msg);
					var questionDiv = document
							.getElementById('question-holder');
					var firstElement = true;
					createTab(questionList.length);
					var time=$('#quizTimer').val();;
					var totalQuestion = msg.length;
					for ( var key in questionList) {
						var question = questionList[key];
				//		console.log(question['questionId'] + " "
							//	+ question['questionType']);
						questionDiv.appendChild(createQuestionUI(key,
								question['questionId'], question, firstElement,
								questionList.length));
						firstElement = false;						
					}
					var fiveMinutes = 60 * parseInt(questionList['requiredTime']),
			        display = document.querySelector('#time');
					startTimer(time, display,totalQuestion);
				} else {
					console.log('LIST IS NULL');
				}
			}).error(function(msg) {
		console.log('QUESTION LOADING ERROR!');
	});
}
function createTab(tabNumber) {
	var tabHolder = document.getElementById('question-change-tab-holder');

	var toggle = true;
	for (var i = 1; i <= tabNumber; i++) {
		var className;
		if (toggle) {
			className = 'btn green';
		} else {
			className = 'btn grey-cascade';
		}
		var tab = '<a class="' + className + '" onclick="switchQuestion(' + i
				+ ')"> ' + i + ' </a>';
		//console.log(tab);
		toggle = !toggle;
		tabHolder.innerHTML += tab;
	}
}
function createQuestionUI(key, questionId, question, firstElement,
		totalQuestion) {
	var fakeRootDiv = createDiv('row');
	var number = parseInt(key) + 1;
	fakeRootDiv.id = "fake-root-" + number;

	var rootDiv = createDiv('row');
	rootDiv.id = questionId;
	if (!firstElement) {
		fakeRootDiv.style.display = "none";
	}

	var firstChildDiv = createDiv('col-md-offset-3 col-md-6 col-sm-12');

	var secondChildDiv = createDiv('portlet box green');
	
	var questionTypeInputTracker = document.createElement('input');
	questionTypeInputTracker.type="hidden";
	questionTypeInputTracker.setAttribute("id","fake-root-"+number+"-type");
	questionTypeInputTracker.value=question['questionType'];
	
	var questionIdInputTracker = document.createElement('input');
	questionIdInputTracker.type="hidden";
	questionIdInputTracker.setAttribute("id","fake-root-"+number+"-id");
	questionIdInputTracker.value=questionId;
	
	
	secondChildDiv.appendChild(createUIHeader(key, question['questionType']));
	secondChildDiv.appendChild(createUIBody(question, key, totalQuestion));
	firstChildDiv.appendChild(secondChildDiv);
	rootDiv.appendChild(firstChildDiv);
	fakeRootDiv.appendChild(questionIdInputTracker);
	fakeRootDiv.appendChild(questionTypeInputTracker);
	fakeRootDiv.appendChild(rootDiv);
	return fakeRootDiv;
}

function createUIBody(question, key, totalQuestion) {
	//console.log(question);
	var rootDiv = createDiv('portlet-body form');
	var firstChildDiv = createDiv('form-body');
	var secondChildDiv = createDiv('form-horizontal');
	secondChildDiv.appendChild(questionTextHeader(question['questionText']));
	secondChildDiv.appendChild(questionTextOption(question));
	firstChildDiv.appendChild(secondChildDiv);
	rootDiv.appendChild(firstChildDiv);
	rootDiv.appendChild(nextButton(key, totalQuestion));
	return rootDiv;
}

function nextButton(key, totalQuestion) {
	var intKey = parseInt(key) + 1;
	var rootDiv = createDiv('form-actions');
	var firstChildDiv = createDiv('row');
	var secondChildDiv = createDiv('col-md-3');
	var headerDiv = createHeaderDivWithStyle(intKey + '/' + totalQuestion,
			'h4', "0em 0em 0em 1em", 'pull-left');
	secondChildDiv.appendChild(headerDiv);
	var thirdChildDiv = createDiv('col-md-offset-4 col-md-5');
	firstChildDiv.appendChild(secondChildDiv);

	if (intKey != 1) {
		thirdChildDiv.innerHTML += '<button type="button" class="btn green" onclick="prevQuestion('
				+ (intKey) + ',' + totalQuestion + ')">Previous</button>';
		firstChildDiv.appendChild(thirdChildDiv);
	}
	if (intKey != totalQuestion) {
		thirdChildDiv.innerHTML += '<button type="button" class="btn green" onclick="nextQuestion('
				+ (intKey) + ',' + totalQuestion + ')">Next</button>';
		firstChildDiv.appendChild(thirdChildDiv);
	} else {
		thirdChildDiv.innerHTML += '<button type="button" class="btn green" onclick="submitExam('+totalQuestion+')">Submit</button>';
		firstChildDiv.appendChild(thirdChildDiv);
	}

	rootDiv.appendChild(firstChildDiv);
	return rootDiv;

}

function questionTextHeader(questionText) {
	var rootDiv = createDiv('row');
	var childDiv = createDiv('col-md-offset-1 col-md-12');
	childDiv.appendChild(createHeaderDiv(questionText, 'h4'));
	rootDiv.appendChild(childDiv);
	return rootDiv;
}

function questionTextOption(question) {
	var rootDiv = createDiv('row');
	var quesBody = JSON.parse(question['questionBody']);
	//console.log(question['questionType']+' '+ question['questionId']);
	for (var i = 0; i < quesBody.length; i++) {
		if (question['questionType'] == 'MCQ') {
			var childDiv = createDiv('col-md-offset-1 col-md-11');
//			var mcqOption = createMCQOption(quesBody[i].text);
			var mcqOption = createMCQOption(quesBody[i].text,quesBody[i].index,question['questionId']);
			childDiv.appendChild(mcqOption);
			rootDiv.appendChild(childDiv);
		//	console.log('MCQ');
		} else if (question['questionType'] == 'DESCRIPTIVE') {
			var childDiv = createDiv('col-md-offset-1 col-md-10');
		//	var descOption = createDescField();
			var descOption = createDescField(question['questionId']);
			childDiv.appendChild(descOption);
			rootDiv.appendChild(childDiv);
		//	console.log('DESCRIPTION');
		} else if (question['questionType'] == 'FILL_IN_THE_GAPS') {
			var childDiv = createDiv('col-md-offset-1 col-md-11');
		//	var figOption = createFIGField(i);
			var figOption = createFIGField(i,quesBody[i].index,question['questionId']);
			childDiv.appendChild(figOption);
			rootDiv.appendChild(childDiv);
			//console.log('DESCRIPTION');
		}
	//	console.log('tuman-' + quesBody[i].text);
	}
	return rootDiv;
}
//function createMCQOption(optionText) {
//	var rootDiv = createDiv('input-group');
//	var childDiv = document.createElement('span');
//	childDiv.className = 'input-group-addon';
//	var checkboxDiv = document.createElement('input');
//	checkboxDiv.type = 'checkbox';
//	childDiv.appendChild(checkboxDiv);
//	rootDiv.appendChild(childDiv);
//	var checkboxTextDiv = document.createElement('h4');
//	checkboxTextDiv.style.padding = '1em 1em';
//	var text = document.createTextNode(optionText);
//	checkboxTextDiv.appendChild(text);
//	rootDiv.appendChild(checkboxTextDiv);
//
//	return rootDiv;
//}
function createMCQOption(optionText,index,questionId) {
//	console.log(optionText+" "+index+" "+questionId);
	var rootDiv = createDiv('input-group');
	var childDiv = document.createElement('span');
	childDiv.className = 'input-group-addon';
	
	
//	var checkerDiv = document.createElement('div');
//	checkerDiv.className='checker';
//	checkerDiv.setAttribute('id',"uniform-questionNo-"+questionId+"-mcq-opt-"+index+"-answer");

//	var spanChecker = document.createElement('span');
	
	var checkboxInput = document.createElement('input');
	checkboxInput.setAttribute("id","questionNo-"+questionId+"-mcq-opt-"+index+"-answer");
	checkboxInput.type = 'checkbox';
	
//	spanChecker.appendChild(checkboxInput);
//	checkerDiv.appendChild(spanChecker);
//	console.log(checkerDiv);
	
	var inputOption = document.createElement('input');
	inputOption.setAttribute("id","questionNo-"+questionId+"-mcq-opt-"+index+"-text");
	inputOption.type = 'hidden';
	
	inputOption.value = optionText;
	childDiv.appendChild(checkboxInput);
	//childDiv.appendChild(checkerDiv);
	childDiv.appendChild(inputOption);
	rootDiv.appendChild(childDiv);
	var checkboxTextDiv = document.createElement('h4');
	checkboxTextDiv.style.padding = '1em 1em';
	var text = document.createTextNode(optionText);
	checkboxTextDiv.appendChild(text);
	rootDiv.appendChild(checkboxTextDiv);

	return rootDiv;
}
// <textarea style="resize: vertical;"
// class="form-control" rows="10" cols="24"
// placeholder="Answer the following question"></textarea>

//function createDescField() {
//	var rootDiv = document.createElement('textarea');
//
//	rootDiv.className = 'form-control';
//	rootDiv.style.resize = 'vertical';
//	rootDiv.cols = "24";
//	rootDiv.rows = "10";
//	rootDiv.placeholder = 'Answer the following question';
//
//	return rootDiv;
//}
function createDescField(questionId) {
	var rootDiv = document.createElement('textarea');
	rootDiv.setAttribute("id","questionNo-"+questionId+"-desc-answer-text");
	rootDiv.className = 'form-control';
	rootDiv.style.resize = 'vertical';
	rootDiv.cols = "24";
	rootDiv.rows = "10";
	rootDiv.placeholder = 'Answer the following question';

	return rootDiv;
}

//function createFIGField(key) {
//	var rootDiv = createDiv('form-group');
//	var intKey = parseInt(key) + 1;
//	var labelDiv = createLabelDiv(' ' + intKey + '. ');
//	var firstChildDiv = createDiv('row');
//	var secondChildDiv = createDiv('col-md-8');
//	var thirdChildDiv = createDiv('input-group');
//	thirdChildDiv.innerHTML = '<input placeholder="type this answer" type="text" class="form-control" />';
//
//	secondChildDiv.appendChild(thirdChildDiv);
//	firstChildDiv.appendChild(secondChildDiv);
//
//	rootDiv.appendChild(labelDiv);
//	rootDiv.appendChild(firstChildDiv);
//	return rootDiv;
//}

function createFIGField(key, index, questionId) {
	var rootDiv = createDiv('form-group');
	var intKey = parseInt(key) + 1;
	var labelDiv = createLabelDiv(' ' + intKey + '. ');
	var firstChildDiv = createDiv('row');
	var secondChildDiv = createDiv('col-md-8');
	var thirdChildDiv = createDiv('input-group');
	thirdChildDiv.innerHTML = '<input placeholder="type this answer" id="questionNo-'+questionId+'-fig-gaps-'+index+'-answer" type="text" class="form-control" />';

	secondChildDiv.appendChild(thirdChildDiv);
	firstChildDiv.appendChild(secondChildDiv);

	rootDiv.appendChild(labelDiv);
	rootDiv.appendChild(firstChildDiv);
	return rootDiv;
}

function createUIHeader(key, questionType) {

	var rootDiv = createDiv('portlet-title');

	var firstChildDiv = createDiv('row');

	var rootHeaderDiv = createDiv('col-md-8');

	var rootHeaderInnerDiv = createDiv('caption caption-md');

	var questionNumber = parseInt(key) + 1;
	var headerDiv;
	if (questionType == 'MCQ') {
		headerDiv = createHeaderDiv(questionNumber + '.MCQ QUESTION', 'h3');
	} else if (questionType == 'DESCRIPTIVE') {
		headerDiv = createHeaderDiv(questionNumber + '.DESCRIPTIVE QUESTION ',
				'h3');
	} else if (questionType == 'FILL_IN_THE_GAPS') {
		headerDiv = createHeaderDiv(questionNumber
				+ '.FILL IN THE GAPS QUESTION', 'h3');
	}


	rootHeaderInnerDiv.appendChild(headerDiv);
	rootHeaderDiv.appendChild(rootHeaderInnerDiv);
	firstChildDiv.appendChild(rootHeaderDiv);

//	var rootTimerDiv = createDiv('col-md-offset-1 col-md-3');
//
//	var rootTimerInnerDiv = createDiv('caption caption-md');
//
//	var timerDiv = createHeaderDiv('02:00', 'h3');
//	rootTimerInnerDiv.appendChild(timerDiv);
//	rootTimerDiv.appendChild(rootTimerInnerDiv);
//	firstChildDiv.appendChild(rootTimerDiv);
	rootDiv.appendChild(firstChildDiv);
	return rootDiv;
}

function createDiv(className) {
	var div = document.createElement('div');
	div.className = className;
	return div;
}

function createHeaderDiv(textValue, headerType) {
	var headerDiv = document.createElement(headerType);
	var strongHeaderDiv = document.createElement('strong');
	var headerText = document.createTextNode(textValue);
	strongHeaderDiv.appendChild(headerText);
	headerDiv.appendChild(strongHeaderDiv);
	return headerDiv;
}

function createLabelDiv(textValue) {
	var headerDiv = document.createElement('label');
	var strongHeaderDiv = document.createElement('strong');
	var emDiv = document.createElement('em');
	var headerText = document.createTextNode(textValue);
	emDiv.appendChild(headerText);
	strongHeaderDiv.appendChild(emDiv);
	headerDiv.appendChild(strongHeaderDiv);
	return headerDiv;
}

function createHeaderDivWithStyle(textValue, headerType, padding, className) {
	var headerDiv = document.createElement(headerType);
	headerDiv.style.padding = padding;
	headerDiv.className = className;
	var strongHeaderDiv = document.createElement('strong');
	var headerText = document.createTextNode(textValue);
	strongHeaderDiv.appendChild(headerText);
	headerDiv.appendChild(strongHeaderDiv);
	return headerDiv;
}