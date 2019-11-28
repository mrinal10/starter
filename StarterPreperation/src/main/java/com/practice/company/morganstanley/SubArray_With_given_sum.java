package com.practice.company.morganstanley;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubArray_With_given_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		while(testcases -- >0) {
			int N = sc.nextInt();
			int target = sc.nextInt();
			int[] ar = new int[N];
			for(int i=0; i<N; i++) {
				ar[i] = sc.nextInt();
			}
			getSubArray(ar, N, target);
			
		}
		sc.close();
	}
	
	public static void getSubArray(int[] ar, int len, int target) {
		int curSum = 0;
		int start = 0;
		int end = -1;
		Map<Integer, Integer> theMap = new HashMap<>();
		for(int i =0; i<len; i++) {
			curSum += ar[i];
			if(curSum == target) {
				start = 0;
				end = i;
				break;
			} else if (theMap.containsKey(curSum-target)) {
				start = theMap.get(curSum-target)+1;
				end = i;
				break;
			}
			theMap.put(curSum, i);
		}
		
		if(end==-1) {
			System.out.println("-1");
		}else {
			System.out.println(start+" : "+end);
		}
	}
}
