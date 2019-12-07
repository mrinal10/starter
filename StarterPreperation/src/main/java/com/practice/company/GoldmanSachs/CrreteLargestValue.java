package com.practice.company.GoldmanSachs;

import java.util.*;

public class CrreteLargestValue {
	public static void main(String[] args) {
		Vector<Integer> arr; 
        arr = new Vector<>(); 
          
        //output should be 6054854654 
        arr.add(60); 
        arr.add(546); 
        arr.add(97); 
        arr.add(79);
        
        arr.add(9); 
        arr.add(20); 
        arr.add(67); 
        arr.add(6);
        
        arr.add(11); 
        arr.add(21); 
        arr.add(33); 
        arr.add(45); 
        createLargest(arr); 		
	}
	
	private static void createLargest(Vector<Integer> arr) {
		Collections.sort(arr, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				int k1 = Integer.parseInt(String.valueOf(o1)+String.valueOf(o2));
				int k2 = Integer.parseInt(String.valueOf(o2)+String.valueOf(o1));
				return k1>k2 ? -1:1;
			}
		});
		Iterator<Integer> it = arr.iterator();		  
	    while(it.hasNext()) 
	        System.out.print(it.next()); 	      
    } 
}
