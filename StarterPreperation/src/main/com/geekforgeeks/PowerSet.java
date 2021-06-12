package com.geekforgeeks;


import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;


public class PowerSet {
	public static void printPowerSet(String[] arrayL){
		String[] arr = new String[arrayL.length];
		try {
			//Recursive Approach
			PowerSet.defHelper_recursive(arrayL,arr, 0);
			
			//Iterative Approach
			PowerSet.defHelper_iterative(arrayL);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}	
	
	private static void defHelper_iterative(String[] arrayL) 
			throws InterruptedException{
		int l = arrayL.length;
		System.out.println();
		for (int i = 0; i < l; i++) {
			String[] arr = new String[arrayL.length];
			arr[i] = arrayL[i];
			PowerSet.printSet(arr);
			for (int j = i+1; j < arrayL.length; j++) {
				arr[j] = arrayL[j];
				PowerSet.printSet(arr);
			}
		}
		
	}
	
	private static void defHelper_recursive(String[] arrayL, String[] arrL, int i) throws InterruptedException{
		if (i==arrayL.length) {
			PowerSet.printSet(arrL);
			return;
		} else {
			arrL[i] = null;
			defHelper_recursive(arrayL, arrL, i+1);
			
			arrL[i] = arrayL[i];
			defHelper_recursive(arrayL, arrL, i+1);
			
		}		
	}
	
	private static void printSet(String[] arrayL){
		Set<String> set = new HashSet<String>(Arrays.asList(arrayL));
		for (Object object : set) {
			if (object!=null) {
				System.out.print(object.toString()+", ");	
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		String[] arr = {"1","2","3","4", "5", "6", "7", "8", "9", "10"};
		PowerSet.printPowerSet(arr);
	}

}
