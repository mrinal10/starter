package com.problems.matrix;

public class Problem695{
	public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
       for(int i=0; i<grid.length; i++) {
           for(int j=0; j<grid[0].length; j++) {
               if(grid[i][j]==1) {
                   int islandArea = dfs(grid, i, j);
                   if(islandArea>maxArea) {
                       maxArea = islandArea;
                   }
               }
           }
       }
        return maxArea;
    }
    
    int dfs(int[][] grid, int i, int j) {
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
           return (	dfs(grid, i+1, j) + 
        		    dfs(grid, i-1, j) + 
        		    dfs(grid, i, j-1) + 
        		    dfs(grid, i, j+1) )
        		   
        		   + 1; 
        }
        return 0;
    }
	
	
	public static void main(String[] args) throws java.lang.Exception
    {
        int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                                  { 0, 1, 0, 0, 1 },
                                  { 1, 0, 0, 1, 1 },
                                  { 0, 0, 0, 0, 0 },
                                  { 1, 0, 1, 0, 1 } };
                                  Problem695 I = new Problem695();
        System.out.println("Number of islands is: " + I.maxAreaOfIsland(M));
    }
}
