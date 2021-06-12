package com.zero.graph;

import java.util.*;

public class Dfs {
	static void dfs(HashMap<Integer, ArrayList<Integer>> g) {
		Stack<Integer> nodeStack = new Stack<>();
		nodeStack.push(0);
		int nodeSize = g.keySet().size();
		for (int i = 0; i < nodeSize; i++) {
			if (nodeStack.empty() && g.containsKey(i)) {
				ArrayList<Integer> nodeList = g.get(i);
				g.remove(i);
				System.out.print(i+" ");
				getValuesinStack(nodeStack, nodeList);
			}
			while (!nodeStack.isEmpty()) {
				int stackTop = nodeStack.pop();
				if (g.containsKey(stackTop)) {
					System.out.print(stackTop + " ");
					getValuesinStack(nodeStack, g.get(stackTop));
					g.remove(stackTop);
				}
			}
			
		}
	}

	static Stack<Integer> getValuesinStack(Stack<Integer> stk, ArrayList<Integer> list) {
		Collections.reverse(list);
		for (int i = 0; i < list.size(); i++) {
			stk.push(list.get(i));
		}
		return stk;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int nodes = sc.nextInt();
			System.err.println(nodes);
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
			dfs(adjacencymatrix);
			System.out.println();
		}
		sc.close();
	}

}
