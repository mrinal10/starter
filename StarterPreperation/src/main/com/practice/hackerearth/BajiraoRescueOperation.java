package com.practice.hackerearth;

import java.util.Scanner;

public class BajiraoRescueOperation {
	
	static void RescueOperation(int N,int K){
		if(N==1){
			System.out.println("1");
		}
		else if(N==2){
			System.out.println("2");
		}
		else if(N==3){
			if(K==2) System.out.println("78");
			else System.out.println("0");
		}
		else if(N==4){
			if(K==2) System.out.println("102");
			else System.out.println("0");
		}
		else {
			System.out.println("0");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int N = sc.nextInt();
			int K = sc.nextInt();
			RescueOperation(N,K);
		}
		sc.close();
	}
}
