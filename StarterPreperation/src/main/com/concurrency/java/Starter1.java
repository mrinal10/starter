package com.concurrency.java;

class ThreadTest extends Thread{
	ThreadTest(String name){
		super(name);
	}
	
	public void run() {
        System.out.println("MyThread - START "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            //Get database connection, delete unused data from DB
            doDBProcessing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread - END "+Thread.currentThread().getName());
    }

    private void doDBProcessing() throws InterruptedException {
        Thread.sleep(5000);
    }
}


class ThredTestt implements Runnable{

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}

public class Starter1 {
	public static void main(String[] args) {
			
		Thread t1 = new ThreadTest("t1");
	    Thread t2 = new ThreadTest("t2");
	    
	    t1.start();
	    t2.start();
	    
	    
	    Thread t3 = new Thread(new ThredTestt(), "name1");
	    t3.start();

	}
}
