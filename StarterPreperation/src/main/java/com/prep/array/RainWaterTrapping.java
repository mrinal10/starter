package com.prep.array;

import java.util.Scanner;

public class RainWaterTrapping {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-->0) {
			int n = sc.nextInt();
			int[] heights = new int[n];
			for (int i = 0; i < heights.length; i++) {
				heights[i] = sc.nextInt();
			}
			System.out.println(trap(heights));
		}
		sc.close();
	}
	public static int trap(int[] height) {
		int len = height.length;
		int[] fromLeft = new int[len];
		int[] fromRight = new int[len];
		int MaxValue = 0;
		for (int i = 0; i < len; i++) {
			if(height[i]>MaxValue) {
				fromLeft[i] = 0;
				MaxValue = height[i];
			}else {
				fromLeft[i] = MaxValue - height[i];
			}
		}
		MaxValue = 0;
		for (int i = len-1; i >= 0; i--) {
			if(height[i]>MaxValue) {
				fromRight[i] = 0;
				MaxValue = height[i];
			}else {
				fromRight[i] = MaxValue - height[i];
			}
		}
		int cnt = 0;
		for (int i = 0; i < fromRight.length; i++) {
			cnt += Math.min(fromLeft[i], fromRight[i]);
		}
		return cnt;
	}
}
