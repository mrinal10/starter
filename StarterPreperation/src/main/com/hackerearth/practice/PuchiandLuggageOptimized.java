package com.hackerearth.practice;

import java.util.*;

public class PuchiandLuggageOptimized {
	public static int MAX = 100010;
	public static int[] fre = new int[1000010];
	public static int[] aux = new int[MAX];
	public static int[] a = new int[MAX];
	public static int[] b = new int[MAX];

	public static void merge(int left, int mid, int right) {
		int i = left, j = mid + 1, k = 0, c = 0;
		for (int m = left; m <= right; m++) {
			if (i > mid) {
				aux[k++] = a[j++];
			} else if (j > right || a[i] <= a[j]) {
				aux[k++] = a[i];
				fre[a[i]] += c;
				i++;
			} else {
				aux[k++] = a[j++];
				c++;
			}
		}
		for (i = 0; i < k; i++) {
			a[left++] = aux[i];
		}
	}

	public static void mer(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mer(left, mid);
			mer(mid + 1, right);
			merge(left, mid, right);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			Arrays.fill(fre, 0);
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				b[i] = a[i];
			}
			mer(0, n - 1);
			for (int i = 0; i < n; i++) {
				System.out.print(fre[b[i]] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}