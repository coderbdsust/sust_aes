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
@Table(name = "test")
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t"),
    @NamedQuery(name = "Test.findByTestId", query = "SELECT t FROM Test t WHERE t.testId = :testId"),
    @NamedQuery(name = "Test.findByTestTitle", query = "SELECT t FROM Test t WHERE t.testTitle = :testTitle"),
    @NamedQuery(name = "Test.findByDescription", query = "SELECT t FROM Test t WHERE t.description = :description"),
    @NamedQuery(name = "Test.findByCreateDate", query = "SELECT t FROM Test t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "Test.findByUpdateDate", query = "SELECT t FROM Test t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "Test.findByStartTime", query = "SELECT t FROM Test t WHERE t.startTime = :startTime"),
    @NamedQuery(name = "Test.findByEndTime", query = "SELECT t FROM Test t WHERE t.endTime = :endTime"),
    @NamedQuery(name = "Test.findByIsQuestionTimerOn", query = "SELECT t FROM Test t WHERE t.isQuestionTimerOn = :isQuestionTimerOn")})
public class Test implements DomainObject,Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "test_id")
    private Long testId;
    @Basic(optional = false)
    @Column(name = "test_title")
    private String testTitle;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testId")
    private List<TestQuestion> testQuestionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testId")
    private List<TestRegistration> testRegistrationList;

    public Test() {
    }

    public Test(Long testId) {
        this.testId = testId;
    }

    public Test(Long testId, String testTitle, Date createDate, Date updateDate, boolean isQuestionTimerOn) {
        this.testId = testId;
        this.testTitle = testTitle;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.isQuestionTimerOn = isQuestionTimerOn;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle;
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

    public List<TestQuestion> getTestQuestionList() {
        return testQuestionList;
    }

    public void setTestQuestionList(List<TestQuestion> testQuestionList) {
        this.testQuestionList = testQuestionList;
    }

    public List<TestRegistration> getTestRegistrationList() {
        return testRegistrationList;
    }

    public void setTestRegistrationList(List<TestRegistration> testRegistrationList) {
        this.testRegistrationList = testRegistrationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testId != null ? testId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.testId == null && other.testId != null) || (this.testId != null && !this.testId.equals(other.testId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.great.cms.entity.Test[ testId=" + testId + " ]";
    }
    
}
