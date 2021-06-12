package com.leetcode;

import java.util.ArrayList;

public class SortArrayByParity {

	public int[] sortArrayByParityII(int[] A) {
		ArrayList<Integer> evenNum = new ArrayList<>();
		ArrayList<Integer> oddNum = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			if((A[i]&1)==0){
				evenNum.add(A[i]);
			}else{
				oddNum.add(A[i]);
			}
		}
		int indx = 0;
		for(int i=0; i<A.length; i=i+2){
			A[i] = evenNum.get(indx);
			indx++;
		}
		indx=0;
		for(int i=1; i<A.length; i=i+2){
			A[i] = oddNum.get(indx);
			indx++;
		}
		return A;
	}
	
	public static void main(String[] args) {
		int[] A = {4,2,5,7};
		SortArrayByParity sortArrayByParity = new SortArrayByParity();
		A = sortArrayByParity.sortArrayByParityII(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]+" ");
		}
	}
}
