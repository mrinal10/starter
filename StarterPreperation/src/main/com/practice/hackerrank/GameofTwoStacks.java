package com.practice.hackerrank;

import java.util.Scanner;

public class GameofTwoStacks {
	static int[] stack1;
	static int[] stack2;

	static int maxCount = 0;
	static int maxSum = 0;
	static int x = 0;

	private static void getMaxCounthlpr(int indx1, int indx2, int curCount, int curSum) {
		System.out.println(indx1 + " ::"+maxCount+":: " + indx2);
		if (indx1 >= stack1.length && indx2 >= stack2.length) {
			return;
		}
		if (curCount > maxCount  && curSum==x) {
			maxCount = curCount;
		}
		
		getMaxCounthlpr(indx1, indx2 + 1, curCount + 1, curSum + stack2[indx2]);
		getMaxCounthlpr(indx1 + 1, indx2, curCount + 1, curSum + stack1[indx1]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();

			x = sc.nextInt();
			stack1 = new int[n1];
			stack2 = new int[n2];
			for (int i = 0; i < n1; i++) {
				stack1[i] = sc.nextInt();
			}

			for (int i = 0; i < n2; i++) {
				stack2[i] = sc.nextInt();
			}

			maxCount = 0;
			maxSum = 0;
			getMaxCounthlpr(0, 0, 0, 0);
			System.out.println(maxCount);
		}
		sc.close();
	}

}
