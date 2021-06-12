package com.zero;

public class PrintPatternDiff5 {
	void printPatternDiff5(int n) 
	{ 
	    helper(n, n, false, false);
	}
	  
	void helper(int lim, int n, boolean increasing, boolean stop){
	    System.out.print(n+" ");
	    if(n<=0){
	      increasing = true;
	      stop = true;
	    }
	  	if(increasing && n==lim){
	      return;
	    }
	    if(!increasing){
	      helper(lim, n-5, increasing, stop);
	    }else{
	      helper(lim, n+5, increasing, stop);
	    }
	}
	
	public static void main(String[] args) {
		PrintPatternDiff5 printPatternDiff = new PrintPatternDiff5();
		printPatternDiff.printPatternDiff5(16);
	}
}
