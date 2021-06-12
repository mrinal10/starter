package com.zero.bitmanipulation;

import java.util.Scanner;

public class FindIntegerWithSingleOccurenceInUnsortedArray {
	private static int singleElement(int[] arr){
		int retValue = arr[0];
		for(int i=1;i<arr.length;i++){
			retValue = retValue^arr[i];
		}
		if(retValue==0)
		    retValue = -1;
		return retValue;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-->0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			System.out.println(singleElement(arr));
		}
		sc.close();
	}

}
