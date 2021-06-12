package com.zero.contest1;

import java.util.Scanner;

public class ReverseraNumber {
	
	private static int reverseInt(int n){
		int k = 0;
		while(n!=0){
			k = k*10;
			k += n%10;
			n = n/10;
		}
		return k;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n!=0){
			if(n<0){
				System.out.println((-1)*(reverseInt(n*(-1))));
			}else
				System.out.println(reverseInt(n));

			n=sc.nextInt();
		}
		sc.close();
	}

}
