package com.great.cms.controller.utils;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.great.cms.controller.bean.simulator.Field;
import com.great.cms.controller.bean.simulator.Option;
import com.great.cms.entity.Question;
import com.great.cms.entity.QuestionAnswer;

public class QuestionAnswerSimulatorUtil implements IQuestionAnswerSimulator {
	private static final QuestionAnswerSimulatorUtil ownInstance = new QuestionAnswerSimulatorUtil();

	public static IQuestionAnswerSimulator getInstance() {
		return ownInstance;
	}

	@Override
	public boolean isMCQAnswerCorrect(Question question,
			QuestionAnswer questionAnswer) {

		List<Option> questionOptions = getSortedOptions(question
				.getQuestionBody());
		List<Option> answerOptions = getSortedOptions(questionAnswer
				.getAnswerBody());
		if (questionOptions.size() == answerOptions.size()) {
			for (int index = 0; index < questionOptions.size(); index++) {
				Option questionOption = questionOptions.get(index);
				Option answerOption = answerOptions.get(index);
				if (!questionOption.equals(answerOption)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean isFillInTheGapsAnswerCorrect(Question question,
			QuestionAnswer questionAnswer) {
		// TODO Auto-generated method stub
		List<Field> questionFields = getSortedField(question.getQuestionBody());
		List<Field> answerFields = getSortedField(questionAnswer
				.getAnswerBody());
		if (questionFields.size() == answerFields.size()) {
			for (int index = 0; index < questionFields.size(); index++) {
				Field questionField = questionFields.get(index);
				Field answerField = answerFields.get(index);
				if (!questionField.equals(answerField)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public List<Option> getSortedOptions(String optionJson) {
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Option>>() {
		}.getType();
		List<Option> Options = (List<Option>) gson.fromJson(optionJson,
				listType);
		return Options;
	}

	public List<Field> getSortedField(String fieldJson) {
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Field>>() {
		}.getType();
		List<Field> fields = (List<Field>) gson.fromJson(fieldJson, listType);
		return fields;
	}
}
