package com.practice.opt.um;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem8 {

	public static void main(String[] args) {
		int[] priorities = {2, 9, 3, 2, 3}; 
				//{ 1, 3, 7, 3 };
		reassignPriority(priorities);
		for (int i = 0; i < priorities.length; i++) {
			System.out.print(priorities[i] + " ");
		}
	}

	private static void reassignPriority(int[] ar) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < ar.length; i++) {
			set.add(ar[i]);
		}
		List<Integer> l = new ArrayList<>();
		for (Integer i : set) {
			l.add(i);
		}

		Collections.sort(l);
		for (int i = 0; i < ar.length; i++) {
			ar[i] = l.indexOf(ar[i]) + 1;
		}
	}

}
