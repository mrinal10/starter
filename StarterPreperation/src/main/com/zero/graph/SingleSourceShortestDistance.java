package com.zero.graph;

import java.util.*;

public class SingleSourceShortestDistance {

	static Set<Integer> alreadyVisited;
	static Queue<Integer> nodeQueue;
	static int[] arr;

	static void BFS(HashMap<Integer, ArrayList<Integer>> g) {
		if (nodeQueue.isEmpty()) {
			return;
		}
		int node = nodeQueue.poll();
		
		alreadyVisited.add(node);
		ArrayList<Integer> neighbouringNodeList = g.get(node);
		for (Iterator<Integer> iterator = neighbouringNodeList.iterator(); iterator.hasNext();) {
			Integer integer = iterator.next();
			if (!alreadyVisited.contains(integer)) {
				nodeQueue.add(integer);	
				arr[integer] = arr[node]+1;
				alreadyVisited.add(integer);
			}
		}
		BFS(g);
	}

	static ArrayList<Integer> shortestDistanceLength(HashMap<Integer, ArrayList<Integer>> g, int s) {
		arr = new int[g.keySet().size()];
		Arrays.fill(arr, Integer.MAX_VALUE);
		ArrayList<Integer> list = new ArrayList<>();
		alreadyVisited = new HashSet<>();
		nodeQueue = new LinkedList();
		nodeQueue.add(s);
		arr[s] = 0;
		BFS(g);
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		return list;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
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
			ArrayList<Integer> distanceArr = shortestDistanceLength(g, 2);
			for (Iterator<Integer> iterator = distanceArr.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				System.out.print(integer + " ");
			}
		}
		sc.close();

	}

}
