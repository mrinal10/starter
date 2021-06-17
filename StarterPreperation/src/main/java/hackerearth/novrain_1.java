/* IMPORTANT: class must not be public. */

import java.io.*;
import java.util.*;

class TestClass_novrain 
{
    public static void main(String args[] ) throws Exception
    {
        int t;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String l=br.readLine();
        //Scanner sc=new Scanner(System.in);
        t=Integer.parseInt(l);
        
        for(int i=0;i<t;i++)
        {
        	int n,a,b,c;
        	l=br.readLine();
        	n=Integer.parseInt(l);
        	
        	l=br.readLine();
        	a=Integer.parseInt(l);
        	
        	l=br.readLine();
        	b=Integer.parseInt(l);
        	
        	l=br.readLine();
        	c=Integer.parseInt(l);
        	
        	int maxx=0,max=0;
        	int p[]=new int[n];
        	int q[]=new int[n];
        	for(int j=0;j<n;j++)
        	{
        		l=br.readLine();
        		p[j]=Integer.parseInt(l);
        		l=br.readLine();
        		q[j]=Integer.parseInt(l);
        		if(max<q[j])
        		{
        			max=q[j];
        		}
        	}
        	
        	for(int j=1;j<=max+1;j++)
        	{
        		int temp=0;
        		for(int k=0;k<n;k++)
        		{
        			if(j<p[k])
        				temp=temp+a;
        			else if(j>q[k])
        				temp=temp+c;
        			else
        				temp=temp+b;
        		}	
        		if(temp>maxx)
        			maxx=temp;
        	}
        	System.out.println (maxx)        	;
        }
    }
}
