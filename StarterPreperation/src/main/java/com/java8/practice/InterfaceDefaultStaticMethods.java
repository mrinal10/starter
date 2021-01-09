package com.java8.practice;

public class InterfaceDefaultStaticMethods implements Java8Interface {
	
	@Override
	public void testDefault() {
		// TODO Auto-generated method stub
		Java8Interface.super.testDefault();
		System.out.println("inside Default overridden");
	}
	
	@Override
	public void testNormalMethod() {
		System.out.println("Thisd is normal method");		
	}
	
	public static void main(String[] args) {
		InterfaceDefaultStaticMethods interfaceDefaultStaticMethods = new InterfaceDefaultStaticMethods();
		interfaceDefaultStaticMethods.testDefault();
		interfaceDefaultStaticMethods.testNormalMethod();
	}
}
