import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution_prjectEuler7
{
	public static int chkprime(int n)
	{		
		double er=Math.sqrt(n);
		int v=(int) er;
	    for(int k=2;k<=v;k++)
	    {
	    		if ((n%k)==0)
	            	return 0;
	    }
    	return 1;
	}	
    public static void main (String[] args) 
    {
    	Scanner sc=new Scanner(System.in);
    	int t=sc.nextInt();
    	for (int j=0;j<t;j++)
    	{
    		int num = sc.nextInt();
    		int i=0;
    		int range=2;
		    int prime=0;
    		while(i<num)
    		{    
    			//System.out.println (i)			;
		        if (chkprime(range)==1)
		        {       
		        	i=i+1;
		            prime=range;        		
		        }
		        range+=1;
    		}
		    System.out.println (prime);
    		
    	}
    		
	}
}