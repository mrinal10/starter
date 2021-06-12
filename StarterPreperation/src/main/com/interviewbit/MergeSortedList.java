package com.interviewbit;

import java.util.ArrayList;

public class MergeSortedList {

	public static void main(String[] args) {
		ArrayList<Integer> li1 = new ArrayList<>();
		li1.add(-4);
		li1.add(3);
		ArrayList<Integer> li2 = new ArrayList<>();
		li2.add(-2);
		li2.add(-2);
		merge(li1,li2);
	}

	public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		int i = 0;
		int j = 0;
		int leni = a.size();
		int lenj = b.size();

		while (i < leni && j < lenj) {
			if (a.get(i)<b.get(j)) {
				System.out.print(a.get(i)+" ");
				i++;
			}else{
				System.out.print(b.get(j)+" ");
				j++;
			}

		}
		while (i < leni) {
			System.out.print(a.get(i)+" ");
			i++;
		}
		while (j < lenj) {
			System.out.print(b.get(j)+" ");
			j++;
		}
		a.clear();
	}

}
