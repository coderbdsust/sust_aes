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
					var questionDiv = document
							.getElementById('question-holder');
					var firstElement = true;
					createTab(questionList.length);
					for ( var key in questionList) {
						var question = questionList[key];
						console.log(question['questionId'] + " "
								+ question['questionType']);
						questionDiv
								.appendChild(createQuestionUI(key,
										question['questionId'], question,
										firstElement));
						firstElement = false;
					}
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
		console.log(tab);
		toggle = !toggle;
		tabHolder.innerHTML += tab;
	}
}
function createQuestionUI(key, questionId, question, firstElement) {
	var fakeRootDiv = createDiv('row');
	var number = parseInt(key) + 1;
	fakeRootDiv.id = "fake-root-" + number;

	var rootDiv = createDiv('row');
	rootDiv.id = "questionNo-" + questionId;
	if (!firstElement) {
		fakeRootDiv.style.display = "none";
	}

	var firstChildDiv = createDiv('col-md-offset-3 col-md-6 col-sm-12');

	var secondChildDiv = createDiv('portlet box green');
	secondChildDiv.appendChild(createUIHeader(key, question['questionType']));
	secondChildDiv.appendChild(createUIBody(question));
	firstChildDiv.appendChild(secondChildDiv);
	rootDiv.appendChild(firstChildDiv);
	fakeRootDiv.appendChild(rootDiv);
	return fakeRootDiv;
}

function createUIBody(question) {
	console.log(question);
	var rootDiv = createDiv('portlet-body form');
	var firstChildDiv = createDiv('form-body');//
	var secondChildDiv = createDiv('form-horizontal');
	secondChildDiv.appendChild(questionTextHeader(question['questionText']));
	secondChildDiv.appendChild(questionTextOption(question));
	firstChildDiv.appendChild(secondChildDiv);
	rootDiv.appendChild(firstChildDiv);
	return rootDiv;
}
function questionTextHeader(questionText) {
	var rootDiv = createDiv('row');
	var childDiv = createDiv('col-md-offset-1 col-md-12');
	childDiv.appendChild(createHFourDiv(questionText));
	rootDiv.appendChild(childDiv);
	return rootDiv;
}

function questionTextOption(question) {
	var rootDiv = createDiv('row');

	var quesBody = JSON.parse(question['questionBody']);
	for (var i = 0; i < quesBody.length; i++) {
		if (question['questionType'] == 'MCQ') {
			var childDiv = createDiv('col-md-offset-1 col-md-11');
			var mcqOption = createMCQOption(quesBody[i].text);
			childDiv.appendChild(mcqOption);
			rootDiv.appendChild(childDiv);
			console.log('MCQ');
		} else if (question['questionType'] == 'DESCRIPTIVE') {
			var childDiv = createDiv('col-md-offset-1 col-md-10');
			var mcqOption = createDescField();
			childDiv.appendChild(mcqOption);
			rootDiv.appendChild(childDiv);
			console.log('MCQ');
		}
		console.log('tuman-' + quesBody[i].text);

	}
	return rootDiv;
}
function createMCQOption(optionText) {
	var rootDiv = createDiv('input-group');
	var childDiv = document.createElement('span');
	childDiv.className = 'input-group-addon';
	var checkboxDiv = document.createElement('input');
	checkboxDiv.type = 'checkbox';
	childDiv.appendChild(checkboxDiv);
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
function createDescField() {
	var rootDiv = document.createElement('textarea');
	rootDiv.className = 'form-control';
	rootDiv.style.resize = 'vertical';
	rootDiv.cols = "24";
	rootDiv.rows = "10";
	rootDiv.placeholder = 'Answer the following question';

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
		headerDiv = createHThreeDiv(questionNumber + '.MCQ QUESTION');
	} else if (questionType == 'DESCRIPTIVE') {
		headerDiv = createHThreeDiv(questionNumber + '.DESCRIPTIVE QUESTION ');
	}
	var rootTimerDiv = createDiv('col-md-offset-1 col-md-3');

	var rootTimerInnerDiv = createDiv('caption caption-md');

	var timerDiv = createHThreeDiv('02:00');

	rootHeaderInnerDiv.appendChild(headerDiv);
	rootHeaderDiv.appendChild(rootHeaderInnerDiv);
	firstChildDiv.appendChild(rootHeaderDiv);

	rootTimerInnerDiv.appendChild(timerDiv);
	rootTimerDiv.appendChild(rootTimerInnerDiv);
	firstChildDiv.appendChild(rootTimerDiv);
	rootDiv.appendChild(firstChildDiv);
	return rootDiv;
}

function createDiv(className) {
	var div = document.createElement('div');
	div.className = className;
	return div;
}

function createHThreeDiv(textValue) {
	var headerDiv = document.createElement('h3');
	var strongHeaderDiv = document.createElement('strong');
	var headerText = document.createTextNode(textValue);
	strongHeaderDiv.appendChild(headerText);
	headerDiv.appendChild(strongHeaderDiv);
	return headerDiv;
}

function createHFourDiv(textValue) {
	var headerDiv = document.createElement('h3');
	var strongHeaderDiv = document.createElement('strong');
	var headerText = document.createTextNode(textValue);
	strongHeaderDiv.appendChild(headerText);
	headerDiv.appendChild(strongHeaderDiv);
	return headerDiv;
}