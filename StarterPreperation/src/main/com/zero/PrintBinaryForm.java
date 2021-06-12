package com.zero;

import java.util.LinkedList;
import java.util.Queue;

public class PrintBinaryForm {
	void printBinaryCounting(int n) 
	{ 
		if(n>0){
			System.out.print(0+" ");
		}
	        Queue<Integer> q1 = new LinkedList<Integer>();
	        q1.add(1);
	        for (int i = 1; i < n; i++) {
				int popValue = q1.poll();
				q1.add(popValue*10);
				q1.add((popValue*10) + 1);
				System.out.println(popValue+" ");
			}
	        
	        // isEmpty(), void add(Integer i), int remove()

	}
	
	public static void main(String[] args) {
		
	}
}
