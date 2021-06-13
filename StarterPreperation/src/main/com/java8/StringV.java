package com.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class StringV {
	public static void main(String[] args) {
		Collection<Integer> integers = Arrays.asList(1,2,3);
		
//		List<String> collected = integers.stream()
//									.filter(i -> i!=2)
//									.map(Object::toString)
//									.collect(toList());
		
		integers.removeIf(i -> i ==2);
		
		for(Iterator<Integer> iterator = integers.iterator(); iterator.hasNext();) {
			Integer integer = iterator.next();
			
			if(integer == 2) {
				iterator.remove();
			}
		}
		
	}
}
	