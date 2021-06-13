package com.practice.optum;

import java.util.Arrays;
import java.util.List;

public class Problem2 {
	public static void main(String[] args) {
		int n = 10;
		List<Integer> start = Arrays.asList(1, 2, 5, 8);
		List<Integer> finish = Arrays.asList(2, 2, 6, 10);
		System.out.println(widestGap(n, start, finish));
	}
	
	public static int widestGap(int n, List<Integer> start, List<Integer> finish) {
		int[] road = new int[n];
		for(int i=0; i<start.size(); i++) {
			int strt = start.get(i);
			int end = finish.get(i);
			
			for(int j=strt-1; j<end; j++) {
				road[j] = 1;
			}
		}
		
		int startPt = 0;
		int endPt = 0;
		int maxLen = 0;
		boolean isStartingFaced = false;
		for(int i=0; i<n; i++) {
			if(road[i]==0) {
				if(!isStartingFaced) {
					startPt = i;
					endPt = i;
					isStartingFaced = true;
				} else {
					endPt = i;
				}
			} else {
				if(isStartingFaced) {
					int temp = endPt - startPt + 1;
					if(temp>maxLen) {
						maxLen = temp;
					}
				}
				isStartingFaced = false;				
			}
		}
		if(isStartingFaced) {
			int temp = endPt - startPt + 1;
			if(temp>maxLen) {
				maxLen = temp;
			}
		}
		return maxLen;
	}
}
