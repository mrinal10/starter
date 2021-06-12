/**
 * @(#)solution_hack.java
 *
 *
 * @author 
 * @version 1.00 2014/11/20
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class alternating_characters{
	private String str;
	alternating_characters(String s){
		str=s;
	}
	
	public int get_delete_no()
	{
		int val=0,leng;
		char c1,c2;
		leng=this.str.length();
		for(int j=0;j<leng-1;j++)
		{
			c1=this.str.charAt(j);
			c2=this.str.charAt(j+1);
			if(c1==c2)
			{
				val++;
			}
		}
		return val;
	}
}


public class solution_hack {

    public static void main (String[] args) {
    	
    	Scanner sc=new Scanner(System.in);
    	int testcase;
    	testcase=sc.nextInt();
    	for(int i=0;i<testcase;i++)
    	{
    		String s=new String();
    		s=sc.next();
    		alternating_characters as=new alternating_characters(s);
    		int v=as.get_delete_no();
    		System.out.println (v);
    		//System.out.println (s+" ");
    	}
    	
	}	
    
    
}