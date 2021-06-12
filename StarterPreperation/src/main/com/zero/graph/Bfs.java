package com.zero.graph;

import java.util.*;

public class Bfs {
	public static HashMap<Integer, ArrayList<Integer>> copy(
		    HashMap<Integer, ArrayList<Integer>> original)
		{
		    HashMap<Integer, ArrayList<Integer>> copy = new HashMap<Integer, ArrayList<Integer>>();
		    for (Map.Entry<Integer, ArrayList<Integer>> entry : original.entrySet())
		    {
		        copy.put(entry.getKey(), new ArrayList<Integer>(entry.getValue()));
		    }
		    return copy;
		}
	static void bfs(HashMap<Integer, ArrayList<Integer> > g, int s){
		HashMap<Integer, ArrayList<Integer> > copyMap;
		  for(int i=0; i<s; i++){
			  copyMap = copy(g);
		    bfsUtil(copyMap, i);
		    System.out.println();
		  }
		}

	static void bfsUtil(HashMap<Integer, ArrayList<Integer> > g, int k){
		Queue<Integer> nodeQueue = new LinkedList<Integer>();
		nodeQueue.add(k);
		int nodeSize = g.keySet().size();
		for (int i = 0; i < nodeSize; i++) {
			if (nodeQueue.isEmpty() && g.containsKey(i)) {
				ArrayList<Integer> nodeList = g.get(i);
				g.remove(i);
				System.out.print(i+" ");
				getValuesinStack(nodeQueue, nodeList);
			}
			while (!nodeQueue.isEmpty()) {
				int stackTop = nodeQueue.poll();
				if (g.containsKey(stackTop)) {
					System.out.print(stackTop + " ");
					getValuesinStack(nodeQueue, g.get(stackTop));
					g.remove(stackTop);
				}
			}
			
		}
	}

	static Queue<Integer> getValuesinStack(Queue<Integer> qu, ArrayList<Integer> list) {
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
