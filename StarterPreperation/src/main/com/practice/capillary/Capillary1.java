package com.practice.capillary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Mrinal
 *
 */

class pair{
	int source;
	int destination;
	pair(int s, int d){
		source = s;
		destination =d;
	}
	
 	@Override
    public boolean equals(Object obj)
    {
	 	pair pairValue = (pair) obj;
        return (pairValue.source == this.source && pairValue.destination == this.destination);
    }
 	
 	@Override
    public int hashCode() {
        int result = Integer.parseInt(String.valueOf(source)+String.valueOf(destination)); 
        return result;
    }
 
}

public class Capillary1 {

	private int v;
	private static int k;
	private static HashMap<pair, Integer> pairCost = new HashMap<>();
	private static ArrayList<Integer>[] adjList;
	private static ArrayList<List<Integer>> allPathfromSrctoDest;
	
	public Capillary1(int vertices) {
		this.v = vertices;
		initAdjList();
	}
	
	private void initAdjList() {
		adjList = new ArrayList[v];
		for (int i = 0; i < v; i++) {
			adjList[i] = new ArrayList<>();
		}
	}

	public void addEdge(int u, int v) {
		adjList[u].add(v);
	}

	private void allPaths(int s, int d ) {
		boolean[] isVisited = new boolean[v];
		ArrayList<Integer> pathList = new ArrayList<>();
		pathList.add(s);
		allPathsUtil(s, d, isVisited, pathList);
	}
	
	private static int calculateOptimalDistance(){
		if (allPathfromSrctoDest.isEmpty()) {
			return -1;
		}
		
		int optimalCost = Integer.MAX_VALUE;
		for (int i = 0; i < allPathfromSrctoDest.size(); i++) {
			int cost = 0;
			List<Integer> path = allPathfromSrctoDest.get(i);
			
			for (int j = 0; j < path.size()-1; j++) {
				int src = path.get(j);
				int dest = path.get(j+1);
				
				pair p = new pair(src, dest);
				Integer distance = pairCost.get(p);
				if (j!=0) {
					cost += k;
				}
				cost = cost + distance;	
			}
			if (path.size()==1) {
				cost += 1;
			}
			if (cost<optimalCost) {
				optimalCost = cost;
			}
		}
		return optimalCost;
	}
	
	private static void allPathsUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList) {
		isVisited[u] = true;
		if (u.equals(d)) {
			List<Integer> pathList = new ArrayList<>();
			for (int i = 0; i < localPathList.size(); i++) {
				pathList.add(localPathList.get(i));
			}
			allPathfromSrctoDest.add(pathList);
		} else {
			for (Integer i : adjList[u]) {
				if (!isVisited[i]) {
					localPathList.add(i);
					allPathsUtil(i, d, isVisited, localPathList);
					localPathList.remove(i);
				}
			}
		}
		isVisited[u] = false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int j = 0; j < t; j++) {
			int N = sc.nextInt();
			int P = sc.nextInt();
			int M = sc.nextInt();
			Capillary1 g = new Capillary1(N);
			try {
				for (int i = 0; i < P; i++) {
					int source = sc.nextInt();
					source = source-1;
					int destination = sc.nextInt();
					destination = destination - 1;
					int distance = sc.nextInt();
					
					pair p = new pair(source, destination);
					pairCost.put(p, distance);
					g.addEdge(source, destination);
					
					pair p1 = new pair(destination, source);
					pairCost.put(p1, distance);
					g.addEdge(destination, source);
				}
				System.out.println("Case:"+(j+1));
				for (int i = 0; i < M; i++) {
					int s = sc.nextInt();
					s = s-1;
					int d = sc.nextInt();
					d=d-1;
					allPathfromSrctoDest = new ArrayList<>();
					
					g.allPaths(s, d);
					System.out.println(calculateOptimalDistance());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sc.close();
	}
}