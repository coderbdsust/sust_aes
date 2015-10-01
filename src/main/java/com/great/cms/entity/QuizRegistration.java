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
@Table(name = "quiz_registration")
@NamedQueries({
    @NamedQuery(name = "QuizRegistration.findAll", query = "SELECT q FROM QuizRegistration q"),
    @NamedQuery(name = "QuizRegistration.findByQuizRegistrationId", query = "SELECT q FROM QuizRegistration q WHERE q.quizRegistrationId = :quizRegistrationId"),
    @NamedQuery(name = "QuizRegistration.findByAttendTime", query = "SELECT q FROM QuizRegistration q WHERE q.attendTime = :attendTime"),
    @NamedQuery(name = "QuizRegistration.findBySubmitTime", query = "SELECT q FROM QuizRegistration q WHERE q.submitTime = :submitTime"),
    @NamedQuery(name = "QuizRegistration.findByIsRegApproved", query = "SELECT q FROM QuizRegistration q WHERE q.isRegApproved = :isRegApproved"),
    @NamedQuery(name = "QuizRegistration.findByIsAttended", query = "SELECT q FROM QuizRegistration q WHERE q.isAttended = :isAttended"),
    @NamedQuery(name = "QuizRegistration.findByIsExamReviewed", query = "SELECT q FROM QuizRegistration q WHERE q.isExamReviewed = :isExamReviewed")})
public class QuizRegistration implements DomainObject, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "quiz_registration_id")
    private Long quizRegistrationId;
    @Column(name = "attend_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date attendTime;
    @Column(name = "submit_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submitTime;
    @Basic(optional = false)
    @Column(name = "is_reg_approved")
    private boolean isRegApproved;
    @Basic(optional = false)
    @Column(name = "is_attended")
    private boolean isAttended;
    @Basic(optional = false)
    @Column(name = "is_exam_reviewed")
    private boolean isExamReviewed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quizRegistrationId")
    private List<QuestionAnswer> questionAnswerList;
    @JoinColumn(name = "quiz_id", referencedColumnName = "quiz_id")
    @ManyToOne(optional = false)
    private Quiz quizId;
    @JoinColumn(name = "course_reg_id", referencedColumnName = "course_reg_id")
    @ManyToOne(optional = false)
    private CourseRegistration courseRegId;

    public QuizRegistration() {
    }

    public QuizRegistration(Long quizRegistrationId) {
        this.quizRegistrationId = quizRegistrationId;
    }

    public QuizRegistration(Long quizRegistrationId, boolean isRegApproved, boolean isAttended, boolean isExamReviewed) {
        this.quizRegistrationId = quizRegistrationId;
        this.isRegApproved = isRegApproved;
        this.isAttended = isAttended;
        this.isExamReviewed = isExamReviewed;
    }

    public Long getQuizRegistrationId() {
        return quizRegistrationId;
    }

    public void setQuizRegistrationId(Long quizRegistrationId) {
        this.quizRegistrationId = quizRegistrationId;
    }

    public Date getAttendTime() {
        return attendTime;
    }

    public void setAttendTime(Date attendTime) {
        this.attendTime = attendTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public boolean getIsRegApproved() {
        return isRegApproved;
    }

    public void setIsRegApproved(boolean isRegApproved) {
        this.isRegApproved = isRegApproved;
    }

    public boolean getIsAttended() {
        return isAttended;
    }

    public void setIsAttended(boolean isAttended) {
        this.isAttended = isAttended;
    }

    public boolean getIsExamReviewed() {
        return isExamReviewed;
    }

    public void setIsExamReviewed(boolean isExamReviewed) {
        this.isExamReviewed = isExamReviewed;
    }

    public List<QuestionAnswer> getQuestionAnswerList() {
        return questionAnswerList;
    }

    public void setQuestionAnswerList(List<QuestionAnswer> questionAnswerList) {
        this.questionAnswerList = questionAnswerList;
    }

    public Quiz getQuizId() {
        return quizId;
    }

    public void setQuizId(Quiz quizId) {
        this.quizId = quizId;
    }

    public CourseRegistration getCourseRegId() {
        return courseRegId;
    }

    public void setCourseRegId(CourseRegistration courseRegId) {
        this.courseRegId = courseRegId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quizRegistrationId != null ? quizRegistrationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuizRegistration)) {
            return false;
        }
        QuizRegistration other = (QuizRegistration) object;
        if ((this.quizRegistrationId == null && other.quizRegistrationId != null) || (this.quizRegistrationId != null && !this.quizRegistrationId.equals(other.quizRegistrationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.great.cms.entity.QuizRegistration[ quizRegistrationId=" + quizRegistrationId + " ]";
    }
    
}
