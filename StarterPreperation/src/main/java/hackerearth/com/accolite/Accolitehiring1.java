package com.accolite;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Accolitehiring1 {
	    public static void main(String args[] ) throws Exception {
	        Scanner s = new Scanner(System.in);
	        try {
		        int N = s.nextInt();
		        for (int i = 0; i < N; i++) {
		        	//int l = s.nextInt();
		            String s1 = s.next();
		            System.out.println(getNumber(s1));
		        }
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				s.close();
			}
	    }
	    
	    private static int getNumber(String s){
	    	List<Integer> liInt = new LinkedList<>();
	    	String ch = "aeiou";
	    	int i=0;
	    	while (i<s.length()) {
				boolean l = ch.contains( Character.toString(s.charAt(i)) );
				if (l) {
					liInt.add(i);
				}
				i++;
			}
	    	System.out.println(liInt);
	    	System.out.println(liInt.size());
			return liInt.size()-2;
	    }
	}
