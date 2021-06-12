package com.hiring.increff;

import java.util.Scanner;
import java.util.Stack;

public class Problem3 {
	static int res = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		Stack<Integer> topDown = new Stack<>();
		Stack<Integer> bottomUp = new Stack<>();
		int topDownM = 1;
		int bottomUpM = 1;
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
			topDown.add(arr[i]);
		}
		
		for(int i=n-1; i>=0; i--){
			bottomUp.add(arr[i]);
		}
		
		mul(topDown, topDownM, m);
		mul(bottomUp, bottomUpM, m);
		sc.close();
		
		System.out.println(res);
	}
	
	private static void mul(Stack<Integer> stack, int value, int m){
		if (stack.isEmpty()) {
			return;
		}
		if (stack.size()<=m) {
			if (res<value) {
				res=value;
				res = res%1000000007;
			}
			return;
		}
		int t = 0;
		for (int i = 0; i < m; i++) {
			t += stack.pop();
		}
		t = (int) Math.floor(t/m);
		stack.push(t);
		value *= t;
		mul(stack, value, m);
	}
}
