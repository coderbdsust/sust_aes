function appendQuestion(data) {
	
	var questionId = data['questionId'];
	var questionText = data['questionText'];
	var requiredTime = data['requiredTime'];
	var questionType = data['questionType'];
	var type='';
	if(questionType=='MCQ')
		type='[M]';
	else if(questionType=='DESCRIPTIVE')
		type='[D]';
	else
		type='[F]';
	
	// console.log(questionId+' '+questionText);
	var totalQuestion= document.getElementById("hiddenTotalQuestion").textContent;
	var quizId= document.getElementById("hiddenQuizId").textContent;
	var inputField="<ul id=\"hiddenQuizQuestionHolder-"+questionId+"\"> " +
	"<li style=\"display: none;\"" +
	"id=\"quizQuestions["+(questionId)+"].questionId.questionId\" " +
	">"+questionId+"</li>" +
	"<li style=\"display: none;\" " +
	"id=\"quizQuestions["+(questionId)+"].quizId.quizId\"" +
	">"+quizId+"</li>" +
	"</ul>";
	var item = $('<li id="question-'+questionId+'" style="background: rgba(223, 240, 216, 0.70);  margin-bottom: 2px;"><span style="display: none;" id="required-time-'+questionId+'">'+requiredTime+'</span>	<div class="task-checkbox"><p style="padding-left:5px; color:green;">'+type+'</p></div> <div class="task-title"> <span class="task-title-sp">'+questionText+' </span>'+inputField+'</div><div class="task-config"><div class="task-config-btn btn-group"><a class="btn btn-xs default" data-toggle="dropdown" data-hover="dropdown" data-close-others="true"> <i class="fa fa-cog"></i><i class="fa fa-angle-down"></i></a><ul class="dropdown-menu pull-right"><li id="add-'+questionId+'"><a id="addButton0" name="addButton'+questionId+'" type="button" onclick="addQuestions('+questionId+')"> <i class="fa fa-plus"></i> Add</a></li><li style="display: none;" id="remove-'+questionId+'"><a id="removeButton'+questionId+'" name="removeButton'+questionId+'" type="button" onclick="removeQuestions('+questionId+')"> <i class="fa fa-times"></i> Remove</a></li><li><a> <i class="fa fa-info"></i> Details</a></li></ul></div></div></li>');
	$('#question-bank').append(item);
	document.getElementById("totalQuestion").textContent=(++totalQuestion);
	
}