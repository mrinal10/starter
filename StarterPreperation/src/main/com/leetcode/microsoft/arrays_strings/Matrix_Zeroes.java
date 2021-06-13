package com.leetcode.microsoft.arrays_strings;

import java.util.List;

class TestObject {
    String size;
    String date;
    String name;
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
}
public class Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
            List
        int[] zeroes = new int[matrix[0].length];
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0) {
                    zeroes[j]= -1;
                    matrix[i][0] = 0;
                }
            }
        }

        //row wise
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j=0; j<matrix[i].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        //column wise
        for(int i=0; i<matrix[0].length; i++){
            if(zeroes[i] == -1) {
                for(int j=0; j<matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }
       
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};//{{0,1,2,0},{3,4,5,2},{1,3,1,5}};//{{0},{1}};//
        Matrix_Zeroes mz = new Matrix_Zeroes();
        mz.setZeroes(matrix);
    }
}
