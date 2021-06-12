package com.gfg.interviewprep;

import java.util.Scanner;

public class PrintKthDigit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int m = sc.nextInt();
			int n = sc.nextInt();
			int k = sc.nextInt();
			int v = power(m, n);
			int count = 0; 
	        while (v > 0 && count < k) { 
	            int rem = v % 10; 
	            count++; 
	            if (count == k) 
	                System.out.println(rem); 
	            v = v / 10; 
	        }  
		}
		sc.close();
	}
	static int power(int x, int y) 
    { 
        if (y == 0) 
            return 1; 
        else if (y % 2 == 0) 
            return power(x, y / 2) * power(x, y / 2); 
        else
            return x * power(x, y / 2) * power(x, y / 2); 
    } 
}
