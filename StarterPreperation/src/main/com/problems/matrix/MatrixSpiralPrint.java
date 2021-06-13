package com.problems.matrix;

import java.util.ArrayList;
import java.util.List;

public class MatrixSpiralPrint {
	public static List<Integer> spiralOrder(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		List<Integer> ll = new ArrayList();
		int rowStart = 0;
		int rowEnd = m;
		int colStart = 0;
		int colEnd = n;
		
		while(rowStart<rowEnd && colStart<colEnd) {
			for(int i=colStart; i<colEnd; i++) {
				ll.add(a[rowStart][i]);
			}
			rowStart++;
			
			for(int i=rowStart; i<rowEnd; i++) {
				ll.add(a[i][colEnd-1]);
			}
			colEnd--;
			
			if(rowStart<rowEnd) {
				for(int i=colEnd-1; i>=colStart; i--) {
					ll.add(a[rowEnd-1][i]);
				}
				rowEnd--;
			}
			
			if(colStart<colEnd) {
				for(int i=rowEnd-1; i>=rowStart; i--) {
					ll.add(a[i][colStart]);
				}
				colStart++;
			}
		}
		return ll;
	}

	public static void main(String[] args) {
		int R = 3;
        int C = 6;
        int a[][] = { { 7 },
                      { 9 },
                      { 6 } };
        for(Integer i : spiralOrder(a)) {
        	System.out.println(i);
        }
        
        
	}
}
