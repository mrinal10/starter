package com.expedia.hiring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SizeOfQuery {
	private static HashMap<Integer, ArrayList<Integer>> graph;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		graph = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			graph.put(i, new ArrayList<>());
		}
		int q = sc.nextInt();
		while (q-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int k = sc.nextInt();

			ArrayList<Integer> aList = new ArrayList<>();
			if (graph.containsKey(x)) {
				aList = graph.get(x);
			}
			aList.add(y);
			graph.put(x, aList);

			aList = new ArrayList<>();
			if (graph.containsKey(y)) {
				aList = graph.get(y);
			}
			aList.add(x);
			graph.put(y, aList);
			System.out.println(getKSmallest(k, N));
		}
		sc.close();
	}

	private static int getKSmallest(int k, int n) {
		ArrayList<Integer> queue = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();

		for (int i = 1; i <= n; i++) {
			cnt = 0;
			graphTraversal(visited, i);
			if (cnt!=0) {
				queue.add(cnt);
			}
		}
		Collections.sort(queue);
		return queue.get(k-1);
	}

	private static void graphTraversal(Set<Integer> visited, int i) {
		if (!visited.contains(i)) {
			visited.add(i);
			cnt++;
			ArrayList<Integer> aList = graph.get(i);
			for (int j = 0; j < aList.size(); j++) {
				int node = aList.get(j);
				graphTraversal(visited, node);
			}
		}else{
			return;
		}
	}
}
