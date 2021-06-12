package com.furlenco.hiring30062018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChocolateDistribution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		
		for (int i = 0; i < testCases; i++) {
			int q,k;
			q = sc.nextInt();
			k = sc.nextInt();
			int totCount = 0;
			int totChocCount = 0;
			int leastIndex = 0;
			int leastValue = Integer.MAX_VALUE;
			List<ArrayList<Integer>> listOfStudent = new ArrayList<>();
			for (int j = 0; j < q; j++) {
				
				int temp = sc.nextInt();
				totCount += temp;
				
				ArrayList<Integer> listT = new ArrayList<>();
				for (int l = 0; l < temp; l++) {
					int t = sc.nextInt();
					listT.add(t);
					if (l==0 && t<leastValue) {
						leastIndex = j;
						leastValue = t;
					}
				}
				listOfStudent.add(listT);
			}
			
			while (totCount!=0 && k!=0) {
				totChocCount += listOfStudent.get(leastIndex).get(0);
				listOfStudent.get(leastIndex).remove(0);
				if (listOfStudent.get(leastIndex).isEmpty()) {
					listOfStudent.remove(leastIndex);
				}
				leastIndex = 0;
				leastValue = Integer.MAX_VALUE;
				for (int j1 = 0; j1 < listOfStudent.size(); j1++) {
					if (leastValue>listOfStudent.get(j1).get(0)) {
						leastValue = listOfStudent.get(j1).get(0);
						leastIndex = j1;
					}
				}
				totCount--;
				k--;
			}
			System.out.println(totChocCount);
		}
		
		sc.close();
	}
}
