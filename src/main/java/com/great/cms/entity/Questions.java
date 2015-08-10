/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.great.cms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Biswajit Debnath
 */
@Entity
@Table(name = "questions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questions.findAll", query = "SELECT q FROM Questions q"),
    @NamedQuery(name = "Questions.findByQuestionId", query = "SELECT q FROM Questions q WHERE q.questionId = :questionId"),
    @NamedQuery(name = "Questions.findByQuestionText", query = "SELECT q FROM Questions q WHERE q.questionText = :questionText"),
    @NamedQuery(name = "Questions.findByDifficultyLevel", query = "SELECT q FROM Questions q WHERE q.difficultyLevel = :difficultyLevel"),
    @NamedQuery(name = "Questions.findByRequiredTime", query = "SELECT q FROM Questions q WHERE q.requiredTime = :requiredTime"),
    @NamedQuery(name = "Questions.findByQuestionMarks", query = "SELECT q FROM Questions q WHERE q.questionMarks = :questionMarks"),
    @NamedQuery(name = "Questions.findByCreatedTime", query = "SELECT q FROM Questions q WHERE q.createdTime = :createdTime"),
    @NamedQuery(name = "Questions.findByLastUpdated", query = "SELECT q FROM Questions q WHERE q.lastUpdated = :lastUpdated")})
public class Questions implements DomainObject, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "question_id")
    private Long questionId;
    @Basic(optional = false)
    @Column(name = "question_text")
    private String questionText;
    @Basic(optional = false)
    @Column(name = "difficulty_level")
    private int difficultyLevel;
    @Basic(optional = false)
    @Column(name = "required_time")
    @Temporal(TemporalType.TIME)
    private Date requiredTime;
    @Basic(optional = false)
    @Column(name = "question_marks")
    private double questionMarks;
    @Basic(optional = false)
    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @Basic(optional = false)
    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    private List<QuestionDescriptions> questionDescriptionsList;
    @JoinColumn(name = "question_type_id", referencedColumnName = "question_type_id")
    @ManyToOne(optional = false)
    private QuestionType questionTypeId;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @ManyToOne(optional = false)
    private Course courseId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    private List<TestQuestion> testQuestionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    private List<QuestionAnswers> questionAnswersList;

    public Questions() {
    }

    public Questions(Long questionId) {
        this.questionId = questionId;
    }

    public Questions(Long questionId, String questionText, int difficultyLevel, Date requiredTime, double questionMarks, Date createdTime, Date lastUpdated) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.difficultyLevel = difficultyLevel;
        this.requiredTime = requiredTime;
        this.questionMarks = questionMarks;
        this.createdTime = createdTime;
        this.lastUpdated = lastUpdated;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Date getRequiredTime() {
        return requiredTime;
    }

    public void setRequiredTime(Date requiredTime) {
        this.requiredTime = requiredTime;
    }

    public double getQuestionMarks() {
        return questionMarks;
    }

    public void setQuestionMarks(double questionMarks) {
        this.questionMarks = questionMarks;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @XmlTransient
    public List<QuestionDescriptions> getQuestionDescriptionsList() {
        return questionDescriptionsList;
    }

    public void setQuestionDescriptionsList(List<QuestionDescriptions> questionDescriptionsList) {
        this.questionDescriptionsList = questionDescriptionsList;
    }

    public QuestionType getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(QuestionType questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    @XmlTransient
    public List<TestQuestion> getTestQuestionList() {
        return testQuestionList;
    }

    public void setTestQuestionList(List<TestQuestion> testQuestionList) {
        this.testQuestionList = testQuestionList;
    }

    @XmlTransient
    public List<QuestionAnswers> getQuestionAnswersList() {
        return questionAnswersList;
    }

    public void setQuestionAnswersList(List<QuestionAnswers> questionAnswersList) {
        this.questionAnswersList = questionAnswersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionId != null ? questionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questions)) {
            return false;
        }
        Questions other = (Questions) object;
        if ((this.questionId == null && other.questionId != null) || (this.questionId != null && !this.questionId.equals(other.questionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.greatcms.cms.entity.Questions[ questionId=" + questionId + " ]";
    }
    
}
