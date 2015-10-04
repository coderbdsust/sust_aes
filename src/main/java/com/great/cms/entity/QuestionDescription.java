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
@Table(name = "question_description")
public class QuestionDescription implements DomainObject, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "question_desc_id")
	private Long questionDescId;
	@Basic(optional = false)
	@Column(name = "question_body")
	private String questionBody;
	@JoinColumn(name = "question_id", referencedColumnName = "question_id")
	@ManyToOne(optional = false)
	private Question questionId;

	public QuestionDescription() {
	}

	public QuestionDescription(Long questionDescId) {
		this.questionDescId = questionDescId;
	}

	public QuestionDescription(Long questionDescId, String questionBody) {
		this.questionDescId = questionDescId;
		this.questionBody = questionBody;
	}

	public Long getQuestionDescId() {
		return questionDescId;
	}

	public void setQuestionDescId(Long questionDescId) {
		this.questionDescId = questionDescId;
	}

	public String getQuestionBody() {
		return questionBody;
	}

	public void setQuestionBody(String questionBody) {
		this.questionBody = questionBody;
	}

	public Question getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Question questionId) {
		this.questionId = questionId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (questionDescId != null ? questionDescId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof QuestionDescription)) {
			return false;
		}
		QuestionDescription other = (QuestionDescription) object;
		if ((this.questionDescId == null && other.questionDescId != null)
				|| (this.questionDescId != null && !this.questionDescId
						.equals(other.questionDescId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.great.cms.entity.QuestionDescription[ questionDescId="
				+ questionDescId + " ]";
	}

}
