function timeEstimationAfterAssigned(questionId){
	var prevEstimatedTime = document.getElementById('estimated-time').innerHTML;
	var newQuestionTime = document.getElementById('required-time-'+questionId).innerHTML;
	var newEstimatedTime = parseInt(prevEstimatedTime)+parseInt(newQuestionTime);
	document.getElementById('estimated-time').innerHTML=newEstimatedTime;
}

function timeEstimationAfterRemoved(questionId){
	var prevEstimatedTime = document.getElementById('estimated-time').innerHTML;
	var newQuestionTime = document.getElementById('required-time-'+questionId).innerHTML;
	var newEstimatedTime = parseInt(prevEstimatedTime)-parseInt(newQuestionTime);
	document.getElementById('estimated-time').innerHTML=newEstimatedTime;
}