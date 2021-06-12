package com.zero.backtracking;

public class RatinMazeBackTracking {

	void generateSolution(int[][] m, int[][] s) {
		generateSolutionHelper(m, s, m.length, m[0].length, 0, 0);
	}
	
	boolean generateSolutionHelper(int[][] m, int[][] s, int r, int c, int i, int j) {
		if(i==r-1 && j==c-1){
			s[i][j] = 1;
			return true;
		}
		if(i>=r || j>=c || i<0 || j<0){
			return false;
		}
		if(s[i][j] == 0 && m[i][j]==1){
			s[i][j] = 1;
			//printsolnMatrix(s); //uncomment to show soln matrix gen at each step
			if(generateSolutionHelper(m, s, r, c, i+1, j)){
				return true;
			}else if(generateSolutionHelper(m, s, r, c, i, j+1)){
				return true;
			}else if(generateSolutionHelper(m, s, r, c, i, j-1)){
				return true;
			}else if(generateSolutionHelper(m, s, r, c, i-1, j)){
				return true;
			}
			s[i][j]=0;
			return false;
		}
		return false;
	}
	
	private void printsolnMatrix(int[][] soln){
		for (int i = 0; i < soln.length; i++) {
			for (int j = 0; j < soln[0].length; j++) {
				System.out.print(soln[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(">>>>>>>>");
	}
	
	public static void main(String[] args) {
		int[][] maze = {{1,1,1,1,1}, {0,0,0,0,1}, {1,1,1,0,1}, {1,0,1,1,1}, {1,0,0,0,1}, {1,1,1,1,0}, {1,1,0,1,1},{1,0,1,1,0},{1,0,1,0,1},{0,0,1,1,1}};
			//{{1,1,1,1,1},{0,0,1,1,0},{1,0,1,1,0},{0,1,0,1,1},{0,0,0,0,1}};
		//{{1,0,0,0},{1,1,1,1},{0,0,1,0},{1,1,1,1}};
		int[][] soln = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		RatinMazeBackTracking rinmzBtrckng = new RatinMazeBackTracking();
		rinmzBtrckng.generateSolution(maze, soln);
		rinmzBtrckng.printsolnMatrix(soln);
	}
}
