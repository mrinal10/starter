package com.zero.contest1;

import java.util.*;
import java.util.Scanner;

public class CodeKill {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if(list.isEmpty()){
				list.add(arr[i]);
			}else{
				int toRemove = -1;
				for (int j = 0; j < list.size(); j++) {
					int t = list.get(j);
					if(t<arr[i]){
						toRemove = j;
						break;
					}
				}
				if(toRemove!=-1){
				list.remove(toRemove);
				}
				list.add(arr[i]);
			}
		}
		int sum = 0;
		for(int i=0 ;i<list.size(); i++){
			sum += list.get(i);
		}
		System.out.println(sum);
		sc.close();
	}

}
