package com.zero.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class FloydWarshall
{
	void printAllPairSD(HashMap<Integer, ArrayList<Edge> > g)
	{
		int numOfNodes = g.keySet().size();
		int[][] solutionMatrix = new int[numOfNodes][numOfNodes];
		for (int i = 0; i < solutionMatrix.length; i++) {
			for (int j = 0; j < solutionMatrix.length; j++) {
				solutionMatrix[i][j] = Integer.MAX_VALUE;
				if(i==j){
					solutionMatrix[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < solutionMatrix.length; i++) {
			ArrayList<Edge> listOfEdges = g.get(i);
			for (Iterator<Edge> iterator = listOfEdges.iterator(); iterator.hasNext();) {
				Edge edge = iterator.next();
				solutionMatrix[i][edge.v] = edge.w;
			}
		}
		
		
		for (int k = 0; k < solutionMatrix.length; k++) {
			for (int i = 0; i < solutionMatrix.length; i++) {
				for (int j = 0; j < solutionMatrix.length; j++) {
					if(solutionMatrix[i][k]+solutionMatrix[k][j] < solutionMatrix[i][j]){
						 solutionMatrix[i][j] = solutionMatrix[i][k]+solutionMatrix[k][j];
					}
				}
			}
		}
		
		for (int i = 0; i < solutionMatrix.length; i++) {
			for (int j = 0; j < solutionMatrix.length; j++) {
				System.out.print(solutionMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
