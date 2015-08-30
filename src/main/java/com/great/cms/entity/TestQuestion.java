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
@Table(name = "test_question")
@NamedQueries({
    @NamedQuery(name = "TestQuestion.findAll", query = "SELECT t FROM TestQuestion t"),
    @NamedQuery(name = "TestQuestion.findByTestQuestionId", query = "SELECT t FROM TestQuestion t WHERE t.testQuestionId = :testQuestionId")})
public class TestQuestion implements DomainObject,Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "test_question_id")
    private Long testQuestionId;
    @JoinColumn(name = "test_id", referencedColumnName = "test_id")
    @ManyToOne(optional = false)
    private Test testId;
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    @ManyToOne(optional = false)
    private Question questionId;

    public TestQuestion() {
    }

    public TestQuestion(Long testQuestionId) {
        this.testQuestionId = testQuestionId;
    }

    public Long getTestQuestionId() {
        return testQuestionId;
    }

    public void setTestQuestionId(Long testQuestionId) {
        this.testQuestionId = testQuestionId;
    }

    public Test getTestId() {
        return testId;
    }

    public void setTestId(Test testId) {
        this.testId = testId;
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
        hash += (testQuestionId != null ? testQuestionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestQuestion)) {
            return false;
        }
        TestQuestion other = (TestQuestion) object;
        if ((this.testQuestionId == null && other.testQuestionId != null) || (this.testQuestionId != null && !this.testQuestionId.equals(other.testQuestionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.great.cms.entity.TestQuestion[ testQuestionId=" + testQuestionId + " ]";
    }
    
}
