package com.Concurrency.Practice;

public class ThreadJoin implements Runnable{
	public void run(){
		
		for(int i= 0 ;i<10;i++){
			
			System.out.println(Thread.currentThread().getName()+"i >>>>> "+i);
		}
	}
}
class TestThreadJoin {
	public static void main(String[] args) {
		ThreadJoin tj = new ThreadJoin();
		ThreadJoin tj1 = new ThreadJoin();
		
		Thread t1 = new Thread(tj);
		Thread t2 = new Thread(tj);
		Thread t3 = new Thread(tj1);
		
		t1.setName("First Thread >> ");
		t1.start();
		try {
			t1.join();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		t2.setName("<<<< Second Thread >> ");
		t2.start();
		try {
			t2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		t3.setName("Third Thread >> ");
		t3.start();
	}
}
