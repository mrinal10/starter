package com.test.java8;

import javax.management.monitor.Monitor;

public class Hashcode {
	public static void main(String[] args) {
		Object e = new NullPointerException("nullPointer");
		if(e instanceof Exception) {
			System.out.println("Exception");
		}
		
		Monitor monitor = new Monitor() {
			
			@Override
			public void stop() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void start() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
