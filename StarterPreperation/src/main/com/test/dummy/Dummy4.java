package com.test.dummy;

import java.util.Scanner;

public class Dummy4 {
	static int msbPos(long n)  
    {  
          
        int msb_p = -1;  
        while (n > 0) {  
            n = n >> 1;  
            msb_p++;  
        }  
          
        return msb_p;  
    }  
  
    static long andOperator(long x, long y)  
    {  
          
        long res = 0;  
  
        while (x > 0 && y > 0) {  
              
            int msb_p1 = msbPos(x);  
            int msb_p2 = msbPos(y);  
  
            if (msb_p1 != msb_p2)  
                break;  
  
            long msb_val = (1 << msb_p1);  
            res = res + msb_val;  
   
            x = x - msb_val;  
            y = y - msb_val;  
        }  
  
        return res;  
    }  
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			while(n-->0){
				long s = sc.nextInt();
				long w = sc.nextInt();
				long v = s;
//				for(long i=s+1; i<=w; i++){
					v = andOperator(s,w);
//				}
				System.out.println(v);
			}
		}
		sc.close();
	}

}
