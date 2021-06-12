package com.hiring05102018.cars24;

import java.util.Scanner;

public class FindX {

    static int add(int x, int y)
    {
        int carry;
        while(y!=0)
        {
            carry = x & y;
            x = x ^ y;
            y = carry << 1;
        }
        return x;
    }

    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		
		while(testCases-->0){
			int sum = 0;
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				sum = add(sum, arr[i]);
			}
			float v = sum/n;
			if (v - Math.round(v)==0) {
				System.out.println(Math.round(v));
			}else
				System.out.println(-1);
		}
		sc.close();
	}

}
