package com.zero.graph;

import java.util.*;

public class ShortestPathCount {
	static HashSet<Integer> citiesVisited;

	private static int ordering(HashMap<Integer, ArrayList<Integer>> g, int fromCity, int toCity, int hopCount) {
	  if (fromCity == toCity) {
	    return hopCount;
	  }

	  ArrayList<Integer> mtrcList = g.get(fromCity);
	  int minV = Integer.MAX_VALUE;
	  for (Integer dCity : mtrcList) {
	    int dstnCt = dCity;
	    
	    
	    if (!citiesVisited.contains(dstnCt)) {
	      citiesVisited.add(dstnCt);
	      minV = Math.min(minV, ordering(g, dstnCt, toCity, hopCount+1));
	      citiesVisited.remove(dstnCt);
	    }
	  }
	  return minV;
	}

	int shortestDistanceLength(HashMap<Integer, ArrayList<Integer> > g, int s, int d){
		citiesVisited = new HashSet<Integer>();
	    if (s == d) {
			return 0;
	    }else{
	      citiesVisited.add(s);
	      int cnt = ordering(g, s, d, 0);
	      citiesVisited.remove(d);
	  	  return cnt;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
