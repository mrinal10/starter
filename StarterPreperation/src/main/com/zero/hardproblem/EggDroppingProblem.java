package com.zero.hardproblem;

import java.util.Scanner;

public class EggDroppingProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int floors = sc.nextInt();
		int noOfEggs = sc.nextInt();
		int[][] dynamicArray = new int[floors][noOfEggs];
		for (int i = 0; i < dynamicArray[0].length; i++) {
			dynamicArray[0][i] = 1;
		}
		for (int i = 0; i < dynamicArray.length; i++) {
			dynamicArray[i][0] = i+1;
		}
		
		for (int i = 1; i < dynamicArray.length; i++) {
			for (int j = 1; j < dynamicArray[0].length; j++) {
				dynamicArray[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= i; x++) {
                    final int brokenEggResult = dynamicArray[x - 1][j - 1];
                    final int EggSurvivedResult = dynamicArray[i - x][j];
                    int temp = Math.max(brokenEggResult, EggSurvivedResult) + 1;
                    if (temp < dynamicArray[i][j]) {
                    	dynamicArray[i][j] = temp;
                    }
                }
			}
		}
		System.out.println(dynamicArray[dynamicArray.length-1][dynamicArray[0].length-1]);
		sc.close();
	}
	
	
}
