package com.leetcode;

public class Problem1578 {
	public int minCost(String s, int[] cost) {
		char[] cArr = s.toCharArray();
		String newS = ""+cArr[0];
		int i=0;
		while( i<cArr.length-1) {
			if(cArr[i] == cArr[i+1]) {
				i++;
			}else {
				newS += cArr[i];
			}
			i++;
		}
		System.out.println(newS);
		return 0;
	}
	
	public static void main(String[] args) {
		Problem1578 pr = new Problem1578();
		int[] cost = {1,2,3,4,5,6,7,8};
		System.out.println(pr.minCost("aabbccdd", cost));
	}
}
