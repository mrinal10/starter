package com.practice.company.morganstanley;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Cnt_prs_with_gvn_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int tar = sc.nextInt();
			int[] ar = new int[n];

			for (int i = 0; i < n; i++) {
				ar[i] = sc.nextInt();
			}
			
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			
			for(int i=0; i<n; i++) {
				int cnt = 0;
				if(map.containsKey(ar[i])) {
					cnt = map.get(ar[i]);
				}
				cnt++;
				map.put(ar[i], cnt);
			}
			int totalCnt = 0;
			for(Entry<Integer, Integer> entry: map.entrySet()) {
				int key = entry.getKey();
				int cnnt = entry.getValue();
				int reqcnt = 0;
				int req = tar - key;
				if(map.containsKey(req)) {
					reqcnt = map.get(req);
					if(req == key) {
						reqcnt -= 1;
					}
				}
				totalCnt += cnnt*reqcnt;
			}
			System.out.println(totalCnt/2);
		}
		sc.close();
	}
}
