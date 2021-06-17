package com.Concurrency.Practice;

public class MultiThreading extends Thread {//implements Runnable{
	private Account acct = new Account(30);
	
	private synchronized void makewithdrawl(int amt){
		if (acct.getBalance() >= amt) {
			System.out.println(Thread.currentThread().getName()+" is going to withdraw.");
			try {
				Thread.sleep(1000);
				acct.withdraw(amt);
				System.out.println(Thread.currentThread().getName()+" completes withdrawl.");
			} catch (Exception e) {
				
				
			}
		} else {
			System.out.println("Not enough in account for "+
								Thread.currentThread().getName()
								+" to withdraw "+acct.getBalance());
		}
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			makewithdrawl(10);
			System.out.println("current Balance :: "+acct.getBalance());
			if (acct.getBalance()<10) {
				System.out.println(" Account is overdrawn! ");
			}
		}
		
	}
	
	public static void main(String[] args) {
		MultiThreading mthr = new MultiThreading();
		Thread one = new Thread(mthr);
		Thread two = new Thread(mthr);
		one.setName("Fred");
		two.setName("Lucy");
		
		one.start();
		two.start();
	}

}


class Account{
	private int balance;
	public Account(int bala) {
		balance = bala;
	}
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}	
	
	public void withdraw(int amt){
		balance = balance-amt;
		System.out.println("balance inside withdrawl :: "+balance);
	}
}
