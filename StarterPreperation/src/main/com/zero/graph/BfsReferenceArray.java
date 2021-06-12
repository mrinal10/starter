package com.zero.graph;

import java.util.*;

public class BfsReferenceArray {
	
	static void bfs(HashMap<Integer, ArrayList<Integer> > g, int s){
		ArrayList<Integer> nodesAlreadydiscovered = new ArrayList<>();
		Queue<Integer> nodeQueue = new LinkedList<Integer>();
		nodeQueue.add(s);
		int nodeSize = g.keySet().size();
		for (int i = 0; i < nodeSize; i++) {
			if (nodeQueue.isEmpty() && g.containsKey(i) && !nodesAlreadydiscovered.contains(i)) {
				ArrayList<Integer> nodeList = g.get(i);
				nodesAlreadydiscovered.add(i);
				System.out.print(i+" ");
				getValuesinQueue(nodeQueue, nodeList);
			}
			while (!nodeQueue.isEmpty()) {
				int stackTop = nodeQueue.poll();
				if (g.containsKey(stackTop) && !nodesAlreadydiscovered.contains(stackTop)) {
					nodesAlreadydiscovered.add(stackTop);
					System.out.print(stackTop + " ");
					getValuesinQueue(nodeQueue, g.get(stackTop));
				}
			}
			
		}
	}

	static Queue<Integer> getValuesinQueue(Queue<Integer> qu, ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			qu.add(list.get(i));
		}
		return qu;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int nodes = sc.nextInt();
			int rel = sc.nextInt();
			HashMap<Integer, ArrayList<Integer>> adjacencymatrix = new HashMap<Integer, ArrayList<Integer>>();
			for (int i = 0; i < rel; i++) {
				int usr = sc.nextInt();
				int frnd = sc.nextInt();
				ArrayList<Integer> list;
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
			bfs(adjacencymatrix, nodes);
			System.out.println();
		}
		sc.close();
	}

}
