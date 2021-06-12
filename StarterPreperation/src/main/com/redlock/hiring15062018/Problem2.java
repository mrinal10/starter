package com.redlock.hiring15062018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		int length, rs;
		Scanner sc = new Scanner(System.in);
		
		length = sc.nextInt();
		rs = sc.nextInt();
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < length; i++) {
			list.add(sc.nextInt());
		}
		
		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				
			}
		}
		sc.close();
	}
}
