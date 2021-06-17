package com.Concurrency.Practice;

class Reader extends Thread{
	Calculator c;
	
	public Reader(Calculator calc){
		c = calc;
	}
	
	public void run() {
		synchronized (c) {
			try {
				System.out.println("Waiting for Calcultion ....");
				c.wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("Calculation completed ....");
	}
	
	public static void main(String[] args) {
		Calculator calcc = new Calculator();
		new Reader(calcc).start();
		new Reader(calcc).start();
		new Reader(calcc).start();

		new Thread(calcc).start();
	}
}



class Calculator implements Runnable{
	int total;

	@Override
	public void run() {
		synchronized (this) {
			for(int i=0;i<100;i++){
				total+=i;
			}
			notifyAll();
			System.out.println("all are notified.");
		}
	}
}