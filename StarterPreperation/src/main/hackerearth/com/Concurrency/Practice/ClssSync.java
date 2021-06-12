package com.Concurrency.Practice;

abstract class Mrinal{
	public int addnUM(int a, int b){
		return a+b;
	}
	
	public abstract int addNum(int a, int b, int c);
}

public class ClssSync extends Mrinal{
	int s = 11;
	@Override
	public int addNum(int a, int b, int c) {
		
		return a+b+c;
	}

	
	public synchronized int getNum(){
		s += 1;
		return s; 
	}
	
}


class Test{
	public static void main(String[] args) {
		ClssSync sync = new ClssSync();
		System.out.println(sync.addNum(6, 7, 8));
	}
}