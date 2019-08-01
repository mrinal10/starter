package com.prep.array;

import java.util.Scanner;

public class Find_MAX_Length_Of_SubArray_Containing_That_Element {
	
	static int calculateMaxSumLength(int arr[], int n, int k) { 
        int ans = 0; // final sum of lengths   
        int count = 0; // number of elements in current subarray
        int flag = 0; // variable for checking if k appeared in subarray   
        for (int i = 0; i < n;) { 
            count = 0; 
            flag = 0;   
            // count the number of elements which are 
            // less than equal to k 
            while (i < n && arr[i] <= k) { 
                count++; 
                if (arr[i] == k) 
                    flag = 1; 
                i++; 
            }   
            
            
            // if current element appeared in current 
            // subarray add count to sumLength 
            if (flag == 1) 
                ans += count; 
            
            
            // skip the array elements which are 
            // greater than k 
            while (i < n && arr[i] > k) 
                i++; 
        } 
        return ans; 
    } 
	
	
	public static void main(String[] args) {
		int[] ar = { 4, 5, 7, 1, 2, 9, 8, 4, 3, 1 }; //{1,4,5,7,3,7,4,3,2,5,6,8,9,7,6,3,4};
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(calculateMaxSumLength(ar,ar.length,n) );
		sc.close();
	}
}
