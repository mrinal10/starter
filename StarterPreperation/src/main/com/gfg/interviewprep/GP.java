package com.gfg.interviewprep;

import java.util.Scanner;

public class GP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int k = sc.nextInt();
			if (k==1) {
				System.err.println(a);
			}else if(k==2){
				System.out.println(b);
			}else{
				int f = b/a;
				for(int i=1; i<k; i++){
					a = a*f;
				}
				System.out.println(a);
			}
		}
		sc.close();
	}
}
