package com.cast.hiring30062018;

import java.util.ArrayList;
import java.util.Scanner;

public class GameOfArray {
	static ArrayList<Integer> list;
	public static void main(String[] args) {
		list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int alexCount = 0;
		int bobCount = 0;
		
		try {
			for (int i = 0; i < n; i++) {
				list.add(sc.nextInt());
			}
			for (int i = 0; i < n; i++) {
				int tem  = 0;
				if (list.size()%2==0) {
					if (list.get(list.size()/2) < list.get((list.size()/2)-1) ) {
						tem = list.get((list.size()/2)-1);
						list.remove((list.size()/2)-1);
					}else{
						tem = list.get(list.size()/2);
						list.remove(list.size()/2);

					}
				}else{
					tem = list.get(list.size()/2);
					list.remove(list.size()/2);

				}
				if (i%2 == 0) {
					alexCount += tem;
				}else {
					bobCount += tem;
				}
				
			}
			
			if (alexCount == bobCount || alexCount>bobCount) {
				System.out.print("Alex ");
			}else{
				System.out.print("Bob ");
			}
			System.out.print(Math.abs(alexCount-bobCount));
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
}