package com.zero.recursion;

public class MinCostPathRecursive {

	int minCostPathHlpr(int[][] ar, int r, int c, int rlim, int clim, int cCost){
		if(r>rlim || c>clim){
			return Integer.MAX_VALUE;
		}
		cCost = cCost+ar[r][c];
		if(r==rlim && c==clim){
			return cCost;
		}
		int right = minCostPathHlpr(ar, r+1, c, rlim, clim, cCost);
		int down = minCostPathHlpr(ar, r, c+1, rlim, clim, cCost);
		int diam = minCostPathHlpr(ar, r+1, c+1, rlim, clim, cCost);
		return Math.min(Math.min(right, down),diam);
	}
	
	int minCostPath(int a[][]){
		return minCostPathHlpr(a, 0, 0, a.length-1, a[0].length-1, 0);
	}
	public static void main(String[] args) {
		int maze[][] = { { 1, 2, 3},{4, -9, 6},{7, 8, 9} };
		MinCostPathRecursive recrsv = new MinCostPathRecursive();
		System.out.println(recrsv.minCostPath(maze));
	}

}
