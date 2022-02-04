package com.great.cms.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Biswajit Debnath
 */
@Entity
@Table(name = "question_answer")
public class QuestionAnswer implements DomainObject, Serializable {
	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "question_ans_id")
	    private Long questionAnsId;
	    @Column(name = "ans_reviewed")
	    private Boolean ansReviewed=false;
	    @Basic(optional = false)
	    @Column(name = "answer_body")
	    private String answerBody;
	    @Basic(optional = false)
	    @Column(name = "marks")
	    private double marks;
	    @JoinColumn(name = "quiz_registration_id", referencedColumnName = "quiz_registration_id")
	    @ManyToOne(optional = false)
	    private QuizRegistration quizRegistrationId;
	    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
	    @ManyToOne(optional = false)
	    private Question questionId;

	    public QuestionAnswer() {
	    }

	    public QuestionAnswer(Long questionAnsId) {
	        this.questionAnsId = questionAnsId;
	    }

	    public QuestionAnswer(Long questionAnsId, String answerBody, double marks) {
	        this.questionAnsId = questionAnsId;
	        this.answerBody = answerBody;
	        this.marks = marks;
	    }

	    public Long getQuestionAnsId() {
	        return questionAnsId;
	    }

	    public void setQuestionAnsId(Long questionAnsId) {
	        this.questionAnsId = questionAnsId;
	    }

	    public Boolean getAnsReviewed() {
	        return ansReviewed;
	    }

	    public void setAnsReviewed(Boolean ansReviewed) {
	        this.ansReviewed = ansReviewed;
	    }

	    public String getAnswerBody() {
	        return answerBody;
	    }

	    public void setAnswerBody(String answerBody) {
	        this.answerBody = answerBody;
	    }

	    public double getMarks() {
	        return marks;
	    }

	    public void setMarks(double marks) {
	        this.marks = marks;
	    }

	    public QuizRegistration getQuizRegistrationId() {
	        return quizRegistrationId;
	    }

	    public void setQuizRegistrationId(QuizRegistration quizRegistrationId) {
	        this.quizRegistrationId = quizRegistrationId;
	    }

	    public Question getQuestionId() {
	        return questionId;
	    }

	    public void setQuestionId(Question questionId) {
	        this.questionId = questionId;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (questionAnsId != null ? questionAnsId.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof QuestionAnswer)) {
	            return false;
	        }
	        QuestionAnswer other = (QuestionAnswer) object;
	        if ((this.questionAnsId == null && other.questionAnsId != null) || (this.questionAnsId != null && !this.questionAnsId.equals(other.questionAnsId))) {
	            return false;
	        }
	        return true;
	    }

	   

		@Override
		public String toString() {
			return "QuestionAnswer [questionAnsId=" + questionAnsId
					+ ", answerBody=" + answerBody + ", marks=" + marks
					+ ", quizRegistrationId=" + quizRegistrationId
					+ ", questionId=" + questionId + "]";
		}

	    
    
}
