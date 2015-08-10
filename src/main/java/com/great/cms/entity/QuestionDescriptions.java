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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Biswajit Debnath
 */
@Entity
@Table(name = "question_descriptions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestionDescriptions.findAll", query = "SELECT q FROM QuestionDescriptions q"),
    @NamedQuery(name = "QuestionDescriptions.findByQuestionsIndexId", query = "SELECT q FROM QuestionDescriptions q WHERE q.questionsIndexId = :questionsIndexId"),
    @NamedQuery(name = "QuestionDescriptions.findByQuestionOptionId", query = "SELECT q FROM QuestionDescriptions q WHERE q.questionOptionId = :questionOptionId"),
    @NamedQuery(name = "QuestionDescriptions.findByOptionText", query = "SELECT q FROM QuestionDescriptions q WHERE q.optionText = :optionText"),
    @NamedQuery(name = "QuestionDescriptions.findByCorrectText", query = "SELECT q FROM QuestionDescriptions q WHERE q.correctText = :correctText"),
    @NamedQuery(name = "QuestionDescriptions.findByMarks", query = "SELECT q FROM QuestionDescriptions q WHERE q.marks = :marks")})
public class QuestionDescriptions implements DomainObject, Serializable {
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
    private Questions questionId;

    public QuestionDescriptions() {
    }

    public QuestionDescriptions(Long questionsIndexId) {
        this.questionsIndexId = questionsIndexId;
    }

    public QuestionDescriptions(Long questionsIndexId, int questionOptionId, String optionText, String correctText, double marks) {
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

    public Questions getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Questions questionId) {
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
        if (!(object instanceof QuestionDescriptions)) {
            return false;
        }
        QuestionDescriptions other = (QuestionDescriptions) object;
        if ((this.questionsIndexId == null && other.questionsIndexId != null) || (this.questionsIndexId != null && !this.questionsIndexId.equals(other.questionsIndexId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.greatcms.cms.entity.QuestionDescriptions[ questionsIndexId=" + questionsIndexId + " ]";
    }
    
}
