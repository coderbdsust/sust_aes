package com.great.cms.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@ContextConfiguration("file:src/main/webapp/WEB-INF/sustaes-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class QuestionAnswerDaoTest {
	
//	@Autowired
//	QuestionAnswerDao qAnsDao;
//	
	@Test
	public void runTest(){
		
//		QuizRegistration quizReg = new QuizRegistration(4L);
//		List<QuestionAnswer> qAnswers = qAnsDao.findAllByQuizRegistrationId(quizReg);
//		System.out.println(qAnswers.size());
////		qAnsDao.deleteAllQuestionAnswerByQuizRegistrationId(quizReg);
////		List<QuestionAnswer> questionAnswers = qAnsDao.findAllQuestionAnswerByQuizRegistrationId(quizReg);
////		System.out.println(questionAnswers.size()==0);
////		System.out.println("Query Excuted!");
//		for(QuestionAnswer q:qAnswers){
//			System.out.println(q.getQuestionAnsId()+" "+q.getAnswerBody());
//		}
//		qAnsDao.deleteAllByQuizRegistration(quizReg);
//		qAnswers = qAnsDao.findAllByQuizRegistrationId(quizReg);
//		System.out.println(qAnswers.size());
		
	}
}
