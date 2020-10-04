package com.gfg.mustdocoding.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {

	private static void mergerArrayList(List<Integer> listA, List<Integer> listB) {
		int indxB = 0;
		for (int i = 0; i < listA.size(); i++) {
			int curIndx = i;
			if (indxB < listB.size() && listA.get(curIndx) > listB.get(indxB)) {
				listA.add(curIndx, listB.get(indxB));
				indxB++;
			}
		}

		while (indxB < listB.size()) {
			listA.add(listB.get(indxB));
			indxB++;
		}
	}

	public static void main(String[] args) {
		List<Integer> listA = new ArrayList<Integer>();
		listA.add(1);
		listA.add(3);
		listA.add(11);
		listA.add(13);
		listA.add(18);
		List<Integer> listB = new ArrayList<Integer>();
		listB.add(2);
		listB.add(7);
		listB.add(9);
		listB.add(12);
		listB.add(17);
		mergerArrayList(listA, listB);
		for (Integer i : listA) {
			System.out.println(i);
		}
	}
}

class main{
	public static void main(String[] args) {
		Problem1 c = new Problem1();
		
	}
}
