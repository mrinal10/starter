package com.java8;

//3 5 8 6 2 4 1
//8 6 4 1

public class TestClass {
	public static void main(String[] args) {
		/*int[] ar = {3, 5, 8, 6, 2, 4, 1};
		int maxSOFar = ar[ar.length-1];
		System.out.println(maxSOFar);
		if(ar.length==1) {
			return;
		}
		for(int i=ar.length-2; i>=0; i--) {
			if(ar[i]>maxSOFar) {
				System.out.println(ar[i]);
				maxSOFar = ar[i];
			}
		}*/
		System.out.println(lcm(16, 12, 2));
	}	
	
	
	private static int lcm(int a, int b, int divisor) {
		if(a==0 || b==0) {
			return 0;
		}
		if(a==1 && b==1) {
			return 1;
		}
		if(a%divisor==0 || b%divisor==0) {
			if(a%divisor == 0) {
				a = a/divisor;
			}
			if(b%divisor == 0) {
				b = b/divisor;
			}
			return divisor*lcm(a, b, divisor);
		}else {
			return lcm(a, b, divisor+1);
		}		
	}
}
