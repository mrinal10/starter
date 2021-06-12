package com.hiring.eskofresher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class CostMatrice {
	String src;
	String destn;
	int price;

	public CostMatrice(String s, String d, int c) {
		src = s;
		destn = d;
		price = c;
	}
}

public class AllPaths {
	static TreeMap<Integer, String> allPathsMap;
	static Map<String, ArrayList<CostMatrice>> map;
	static HashSet<String> citiesVisited;
	static String sCity;
	static String dCity;

	static void insertMap(String srcCity, CostMatrice c) {
		ArrayList<CostMatrice> list = new ArrayList<>();
		if (map.containsKey(srcCity)) {
			list = map.get(srcCity);
		}
		list.add(c);
		map.put(srcCity, list);
	}

	static void populateMap(String sCity, String dCity, int price) {
		CostMatrice c1 = new CostMatrice(sCity, dCity, price);
		insertMap(sCity, c1);
//		CostMatrice c2 = new CostMatrice(dCity, sCity, price);
//		insertMap(dCity, c2);
	}

	private static void ordering(String fromCity, String toCity, int cost, String path) {
		if (fromCity.equals(dCity)) {
			allPathsMap.put(cost, path);
			return;
		}

		ArrayList<CostMatrice> mtrcList = map.get(fromCity);
		for (CostMatrice costMatrice : mtrcList) {
			String dstnCt = costMatrice.destn;
			int cst = costMatrice.price;
			if (!citiesVisited.contains(dstnCt)) {
				citiesVisited.add(dstnCt);
				ordering(dstnCt, toCity, cost + cst, path + " " + dstnCt);
				citiesVisited.remove(dstnCt);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sCity = sc.next();
		dCity = sc.next();
		int t = 3;
		map = new HashMap<>();
		while (t > 0) {
			String srcCity = sc.next();
			String cityDstn = sc.next();
			int cost = sc.nextInt();
			populateMap(srcCity, cityDstn, cost);
			t--;
		}
		citiesVisited = new HashSet<String>();
		allPathsMap = new TreeMap<>();
		citiesVisited.add(sCity);
		ordering(sCity, dCity, 0, sCity);
		for (Map.Entry<Integer, String> entry : allPathsMap.entrySet()) {
			System.out.println(entry.getValue() + " " + entry.getKey());
		}
		sc.close();
	}

}
