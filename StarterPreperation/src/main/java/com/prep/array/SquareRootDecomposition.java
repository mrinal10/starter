package com.prep.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//for range query
class SubArray{
	
	private int sum;
	private int lengthOfArray;
	private int[] arr;
	
	public SubArray(int length) {
		lengthOfArray = length;
		arr = new int[length];
		sum = 0;
	}
	
	public void updateValue(int value, int index) {
		sum -= arr[index];
		arr[index] = value;
		sum += arr[index];
	}
	
	public int getSum() {
		return sum;
	}

	public int getLengthOfArray() {
		return lengthOfArray;
	}

	public int[] getArr() {
		return arr;
	}
}

public class SquareRootDecomposition {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lengthOfArray = sc.nextInt();
		int[] arr = new int[lengthOfArray];
		for(int i=0; i<lengthOfArray; i++) {
			arr[i] = sc.nextInt();
		}
		int lengthOfSubArrays = (int) Math.ceil(Math.sqrt(lengthOfArray));
//		int numberOfSubArrays = num 
//		List<SubArray> listOfArray = new ArrayList<SubArray>(numberOfSubArrays);
//		for(int i=0; i<lengthOfArray; i++) {
//			if( i%lengthOfArray == 0) {
//				SubArray subArray = new SubArray(length)
//			}
//		}
		sc.close();
	}
}
