package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class State {
	private String stateName;
	private int femaleCount;
	private int maleCount;
	private int literacyPercentage;
	public String getStateName() {
		return stateName;
	}
	public int getFemaleCount() {
		return femaleCount;
	}
	public int getMaleCount() {
		return maleCount;
	}
	public int getLiteracyPercentage() {
		return literacyPercentage;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public void setFemaleCount(int femaleCount) {
		this.femaleCount = femaleCount;
	}
	public void setMaleCount(int maleCount) {
		this.maleCount = maleCount;
	}
	public void setLiteracyPercentage(int literacyPercentage) {
		this.literacyPercentage = literacyPercentage;
	}
}

class Group{
	public static void main(String[] args) {
		List<State> ll = new ArrayList<State>();
		
		Comparator<State> LiteracyComparator = ((State s1, State s2) -> {
			if(s1.getLiteracyPercentage() > s2.getLiteracyPercentage()) {
				return 1;
			} else if(s1.getLiteracyPercentage()<s2.getLiteracyPercentage()) {
				return -1;
			}
			return 0;
		});
		
		Comparator<State> comparator = Comparator.comparing( State::getLiteracyPercentage );
		int maxV1 = ll.stream().max(LiteracyComparator).get().getLiteracyPercentage();
		int maxV2 = ll.stream().max(comparator).get().getLiteracyPercentage();
		ll.sort((State s1, State s2)->(s1.getMaleCount() - s2.getMaleCount()));

		
		int totalFemale = ll.stream().mapToInt(state->state.getFemaleCount()).sum();
		
		System.out.println(maxV1+"::"+maxV2+"::"+totalFemale);
	}
}

