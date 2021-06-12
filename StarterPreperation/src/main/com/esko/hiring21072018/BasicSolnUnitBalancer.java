package com.esko.hiring21072018;

import java.util.Scanner;

public class BasicSolnUnitBalancer {

	public static void main(String[] args) {
		Long startTime = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] units = s.split(",");
		String eq = " = ";
		String finalString = "";
		int startingUnit = 1;
		Long afterInput = System.currentTimeMillis();
		System.out.println(afterInput - startTime);
		
		for (int i = 0; i < units.length - 1; i++) {
			String leftSide = sc.next();
			eq = sc.next();
			String unit = sc.next();
			if (i==0) {
				finalString = finalString+startingUnit+leftSide;
			}
			String rightSide = sc.next();
			finalString = finalString+" = "+(startingUnit*Integer.parseInt(unit))+rightSide;
			startingUnit = startingUnit*Integer.parseInt(unit);
		}
		System.out.println(finalString);
		afterInput = System.currentTimeMillis();
		System.out.println(afterInput - startTime);
		
		sc.close();
	}

}
