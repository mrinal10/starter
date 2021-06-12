package com.zero.graph;

import java.util.*;

public class ConnectedComponentsCount {
	
	static Set<Integer> alreadyVisited;
	static Set<Integer> allNodes;
	
	static void DFS(int node, HashMap<Integer, ArrayList<Integer>> g){
		if (alreadyVisited.contains(node)) {
			return;
		}
		alreadyVisited.add(node);
		allNodes.remove(node);
		ArrayList<Integer> neighbouringNodeList = g.get(node);
		for (Iterator<Integer> iterator = neighbouringNodeList.iterator(); iterator.hasNext();) {
			int curNode = iterator.next();
			DFS(curNode, g);
		}
	}
	
	
	static int connectedComponentsCount(HashMap<Integer, ArrayList<Integer>> g) {
		alreadyVisited = new HashSet<>();
		allNodes = new HashSet<Integer>();
		Set<Integer> keys = g.keySet();
		for (Integer integer : keys) {
			allNodes.add(integer);
		}
		int cnt = 0;
		while (!allNodes.isEmpty()) {
			int randomNode = (int) allNodes.toArray()[0];
			DFS(randomNode, g);
			cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
			int nn = sc.nextInt();
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int s = sc.nextInt();
				int d = sc.nextInt();
				ArrayList<Integer> list = new ArrayList<>();
				if (g.containsKey(s)) {
					list = g.get(s);
				}
				list.add(d);
				g.put(s, list);
				
				list = new ArrayList<>();
				if (g.containsKey(d)) {
					list = g.get(d);
				}
				list.add(s);
				g.put(d, list);
			}
			System.out.println(connectedComponentsCount(g));
		}
		sc.close();

	}

}
