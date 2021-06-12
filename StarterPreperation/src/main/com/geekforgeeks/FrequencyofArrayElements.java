package com.geekforgeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyofArrayElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			int n = sc.nextInt();
			
			for (int i = 0; i < n; i++) {
				int temp = sc.nextInt();
				int freq = 0;
				if (map.containsKey(temp)) {
					freq = map.get(temp);
				}
				
				map.put(temp, freq+1);
				
			}
			for (int i = 1; i <= n; i++) {
				if (map.containsKey(i)) {
					System.out.print(map.get(i)+" ");
				}else{
					System.out.print(0+" ");
				}
			}
		}
		sc.close();
	}

}
