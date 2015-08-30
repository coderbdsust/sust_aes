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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Biswajit Debnath
 */
@Entity
@Table(name = "teaches")
@NamedQueries({
		@NamedQuery(name = "Teaches.findAll", query = "SELECT t FROM Teaches t"),
		@NamedQuery(name = "Teaches.findByTeachesId", query = "SELECT t FROM Teaches t WHERE t.teachesId = :teachesId") })
public class Teaches implements DomainObject, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "teaches_id")
	private Integer teachesId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teachesId")
	private List<Test> testList;
	@JoinColumn(name = "instructor_id", referencedColumnName = "instructor_id")
	@ManyToOne(optional = false)
	private Teacher instructorId;
	@JoinColumn(name = "course_id", referencedColumnName = "course_id")
	@ManyToOne(optional = false)
	private Course courseId;

	public Teaches() {
	}

	public Teaches(Integer teachesId) {
		this.teachesId = teachesId;
	}

	public Integer getTeachesId() {
		return teachesId;
	}

	public void setTeachesId(Integer teachesId) {
		this.teachesId = teachesId;
	}

	public List<Test> getTestList() {
		return testList;
	}

	public void setTestList(List<Test> testList) {
		this.testList = testList;
	}

	public Teacher getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Teacher instructorId) {
		this.instructorId = instructorId;
	}

	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (teachesId != null ? teachesId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Teaches)) {
			return false;
		}
		Teaches other = (Teaches) object;
		if ((this.teachesId == null && other.teachesId != null)
				|| (this.teachesId != null && !this.teachesId
						.equals(other.teachesId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Teaches [teachesId=" + teachesId + ", instructorId="
				+ instructorId + ", courseId=" + courseId + "]";
	}

}
