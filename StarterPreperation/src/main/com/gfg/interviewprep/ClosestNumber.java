package com.gfg.interviewprep;

import java.util.Scanner;

public class ClosestNumber {
	static int closestNumber(int n, int m) 
    { 
        int q = n / m; 
           
        int n1 = m * q; 
           
        int n2 = (n * m) > 0 ? (m * (q + 1)) : (m * (q - 1)); 
           
        if (Math.abs(n - n1) < Math.abs(n - n2)) 
            return n1; 
           
        return n2;     
    } 
       
    // Driver program to test above 
    public static void main(String args[]) 
    { 
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	System.out.println(closestNumber(n, m));
    	sc.close();
    }
}
