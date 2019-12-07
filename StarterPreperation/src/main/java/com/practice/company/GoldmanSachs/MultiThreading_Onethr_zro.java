package com.practice.company.GoldmanSachs;

class MyThread implements Runnable {
	String name;
	Thread t;

	MyThread(String threadname) {
		name = threadname;
		t = new Thread(this, name);
		System.out.println("New thread: " + t);
		t.start();
	}
  
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}

public class MultiThreading_Onethr_zro {
	public static void main(String[] args) {

	}
}
