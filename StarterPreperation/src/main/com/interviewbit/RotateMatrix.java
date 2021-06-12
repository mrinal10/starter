package com.interviewbit;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RotateMatrix {
	public static void rotate(ArrayList<ArrayList<Integer>> a) {
		int n = a.size();
		
		for (int i = 0; i <n; i++) {
			ArrayList<Integer> ll = new ArrayList<>();
			for (int j = n - 1; j >= 0; j--) {
				ll.add(a.get(j).get(i));
			}
			a.add(ll);
		}
		for (int i = 0; i <n; i++) {
			a.remove(0);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		ArrayList<Integer> li1 = new ArrayList<>();
		li1.add(1);
		li1.add(2);
		
		ArrayList<Integer> li2 = new ArrayList<>();
		li2.add(3);
		li2.add(4);
		
		list.add(li1);
		list.add(li2);
		
		rotate(list);
	}
}
