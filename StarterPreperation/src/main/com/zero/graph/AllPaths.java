package com.zero.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class AllPaths {
	static Map<Integer, ArrayList<Integer>> map;
	static HashSet<Integer> citiesVisited;
	static int sCity;
	static int dCity;

	static void insertMap(int srcCity, int dCity) {
		ArrayList<Integer> list = new ArrayList<>();
		if (map.containsKey(srcCity)) {
			list = map.get(srcCity);
		}
		list.add(dCity);
		map.put(srcCity, list);
	}

	static void populateMap(int sCity, int dCity) {
		insertMap(sCity, dCity);
		insertMap(dCity, sCity);
	}

	private static void ordering(int fromCity, int toCity, String path) {
		if (fromCity == dCity) {
			System.out.println(path);
			return;
		}

		ArrayList<Integer> mtrcList = map.get(fromCity);
		for (Integer dCity : mtrcList) {
			int dstnCt = dCity;

			if (!citiesVisited.contains(dstnCt)) {
				citiesVisited.add(dstnCt);
				ordering(dstnCt, toCity, path + "->" + dstnCt);
				citiesVisited.remove(dstnCt);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		while (testCase-- > 0) {

			int t = sc.nextInt();
			t = sc.nextInt();
			map = new HashMap<>();
			while (t > 0) {
				int srcCity = sc.nextInt();
				int cityDstn = sc.nextInt();

				populateMap(srcCity, cityDstn);
				t--;
			}
			int q = sc.nextInt();
			while(q-->0){
				citiesVisited = new HashSet<Integer>();
				sCity = sc.nextInt();
				dCity = sc.nextInt();
				if (sCity == dCity) {
					System.out.println(sCity+"->"+dCity);
					continue;
				}
				citiesVisited.add(sCity);
				ordering(sCity, dCity, sCity+"");
				citiesVisited.remove(sCity);
			}
			
		}
		sc.close();
	}

}
