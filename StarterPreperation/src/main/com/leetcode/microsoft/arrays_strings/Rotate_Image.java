package com.leetcode.microsoft.arrays_strings;

public class Rotate_Image {

    public void rotate(int[][] matrix) {
        int dim = matrix.length;

        int[][] newMatrix = new int[dim][dim];

        for(int i=0; i<dim; i++) {
            for(int j=0; j<dim; j++) {
                newMatrix[j][dim-1-i] = matrix[i][j];
            }
        }


        for(int i=0; i<dim; i++) {
            for(int j=0; j<dim; j++) {
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Rotate_Image rI = new Rotate_Image();
        rI.rotate(matrix);
    }
}
