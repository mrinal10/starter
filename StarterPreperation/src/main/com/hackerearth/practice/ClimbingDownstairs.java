package com.hackerearth.practice;

import java.math.BigDecimal;
import java.util.Scanner;

public class ClimbingDownstairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-->0) {
			BigDecimal steps = sc.nextBigDecimal();
			BigDecimal rem = steps.remainder(new BigDecimal("6"));
			if(rem.equals(0)){
				System.out.println(3);
			}else{
				rem = rem.remainder(new BigDecimal("3"));
				if (rem.equals(0)) {
					System.out.println(2);
				}else
					System.out.println(1);
			}
		}
		sc.close();
	}

}
