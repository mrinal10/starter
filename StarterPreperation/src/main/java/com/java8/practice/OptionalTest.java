package com.java8.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(500);
		Optional<Integer> value = Optional.of(list.get(5));
		
		System.out.println(value.isPresent());
	}
}
