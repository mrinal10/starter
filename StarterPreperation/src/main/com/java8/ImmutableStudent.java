package com.java8;

public class ImmutableStudent {
	private final int id;
	private final String name;
	private final Age age;
	
	
	public ImmutableStudent(int id, String name, Age age1) {
		super();
		this.id = id;
		this.name = name;
		
		Age cloneAge = new Age();
		cloneAge.setDay(age1.getDay());
		cloneAge.setMonth(age1.getMonth());
		cloneAge.setYear(age1.getYear());		
		
		this.age = cloneAge;
	}

	public Age getAge() {
		Age cloneAge = new Age();
		cloneAge.setDay(this.age.getDay());
		cloneAge.setMonth(this.age.getMonth());
		cloneAge.setYear(this.age.getYear());
		
		return cloneAge;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
