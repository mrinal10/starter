package com.practice.reflections;

import java.lang.reflect.Method;

public class Starter {
	public static void main(String[] args) {
		String s = "";
		Method[] methods = s.getClass().getMethods();
		for(Method method:methods){
			System.out.println(method.getName());
		}
		
	}
}
