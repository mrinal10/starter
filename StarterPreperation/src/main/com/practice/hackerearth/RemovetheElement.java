package com.practice.hackerearth;

import java.util.HashMap;
import java.util.Scanner;


class Pair{
	int indx;
	int value;
	public Pair(int i, int v) {
		indx = i;
		value = v;
	}
}

public class RemovetheElement {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt(); 
		HashMap<Integer, Pair> map = new HashMap<>();
		
		for (int i = 1; i <= n; i++) {
			if (map.isEmpty()) {
				map.put(i, new Pair(i, sc.nextInt())) ;
			}else{
				int num = sc.nextInt();
				for (int j = 1; j <= map.size(); j++) {
					if (map.get(j).value<num) {
						int nn = map.get(j).value;
						int in = map.get(j).indx;
						map.put(j, new Pair(in, num));
						num = nn;
					}
				}
				map.put(map.size()+1, new Pair(map.size()+1, num));
			}
		}
		
		sc.close();
	}

}
