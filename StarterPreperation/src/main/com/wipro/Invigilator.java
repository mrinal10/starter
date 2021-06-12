package com.wipro;

import java.util.ArrayList;
import java.util.Scanner;

class inVig{
	static boolean[] ar = new boolean[500];
	public void set(){
		for (int i = 0; i < 500; i++) {
			ar[i] = false;
		}
	}
	
	public boolean setAppoint(int startTime, int duration){
		boolean flag = true;
		for (int i = startTime-1; i < startTime+duration; i++) {
			if (ar[i]!=true) {
				ar[i] = true;
			}else{
				for (int k = startTime-1; k < i; k++){
					ar[k] = false;
				}
				return false;
			}
		}
		return flag;
	}
}


public class Invigilator {
	public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        
        for (int i = 0; i < T; i++) {
        	 int N = s.nextInt();
        	 int M = s.nextInt();
        	 
        	 ArrayList<inVig> inv = new ArrayList<inVig>();
             if (M>0) {
     			inVig in1 = new inVig();
     			in1.set();
     			inv.add(in1);
     		 }
        	 
        	 try {
				for (int j = 0; j < M; j++) {
		        	 int id = s.nextInt();
		        	 int t = s.nextInt();
		        	 int dur = s.nextInt();
		        	 boolean flag = false;
		        	 for(int kk = 0; kk<inv.size(); kk++){
		        		try {
			        		 inVig in2 = inv.get(kk);
			        		 flag  = in2.setAppoint(t, dur);
			        		 if (flag) {
								 break;
							 }
						} catch (Exception e) {
							// TODO: handle exception
						}
		        	 }
		        	 
		        	 if (!flag) {
						inVig in3 = new inVig();
						in3.set();
						in3.setAppoint(t, dur);
						inv.add(in3);
					 }
	        	 }
			} catch (Exception e) {
				// TODO: handle exception
			}
        	System.out.println(inv.size());
        }      
        
    }
}
