package com.java8.practice;

import java.util.function.BiFunction;

interface Customizeable{
	void customize();
}

public class MethodRef {
	
	public static void aStaticMethod() {
		System.out.println("Inside a static method");
	}
	
	public static void main(String[] args) {
		Customizeable customizeable = MethodRef::aStaticMethod;
//		BiFunction<> biFunction = MethodRef::aStaticMethod;
		customizeable.customize();
	}
	
	
}
