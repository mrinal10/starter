package com.zero.recursion;

public class PrintAllPaths {
	
	void printAllMatrixPathsHelper(int[][] a, int r, int c, int rlim, int clim, String s){
		s = s+a[r][c]+" ";
		if(r==rlim && c == clim){
			System.out.println(s);
			return;
		}

		if(r>=rlim){
			printAllMatrixPathsHelper(a, r, c+1, rlim, clim, s);
		}else if(c>=clim){
			printAllMatrixPathsHelper(a, r+1, c, rlim, clim, s);
		}else{
			printAllMatrixPathsHelper(a, r+1, c, rlim, clim, s);
			printAllMatrixPathsHelper(a, r, c+1, rlim, clim, s);
		}
	}
	void printAllMatrixPaths(int[][] m) {
		printAllMatrixPathsHelper(m, 0, 0, m.length-1, m[0].length-1, "");
	}

	public static void main(String[] args) {
		PrintAllPaths hassumpath = new PrintAllPaths();
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};

		hassumpath.printAllMatrixPaths(mat);


	}

}
