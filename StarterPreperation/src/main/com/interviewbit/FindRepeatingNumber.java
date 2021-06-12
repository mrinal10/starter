package com.interviewbit;

import java.util.List;

public class FindRepeatingNumber {

	
	public int repeatedNumber(final List<Integer> A) {
		int[] arr = new int[A.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = A.get(i);
		}
		
		for (int i = 0; i < arr.length; i++) 
        { 
            if (arr[Math.abs(arr[i])] >= 0) 
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])]; 
            else
                return Math.abs(arr[i]); 
        } 
		return -1;
	}
	
	
	public static void main(String[] args) {
		

	}

}
