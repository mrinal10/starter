package com.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesSortedArray {

	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 1, 1, 1, 1, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 7, 8, 8, 8,12,13,14,14,15 };
		ArrayList<Integer> ll = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			ll.add(a[i]);
		}
		removeDuplicates(ll);
		for (int i = 0; i < ll.size(); i++) {
			System.out.println(ll.get(i));
		}
	}
	
	
	public static int removeDuplicates(List<Integer> a) {
        int[] arr = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            arr[i] = a.get(i);
        }
        int cnt = 0;
        int n = a.size();
        if (n == 0 || n == 1) 
            return n; 
        int j = 0; 
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				arr[j++] = arr[i];
				cnt++;
			}
		}
        
        arr[j++] = arr[n-1]; 
        a.clear();
        for(int i=0; i<=cnt; i++){
            a.add(arr[i]);
        }
        return j;
	}
}
