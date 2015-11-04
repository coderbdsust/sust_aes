function isQuestionUpdationReady(){
	if($('#quizRegInputHeader').is(':visible')){
	   loadQuizQuestion(); 
	 } else {
	    setTimeout(isQuestionUpdationReady, 10); 
	 }
	
}

function loadQuizQuestion() {
	console.log('LOAD QUIZ QUESTION INSTANTIATED');
	var data={};
	data['quizRegId'] = document.getElementById("quizRegistrationId").value;
	console.log('QUIZ REG ID: ' + data['quizRegId']);
	var questionList="";
	var requestURL = '/sustaes/student/quiz/question/list';

	$.ajax({
		method : "POST",
		url : requestURL,
		data:data
	}).success(function(msg) {
		console.log('SUCCESS IN QUESTION LOADING');
		if (msg != null) {
			questionList = msg;
			for(var key in questionList){
				var question = questionList[key];
			}
		} else {
			console.log('LIST IS NULL');
		}
	}).error(function(msg) {
		console.log('QUESTION LOADING ERROR!');
	});
	
	
}