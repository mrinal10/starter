package com.practice.opt.um;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem8 {

	public static void main(String[] args) {
		List<Integer> priorities = Arrays.asList(1, 3, 7, 3);
		priorities = reassignPriority(priorities);
		for (int i = 0; i < priorities.size(); i++) {
			System.out.print(priorities.get(i) + " ");
		}
	}

	private static List<Integer> reassignPriority(List<Integer> ar) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < ar.size(); i++) {
			set.add(ar.get(i));
		}
		List<Integer> l = new ArrayList<>();
		for (Integer i : set) {
			l.add(i);
		}

		Collections.sort(l);
		List<Integer> ll = new ArrayList<>();
		for (int i = 0; i < ar.size(); i++) {
			int indx = l.indexOf(ar.get(i))+1;
			ll.add(indx);
		}
		return ll;
	}

}
