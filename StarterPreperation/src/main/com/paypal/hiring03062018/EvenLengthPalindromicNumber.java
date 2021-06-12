package com.paypal.hiring03062018;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class EvenLengthPalindromicNumber {
	public static HashMap<Integer, Integer> palindromeMap = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			generatePaldindromes(n);
			numberMapper(n);
		}
		
		sc.close();
	}
	
	static int createPalindrome(int input, int b) {
	    int n = input;
	    int palin = input;
	    while (n > 0) {
	        palin = palin * b + (n % b);
	        n /= b;
	    }
	    return palin;
	}

	static void generatePaldindromes(int n) {
	    int number;
	 
	    // Run two times for odd and even 
	    // length palindromes
	    for (int j = 0; j < 1; j++) {
	 
	    // Creates palindrome numbers with first 
	    // half as i. Value of j decided whether
	    // we need an odd length of even length
	    // palindrome.
	        int i = 1;
	        int k = 0;
	        while (k < n) {
	        	if (palindromeMap.get(i)== null) {
	        		number = createPalindrome(i, 10);
	        		palindromeMap.put(i, number);
				}else{
					number = palindromeMap.get(i);
				}
	        	
	        	//System.out.println(i+" "+number);
	            i++;
	            k++;
	        }
	    }
	}

	static void numberMapper(int n){
		String number = String.valueOf(palindromeMap.get(n));

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < number.length()/2; i++) {
			if (map.get(number.charAt(i))==null) {
				map.put(Integer.parseInt(String.valueOf(number.charAt(i))), 1);
			} else {
				map.put(Integer.parseInt(String.valueOf(number.charAt(i))),
						map.get(number.charAt(i)+1)) ;
			}
		}
		
		// using for-each loop for iteration over Map.entrySet()
		int minVal = 0;
		int minValCount = 0;
		int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	count=entry.getValue();

        	if (count>minValCount) {
				minVal = entry.getKey();
			} else if(count == minValCount && minVal>entry.getKey()) {
					minVal = entry.getKey();
			}
        	minValCount = count;
        }
        
        System.out.println(minVal);
	}

}
