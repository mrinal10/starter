package com.zero.backtracking;

public class TollGate {
	static int minCostOfTollTravel(int cost[][], int startLane){
		return mintollValueHelpr(cost, cost.length, cost[0].length, startLane-1, 0);
	}

	static int mintollValueHelpr(int[][] cost, int r, int c, int i, int j){
	  if(i<0 || i>=r)
	    return 100000;
	  if(j==c-1){
	    return cost[i][j];
	  }
	  int lft = cost[i][j]+mintollValueHelpr(cost, r, c, i-1, j+1);
	  int right = cost[i][j]+mintollValueHelpr(cost, r, c, i+1, j+1);
	  int strt = cost[i][j]+mintollValueHelpr(cost, r, c, i, j+1);
	  
	  return Math.min(lft, Math.min(right, strt));
	}
	public static void main(String[] args) {
		int[][] cost = {{2,9,1,7},{3,0,1,1},{6,2,1,8},{1,5,2,2},{7,3,2,9},{5,4,1,1}}; 
			//{{5,4,100,9},{2,2,200,4},{4,3,400,5},{6,5,1,1}};
		System.out.println(minCostOfTollTravel(cost, 4));
	}

}
