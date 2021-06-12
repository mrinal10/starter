package com.apostek.hiring24082018;

import java.util.Scanner;

public class Problem1 {

	private static void queryOne(int[] arr, int indx) {
		int leftIndx = -1;
		int rightIndx = -1;
		for (int i = indx-1; i >=0; i--) {
			if(arr[i]==1){
				leftIndx = i;
				break;
			}
		}
		
		for (int i = indx+1; i<arr.length; i++) {
			if(arr[i]==1){
				rightIndx = i;
				break;
			}
		}
		System.out.println(leftIndx+" "+rightIndx);
	}

	private static void queryTwo(int[] arr, int indx) {
		if(arr[indx] == 0){
			arr[indx] = 1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i <=m; i++) {
			String q = sc.nextLine();
			String[] query = q.split(" ");
			if (query[0].equals("0")) {
				queryOne(arr, Integer.parseInt(query[1]));
			} else if (query[0].equals("1")) {
				queryTwo(arr, Integer.parseInt(query[1]));
			}

		}
		sc.close();
	}

}
