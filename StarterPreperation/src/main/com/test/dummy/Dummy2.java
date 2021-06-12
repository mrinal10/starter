package com.test.dummy;

import java.util.Scanner;

public class Dummy2 {

	public static boolean isStepNum(int n) 
    { 
        int prevDigit = -1; 
  
        while (n > 0) 
        { 
            int curDigit = n % 10; 
   
            if (prevDigit != -1) 
            { 
                if (Math.abs(curDigit-prevDigit) != 1) 
                    return false; 
            } 
            n /= 10; 
            prevDigit = curDigit; 
        } 
        return true; 
    } 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			for(int i=s; i<=e; i++){
				if(isStepNum(i)){
					System.out.print(i+" ");
				}
			}
		}
		sc.close();
	}

}
