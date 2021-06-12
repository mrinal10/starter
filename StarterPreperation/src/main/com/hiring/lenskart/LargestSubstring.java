package com.hiring.lenskart;

import java.util.Scanner;

public class LargestSubstring {
	public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String inp = s.next();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(String.valueOf(inp.charAt(i)));
		}
        int longestLength = 0;
        for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int zCnt = 0;
				int wanCnt = 0;
				
				for (int k = i; k <= j; k++) {
					if (arr[k] == 0) {
						zCnt++;
					}else if(arr[k] == 1){
						wanCnt++;
					}
					if (zCnt>wanCnt) {
						if (longestLength<k-i+1) 
							longestLength = k-i+1;
					}
				}
			}
		}
        System.out.println(longestLength);
        s.close();
    }
}
