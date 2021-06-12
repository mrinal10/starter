package com.util.graph;

import java.util.LinkedList;
import java.util.ListIterator;
/**
 * 
 * @author mrinal
 *
 */
public class DFSGraph {
	private int noOfVertices;
	private LinkedList<Integer> adjacencyList[];
	
	@SuppressWarnings("unchecked")
	public DFSGraph(int v) {
		noOfVertices = v;
		adjacencyList = new LinkedList[noOfVertices];
		for (int i = 0; i < v; i++) {
			adjacencyList[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int ver, int wt){
		adjacencyList[ver].add(wt);
	}
	
	public void DFS(int v){
		boolean visited[] = new boolean[noOfVertices];
		DfsUtil(v, visited);
	}
	
	
	private void DfsUtil(int v, boolean[] visited){
		visited[v] = true;
		ListIterator<Integer> i = adjacencyList[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n]) {
				System.out.print(" -----> "+n);
				DfsUtil(n, visited);
			}
		}
	}
}

class TestDFS{
	public static void main(String[] args) {
		DFSGraph g = new DFSGraph(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.DFS(2);
	}
}
