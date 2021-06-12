package com.interviewbit;

import java.util.*;

public class Permutations2 {

	public static void main(String[] args) {
		int[] arr = {1,2,4,3,4,1,5};
		ArrayList<ArrayList<Integer>> permute = permuteUnique(arr);
		printList(permute);
	}
	
	private static void printList(ArrayList<ArrayList<Integer>> permute){
		for (int i = 0; i < permute.size(); i++) {
			ArrayList<Integer> aList = permute.get(i);
			for (int j = 0; j < aList.size(); j++) {
				System.out.print(aList.get(j)+" ");
			}
			System.out.println(">>>>>>");
		}
	}

	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> returnList = new ArrayList<>();
		returnList.add(new ArrayList<Integer>());
		for (int i = 0; i < num.length; i++) {
			Set<ArrayList<Integer>> currentSet = new HashSet<>();
			for (List<Integer> l : returnList) {
				for (int j = 0; j < l.size() + 1; j++) {
					l.add(j, num[i]);
					currentSet.add(new ArrayList<Integer>(l));
					l.remove(j);
				}
			}
			returnList = new ArrayList<>(currentSet);
			printList(returnList);
			System.out.println("@@@@@@@@@@@@@");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
		return returnList;
	}

}
