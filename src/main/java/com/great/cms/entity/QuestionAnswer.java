/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.great.cms.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Biswajit Debnath
 */
@Entity
@Table(name = "question_answer")
@NamedQueries({
    @NamedQuery(name = "QuestionAnswer.findAll", query = "SELECT q FROM QuestionAnswer q"),
    @NamedQuery(name = "QuestionAnswer.findByQuestionAnswersIndexId", query = "SELECT q FROM QuestionAnswer q WHERE q.questionAnswersIndexId = :questionAnswersIndexId"),
    @NamedQuery(name = "QuestionAnswer.findByQuestionOptionId", query = "SELECT q FROM QuestionAnswer q WHERE q.questionOptionId = :questionOptionId"),
    @NamedQuery(name = "QuestionAnswer.findByAnswerText", query = "SELECT q FROM QuestionAnswer q WHERE q.answerText = :answerText"),
    @NamedQuery(name = "QuestionAnswer.findByMarks", query = "SELECT q FROM QuestionAnswer q WHERE q.marks = :marks")})
public class QuestionAnswer implements DomainObject,Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "question_answers_index_id")
    private Long questionAnswersIndexId;
    @Basic(optional = false)
    @Column(name = "question_option_id")
    private int questionOptionId;
    @Basic(optional = false)
    @Column(name = "answer_text")
    private String answerText;
    @Basic(optional = false)
    @Column(name = "marks")
    private double marks;
    @JoinColumn(name = "test_registration_id", referencedColumnName = "test_registration_id")
    @ManyToOne(optional = false)
    private TestRegistration testRegistrationId;
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    @ManyToOne(optional = false)
    private Question questionId;

    public QuestionAnswer() {
    }

    public QuestionAnswer(Long questionAnswersIndexId) {
        this.questionAnswersIndexId = questionAnswersIndexId;
    }

    public QuestionAnswer(Long questionAnswersIndexId, int questionOptionId, String answerText, double marks) {
        this.questionAnswersIndexId = questionAnswersIndexId;
        this.questionOptionId = questionOptionId;
        this.answerText = answerText;
        this.marks = marks;
    }

    public Long getQuestionAnswersIndexId() {
        return questionAnswersIndexId;
    }

    public void setQuestionAnswersIndexId(Long questionAnswersIndexId) {
        this.questionAnswersIndexId = questionAnswersIndexId;
    }

    public int getQuestionOptionId() {
        return questionOptionId;
    }

    public void setQuestionOptionId(int questionOptionId) {
        this.questionOptionId = questionOptionId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public TestRegistration getTestRegistrationId() {
        return testRegistrationId;
    }

    public void setTestRegistrationId(TestRegistration testRegistrationId) {
        this.testRegistrationId = testRegistrationId;
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
        hash += (questionAnswersIndexId != null ? questionAnswersIndexId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionAnswer)) {
            return false;
        }
        QuestionAnswer other = (QuestionAnswer) object;
        if ((this.questionAnswersIndexId == null && other.questionAnswersIndexId != null) || (this.questionAnswersIndexId != null && !this.questionAnswersIndexId.equals(other.questionAnswersIndexId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.great.cms.entity.QuestionAnswer[ questionAnswersIndexId=" + questionAnswersIndexId + " ]";
    }
    
}
