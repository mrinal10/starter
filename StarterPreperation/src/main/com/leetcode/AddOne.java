package com.leetcode;

import java.util.ArrayList;

public class AddOne {
	public static int[] plusOne(int[] digits) {
		int rem = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int v = digits[i];
			v += rem;

			if (v >= 10) {
				rem = v % 10;
				v = v / 10;
				digits[i] = v;
			} else {
				digits[i] = v;
				return digits;
			}
		}
		int[] val = new int[digits.length + 1];
		val[0] = rem;
		for (int i = 1; i < val.length; i++) {
			val[i] = digits[i - 1];
		}

		return val;
	}

	public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		int rem = 1;
		for (int i = A.size() - 1; i >= 0; i--) {
			int v = A.get(i);
			v += rem;

			if (v >= 10) {
				rem = v / 10;
				v = v % 10;
				A.remove(i);
				A.add(i, v);
			} else {
				A.remove(i);
				A.add(i, v);
				vlean(A);
				return A;
			}
		}
		A.add(0, rem);
		vlean(A);
		return A;
	}
	
	private static void vlean(ArrayList<Integer> A){
		while (A.size()!=0) {
			if (A.get(0)==0) {
				A.remove(0);
			}else
				break;
		}
	}

	public static void main(String[] args) {
//		int[] arr = { 0, 3 , 9 };
		ArrayList<Integer> aList = new ArrayList<>();
		aList.add(9);
		plusOne(aList);
	}
}
