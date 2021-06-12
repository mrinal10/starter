package com.spoj.dynamicproblems;

import java.util.*;

public class CATER {
	int[][][] dp;
	private static HashMap<Integer, ArrayList<Integer>> trainNetwork;
	private static int pathCount = 0;
	private static void insertInNetwork(int src, int dest){
		ArrayList<Integer> listOfStations;
		if (trainNetwork.containsKey(src)) {
			listOfStations = trainNetwork.get(src);
			listOfStations.add(dest);
		}else{
			listOfStations = new ArrayList<>();
			listOfStations.add(dest);
		}
		trainNetwork.put(src, listOfStations);
	}
	
	private static void putThemInNetwork(int src, int dest){
		insertInNetwork(src, dest);
		insertInNetwork(dest, src);
	}
	
	private static void getPathCount(int hopsRemianing, int curHop, int fromHop){
		
		if (hopsRemianing==0) {
			pathCount += 1;
			return;
		}
		ArrayList<Integer> listOfHops = trainNetwork.get(curHop);
		ListIterator<Integer> it = listOfHops.listIterator();
		while (it.hasNext()) {
			int nextHop = it.next(); 
			if (nextHop!=fromHop) {
				getPathCount(hopsRemianing-1, nextHop, curHop);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfstations = sc.nextInt();
		int k = sc.nextInt();
		pathCount = 0;
		trainNetwork = new HashMap<>();
		for (int i = 0; i < numberOfstations-1; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			putThemInNetwork(src,dest);
		}
		for(Map.Entry<Integer, ArrayList<Integer>> entry : trainNetwork.entrySet()){
			getPathCount(k-1, entry.getKey(), entry.getKey());
		}
		System.out.println(pathCount/2);
		sc.close();
	}

}
