package com.codeforce;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hash1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < testCases; i++) {
			String key = sc.next();
			if(!map.containsKey(key)){
				System.out.println("OK");
				map.put(key, 1);
			}else{
				int valu = map.get(key);
				System.out.println(key+valu);
				valu++;
				map.put(key, valu);
			}
		}
		sc.close();
	}
}
