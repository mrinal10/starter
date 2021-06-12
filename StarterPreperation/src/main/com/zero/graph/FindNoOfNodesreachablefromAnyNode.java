package com.zero.graph;

import java.util.*;

public class FindNoOfNodesreachablefromAnyNode {

	static HashMap<Integer, List<Integer>> graph;
	static int[][] arr;
	static HashSet<Integer> alreadyVisited;

	private static void addNodes(int src, int destn) {
		List<Integer> list = new ArrayList<>();
		if (graph.containsKey(src)) {
			list = graph.get(src);
		}
		list.add(destn);
		graph.put(src, list);
	}

	private static void traverseGraph(int root, int curNode) {
		if (root == curNode) {
			arr[root - 1][curNode - 1] = 0;
		} else {
			if (alreadyVisited.contains(curNode)) {
				return;
			}
			if (arr[root - 1][curNode - 1] != -1) {
				return;
			}
			arr[root - 1][curNode - 1] = 1;
			alreadyVisited.add(curNode);
		}

		if (graph.containsKey(curNode)) {
			List<Integer> adjacentNodes = graph.get(curNode);
			for (int i = 0; i < adjacentNodes.size(); i++) {
				alreadyVisited.add(curNode);
				traverseGraph(curNode, adjacentNodes.get(i));
			}
		}
	}
	
	private static void reiterateGraph(){
		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i][j] == 1) {
					for (int k = 0; k < arr.length; k++) {
						if(arr[j][k] == 1){
							arr[i][k] = 1;
						}
					}
				}
			}
		}
	}

	private static int getNoOfReachableNodes() {
		for (int i = 1; i <= arr[0].length; i++) {
			alreadyVisited = new HashSet<>();
			alreadyVisited.add(i);
			traverseGraph(i, i);
		}
		reiterateGraph();
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			boolean flag = true;
			for (int j = 0; j < arr.length; j++) {
				if(arr[j][i] ==-1){
					flag = false;
					break;
				}
			}
			if (flag) {
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while (testCases-- > 0) {
			graph = new HashMap<>();
			int noOfNodes = sc.nextInt();
			arr = new int[noOfNodes][noOfNodes];
			for (int i = 0; i < noOfNodes; i++) {
				Arrays.fill(arr[i], -1);
			}
			int noOfVertex = sc.nextInt();
			while (noOfVertex-- > 0) {
				int src = sc.nextInt();
				int destn = sc.nextInt();
				addNodes(src, destn);
			}
			System.out.println(getNoOfReachableNodes());
		}
		sc.close();
	}

}
