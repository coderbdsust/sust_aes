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

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Biswajit Debnath
 */
@Entity
@Table(name = "exam")
@NamedQueries({ @NamedQuery(name = "Exam.findAll", query = "SELECT e FROM Exam e"),
		@NamedQuery(name = "Exam.findByExamId", query = "SELECT e FROM Exam e WHERE e.examId = :examId"),
		@NamedQuery(name = "Exam.findByUsnNo", query = "SELECT e FROM Exam e WHERE e.usnNo = :usnNo"),
		@NamedQuery(name = "Exam.findByExamStart", query = "SELECT e FROM Exam e WHERE e.examStart = :examStart"),
		@NamedQuery(name = "Exam.findByExamEnd", query = "SELECT e FROM Exam e WHERE e.examEnd = :examEnd"),
		@NamedQuery(name = "Exam.findByRegStart", query = "SELECT e FROM Exam e WHERE e.regStart = :regStart"),
		@NamedQuery(name = "Exam.findByRegEnd", query = "SELECT e FROM Exam e WHERE e.regEnd = :regEnd") })
public class Exam implements DomainObject, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "exam_id")
	private Long examId;
	@Basic(optional = false)
	@Column(name = "usn_no")
	private int usnNo;
	@Basic(optional = false)
	@Column(name = "exam_start")
	private String examStart;
	@Basic(optional = false)
	@Column(name = "exam_end")
	private String examEnd;
	@Basic(optional = false)
	@Column(name = "reg_start")
	private String regStart;
	@Basic(optional = false)
	@Column(name = "reg_end")
	private String regEnd;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "examId")
	private List<ExamCommittee> examCommitteeList;
	@JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
	@ManyToOne(optional = false)
	private Department deptId;

	public Exam() {
	}

	public Exam(Long examId) {
		this.examId = examId;
	}

	public Exam(Long examId, int usnNo, String examStart, String examEnd, String regStart, String regEnd) {
		this.examId = examId;
		this.usnNo = usnNo;
		this.examStart = examStart;
		this.examEnd = examEnd;
		this.regStart = regStart;
		this.regEnd = regEnd;
	}

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public int getUsnNo() {
		return usnNo;
	}

	public void setUsnNo(int usnNo) {
		this.usnNo = usnNo;
	}

	public String getExamStart() {
		return examStart;
	}

	public void setExamStart(String examStart) {
		this.examStart = examStart;
	}

	public String getExamEnd() {
		return examEnd;
	}

	public void setExamEnd(String examEnd) {
		this.examEnd = examEnd;
	}

	public String getRegStart() {
		return regStart;
	}

	public void setRegStart(String regStart) {
		this.regStart = regStart;
	}

	public String getRegEnd() {
		return regEnd;
	}

	public void setRegEnd(String regEnd) {
		this.regEnd = regEnd;
	}

	public List<ExamCommittee> getExamCommitteeList() {
		return examCommitteeList;
	}

	public void setExamCommitteeList(List<ExamCommittee> examCommitteeList) {
		this.examCommitteeList = examCommitteeList;
	}

	public Department getDeptId() {
		return deptId;
	}

	public void setDeptId(Department deptId) {
		this.deptId = deptId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (examId != null ? examId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Exam)) {
			return false;
		}
		Exam other = (Exam) object;
		if ((this.examId == null && other.examId != null)
				|| (this.examId != null && !this.examId.equals(other.examId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.great.cms.entity.Exam[ examId=" + examId + " ]";
	}

}
