package com.contest.techgig;

import java.util.Scanner;
import java.util.Stack;

public class CAnRepBST {
	boolean canRepresentBST(int pre[], int n) {
		Stack<Integer> s = new Stack<Integer>();
		int root = Integer.MIN_VALUE;
//Input:  pre[] = {40, 30, 35, 80, 100}
		for (int i = 0; i < n; i++) {
			if (pre[i] < root)
				return false;
			while (!s.empty() && s.peek() < pre[i])
				root = s.pop();
			s.push(pre[i]);
		}
		return true;
	}

	public static void main(String[] args) {
		CAnRepBST bst = new CAnRepBST();
		Scanner sc = new Scanner(System.in);
		int testsCases = sc.nextInt();
		while (testsCases-- > 0) {
			int n = sc.nextInt();
			int[] pre = new int[n];
			for (int i = 0; i < n; i++) {
				pre[i] = sc.nextInt();
			}
			if (bst.canRepresentBST(pre, n) == true) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
		}
		sc.close();
	}
}
