/**
 * @(#)frustrated.java
 *
 *
 * @author 
 * @version 1.00 2015/2/5
 */
import java.util.*;

class frustrated {
	static int getInt(String val)
	{
		
		int retval=Integer.parseInt(val);			
		return retval;
	}
	static int getprime(int n)
	{
		
		int t = (int) Math.round(Math.sqrt(n)+1);
		if(n==2)
		{
			System.out.println ("the sqrt val : "+t);
		}
		for(int i=2;i<=t;i++)
		{
			if(n%i==0)
			{
				return 0;
			}
		}
		return 1;
	}
    public static void main (String[] args) 
    {
    	@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
    	int t;
    	t=sc.nextInt();
    	
    	while(t>0)
    	{
    		t--;
    		int k;
    		String x,y,temp="";
    		k=sc.nextInt();
    		x=sc.next();
    		y=sc.next();
    		int i=1;
    		while(k<Math.pow(10,i))    		
    		{    			
    			i++;
    		}
    		int max=0;
    		
    		for(int i1=i;i1>=1;i1--)
    		{    				    		
	    		for(int j=0;j<x.length()-i;j++)
	    		{
	    			temp=x.substring(j,j+i);
	    			int xint=getInt(temp);
	    			if(getprime(xint)==1)
		    		{
		    			for(int k1=0;k1<y.length()-i;k1++)
		    			{
		    				String temp1=y.substring(k1,k1+i);
		    				int yint=getInt(temp1);
		    				if(xint<=k && xint==yint)
		    				{		   
		    					System.out.println ("xint : "+xint);			    				
		    					if(max<xint)
		    					{
		    						max=xint;
		    					}
		    				}
	    				}
	    			}
	    		}
    		}
    		
    		System.out.println (max);    		
    	}
	}    
}