package com.Payu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PayU1 {
	public static void main(String args[] ) throws Exception {
		Map<Integer,Integer> MyMap = new HashMap<Integer,Integer>();
        //Scanner
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
        	MyMap = new HashMap<Integer,Integer>();
        	int N = s.nextInt();
        	for (int k = 0; k < N; k++) {
        		int a = s.nextInt();
        		if (MyMap.get(a)!=null) {
					int vaue = MyMap.get(a);
					vaue++;
					MyMap.put(a, vaue);
				} else {
					MyMap.put(a, 1);
				}
        	}
        	if (isDeleteElementPossible(MyMap, N)) {
				System.out.println("YES");
			} else{
				System.out.println("NO");
			}
        }
    }
	
	private static boolean isDeleteElementPossible(Map<Integer, Integer> myMap,int N){
		boolean flag = true;
		while (flag) {
			try {	
				if (myMap.get(N)!=null) {
					N = N - myMap.get(N);
				} else {
					return false;
				}
				if (N==0) {
					flag = false;
				}
			} catch (Exception e) {
				return false;
			}	
		}
		return true;
	}
}
