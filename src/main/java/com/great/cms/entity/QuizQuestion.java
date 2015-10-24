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
@Table(name = "quiz_question")
@NamedQueries({
		@NamedQuery(name = "QuizQuestion.findAll", query = "SELECT q FROM QuizQuestion q"),
		@NamedQuery(name = "QuizQuestion.findByQuizQuestionId", query = "SELECT q FROM QuizQuestion q WHERE q.quizQuestionId = :quizQuestionId") })
public class QuizQuestion implements DomainObject, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "quiz_question_id")
	private Long quizQuestionId;
	@JoinColumn(name = "quiz_id", referencedColumnName = "quiz_id")
	@ManyToOne(optional = false)
	private Quiz quizId;
	@JoinColumn(name = "question_id", referencedColumnName = "question_id")
	@ManyToOne(optional = false)
	private Question questionId;

	public QuizQuestion() {
	}

	public QuizQuestion(Long quizQuestionId) {
		this.quizQuestionId = quizQuestionId;
	}

	public Long getQuizQuestionId() {
		return quizQuestionId;
	}

	public void setQuizQuestionId(Long quizQuestionId) {
		this.quizQuestionId = quizQuestionId;
	}

	public Quiz getQuizId() {
		return quizId;
	}

	public void setQuizId(Quiz quizId) {
		this.quizId = quizId;
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
		hash += (quizQuestionId != null ? quizQuestionId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof QuizQuestion)) {
			return false;
		}
		QuizQuestion other = (QuizQuestion) object;

		if (this.questionId == null)
			return false;
		if (this.quizId == null)
			return false;
		if (other.getQuestionId() == null)
			return false;
		if (other.getQuizId() == null)
			return false;

		if (this.quizId.getQuizId() == other.getQuizId().getQuizId()
				&& this.questionId.getQuestionId() == other.getQuestionId()
						.getQuestionId()) {
			return true;
		} else {
			if (this.quizQuestionId == other.getQuizQuestionId()) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public String toString() {
		return "QuizQuestion [quizQuestionId=" + quizQuestionId + ", quizId="
				+ quizId + ", questionId=" + questionId + "]";
	}

}
