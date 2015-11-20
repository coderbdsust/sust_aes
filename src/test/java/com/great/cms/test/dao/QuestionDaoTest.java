package com.great.cms.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration("file:src/main/webapp/WEB-INF/sustaes-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class QuestionDaoTest {

//	@Autowired
//	QuestionDao questionDao;

	@Test
	public void runTest() {
		// Course course = new Course();
		// course.setCourseId(1);
		//
		// Question q = new Question();
		// q.setQuestionText("What are you doing?");
		// q.setDifficultyLevel(1);
		// q.setQuestionMarks(5.0);
		// q.setRequiredTime(50);
		// q.setQuestionBody("");
		// q.setCourseId(course);
		// q.setQuestionType(QuestionType.MCQ);
		// System.out.println(q);
		// questionDao.save(q);
		// Question question = questionDao.findByCreatedTimeAndCourseId(
		// q.getCreatedTime(), q.getCourseId());
		// assertNotNull(question);
		// System.out.println(question.getQuestionId());

		// Quiz quiz = new Quiz(7L);
		// List<Question> questions = questionDao.findAvailableQuestions(quiz);
		// System.out.println("Total Available Questions: " + questions.size());
		// if(!questions.isEmpty()){
		// for(Question q:questions){
		// System.out.println(q.getQuestionId());
		// }
		// }

//		Quiz quiz = new Quiz(7L);
//		List<Question> questions = questionDao.findAssignedQuestions(quiz);
//		System.out.println("Total Assigned Questions: " + questions.size());
//		if (!questions.isEmpty()) {
//			for (Question q : questions) {
//				System.out.println(q.getQuestionId());
//			}
//		}
		
//		List<Question> question = questionDao.findAll();
//		for(Question q:question){
//			System.out.println(q);
//		}
//		Question q = questionDao.findById(1L);
//		System.out.println(q);
	}
}
