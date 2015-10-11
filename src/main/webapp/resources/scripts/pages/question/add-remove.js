function addQuestions(id) {
		//alert('parent1');
		console.log('SQ: '+id);
		var oldParent = document.getElementById("question-bank");
		var newParent = document.getElementById("quiz-question");
		//alert('parent2');
		var child = document.getElementById("question-" + id);
		console.log("question-" + id);
		$("#add-" + id).hide();
		$("#remove-" + id).show();
		//alert('parent3');
		oldParent.removeChild(child);
		newParent.appendChild(child);
		//alert('parent');
	}
	function removeQuestions(id) {
		//alert('parent1');
		var oldParent = document.getElementById("quiz-question");
		var newParent = document.getElementById("question-bank");
		//alert('parent2');
		var child = document.getElementById("question-" + id);
		$("#remove-" + id).hide();
		$("#add-" + id).show();
		//alert('parent3');
		oldParent.removeChild(child);
		newParent.appendChild(child);
		//alert('parent');
	}