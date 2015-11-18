function startTimer(duration, display, totalQuestion,submitted) {
	var start = Date.now(), diff, minutes, seconds;
	function timer() {

		diff = duration - (((Date.now() - start) / 1000) | 0);

		minutes = (diff / 60) | 0;
		seconds = (diff % 60) | 0;
		var timerText;

		if (minutes <= 0 && seconds <= 0 && !submitted) {
			submitExam(totalQuestion);
			submitted=true;
			console.log('submitted');
		}else if (minutes >= 0 && seconds >= 0 && !submitted) {
		minutes = minutes < 10 ? "0" + minutes : minutes;
		seconds = seconds < 10 ? "0" + seconds : seconds;
		timerText = minutes <1 ? " Minute" : " Minutes";

		display.textContent = minutes + ":" + seconds+timerText;
		}

	}
	;
	timer();
	setInterval(timer, 1000);
}