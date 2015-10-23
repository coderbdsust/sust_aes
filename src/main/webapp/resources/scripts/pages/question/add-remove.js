function addQuestions(id) {
		//alert('parent1');
		console.log('SQ: '+id);

		var oldParent = document.getElementById("question-bank");
		var newParent = document.getElementById("quiz-question");
		var hiddenInputNameQuesion="quizQuestions["+id+"].questionId.questionId";
		var hiddenInputNameQuiz="quizQuestions["+id+"].quizId.quizId";
		
		var hiddenInputFieldQuestion= document.getElementById(hiddenInputNameQuesion);
		var hiddenInputFieldQuiz= document.getElementById(hiddenInputNameQuiz);
		//alert('parent2');
		var questionInputField = document.createElement("input");
		questionInputField.setAttribute('id', 'hiddenQuestionInput'+id);
		questionInputField.setAttribute('type', 'hidden');
		questionInputField.setAttribute('name', hiddenInputNameQuesion);
		questionInputField.setAttribute('value', hiddenInputFieldQuestion.textContent);

		var quizInputField = document.createElement("input");
		quizInputField.setAttribute('id', 'hiddenQuizInput'+id);
		quizInputField.setAttribute('type', 'hidden');
		quizInputField.setAttribute('name', hiddenInputNameQuiz);
		quizInputField.setAttribute('value', hiddenInputFieldQuiz.textContent);

		var hiddenQuizQuestionHolder = document.getElementById("hiddenQuizQuestionHolder-"+id); 
		hiddenQuizQuestionHolder.appendChild(questionInputField);
		hiddenQuizQuestionHolder.appendChild(quizInputField);

		var child = document.getElementById("question-" + id);
		console.log("question-" + id);
		$("#add-" + id).hide();
		$("#remove-" + id).show();
		//alert('parent3');
		oldParent.removeChild(child);
		newParent.appendChild(child);
		//alert('parent');
		timeEstimationAfterAssigned(id);
	}
	function removeQuestions(id) {
		//alert('parent1');
		var oldParent = document.getElementById("quiz-question");
		var newParent = document.getElementById("question-bank");
		var hiddenInputFieldQuestion= document.getElementById('hiddenQuestionInput'+id);
		var hiddenInputFieldQuiz= document.getElementById('hiddenQuizInput'+id);
		var hiddenQuizQuestionHolder = document.getElementById("hiddenQuizQuestionHolder-"+id); 
		hiddenQuizQuestionHolder.removeChild(hiddenInputFieldQuiz);
		hiddenQuizQuestionHolder.removeChild(hiddenInputFieldQuestion);

		//alert('parent2');
		var child = document.getElementById("question-" + id);
		$("#remove-" + id).hide();
		$("#add-" + id).show();
		//alert('parent3');
		oldParent.removeChild(child);
		newParent.appendChild(child);
		timeEstimationAfterRemoved(id);
		//alert('parent');
	}