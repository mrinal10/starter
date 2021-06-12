package com.concurrency.java;


class testClass {
	public static void getObjectType(Object model) {
		System.out.println(model instanceof String);
	}
}

public class ObjectClass {
	public static void main(String[] args) {
		testClass.getObjectType("model");
	}
}
