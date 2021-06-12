/*
 * 

Being greedy for Water

You are given container full of water. Container can have limited amount of water. 
You also have N bottles to fill. You need to find the maximum numbers of bottles you can fill.

Input:
First line contains one integer, T, number of test cases.
First line of each test case contains two integer, N and X, number of bottles and capacity 
of the container.
Second line of each test case contains N space separated integers, capacities of bottles. 

 * */


package com.practice.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GreedOfWater {
	private static int[] sortList(int[] bottleSize) {
		Arrays.sort(bottleSize);
		
		return bottleSize;
	}
	
	public static void main(String[] args) {
		int t;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int i=0;i<t; i++) {
			int n,x;
			n = sc.nextInt();
			x = sc.nextInt();
			int[] bottleCapacities = new int[n];
			int j = 0;
			for(j=0; j<n; j++) {
				bottleCapacities[j] = sc.nextInt();
			}
			
			bottleCapacities = sortList(bottleCapacities);
			j = 0;
			while(j<n && x>0) {
				x -= bottleCapacities[j];
				j++;
			}
			if (x<0) {
				j--;
			}
			
			System.out.println(j);
		}
		sc.close();
	}
}
