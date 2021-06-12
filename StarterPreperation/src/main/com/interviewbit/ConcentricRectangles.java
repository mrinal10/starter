package com.interviewbit;

import java.util.ArrayList;

public class ConcentricRectangles {

	public static void main(String[] args) {
		int n = 4;
		prettyPrint(n);
	}
	
	private static void printArr(int[][] ar){
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> prettyPrint(int A) {
		ArrayList<ArrayList<Integer>> aList = new ArrayList<>();
		int dimension = A*2-1;
		int num = A;
		int[][] arr = new int[dimension][dimension];
		for (int i = 0; i < arr.length/2+1; i++) {
			for (int j = i; j < arr.length-i; j++) {
				arr[i][j] = num;
				arr[arr.length-1-i][j] = num;
			}
			num--;
		}
		
		num = A;
		for (int i = 0; i < arr.length/2+1; i++) {
			for (int j = i+1; j < arr.length-i-1; j++) {
				arr[j][i]= num;
				arr[j][arr.length-1-i]= num;
			}
			num--;
		}
		for (int i = 0; i < arr.length; i++) {
			ArrayList<Integer> tempList = new ArrayList<>();
			for (int j = 0; j < arr.length; j++) {
				tempList.add(arr[i][j]);
			}
			aList.add(tempList);
		}
		return aList;
    }

}
