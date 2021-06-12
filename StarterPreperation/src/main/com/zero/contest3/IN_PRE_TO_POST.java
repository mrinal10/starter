package com.zero.contest3;

import java.util.Scanner;

public class IN_PRE_TO_POST {
	static int preIndex = 0;
	static int in[];
	static int pre[];

	static void postOrderTraversal(int sIndex, int eIndex) {
		if (sIndex > eIndex)
			return;
		int inIndex = search(sIndex, eIndex, preIndex++);
		postOrderTraversal(sIndex, inIndex - 1);
		postOrderTraversal(inIndex + 1, eIndex);
		System.out.print(in[inIndex] + " ");
	}

	static int search(int startIn, int endIn, int data) {
		int i = 0;
		for (i = startIn; i < endIn; i++)
			if (in[i] == pre[data])
				return i;
		return i;
	}

	public static void main(String ars[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		in = new int[n];
		for (int i = 0; i < n; i++) {
			in[i] = sc.nextInt();
		}
		pre = new int[n];
		for (int i = 0; i < n; i++) {
			pre[i] = sc.nextInt();
		}
		int len = in.length;
		postOrderTraversal(0, len - 1);
		sc.close();
	}
}