package com.zero.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class DividenRule {
    private int time;
    private static HashMap<Integer, ArrayList<Integer>> graphMap;
    public Set<Integer> findarticulationPoints() {
        time = 0;
        Set<Integer> visited = new HashSet<>();
        Set<Integer> articulationPoints = new HashSet<>();
        int startVertex = graphMap.keySet().iterator().next();

        Map<Integer, Integer> visitedTime = new HashMap<>();
        Map<Integer, Integer> lowTime = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();

        DFS(visited,articulationPoints,startVertex, visitedTime, lowTime, parent);
        return articulationPoints;
    }

    private void DFS(Set<Integer> visited,
            Set<Integer> articulationPoints, int vertex,
            Map<Integer, Integer> visitedTime,
            Map<Integer, Integer> lowTime, Map<Integer, Integer> parent) {
        visited.add(vertex);
        visitedTime.put(vertex, time);
        lowTime.put(vertex, time);
        time++;
        int childCount =0;
        boolean isArticulationPoint = false;
        for(int adj : graphMap.get(vertex)){
            if(parent.containsKey(vertex) && adj == parent.get(vertex)) {
                continue;
            }
            
            if(!visited.contains(adj)) {
                parent.put(adj, vertex);
                childCount++;
                DFS(visited, articulationPoints, adj, visitedTime, lowTime, parent);

                if(visitedTime.get(vertex) <= lowTime.get(adj)) {
                    isArticulationPoint = true;
                } else {
                    lowTime.compute(vertex, (currentVertex, time) ->
                        Math.min(time, lowTime.get(adj))
                    );
                }

            } else { 
                lowTime.compute(vertex, (currentVertex, time) ->
                                Math.min(time, visitedTime.get(adj))
                );
            }
        }
        if((parent.get(vertex) == null && childCount >= 2) || parent.get(vertex) != null && isArticulationPoint ) {
            articulationPoints.add(vertex);
        }
        
    }
    
    private static void addSrcDestn(int s, int d){
    	ArrayList<Integer> list = new ArrayList<>();
    	if (graphMap.containsKey(s)) {
			list = graphMap.get(s);
		}
    	list.add(d);
    	graphMap.put(s, list);
    }
    
    private static void addtoMap(int s, int d){
    	addSrcDestn(s, d);
    	addSrcDestn(d, s);
    }

    public static void main(String args[]){
    	
    	Scanner sc = new Scanner(System.in);
    	int numberOfNodes = sc.nextInt();
    	int numberOfRelations = sc.nextInt();
    	graphMap = new HashMap<>();
    	while (numberOfRelations-->0) {
    		int src = sc.nextInt();
    		int destn = sc.nextInt();
    		addtoMap(src, destn);
		}
    	sc.close();
    	DividenRule ap = new DividenRule();
        Set<Integer> aPoints = ap.findarticulationPoints();
        System.out.println(aPoints.size());
    }
}
