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
@Table(name = "test_registration")
@NamedQueries({
    @NamedQuery(name = "TestRegistration.findAll", query = "SELECT t FROM TestRegistration t"),
    @NamedQuery(name = "TestRegistration.findByTestRegistrationId", query = "SELECT t FROM TestRegistration t WHERE t.testRegistrationId = :testRegistrationId"),
    @NamedQuery(name = "TestRegistration.findByAttendTime", query = "SELECT t FROM TestRegistration t WHERE t.attendTime = :attendTime"),
    @NamedQuery(name = "TestRegistration.findBySubmitTime", query = "SELECT t FROM TestRegistration t WHERE t.submitTime = :submitTime"),
    @NamedQuery(name = "TestRegistration.findByIsRegApproved", query = "SELECT t FROM TestRegistration t WHERE t.isRegApproved = :isRegApproved"),
    @NamedQuery(name = "TestRegistration.findByIsAttended", query = "SELECT t FROM TestRegistration t WHERE t.isAttended = :isAttended"),
    @NamedQuery(name = "TestRegistration.findByIsExamReviewed", query = "SELECT t FROM TestRegistration t WHERE t.isExamReviewed = :isExamReviewed")})
public class TestRegistration implements DomainObject,Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "test_registration_id")
    private Long testRegistrationId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testRegistrationId")
    private List<QuestionAnswer> questionAnswerList;
    @JoinColumn(name = "test_id", referencedColumnName = "test_id")
    @ManyToOne(optional = false)
    private Test testId;
    @JoinColumn(name = "course_reg_id", referencedColumnName = "course_reg_id")
    @ManyToOne(optional = false)
    private CourseRegistration courseRegId;

    public TestRegistration() {
    }

    public TestRegistration(Long testRegistrationId) {
        this.testRegistrationId = testRegistrationId;
    }

    public TestRegistration(Long testRegistrationId, boolean isRegApproved, boolean isAttended, boolean isExamReviewed) {
        this.testRegistrationId = testRegistrationId;
        this.isRegApproved = isRegApproved;
        this.isAttended = isAttended;
        this.isExamReviewed = isExamReviewed;
    }

    public Long getTestRegistrationId() {
        return testRegistrationId;
    }

    public void setTestRegistrationId(Long testRegistrationId) {
        this.testRegistrationId = testRegistrationId;
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

    public Test getTestId() {
        return testId;
    }

    public void setTestId(Test testId) {
        this.testId = testId;
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
        hash += (testRegistrationId != null ? testRegistrationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestRegistration)) {
            return false;
        }
        TestRegistration other = (TestRegistration) object;
        if ((this.testRegistrationId == null && other.testRegistrationId != null) || (this.testRegistrationId != null && !this.testRegistrationId.equals(other.testRegistrationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.great.cms.entity.TestRegistration[ testRegistrationId=" + testRegistrationId + " ]";
    }
    
}
