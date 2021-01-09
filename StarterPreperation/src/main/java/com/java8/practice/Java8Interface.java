package com.java8.practice;

public interface Java8Interface {
	default void testDefault() {
		System.out.println("Inside root Default");
	}
	void testNormalMethod();
	static void newStaticMethod() {
		System.out.println("This is a static method");
	}
}
