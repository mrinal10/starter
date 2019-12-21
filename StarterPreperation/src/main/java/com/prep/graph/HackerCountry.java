package com.prep.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.hackerrank.com/challenges/hacker-country/problem
public class HackerCountry {
	private static String calculate(int[][] tolls, int n) {
		Map<Integer, List<Integer>> tollMap = new HashMap<Integer, List<Integer>>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				List<Integer> list = new ArrayList<Integer>();
				if(tollMap.containsKey(i)) {
					list = tollMap.get(i);
				}
				list.add(tolls[i][j]);
				tollMap.put(i, list);
			}
		}
		System.out.println(getValueForEachStartPoint(0, 0, tollMap, n, 0, 0));
		
		return "";
	}
	
	private static String getValueForEachStartPoint(int startPoint, 
			int endPoint, Map<Integer, List<Integer>> tollMap, int n, int tollSoFar, int numberOfHops) {
		int tollCollected = tollSoFar+
		return "";
	}
	
	public static void main(String[] args) {
		
	} 	
}
