package com.geekforgeeks.microsoft;

import java.util.Scanner;
import java.util.Stack;

public class EasetheArray {
	static Stack<Integer> stack;
	
	private static int printStack(){
		Stack<Integer> s = new Stack<>();
		int cnt = 0;
		while(!stack.isEmpty()){
		    int top = stack.pop();
		    if(top!=0){
		        cnt++;
			    s.push(top);
		    }
		}
		while (!s.isEmpty()) {
			System.out.print(s.pop()+" ");
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while (t --> 0) {
			stack = new Stack<>();
			int n = sc.nextInt();
            int i = 0;
			while (i<n) {
				int value = sc.nextInt();
				if (stack.isEmpty()) {
				    if(value!=0)
					    stack.push(value);
				}else{
					if (value==stack.peek()) {
						int top = stack.pop();
						stack.push(top*2);
					}else{
						stack.push(value);
					}
				}
				i++;
			}
			int stackSize = printStack();
			for (int j = 0; j < n-stackSize; j++) {
				System.out.print(0+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}