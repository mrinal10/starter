package com.java.basics;

class Parent{
	public int addValues(int a) {
		return a+2;
	}
}

class Child extends Parent{
	@Override
	public int addValues(int a) throws ArithmeticException{
		return a;		
	}
	
	public int addValues(int a, String b) {
		return a;		
	}
	
	public int addValues(String b, int a) {
		return a;		
	}
}

public class PolymorphimCheck {
	
}
