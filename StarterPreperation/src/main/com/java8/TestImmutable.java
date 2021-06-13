package com.java8;

public class TestImmutable {
	public static void main(String[] args) {
		Age age = new Age();
		age.setDay(1);
		age.setMonth(10);
		age.setYear(1993);
		ImmutableStudent immutableStudent = new ImmutableStudent(1, "Alex", age);
		
		System.out.println(immutableStudent.getAge().getYear());
		age.setYear(1992);
		System.out.println(immutableStudent.getAge().getYear());
		
	}
}
