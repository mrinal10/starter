package com.zero.backtracking;

import java.util.Scanner;

public class GetDesiredResult {

	private boolean achieveTarget(int[] arr, int trgt, int startIndx, int endindx, int curValue, int arrlength,
			String expr) {
		System.out.println(expr+" :: "+curValue);
		if (trgt == curValue) {
			return true;
		}
		for (int i = startIndx; i <= endindx; i++) {
			boolean value1 = achieveTarget(arr, trgt, i + 1, endindx, curValue + arr[i], arr.length,
					expr + "+" + arr[i]);
			if (value1) {
				return value1;
			}
			value1 = achieveTarget(arr, trgt, i + 1, endindx, curValue - arr[i], arr.length, expr + "-" + arr[i]);
			if (value1) {
				return value1;
			}
			// if(curValue!=0){
			value1 = achieveTarget(arr, trgt, i + 1, endindx, curValue * arr[i], arr.length, expr + "*" + arr[i]);
			if (value1) {
				return value1;
			}
			// }
		}
		return false;
	}

	private boolean isTargetAchievable(int[] arr, int trgt) {
		String expr = "";
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				flag = achieveTarget(arr, trgt, i, j, 0, arr.length, expr);
				if (flag) {
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		int[] arr = new int[5];// {2,3,5,7,11};//{ 1, 2, 3, 4, 5 };
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		while (flag) {
			int zroCnt = 0;
			for (int i = 0; i < arr.length; i++) {
				int v = sc.nextInt();
				if (v == 0) {
					zroCnt++;
				}
				if (zroCnt == 5) {
					flag = false;
				}
				arr[i] = v;
			}
			if (flag) {
				int trgt = 23;
				GetDesiredResult res = new GetDesiredResult();
				if (res.isTargetAchievable(arr, trgt)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
		sc.close();
	}

}
