package com.zero;

import java.util.*;
public class MajorityElementOptimized3 
{
	
	static int boyceMoore(int[] arr){
		int maxEl = arr[0];
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(count==0){
				maxEl = arr[i];
				count = 1;
			}
			if(maxEl==arr[i]){
				count++;
			}else{
				count--;
			}
		}
		return maxEl;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		while(tCase-->0){
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(boyceMoore(arr));
		}
		sc.close();
	}
}