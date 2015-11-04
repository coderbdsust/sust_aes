package com.great.cms.controller.bean.simulator;

import java.util.List;

import com.great.cms.entity.Teacher;
import com.great.cms.enums.QuestionType;

public class MCQ implements IQuestion{
	private Long questionId;
	private Integer courseId;
	private QuestionType questionType;
	private String questionText;
	private List<Option> questionBody;
	private Integer difficultyLevel;
	private Integer requiredTime;
	private Double questionMarks;
	private Teacher createdBy;

	public MCQ() {
	}

	public MCQ(Long questionId, Integer courseId, QuestionType questionType,
			String questionText, List<Option> questionBody,
			Integer difficultyLevel, Integer requiredTime, Double questionMarks) {
		this.questionId = questionId;
		this.courseId = courseId;
		this.questionType = questionType;
		this.questionText = questionText;
		this.questionBody = questionBody;
		this.difficultyLevel = difficultyLevel;
		this.requiredTime = requiredTime;
		this.questionMarks = questionMarks;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<Option> getQuestionBody() {
		return questionBody;
	}

	public void setQuestionBody(List<Option> questionBody) {
		this.questionBody = questionBody;
	}

	public Integer getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(Integer difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public Integer getRequiredTime() {
		return requiredTime;
	}

	public void setRequiredTime(Integer requiredTime) {
		this.requiredTime = requiredTime;
	}

	public Double getQuestionMarks() {
		return questionMarks;
	}

	public void setQuestionMarks(Double questionMarks) {
		this.questionMarks = questionMarks;
	}

	public Teacher getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Teacher createdBy) {
		this.createdBy = createdBy;
	}
	
	

}
