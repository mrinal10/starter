package com.NationalInstruments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class NationalInstrumentsTestClass1 {
	public static void main(String[] args) {
		int T;
		Scanner sc = null ;
		try {
			sc = new Scanner(System.in);
			T = sc.nextInt();
			int i=0;
			int n=0;
			int k=0;
			while (i<T) {
				n = sc.nextInt();
				k = sc.nextInt();
				String[][] grid = new String[n][n];
				for (int j = 0; j < n; j++) {
					for (int j2 = 0; j2 < n; j2++) {
						grid[j][j2]=sc.next();
					}
				}
				int attainableThiefsinthisGrid = 0;
				for (int j = 0; j < n; j++) {
					List<Integer> policeLoc = new ArrayList<Integer>();
					List<Integer> thiefLoc = new ArrayList<Integer>();
					int attainableThiefsinthisRow = 0;
					for (int j2 = 0; j2 < n; j2++) {
						if (grid[j][j2].equalsIgnoreCase("p")) {
							policeLoc.add(j2);
						}else{
							thiefLoc.add(j2);
						}
					}
					for (Iterator iterator = policeLoc.iterator(); iterator.hasNext();) {
						Integer integer = (Integer) iterator.next();
						for (Iterator iterator1 = thiefLoc.iterator(); iterator1.hasNext();) {
							Integer integer1 = (Integer) iterator1.next();
							
							
						}
					}
					attainableThiefsinthisGrid+=attainableThiefsinthisRow;
				}
				System.out.println(attainableThiefsinthisGrid);
				i++;
			}
		} catch (Exception e) {
			sc.close();
		}
	}
}
