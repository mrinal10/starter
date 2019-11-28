package com.jva.lambda;

public class Test {
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("test ::");				
			}
		};
		
		
		
		//Since there is only one abstract function in the functional interfaces, there is no confusion
		//in applying the lambda expression to the method. Lambda Expressions syntax is (argument) -> (body).
		
		Runnable r1 = () -> 
			{
				System.out.println("Just Check for Multilines");
				System.out.println("test functional");
			};
	}
}
