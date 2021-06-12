package com.zero;

public class Divby2 {

	public static void main(String[] args) {
		Double d = Math.log(32)/Math.log(2);
		if (Math.floor(d)==Math.ceil(d)) {
			System.out.println("true");
		}
		System.out.println("false");
	}

}
