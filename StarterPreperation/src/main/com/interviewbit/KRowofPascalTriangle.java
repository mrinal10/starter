package com.interviewbit;

import java.util.ArrayList;

public class KRowofPascalTriangle {

	public static ArrayList<Integer> getRow(int A) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i <=A; i++) {
			list.add(binomialCoeff(A, i));
		}
		return list;
    }
	
	public static int binomialCoeff(int n, int k){
		int res = 1;
		if (k>n-k) {
			k = n-k;
		}
		for (int i = 0; i < k; i++) {
			res *= (n-i);
			res /= (i+1);
		}
		return res;
	}
	public static void main(String[] args) {
		int n = 3;
		ArrayList<Integer> list = getRow(n);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
