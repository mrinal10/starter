package com.cast.hiring30062018;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class PerpendicularLines {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			BigDecimal x1 = sc.nextBigDecimal();
			BigDecimal y1 = sc.nextBigDecimal();
			BigDecimal x2 = sc.nextBigDecimal();
			BigDecimal y2 = sc.nextBigDecimal();
			float slope1 = getSlope(x2, y2, x1, y1);
			BigDecimal x3 = sc.nextBigDecimal();
			BigDecimal y3 = sc.nextBigDecimal();
			BigDecimal x4 = sc.nextBigDecimal();
			BigDecimal y4 = sc.nextBigDecimal();
			float slope2 = getSlope(x4, y4, x3, y3);
			
			if (slope1!=0 && slope2!=0) {
				if (slope1*slope2!=-1){
					System.out.println("NO");
				}else{
					System.out.println("YES");
				}
			}else{
				System.out.println("INVALID");
			}
		}
		sc.close();
	}
	
	
	private static float getSlope(BigDecimal x2, BigDecimal y2, BigDecimal x1, BigDecimal y1){
		try {
			if (!x1.equals(x2) && !y1.equals(y2) ) {

					return (y1.subtract(y2)).divide((x1.subtract(x2)), 2, RoundingMode.HALF_UP).floatValue();
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}