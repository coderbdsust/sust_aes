/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.great.cms.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Biswajit Debnath
 */
@Entity
@Table(name = "course_registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseRegistration.findAll", query = "SELECT c FROM CourseRegistration c"),
    @NamedQuery(name = "CourseRegistration.findByCourseRegId", query = "SELECT c FROM CourseRegistration c WHERE c.courseRegId = :courseRegId"),
    @NamedQuery(name = "CourseRegistration.findByIsApproved", query = "SELECT c FROM CourseRegistration c WHERE c.isApproved = :isApproved"),
    @NamedQuery(name = "CourseRegistration.findByMarks", query = "SELECT c FROM CourseRegistration c WHERE c.marks = :marks"),
    @NamedQuery(name = "CourseRegistration.findByGpa", query = "SELECT c FROM CourseRegistration c WHERE c.gpa = :gpa")})
public class CourseRegistration implements DomainObject, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "course_reg_id")
    private Integer courseRegId;
    @Basic(optional = false)
    @Column(name = "is_approved")
    private boolean isApproved;
    @Basic(optional = false)
    @Column(name = "marks")
    private double marks;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GPA")
    private Double gpa;
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    @ManyToOne(optional = false)
    private Student studentId;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @ManyToOne(optional = false)
    private Course courseId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseRegId")
    private List<TestRegistration> testRegistrationList;

    public CourseRegistration() {
    }

    public CourseRegistration(Integer courseRegId) {
        this.courseRegId = courseRegId;
    }

    public CourseRegistration(Integer courseRegId, boolean isApproved, double marks) {
        this.courseRegId = courseRegId;
        this.isApproved = isApproved;
        this.marks = marks;
    }

    public Integer getCourseRegId() {
        return courseRegId;
    }

    public void setCourseRegId(Integer courseRegId) {
        this.courseRegId = courseRegId;
    }

    public boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    @XmlTransient
    public List<TestRegistration> getTestRegistrationList() {
        return testRegistrationList;
    }

    public void setTestRegistrationList(List<TestRegistration> testRegistrationList) {
        this.testRegistrationList = testRegistrationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseRegId != null ? courseRegId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseRegistration)) {
            return false;
        }
        CourseRegistration other = (CourseRegistration) object;
        if ((this.courseRegId == null && other.courseRegId != null) || (this.courseRegId != null && !this.courseRegId.equals(other.courseRegId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.greatcms.cms.entity.CourseRegistration[ courseRegId=" + courseRegId + " ]";
    }
    
}
