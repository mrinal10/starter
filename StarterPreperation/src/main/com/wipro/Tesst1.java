package com.wipro;


class Men { public int number; }

public class Tesst1{
	public static void main(String [] args) 
	{
		Tesst1 p = new Tesst1();
	    p.start();
	}

	void start() 
	{
	    boolean b1 = false;
	    boolean b2 = fix(b1);
	    System.out.println(b1 + " " + b2);
	}

	boolean fix(boolean b1) 
	{
	    b1 = true;
	    return b1;
	}
}
