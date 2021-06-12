package com.Bima;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Value {
	public static void main(String args[] ) throws Exception {
    	try {
    		int min = 0;
    		int max = 0;
			Scanner s = new Scanner(System.in);
			try {
				Map<String,String> hMap = new HashMap<String,String>();
		        int N = s.nextInt();
		        for (int i = 0; i < N; i++) {
		        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		            String line = br.readLine();
		            //System.out.println("line ::: "+line);
		        	String[] X1 = line.split(" ");
		        	if (X1.length==3) {
		        		hMap.put(X1[1], X1[2]);
		        		if (min>Integer.parseInt(X1[2])) {
		        			min=Integer.parseInt(X1[2]);
						}
		        		if (max<Integer.parseInt(X1[2])) {
		        			max=Integer.parseInt(X1[2]);
						}
					}else if (X1.length==2) {
						String expeledVal = hMap.get(X1[1]);
						hMap.remove(X1[1]);
						if (expeledVal.equals(String.valueOf(min)) ) {
							min=Integer.parseInt(findMin(hMap));
						}else{
							max=Integer.parseInt(findMax(hMap));
						}					
					}else if (X1.length==1) {
						if (X1[0].equals("3")) {
							System.out.println(findMin(hMap)+" "+findMax(hMap));
						}else if (X1[0].equals("4")) {
							System.out.println(hMap.get(findHighestKey(hMap)));
						}
					}
		        }
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				s.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private static String findMax(Map<String, String> hMap){
    	Set<String> keySetValues = hMap.keySet();
    	Iterator<String> itr = keySetValues.iterator();
    	int max = -10000;
    	while (itr.hasNext()) {
    		String type = (String) itr.next();	
    		String v = hMap.get(type);
    		
    		if(max == 0){
    			max = Integer.parseInt(v);
    		}
    		
    		else if (Integer.parseInt(v)>max) {
				max = Integer.parseInt(v);
			}
		}
    	return String.valueOf(max);
    }
    
    private static String findHighestKey(Map<String, String> hMap){
    	Set<String> keySetValues = hMap.keySet();
    	Iterator<String> itr = keySetValues.iterator();
    	int max = 0;
    	while (itr.hasNext()) {
    		String type = (String) itr.next();	
    		if (Integer.parseInt(type)>max) {
				max = Integer.parseInt(type);
			}
		}
    	return String.valueOf(max);
    }
    
    private static String findMin(Map<String, String> hMap){
    	Set<String> keySetValues = hMap.keySet();
    	Iterator<String> itr = keySetValues.iterator();
    	int max = -10000;
    	while (itr.hasNext()) {
    		String type = (String) itr.next();	
    		String v = hMap.get(type);
    		//System.out.println("find minimum iteration :: "+v);
    		if(max == -10000){
    			max = Integer.parseInt(v);
    		}
    		
    		else if (Integer.parseInt(v)<max) {
				max = Integer.parseInt(v);
			}
		}
    	return String.valueOf(max);
    }
}
