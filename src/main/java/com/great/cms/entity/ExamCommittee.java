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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "exam_committee")
@NamedQueries({
    @NamedQuery(name = "ExamCommittee.findAll", query = "SELECT e FROM ExamCommittee e"),
    @NamedQuery(name = "ExamCommittee.findByExamCommitteeId", query = "SELECT e FROM ExamCommittee e WHERE e.examCommitteeId = :examCommitteeId"),
    @NamedQuery(name = "ExamCommittee.findBySession", query = "SELECT e FROM ExamCommittee e WHERE e.session = :session"),
    @NamedQuery(name = "ExamCommittee.findBySemester", query = "SELECT e FROM ExamCommittee e WHERE e.semester = :semester"),
    @NamedQuery(name = "ExamCommittee.findByChairmanId", query = "SELECT e FROM ExamCommittee e WHERE e.chairmanId = :chairmanId"),
    @NamedQuery(name = "ExamCommittee.findByStartDate", query = "SELECT e FROM ExamCommittee e WHERE e.startDate = :startDate"),
    @NamedQuery(name = "ExamCommittee.findByEndDate", query = "SELECT e FROM ExamCommittee e WHERE e.endDate = :endDate")})
public class ExamCommittee implements DomainObject, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "exam_committee_id")
    private Integer examCommitteeId;
    @Basic(optional = false)
    @Column(name = "session")
    private int session;
    @Basic(optional = false)
    @Column(name = "semester")
    private int semester;
    @Basic(optional = false)
    @Column(name = "chairman_id")
    private int chairmanId;
    @Basic(optional = false)
    @Column(name = "start_date")
    private String startDate;
    @Basic(optional = false)
    @Column(name = "end_date")
    private String endDate;
    @JoinColumn(name = "exam_id", referencedColumnName = "exam_id")
    @ManyToOne(optional = false)
    private Exam examId;

    public ExamCommittee() {
    }

    public ExamCommittee(Integer examCommitteeId) {
        this.examCommitteeId = examCommitteeId;
    }

    public ExamCommittee(Integer examCommitteeId, int session, int semester, int chairmanId, String startDate, String endDate) {
        this.examCommitteeId = examCommitteeId;
        this.session = session;
        this.semester = semester;
        this.chairmanId = chairmanId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getExamCommitteeId() {
        return examCommitteeId;
    }

    public void setExamCommitteeId(Integer examCommitteeId) {
        this.examCommitteeId = examCommitteeId;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getChairmanId() {
        return chairmanId;
    }

    public void setChairmanId(int chairmanId) {
        this.chairmanId = chairmanId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Exam getExamId() {
        return examId;
    }

    public void setExamId(Exam examId) {
        this.examId = examId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examCommitteeId != null ? examCommitteeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamCommittee)) {
            return false;
        }
        ExamCommittee other = (ExamCommittee) object;
        if ((this.examCommitteeId == null && other.examCommitteeId != null) || (this.examCommitteeId != null && !this.examCommitteeId.equals(other.examCommitteeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.great.cms.entity.ExamCommittee[ examCommitteeId=" + examCommitteeId + " ]";
    }
    
}
