package com.zero.graph;

import java.util.*;

public class Dijkstras {
	static Set<Integer> alreadyVisited;
	static PriorityQueue<Edge> pq;
	static Map<Integer, Integer> distanceMap;

	private void printSingleSourceShortestDistanceHlpr(Map<Integer, ArrayList<Edge>> g) {

		if (g.keySet().size() == alreadyVisited.size()) {
			return;
		}
		
		while (!pq.isEmpty()) {
			Edge edg = pq.poll();
			int curDestn = edg.v;
			if (!alreadyVisited.contains(curDestn)) {
				alreadyVisited.add(curDestn);
				distanceMap.put(curDestn, edg.w);
				ArrayList<Edge> edgeList = g.get(curDestn);
				for (int i = 0; i < edgeList.size(); i++) {
					Edge curEdge = edgeList.get(i);
					Edge cEdge = new Edge(curEdge.v, curEdge.w+edg.w);
					pq.add(cEdge);
				}
				printSingleSourceShortestDistanceHlpr(g);
			}
		}
	}

	void printSingleSourceShortestDistance(Map<Integer, ArrayList<Edge>> g, int s) {
		alreadyVisited = new HashSet<>();
		pq = new PriorityQueue<>();
		distanceMap = new TreeMap<>();

		alreadyVisited.add(s);
		distanceMap.put(s, 0);
		ArrayList<Edge> edgeList = g.get(s);
		for (int i = 0; i < edgeList.size(); i++) {
			Edge cedg = edgeList.get(i);
			pq.add(cedg);
		}
		printSingleSourceShortestDistanceHlpr(g);
		for (Map.Entry<Integer, Integer> entry : distanceMap.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
		System.out.println();
	}
}

class Edge implements Comparable<Edge> {
	int v;
	int w;

	Edge(int v, int w) {
		this.v = v;
		this.w = w;
	}

	public int compareTo(Edge o) {
		return this.w - o.w;
	}
}

class BeingZeroGraph {
	void insertEdge(HashMap<Integer, ArrayList<Edge>> g, int u, int v, int w) {
		Edge e1 = new Edge(v, w);
		ArrayList<Edge> edglst = new ArrayList<Edge>();
		if (g.containsKey(u)) {
			edglst = g.get(u);
		}
		edglst.add(e1);
		g.put(u, edglst);
		
		Edge e2 = new Edge(u, w);
		ArrayList<Edge> edglst1 = new ArrayList<Edge>();
		if (g.containsKey(v)) {
			edglst1 = g.get(v);
		}
		edglst1.add(e2);
		g.put(v, edglst1);
	}

	void printGraph(HashMap<Integer, ArrayList<Edge>> g) {
		for (Map.Entry<Integer, ArrayList<Edge>> entry : g.entrySet()) {
			ArrayList<Edge> edgeList = entry.getValue();
			int vertex = entry.getKey();
			System.out.print(vertex + " : ");
			for (int i = 0; i < edgeList.size(); i++) {
				System.out.print(edgeList.get(i).v + " (" + edgeList.get(i).w + ") ");
			}
			System.out.println();
		}
	}
}

class TestDijkstra {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		BeingZeroGraph bzg = new BeingZeroGraph();
		while (t-- > 0) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			HashMap<Integer, ArrayList<Edge>> g = new HashMap<>();
			for (int k = 0; k < v; k++)
				g.put(k, new ArrayList<Edge>());
			for (int i = 0; i < e; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int w = sc.nextInt();
				bzg.insertEdge(g, x, y, w);
			}
			//bzg.printGraph(g);
			int q = sc.nextInt();
			while (q-- > 0) {
				int nn = sc.nextInt();
				Dijkstras dijk = new Dijkstras();
				dijk.printSingleSourceShortestDistance(g, nn);
			}
			System.out.println();
		}
		sc.close();
	}
}
