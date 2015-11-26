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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Biswajit Debnath
 */
@Entity
@Table(name = "department")
public class Department implements DomainObject, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "dept_id")
	private Integer deptId;
	@Basic(optional = false)
	@Column(name = "dept_name")
	private String deptName;
	@Basic(optional = false)
	@Column(name = "dept_code")
	private String deptCode;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "deptId")
	private List<Student> studentList;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "deptId")
	private List<Exam> examList;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "deptId")
	private List<Teacher> teacherList;

	public Department() {
	}

	public Department(Integer deptId) {
		this.deptId = deptId;
	}

	public Department(String deptName, String deptCode) {

		this.deptName = deptName;
		this.deptCode = deptCode;
	}

	public Department(Integer deptId, String deptName, String deptCode) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptCode = deptCode;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<Exam> getExamList() {
		return examList;
	}

	public void setExamList(List<Exam> examList) {
		this.examList = examList;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (deptId != null ? deptId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Department)) {
			return false;
		}
		Department other = (Department) object;
		if ((this.deptId == null && other.deptId != null)
				|| (this.deptId != null && !this.deptId.equals(other.deptId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.great.cms.entity.Department[ deptId=" + deptId + " ]";
	}

}
