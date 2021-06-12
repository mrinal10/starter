package com.practice.hackerearth;

import java.util.Scanner;

public class TreeAndSpecialNodesOptimized{

	static boolean[] alreadyVisited;
	
	static int n, m;
	static int[][] graph;
	static int[] A;
	static boolean ans[];
	static int[] present;

	static void gList(int[] from, int[] to) {
		graph = new int[n][];

		int[] freq = new int[n];
		for (int i = 0; i < m; i++) {
			freq[from[i]]++;
		}
		for (int i = 0; i < n; i++)
			graph[i] = new int[freq[i]];

		for (int i = 0; i < m; i++) {
			graph[from[i]][--freq[from[i]]] = to[i];
		}
	}

	static void dfs(int u, int par, boolean flag) {
		alreadyVisited[u] = true;
		if (++present[A[u]] > 1 || flag) {
			flag = true;
			ans[u] = true;
		}

		for (int v : graph[u]) {
			if (v != par && !alreadyVisited[v]) {
				if (flag){
					ans[v] = true;
				}
				dfs(v, u, flag);
			}
		}
		present[A[u]]--;
	}


	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = n - 1;
		A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		ans = new boolean[n];
		present = new int[1000 * 1000 + 1];
		int[] from = new int[2 * m];
		int[] to = new int[2 * m];
		alreadyVisited = new boolean[n];
		int p = 0;
		for (int i = 1; i <= n - 1; i++) {
			int u = s.nextInt() - 1;
			int v = s.nextInt() - 1;
			from[p] = u;
			to[p] = v;
			p++;
			from[p] = v;
			to[p] = u;
			p++;
		}
		m = p;
		gList(from, to);
		dfs(0, -1, false);
		int d = 0;
		for (boolean v : ans)
			if (!v)
				d++;
		System.out.println(d);
		s.close();
	}
}
