package com.practice;

import java.util.*;

public class SymmetricLogos {
	public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        try {
			for (int i = 0; i < N; i++) {
				System.out.println(N+" :::: i ::::: "+i);
	        	 int n = s.nextInt();
	        	 int[][] ar = new int[n][n];
	        	 
	        	 for (int j = 0; j < n; j++) {
					for (int j2 = 0; j2 < n; j2++) {
						ar[j][j2] = s.nextInt();
					}
				 }
	        	 System.out.println(isSymmetric(ar));
	        }
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}   
    }
	
	private static synchronized boolean isSymmetric(int[][] ar) throws Exception {
		System.out.println("isSymmetricxAxis(ar) :: "+isSymmetricxAxis(ar));
		System.out.println("isSymmetricyAxis(ar) :: "+isSymmetricyAxis(ar));
		boolean flag = isSymmetricxAxis(ar) && isSymmetricyAxis(ar);
		return flag;
	}
	
	private static synchronized boolean isSymmetricyAxis(int[][] ar){
		boolean flag = false;
		int k = ar.length;
		int l = 0;
		try {
			for (int i = 0; i < k/2; i++) {
				l = ar[i].length;
				for (int j = 0; j < l; j++) {
					if (ar[i][j] == ar[k-1-i][j] ) {
						flag = true;
						//System.out.println("xAxis flag >>> "+flag);
					}else{
						return false;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}
	
	private static synchronized boolean isSymmetricxAxis(int[][] ar) throws Exception {
		boolean flag = false;
		int k = ar.length;
		int l = 0;
		try {
			for (int i = 0; i < k; i++) {
				l = ar[i].length;
				for (int j = 0; j < l/2; j++) {
					if (ar[i][j] == ar[i][l-j-1] ) {
						flag = true;
					}else{
						return false;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}
}