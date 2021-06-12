package com.util.graph;

public class FloydWarshall {
	public static final int INF = 9999;
	private static void AllPairShortestPath(int[][] graph){
		int dist[][] = new int[graph.length][graph.length];
        int i, j, k;
 
        for (i = 0; i < graph.length; i++)
            for (j = 0; j < graph.length; j++)
                dist[i][j] = graph[i][j];
        
		for (k = 0; k < graph.length; k++) {
			for (j = 0; j < graph.length; j++) {
				for (i = 0; i < graph.length; i++) {
					if (dist[i][j] > dist[i][k]+dist[k][j]) {
						dist[i][j] = dist[i][k]+dist[k][j];
					}
				}
			}
		}
		printSolution(dist);
	}
	
	private static void printSolution(int dist[][])
    {
        System.out.println("The following matrix shows the shortest "+
                         "distances between every pair of vertices");
        for (int i=0; i<dist.length; ++i)
        {
            for (int j=0; j<dist.length; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }
 
	
	public static void main(String[] args) {
		/* Let us create the following weighted graph
        10
     (0)------->(3)
     |         /|\
     5 |          |
     |          | 1
     \|/         |
     (1)------->(2)
        3           */
     int graph[][] = { {0,   5,  INF, 10},
                       {2, 0,   3, INF},
                       {1, INF, 0,   1},
                       {8, INF, INF, 0}
                     };
     FloydWarshall a = new FloydWarshall();

     // Print the solution
     a.AllPairShortestPath(graph);
	}
}
