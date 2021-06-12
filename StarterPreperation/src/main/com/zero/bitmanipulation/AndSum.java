package com.zero.bitmanipulation;

import java.util.ArrayList;
import java.util.Scanner;
 
public class AndSum {
    // Returns sum of XORs of all subsets
    static int andSum(ArrayList<Integer> aList)
    {
    	 int bits = 0;
    	 if (aList.size()!=0) {
    		 bits = aList.get(0);
		}
         
         // Finding bitwise OR of all elements
         for (int i = 0; i < aList.size(); i++) {
             bits &= aList.get(i);
         }
         System.out.println("bits >> "+bits);
        return bits;
    }
    
    private static int getVal(int[] arr) {
    	int size = (int) Math.pow(2, arr.length);
//    	System.out.println("size :: "+size);
    	int sumVal = 0;
    	for (int i = 0; i < size; i++) {
//    		System.out.println("i :: "+i);
    		int temp = i;
    		ArrayList<Integer> l = new ArrayList<Integer>();
    		int count = 0;
    		while(temp!=0) {
    			int j = arr[count];
				
				if (temp%2==1) {
					l.add(j);
				}
				temp = temp/2;
				count++;
    		}
    		sumVal += andSum(l);
		}
    	return sumVal;
    }
    
    
    
    public static void main(String[] args)
    {
    	int t;
    	Scanner sc = new Scanner(System.in);
    	t = sc.nextInt();
    	for(int i =0; i<t; i++) {
    		int n = sc.nextInt();
    		int[] arr = new int[n];
    		for(int j=0; j<n; j++) {
    			arr[j] = sc.nextInt();
    		}
    		System.out.print(getVal(arr));
    	}
        sc.close();
    }
}