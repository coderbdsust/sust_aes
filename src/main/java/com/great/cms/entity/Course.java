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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Biswajit Debnath
 */
@Entity
@Table(name = "course")
public class Course implements DomainObject, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "course_id")
	private Integer courseId;
	@Basic(optional = false)
	@Column(name = "course_code")
	private String courseCode;
	@Basic(optional = false)
	@Column(name = "course_title")
	private String courseTitle;
	@Basic(optional = false)
	@Column(name = "credit")
	private double credit;
	@Basic(optional = false)
	@Column(name = "semester")
	private int semester;
	@Basic(optional = false)
	@Column(name = "session")
	private int session;
	@Basic(optional = false)
	@Column(name = "offering_dept")
	private String offeringDept;
	@Basic(optional = false)
	@Column(name = "accepting_dept")
	private String acceptingDept;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
	private List<CourseRegistration> courseRegistrationList;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
	private List<Teaches> teachesList;

	public Course() {
	}

	public Course(Integer courseId) {
		this.courseId = courseId;
	}

	public Course(Integer courseId, String courseCode, String courseTitle, double credit, int semester, int session,
			String offeringDept, String acceptingDept) {
		this.courseId = courseId;
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.credit = credit;
		this.semester = semester;
		this.session = session;
		this.offeringDept = offeringDept;
		this.acceptingDept = acceptingDept;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		this.session = session;
	}

	public String getOfferingDept() {
		return offeringDept;
	}

	public void setOfferingDept(String offeringDept) {
		this.offeringDept = offeringDept;
	}

	public String getAcceptingDept() {
		return acceptingDept;
	}

	public void setAcceptingDept(String acceptingDept) {
		this.acceptingDept = acceptingDept;
	}

	public List<CourseRegistration> getCourseRegistrationList() {
		return courseRegistrationList;
	}

	public void setCourseRegistrationList(List<CourseRegistration> courseRegistrationList) {
		this.courseRegistrationList = courseRegistrationList;
	}

	public List<Teaches> getTeachesList() {
		return teachesList;
	}

	public void setTeachesList(List<Teaches> teachesList) {
		this.teachesList = teachesList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (courseId != null ? courseId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Course)) {
			return false;
		}
		Course other = (Course) object;
		if ((this.courseId == null && other.courseId != null)
				|| (this.courseId != null && !this.courseId.equals(other.courseId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseCode=" + courseCode + ", courseTitle=" + courseTitle
				+ ", credit=" + credit + ", semester=" + semester + ", session=" + session + ", offeringDept="
				+ offeringDept + ", acceptingDept=" + acceptingDept + "]";
	}

}
