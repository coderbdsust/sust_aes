function updateQuizReg(quizRegId) {

	var quizRegistration = {};
	quizRegistration['quizRegistrationId'] = quizRegId;
	quizRegistration['courseRegId.courseRegId'] = document
			.getElementById('courseRegId.courseRegId-' + quizRegId).value;
	quizRegistration['quizId.quizId'] = document
			.getElementById('quizId.quizId-' + quizRegId).value;
	quizRegistration['courseRegId.courseRegId'] = document
			.getElementById('courseRegId.courseRegId-' + quizRegId).value;

	quizRegistration['isRegApproved'] = document
			.getElementById('isRegApproved-' + quizRegId).checked == true ? true
			: false;
	quizRegistration['isAttended'] = document.getElementById('isAttended-'
			+ quizRegId).checked == true ? true : false;
	quizRegistration['isExamReviewed'] = document
			.getElementById('isExamReviewed-' + quizRegId).checked == true ? true
			: false;

	var URL = '/sustaes/teacher/quiz/students/api/approve';

	$.ajax({
		method : "POST",
		url : URL,
		data : quizRegistration
	}).success(function(msg) {
		console.log('SUCCESS ' + msg);
		location.reload();

	}).error(function(msg) {
		console.log('ERROR ' + msg);
		location.reload();
	});

}