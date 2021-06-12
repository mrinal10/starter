package com.zero.graph;

import java.util.*;

public class P1Graph {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int nodes = sc.nextInt();
			int rel = sc.nextInt();
			TreeMap<Integer, List<Integer>> adjacencymatrix = new TreeMap<Integer, List<Integer>>();
			for (int i = 0; i < rel; i++) {
				int usr = sc.nextInt();
				int frnd = sc.nextInt();
				List<Integer> list;
				if (adjacencymatrix.get(usr) == null) {
					list = new ArrayList<>();
					list.add(frnd);
				} else {
					list = adjacencymatrix.get(usr);
					list.add(frnd);
				}
				adjacencymatrix.put(usr, list);
				if (adjacencymatrix.get(frnd) == null) {
					list = new ArrayList<>();
					list.add(usr);
				} else {
					list = adjacencymatrix.get(frnd);
					list.add(usr);
				}
				adjacencymatrix.put(frnd, list);
			}
			for (int i = 0; i < nodes; i++) {
				System.out.print(i + " : ");
				if (adjacencymatrix.get(i) != null) {
					for (int j = 0; j < adjacencymatrix.get(i).size(); j++) {
						System.out.print(adjacencymatrix.get(i).get(j) + " ");
					}
				}
				System.out.println();
			}
			System.out.println();
		}
		sc.close();
	}
}