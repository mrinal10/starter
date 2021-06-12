package com.anzen.hiring13072018;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AnzenP1 {

    public static void main(String arr[]) {
    	Scanner sc = new Scanner(System.in);
    	int testCases = sc.nextInt();
    	Set<Integer> set = new HashSet();
    	int[] ar = new int[testCases];
    	for (int i = 0; i < testCases; i++) {
			int t = sc.nextInt();
			if (!set.contains(t)){
				ar[i] = t;
				set.add(t);
			}
		}
    	
    	
    	Arrays.sort(ar);
    	int q = sc.nextInt();
    	for (int i = 0; i < q; i++) {
			int avg = sc.nextInt();
			int cnt = 0;
			int j = 0;
			int trgt = 0;
			for (j = 0; j < ar.length ; j++) {
				cnt += ar[j];
				trgt = (j+1)*avg;
				if(trgt <= cnt){
					break;
				}
			}
			System.out.println(j);
		}
    	sc.close();
    }
}
