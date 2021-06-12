package com.servicenow.hiring06072018;

import java.util.Arrays;
import java.util.Scanner;

class Problem2_ver2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n,m,k;
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			
			int[] boxCap = new int[n];
			int[] ballw = new int[m];
			
			for (int j = 0; j < n; j++) {
				boxCap[j] = sc.nextInt();
			}
			
			for (int j = 0; j < m; j++) {
				ballw[j] = sc.nextInt();
			}
			Arrays.sort(boxCap);
			Arrays.sort(ballw);
			
			int cnt = 0;
			if (m<n) {
				int startIndex = n-1;
				for (int j = m-1; j >= 0 && cnt<m; j--) {
					int ballWt = ballw[j];
					for (int j2 = startIndex; j2 >= 0; j2--) {
						if(ballWt>boxCap[j2]+k){
							break;
						}else if(ballWt<=boxCap[j2]+k && ballWt>=boxCap[j2]){
							cnt++;
							startIndex = j2-1;
							break;
						}
					}
				}
			}else{
				int startIndex = m-1;
				for (int j = n-1; j >= 0 && cnt<n; j--) {
					int boxcapa = boxCap[j];
					for (int j2 = startIndex; j2 >= 0; j2--) {
						if(boxcapa > ballw[j2]){
							break;
						}else if(boxcapa<=ballw[j2]+k && boxcapa>=ballw[j2]){
							cnt++;
							startIndex = j2-1;
							break;
						}
					}
				}
			}
			
			System.out.println(cnt);
		}
		sc.close();
	}
}