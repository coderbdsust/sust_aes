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

/**
 *
 * @author Biswajit Debnath
 */
@Entity
@Table(name = "question")
@NamedQueries({
		@NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
		@NamedQuery(name = "Question.findByQuestionId", query = "SELECT q FROM Question q WHERE q.questionId = :questionId"),
		@NamedQuery(name = "Question.findByQuestionText", query = "SELECT q FROM Question q WHERE q.questionText = :questionText"),
		@NamedQuery(name = "Question.findByDifficultyLevel", query = "SELECT q FROM Question q WHERE q.difficultyLevel = :difficultyLevel"),
		@NamedQuery(name = "Question.findByRequiredTime", query = "SELECT q FROM Question q WHERE q.requiredTime = :requiredTime"),
		@NamedQuery(name = "Question.findByQuestionMarks", query = "SELECT q FROM Question q WHERE q.questionMarks = :questionMarks"),
		@NamedQuery(name = "Question.findByCreatedTime", query = "SELECT q FROM Question q WHERE q.createdTime = :createdTime"),
		@NamedQuery(name = "Question.findByLastUpdated", query = "SELECT q FROM Question q WHERE q.lastUpdated = :lastUpdated") })
public class Question implements DomainObject, Serializable {
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
    private long requiredTime;
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
    @JoinColumn(name = "question_type_id", referencedColumnName = "question_type_id")
    @ManyToOne(optional = false)
    private QuestionType questionTypeId;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @ManyToOne(optional = false)
    private Course courseId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    private List<QuestionAnswer> questionAnswerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    private List<QuizQuestion> quizQuestionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    private List<QuestionDescription> questionDescriptionList;

    public Question() {
    }

    public Question(Long questionId) {
        this.questionId = questionId;
    }

    public Question(Long questionId, String questionText, int difficultyLevel, long requiredTime, double questionMarks, Date createdTime, Date lastUpdated) {
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

    public long getRequiredTime() {
        return requiredTime;
    }

    public void setRequiredTime(long requiredTime) {
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

    public List<QuestionAnswer> getQuestionAnswerList() {
        return questionAnswerList;
    }

    public void setQuestionAnswerList(List<QuestionAnswer> questionAnswerList) {
        this.questionAnswerList = questionAnswerList;
    }

    public List<QuizQuestion> getQuizQuestionList() {
        return quizQuestionList;
    }

    public void setQuizQuestionList(List<QuizQuestion> quizQuestionList) {
        this.quizQuestionList = quizQuestionList;
    }

    public List<QuestionDescription> getQuestionDescriptionList() {
        return questionDescriptionList;
    }

    public void setQuestionDescriptionList(List<QuestionDescription> questionDescriptionList) {
        this.questionDescriptionList = questionDescriptionList;
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
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.questionId == null && other.questionId != null) || (this.questionId != null && !this.questionId.equals(other.questionId))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText="
				+ questionText + ", difficultyLevel=" + difficultyLevel
				+ ", requiredTime=" + requiredTime + ", questionMarks="
				+ questionMarks + ", createdTime=" + createdTime
				+ ", lastUpdated=" + lastUpdated + ", questionTypeId="
				+ questionTypeId + ", courseId=" + courseId+"]";
	}

    

}
