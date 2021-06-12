package com.hiring.seclore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class GraphNode {
	int destinationVertex;
	int weight;

	public GraphNode(int dVertex, int wt) {
		destinationVertex = dVertex;
		weight = wt;
	}

	public int getDestinationVertex() {
		return destinationVertex;
	}

	public int getWeight() {
		return weight;
	}
}

class CustomClass {
	Long price;
	Set<Integer> allVerticesCovered;
	
	public CustomClass(Long weight, Set<Integer> vertices) {
		price = weight;
		allVerticesCovered = vertices;
	}
}

public class Problem1 {
	private static HashMap<Integer, List<GraphNode>> graph;
	private static HashMap<String, CustomClass> srcDetnMap;
	private static Set<Integer> visited;
	private static Set<Integer> customSet;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sizeOfArr = sc.nextInt();
		int[] a = new int[sizeOfArr];
		int[] b = new int[sizeOfArr];

		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt();
		}

		int numberOfTransformation = sc.nextInt();
		graph = new HashMap<>();

		srcDetnMap = new HashMap<String, CustomClass>();
		for (int i = 0; i < numberOfTransformation; i++) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			int w = sc.nextInt();

			GraphNode g = new GraphNode(d, w);
			List<GraphNode> existingList = new ArrayList<>();
			if (graph.containsKey(s)) {
				existingList = graph.get(s);
			}
			existingList.add(g);
			graph.put(s, existingList);

			GraphNode g1 = new GraphNode(s, w);
			existingList = new ArrayList<>();
			if (graph.containsKey(d)) {
				existingList = graph.get(d);
			}
			existingList.add(g1);
			graph.put(d, existingList);
		}
		long minCost = 0;
		visited = new HashSet<>();
		
		for (int j = 0; j < b.length; j++) {
			customSet = new HashSet<>();
			long curCost = getMinCost(a[j], b[j]);
			String key = a[j]+":"+b[j];
			srcDetnMap.put(key, new CustomClass(curCost, customSet));
			key = b[j]+":"+a[j];
			srcDetnMap.put(key, new CustomClass(curCost, customSet));
			
			minCost += curCost;
		}
		System.out.println(minCost);
		sc.close();
	}


	private static long getMinCost(int src, int dstn) {
		if (src == dstn) {
			return 0;
		}
		if (visited.contains(src) || !graph.containsKey(src)) {
			return 2000000000;
		}
		String sdstn = src+":"+dstn ;
		if (srcDetnMap.containsKey(sdstn)) {
			return srcDetnMap.get(sdstn).price;
		}
		
		long minValue = 2000000000;
		visited.add(src);
		long minTillNow = 2000000000;
		long value = 0;
		
		
		List<GraphNode> midHopLists = graph.get(src);
		Set<Integer> alreadyTraversed = new HashSet<>();
		int midHop = -1;
		
		for (int i = 0; i < midHopLists.size(); i++) {
			midHop = midHopLists.get(i).getDestinationVertex();
			String sdstn1 = src+":"+midHop;
			if (srcDetnMap.containsKey(sdstn1)) {
				value = srcDetnMap.get(sdstn1).price;
				alreadyTraversed = srcDetnMap.get(sdstn1).allVerticesCovered;
				minValue = value + specificOptimization(alreadyTraversed, midHop);
			}else{
				value = midHopLists.get(i).getWeight();
				minValue = value + Math.min(minValue, getMinCost(midHop, dstn));
			}
			if (minTillNow>minValue) {
				customSet = visited;
				minTillNow = minValue;
			}
		}
		
		
		visited.remove(src);
		return minTillNow;
	}
	
	private static long specificOptimization(Set<Integer> alreadyTraversed, int midHop){
		long minV = 2000000000;
		if (alreadyTraversed.size()!=0 && midHop!=-1) {
			List<GraphNode> graphNodeList = graph.get(midHop);
			for (Iterator<GraphNode> iterator = graphNodeList.iterator(); iterator.hasNext();) {
				GraphNode graphNode = (GraphNode) iterator.next();
				if (!alreadyTraversed.contains(graphNode.destinationVertex)) {
					long n = getMinCost(midHop, graphNode.destinationVertex);
					if (minV>n) {
						minV = n;
					}
				}
			}
		}
		return minV;
	}
}
