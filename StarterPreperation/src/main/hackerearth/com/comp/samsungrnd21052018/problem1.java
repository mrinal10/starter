package com.comp.samsungrnd21052018;

class test{
	public static void main(String[] args) {
		int a = 5;
		System.out.println(isdiv(a));
	}
	
	private static boolean isdiv(int a) {
		double d = Math.log(a)/Math.log(4) ;
		if (d == Math.round(a)) {
			return true;
		}
		return false;
	}
}