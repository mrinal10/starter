package com.codechef;

import java.util.*;

public class SNCKYEAR {

	public static void main(String[] args) {
		Set<Integer> h = new HashSet<>(Arrays.asList(2010, 2015, 2016, 2017, 2019));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			if (h.contains(n)) {
				System.out.println("Hosted");
			}else
				System.out.println("Not Hosted");
		}
	}

}
