package com.practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class paytm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.next();
		
		String[] arr = a.split(" ");
		Set<String> newSet = new HashSet<>();
		for(int i=0; i<arr.length; i++){
			if (arr[i].startsWith(b)) {
				newSet.add(arr[i]);
			}
		}
		for(String str:newSet){
			System.out.println(str);
		}
		sc.close();
	}
}
