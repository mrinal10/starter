package com.julyCircuit;

import java.util.Scanner;

public class primeCells {
	public static void main(String[] args) {
		try {		
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int[][]ar = new int[n][n];
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					ar[i][j] = sc.nextInt();
				}
			}
			sc.close();
			System.out.println(countPrime(ar, n));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static int countPrime(int[][] ar, int n){
		int varCount = 0;
		for(int i=0; i<n; i++){
			
			for(int j=0; j<n; j++){
				int jj = 0;
//				System.out.println("ar[i][j] :: "+ar[i][j]);
				try {					
					if (i==0) {
						jj = jj+ar[i+1][j];
					} else if(i==n-1) {
						jj = jj+ar[i-1][j];
					} else {
						jj = jj+ar[i+1][j]+ar[i-1][j];
					}
//					System.out.println("intem jj :: "+jj);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try{
				
					if (j==0) {
						jj = jj+ar[i][j+1];
					} else if(j==n-1) {
						jj = jj+ar[i][j-1];
					} else {
						jj = jj+ar[i][j+1]+ar[i][j-1];
					}
//					System.out.println("intem jj :: "+jj);
				}catch(Exception e){
					e.printStackTrace();
				}
//				System.out.println("jj :: "+isPrime(jj));
				if(isPrime(jj)){
					varCount ++;
				}
			}
		}
		return varCount;
	}
	
	private static boolean isPrime(int v){
		for(int i=2; i<Math.sqrt(v); i++){
			if (v%i == 0) {
				return false;
			}
		}
		return true;
	}
}
