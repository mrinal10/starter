package com.hackerearth.practice;

import java.util.Scanner;

public class PrateekandhisFriends {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		while(testcases-->0){
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[] arr = new int[n];
			for(int i=0; i<n; i++){
				arr[i] = sc.nextInt();
			}
			boolean flag = false;
			for(int i=0; i<n; i++){
				int sum = 0;
				flag = false;
				for(int j=i; j<n ;j++){
					sum += arr[j];
					if(sum==k){
						flag = true;
						break;
					}
					if(sum>k){
						break;
					}
				}
				if(flag){
					break;
				}
			}
			if(flag){
				System.out.println("YES");
			}else
				System.out.println("NO");
		}
		sc.close();
	}

}
