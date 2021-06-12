package com.zero.exam;

import java.util.ArrayList;
import java.util.Scanner;

class pair{
	int r;
	int c;
	pair(int ro, int col){
		r = ro;
		c = col;
	}
}

public class Problem1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<pair> list = new ArrayList<>();
		int row = sc.nextInt();
		int column = sc.nextInt();
		int[][] ar = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				int t = sc.nextInt();
				 ar[i][j] = t;
				 if(t==3){
					 pair p = new pair(i, j);
					 list.add(p);
				 }
			}
		}
		for(int i=0; i<list.size(); i++){
			recur(ar, list.get(i).r, list.get(i).c, row, column);
		}
		int cnt = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
			System.out.print(ar[i][j]+" ");
				 if(ar[i][j]==1){
					 cnt++;
				 }
			}
			System.out.println();
		}
		System.out.println(cnt);
		sc.close();
	}
	
	private static void recur(int[][] ar, int i, int j, int row, int column){
		
		while ((i-1>0)&&(ar[i][j]==3 && ar[i-1][j]==1)) {
			ar[i-1][j] = 3;
			recur(ar, i-1, j,row,column);
		}
		while ((j+1<column)&&(ar[i][j]==3 && ar[i][j+1]==1)) {
			ar[i][j+1]=3;
			recur(ar, i, j+1,row,column);
		}
		while ((j-1>0)&&(ar[i][j]==3 && ar[i][j-1]==1)) {
			ar[i][j-1]=3;
			recur(ar, i, j-1,row,column);
		}
		while ((i+1<row)&&(ar[i][j]==3 && ar[i+1][j]==1)) {
			ar[i+1][j]=3;
			recur(ar, i+1, j,row,column);
		}
		
		if ((i-1<0)||(i+1>=row)||(j-1<0)||(j+1>=column)) {
			return;
		}
	}
}
