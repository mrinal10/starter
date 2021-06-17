/**
 * @(#)promnight.java
 *
 *
 * @author 
 * @version 1.00 2015/1/23
 */
import java.io.*;
import java.util.*;

public class promnight 
{
	public static int[] bubble(int a[],int n)
	{
		int i,j,temp;
		for(i=0;i<n;i++)
		{
			for(j=0;j<n-i-1;j++)
			{
				if(a[j]>a[j+1])
				{
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		return a;
	}
    public static void main (String[] args) 
    {
    	int i=0,t,n,m,gcount=0;
    	Scanner sc=new Scanner(System.in);
    	t=sc.nextInt();
    	while(t>0)
    	{
    		t--;
	    	n=sc.nextInt();
	    	m=sc.nextInt();
	    	int a[]=new int[n];
	    	int b[]=new int[m];
	    
	    	
	    		a[i]=sc.nextInt();
	    	
	    	
	    	for(i=0;i<m;i++)
	    	{
	    		b[i]=sc.nextInt();
	    	}
	    	b=bubble(b,m);
	    	for(i=0;i<n;i++)
	    	{
	    		System.out.print (a[i]+" ");
	    	}
	    	for(i=0;i<m;i++)
	    	{
	    		System.out.print (b[i]+" ");
	    	}
	    	for(i=0;i<n && gcount<m;i++)
	    	{
	    		while(a[i]>b[gcount] && gcount<m)    		
	    			gcount++;
	    		//System.out.println ("a = "+a[i]);
	    		//System.out.println ("girls count = "+gcount);
	    	}
	    	if(gcount>=m)
	    		System.out.println ("NO");
	    	else
	    		System.out.println ("YES");
    	}
    	  
	}
}