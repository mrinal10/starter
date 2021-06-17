package com.Concurrency.Practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FactorialCalculator implements Callable<Long> 
{ 
	private int number; 
	public FactorialCalculator(int number){ 
		this.number = number; 
	} 
	
	@Override 
	public Long call() throws Exception { 
		return factorial(number); 
	} 
	
	private long factorial(int n) throws InterruptedException { 
		long result = 1; 
		while (n != 0) { 
			result = n * result; 
			n = n - 1; 
			Thread.sleep(100); 
		} 
		return result; 
	} 
} 


class HelloWorldApp { 
	public static void main(String... args) throws InterruptedException, ExecutionException { 
		ExecutorService es = Executors.newFixedThreadPool(3);
				
				//Executors.newSingleThreadExecutor(); 
		Future<Long> result10 = es.submit(new FactorialCalculator(10)); 
		Future<Long> result15 = es.submit(new FactorialCalculator(5)); 
		Future<Long> result20 = es.submit(new FactorialCalculator(20)); 

		long factorialof10 = (long) result10.get();
		System.out.println("factorialof10 >> "+factorialof10);
		long factorialof15 = (long) result15.get();
		System.out.println("factorialof15 >> "+factorialof15);
		long factorialof20 = (long) result20.get(); 
		System.out.println("factorialof20 >> "+factorialof20);
	} 
} 