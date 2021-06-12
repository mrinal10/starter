package com.hiring.deshaw22042018;

import java.util.Scanner;

public class Kpaths
{
    static final int numberOfVertices = 5; 
 
    int countwalks(int graph[][], int u, int v, int k)
    {
        if (k == 0 && u == v)           return 1;
        if (k == 1 && graph[u][v] == 1) return 1;
        if (k <= 0)                     return 0;
 
        int count = 0;
        for (int i = 0; i < numberOfVertices; i++) {
            if (graph[u][i] == 1) { 
                count += countwalks(graph, i, v, k-1);
            }
        }
        return count;
    }
 
    public static void main (String[] args) throws java.lang.Exception
    {
        int graph[][] = new int[][] { {-1, 1, 0, 0, 1},
	        {1, -1, 1, 0, 0},
	        {0, 1, -1, 1, 0},
	        {0, 0, 1, -1, 1},
	        {1, 0, 0, 1, -1}};
	     try {
			
	        int t;
	    	Scanner sc = new Scanner(System.in);
	    	t = sc.nextInt();
	    	for(int i =0; i<t; i++) {
	    		int u = 0, v = 0;
		        int k = sc.nextInt();
		        Kpaths p = new Kpaths();
		        System.out.println(p.countwalks(graph, u, v, k));
	    	}

		} catch (Exception e) {
			// TODO: handle exception
		}   
    }
}
