package com.hiring.hsbc22062019;

import java.util.Scanner;

public class SamHeightHSBC {
	public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int N = sc.nextInt();
            int S = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0;i<N;i++){
                arr[i] = sc.nextInt();
            }
            int out = solve(arr, N, S);
            System.out.println(out);
        }
        sc.close();
    }
    static int solve(int[] arr, int N, int S){
    	int smlCnt = 0;
    	int grtCnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (S<arr[i]) {
				smlCnt++;
			}else {
				grtCnt++;
			}
		}
    	
    	if (grtCnt-smlCnt >0) {;
        	return grtCnt-smlCnt;
    	}else {
    		return smlCnt-grtCnt;
    	}
    }
}
