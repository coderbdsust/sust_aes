package com.great.cms.controller.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.great.cms.entity.QuizQuestion;

public class AssignQuestion {

	private List<QuizQuestion> removeList = new ArrayList<QuizQuestion>();
	private List<QuizQuestion> saveList = new ArrayList<QuizQuestion>();

	public AssignQuestion(ArrayList<QuizQuestion> prevList,
			ArrayList<QuizQuestion> newList) {
		divideIntoOperationList(prevList, newList);
	}

	private void divideIntoOperationList(ArrayList<QuizQuestion> prevList,
			ArrayList<QuizQuestion> newList) {

		List<QuizQuestion> commonList = new ArrayList<>(prevList);
		commonList.retainAll(newList);
		System.out.println("COMMON SIZE: " + commonList.size());
		prevList.removeAll(commonList);
		newList.removeAll(commonList);
		removeList = prevList;
		saveList = newList;

	}

	public List<QuizQuestion> getRemoveList() {
		return removeList;
	}

	public void setRemoveList(List<QuizQuestion> removeList) {
		this.removeList = removeList;
	}

	public List<QuizQuestion> getSaveList() {
		return saveList;
	}

	public void setSaveList(List<QuizQuestion> saveList) {
		this.saveList = saveList;
	}

}
