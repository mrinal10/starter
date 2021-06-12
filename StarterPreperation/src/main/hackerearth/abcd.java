/**
 * @(#)abcd.java
 *
 *
 * @author 
 * @version 1.00 2014/9/10
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class abcd 
{
	static int ipow(int base, int exp)
	{
	    int result = 1;
	    while (exp != 0)
	    {
	        if ((exp & 1)!= 0)
	            result *= base;
	        exp >>= 1;
	        base *= base;
	    }	
	    return result;
	}

    public static void main (String[] args) 
    {
    	int sum,i,j,k,testcase;
    	Scanner sc=new Scanner(System.in);
		testcase=sc.nextInt();
		
		int n, count=0;
		int[] a;
		a=new int[testcase];
		for(i=0;i<testcase;i++)
		{
			count=0;
			sum=0;
			n=sc.nextInt();
			while(ipow(2,count)<=n)
			{
				count++;	
				//System.out.println ("count = "+count);
			}
			
			
			for(j=0;j<count;j++)
			{
				for(k=0;k<=n;k++)
				{
					sum=sum+ ipow(2,(ipow(2,j)+(2*k)));
					sum=sum%10;
					//System.out.println ("\n sum= "+sum);
				}
			}
			a[i]=sum;
		}
	
		for(i=0;i<testcase;i++)
		{
			System.out.println (a[i]);
		}	
	}    
}