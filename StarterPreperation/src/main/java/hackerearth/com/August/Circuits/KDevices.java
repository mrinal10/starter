package com.August.Circuits;

import java.util.Arrays;
import java.util.Scanner;

public class KDevices {
	public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();
        
        int[] X = new int[N];
        int[] Y = new int[N];
        double[] Z = new double[N];
        for (int i = 0; i < N; i++) {
        	X[i] = s.nextInt();
        }
        for (int i = 0; i < N; i++) {
        	Y[i] = s.nextInt();
        } 
        
        for (int i = 0; i < N; i++) {
        	Z[i] = getdistance(X[i],Y[i]);
        } 
        
        Arrays.sort(Z);
        
        
        try {
			 String s1 = String.valueOf(Math.ceil(Z[K-1]));
	         s1 = s1.substring(0,s1.length()-2);
	         System.out.println(s1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
    }
	 
	 private static double getdistance(int x, int y){
		 
		 return Math.sqrt((x*x)+(y*y));
	 }
}
