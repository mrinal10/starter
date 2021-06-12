package com.leetcode.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {
	List<Set<Integer>> allRoutesList = new ArrayList<>();
	Queue<String> q = new LinkedList<>();
	Set<String> visited = new HashSet<String>();

	public int numBusesToDestination(int[][] routes, int S, int T) {
		for (int i = 0; i < routes.length; i++) {
			Set<Integer> route = new HashSet<>();
			for (int j = 0; j < routes[0].length; j++) {
				route.add(routes[i][j]);
			}
			if (route.contains(S)) {
				numBusesToDestinationUtil(i, "" + S, T);
			}
			allRoutesList.add(route);
		}

		return 0;
	}

	public int numBusesToDestinationUtil(int indx, String S, int T) {
		visited.add(S);
		q.add(S);

		while (!q.isEmpty()) {
			int count = -1;
			Set<Integer> allbusStations = allRoutesList.get(indx);
			for (int stattin : allbusStations) {
				count = 1;
				if (stattin != Integer.parseInt(S.substring(S.length() - 1))) {
					if (stattin==T) {
						return count;
					}
					S += stattin;
					visited.add(S);
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[][] routes = { { 1, 2, 7 }, { 3, 6, 7 } };
		int S = 1;
		int T = 6;
		BusRoutes busRoutes = new BusRoutes();
		System.out.println(busRoutes.numBusesToDestination(routes, S, T));
	}

}
