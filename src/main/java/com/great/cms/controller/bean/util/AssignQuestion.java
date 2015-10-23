package com.great.cms.controller.bean.util;

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

	public AssignQuestion(List<QuizQuestion> prevList,
			List<QuizQuestion> newList) {
		divideIntoOperationList(prevList, newList);
	}

	private void divideIntoOperationList(List<QuizQuestion> prevList,
			List<QuizQuestion> newList) {
		// System.out.println("PREV LIST: " + prevList.size());
		// System.out.println("NEW LIST: " + newList.size());
		removeList = prevList;
		saveList = newList;

		HashMap mapPrevListIndex = new HashMap<Long, Integer>();
		HashMap commonKeyMap = new HashMap<Long, Integer>();

		for (Integer index = 0; index < prevList.size(); index++) {
			QuizQuestion q = prevList.get(index);
			mapPrevListIndex.put(q.getQuestionId().getQuestionId(), index);
		}

		for (Integer index = 0; index < newList.size(); index++) {
			QuizQuestion q = newList.get(index);
			if (mapPrevListIndex.containsKey(q.getQuestionId().getQuestionId())) {
				commonKeyMap.put(q.getQuestionId().getQuestionId(), index);
			}
		}

		ArrayList<Integer> prevListRemoveIndexes = new ArrayList<Integer>();
		ArrayList<Integer> newListRemoveIndexes = new ArrayList<Integer>();
		Set<Long> keys = commonKeyMap.keySet();

		for (Long key : keys) {
			System.out.println("Key:" + key);

			prevListRemoveIndexes.add((Integer) mapPrevListIndex.get(key));
			newListRemoveIndexes.add((Integer) commonKeyMap.get(key));

		}

		Collections.sort(prevListRemoveIndexes, Collections.reverseOrder());
		Collections.sort(newListRemoveIndexes, Collections.reverseOrder());

		// System.out.println("REMOVE LIST SIZE BEFORE DELETE: " +
		// removeList.size());
		for (int in : prevListRemoveIndexes) {
			
			removeList.remove(in);

			// System.out.println("REMOVE FROM LIST: " + index);
		}
		// System.out.println("REMOVE LIST SIZE BEFORE DELETE: " +
		// removeList.size());

		// System.out.println("SAVE LIST SIZE BEFORE DELETE: " +
		// saveList.size());
		for (int in : newListRemoveIndexes) {
			saveList.remove(in);
			// System.out.println("REMOVE FROM LIST: " + index);
		}
		// System.out.println("SAVE LIST SIZE AFTER DELETE: " +
		// saveList.size());
		System.out.println("SPLITING COMPLETE!");
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
