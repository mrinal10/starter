package com.leetcode.microsoft.arrays_strings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int startRow = 0;
        int endRow = matrix.length;

        int startCol = 0;
        int endCol = matrix[0].length;

        while(startRow <  endRow && startRow < endRow) {
            for(int i = startCol; i < endCol; ++i) {
                System.out.print(matrix[startRow][i] +" ");
                result.add(matrix[startRow][i]);
            }
            startRow++;

            for(int i = startRow; i < endRow; ++i) {
                System.out.print(matrix[i][endCol-1] + " ");
                result.add(matrix[i][endCol-1]);
            }
            endCol--;
            
            if(startRow < endRow) {
                for(int i = endCol-1; i >= startCol; --i){
                    System.out.print(matrix[endRow-1][i] + " ");
                    result.add(matrix[endRow-1][i]);
                }
                endRow--;
            }

            if(startCol < endCol) {
                for(int i = endRow-1; i >= startRow; --i){
                    System.out.print(matrix[i][startCol] + " ");
                    result.add(matrix[i][startCol]);
                }
                startCol++;            
            }        
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //{{1,2,3},{4,5,6},{7,8,9}};

        SpiralMatrix sp = new SpiralMatrix();
        sp.spiralOrder(matrix);
    }
}
