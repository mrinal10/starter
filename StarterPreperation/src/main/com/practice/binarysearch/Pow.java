package com.practice.binarysearch;

public class Pow {
	public static void main(String[] args) {
		System.out.println(pow(5,2));
	}
	
	public static int pow(int x, int y) {
		if(y==0) {
			return 1;
		}
		if(y%2==0) {
			return pow(x,y/2)*pow(x,y/2);
		} else {
			return x*pow(x,y/2)*pow(x,y/2);
		}
	}
}
