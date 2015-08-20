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
@Table(name = "teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findByInstructorId", query = "SELECT t FROM Teacher t WHERE t.instructorId = :instructorId"),
    @NamedQuery(name = "Teacher.findByTeacherName", query = "SELECT t FROM Teacher t WHERE t.teacherName = :teacherName"),
    @NamedQuery(name = "Teacher.findByEmployeeCode", query = "SELECT t FROM Teacher t WHERE t.employeeCode = :employeeCode"),
    @NamedQuery(name = "Teacher.findByIsPermanent", query = "SELECT t FROM Teacher t WHERE t.isPermanent = :isPermanent"),
    @NamedQuery(name = "Teacher.findByEmail", query = "SELECT t FROM Teacher t WHERE t.email = :email"),
    @NamedQuery(name = "Teacher.findByIsAvailable", query = "SELECT t FROM Teacher t WHERE t.isAvailable = :isAvailable")})
public class Teacher implements DomainObject, Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "instructor_id")
    private Long instructorId;
    
    
    @Basic(optional = false)
    @Column(name = "teacher_name")
    private String teacherName;
    @Basic(optional = false)
    @Column(name = "employee_code")
    private String employeeCode;
    @Basic(optional = false)
    @Column(name = "is_permanent")
    private boolean isPermanent;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "is_available")
    private boolean isAvailable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructorId")
    private List<Teaches> teachesList;
    @JoinColumn(name = "desig_id", referencedColumnName = "desig_id")
    @ManyToOne(optional = false)
    private Designation desigId;
    @JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
    @ManyToOne(optional = false)
    private Department deptId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Teacher() {
    }

    public Teacher(Long instructorId) {
        this.instructorId = instructorId;
    }

    public Teacher(Long instructorId, String teacherName, String employeeCode, boolean isPermanent, String email, boolean isAvailable) {
        this.instructorId = instructorId;
        this.teacherName = teacherName;
        this.employeeCode = employeeCode;
        this.isPermanent = isPermanent;
        this.email = email;
        this.isAvailable = isAvailable;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public boolean getIsPermanent() {
        return isPermanent;
    }

    public void setIsPermanent(boolean isPermanent) {
        this.isPermanent = isPermanent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @XmlTransient
    public List<Teaches> getTeachesList() {
        return teachesList;
    }

    public void setTeachesList(List<Teaches> teachesList) {
        this.teachesList = teachesList;
    }

    public Designation getDesigId() {
        return desigId;
    }

    public void setDesigId(Designation desigId) {
        this.desigId = desigId;
    }

    public Department getDeptId() {
        return deptId;
    }

    public void setDeptId(Department deptId) {
        this.deptId = deptId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instructorId != null ? instructorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.instructorId == null && other.instructorId != null) || (this.instructorId != null && !this.instructorId.equals(other.instructorId))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Teacher [instructorId=" + instructorId + ", teacherName="
				+ teacherName + ", employeeCode=" + employeeCode
				+ ", isPermanent=" + isPermanent + ", email=" + email
				+ ", isAvailable=" + isAvailable + ", teachesList="
				+ teachesList + ", desigId=" + desigId + ", deptId=" + deptId
				+ ", userId=" + userId + "]";
	}

    
    
}
