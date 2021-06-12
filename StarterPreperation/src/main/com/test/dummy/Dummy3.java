package com.test.dummy;

import java.util.Arrays;
import java.util.Scanner;

public class Dummy3 {



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n; i++){
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			if(arr[0]<k){
				System.out.println(arr[0]);
			}else{
				System.out.println(0);
			}
			
		}
		sc.close();
	}

}
