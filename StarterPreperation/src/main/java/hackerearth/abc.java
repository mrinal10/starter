/**
 * @(#)abc.java
 *
 *
 * @author 
 * @version 1.00 2014/11/19
 */
import java.io.*;
import java.util.*;

public class abc {

	private int j,r,c;
    public abc(int a,int b) {
    	j=a;r=b;
    }
    public int addd()
    {
    	c=j+r;
    	return c;
    }
    
}

class test{
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		abc ad=new abc(a,b);
		System.out.println (ad.addd());
	}
}