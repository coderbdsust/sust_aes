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
@Table(name = "quiz")
@NamedQueries({
    @NamedQuery(name = "Quiz.findAll", query = "SELECT q FROM Quiz q"),
    @NamedQuery(name = "Quiz.findByQuizId", query = "SELECT q FROM Quiz q WHERE q.quizId = :quizId"),
    @NamedQuery(name = "Quiz.findByQuizTitle", query = "SELECT q FROM Quiz q WHERE q.quizTitle = :quizTitle"),
    @NamedQuery(name = "Quiz.findByDescription", query = "SELECT q FROM Quiz q WHERE q.description = :description"),
    @NamedQuery(name = "Quiz.findByCreateDate", query = "SELECT q FROM Quiz q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "Quiz.findByUpdateDate", query = "SELECT q FROM Quiz q WHERE q.updateDate = :updateDate"),
    @NamedQuery(name = "Quiz.findByStartTime", query = "SELECT q FROM Quiz q WHERE q.startTime = :startTime"),
    @NamedQuery(name = "Quiz.findByEndTime", query = "SELECT q FROM Quiz q WHERE q.endTime = :endTime"),
    @NamedQuery(name = "Quiz.findByIsQuestionTimerOn", query = "SELECT q FROM Quiz q WHERE q.isQuestionTimerOn = :isQuestionTimerOn")})
public class Quiz implements DomainObject, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "quiz_id")
    private Long quizId;
    @Basic(optional = false)
    @Column(name = "quiz_title")
    private String quizTitle;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Basic(optional = false)
    @Column(name = "is_question_timer_on")
    private boolean isQuestionTimerOn;
    @JoinColumn(name = "teaches_id", referencedColumnName = "teaches_id")
    @ManyToOne(optional = false)
    private Teaches teachesId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quizId")
    private List<QuizQuestion> quizQuestionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quizId")
    private List<QuizRegistration> quizRegistrationList;

    public Quiz() {
    }

    public Quiz(Long quizId) {
        this.quizId = quizId;
    }

    public Quiz(Long quizId, String quizTitle, Date createDate, Date updateDate, boolean isQuestionTimerOn) {
        this.quizId = quizId;
        this.quizTitle = quizTitle;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.isQuestionTimerOn = isQuestionTimerOn;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean getIsQuestionTimerOn() {
        return isQuestionTimerOn;
    }

    public void setIsQuestionTimerOn(boolean isQuestionTimerOn) {
        this.isQuestionTimerOn = isQuestionTimerOn;
    }

    public Teaches getTeachesId() {
        return teachesId;
    }

    public void setTeachesId(Teaches teachesId) {
        this.teachesId = teachesId;
    }

    public List<QuizQuestion> getQuizQuestionList() {
        return quizQuestionList;
    }

    public void setQuizQuestionList(List<QuizQuestion> quizQuestionList) {
        this.quizQuestionList = quizQuestionList;
    }

    public List<QuizRegistration> getQuizRegistrationList() {
        return quizRegistrationList;
    }

    public void setQuizRegistrationList(List<QuizRegistration> quizRegistrationList) {
        this.quizRegistrationList = quizRegistrationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quizId != null ? quizId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quiz)) {
            return false;
        }
        Quiz other = (Quiz) object;
        if ((this.quizId == null && other.quizId != null) || (this.quizId != null && !this.quizId.equals(other.quizId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.great.cms.entity.Quiz[ quizId=" + quizId + " ]";
    }
    
}
