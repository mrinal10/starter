package com.Bima;

//import java.util.HashMap;
//import java.util.Map;
import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        //Map<Integer,Integer> newMap = new HashMap<Integer,Integer>();
        Scanner s = new Scanner(System.in);
        try {
			int N = s.nextInt();
	        int[] ar = new int[N];
	        int Q = s.nextInt();
	        for (int i = 0; i < Q; i++) {
	        	int X = s.nextInt();
	        	System.out.println(allocate(ar,X));
	        }
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			s.close();
		}
    }
    
    private static boolean allocate(int[] ar, int val){
    	int startPoint = findmin(ar.length,val);
    	startPoint = startPoint-1;
    	System.out.println("startPoint :"+startPoint);
    	return false;
    }
    
    private static int findmin(int a,int b){
    	if (a<b) {
			return a;
		}
    	return b;
    }
}
