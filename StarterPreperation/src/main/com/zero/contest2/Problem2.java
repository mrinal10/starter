package com.zero.contest2;

import java.util.Scanner;

public class Problem2 {
	private static int Max_Value = Integer.MIN_VALUE;
	private static boolean isSafe(int[][] arr, int r, int c){
		return (r<0||r>arr.length-1||c<0||c>arr[0].length-1);
	}
	private static void findMaxHlpr(int[][] arr, int r, int c, int h, int w, int cnt){
		if(isSafe(arr, r, c)){
			return;
		}
		if(r == 0){
			cnt += arr[r][c];
			if(Max_Value<cnt){
				Max_Value = cnt;
			}
			return;
		}
		findMaxHlpr(arr,r-1,c,h,w,cnt+arr[r][c]);
		findMaxHlpr(arr,r-1,c+1,h,w,cnt+arr[r][c]);
		findMaxHlpr(arr,r-1,c-1,h,w,cnt+arr[r][c]);
	}
	
	private static void findMaxHlpr(int[][] arr, int r, int c){
		
		findMaxHlpr(arr, r, c, arr.length, arr[0].length, 0);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
//		int[][] arr = new int[h][w];
//		for (int i = 0; i < h; i++) {
//			for (int j = 0; j < w; j++) {
//				arr[i][j] = sc.nextInt();
//			}
//		}
		
		int[][] arr = {{3,1,7,4,2},{2,1,3,1,1},{1,2,2,1,8},{2,2,1,5,3},{2,1,4,4,4},{5,2,7,5,1}};
		for (int i = 0; i < arr[0].length; i++) {
			
			findMaxHlpr(arr, h-1,i);
			
		}
		System.out.println(Max_Value);
		sc.close();

	}

}
