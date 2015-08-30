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
@Table(name = "question_description")
@NamedQueries({
    @NamedQuery(name = "QuestionDescription.findAll", query = "SELECT q FROM QuestionDescription q"),
    @NamedQuery(name = "QuestionDescription.findByQuestionsIndexId", query = "SELECT q FROM QuestionDescription q WHERE q.questionsIndexId = :questionsIndexId"),
    @NamedQuery(name = "QuestionDescription.findByQuestionOptionId", query = "SELECT q FROM QuestionDescription q WHERE q.questionOptionId = :questionOptionId"),
    @NamedQuery(name = "QuestionDescription.findByOptionText", query = "SELECT q FROM QuestionDescription q WHERE q.optionText = :optionText"),
    @NamedQuery(name = "QuestionDescription.findByCorrectText", query = "SELECT q FROM QuestionDescription q WHERE q.correctText = :correctText"),
    @NamedQuery(name = "QuestionDescription.findByMarks", query = "SELECT q FROM QuestionDescription q WHERE q.marks = :marks")})
public class QuestionDescription implements DomainObject,Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "questions_index_id")
    private Long questionsIndexId;
    @Basic(optional = false)
    @Column(name = "question_option_id")
    private int questionOptionId;
    @Basic(optional = false)
    @Column(name = "option_text")
    private String optionText;
    @Basic(optional = false)
    @Column(name = "correct_text")
    private String correctText;
    @Basic(optional = false)
    @Column(name = "marks")
    private double marks;
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    @ManyToOne(optional = false)
    private Question questionId;

    public QuestionDescription() {
    }

    public QuestionDescription(Long questionsIndexId) {
        this.questionsIndexId = questionsIndexId;
    }

    public QuestionDescription(Long questionsIndexId, int questionOptionId, String optionText, String correctText, double marks) {
        this.questionsIndexId = questionsIndexId;
        this.questionOptionId = questionOptionId;
        this.optionText = optionText;
        this.correctText = correctText;
        this.marks = marks;
    }

    public Long getQuestionsIndexId() {
        return questionsIndexId;
    }

    public void setQuestionsIndexId(Long questionsIndexId) {
        this.questionsIndexId = questionsIndexId;
    }

    public int getQuestionOptionId() {
        return questionOptionId;
    }

    public void setQuestionOptionId(int questionOptionId) {
        this.questionOptionId = questionOptionId;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public String getCorrectText() {
        return correctText;
    }

    public void setCorrectText(String correctText) {
        this.correctText = correctText;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
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
        hash += (questionsIndexId != null ? questionsIndexId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionDescription)) {
            return false;
        }
        QuestionDescription other = (QuestionDescription) object;
        if ((this.questionsIndexId == null && other.questionsIndexId != null) || (this.questionsIndexId != null && !this.questionsIndexId.equals(other.questionsIndexId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.great.cms.entity.QuestionDescription[ questionsIndexId=" + questionsIndexId + " ]";
    }
    
}
