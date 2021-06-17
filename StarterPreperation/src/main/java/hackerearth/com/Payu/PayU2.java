package com.Payu;

import java.util.ArrayList;
import java.util.Scanner;

public class PayU2 {

	public static void main(String args[] ) throws Exception {
		Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int set[] = new int[t];
        for (int i = 0; i < t; i++) {
        	set[i]=s.nextInt();
        }
        
        int[] be = printSubsets(set);
        long val = 0;
        
        for (int i = 0; i <= t; i++) {
        	System.out.println(Math.pow(31, i));
        	val += (be[i]*(int) Math.pow(31, i))%(Math.pow(10, 9)+7);		
		}
        System.out.println(val);
        s.close();
    }
	
	
	static int[] printSubsets(int[] set)
    {
        int n = set.length;
        int max_a = 0;
        for (int i=1; i<n; i++)
 	       if (set[i] > max_a)
 	    	   max_a = set[i];
 	 
        int m = (1 << (int)( (Math.log(max_a)/Math.log(2)) + 1) ) - 1;
        int[] br = new int[m+1];
        for (int i = 0; i <n; i++){
        	br[i] = 0;
        }

        for (int i = 0; i < (1<<n); i++)
        {
            
        	int l = 0;
        	int B = 0;
            // Print current subset
            for (int j = 0; j < n; j++){
            	ArrayList<Integer> arrList = new ArrayList<Integer>();
                
            	
                if ((i & (1 << j)) > 0){
                	arrList.add(set[j]);
                	B ^= set[j];
                	l++;
                }
                
            }
            if (br[B]<l) {
				br[B] = l;
			}
            
        }
        return br;
    }
	
 
}
