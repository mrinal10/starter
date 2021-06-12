package com.hotstar.hiring06072018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			Map<String, ArrayList<Integer>> list = new HashMap<>();
			int n = sc.nextInt();
			for (int j = 0; j < n; j++) {
				String s = sc.next();
				int cost = sc.nextInt();
				if (list.containsKey(s)) {
					ArrayList<Integer> costList = list.get(s);
					costList.add(cost);
				}else{
					ArrayList<Integer> costList = new ArrayList<>();
					costList.add(cost);
					list.put(s, costList);
				}
			}
			int maxCost = 0;
			String festivalName = "";
			int curcost = 0;
	        for (String name : list.keySet()) {
	        	curcost = 0;
	        	ArrayList<Integer> cost = list.get(name);
	        	Collections.sort(cost);
	        	Collections.reverse(cost);
	        	for (int j = 0; j < 3 && j<cost.size(); j++) {
	        		curcost += cost.get(j);
				}
	        	if (curcost>maxCost) {
					maxCost = curcost;
					festivalName = name;
				}
	        }
	        System.out.println(festivalName+" "+maxCost);
		}
		
		sc.close();
	}
}
