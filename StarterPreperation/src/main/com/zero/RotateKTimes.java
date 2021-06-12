package com.zero;

public class RotateKTimes {
	private static String roateKTimes(String s, int k){
		s = s.substring(s.length()-k)+s.substring(0,s.length()-k);
		return s;
	}
	public static void main(String[] args) {
		StringBuilder s = new StringBuilder("beingZero");
		int k = 2;
		System.out.println();
	}
}
