package com.zero;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class MaxNoRearranging {
	
	
	void rearrangeArrayToFormLargestNumber(int a[])
	{
		final Integer[] sorted = new Integer[a.length];
		for (int i = 0; i < sorted.length; i++) {
			sorted[i] = a[i];
		}
		Arrays.sort(sorted, new Comparator<Integer>() {
		    public int compare(Integer o1, Integer o2) {
		    	String s1 = String.valueOf(o1)+String.valueOf(o2);
				String s2 = String.valueOf(o2)+String.valueOf(o1);
				if (Integer.parseInt(s1)>Integer.parseInt(s2)) {
					return -1;
				}else if(Integer.parseInt(s1) == Integer.parseInt(s2)){
					return 0;
				}
				return 1;
		    }
		});
		for (int i = 0; i < sorted.length; i++) {
			a[i] = sorted[i];
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
